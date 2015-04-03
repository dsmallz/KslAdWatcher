/*   1:    */ package com.dsmallwood.kslclassifieds.client;
/*   2:    */ 
/*   3:    */ import com.dsmallwood.kslclassifieds.shared.AdWatcherDTO;
/*   4:    */ import com.dsmallwood.kslclassifieds.shared.FieldVerifier;
/*   5:    */ import com.google.gwt.core.client.EntryPoint;
/*   6:    */ import com.google.gwt.core.client.GWT;
/*   7:    */ import com.google.gwt.event.dom.client.ClickEvent;
/*   8:    */ import com.google.gwt.event.dom.client.ClickHandler;
/*   9:    */ import com.google.gwt.event.dom.client.KeyUpEvent;
/*  10:    */ import com.google.gwt.event.dom.client.KeyUpHandler;
/*  11:    */ import com.google.gwt.user.client.rpc.AsyncCallback;
/*  12:    */ import com.google.gwt.user.client.ui.Anchor;
/*  13:    */ import com.google.gwt.user.client.ui.Button;
/*  14:    */ import com.google.gwt.user.client.ui.CheckBox;
/*  15:    */ import com.google.gwt.user.client.ui.DialogBox;
/*  16:    */ import com.google.gwt.user.client.ui.DockPanel;
/*  17:    */ import com.google.gwt.user.client.ui.FlexTable;
/*  18:    */ import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
/*  19:    */ import com.google.gwt.user.client.ui.HTMLTable.Cell;
/*  20:    */ import com.google.gwt.user.client.ui.HTMLTable.CellFormatter;
/*  21:    */ import com.google.gwt.user.client.ui.HTMLTable.RowFormatter;
/*  22:    */ import com.google.gwt.user.client.ui.Label;
/*  23:    */ import com.google.gwt.user.client.ui.ListBox;
/*  24:    */ import com.google.gwt.user.client.ui.RootPanel;
/*  25:    */ import com.google.gwt.user.client.ui.TextBox;
/*  26:    */ import com.google.gwt.user.client.ui.VerticalPanel;
/*  27:    */ import java.util.ArrayList;
/*  28:    */ 
/*  29:    */ public class KSLClassifieds
/*  30:    */   implements EntryPoint
/*  31:    */ {
/*  32:    */   private static final String SERVER_ERROR = "An error occurred while attempting to contact the server. Please check your network connection and try again.";
/*  33: 47 */   private final AdWatcherServiceAsync AdWatcherService = (AdWatcherServiceAsync)GWT.create(AdWatcherService.class);
/*  34:    */   private TextBox keywordField;
/*  35:    */   private FlexTable watchListFlexTable;
/*  36:    */   private TextBox nickNameField;
/*  37: 52 */   private LoginInfo loginInfo = null;
/*  38: 53 */   private VerticalPanel loginPanel = new VerticalPanel();
/*  39: 54 */   private DockPanel dock = new DockPanel();
/*  40: 55 */   private Label loginLabel = new Label("Please sign in to your Google Account to access the KSL AdWatcher application.");
/*  41: 56 */   private Anchor signInLink = new Anchor("Sign In");
/*  42: 57 */   private Anchor signOutLink = new Anchor("Sign Out");
/*  43: 59 */   final Button createButton = new Button("Create AdWatcher");
/*  44: 60 */   final Button editButton = new Button("Apply Changes");
/*  45: 61 */   final Button cancelButton = new Button("Discard Changes");
/*  46: 63 */   final Label errorLabel = new Label();
/*  47: 64 */   final DialogBox dialogBox = new DialogBox();
/*  48: 65 */   final Button closeButton = new Button("Close");
/*  49:    */   private TextBox zipField;
/*  50:    */   private TextBox milesField;
/*  51:    */   private TextBox minField;
/*  52:    */   private TextBox maxField;
/*  53:    */   private ListBox sellerField;
/*  54:    */   private Label frequencyLabel;
/*  55:    */   private ListBox frequencyListBox;
/*  56:    */   private Label notificationMethodsLabel;
/*  57:    */   private CheckBox textMessageCheckBox;
/*  58:    */   private CheckBox emailCheckBox;
/*  59:    */   private int rowClicked;
/*  60: 78 */   final int KEY_COL = 0;
/*  61: 79 */   final int KEYWORD_COL = 1;
/*  62: 80 */   final int ZIP_COL = 2;
/*  63: 81 */   final int MILES_COL = 3;
/*  64: 82 */   final int MIN_COL = 4;
/*  65: 83 */   final int MAX_COL = 5;
/*  66: 84 */   final int SELLER_COL = 6;
/*  67: 85 */   final int FREQUENCY_COL = 7;
/*  68: 86 */   final int NOTIFICATIONS_COL = 8;
/*  69: 87 */   final int EDIT_LINK_COL = 9;
/*  70: 88 */   final int REMOVE_LINK_COL = 10;
/*  71:    */   
/*  72:    */   public String getKeyWordField()
/*  73:    */   {
/*  74: 94 */     return this.keywordField.getText();
/*  75:    */   }
/*  76:    */   
/*  77:    */   private void loadLogin()
/*  78:    */   {
/*  79: 99 */     this.signInLink.setHref(this.loginInfo.getLoginUrl());
/*  80:100 */     this.loginPanel.add(this.loginLabel);
/*  81:101 */     this.loginPanel.add(this.signInLink);
/*  82:102 */     RootPanel.get().add(this.loginPanel);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void onModuleLoad()
/*  86:    */   {
/*  87:109 */     LoginServiceAsync loginService = (LoginServiceAsync)GWT.create(LoginService.class);
/*  88:110 */     loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback()
/*  89:    */     {
/*  90:    */       public void onFailure(Throwable error) {}
/*  91:    */       
/*  92:    */       public void onSuccess(LoginInfo result)
/*  93:    */       {
/*  94:115 */         KSLClassifieds.this.loginInfo = result;
/*  95:116 */         if (KSLClassifieds.this.loginInfo.isLoggedIn())
/*  96:    */         {
/*  97:117 */           KSLClassifieds.this.signOutLink.setHref(KSLClassifieds.this.loginInfo.getLogoutUrl());
/*  98:118 */           KSLClassifieds.this.AdWatcherService.getAdWatcherList(new AsyncCallback()
/*  99:    */           {
/* 100:    */             public void onFailure(Throwable caught) {}
/* 101:    */             
/* 102:    */             public void onSuccess(ArrayList<AdWatcherDTO> watchList)
/* 103:    */             {
/* 104:125 */               KSLClassifieds.this.loadSearchFields();
/* 105:126 */               KSLClassifieds.this.loadWatchListTable(watchList);
/* 106:    */             }
/* 107:    */           });
/* 108:    */         }
/* 109:    */         else
/* 110:    */         {
/* 111:132 */           KSLClassifieds.this.loadLogin();
/* 112:    */         }
/* 113:    */       }
/* 114:    */     });
/* 115:    */   }
/* 116:    */   
/* 117:    */   private void loadSearchFields()
/* 118:    */   {
/* 119:141 */     Label searchLabel = new Label("Search Settings");
/* 120:142 */     searchLabel.setStylePrimaryName("bold");
/* 121:143 */     this.keywordField = new TextBox();
/* 122:144 */     Label keywordLabel = new Label("Keywords");
/* 123:145 */     this.zipField = new TextBox();
/* 124:146 */     Label zipLabel = new Label("Zip");
/* 125:147 */     this.milesField = new TextBox();
/* 126:148 */     Label milesLabel = new Label("Miles from");
/* 127:149 */     this.minField = new TextBox();
/* 128:150 */     Label minLabel = new Label("Min $");
/* 129:151 */     this.maxField = new TextBox();
/* 130:152 */     Label maxLabel = new Label("Max $");
/* 131:153 */     this.sellerField = new ListBox();
/* 132:154 */     Label sellerLabel = new Label("Seller");
/* 133:    */     
/* 134:156 */     this.sellerField.addItem("All");
/* 135:157 */     this.sellerField.addItem("Private");
/* 136:158 */     this.sellerField.addItem("Business");
/* 137:    */     
/* 138:    */ 
/* 139:161 */     this.frequencyLabel = new Label("Notification Settings");
/* 140:162 */     this.frequencyLabel.setStylePrimaryName("bold");
/* 141:163 */     this.frequencyListBox = new ListBox();
/* 142:164 */     this.frequencyListBox.addItem("1 Minute", "1");
/* 143:165 */     this.frequencyListBox.addItem("10 Minutes", "10");
/* 144:166 */     this.frequencyListBox.addItem("30 Minutes", "30");
/* 145:167 */     this.frequencyListBox.addItem("1 Hour", "60");
/* 146:168 */     this.frequencyListBox.addItem("2 Hours", "120");
/* 147:169 */     this.frequencyListBox.addItem("4 Hours", "240");
/* 148:170 */     this.frequencyListBox.addItem("8 Hours", "480");
/* 149:171 */     this.frequencyListBox.addItem("24 Hours", "1440");
/* 150:172 */     this.frequencyListBox.setSelectedIndex(3);
/* 151:173 */     this.notificationMethodsLabel = new Label("Notification Methods:");
/* 152:174 */     this.textMessageCheckBox = new CheckBox("Text Message");
/* 153:175 */     this.emailCheckBox = new CheckBox("Email Message");
/* 154:176 */     this.emailCheckBox.setValue(Boolean.valueOf(true));
/* 155:    */     
/* 156:178 */     this.editButton.addStyleName("editButton");
/* 157:179 */     this.editButton.setVisible(false);
/* 158:180 */     this.editButton.addClickHandler(new ClickHandler()
/* 159:    */     {
/* 160:    */       public void onClick(ClickEvent event)
/* 161:    */       {
/* 162:184 */         Label keyLabel = (Label)KSLClassifieds.this.watchListFlexTable.getWidget(KSLClassifieds.this.rowClicked, 0);
/* 163:185 */         final AdWatcherDTO adWatcherDTO = new AdWatcherDTO(KSLClassifieds.this.keywordField.getText(), 
/* 164:186 */           KSLClassifieds.this.zipField.getText(), 
/* 165:187 */           KSLClassifieds.this.milesField.getText(), 
/* 166:188 */           KSLClassifieds.this.minField.getText(), 
/* 167:189 */           KSLClassifieds.this.maxField.getText(), 
/* 168:190 */           KSLClassifieds.this.sellerField.getItemText(KSLClassifieds.this.sellerField.getSelectedIndex()), 
/* 169:191 */           Integer.parseInt(KSLClassifieds.this.frequencyListBox.getValue(KSLClassifieds.this.frequencyListBox.getSelectedIndex())), 
/* 170:192 */           KSLClassifieds.this.emailCheckBox.getValue().booleanValue(), 
/* 171:193 */           KSLClassifieds.this.textMessageCheckBox.getValue().booleanValue());
/* 172:194 */         adWatcherDTO.setKey(keyLabel.getText());
/* 173:195 */         adWatcherDTO.setUrl(KSLClassifieds.this.createAdWatcherUrl(adWatcherDTO));
/* 174:196 */         KSLClassifieds.this.AdWatcherService.editAdWatcherListItem(keyLabel.getText(), adWatcherDTO, new AsyncCallback()
/* 175:    */         {
/* 176:    */           public void onFailure(Throwable caught) {}
/* 177:    */           
/* 178:    */           public void onSuccess(Void result)
/* 179:    */           {
/* 180:203 */             KSLClassifieds.this.addItemToTable(KSLClassifieds.this.rowClicked, adWatcherDTO);
/* 181:204 */             KSLClassifieds.this.editButton.setVisible(false);
/* 182:205 */             KSLClassifieds.this.cancelButton.setVisible(false);
/* 183:206 */             KSLClassifieds.this.createButton.setVisible(true);
/* 184:207 */             KSLClassifieds.this.clearSearchFieldValues();
/* 185:    */           }
/* 186:    */         });
/* 187:    */       }
/* 188:212 */     });
/* 189:213 */     this.cancelButton.addStyleName("cancelButton");
/* 190:214 */     this.cancelButton.setVisible(false);
/* 191:215 */     this.cancelButton.addClickHandler(new ClickHandler()
/* 192:    */     {
/* 193:    */       public void onClick(ClickEvent event)
/* 194:    */       {
/* 195:219 */         KSLClassifieds.this.editButton.setVisible(false);
/* 196:220 */         KSLClassifieds.this.cancelButton.setVisible(false);
/* 197:221 */         KSLClassifieds.this.createButton.setVisible(true);
/* 198:222 */         KSLClassifieds.this.clearSearchFieldValues();
/* 199:    */       }
/* 200:229 */     });
/* 201:230 */     this.createButton.addStyleName("createButton");
/* 202:231 */     MyHandler handler = new MyHandler();
/* 203:232 */     this.createButton.addClickHandler(handler);
/* 204:    */     
/* 205:    */ 
/* 206:235 */     FlexTable searchFlexTable = new FlexTable();
/* 207:236 */     FlexTable.FlexCellFormatter cellFormatter = searchFlexTable.getFlexCellFormatter();
/* 208:237 */     searchFlexTable.addStyleName("cw-FlexTable");
/* 209:238 */     searchFlexTable.setWidth("32em");
/* 210:239 */     searchFlexTable.setCellSpacing(5);
/* 211:240 */     searchFlexTable.setCellPadding(3);
/* 212:    */     
/* 213:242 */     searchFlexTable.setWidget(0, 0, searchLabel);
/* 214:243 */     searchFlexTable.setWidget(1, 0, keywordLabel);
/* 215:244 */     searchFlexTable.setWidget(1, 1, this.keywordField);
/* 216:245 */     searchFlexTable.setWidget(2, 0, zipLabel);
/* 217:246 */     searchFlexTable.setWidget(2, 1, this.zipField);
/* 218:247 */     searchFlexTable.setWidget(3, 0, milesLabel);
/* 219:248 */     searchFlexTable.setWidget(3, 1, this.milesField);
/* 220:249 */     searchFlexTable.setWidget(4, 0, minLabel);
/* 221:250 */     searchFlexTable.setWidget(4, 1, this.minField);
/* 222:251 */     searchFlexTable.setWidget(5, 0, maxLabel);
/* 223:252 */     searchFlexTable.setWidget(5, 1, this.maxField);
/* 224:253 */     searchFlexTable.setWidget(6, 0, sellerLabel);
/* 225:254 */     searchFlexTable.setWidget(6, 1, this.sellerField);
/* 226:255 */     searchFlexTable.setText(7, 0, " ");
/* 227:    */     
/* 228:257 */     searchFlexTable.setWidget(8, 0, this.frequencyLabel);
/* 229:258 */     searchFlexTable.setText(9, 0, "Notification Frequency");
/* 230:259 */     searchFlexTable.setWidget(9, 1, this.frequencyListBox);
/* 231:260 */     searchFlexTable.setWidget(10, 0, this.notificationMethodsLabel);
/* 232:261 */     searchFlexTable.setWidget(10, 1, this.textMessageCheckBox);
/* 233:262 */     searchFlexTable.setWidget(11, 1, this.emailCheckBox);
/* 234:263 */     searchFlexTable.setText(13, 0, " ");
/* 235:264 */     searchFlexTable.setWidget(14, 1, this.createButton);
/* 236:265 */     searchFlexTable.setWidget(15, 1, this.editButton);
/* 237:266 */     searchFlexTable.setWidget(16, 1, this.cancelButton);
/* 238:    */     
/* 239:268 */     this.dock = new DockPanel();
/* 240:269 */     this.dock.setStyleName("search-DockPanel");
/* 241:270 */     this.dock.setSpacing(4);
/* 242:271 */     this.dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
/* 243:    */     
/* 244:273 */     this.dock.add(searchFlexTable, DockPanel.WEST);
/* 245:    */     
/* 246:    */ 
/* 247:276 */     RootPanel.get().add(this.dock);
/* 248:    */     
/* 249:    */ 
/* 250:279 */     this.keywordField.setFocus(true);
/* 251:280 */     this.keywordField.selectAll();
/* 252:    */   }
/* 253:    */   
/* 254:    */   private void clearSearchFieldValues()
/* 255:    */   {
/* 256:285 */     this.keywordField.setText("");
/* 257:286 */     this.zipField.setText("");
/* 258:287 */     this.milesField.setText("");
/* 259:288 */     this.minField.setText("");
/* 260:289 */     this.maxField.setText("");
/* 261:290 */     this.sellerField.setSelectedIndex(0);
/* 262:293 */     for (int i = 0; i < this.frequencyListBox.getItemCount(); i++)
/* 263:    */     {
/* 264:295 */       String value = "60";
/* 265:296 */       if (value.equalsIgnoreCase(this.frequencyListBox.getValue(i)))
/* 266:    */       {
/* 267:298 */         this.frequencyListBox.setSelectedIndex(i);
/* 268:299 */         break;
/* 269:    */       }
/* 270:    */     }
/* 271:    */   }
/* 272:    */   
/* 273:    */   private void loadWatchListTable(ArrayList<AdWatcherDTO> watchList)
/* 274:    */   {
/* 275:307 */     this.watchListFlexTable = new FlexTable();
/* 276:308 */     this.watchListFlexTable.setText(0, 1, "Keywords");
/* 277:309 */     this.watchListFlexTable.setText(0, 2, "Zip");
/* 278:310 */     this.watchListFlexTable.setText(0, 3, "Miles From");
/* 279:311 */     this.watchListFlexTable.setText(0, 4, "Min $");
/* 280:312 */     this.watchListFlexTable.setText(0, 5, "Max $");
/* 281:313 */     this.watchListFlexTable.setText(0, 6, "Seller");
/* 282:    */     
/* 283:315 */     this.watchListFlexTable.setText(0, 7, "Frequency");
/* 284:316 */     this.watchListFlexTable.setText(0, 8, "Notifications");
/* 285:    */     
/* 286:318 */     this.watchListFlexTable.setText(0, 9, "Edit");
/* 287:319 */     this.watchListFlexTable.setText(0, 10, "Remove");
/* 288:    */     
/* 289:    */ 
/* 290:    */ 
/* 291:323 */     this.watchListFlexTable.setCellPadding(6);
/* 292:324 */     this.watchListFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
/* 293:325 */     this.watchListFlexTable.addStyleName("watchList");
/* 294:326 */     this.watchListFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
/* 295:327 */     this.watchListFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
/* 296:328 */     this.watchListFlexTable.getCellFormatter().addStyleName(0, 4, "watchListNumericColumn");
/* 297:329 */     this.watchListFlexTable.getCellFormatter().addStyleName(0, 5, "watchListNumericColumn");
/* 298:330 */     this.watchListFlexTable.getCellFormatter().addStyleName(0, 9, "watchListEditColumn");
/* 299:331 */     this.watchListFlexTable.getCellFormatter().addStyleName(0, 10, "watchListRemoveColumn");
/* 300:334 */     for (int i = 0; i < watchList.size(); i++) {
/* 301:336 */       addItemToTable(i + 1, (AdWatcherDTO)watchList.get(i));
/* 302:    */     }
/* 303:339 */     this.watchListFlexTable.addClickHandler(new ClickHandler()
/* 304:    */     {
/* 305:    */       public void onClick(ClickEvent event)
/* 306:    */       {
/* 307:342 */         FlexTable table = (FlexTable)event.getSource();
/* 308:343 */         HTMLTable.Cell cell = table.getCellForEvent(event);
/* 309:344 */         KSLClassifieds.this.rowClicked = cell.getRowIndex();
/* 310:345 */         int colClicked = cell.getCellIndex();
/* 311:347 */         if (colClicked == 9)
/* 312:    */         {
/* 313:348 */           KSLClassifieds.this.createButton.setVisible(false);
/* 314:349 */           KSLClassifieds.this.editButton.setVisible(true);
/* 315:350 */           KSLClassifieds.this.cancelButton.setVisible(true);
/* 316:351 */           loadSearchFieldValues(KSLClassifieds.this.rowClicked);
/* 317:    */         }
/* 318:352 */         else if (colClicked == 10)
/* 319:    */         {
/* 320:353 */           Label key = (Label)table.getWidget(KSLClassifieds.this.rowClicked, 0);
/* 321:354 */           KSLClassifieds.this.AdWatcherService.removeAdWatcherListItem(key.getText(), new AsyncCallback()
/* 322:    */           {
/* 323:    */             public void onFailure(Throwable caught) {}
/* 324:    */             
/* 325:    */             public void onSuccess(Void result)
/* 326:    */             {
/* 327:361 */               KSLClassifieds.this.watchListFlexTable.removeRow(KSLClassifieds.this.rowClicked);
/* 328:    */             }
/* 329:    */           });
/* 330:    */         }
/* 331:    */       }
/* 332:    */       
/* 333:    */       private void loadSearchFieldValues(int rowClicked)
/* 334:    */       {
/* 335:368 */         KSLClassifieds.this.keywordField.setText(KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 1));
/* 336:369 */         KSLClassifieds.this.zipField.setText(KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 2));
/* 337:370 */         KSLClassifieds.this.milesField.setText(KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 3));
/* 338:371 */         KSLClassifieds.this.minField.setText(KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 4));
/* 339:372 */         KSLClassifieds.this.maxField.setText(KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 5));
/* 340:373 */         String seller = KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 6);
/* 341:374 */         if (seller.equalsIgnoreCase("All")) {
/* 342:375 */           KSLClassifieds.this.sellerField.setSelectedIndex(0);
/* 343:377 */         } else if (seller.equalsIgnoreCase("Private")) {
/* 344:378 */           KSLClassifieds.this.sellerField.setSelectedIndex(1);
/* 345:    */         } else {
/* 346:381 */           KSLClassifieds.this.sellerField.setSelectedIndex(2);
/* 347:    */         }
/* 348:384 */         String[] timeString = KSLClassifieds.this.watchListFlexTable.getText(rowClicked, 7).split(" ");
/* 349:385 */         int time = 60;
/* 350:386 */         if ((timeString[1].contains("Hour")) || (timeString[1].contains("hour"))) {
/* 351:388 */           time = Integer.parseInt(timeString[0]) * 60;
/* 352:    */         } else {
/* 353:392 */           time = Integer.parseInt(timeString[0]);
/* 354:    */         }
/* 355:394 */         for (int i = 0; i < KSLClassifieds.this.frequencyListBox.getItemCount(); i++)
/* 356:    */         {
/* 357:396 */           int value = Integer.parseInt(KSLClassifieds.this.frequencyListBox.getValue(i));
/* 358:398 */           if (value == time)
/* 359:    */           {
/* 360:400 */             KSLClassifieds.this.frequencyListBox.setSelectedIndex(i);
/* 361:401 */             break;
/* 362:    */           }
/* 363:    */         }
/* 364:    */       }
/* 365:407 */     });
/* 366:408 */     this.dock.add(this.watchListFlexTable, DockPanel.EAST);
/* 367:409 */     RootPanel.get().add(this.signOutLink);
/* 368:    */   }
/* 369:    */   
/* 370:    */   public void addItemToTable(int row, AdWatcherDTO item)
/* 371:    */   {
/* 372:414 */     Label key = new Label(item.getKey());
/* 373:415 */     Anchor kslURL = new Anchor(item.getKeywords(), item.getUrl());
/* 374:416 */     key.setVisible(false);
/* 375:417 */     this.watchListFlexTable.setWidget(row, 0, key);
/* 376:418 */     this.watchListFlexTable.setWidget(row, 1, kslURL);
/* 377:419 */     this.watchListFlexTable.setText(row, 2, item.getZip());
/* 378:420 */     this.watchListFlexTable.setText(row, 3, item.getMiles());
/* 379:421 */     this.watchListFlexTable.setText(row, 4, item.getMinPrice());
/* 380:422 */     this.watchListFlexTable.setText(row, 5, item.getMaxPrice());
/* 381:423 */     this.watchListFlexTable.setText(row, 6, item.getSeller());
/* 382:424 */     this.watchListFlexTable.setText(row, 7, convertNumToText(item.getNotificationTime()));
/* 383:425 */     this.watchListFlexTable.setText(row, 8, "Email/SMS");
/* 384:    */     
/* 385:427 */     this.watchListFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
/* 386:428 */     this.watchListFlexTable.getCellFormatter().addStyleName(row, 3, "watchListNumericColumn");
/* 387:429 */     this.watchListFlexTable.getCellFormatter().addStyleName(row, 4, "watchListNumericColumn");
/* 388:430 */     this.watchListFlexTable.getCellFormatter().addStyleName(row, 5, "editListRemoveColumn");
/* 389:431 */     this.watchListFlexTable.getCellFormatter().addStyleName(row, 10, "watchListRemoveColumn");
/* 390:    */     
/* 391:    */ 
/* 392:    */ 
/* 393:    */ 
/* 394:436 */     Button editWatchListItemButton = new Button("x");
/* 395:437 */     editWatchListItemButton.addStyleDependentName("edit");
/* 396:    */     
/* 397:    */ 
/* 398:    */ 
/* 399:    */ 
/* 400:    */ 
/* 401:    */ 
/* 402:    */ 
/* 403:    */ 
/* 404:    */ 
/* 405:    */ 
/* 406:    */ 
/* 407:    */ 
/* 408:    */ 
/* 409:    */ 
/* 410:    */ 
/* 411:    */ 
/* 412:    */ 
/* 413:    */ 
/* 414:    */ 
/* 415:    */ 
/* 416:    */ 
/* 417:    */ 
/* 418:    */ 
/* 419:    */ 
/* 420:    */ 
/* 421:    */ 
/* 422:    */ 
/* 423:    */ 
/* 424:    */ 
/* 425:    */ 
/* 426:    */ 
/* 427:    */ 
/* 428:    */ 
/* 429:    */ 
/* 430:    */ 
/* 431:    */ 
/* 432:    */ 
/* 433:    */ 
/* 434:    */ 
/* 435:    */ 
/* 436:    */ 
/* 437:    */ 
/* 438:480 */     Button removeWatchListItemButton = new Button("x");
/* 439:481 */     removeWatchListItemButton.addStyleDependentName("remove");
/* 440:    */     
/* 441:    */ 
/* 442:    */ 
/* 443:    */ 
/* 444:    */ 
/* 445:    */ 
/* 446:    */ 
/* 447:    */ 
/* 448:    */ 
/* 449:    */ 
/* 450:    */ 
/* 451:    */ 
/* 452:    */ 
/* 453:    */ 
/* 454:    */ 
/* 455:    */ 
/* 456:498 */     this.watchListFlexTable.setWidget(row, 9, editWatchListItemButton);
/* 457:499 */     this.watchListFlexTable.setWidget(row, 10, removeWatchListItemButton);
/* 458:    */   }
/* 459:    */   
/* 460:    */   private String convertNumToText(int notificationTime)
/* 461:    */   {
/* 462:505 */     switch (notificationTime)
/* 463:    */     {
/* 464:    */     case 1: 
/* 465:506 */       return "1 minute";
/* 466:    */     case 10: 
/* 467:507 */       return "10 minutes";
/* 468:    */     case 30: 
/* 469:508 */       return "30 minutes";
/* 470:    */     case 60: 
/* 471:509 */       return "1 hour";
/* 472:    */     case 120: 
/* 473:510 */       return "2 hours";
/* 474:    */     case 240: 
/* 475:511 */       return "4 hours";
/* 476:    */     case 480: 
/* 477:512 */       return "8 hours";
/* 478:    */     case 1440: 
/* 479:513 */       return "24 hours";
/* 480:    */     }
/* 481:516 */     return "No Schedule";
/* 482:    */   }
/* 483:    */   
/* 484:    */   private String createAdWatcherUrl(AdWatcherDTO adWatcherDTO)
/* 485:    */   {
/* 486:521 */     String url = "http://www.ksl.com/index.php?nid=231&nocache=1&search=&zip=&distance=&min_price=&max_price=&type=&x=0&y=0";
/* 487:522 */     url = url.replace("search=", "search=" + adWatcherDTO.getKeywords());
/* 488:523 */     url = url.replace("zip=", "zip=" + adWatcherDTO.getZip());
/* 489:524 */     url = url.replace("distance=", "distance=" + adWatcherDTO.getMiles());
/* 490:525 */     url = url.replace("min_price=", "min_price=" + adWatcherDTO.getMinPrice());
/* 491:526 */     url = url.replace("max_price=", "max_price=" + adWatcherDTO.getMaxPrice());
/* 492:    */     
/* 493:528 */     String sellerType = adWatcherDTO.getSeller();
/* 494:529 */     if (sellerType.equalsIgnoreCase("Private")) {
/* 495:531 */       url = url.replace("type=", "type=0");
/* 496:533 */     } else if (sellerType.equalsIgnoreCase("Business")) {
/* 497:535 */       url = url.replace("type=", "type=1");
/* 498:    */     }
/* 499:538 */     return url;
/* 500:    */   }
/* 501:    */   
/* 502:    */   class MyHandler
/* 503:    */     implements ClickHandler, KeyUpHandler
/* 504:    */   {
/* 505:    */     MyHandler() {}
/* 506:    */     
/* 507:    */     public void onClick(ClickEvent event)
/* 508:    */     {
/* 509:548 */       addWatchListItem();
/* 510:    */     }
/* 511:    */     
/* 512:    */     public void onKeyUp(KeyUpEvent event)
/* 513:    */     {
/* 514:556 */       if (event.getNativeKeyCode() == 13) {
/* 515:558 */         addWatchListItem();
/* 516:    */       }
/* 517:    */     }
/* 518:    */     
/* 519:    */     private void addWatchListItem()
/* 520:    */     {
/* 521:567 */       KSLClassifieds.this.errorLabel.setText("");
/* 522:568 */       String validKeyword = KSLClassifieds.this.keywordField.getText();
/* 523:569 */       if (!FieldVerifier.isValidName(validKeyword))
/* 524:    */       {
/* 525:570 */         KSLClassifieds.this.errorLabel.setText("Please enter a valid search keyword.");
/* 526:571 */         return;
/* 527:    */       }
/* 528:576 */       final AdWatcherDTO adWatcherDTO = new AdWatcherDTO(KSLClassifieds.this.keywordField.getText(), 
/* 529:577 */         KSLClassifieds.this.zipField.getText(), 
/* 530:578 */         KSLClassifieds.this.milesField.getText(), 
/* 531:579 */         KSLClassifieds.this.minField.getText(), 
/* 532:580 */         KSLClassifieds.this.maxField.getText(), 
/* 533:581 */         KSLClassifieds.this.sellerField.getItemText(KSLClassifieds.this.sellerField.getSelectedIndex()), 
/* 534:582 */         Integer.parseInt(KSLClassifieds.this.frequencyListBox.getValue(KSLClassifieds.this.frequencyListBox.getSelectedIndex())), 
/* 535:583 */         KSLClassifieds.this.emailCheckBox.getValue().booleanValue(), 
/* 536:584 */         KSLClassifieds.this.textMessageCheckBox.getValue().booleanValue());
/* 537:585 */       adWatcherDTO.setUrl(KSLClassifieds.this.createAdWatcherUrl(adWatcherDTO));
/* 538:586 */       KSLClassifieds.this.AdWatcherService.addAdWatcher(adWatcherDTO, 
/* 539:587 */         new AsyncCallback()
/* 540:    */         {
/* 541:    */           public void onFailure(Throwable caught)
/* 542:    */           {
/* 543:591 */             KSLClassifieds.this.dialogBox.setText("Remote Procedure Call - Failure");
/* 544:592 */             KSLClassifieds.this.dialogBox.center();
/* 545:593 */             KSLClassifieds.this.closeButton.setFocus(true);
/* 546:    */           }
/* 547:    */           
/* 548:    */           public void onSuccess(String key)
/* 549:    */           {
/* 550:597 */             KSLClassifieds.this.dialogBox.setText("Remote Procedure Call");
/* 551:598 */             adWatcherDTO.setKey(key);
/* 552:599 */             KSLClassifieds.this.addItemToTable(KSLClassifieds.this.watchListFlexTable.getRowCount(), adWatcherDTO);
/* 553:600 */             KSLClassifieds.this.clearSearchFieldValues();
/* 554:    */           }
/* 555:    */         });
/* 556:    */     }
/* 557:    */   }
/* 558:    */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.client.KSLClassifieds
 * JD-Core Version:    0.7.0.1
 */