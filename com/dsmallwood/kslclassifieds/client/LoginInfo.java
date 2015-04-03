/*  1:   */ package com.dsmallwood.kslclassifieds.client;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public class LoginInfo
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8: 7 */   private boolean loggedIn = false;
/*  9:   */   private String loginUrl;
/* 10:   */   private String logoutUrl;
/* 11:   */   private String emailAddress;
/* 12:   */   private String nickname;
/* 13:   */   
/* 14:   */   public boolean isLoggedIn()
/* 15:   */   {
/* 16:14 */     return this.loggedIn;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setLoggedIn(boolean loggedIn)
/* 20:   */   {
/* 21:18 */     this.loggedIn = loggedIn;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getLoginUrl()
/* 25:   */   {
/* 26:22 */     return this.loginUrl;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setLoginUrl(String loginUrl)
/* 30:   */   {
/* 31:26 */     this.loginUrl = loginUrl;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getLogoutUrl()
/* 35:   */   {
/* 36:30 */     return this.logoutUrl;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setLogoutUrl(String logoutUrl)
/* 40:   */   {
/* 41:34 */     this.logoutUrl = logoutUrl;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getEmailAddress()
/* 45:   */   {
/* 46:38 */     return this.emailAddress;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setEmailAddress(String emailAddress)
/* 50:   */   {
/* 51:42 */     this.emailAddress = emailAddress;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getNickname()
/* 55:   */   {
/* 56:46 */     return this.nickname;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setNickname(String nickname)
/* 60:   */   {
/* 61:50 */     this.nickname = nickname;
/* 62:   */   }
/* 63:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.client.LoginInfo
 * JD-Core Version:    0.7.0.1
 */