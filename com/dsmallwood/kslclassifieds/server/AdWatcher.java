/*   1:    */ package com.dsmallwood.kslclassifieds.server;
/*   2:    */ 
/*   3:    */ import com.google.appengine.api.users.User;
/*   4:    */ import com.google.gwt.user.client.rpc.IsSerializable;
/*   5:    */ import java.util.Date;
/*   6:    */ import javax.jdo.JDOFatalInternalException;
/*   7:    */ import javax.jdo.PersistenceManager;
/*   8:    */ import javax.jdo.annotations.Extension;
/*   9:    */ import javax.jdo.annotations.IdGeneratorStrategy;
/*  10:    */ import javax.jdo.annotations.Persistent;
/*  11:    */ import javax.jdo.annotations.PrimaryKey;
/*  12:    */ import javax.jdo.identity.StringIdentity;
/*  13:    */ import javax.jdo.spi.JDOImplHelper;
/*  14:    */ import javax.jdo.spi.PersistenceCapable.ObjectIdFieldConsumer;
/*  15:    */ import javax.jdo.spi.PersistenceCapable.ObjectIdFieldSupplier;
/*  16:    */ import javax.jdo.spi.StateManager;
/*  17:    */ 
/*  18:    */ @javax.jdo.annotations.PersistenceCapable
/*  19:    */ public class AdWatcher
/*  20:    */   implements IsSerializable, javax.jdo.spi.PersistenceCapable
/*  21:    */ {
/*  22:    */   @PrimaryKey
/*  23:    */   @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
/*  24:    */   @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
/*  25:    */   private String key;
/*  26:    */   @Persistent
/*  27:    */   private User user;
/*  28:    */   @Persistent
/*  29:    */   private Date createDate;
/*  30:    */   @Persistent
/*  31:    */   private String keywords;
/*  32:    */   @Persistent
/*  33:    */   private String zip;
/*  34:    */   @Persistent
/*  35:    */   private String miles;
/*  36:    */   @Persistent
/*  37:    */   private String minPrice;
/*  38:    */   @Persistent
/*  39:    */   private String maxPrice;
/*  40:    */   @Persistent
/*  41:    */   private String seller;
/*  42:    */   @Persistent
/*  43:    */   private String url;
/*  44:    */   @Persistent
/*  45:    */   private int notificationTime;
/*  46:    */   @Persistent
/*  47:    */   private boolean notifyEmail;
/*  48:    */   @Persistent
/*  49:    */   private boolean notifySMS;
/*  50:    */   protected transient StateManager jdoStateManager;
/*  51:    */   protected transient byte jdoFlags;
/*  52:    */   private static final byte[] jdoFieldFlags;
/*  53:    */   private static final Class jdoPersistenceCapableSuperclass;
/*  54:    */   private static final Class[] jdoFieldTypes;
/*  55:    */   private static final String[] jdoFieldNames = ;
/*  56:    */   private static final int jdoInheritedFieldCount;
/*  57:    */   
/*  58:    */   public static Class ___jdo$loadClass(String className)
/*  59:    */   {
/*  60:    */     try
/*  61:    */     {
/*  62:  8 */       return Class.forName(className);
/*  63:    */     }
/*  64:    */     catch (ClassNotFoundException e)
/*  65:    */     {
/*  66:  8 */       throw new NoClassDefFoundError(e.getMessage());
/*  67:    */     }
/*  68:    */   }
/*  69:    */   
/*  70:    */   public AdWatcher(String keywords, String zip, String miles, String minPrice, String maxPrice, String seller, String url, int notificationTime, boolean notifyEmail, boolean notifySMS)
/*  71:    */   {
/*  72: 62 */     setKeywords(keywords);
/*  73: 63 */     setZip(zip);
/*  74: 64 */     setMiles(miles);
/*  75: 65 */     setMinPrice(minPrice);
/*  76: 66 */     setMaxPrice(maxPrice);
/*  77: 67 */     setSeller(seller);
/*  78: 68 */     setUrl(url);
/*  79: 69 */     setNotificationTime(notificationTime);
/*  80: 70 */     setNotifyEmail(notifyEmail);
/*  81: 71 */     setNotifySMS(notifySMS);
/*  82:    */   }
/*  83:    */   
/*  84:    */   public AdWatcher(String keywords, String zip, String miles, String minPrice, String maxPrice, String seller, String key, String url, int notificationTime, boolean notifyEmail, boolean notifySMS)
/*  85:    */   {
/*  86: 77 */     setKeywords(keywords);
/*  87: 78 */     setZip(zip);
/*  88: 79 */     setMiles(miles);
/*  89: 80 */     setMinPrice(minPrice);
/*  90: 81 */     setMaxPrice(maxPrice);
/*  91: 82 */     setSeller(seller);
/*  92: 83 */     setKey(key);
/*  93: 84 */     setUrl(url);
/*  94: 85 */     setNotificationTime(notificationTime);
/*  95: 86 */     setNotifyEmail(notifyEmail);
/*  96: 87 */     setNotifySMS(notifySMS);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setUser(User user)
/* 100:    */   {
/* 101: 92 */     jdoSetuser(this, user);
/* 102:    */   }
/* 103:    */   
/* 104:    */   public User getUser()
/* 105:    */   {
/* 106: 97 */     return jdoGetuser(this);
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setKeywords(String keywords)
/* 110:    */   {
/* 111:102 */     jdoSetkeywords(this, keywords);
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getKeywords()
/* 115:    */   {
/* 116:107 */     return jdoGetkeywords(this);
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setZip(String zip)
/* 120:    */   {
/* 121:112 */     jdoSetzip(this, zip);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getZip()
/* 125:    */   {
/* 126:117 */     return jdoGetzip(this);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setMiles(String miles)
/* 130:    */   {
/* 131:122 */     jdoSetmiles(this, miles);
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getMiles()
/* 135:    */   {
/* 136:127 */     return jdoGetmiles(this);
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setMinPrice(String minPrice)
/* 140:    */   {
/* 141:132 */     jdoSetminPrice(this, minPrice);
/* 142:    */   }
/* 143:    */   
/* 144:    */   public String getMinPrice()
/* 145:    */   {
/* 146:137 */     return jdoGetminPrice(this);
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setMaxPrice(String maxPrice)
/* 150:    */   {
/* 151:142 */     jdoSetmaxPrice(this, maxPrice);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getMaxPrice()
/* 155:    */   {
/* 156:147 */     return jdoGetmaxPrice(this);
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setSeller(String seller)
/* 160:    */   {
/* 161:152 */     jdoSetseller(this, seller);
/* 162:    */   }
/* 163:    */   
/* 164:    */   public String getSeller()
/* 165:    */   {
/* 166:157 */     return jdoGetseller(this);
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setUrl(String url)
/* 170:    */   {
/* 171:161 */     jdoSeturl(this, url);
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String getUrl()
/* 175:    */   {
/* 176:165 */     return jdoGeturl(this);
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setNotificationTime(int notificationTime)
/* 180:    */   {
/* 181:169 */     jdoSetnotificationTime(this, notificationTime);
/* 182:    */   }
/* 183:    */   
/* 184:    */   public int getNotificationTime()
/* 185:    */   {
/* 186:173 */     return jdoGetnotificationTime(this);
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setNotifyEmail(boolean notifyEmail)
/* 190:    */   {
/* 191:177 */     jdoSetnotifyEmail(this, notifyEmail);
/* 192:    */   }
/* 193:    */   
/* 194:    */   public boolean isNotifyEmail()
/* 195:    */   {
/* 196:181 */     return jdoGetnotifyEmail(this);
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setNotifySMS(boolean notifySMS)
/* 200:    */   {
/* 201:185 */     jdoSetnotifySMS(this, notifySMS);
/* 202:    */   }
/* 203:    */   
/* 204:    */   public boolean isNotifySMS()
/* 205:    */   {
/* 206:189 */     return jdoGetnotifySMS(this);
/* 207:    */   }
/* 208:    */   
/* 209:    */   public String getKey()
/* 210:    */   {
/* 211:193 */     return jdoGetkey(this);
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setKey(String key)
/* 215:    */   {
/* 216:197 */     jdoSetkey(this, key);
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setCreateDate(Date createDate)
/* 220:    */   {
/* 221:201 */     jdoSetcreateDate(this, createDate);
/* 222:    */   }
/* 223:    */   
/* 224:    */   public Date getCreateDate()
/* 225:    */   {
/* 226:205 */     return jdoGetcreateDate(this);
/* 227:    */   }
/* 228:    */   
/* 229:    */   static
/* 230:    */   {
/* 231:    */     jdoFieldTypes = __jdoFieldTypesInit();
/* 232:    */     jdoFieldFlags = __jdoFieldFlagsInit();
/* 233:    */     jdoInheritedFieldCount = __jdoGetInheritedFieldCount();
/* 234:    */     jdoPersistenceCapableSuperclass = __jdoPersistenceCapableSuperclassInit();
/* 235:    */     JDOImplHelper.registerClass(___jdo$loadClass("com.dsmallwood.kslclassifieds.server.AdWatcher"), jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new AdWatcher());
/* 236:    */   }
/* 237:    */   
/* 238:    */   protected AdWatcher() {}
/* 239:    */   
/* 240:    */   public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid)
/* 241:    */   {
/* 242:    */     if (fc == null) {
/* 243:    */       throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
/* 244:    */     }
/* 245:    */     if (!(oid instanceof StringIdentity)) {
/* 246:    */       throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
/* 247:    */     }
/* 248:    */     StringIdentity o = (StringIdentity)oid;
/* 249:    */     fc.storeStringField(1, o.getKey());
/* 250:    */   }
/* 251:    */   
/* 252:    */   protected void jdoCopyKeyFieldsFromObjectId(Object oid)
/* 253:    */   {
/* 254:    */     if (!(oid instanceof StringIdentity)) {
/* 255:    */       throw new ClassCastException("key class is not javax.jdo.identity.StringIdentity or null");
/* 256:    */     }
/* 257:    */     StringIdentity o = (StringIdentity)oid;
/* 258:    */     this.key = o.getKey();
/* 259:    */   }
/* 260:    */   
/* 261:    */   public final void jdoCopyKeyFieldsToObjectId(Object oid)
/* 262:    */   {
/* 263:    */     throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
/* 264:    */   }
/* 265:    */   
/* 266:    */   public final void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier fs, Object paramObject)
/* 267:    */   {
/* 268:    */     throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
/* 269:    */   }
/* 270:    */   
/* 271:    */   public final Object jdoGetObjectId()
/* 272:    */   {
/* 273:    */     if (this.jdoStateManager != null) {
/* 274:    */       return this.jdoStateManager.getObjectId(this);
/* 275:    */     }
/* 276:    */     return null;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public final Object jdoGetVersion()
/* 280:    */   {
/* 281:    */     if (this.jdoStateManager != null) {
/* 282:    */       return this.jdoStateManager.getVersion(this);
/* 283:    */     }
/* 284:    */     return null;
/* 285:    */   }
/* 286:    */   
/* 287:    */   protected final void jdoPreSerialize()
/* 288:    */   {
/* 289:    */     if (this.jdoStateManager != null) {
/* 290:    */       this.jdoStateManager.preSerialize(this);
/* 291:    */     }
/* 292:    */   }
/* 293:    */   
/* 294:    */   public final PersistenceManager jdoGetPersistenceManager()
/* 295:    */   {
/* 296:    */     return this.jdoStateManager != null ? this.jdoStateManager.getPersistenceManager(this) : null;
/* 297:    */   }
/* 298:    */   
/* 299:    */   public final Object jdoGetTransactionalObjectId()
/* 300:    */   {
/* 301:    */     return this.jdoStateManager != null ? this.jdoStateManager.getTransactionalObjectId(this) : null;
/* 302:    */   }
/* 303:    */   
/* 304:    */   public final boolean jdoIsDeleted()
/* 305:    */   {
/* 306:    */     return this.jdoStateManager != null ? this.jdoStateManager.isDeleted(this) : false;
/* 307:    */   }
/* 308:    */   
/* 309:    */   public final boolean jdoIsDirty()
/* 310:    */   {
/* 311:    */     if (this.jdoStateManager != null) {
/* 312:    */       return this.jdoStateManager.isDirty(this);
/* 313:    */     }
/* 314:    */     return false;
/* 315:    */   }
/* 316:    */   
/* 317:    */   public final boolean jdoIsNew()
/* 318:    */   {
/* 319:    */     return this.jdoStateManager != null ? this.jdoStateManager.isNew(this) : false;
/* 320:    */   }
/* 321:    */   
/* 322:    */   public final boolean jdoIsPersistent()
/* 323:    */   {
/* 324:    */     return this.jdoStateManager != null ? this.jdoStateManager.isPersistent(this) : false;
/* 325:    */   }
/* 326:    */   
/* 327:    */   public final boolean jdoIsTransactional()
/* 328:    */   {
/* 329:    */     return this.jdoStateManager != null ? this.jdoStateManager.isTransactional(this) : false;
/* 330:    */   }
/* 331:    */   
/* 332:    */   public void jdoMakeDirty(String fieldName)
/* 333:    */   {
/* 334:    */     if (this.jdoStateManager != null) {
/* 335:    */       this.jdoStateManager.makeDirty(this, fieldName);
/* 336:    */     }
/* 337:    */   }
/* 338:    */   
/* 339:    */   public final Object jdoNewObjectIdInstance()
/* 340:    */   {
/* 341:    */     return new StringIdentity(getClass(), this.key);
/* 342:    */   }
/* 343:    */   
/* 344:    */   public final Object jdoNewObjectIdInstance(Object key)
/* 345:    */   {
/* 346:    */     if (key == null) {
/* 347:    */       throw new IllegalArgumentException("key is null");
/* 348:    */     }
/* 349:    */     if (!(key instanceof String)) {
/* 350:    */       return new StringIdentity(getClass(), (String)key);
/* 351:    */     }
/* 352:    */     return new StringIdentity(getClass(), (String)key);
/* 353:    */   }
/* 354:    */   
/* 355:    */   public final void jdoProvideFields(int[] indices)
/* 356:    */   {
/* 357:    */     if (indices == null) {
/* 358:    */       throw new IllegalArgumentException("argment is null");
/* 359:    */     }
/* 360:    */     int i = indices.length - 1;
/* 361:    */     if (i >= 0) {
/* 362:    */       do
/* 363:    */       {
/* 364:    */         jdoProvideField(indices[i]);
/* 365:    */         i--;
/* 366:    */       } while (i >= 0);
/* 367:    */     }
/* 368:    */   }
/* 369:    */   
/* 370:    */   public final void jdoReplaceFields(int[] indices)
/* 371:    */   {
/* 372:    */     if (indices == null) {
/* 373:    */       throw new IllegalArgumentException("argument is null");
/* 374:    */     }
/* 375:    */     int i = indices.length;
/* 376:    */     if (i > 0)
/* 377:    */     {
/* 378:    */       int j = 0;
/* 379:    */       do
/* 380:    */       {
/* 381:    */         jdoReplaceField(indices[j]);
/* 382:    */         j++;
/* 383:    */       } while (j < i);
/* 384:    */     }
/* 385:    */   }
/* 386:    */   
/* 387:    */   public final void jdoReplaceFlags()
/* 388:    */   {
/* 389:    */     if (this.jdoStateManager != null) {
/* 390:    */       this.jdoFlags = this.jdoStateManager.replacingFlags(this);
/* 391:    */     }
/* 392:    */   }
/* 393:    */   
/* 394:    */   public final synchronized void jdoReplaceStateManager(StateManager sm)
/* 395:    */   {
/* 396:    */     if (this.jdoStateManager != null)
/* 397:    */     {
/* 398:    */       this.jdoStateManager = this.jdoStateManager.replacingStateManager(this, sm);
/* 399:    */     }
/* 400:    */     else
/* 401:    */     {
/* 402:    */       JDOImplHelper.checkAuthorizedStateManager(sm);
/* 403:    */       this.jdoStateManager = sm;
/* 404:    */       this.jdoFlags = 1;
/* 405:    */     }
/* 406:    */   }
/* 407:    */   
/* 408:    */   public boolean jdoIsDetached()
/* 409:    */   {
/* 410:    */     return false;
/* 411:    */   }
/* 412:    */   
/* 413:    */   public javax.jdo.spi.PersistenceCapable jdoNewInstance(StateManager sm)
/* 414:    */   {
/* 415:    */     AdWatcher result = new AdWatcher();
/* 416:    */     result.jdoFlags = 1;
/* 417:    */     result.jdoStateManager = sm;
/* 418:    */     return result;
/* 419:    */   }
/* 420:    */   
/* 421:    */   public javax.jdo.spi.PersistenceCapable jdoNewInstance(StateManager sm, Object obj)
/* 422:    */   {
/* 423:    */     AdWatcher result = new AdWatcher();
/* 424:    */     result.jdoFlags = 1;
/* 425:    */     result.jdoStateManager = sm;
/* 426:    */     result.jdoCopyKeyFieldsFromObjectId(obj);
/* 427:    */     return result;
/* 428:    */   }
/* 429:    */   
/* 430:    */   public void jdoReplaceField(int index)
/* 431:    */   {
/* 432:    */     if (this.jdoStateManager == null) {
/* 433:    */       throw new IllegalStateException("state manager is null");
/* 434:    */     }
/* 435:    */     switch (index)
/* 436:    */     {
/* 437:    */     case 0: 
/* 438:    */       this.createDate = ((Date)this.jdoStateManager.replacingObjectField(this, index));
/* 439:    */       break;
/* 440:    */     case 1: 
/* 441:    */       this.key = this.jdoStateManager.replacingStringField(this, index);
/* 442:    */       break;
/* 443:    */     case 2: 
/* 444:    */       this.keywords = this.jdoStateManager.replacingStringField(this, index);
/* 445:    */       break;
/* 446:    */     case 3: 
/* 447:    */       this.maxPrice = this.jdoStateManager.replacingStringField(this, index);
/* 448:    */       break;
/* 449:    */     case 4: 
/* 450:    */       this.miles = this.jdoStateManager.replacingStringField(this, index);
/* 451:    */       break;
/* 452:    */     case 5: 
/* 453:    */       this.minPrice = this.jdoStateManager.replacingStringField(this, index);
/* 454:    */       break;
/* 455:    */     case 6: 
/* 456:    */       this.notificationTime = this.jdoStateManager.replacingIntField(this, index);
/* 457:    */       break;
/* 458:    */     case 7: 
/* 459:    */       this.notifyEmail = this.jdoStateManager.replacingBooleanField(this, index);
/* 460:    */       break;
/* 461:    */     case 8: 
/* 462:    */       this.notifySMS = this.jdoStateManager.replacingBooleanField(this, index);
/* 463:    */       break;
/* 464:    */     case 9: 
/* 465:    */       this.seller = this.jdoStateManager.replacingStringField(this, index);
/* 466:    */       break;
/* 467:    */     case 10: 
/* 468:    */       this.url = this.jdoStateManager.replacingStringField(this, index);
/* 469:    */       break;
/* 470:    */     case 11: 
/* 471:    */       this.user = ((User)this.jdoStateManager.replacingObjectField(this, index));
/* 472:    */       break;
/* 473:    */     case 12: 
/* 474:    */       this.zip = this.jdoStateManager.replacingStringField(this, index);
/* 475:    */       break;
/* 476:    */     default: 
/* 477:    */       throw new IllegalArgumentException("out of field index :" + index);
/* 478:    */     }
/* 479:    */   }
/* 480:    */   
/* 481:    */   public void jdoProvideField(int index)
/* 482:    */   {
/* 483:    */     if (this.jdoStateManager == null) {
/* 484:    */       throw new IllegalStateException("state manager is null");
/* 485:    */     }
/* 486:    */     switch (index)
/* 487:    */     {
/* 488:    */     case 0: 
/* 489:    */       this.jdoStateManager.providedObjectField(this, index, this.createDate);
/* 490:    */       break;
/* 491:    */     case 1: 
/* 492:    */       this.jdoStateManager.providedStringField(this, index, this.key);
/* 493:    */       break;
/* 494:    */     case 2: 
/* 495:    */       this.jdoStateManager.providedStringField(this, index, this.keywords);
/* 496:    */       break;
/* 497:    */     case 3: 
/* 498:    */       this.jdoStateManager.providedStringField(this, index, this.maxPrice);
/* 499:    */       break;
/* 500:    */     case 4: 
/* 501:    */       this.jdoStateManager.providedStringField(this, index, this.miles);
/* 502:    */       break;
/* 503:    */     case 5: 
/* 504:    */       this.jdoStateManager.providedStringField(this, index, this.minPrice);
/* 505:    */       break;
/* 506:    */     case 6: 
/* 507:    */       this.jdoStateManager.providedIntField(this, index, this.notificationTime);
/* 508:    */       break;
/* 509:    */     case 7: 
/* 510:    */       this.jdoStateManager.providedBooleanField(this, index, this.notifyEmail);
/* 511:    */       break;
/* 512:    */     case 8: 
/* 513:    */       this.jdoStateManager.providedBooleanField(this, index, this.notifySMS);
/* 514:    */       break;
/* 515:    */     case 9: 
/* 516:    */       this.jdoStateManager.providedStringField(this, index, this.seller);
/* 517:    */       break;
/* 518:    */     case 10: 
/* 519:    */       this.jdoStateManager.providedStringField(this, index, this.url);
/* 520:    */       break;
/* 521:    */     case 11: 
/* 522:    */       this.jdoStateManager.providedObjectField(this, index, this.user);
/* 523:    */       break;
/* 524:    */     case 12: 
/* 525:    */       this.jdoStateManager.providedStringField(this, index, this.zip);
/* 526:    */       break;
/* 527:    */     default: 
/* 528:    */       throw new IllegalArgumentException("out of field index :" + index);
/* 529:    */     }
/* 530:    */   }
/* 531:    */   
/* 532:    */   protected final void jdoCopyField(AdWatcher obj, int index)
/* 533:    */   {
/* 534:    */     switch (index)
/* 535:    */     {
/* 536:    */     case 0: 
/* 537:    */       this.createDate = obj.createDate;
/* 538:    */       break;
/* 539:    */     case 1: 
/* 540:    */       this.key = obj.key;
/* 541:    */       break;
/* 542:    */     case 2: 
/* 543:    */       this.keywords = obj.keywords;
/* 544:    */       break;
/* 545:    */     case 3: 
/* 546:    */       this.maxPrice = obj.maxPrice;
/* 547:    */       break;
/* 548:    */     case 4: 
/* 549:    */       this.miles = obj.miles;
/* 550:    */       break;
/* 551:    */     case 5: 
/* 552:    */       this.minPrice = obj.minPrice;
/* 553:    */       break;
/* 554:    */     case 6: 
/* 555:    */       this.notificationTime = obj.notificationTime;
/* 556:    */       break;
/* 557:    */     case 7: 
/* 558:    */       this.notifyEmail = obj.notifyEmail;
/* 559:    */       break;
/* 560:    */     case 8: 
/* 561:    */       this.notifySMS = obj.notifySMS;
/* 562:    */       break;
/* 563:    */     case 9: 
/* 564:    */       this.seller = obj.seller;
/* 565:    */       break;
/* 566:    */     case 10: 
/* 567:    */       this.url = obj.url;
/* 568:    */       break;
/* 569:    */     case 11: 
/* 570:    */       this.user = obj.user;
/* 571:    */       break;
/* 572:    */     case 12: 
/* 573:    */       this.zip = obj.zip;
/* 574:    */       break;
/* 575:    */     default: 
/* 576:    */       throw new IllegalArgumentException("out of field index :" + index);
/* 577:    */     }
/* 578:    */   }
/* 579:    */   
/* 580:    */   public void jdoCopyFields(Object obj, int[] indices)
/* 581:    */   {
/* 582:    */     if (this.jdoStateManager == null) {
/* 583:    */       throw new IllegalStateException("state manager is null");
/* 584:    */     }
/* 585:    */     if (indices == null) {
/* 586:    */       throw new IllegalStateException("fieldNumbers is null");
/* 587:    */     }
/* 588:    */     if (!(obj instanceof AdWatcher)) {
/* 589:    */       throw new IllegalArgumentException("object is not an object of type com.dsmallwood.kslclassifieds.server.AdWatcher");
/* 590:    */     }
/* 591:    */     AdWatcher other = (AdWatcher)obj;
/* 592:    */     if (this.jdoStateManager != other.jdoStateManager) {
/* 593:    */       throw new IllegalArgumentException("state managers do not match");
/* 594:    */     }
/* 595:    */     int i = indices.length - 1;
/* 596:    */     if (i >= 0) {
/* 597:    */       do
/* 598:    */       {
/* 599:    */         jdoCopyField(other, indices[i]);
/* 600:    */         i--;
/* 601:    */       } while (i >= 0);
/* 602:    */     }
/* 603:    */   }
/* 604:    */   
/* 605:    */   private static final String[] __jdoFieldNamesInit()
/* 606:    */   {
/* 607:    */     return new String[] { "createDate", "key", "keywords", "maxPrice", "miles", "minPrice", "notificationTime", "notifyEmail", "notifySMS", "seller", "url", "user", "zip" };
/* 608:    */   }
/* 609:    */   
/* 610:    */   private static final Class[] __jdoFieldTypesInit()
/* 611:    */   {
/* 612:    */     return new Class[] { ___jdo$loadClass("java.util.Date"), ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("java.lang.String"), Integer.TYPE, Boolean.TYPE, Boolean.TYPE, ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("com.google.appengine.api.users.User"), ___jdo$loadClass("java.lang.String") };
/* 613:    */   }
/* 614:    */   
/* 615:    */   private static final byte[] __jdoFieldFlagsInit()
/* 616:    */   {
/* 617:    */     return new byte[] { 21, 24, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21 };
/* 618:    */   }
/* 619:    */   
/* 620:    */   protected static int __jdoGetInheritedFieldCount()
/* 621:    */   {
/* 622:    */     return 0;
/* 623:    */   }
/* 624:    */   
/* 625:    */   protected static int jdoGetManagedFieldCount()
/* 626:    */   {
/* 627:    */     return 13;
/* 628:    */   }
/* 629:    */   
/* 630:    */   private static Class __jdoPersistenceCapableSuperclassInit()
/* 631:    */   {
/* 632:    */     return null;
/* 633:    */   }
/* 634:    */   
/* 635:    */   private Object jdoSuperClone()
/* 636:    */     throws CloneNotSupportedException
/* 637:    */   {
/* 638:    */     AdWatcher o = (AdWatcher)super.clone();
/* 639:    */     o.jdoFlags = 0;
/* 640:    */     o.jdoStateManager = null;
/* 641:    */     return o;
/* 642:    */   }
/* 643:    */   
/* 644:    */   private static Date jdoGetcreateDate(AdWatcher objPC)
/* 645:    */   {
/* 646:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 0))) {
/* 647:    */       return (Date)objPC.jdoStateManager.getObjectField(objPC, 0, objPC.createDate);
/* 648:    */     }
/* 649:    */     return objPC.createDate;
/* 650:    */   }
/* 651:    */   
/* 652:    */   private static void jdoSetcreateDate(AdWatcher objPC, Date val)
/* 653:    */   {
/* 654:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 655:    */       objPC.jdoStateManager.setObjectField(objPC, 0, objPC.createDate, val);
/* 656:    */     } else {
/* 657:    */       objPC.createDate = val;
/* 658:    */     }
/* 659:    */   }
/* 660:    */   
/* 661:    */   private static String jdoGetkey(AdWatcher objPC)
/* 662:    */   {
/* 663:    */     return objPC.key;
/* 664:    */   }
/* 665:    */   
/* 666:    */   private static void jdoSetkey(AdWatcher objPC, String val)
/* 667:    */   {
/* 668:    */     if (objPC.jdoStateManager == null) {
/* 669:    */       objPC.key = val;
/* 670:    */     } else {
/* 671:    */       objPC.jdoStateManager.setStringField(objPC, 1, objPC.key, val);
/* 672:    */     }
/* 673:    */   }
/* 674:    */   
/* 675:    */   private static String jdoGetkeywords(AdWatcher objPC)
/* 676:    */   {
/* 677:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 2))) {
/* 678:    */       return objPC.jdoStateManager.getStringField(objPC, 2, objPC.keywords);
/* 679:    */     }
/* 680:    */     return objPC.keywords;
/* 681:    */   }
/* 682:    */   
/* 683:    */   private static void jdoSetkeywords(AdWatcher objPC, String val)
/* 684:    */   {
/* 685:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 686:    */       objPC.jdoStateManager.setStringField(objPC, 2, objPC.keywords, val);
/* 687:    */     } else {
/* 688:    */       objPC.keywords = val;
/* 689:    */     }
/* 690:    */   }
/* 691:    */   
/* 692:    */   private static String jdoGetmaxPrice(AdWatcher objPC)
/* 693:    */   {
/* 694:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 3))) {
/* 695:    */       return objPC.jdoStateManager.getStringField(objPC, 3, objPC.maxPrice);
/* 696:    */     }
/* 697:    */     return objPC.maxPrice;
/* 698:    */   }
/* 699:    */   
/* 700:    */   private static void jdoSetmaxPrice(AdWatcher objPC, String val)
/* 701:    */   {
/* 702:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 703:    */       objPC.jdoStateManager.setStringField(objPC, 3, objPC.maxPrice, val);
/* 704:    */     } else {
/* 705:    */       objPC.maxPrice = val;
/* 706:    */     }
/* 707:    */   }
/* 708:    */   
/* 709:    */   private static String jdoGetmiles(AdWatcher objPC)
/* 710:    */   {
/* 711:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 4))) {
/* 712:    */       return objPC.jdoStateManager.getStringField(objPC, 4, objPC.miles);
/* 713:    */     }
/* 714:    */     return objPC.miles;
/* 715:    */   }
/* 716:    */   
/* 717:    */   private static void jdoSetmiles(AdWatcher objPC, String val)
/* 718:    */   {
/* 719:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 720:    */       objPC.jdoStateManager.setStringField(objPC, 4, objPC.miles, val);
/* 721:    */     } else {
/* 722:    */       objPC.miles = val;
/* 723:    */     }
/* 724:    */   }
/* 725:    */   
/* 726:    */   private static String jdoGetminPrice(AdWatcher objPC)
/* 727:    */   {
/* 728:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 5))) {
/* 729:    */       return objPC.jdoStateManager.getStringField(objPC, 5, objPC.minPrice);
/* 730:    */     }
/* 731:    */     return objPC.minPrice;
/* 732:    */   }
/* 733:    */   
/* 734:    */   private static void jdoSetminPrice(AdWatcher objPC, String val)
/* 735:    */   {
/* 736:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 737:    */       objPC.jdoStateManager.setStringField(objPC, 5, objPC.minPrice, val);
/* 738:    */     } else {
/* 739:    */       objPC.minPrice = val;
/* 740:    */     }
/* 741:    */   }
/* 742:    */   
/* 743:    */   private static int jdoGetnotificationTime(AdWatcher objPC)
/* 744:    */   {
/* 745:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 6))) {
/* 746:    */       return objPC.jdoStateManager.getIntField(objPC, 6, objPC.notificationTime);
/* 747:    */     }
/* 748:    */     return objPC.notificationTime;
/* 749:    */   }
/* 750:    */   
/* 751:    */   private static void jdoSetnotificationTime(AdWatcher objPC, int val)
/* 752:    */   {
/* 753:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 754:    */       objPC.jdoStateManager.setIntField(objPC, 6, objPC.notificationTime, val);
/* 755:    */     } else {
/* 756:    */       objPC.notificationTime = val;
/* 757:    */     }
/* 758:    */   }
/* 759:    */   
/* 760:    */   private static boolean jdoGetnotifyEmail(AdWatcher objPC)
/* 761:    */   {
/* 762:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 7))) {
/* 763:    */       return objPC.jdoStateManager.getBooleanField(objPC, 7, objPC.notifyEmail);
/* 764:    */     }
/* 765:    */     return objPC.notifyEmail;
/* 766:    */   }
/* 767:    */   
/* 768:    */   private static void jdoSetnotifyEmail(AdWatcher objPC, boolean val)
/* 769:    */   {
/* 770:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 771:    */       objPC.jdoStateManager.setBooleanField(objPC, 7, objPC.notifyEmail, val);
/* 772:    */     } else {
/* 773:    */       objPC.notifyEmail = val;
/* 774:    */     }
/* 775:    */   }
/* 776:    */   
/* 777:    */   private static boolean jdoGetnotifySMS(AdWatcher objPC)
/* 778:    */   {
/* 779:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 8))) {
/* 780:    */       return objPC.jdoStateManager.getBooleanField(objPC, 8, objPC.notifySMS);
/* 781:    */     }
/* 782:    */     return objPC.notifySMS;
/* 783:    */   }
/* 784:    */   
/* 785:    */   private static void jdoSetnotifySMS(AdWatcher objPC, boolean val)
/* 786:    */   {
/* 787:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 788:    */       objPC.jdoStateManager.setBooleanField(objPC, 8, objPC.notifySMS, val);
/* 789:    */     } else {
/* 790:    */       objPC.notifySMS = val;
/* 791:    */     }
/* 792:    */   }
/* 793:    */   
/* 794:    */   private static String jdoGetseller(AdWatcher objPC)
/* 795:    */   {
/* 796:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 9))) {
/* 797:    */       return objPC.jdoStateManager.getStringField(objPC, 9, objPC.seller);
/* 798:    */     }
/* 799:    */     return objPC.seller;
/* 800:    */   }
/* 801:    */   
/* 802:    */   private static void jdoSetseller(AdWatcher objPC, String val)
/* 803:    */   {
/* 804:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 805:    */       objPC.jdoStateManager.setStringField(objPC, 9, objPC.seller, val);
/* 806:    */     } else {
/* 807:    */       objPC.seller = val;
/* 808:    */     }
/* 809:    */   }
/* 810:    */   
/* 811:    */   private static String jdoGeturl(AdWatcher objPC)
/* 812:    */   {
/* 813:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 10))) {
/* 814:    */       return objPC.jdoStateManager.getStringField(objPC, 10, objPC.url);
/* 815:    */     }
/* 816:    */     return objPC.url;
/* 817:    */   }
/* 818:    */   
/* 819:    */   private static void jdoSeturl(AdWatcher objPC, String val)
/* 820:    */   {
/* 821:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 822:    */       objPC.jdoStateManager.setStringField(objPC, 10, objPC.url, val);
/* 823:    */     } else {
/* 824:    */       objPC.url = val;
/* 825:    */     }
/* 826:    */   }
/* 827:    */   
/* 828:    */   private static User jdoGetuser(AdWatcher objPC)
/* 829:    */   {
/* 830:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 11))) {
/* 831:    */       return (User)objPC.jdoStateManager.getObjectField(objPC, 11, objPC.user);
/* 832:    */     }
/* 833:    */     return objPC.user;
/* 834:    */   }
/* 835:    */   
/* 836:    */   private static void jdoSetuser(AdWatcher objPC, User val)
/* 837:    */   {
/* 838:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 839:    */       objPC.jdoStateManager.setObjectField(objPC, 11, objPC.user, val);
/* 840:    */     } else {
/* 841:    */       objPC.user = val;
/* 842:    */     }
/* 843:    */   }
/* 844:    */   
/* 845:    */   private static String jdoGetzip(AdWatcher objPC)
/* 846:    */   {
/* 847:    */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 12))) {
/* 848:    */       return objPC.jdoStateManager.getStringField(objPC, 12, objPC.zip);
/* 849:    */     }
/* 850:    */     return objPC.zip;
/* 851:    */   }
/* 852:    */   
/* 853:    */   private static void jdoSetzip(AdWatcher objPC, String val)
/* 854:    */   {
/* 855:    */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* 856:    */       objPC.jdoStateManager.setStringField(objPC, 12, objPC.zip, val);
/* 857:    */     } else {
/* 858:    */       objPC.zip = val;
/* 859:    */     }
/* 860:    */   }
/* 861:    */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.AdWatcher
 * JD-Core Version:    0.7.0.1
 */