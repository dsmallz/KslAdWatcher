/*  1:   */ package com.dsmallwood.kslclassifieds.server;
/*  2:   */ 
/*  3:   */ import com.dsmallwood.kslclassifieds.PMF;
/*  4:   */ import com.dsmallwood.kslclassifieds.client.LoginInfo;
/*  5:   */ import com.dsmallwood.kslclassifieds.client.LoginService;
/*  6:   */ import com.google.appengine.api.users.User;
/*  7:   */ import com.google.appengine.api.users.UserService;
/*  8:   */ import com.google.appengine.api.users.UserServiceFactory;
/*  9:   */ import com.google.gwt.user.server.rpc.RemoteServiceServlet;
/* 10:   */ import java.util.Date;
/* 11:   */ import java.util.List;
/* 12:   */ import javax.jdo.PersistenceManager;
/* 13:   */ import javax.jdo.PersistenceManagerFactory;
/* 14:   */ import javax.jdo.Query;
/* 15:   */ import javax.jdo.Transaction;
/* 16:   */ 
/* 17:   */ public class LoginServiceImpl
/* 18:   */   extends RemoteServiceServlet
/* 19:   */   implements LoginService
/* 20:   */ {
/* 21:   */   public LoginInfo login(String requestUri)
/* 22:   */   {
/* 23:22 */     UserService userService = UserServiceFactory.getUserService();
/* 24:23 */     User user = userService.getCurrentUser();
/* 25:24 */     LoginInfo loginInfo = new LoginInfo();
/* 26:26 */     if (user != null)
/* 27:   */     {
/* 28:27 */       loginInfo.setLoggedIn(true);
/* 29:28 */       loginInfo.setEmailAddress(user.getEmail());
/* 30:29 */       loginInfo.setNickname(user.getNickname());
/* 31:30 */       loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
/* 32:31 */       storeAdWatchUser(user);
/* 33:   */     }
/* 34:   */     else
/* 35:   */     {
/* 36:33 */       loginInfo.setLoggedIn(false);
/* 37:34 */       loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
/* 38:   */     }
/* 39:36 */     return loginInfo;
/* 40:   */   }
/* 41:   */   
/* 42:   */   private void storeAdWatchUser(User user)
/* 43:   */   {
/* 44:40 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/* 45:41 */     Transaction tx = pm.currentTransaction();
/* 46:42 */     tx.begin();
/* 47:   */     
/* 48:44 */     Query q = pm.newQuery(AdWatcherUser.class, "user == u");
/* 49:45 */     q.declareParameters("com.google.appengine.api.users.User u");
/* 50:46 */     List results = (List)q.execute(user);
/* 51:   */     try
/* 52:   */     {
/* 53:49 */       if (results.size() < 1)
/* 54:   */       {
/* 55:51 */         pm.makePersistent(new AdWatcherUser(user));
/* 56:   */       }
/* 57:   */       else
/* 58:   */       {
/* 59:55 */         AdWatcherUser adWatcherUser = (AdWatcherUser)results.get(0);
/* 60:56 */         adWatcherUser.setLastlogin(new Date());
/* 61:   */       }
/* 62:58 */       tx.commit();
/* 63:   */     }
/* 64:   */     finally
/* 65:   */     {
/* 66:60 */       if (tx.isActive()) {
/* 67:62 */         tx.rollback();
/* 68:   */       }
/* 69:64 */       pm.close();
/* 70:   */     }
/* 71:   */   }
/* 72:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.LoginServiceImpl
 * JD-Core Version:    0.7.0.1
 */