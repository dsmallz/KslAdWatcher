/*   1:    */ package com.dsmallwood.kslclassifieds.server;
/*   2:    */ 
/*   3:    */ import com.dsmallwood.kslclassifieds.PMF;
/*   4:    */ import com.dsmallwood.kslclassifieds.client.AdWatcherService;
/*   5:    */ import com.dsmallwood.kslclassifieds.shared.AdWatcherDTO;
/*   6:    */ import com.dsmallwood.kslclassifieds.shared.FieldVerifier;
/*   7:    */ import com.google.appengine.api.users.User;
/*   8:    */ import com.google.appengine.api.users.UserService;
/*   9:    */ import com.google.appengine.api.users.UserServiceFactory;
/*  10:    */ import com.google.gwt.user.server.rpc.RemoteServiceServlet;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.Date;
/*  13:    */ import java.util.Iterator;
/*  14:    */ import java.util.List;
/*  15:    */ import javax.jdo.PersistenceManager;
/*  16:    */ import javax.jdo.PersistenceManagerFactory;
/*  17:    */ import javax.jdo.Query;
/*  18:    */ import javax.jdo.Transaction;
/*  19:    */ import javax.servlet.ServletContext;
/*  20:    */ import javax.servlet.http.HttpServletRequest;
/*  21:    */ 
/*  22:    */ public class AdWatcherServiceImpl
/*  23:    */   extends RemoteServiceServlet
/*  24:    */   implements AdWatcherService
/*  25:    */ {
/*  26:    */   public String addAdWatcher(AdWatcherDTO adWatcherDTO)
/*  27:    */     throws IllegalArgumentException
/*  28:    */   {
/*  29: 31 */     if (!FieldVerifier.isValidName(adWatcherDTO.getKeywords())) {
/*  30: 34 */       throw new IllegalArgumentException(
/*  31: 35 */         "Name must be at least 4 characters long");
/*  32:    */     }
/*  33: 38 */     String serverInfo = getServletContext().getServerInfo();
/*  34: 39 */     String userAgent = getThreadLocalRequest().getHeader("User-Agent");
/*  35:    */     
/*  36:    */ 
/*  37:    */ 
/*  38: 43 */     userAgent = escapeHtml(userAgent);
/*  39:    */     
/*  40: 45 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/*  41: 46 */     Transaction tx = pm.currentTransaction();
/*  42: 47 */     tx.begin();
/*  43:    */     String key;
/*  44:    */     try
/*  45:    */     {
/*  46: 51 */       AdWatcher adWatcher = new AdWatcher(adWatcherDTO.getKeywords(), adWatcherDTO.getZip(), adWatcherDTO.getMiles(), 
/*  47: 52 */         adWatcherDTO.getMinPrice(), adWatcherDTO.getMaxPrice(), adWatcherDTO.getSeller(), adWatcherDTO.getUrl(), 
/*  48: 53 */         adWatcherDTO.getNotificationTime(), adWatcherDTO.isNotifyEmail(), adWatcherDTO.isNotifySMS());
/*  49: 54 */       adWatcher.setCreateDate(new Date());
/*  50: 55 */       adWatcher.setUser(getUser());
/*  51: 56 */       pm.makePersistent(adWatcher);
/*  52: 57 */       tx.commit();
/*  53: 58 */       key = adWatcher.getKey();
/*  54:    */     }
/*  55:    */     finally
/*  56:    */     {
/*  57:    */       String key;
/*  58: 62 */       if (tx.isActive()) {
/*  59: 64 */         tx.rollback();
/*  60:    */       }
/*  61: 66 */       pm.close();
/*  62:    */     }
/*  63: 69 */     return key;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public ArrayList<AdWatcherDTO> getAdWatcherList()
/*  67:    */   {
/*  68: 73 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/*  69: 74 */     Transaction tx = pm.currentTransaction();
/*  70:    */     
/*  71: 76 */     tx.begin();
/*  72: 77 */     Query q = pm.newQuery(AdWatcher.class, "user == u");
/*  73: 78 */     q.declareParameters("com.google.appengine.api.users.User u");
/*  74: 79 */     q.setOrdering("createDate");
/*  75:    */     
/*  76: 81 */     List results = (List)q.execute(getUser());
/*  77:    */     
/*  78: 83 */     ArrayList<AdWatcherDTO> adWatcherListDTOs = new ArrayList(results != null ? results.size() : 0);
/*  79: 84 */     if ((results != null) && (results.size() > 0))
/*  80:    */     {
/*  81: 86 */       Iterator iter = results.iterator();
/*  82: 87 */       while (iter.hasNext())
/*  83:    */       {
/*  84: 89 */         AdWatcher tempAdWatcher = (AdWatcher)iter.next();
/*  85: 90 */         adWatcherListDTOs.add(createAdWatcherDTO(tempAdWatcher));
/*  86:    */       }
/*  87:    */     }
/*  88: 93 */     tx.commit();
/*  89: 94 */     return adWatcherListDTOs;
/*  90:    */   }
/*  91:    */   
/*  92:    */   private AdWatcherDTO createAdWatcherDTO(AdWatcher adWatcher)
/*  93:    */   {
/*  94: 98 */     return new AdWatcherDTO(adWatcher.getKeywords(), adWatcher.getZip(), adWatcher.getMiles(), adWatcher.getMinPrice(), adWatcher.getMaxPrice(), adWatcher.getSeller(), adWatcher.getKey(), adWatcher.getUrl(), 
/*  95: 99 */       adWatcher.getNotificationTime(), adWatcher.isNotifyEmail(), adWatcher.isNotifySMS());
/*  96:    */   }
/*  97:    */   
/*  98:    */   private AdWatcher createAdWatcher(AdWatcherDTO adWatcherDTO)
/*  99:    */   {
/* 100:104 */     return new AdWatcher(adWatcherDTO.getKeywords(), adWatcherDTO.getZip(), adWatcherDTO.getMiles(), 
/* 101:105 */       adWatcherDTO.getMinPrice(), adWatcherDTO.getMaxPrice(), adWatcherDTO.getSeller(), adWatcherDTO.getKey(), adWatcherDTO.getUrl(), 
/* 102:106 */       adWatcherDTO.getNotificationTime(), adWatcherDTO.isNotifyEmail(), adWatcherDTO.isNotifySMS());
/* 103:    */   }
/* 104:    */   
/* 105:    */   private User getUser()
/* 106:    */   {
/* 107:109 */     UserService userService = UserServiceFactory.getUserService();
/* 108:110 */     return userService.getCurrentUser();
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void removeAdWatcherListItem(String key)
/* 112:    */   {
/* 113:115 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/* 114:116 */     Transaction tx = pm.currentTransaction();
/* 115:117 */     tx.begin();
/* 116:    */     
/* 117:119 */     Query newQuery = pm.newQuery(AdWatcher.class, "key == \"" + key + "\"");
/* 118:120 */     List<AdWatcher> adWatcher = (List)pm.newQuery(newQuery).execute();
/* 119:122 */     if (adWatcher.size() != 0)
/* 120:    */     {
/* 121:128 */       AdWatcher toBeDeleted = (AdWatcher)adWatcher.iterator().next();
/* 122:129 */       pm.deletePersistent(toBeDeleted);
/* 123:130 */       tx.commit();
/* 124:131 */       pm.close();
/* 125:    */     }
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void editAdWatcherListItem(String key, AdWatcherDTO adWatcherDTO)
/* 129:    */   {
/* 130:137 */     PersistenceManager pm = PMF.get().getPersistenceManager();
/* 131:138 */     Transaction tx = pm.currentTransaction();
/* 132:139 */     tx.begin();
/* 133:    */     
/* 134:141 */     Query newQuery = pm.newQuery(AdWatcher.class, "key == \"" + key + "\"");
/* 135:142 */     List<AdWatcher> adWatcher = (List)pm.newQuery(newQuery).execute();
/* 136:144 */     if (adWatcher.size() != 0)
/* 137:    */     {
/* 138:150 */       AdWatcher toBeUpdated = (AdWatcher)adWatcher.iterator().next();
/* 139:151 */       AdWatcher toBeSaved = createAdWatcher(adWatcherDTO);
/* 140:152 */       toBeSaved.setCreateDate(toBeUpdated.getCreateDate());
/* 141:153 */       toBeSaved.setUser(toBeUpdated.getUser());
/* 142:154 */       pm.makePersistent(toBeSaved);
/* 143:155 */       tx.commit();
/* 144:156 */       pm.close();
/* 145:    */     }
/* 146:    */   }
/* 147:    */   
/* 148:    */   private String escapeHtml(String html)
/* 149:    */   {
/* 150:170 */     if (html == null) {
/* 151:171 */       return null;
/* 152:    */     }
/* 153:173 */     return 
/* 154:174 */       html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
/* 155:    */   }
/* 156:    */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.AdWatcherServiceImpl
 * JD-Core Version:    0.7.0.1
 */