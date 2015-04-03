/*  1:   */ package com.dsmallwood.kslclassifieds.shared;
/*  2:   */ 
/*  3:   */ public class FieldVerifier
/*  4:   */ {
/*  5:   */   public static boolean isValidName(String name)
/*  6:   */   {
/*  7:37 */     if (name == null) {
/*  8:38 */       return false;
/*  9:   */     }
/* 10:40 */     return name.length() > 3;
/* 11:   */   }
/* 12:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.shared.FieldVerifier
 * JD-Core Version:    0.7.0.1
 */