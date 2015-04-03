/*  1:   */ package com.dsmallwood.kslclassifieds.server;
/*  2:   */ 
/*  3:   */ import com.google.appengine.api.users.User;
/*  4:   */ import com.google.gwt.user.client.rpc.IsSerializable;
/*  5:   */ import java.util.Date;
/*  6:   */ import javax.jdo.JDOFatalInternalException;
/*  7:   */ import javax.jdo.PersistenceManager;
/*  8:   */ import javax.jdo.annotations.Persistent;
/*  9:   */ import javax.jdo.annotations.PrimaryKey;
/* 10:   */ import javax.jdo.identity.StringIdentity;
/* 11:   */ import javax.jdo.spi.JDOImplHelper;
/* 12:   */ import javax.jdo.spi.PersistenceCapable.ObjectIdFieldConsumer;
/* 13:   */ import javax.jdo.spi.PersistenceCapable.ObjectIdFieldSupplier;
/* 14:   */ import javax.jdo.spi.StateManager;
/* 15:   */ 
/* 16:   */ @javax.jdo.annotations.PersistenceCapable
/* 17:   */ public class AdWatcherUser
/* 18:   */   implements IsSerializable, javax.jdo.spi.PersistenceCapable
/* 19:   */ {
/* 20:   */   @Persistent
/* 21:   */   private User user;
/* 22:   */   @Persistent
/* 23:   */   private String username;
/* 24:   */   @PrimaryKey
/* 25:   */   @Persistent
/* 26:   */   private String email;
/* 27:   */   @Persistent
/* 28:   */   private Date lastlogin;
/* 29:   */   @Persistent
/* 30:   */   private Date createDate;
/* 31:   */   protected transient StateManager jdoStateManager;
/* 32:   */   protected transient byte jdoFlags;
/* 33:   */   private static final byte[] jdoFieldFlags;
/* 34:   */   private static final Class jdoPersistenceCapableSuperclass;
/* 35:   */   private static final Class[] jdoFieldTypes;
/* 36:   */   private static final String[] jdoFieldNames = ;
/* 37:   */   private static final int jdoInheritedFieldCount;
/* 38:   */   
/* 39:   */   public static Class ___jdo$loadClass(String className)
/* 40:   */   {
/* 41:   */     try
/* 42:   */     {
/* 43: 8 */       return Class.forName(className);
/* 44:   */     }
/* 45:   */     catch (ClassNotFoundException e)
/* 46:   */     {
/* 47: 8 */       throw new NoClassDefFoundError(e.getMessage());
/* 48:   */     }
/* 49:   */   }
/* 50:   */   
/* 51:   */   public AdWatcherUser(User user)
/* 52:   */   {
/* 53:34 */     setUser(user);
/* 54:35 */     this.email = user.getEmail();
/* 55:36 */     this.username = user.getNickname();
/* 56:37 */     this.createDate = new Date();
/* 57:38 */     this.lastlogin = new Date();
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setLastlogin(Date lastlogin)
/* 61:   */   {
/* 62:42 */     jdoSetlastlogin(this, lastlogin);
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Date getLastlogin()
/* 66:   */   {
/* 67:46 */     return jdoGetlastlogin(this);
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setCreateDate(Date createDate)
/* 71:   */   {
/* 72:50 */     jdoSetcreateDate(this, createDate);
/* 73:   */   }
/* 74:   */   
/* 75:   */   public Date getCreateDate()
/* 76:   */   {
/* 77:54 */     return jdoGetcreateDate(this);
/* 78:   */   }
/* 79:   */   
/* 80:   */   public void setEmail(String email)
/* 81:   */   {
/* 82:58 */     jdoSetemail(this, email);
/* 83:   */   }
/* 84:   */   
/* 85:   */   public String getEmail()
/* 86:   */   {
/* 87:62 */     return jdoGetemail(this);
/* 88:   */   }
/* 89:   */   
/* 90:   */   public void setUsername(String username)
/* 91:   */   {
/* 92:66 */     jdoSetusername(this, username);
/* 93:   */   }
/* 94:   */   
/* 95:   */   public String getUsername()
/* 96:   */   {
/* 97:70 */     return jdoGetusername(this);
/* 98:   */   }
/* 99:   */   
/* :0:   */   public void setUser(User user)
/* :1:   */   {
/* :2:74 */     jdoSetuser(this, user);
/* :3:   */   }
/* :4:   */   
/* :5:   */   public User getUser()
/* :6:   */   {
/* :7:78 */     return jdoGetuser(this);
/* :8:   */   }
/* :9:   */   
/* ;0:   */   static
/* ;1:   */   {
/* ;2:   */     jdoFieldTypes = __jdoFieldTypesInit();
/* ;3:   */     jdoFieldFlags = __jdoFieldFlagsInit();
/* ;4:   */     jdoInheritedFieldCount = __jdoGetInheritedFieldCount();
/* ;5:   */     jdoPersistenceCapableSuperclass = __jdoPersistenceCapableSuperclassInit();
/* ;6:   */     JDOImplHelper.registerClass(___jdo$loadClass("com.dsmallwood.kslclassifieds.server.AdWatcherUser"), jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new AdWatcherUser());
/* ;7:   */   }
/* ;8:   */   
/* ;9:   */   protected AdWatcherUser() {}
/* <0:   */   
/* <1:   */   public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid)
/* <2:   */   {
/* <3:   */     if (fc == null) {
/* <4:   */       throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
/* <5:   */     }
/* <6:   */     if (!(oid instanceof StringIdentity)) {
/* <7:   */       throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
/* <8:   */     }
/* <9:   */     StringIdentity o = (StringIdentity)oid;
/* =0:   */     fc.storeStringField(1, o.getKey());
/* =1:   */   }
/* =2:   */   
/* =3:   */   protected void jdoCopyKeyFieldsFromObjectId(Object oid)
/* =4:   */   {
/* =5:   */     if (!(oid instanceof StringIdentity)) {
/* =6:   */       throw new ClassCastException("key class is not javax.jdo.identity.StringIdentity or null");
/* =7:   */     }
/* =8:   */     StringIdentity o = (StringIdentity)oid;
/* =9:   */     this.email = o.getKey();
/* >0:   */   }
/* >1:   */   
/* >2:   */   public final void jdoCopyKeyFieldsToObjectId(Object oid)
/* >3:   */   {
/* >4:   */     throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
/* >5:   */   }
/* >6:   */   
/* >7:   */   public final void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier fs, Object paramObject)
/* >8:   */   {
/* >9:   */     throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
/* ?0:   */   }
/* ?1:   */   
/* ?2:   */   public final Object jdoGetObjectId()
/* ?3:   */   {
/* ?4:   */     if (this.jdoStateManager != null) {
/* ?5:   */       return this.jdoStateManager.getObjectId(this);
/* ?6:   */     }
/* ?7:   */     return null;
/* ?8:   */   }
/* ?9:   */   
/* @0:   */   public final Object jdoGetVersion()
/* @1:   */   {
/* @2:   */     if (this.jdoStateManager != null) {
/* @3:   */       return this.jdoStateManager.getVersion(this);
/* @4:   */     }
/* @5:   */     return null;
/* @6:   */   }
/* @7:   */   
/* @8:   */   protected final void jdoPreSerialize()
/* @9:   */   {
/* A0:   */     if (this.jdoStateManager != null) {
/* A1:   */       this.jdoStateManager.preSerialize(this);
/* A2:   */     }
/* A3:   */   }
/* A4:   */   
/* A5:   */   public final PersistenceManager jdoGetPersistenceManager()
/* A6:   */   {
/* A7:   */     return this.jdoStateManager != null ? this.jdoStateManager.getPersistenceManager(this) : null;
/* A8:   */   }
/* A9:   */   
/* B0:   */   public final Object jdoGetTransactionalObjectId()
/* B1:   */   {
/* B2:   */     return this.jdoStateManager != null ? this.jdoStateManager.getTransactionalObjectId(this) : null;
/* B3:   */   }
/* B4:   */   
/* B5:   */   public final boolean jdoIsDeleted()
/* B6:   */   {
/* B7:   */     return this.jdoStateManager != null ? this.jdoStateManager.isDeleted(this) : false;
/* B8:   */   }
/* B9:   */   
/* C0:   */   public final boolean jdoIsDirty()
/* C1:   */   {
/* C2:   */     if (this.jdoStateManager != null) {
/* C3:   */       return this.jdoStateManager.isDirty(this);
/* C4:   */     }
/* C5:   */     return false;
/* C6:   */   }
/* C7:   */   
/* C8:   */   public final boolean jdoIsNew()
/* C9:   */   {
/* D0:   */     return this.jdoStateManager != null ? this.jdoStateManager.isNew(this) : false;
/* D1:   */   }
/* D2:   */   
/* D3:   */   public final boolean jdoIsPersistent()
/* D4:   */   {
/* D5:   */     return this.jdoStateManager != null ? this.jdoStateManager.isPersistent(this) : false;
/* D6:   */   }
/* D7:   */   
/* D8:   */   public final boolean jdoIsTransactional()
/* D9:   */   {
/* E0:   */     return this.jdoStateManager != null ? this.jdoStateManager.isTransactional(this) : false;
/* E1:   */   }
/* E2:   */   
/* E3:   */   public void jdoMakeDirty(String fieldName)
/* E4:   */   {
/* E5:   */     if (this.jdoStateManager != null) {
/* E6:   */       this.jdoStateManager.makeDirty(this, fieldName);
/* E7:   */     }
/* E8:   */   }
/* E9:   */   
/* F0:   */   public final Object jdoNewObjectIdInstance()
/* F1:   */   {
/* F2:   */     return new StringIdentity(getClass(), this.email);
/* F3:   */   }
/* F4:   */   
/* F5:   */   public final Object jdoNewObjectIdInstance(Object key)
/* F6:   */   {
/* F7:   */     if (key == null) {
/* F8:   */       throw new IllegalArgumentException("key is null");
/* F9:   */     }
/* G0:   */     if (!(key instanceof String)) {
/* G1:   */       return new StringIdentity(getClass(), (String)key);
/* G2:   */     }
/* G3:   */     return new StringIdentity(getClass(), (String)key);
/* G4:   */   }
/* G5:   */   
/* G6:   */   public final void jdoProvideFields(int[] indices)
/* G7:   */   {
/* G8:   */     if (indices == null) {
/* G9:   */       throw new IllegalArgumentException("argment is null");
/* H0:   */     }
/* H1:   */     int i = indices.length - 1;
/* H2:   */     if (i >= 0) {
/* H3:   */       do
/* H4:   */       {
/* H5:   */         jdoProvideField(indices[i]);
/* H6:   */         i--;
/* H7:   */       } while (i >= 0);
/* H8:   */     }
/* H9:   */   }
/* I0:   */   
/* I1:   */   public final void jdoReplaceFields(int[] indices)
/* I2:   */   {
/* I3:   */     if (indices == null) {
/* I4:   */       throw new IllegalArgumentException("argument is null");
/* I5:   */     }
/* I6:   */     int i = indices.length;
/* I7:   */     if (i > 0)
/* I8:   */     {
/* I9:   */       int j = 0;
/* J0:   */       do
/* J1:   */       {
/* J2:   */         jdoReplaceField(indices[j]);
/* J3:   */         j++;
/* J4:   */       } while (j < i);
/* J5:   */     }
/* J6:   */   }
/* J7:   */   
/* J8:   */   public final void jdoReplaceFlags()
/* J9:   */   {
/* K0:   */     if (this.jdoStateManager != null) {
/* K1:   */       this.jdoFlags = this.jdoStateManager.replacingFlags(this);
/* K2:   */     }
/* K3:   */   }
/* K4:   */   
/* K5:   */   public final synchronized void jdoReplaceStateManager(StateManager sm)
/* K6:   */   {
/* K7:   */     if (this.jdoStateManager != null)
/* K8:   */     {
/* K9:   */       this.jdoStateManager = this.jdoStateManager.replacingStateManager(this, sm);
/* L0:   */     }
/* L1:   */     else
/* L2:   */     {
/* L3:   */       JDOImplHelper.checkAuthorizedStateManager(sm);
/* L4:   */       this.jdoStateManager = sm;
/* L5:   */       this.jdoFlags = 1;
/* L6:   */     }
/* L7:   */   }
/* L8:   */   
/* L9:   */   public boolean jdoIsDetached()
/* M0:   */   {
/* M1:   */     return false;
/* M2:   */   }
/* M3:   */   
/* M4:   */   public javax.jdo.spi.PersistenceCapable jdoNewInstance(StateManager sm)
/* M5:   */   {
/* M6:   */     AdWatcherUser result = new AdWatcherUser();
/* M7:   */     result.jdoFlags = 1;
/* M8:   */     result.jdoStateManager = sm;
/* M9:   */     return result;
/* N0:   */   }
/* N1:   */   
/* N2:   */   public javax.jdo.spi.PersistenceCapable jdoNewInstance(StateManager sm, Object obj)
/* N3:   */   {
/* N4:   */     AdWatcherUser result = new AdWatcherUser();
/* N5:   */     result.jdoFlags = 1;
/* N6:   */     result.jdoStateManager = sm;
/* N7:   */     result.jdoCopyKeyFieldsFromObjectId(obj);
/* N8:   */     return result;
/* N9:   */   }
/* O0:   */   
/* O1:   */   public void jdoReplaceField(int index)
/* O2:   */   {
/* O3:   */     if (this.jdoStateManager == null) {
/* O4:   */       throw new IllegalStateException("state manager is null");
/* O5:   */     }
/* O6:   */     switch (index)
/* O7:   */     {
/* O8:   */     case 0: 
/* O9:   */       this.createDate = ((Date)this.jdoStateManager.replacingObjectField(this, index));
/* P0:   */       break;
/* P1:   */     case 1: 
/* P2:   */       this.email = this.jdoStateManager.replacingStringField(this, index);
/* P3:   */       break;
/* P4:   */     case 2: 
/* P5:   */       this.lastlogin = ((Date)this.jdoStateManager.replacingObjectField(this, index));
/* P6:   */       break;
/* P7:   */     case 3: 
/* P8:   */       this.user = ((User)this.jdoStateManager.replacingObjectField(this, index));
/* P9:   */       break;
/* Q0:   */     case 4: 
/* Q1:   */       this.username = this.jdoStateManager.replacingStringField(this, index);
/* Q2:   */       break;
/* Q3:   */     default: 
/* Q4:   */       throw new IllegalArgumentException("out of field index :" + index);
/* Q5:   */     }
/* Q6:   */   }
/* Q7:   */   
/* Q8:   */   public void jdoProvideField(int index)
/* Q9:   */   {
/* R0:   */     if (this.jdoStateManager == null) {
/* R1:   */       throw new IllegalStateException("state manager is null");
/* R2:   */     }
/* R3:   */     switch (index)
/* R4:   */     {
/* R5:   */     case 0: 
/* R6:   */       this.jdoStateManager.providedObjectField(this, index, this.createDate);
/* R7:   */       break;
/* R8:   */     case 1: 
/* R9:   */       this.jdoStateManager.providedStringField(this, index, this.email);
/* S0:   */       break;
/* S1:   */     case 2: 
/* S2:   */       this.jdoStateManager.providedObjectField(this, index, this.lastlogin);
/* S3:   */       break;
/* S4:   */     case 3: 
/* S5:   */       this.jdoStateManager.providedObjectField(this, index, this.user);
/* S6:   */       break;
/* S7:   */     case 4: 
/* S8:   */       this.jdoStateManager.providedStringField(this, index, this.username);
/* S9:   */       break;
/* T0:   */     default: 
/* T1:   */       throw new IllegalArgumentException("out of field index :" + index);
/* T2:   */     }
/* T3:   */   }
/* T4:   */   
/* T5:   */   protected final void jdoCopyField(AdWatcherUser obj, int index)
/* T6:   */   {
/* T7:   */     switch (index)
/* T8:   */     {
/* T9:   */     case 0: 
/* U0:   */       this.createDate = obj.createDate;
/* U1:   */       break;
/* U2:   */     case 1: 
/* U3:   */       this.email = obj.email;
/* U4:   */       break;
/* U5:   */     case 2: 
/* U6:   */       this.lastlogin = obj.lastlogin;
/* U7:   */       break;
/* U8:   */     case 3: 
/* U9:   */       this.user = obj.user;
/* V0:   */       break;
/* V1:   */     case 4: 
/* V2:   */       this.username = obj.username;
/* V3:   */       break;
/* V4:   */     default: 
/* V5:   */       throw new IllegalArgumentException("out of field index :" + index);
/* V6:   */     }
/* V7:   */   }
/* V8:   */   
/* V9:   */   public void jdoCopyFields(Object obj, int[] indices)
/* W0:   */   {
/* W1:   */     if (this.jdoStateManager == null) {
/* W2:   */       throw new IllegalStateException("state manager is null");
/* W3:   */     }
/* W4:   */     if (indices == null) {
/* W5:   */       throw new IllegalStateException("fieldNumbers is null");
/* W6:   */     }
/* W7:   */     if (!(obj instanceof AdWatcherUser)) {
/* W8:   */       throw new IllegalArgumentException("object is not an object of type com.dsmallwood.kslclassifieds.server.AdWatcherUser");
/* W9:   */     }
/* X0:   */     AdWatcherUser other = (AdWatcherUser)obj;
/* X1:   */     if (this.jdoStateManager != other.jdoStateManager) {
/* X2:   */       throw new IllegalArgumentException("state managers do not match");
/* X3:   */     }
/* X4:   */     int i = indices.length - 1;
/* X5:   */     if (i >= 0) {
/* X6:   */       do
/* X7:   */       {
/* X8:   */         jdoCopyField(other, indices[i]);
/* X9:   */         i--;
/* Y0:   */       } while (i >= 0);
/* Y1:   */     }
/* Y2:   */   }
/* Y3:   */   
/* Y4:   */   private static final String[] __jdoFieldNamesInit()
/* Y5:   */   {
/* Y6:   */     return new String[] { "createDate", "email", "lastlogin", "user", "username" };
/* Y7:   */   }
/* Y8:   */   
/* Y9:   */   private static final Class[] __jdoFieldTypesInit()
/* Z0:   */   {
/* Z1:   */     return new Class[] { ___jdo$loadClass("java.util.Date"), ___jdo$loadClass("java.lang.String"), ___jdo$loadClass("java.util.Date"), ___jdo$loadClass("com.google.appengine.api.users.User"), ___jdo$loadClass("java.lang.String") };
/* Z2:   */   }
/* Z3:   */   
/* Z4:   */   private static final byte[] __jdoFieldFlagsInit()
/* Z5:   */   {
/* Z6:   */     return new byte[] { 21, 24, 21, 21, 21 };
/* Z7:   */   }
/* Z8:   */   
/* Z9:   */   protected static int __jdoGetInheritedFieldCount()
/* [0:   */   {
/* [1:   */     return 0;
/* [2:   */   }
/* [3:   */   
/* [4:   */   protected static int jdoGetManagedFieldCount()
/* [5:   */   {
/* [6:   */     return 5;
/* [7:   */   }
/* [8:   */   
/* [9:   */   private static Class __jdoPersistenceCapableSuperclassInit()
/* \0:   */   {
/* \1:   */     return null;
/* \2:   */   }
/* \3:   */   
/* \4:   */   private Object jdoSuperClone()
/* \5:   */     throws CloneNotSupportedException
/* \6:   */   {
/* \7:   */     AdWatcherUser o = (AdWatcherUser)super.clone();
/* \8:   */     o.jdoFlags = 0;
/* \9:   */     o.jdoStateManager = null;
/* ]0:   */     return o;
/* ]1:   */   }
/* ]2:   */   
/* ]3:   */   private static Date jdoGetcreateDate(AdWatcherUser objPC)
/* ]4:   */   {
/* ]5:   */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 0))) {
/* ]6:   */       return (Date)objPC.jdoStateManager.getObjectField(objPC, 0, objPC.createDate);
/* ]7:   */     }
/* ]8:   */     return objPC.createDate;
/* ]9:   */   }
/* ^0:   */   
/* ^1:   */   private static void jdoSetcreateDate(AdWatcherUser objPC, Date val)
/* ^2:   */   {
/* ^3:   */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* ^4:   */       objPC.jdoStateManager.setObjectField(objPC, 0, objPC.createDate, val);
/* ^5:   */     } else {
/* ^6:   */       objPC.createDate = val;
/* ^7:   */     }
/* ^8:   */   }
/* ^9:   */   
/* _0:   */   private static String jdoGetemail(AdWatcherUser objPC)
/* _1:   */   {
/* _2:   */     return objPC.email;
/* _3:   */   }
/* _4:   */   
/* _5:   */   private static void jdoSetemail(AdWatcherUser objPC, String val)
/* _6:   */   {
/* _7:   */     if (objPC.jdoStateManager == null) {
/* _8:   */       objPC.email = val;
/* _9:   */     } else {
/* `0:   */       objPC.jdoStateManager.setStringField(objPC, 1, objPC.email, val);
/* `1:   */     }
/* `2:   */   }
/* `3:   */   
/* `4:   */   private static Date jdoGetlastlogin(AdWatcherUser objPC)
/* `5:   */   {
/* `6:   */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 2))) {
/* `7:   */       return (Date)objPC.jdoStateManager.getObjectField(objPC, 2, objPC.lastlogin);
/* `8:   */     }
/* `9:   */     return objPC.lastlogin;
/* a0:   */   }
/* a1:   */   
/* a2:   */   private static void jdoSetlastlogin(AdWatcherUser objPC, Date val)
/* a3:   */   {
/* a4:   */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* a5:   */       objPC.jdoStateManager.setObjectField(objPC, 2, objPC.lastlogin, val);
/* a6:   */     } else {
/* a7:   */       objPC.lastlogin = val;
/* a8:   */     }
/* a9:   */   }
/* b0:   */   
/* b1:   */   private static User jdoGetuser(AdWatcherUser objPC)
/* b2:   */   {
/* b3:   */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 3))) {
/* b4:   */       return (User)objPC.jdoStateManager.getObjectField(objPC, 3, objPC.user);
/* b5:   */     }
/* b6:   */     return objPC.user;
/* b7:   */   }
/* b8:   */   
/* b9:   */   private static void jdoSetuser(AdWatcherUser objPC, User val)
/* c0:   */   {
/* c1:   */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* c2:   */       objPC.jdoStateManager.setObjectField(objPC, 3, objPC.user, val);
/* c3:   */     } else {
/* c4:   */       objPC.user = val;
/* c5:   */     }
/* c6:   */   }
/* c7:   */   
/* c8:   */   private static String jdoGetusername(AdWatcherUser objPC)
/* c9:   */   {
/* d0:   */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 4))) {
/* d1:   */       return objPC.jdoStateManager.getStringField(objPC, 4, objPC.username);
/* d2:   */     }
/* d3:   */     return objPC.username;
/* d4:   */   }
/* d5:   */   
/* d6:   */   private static void jdoSetusername(AdWatcherUser objPC, String val)
/* d7:   */   {
/* d8:   */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* d9:   */       objPC.jdoStateManager.setStringField(objPC, 4, objPC.username, val);
/* e0:   */     } else {
/* e1:   */       objPC.username = val;
/* e2:   */     }
/* e3:   */   }
/* e4:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.AdWatcherUser
 * JD-Core Version:    0.7.0.1
 */