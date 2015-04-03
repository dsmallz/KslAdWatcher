/*   1:    */ package com.dsmallwood.kslclassifieds.server;
/*   2:    */ 
/*   3:    */ import com.dsmallwood.kslclassifieds.PMF;
/*   4:    */ import com.google.appengine.api.users.User;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.UnsupportedEncodingException;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Properties;
/*  10:    */ import java.util.logging.Logger;
/*  11:    */ import javax.jdo.PersistenceManager;
/*  12:    */ import javax.jdo.PersistenceManagerFactory;
/*  13:    */ import javax.jdo.Query;
/*  14:    */ import javax.mail.Message;
/*  15:    */ import javax.mail.Message.RecipientType;
/*  16:    */ import javax.mail.MessagingException;
/*  17:    */ import javax.mail.Session;
/*  18:    */ import javax.mail.Transport;
/*  19:    */ import javax.mail.internet.AddressException;
/*  20:    */ import javax.mail.internet.InternetAddress;
/*  21:    */ import javax.mail.internet.MimeMessage;
/*  22:    */ import javax.servlet.ServletException;
/*  23:    */ import javax.servlet.http.HttpServlet;
/*  24:    */ import javax.servlet.http.HttpServletRequest;
/*  25:    */ import javax.servlet.http.HttpServletResponse;
/*  26:    */ import org.htmlparser.Node;
/*  27:    */ import org.htmlparser.NodeFilter;
/*  28:    */ import org.htmlparser.Parser;
/*  29:    */ import org.htmlparser.Tag;
/*  30:    */ import org.htmlparser.Text;
/*  31:    */ import org.htmlparser.filters.AndFilter;
/*  32:    */ import org.htmlparser.filters.HasAttributeFilter;
/*  33:    */ import org.htmlparser.filters.HasChildFilter;
/*  34:    */ import org.htmlparser.filters.NodeClassFilter;
/*  35:    */ import org.htmlparser.filters.TagNameFilter;
/*  36:    */ import org.htmlparser.tags.LinkTag;
/*  37:    */ import org.htmlparser.util.NodeList;
/*  38:    */ import org.htmlparser.util.ParserException;
/*  39:    */ import org.htmlparser.visitors.NodeVisitor;
/*  40:    */ 
/*  41:    */ public class NotificationServiceImpl
/*  42:    */   extends HttpServlet
/*  43:    */ {
/*  44: 49 */   private static final Logger _logger = Logger.getLogger(NotificationServiceImpl.class.getName());
/*  45:    */   public ArrayList<Listing> adListings;
/*  46:    */   
/*  47:    */   public void doGet(HttpServletRequest req, HttpServletResponse resp)
/*  48:    */     throws IOException
/*  49:    */   {
/*  50: 55 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/*  51:    */     try
/*  52:    */     {
/*  53: 58 */       Query q = pm.newQuery(NotificationCount.class);
/*  54: 59 */       List<NotificationCount> notifyCount = (List)q.execute();
/*  55: 60 */       if (notifyCount.size() == 0)
/*  56:    */       {
/*  57: 61 */         NotificationCount count = new NotificationCount();
/*  58: 62 */         pm.makePersistent(count);
/*  59: 63 */         notifyAdWatcherUsers(runNotificationSchedules(count
/*  60: 64 */           .getNotificationCount()));
/*  61:    */       }
/*  62:    */       else
/*  63:    */       {
/*  64: 68 */         NotificationCount count = (NotificationCount)notifyCount.get(0);
/*  65: 69 */         notifyAdWatcherUsers(runNotificationSchedules(count
/*  66: 70 */           .getNotificationCount()));
/*  67: 71 */         count.setNotificationCount(count.getNotificationCount() + 1);
/*  68:    */       }
/*  69:    */     }
/*  70:    */     catch (Exception ex)
/*  71:    */     {
/*  72: 74 */       _logger.severe("Unable to complete cron job successfully: " + ex.getMessage());
/*  73:    */     }
/*  74:    */     finally
/*  75:    */     {
/*  76: 76 */       pm.close();
/*  77:    */     }
/*  78:    */   }
/*  79:    */   
/*  80:    */   private void notifyAdWatcherUsers(String scheduleString)
/*  81:    */   {
/*  82: 82 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/*  83:    */     try
/*  84:    */     {
/*  85: 84 */       String userQuery = "select from " + User.class;
/*  86: 85 */       List<AdWatcherUser> users = (List)pm.newQuery(
/*  87: 86 */         AdWatcherUser.class).execute();
/*  88: 87 */       for (AdWatcherUser user : users)
/*  89:    */       {
/*  90: 88 */         boolean containsListings = false;
/*  91: 89 */         Query q = pm.newQuery(AdWatcher.class);
/*  92: 90 */         q.setFilter("user == u && (" + scheduleString + ")");
/*  93: 91 */         q.declareParameters("com.google.appengine.api.users.User u");
/*  94: 92 */         q.setOrdering("createDate");
/*  95:    */         
/*  96: 94 */         List<AdWatcher> notifyAds = (List)q.execute(user.getUser());
/*  97: 95 */         ArrayList<AdWatcherListings> adWatcherListings = new ArrayList();
/*  98: 96 */         for (AdWatcher adWatcher : notifyAds)
/*  99:    */         {
/* 100: 97 */           ArrayList<Listing> emailListings = new ArrayList();
/* 101:    */           try
/* 102:    */           {
/* 103: 99 */             if ((adWatcher.isNotifyEmail()) || (adWatcher.isNotifySMS()))
/* 104:    */             {
/* 105:101 */               parseHTML(adWatcher.getUrl());
/* 106:102 */               for (Listing listing : this.adListings)
/* 107:    */               {
/* 108:104 */                 int adTimeInMins = listing.getTimeValue();
/* 109:105 */                 if (!listing.getTimeUnit().equalsIgnoreCase("min")) {
/* 110:107 */                   adTimeInMins *= 60;
/* 111:    */                 }
/* 112:109 */                 if (adTimeInMins > adWatcher.getNotificationTime()) {
/* 113:    */                   break;
/* 114:    */                 }
/* 115:110 */                 containsListings = true;
/* 116:111 */                 emailListings.add(listing);
/* 117:    */               }
/* 118:    */             }
/* 119:    */           }
/* 120:    */           catch (ParserException e)
/* 121:    */           {
/* 122:121 */             _logger.severe("Unable to parse html: " + e.getMessage());
/* 123:    */           }
/* 124:123 */           adWatcherListings.add(new AdWatcherListings(adWatcher, 
/* 125:124 */             emailListings));
/* 126:    */         }
/* 127:126 */         if (containsListings) {
/* 128:127 */           sendUserEmailListings(adWatcherListings, user.getEmail(), 
/* 129:128 */             user.getUsername());
/* 130:    */         }
/* 131:    */       }
/* 132:    */     }
/* 133:    */     catch (Exception localException) {}finally
/* 134:    */     {
/* 135:134 */       pm.close();
/* 136:    */     }
/* 137:    */   }
/* 138:    */   
/* 139:    */   private String runNotificationSchedules(int count)
/* 140:    */   {
/* 141:139 */     ArrayList<String> queryString = new ArrayList();
/* 142:140 */     if (count % 1 == 0) {
/* 143:141 */       queryString.add("notificationTime == 1");
/* 144:    */     }
/* 145:143 */     if (count % 10 == 0) {
/* 146:144 */       queryString.add("notificationTime == 10");
/* 147:    */     }
/* 148:146 */     if (count % 30 == 0) {
/* 149:147 */       queryString.add("notificationTime == 30");
/* 150:    */     }
/* 151:149 */     if (count % 60 == 0) {
/* 152:150 */       queryString.add("notificationTime == 60");
/* 153:    */     }
/* 154:152 */     if (count % 120 == 0) {
/* 155:153 */       queryString.add("notificationTime == 120");
/* 156:    */     }
/* 157:155 */     if (count % 240 == 0) {
/* 158:156 */       queryString.add("notificationTime == 240");
/* 159:    */     }
/* 160:158 */     if (count % 480 == 0) {
/* 161:159 */       queryString.add("notificationTime == 480");
/* 162:    */     }
/* 163:161 */     if (count % 1440 == 0) {
/* 164:162 */       queryString.add("notificationTime == 1440");
/* 165:    */     }
/* 166:164 */     String formattedString = "";
/* 167:165 */     if (queryString.size() > 0) {
/* 168:166 */       formattedString = (String)queryString.get(0);
/* 169:    */     }
/* 170:169 */     for (int i = 1; i < queryString.size(); i++) {
/* 171:170 */       formattedString = formattedString + " || " + (String)queryString.get(i);
/* 172:    */     }
/* 173:172 */     return formattedString;
/* 174:    */   }
/* 175:    */   
/* 176:    */   private void sendUserEmailListings(ArrayList<AdWatcherListings> emailListings, String email, String nickname)
/* 177:    */   {
/* 178:179 */     Properties props = new Properties();
/* 179:180 */     Session session = Session.getDefaultInstance(props, null);
/* 180:    */     
/* 181:182 */     String msgBody = createEmailMsgBody(emailListings);
/* 182:    */     try
/* 183:    */     {
/* 184:185 */       Message msg = new MimeMessage(session);
/* 185:186 */       msg.setFrom(new InternetAddress(
/* 186:187 */         "kslclassifieds.adwatcher@gmail.com", "AdWatcher Admin"));
/* 187:188 */       msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
/* 188:189 */         email, nickname));
/* 189:190 */       msg.setSubject("AdWatcher Listings Update");
/* 190:191 */       msg.setText(msgBody);
/* 191:192 */       Transport.send(msg);
/* 192:    */     }
/* 193:    */     catch (AddressException localAddressException) {}catch (MessagingException localMessagingException) {}catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
/* 194:    */   }
/* 195:    */   
/* 196:    */   private String createEmailMsgBody(ArrayList<AdWatcherListings> emailListings)
/* 197:    */   {
/* 198:204 */     String msgBody = "";
/* 199:205 */     for (AdWatcherListings adWatcherListing : emailListings)
/* 200:    */     {
/* 201:206 */       AdWatcher adWatcher = adWatcherListing.getAdWatcher();
/* 202:207 */       msgBody = msgBody + "Adwatcher Keywords: " + adWatcher.getKeywords() + 
/* 203:208 */         "\r\n" + adWatcher.getUrl() + "\r\n\r\n";
/* 204:209 */       ArrayList<Listing> listings = adWatcherListing.getListings();
/* 205:210 */       for (Listing listing : listings)
/* 206:    */       {
/* 207:211 */         msgBody = msgBody + listing.getAdTitle() + "\r\n";
/* 208:212 */         msgBody = msgBody + listing.getAdDesc() + "\r\n";
/* 209:213 */         msgBody = msgBody + listing.getAdLocation() + "\r\n";
/* 210:214 */         msgBody = msgBody + listing.getAdPrice() + "\r\n";
/* 211:215 */         msgBody = msgBody + listing.getAdURLLink() + "\r\n";
/* 212:216 */         msgBody = msgBody + listing.getAdDays() + "\r\n\r\n";
/* 213:    */       }
/* 214:218 */       msgBody = msgBody + "\r\n";
/* 215:    */     }
/* 216:220 */     return msgBody;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void doPost(HttpServletRequest req, HttpServletResponse resp)
/* 220:    */     throws ServletException, IOException
/* 221:    */   {
/* 222:226 */     doGet(req, resp);
/* 223:    */   }
/* 224:    */   
/* 225:    */   private void parseHTML(String url)
/* 226:    */     throws ParserException
/* 227:    */   {
/* 228:231 */     Parser parser = new Parser(url);
/* 229:232 */     NodeVisitor visitor = new NodeVisitor()
/* 230:    */     {
/* 231:    */       public void visitTag(Tag tag)
/* 232:    */       {
/* 233:236 */         String name = tag.getTagName();
/* 234:238 */         if ((name != null) && ("div".equalsIgnoreCase(name)))
/* 235:    */         {
/* 236:239 */           String tagAttr = tag.getAttribute("style");
/* 237:241 */           if (tagAttr != null) {
/* 238:243 */             if (tagAttr.equalsIgnoreCase("width: 620px; margin-top: 4px;"))
/* 239:    */             {
/* 240:244 */               NodeFilter adBoxFilter = new TagNameFilter("DIV");
/* 241:245 */               NodeList adBoxNodes = null;
/* 242:246 */               NodeList nodeList = tag.getChildren();
/* 243:247 */               if (nodeList != null) {
/* 244:248 */                 adBoxNodes = 
/* 245:249 */                   nodeList.extractAllNodesThatMatch(adBoxFilter);
/* 246:    */               }
/* 247:251 */               if ((adBoxNodes != null) && (adBoxNodes.size() > 0)) {
/* 248:252 */                 NotificationServiceImpl.this.adListings = parseAdBoxTags(adBoxNodes);
/* 249:    */               }
/* 250:    */             }
/* 251:    */           }
/* 252:    */         }
/* 253:    */       }
/* 254:    */       
/* 255:    */       private ArrayList<Listing> parseAdBoxTags(NodeList adBoxes)
/* 256:    */       {
/* 257:260 */         ArrayList<Listing> adListings = new ArrayList();
/* 258:261 */         final Listing tempListing = new Listing();
/* 259:262 */         for (int i = 0; i < adBoxes.size(); i++)
/* 260:    */         {
/* 261:263 */           resetListing(tempListing);
/* 262:264 */           Node adBox = adBoxes.elementAt(i);
/* 263:265 */           NodeList nodeList = adBox.getChildren();
/* 264:266 */           NodeFilter adBoxFilter = new AndFilter(new TagNameFilter(
/* 265:267 */             "DIV"), new HasAttributeFilter("class"));
/* 266:    */           
/* 267:    */ 
/* 268:270 */           NodeList adBoxSubNodes = nodeList
/* 269:271 */             .extractAllNodesThatMatch(adBoxFilter);
/* 270:272 */           NodeVisitor subVisitor = new NodeVisitor(true)
/* 271:    */           {
/* 272:    */             public void visitTag(Tag tag)
/* 273:    */             {
/* 274:275 */               String tagText = tag.getText();
/* 275:276 */               if (tagText.contains("adTitle")) {
/* 276:277 */                 generateAdTitle(tag.getChildren());
/* 277:278 */               } else if ((tempListing.getAdLocation() == null) && 
/* 278:279 */                 (tagText.contains("adTime"))) {
/* 279:283 */                 tempListing.setAdLocation(getTextNode(
/* 280:284 */                   tag.getChildren()).replaceAll("&nbsp;", 
/* 281:285 */                   " "));
/* 282:286 */               } else if (tagText.contains("adDesc")) {
/* 283:287 */                 tempListing.setAdDesc(getTextNode(tag
/* 284:288 */                   .getChildren()));
/* 285:289 */               } else if (tagText.contains("priceBox")) {
/* 286:290 */                 generatePriceBox(tag.getChildren());
/* 287:291 */               } else if (tagText.contains("adDays")) {
/* 288:292 */                 tempListing.setAdDays(getTextNode(tag
/* 289:293 */                   .getChildren()));
/* 290:    */               } else {
/* 291:294 */                 tagText.contains("adImage");
/* 292:    */               }
/* 293:    */             }
/* 294:    */             
/* 295:    */             private String getTextNode(NodeList children)
/* 296:    */             {
/* 297:306 */               NodeClassFilter filter = new NodeClassFilter(
/* 298:307 */                 Text.class);
/* 299:308 */               NodeList nodeList = new NodeList();
/* 300:309 */               for (int i = 0; i < children.size(); i++) {
/* 301:310 */                 children.elementAt(i).collectInto(nodeList, 
/* 302:311 */                   filter);
/* 303:    */               }
/* 304:314 */               Text[] textTags = new Text[1];
/* 305:315 */               nodeList.copyToNodeArray(textTags);
/* 306:316 */               if (textTags[0] != null) {
/* 307:317 */                 return textTags[0].getText();
/* 308:    */               }
/* 309:319 */               return null;
/* 310:    */             }
/* 311:    */             
/* 312:    */             private void generatePriceBox(NodeList children)
/* 313:    */             {
/* 314:323 */               NodeList linkTags = new NodeList();
/* 315:324 */               NodeClassFilter filter = new NodeClassFilter(
/* 316:325 */                 LinkTag.class);
/* 317:327 */               for (int i = 0; i < children.size(); i++) {
/* 318:328 */                 children.elementAt(i).collectInto(linkTags, 
/* 319:329 */                   filter);
/* 320:    */               }
/* 321:332 */               LinkTag[] linkTag = new LinkTag[1];
/* 322:333 */               linkTags.copyToNodeArray(linkTag);
/* 323:334 */               if (linkTag[0] != null)
/* 324:    */               {
/* 325:335 */                 String adPrice = linkTag[0].getLinkText();
/* 326:336 */                 tempListing.setAdPrice(adPrice.substring(0, 
/* 327:337 */                   adPrice.length() - 1));
/* 328:    */               }
/* 329:    */             }
/* 330:    */             
/* 331:    */             private void generateAdTitle(NodeList children)
/* 332:    */             {
/* 333:343 */               NodeList linkTags = new NodeList();
/* 334:344 */               NodeClassFilter filter = new NodeClassFilter(
/* 335:345 */                 LinkTag.class);
/* 336:347 */               for (int i = 0; i < children.size(); i++) {
/* 337:348 */                 children.elementAt(i).collectInto(linkTags, 
/* 338:349 */                   filter);
/* 339:    */               }
/* 340:352 */               LinkTag[] linkTag = new LinkTag[1];
/* 341:353 */               linkTags.copyToNodeArray(linkTag);
/* 342:354 */               if (linkTag[0] != null)
/* 343:    */               {
/* 344:356 */                 tempListing.setAdTitle(linkTag[0].getLinkText());
/* 345:357 */                 tempListing.setAdURLLink(linkTag[0].getLink());
/* 346:    */               }
/* 347:    */             }
/* 348:    */           };
/* 349:    */           try
/* 350:    */           {
/* 351:363 */             adBoxSubNodes.visitAllNodesWith(subVisitor);
/* 352:    */           }
/* 353:    */           catch (ParserException e)
/* 354:    */           {
/* 355:367 */             e.printStackTrace();
/* 356:    */           }
/* 357:369 */           adListings.add(new Listing(tempListing.getAdURLLink(), 
/* 358:370 */             tempListing.getAdImageSource(), tempListing
/* 359:371 */             .getAdTitle(), tempListing.getAdPrice(), 
/* 360:372 */             tempListing.getAdDays(), tempListing.getAdDesc(), 
/* 361:373 */             tempListing.getAdLocation()));
/* 362:    */         }
/* 363:376 */         return adListings;
/* 364:    */       }
/* 365:    */       
/* 366:    */       private void resetListing(Listing listing)
/* 367:    */       {
/* 368:380 */         listing.setNullValues();
/* 369:    */       }
/* 370:383 */     };
/* 371:384 */     parser.visitAllNodesWith(visitor);
/* 372:    */   }
/* 373:    */   
/* 374:    */   private ArrayList<Listing> parseListings(ArrayList<NodeList> adListings)
/* 375:    */   {
/* 376:389 */     for (NodeList ad : adListings)
/* 377:    */     {
/* 378:390 */       NodeFilter imageFilter = new AndFilter(new TagNameFilter("A"), 
/* 379:391 */         new HasChildFilter(new TagNameFilter("IMG")));
/* 380:392 */       NodeList localNodeList1 = ad.extractAllNodesThatMatch(imageFilter);
/* 381:    */     }
/* 382:395 */     return null;
/* 383:    */   }
/* 384:    */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.NotificationServiceImpl
 * JD-Core Version:    0.7.0.1
 */