/*   1:    */ package com.dsmallwood.kslclassifieds.shared;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class AdWatcherDTO
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8:    */   private String key;
/*   9:    */   private String keywords;
/*  10:    */   private String zip;
/*  11:    */   private String miles;
/*  12:    */   private String minPrice;
/*  13:    */   private String maxPrice;
/*  14:    */   private String seller;
/*  15:    */   private String url;
/*  16:    */   private int notificationTime;
/*  17:    */   private boolean notifyEmail;
/*  18:    */   private boolean notifySMS;
/*  19:    */   
/*  20:    */   public AdWatcherDTO() {}
/*  21:    */   
/*  22:    */   public AdWatcherDTO(String keywords, String zip, String miles, String minPrice, String maxPrice, String seller, int notificationTime, boolean notifyEmail, boolean notifySMS)
/*  23:    */   {
/*  24: 34 */     setKeywords(keywords);
/*  25: 35 */     setZip(zip);
/*  26: 36 */     setMiles(miles);
/*  27: 37 */     setMinPrice(minPrice);
/*  28: 38 */     setMaxPrice(maxPrice);
/*  29: 39 */     setSeller(seller);
/*  30: 40 */     setNotificationTime(notificationTime);
/*  31: 41 */     setNotifyEmail(notifyEmail);
/*  32: 42 */     setNotifySMS(notifySMS);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public AdWatcherDTO(String keywords, String zip, String miles, String minPrice, String maxPrice, String seller, String key, String url, int notificationTime, boolean notifyEmail, boolean notifySMS)
/*  36:    */   {
/*  37: 57 */     setKeywords(keywords);
/*  38: 58 */     setZip(zip);
/*  39: 59 */     setMiles(miles);
/*  40: 60 */     setMinPrice(minPrice);
/*  41: 61 */     setMaxPrice(maxPrice);
/*  42: 62 */     setSeller(seller);
/*  43: 63 */     setKey(key);
/*  44: 64 */     setUrl(url);
/*  45: 65 */     setNotificationTime(notificationTime);
/*  46: 66 */     setNotifyEmail(notifyEmail);
/*  47: 67 */     setNotifySMS(notifySMS);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setKey(String key)
/*  51:    */   {
/*  52: 72 */     this.key = key;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getKey()
/*  56:    */   {
/*  57: 76 */     return this.key;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setKeywords(String keywords)
/*  61:    */   {
/*  62: 80 */     this.keywords = keywords;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public String getKeywords()
/*  66:    */   {
/*  67: 84 */     return this.keywords;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setZip(String zip)
/*  71:    */   {
/*  72: 88 */     this.zip = zip;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getZip()
/*  76:    */   {
/*  77: 92 */     return this.zip;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setMiles(String miles)
/*  81:    */   {
/*  82: 96 */     this.miles = miles;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getMiles()
/*  86:    */   {
/*  87:100 */     return this.miles;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setMinPrice(String minPrice)
/*  91:    */   {
/*  92:104 */     this.minPrice = minPrice;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getMinPrice()
/*  96:    */   {
/*  97:108 */     return this.minPrice;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setMaxPrice(String maxPrice)
/* 101:    */   {
/* 102:112 */     this.maxPrice = maxPrice;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getMaxPrice()
/* 106:    */   {
/* 107:116 */     return this.maxPrice;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setSeller(String seller)
/* 111:    */   {
/* 112:120 */     this.seller = seller;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String getSeller()
/* 116:    */   {
/* 117:124 */     return this.seller;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setUrl(String url)
/* 121:    */   {
/* 122:128 */     this.url = url;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getUrl()
/* 126:    */   {
/* 127:132 */     return this.url;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setNotificationTime(int notificationTime)
/* 131:    */   {
/* 132:136 */     this.notificationTime = notificationTime;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public int getNotificationTime()
/* 136:    */   {
/* 137:140 */     return this.notificationTime;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setNotifyEmail(boolean notifyEmail)
/* 141:    */   {
/* 142:144 */     this.notifyEmail = notifyEmail;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public boolean isNotifyEmail()
/* 146:    */   {
/* 147:148 */     return this.notifyEmail;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setNotifySMS(boolean notifySMS)
/* 151:    */   {
/* 152:152 */     this.notifySMS = notifySMS;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public boolean isNotifySMS()
/* 156:    */   {
/* 157:156 */     return this.notifySMS;
/* 158:    */   }
/* 159:    */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.shared.AdWatcherDTO
 * JD-Core Version:    0.7.0.1
 */