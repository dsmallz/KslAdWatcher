/*  1:   */ package com.dsmallwood.kslclassifieds.server;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ 
/*  5:   */ public class AdWatcherListings
/*  6:   */ {
/*  7:   */   private AdWatcher adWatcher;
/*  8:   */   private ArrayList<Listing> listings;
/*  9:   */   
/* 10:   */   public AdWatcherListings(AdWatcher adWatcher, ArrayList<Listing> emailListings)
/* 11:   */   {
/* 12:11 */     this.adWatcher = adWatcher;
/* 13:12 */     this.listings = emailListings;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public void setAdWatcher(AdWatcher adWatcher)
/* 17:   */   {
/* 18:16 */     this.adWatcher = adWatcher;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public AdWatcher getAdWatcher()
/* 22:   */   {
/* 23:20 */     return this.adWatcher;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public ArrayList<Listing> getListings()
/* 27:   */   {
/* 28:25 */     return this.listings;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setListings(ArrayList<Listing> listings)
/* 32:   */   {
/* 33:30 */     this.listings = listings;
/* 34:   */   }
/* 35:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.AdWatcherListings
 * JD-Core Version:    0.7.0.1
 */