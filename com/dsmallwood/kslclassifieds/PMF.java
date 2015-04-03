/*  1:   */ package com.dsmallwood.kslclassifieds;
/*  2:   */ 
/*  3:   */ import javax.jdo.JDOHelper;
/*  4:   */ import javax.jdo.PersistenceManagerFactory;
/*  5:   */ 
/*  6:   */ public final class PMF
/*  7:   */ {
/*  8: 8 */   private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");
/*  9:   */   
/* 10:   */   public static PersistenceManagerFactory get()
/* 11:   */   {
/* 12:13 */     return pmfInstance;
/* 13:   */   }
/* 14:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.PMF
 * JD-Core Version:    0.7.0.1
 */