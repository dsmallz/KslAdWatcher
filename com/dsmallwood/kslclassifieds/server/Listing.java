/*   1:    */ package com.dsmallwood.kslclassifieds.server;
/*   2:    */ 
/*   3:    */ public class Listing
/*   4:    */ {
/*   5:    */   private String adURLLink;
/*   6:    */   private String adImageSource;
/*   7:    */   private String adTitle;
/*   8:    */   private String adPrice;
/*   9:    */   private String adDays;
/*  10:    */   private String adDesc;
/*  11:    */   private String adLocation;
/*  12:    */   private String timeUnit;
/*  13:    */   private int timeValue;
/*  14:    */   
/*  15:    */   public Listing() {}
/*  16:    */   
/*  17:    */   public Listing(String adURLLink, String adImageSource, String adTitle, String adPrice, String adDays, String adDesc, String adLocation)
/*  18:    */   {
/*  19: 22 */     this.adURLLink = adURLLink;
/*  20: 23 */     this.adImageSource = adImageSource;
/*  21: 24 */     this.adTitle = adTitle;
/*  22: 25 */     this.adPrice = adPrice;
/*  23: 26 */     this.adDesc = adDesc;
/*  24: 27 */     this.adLocation = adLocation;
/*  25: 28 */     this.adDays = adDays;
/*  26:    */     
/*  27: 30 */     String[] time = adDays.split(" ");
/*  28: 31 */     if (time.length == 2)
/*  29:    */     {
/*  30: 33 */       this.timeValue = Integer.parseInt(time[0]);
/*  31: 34 */       this.timeUnit = time[1];
/*  32:    */     }
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setAdURLLink(String adURLLink)
/*  36:    */   {
/*  37: 40 */     this.adURLLink = adURLLink;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getAdURLLink()
/*  41:    */   {
/*  42: 44 */     return this.adURLLink;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setAdImageSource(String adImageSource)
/*  46:    */   {
/*  47: 48 */     this.adImageSource = adImageSource;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getAdImageSource()
/*  51:    */   {
/*  52: 52 */     return this.adImageSource;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setAdTitle(String adTitle)
/*  56:    */   {
/*  57: 56 */     this.adTitle = adTitle;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getAdTitle()
/*  61:    */   {
/*  62: 60 */     return this.adTitle;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setAdPrice(String adPrice)
/*  66:    */   {
/*  67: 64 */     this.adPrice = adPrice;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getAdPrice()
/*  71:    */   {
/*  72: 68 */     return this.adPrice;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setAdDays(String adDays)
/*  76:    */   {
/*  77: 73 */     this.adDays = adDays;
/*  78: 74 */     String[] time = adDays.split(" ");
/*  79: 75 */     if (time.length == 2)
/*  80:    */     {
/*  81: 77 */       this.timeValue = Integer.parseInt(time[0]);
/*  82: 78 */       this.timeUnit = time[0];
/*  83:    */     }
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getAdDays()
/*  87:    */   {
/*  88: 83 */     return this.adDays;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getTimeUnit()
/*  92:    */   {
/*  93: 88 */     return this.timeUnit;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public int getTimeValue()
/*  97:    */   {
/*  98: 93 */     return this.timeValue;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setAdDesc(String adDesc)
/* 102:    */   {
/* 103: 97 */     this.adDesc = adDesc;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getAdDesc()
/* 107:    */   {
/* 108:102 */     return this.adDesc;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setAdLocation(String adLocation)
/* 112:    */   {
/* 113:106 */     this.adLocation = adLocation;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getAdLocation()
/* 117:    */   {
/* 118:110 */     return this.adLocation;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setNullValues()
/* 122:    */   {
/* 123:114 */     this.adURLLink = null;
/* 124:115 */     this.adImageSource = null;
/* 125:116 */     this.adTitle = null;
/* 126:117 */     this.adPrice = null;
/* 127:118 */     this.adDays = null;
/* 128:119 */     this.timeValue = 2147483647;
/* 129:120 */     this.timeUnit = null;
/* 130:121 */     this.adDesc = null;
/* 131:122 */     setAdLocation(null);
/* 132:    */   }
/* 133:    */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.Listing
 * JD-Core Version:    0.7.0.1
 */