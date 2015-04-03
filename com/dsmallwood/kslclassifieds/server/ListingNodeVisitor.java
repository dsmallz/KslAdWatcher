/*  1:   */ package com.dsmallwood.kslclassifieds.server;
/*  2:   */ 
/*  3:   */ import org.htmlparser.visitors.NodeVisitor;
/*  4:   */ 
/*  5:   */ public class ListingNodeVisitor
/*  6:   */   extends NodeVisitor
/*  7:   */ {
/*  8:   */   public Listing adListing;
/*  9:   */   
/* 10:   */   public ListingNodeVisitor(boolean b) {}
/* 11:   */   
/* 12:   */   public void ListingNodeVisitor() {}
/* 13:   */   
/* 14:   */   public Listing getAdListings()
/* 15:   */   {
/* 16:33 */     return this.adListing;
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.ListingNodeVisitor
 * JD-Core Version:    0.7.0.1
 */