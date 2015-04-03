/*  1:   */ package com.dsmallwood.kslclassifieds.server;
/*  2:   */ 
/*  3:   */ import com.google.gwt.user.client.rpc.IsSerializable;
/*  4:   */ import javax.jdo.JDOFatalInternalException;
/*  5:   */ import javax.jdo.PersistenceManager;
/*  6:   */ import javax.jdo.annotations.Extension;
/*  7:   */ import javax.jdo.annotations.IdGeneratorStrategy;
/*  8:   */ import javax.jdo.annotations.Persistent;
/*  9:   */ import javax.jdo.annotations.PrimaryKey;
/* 10:   */ import javax.jdo.identity.StringIdentity;
/* 11:   */ import javax.jdo.spi.JDOImplHelper;
/* 12:   */ import javax.jdo.spi.PersistenceCapable.ObjectIdFieldConsumer;
/* 13:   */ import javax.jdo.spi.PersistenceCapable.ObjectIdFieldSupplier;
/* 14:   */ import javax.jdo.spi.StateManager;
/* 15:   */ 
/* 16:   */ @javax.jdo.annotations.PersistenceCapable
/* 17:   */ public class NotificationCount
/* 18:   */   implements IsSerializable, javax.jdo.spi.PersistenceCapable
/* 19:   */ {
/* 20:   */   @PrimaryKey
/* 21:   */   @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
/* 22:   */   @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
/* 23:   */   private String key;
/* 24:   */   @Persistent
/* 25:   */   private int notificationCount;
/* 26:   */   protected transient StateManager jdoStateManager;
/* 27:   */   protected transient byte jdoFlags;
/* 28:   */   private static final byte[] jdoFieldFlags;
/* 29:   */   private static final Class jdoPersistenceCapableSuperclass;
/* 30:   */   private static final Class[] jdoFieldTypes;
/* 31:   */   private static final String[] jdoFieldNames = ;
/* 32:   */   private static final int jdoInheritedFieldCount;
/* 33:   */   
/* 34:   */   public static Class ___jdo$loadClass(String className)
/* 35:   */   {
/* 36:   */     try
/* 37:   */     {
/* 38: 8 */       return Class.forName(className);
/* 39:   */     }
/* 40:   */     catch (ClassNotFoundException e)
/* 41:   */     {
/* 42: 8 */       throw new NoClassDefFoundError(e.getMessage());
/* 43:   */     }
/* 44:   */   }
/* 45:   */   
/* 46:   */   public NotificationCount()
/* 47:   */   {
/* 48:24 */     setNotificationCount(1);
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setNotificationCount(int notificationCount)
/* 52:   */   {
/* 53:28 */     jdoSetnotificationCount(this, notificationCount);
/* 54:   */   }
/* 55:   */   
/* 56:   */   public int getNotificationCount()
/* 57:   */   {
/* 58:32 */     return jdoGetnotificationCount(this);
/* 59:   */   }
/* 60:   */   
/* 61:   */   static
/* 62:   */   {
/* 63:   */     jdoFieldTypes = __jdoFieldTypesInit();
/* 64:   */     jdoFieldFlags = __jdoFieldFlagsInit();
/* 65:   */     jdoInheritedFieldCount = __jdoGetInheritedFieldCount();
/* 66:   */     jdoPersistenceCapableSuperclass = __jdoPersistenceCapableSuperclassInit();
/* 67:   */     JDOImplHelper.registerClass(___jdo$loadClass("com.dsmallwood.kslclassifieds.server.NotificationCount"), jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new NotificationCount());
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid)
/* 71:   */   {
/* 72:   */     if (fc == null) {
/* 73:   */       throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
/* 74:   */     }
/* 75:   */     if (!(oid instanceof StringIdentity)) {
/* 76:   */       throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
/* 77:   */     }
/* 78:   */     StringIdentity o = (StringIdentity)oid;
/* 79:   */     fc.storeStringField(0, o.getKey());
/* 80:   */   }
/* 81:   */   
/* 82:   */   protected void jdoCopyKeyFieldsFromObjectId(Object oid)
/* 83:   */   {
/* 84:   */     if (!(oid instanceof StringIdentity)) {
/* 85:   */       throw new ClassCastException("key class is not javax.jdo.identity.StringIdentity or null");
/* 86:   */     }
/* 87:   */     StringIdentity o = (StringIdentity)oid;
/* 88:   */     this.key = o.getKey();
/* 89:   */   }
/* 90:   */   
/* 91:   */   public final void jdoCopyKeyFieldsToObjectId(Object oid)
/* 92:   */   {
/* 93:   */     throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
/* 94:   */   }
/* 95:   */   
/* 96:   */   public final void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier fs, Object paramObject)
/* 97:   */   {
/* 98:   */     throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
/* 99:   */   }
/* :0:   */   
/* :1:   */   public final Object jdoGetObjectId()
/* :2:   */   {
/* :3:   */     if (this.jdoStateManager != null) {
/* :4:   */       return this.jdoStateManager.getObjectId(this);
/* :5:   */     }
/* :6:   */     return null;
/* :7:   */   }
/* :8:   */   
/* :9:   */   public final Object jdoGetVersion()
/* ;0:   */   {
/* ;1:   */     if (this.jdoStateManager != null) {
/* ;2:   */       return this.jdoStateManager.getVersion(this);
/* ;3:   */     }
/* ;4:   */     return null;
/* ;5:   */   }
/* ;6:   */   
/* ;7:   */   protected final void jdoPreSerialize()
/* ;8:   */   {
/* ;9:   */     if (this.jdoStateManager != null) {
/* <0:   */       this.jdoStateManager.preSerialize(this);
/* <1:   */     }
/* <2:   */   }
/* <3:   */   
/* <4:   */   public final PersistenceManager jdoGetPersistenceManager()
/* <5:   */   {
/* <6:   */     return this.jdoStateManager != null ? this.jdoStateManager.getPersistenceManager(this) : null;
/* <7:   */   }
/* <8:   */   
/* <9:   */   public final Object jdoGetTransactionalObjectId()
/* =0:   */   {
/* =1:   */     return this.jdoStateManager != null ? this.jdoStateManager.getTransactionalObjectId(this) : null;
/* =2:   */   }
/* =3:   */   
/* =4:   */   public final boolean jdoIsDeleted()
/* =5:   */   {
/* =6:   */     return this.jdoStateManager != null ? this.jdoStateManager.isDeleted(this) : false;
/* =7:   */   }
/* =8:   */   
/* =9:   */   public final boolean jdoIsDirty()
/* >0:   */   {
/* >1:   */     if (this.jdoStateManager != null) {
/* >2:   */       return this.jdoStateManager.isDirty(this);
/* >3:   */     }
/* >4:   */     return false;
/* >5:   */   }
/* >6:   */   
/* >7:   */   public final boolean jdoIsNew()
/* >8:   */   {
/* >9:   */     return this.jdoStateManager != null ? this.jdoStateManager.isNew(this) : false;
/* ?0:   */   }
/* ?1:   */   
/* ?2:   */   public final boolean jdoIsPersistent()
/* ?3:   */   {
/* ?4:   */     return this.jdoStateManager != null ? this.jdoStateManager.isPersistent(this) : false;
/* ?5:   */   }
/* ?6:   */   
/* ?7:   */   public final boolean jdoIsTransactional()
/* ?8:   */   {
/* ?9:   */     return this.jdoStateManager != null ? this.jdoStateManager.isTransactional(this) : false;
/* @0:   */   }
/* @1:   */   
/* @2:   */   public void jdoMakeDirty(String fieldName)
/* @3:   */   {
/* @4:   */     if (this.jdoStateManager != null) {
/* @5:   */       this.jdoStateManager.makeDirty(this, fieldName);
/* @6:   */     }
/* @7:   */   }
/* @8:   */   
/* @9:   */   public final Object jdoNewObjectIdInstance()
/* A0:   */   {
/* A1:   */     return new StringIdentity(getClass(), this.key);
/* A2:   */   }
/* A3:   */   
/* A4:   */   public final Object jdoNewObjectIdInstance(Object key)
/* A5:   */   {
/* A6:   */     if (key == null) {
/* A7:   */       throw new IllegalArgumentException("key is null");
/* A8:   */     }
/* A9:   */     if (!(key instanceof String)) {
/* B0:   */       return new StringIdentity(getClass(), (String)key);
/* B1:   */     }
/* B2:   */     return new StringIdentity(getClass(), (String)key);
/* B3:   */   }
/* B4:   */   
/* B5:   */   public final void jdoProvideFields(int[] indices)
/* B6:   */   {
/* B7:   */     if (indices == null) {
/* B8:   */       throw new IllegalArgumentException("argment is null");
/* B9:   */     }
/* C0:   */     int i = indices.length - 1;
/* C1:   */     if (i >= 0) {
/* C2:   */       do
/* C3:   */       {
/* C4:   */         jdoProvideField(indices[i]);
/* C5:   */         i--;
/* C6:   */       } while (i >= 0);
/* C7:   */     }
/* C8:   */   }
/* C9:   */   
/* D0:   */   public final void jdoReplaceFields(int[] indices)
/* D1:   */   {
/* D2:   */     if (indices == null) {
/* D3:   */       throw new IllegalArgumentException("argument is null");
/* D4:   */     }
/* D5:   */     int i = indices.length;
/* D6:   */     if (i > 0)
/* D7:   */     {
/* D8:   */       int j = 0;
/* D9:   */       do
/* E0:   */       {
/* E1:   */         jdoReplaceField(indices[j]);
/* E2:   */         j++;
/* E3:   */       } while (j < i);
/* E4:   */     }
/* E5:   */   }
/* E6:   */   
/* E7:   */   public final void jdoReplaceFlags()
/* E8:   */   {
/* E9:   */     if (this.jdoStateManager != null) {
/* F0:   */       this.jdoFlags = this.jdoStateManager.replacingFlags(this);
/* F1:   */     }
/* F2:   */   }
/* F3:   */   
/* F4:   */   public final synchronized void jdoReplaceStateManager(StateManager sm)
/* F5:   */   {
/* F6:   */     if (this.jdoStateManager != null)
/* F7:   */     {
/* F8:   */       this.jdoStateManager = this.jdoStateManager.replacingStateManager(this, sm);
/* F9:   */     }
/* G0:   */     else
/* G1:   */     {
/* G2:   */       JDOImplHelper.checkAuthorizedStateManager(sm);
/* G3:   */       this.jdoStateManager = sm;
/* G4:   */       this.jdoFlags = 1;
/* G5:   */     }
/* G6:   */   }
/* G7:   */   
/* G8:   */   public boolean jdoIsDetached()
/* G9:   */   {
/* H0:   */     return false;
/* H1:   */   }
/* H2:   */   
/* H3:   */   public javax.jdo.spi.PersistenceCapable jdoNewInstance(StateManager sm)
/* H4:   */   {
/* H5:   */     NotificationCount result = new NotificationCount();
/* H6:   */     result.jdoFlags = 1;
/* H7:   */     result.jdoStateManager = sm;
/* H8:   */     return result;
/* H9:   */   }
/* I0:   */   
/* I1:   */   public javax.jdo.spi.PersistenceCapable jdoNewInstance(StateManager sm, Object obj)
/* I2:   */   {
/* I3:   */     NotificationCount result = new NotificationCount();
/* I4:   */     result.jdoFlags = 1;
/* I5:   */     result.jdoStateManager = sm;
/* I6:   */     result.jdoCopyKeyFieldsFromObjectId(obj);
/* I7:   */     return result;
/* I8:   */   }
/* I9:   */   
/* J0:   */   public void jdoReplaceField(int index)
/* J1:   */   {
/* J2:   */     if (this.jdoStateManager == null) {
/* J3:   */       throw new IllegalStateException("state manager is null");
/* J4:   */     }
/* J5:   */     switch (index)
/* J6:   */     {
/* J7:   */     case 0: 
/* J8:   */       this.key = this.jdoStateManager.replacingStringField(this, index);
/* J9:   */       break;
/* K0:   */     case 1: 
/* K1:   */       this.notificationCount = this.jdoStateManager.replacingIntField(this, index);
/* K2:   */       break;
/* K3:   */     default: 
/* K4:   */       throw new IllegalArgumentException("out of field index :" + index);
/* K5:   */     }
/* K6:   */   }
/* K7:   */   
/* K8:   */   public void jdoProvideField(int index)
/* K9:   */   {
/* L0:   */     if (this.jdoStateManager == null) {
/* L1:   */       throw new IllegalStateException("state manager is null");
/* L2:   */     }
/* L3:   */     switch (index)
/* L4:   */     {
/* L5:   */     case 0: 
/* L6:   */       this.jdoStateManager.providedStringField(this, index, this.key);
/* L7:   */       break;
/* L8:   */     case 1: 
/* L9:   */       this.jdoStateManager.providedIntField(this, index, this.notificationCount);
/* M0:   */       break;
/* M1:   */     default: 
/* M2:   */       throw new IllegalArgumentException("out of field index :" + index);
/* M3:   */     }
/* M4:   */   }
/* M5:   */   
/* M6:   */   protected final void jdoCopyField(NotificationCount obj, int index)
/* M7:   */   {
/* M8:   */     switch (index)
/* M9:   */     {
/* N0:   */     case 0: 
/* N1:   */       this.key = obj.key;
/* N2:   */       break;
/* N3:   */     case 1: 
/* N4:   */       this.notificationCount = obj.notificationCount;
/* N5:   */       break;
/* N6:   */     default: 
/* N7:   */       throw new IllegalArgumentException("out of field index :" + index);
/* N8:   */     }
/* N9:   */   }
/* O0:   */   
/* O1:   */   public void jdoCopyFields(Object obj, int[] indices)
/* O2:   */   {
/* O3:   */     if (this.jdoStateManager == null) {
/* O4:   */       throw new IllegalStateException("state manager is null");
/* O5:   */     }
/* O6:   */     if (indices == null) {
/* O7:   */       throw new IllegalStateException("fieldNumbers is null");
/* O8:   */     }
/* O9:   */     if (!(obj instanceof NotificationCount)) {
/* P0:   */       throw new IllegalArgumentException("object is not an object of type com.dsmallwood.kslclassifieds.server.NotificationCount");
/* P1:   */     }
/* P2:   */     NotificationCount other = (NotificationCount)obj;
/* P3:   */     if (this.jdoStateManager != other.jdoStateManager) {
/* P4:   */       throw new IllegalArgumentException("state managers do not match");
/* P5:   */     }
/* P6:   */     int i = indices.length - 1;
/* P7:   */     if (i >= 0) {
/* P8:   */       do
/* P9:   */       {
/* Q0:   */         jdoCopyField(other, indices[i]);
/* Q1:   */         i--;
/* Q2:   */       } while (i >= 0);
/* Q3:   */     }
/* Q4:   */   }
/* Q5:   */   
/* Q6:   */   private static final String[] __jdoFieldNamesInit()
/* Q7:   */   {
/* Q8:   */     return new String[] { "key", "notificationCount" };
/* Q9:   */   }
/* R0:   */   
/* R1:   */   private static final Class[] __jdoFieldTypesInit()
/* R2:   */   {
/* R3:   */     return new Class[] { ___jdo$loadClass("java.lang.String"), Integer.TYPE };
/* R4:   */   }
/* R5:   */   
/* R6:   */   private static final byte[] __jdoFieldFlagsInit()
/* R7:   */   {
/* R8:   */     return new byte[] { 24, 21 };
/* R9:   */   }
/* S0:   */   
/* S1:   */   protected static int __jdoGetInheritedFieldCount()
/* S2:   */   {
/* S3:   */     return 0;
/* S4:   */   }
/* S5:   */   
/* S6:   */   protected static int jdoGetManagedFieldCount()
/* S7:   */   {
/* S8:   */     return 2;
/* S9:   */   }
/* T0:   */   
/* T1:   */   private static Class __jdoPersistenceCapableSuperclassInit()
/* T2:   */   {
/* T3:   */     return null;
/* T4:   */   }
/* T5:   */   
/* T6:   */   private Object jdoSuperClone()
/* T7:   */     throws CloneNotSupportedException
/* T8:   */   {
/* T9:   */     NotificationCount o = (NotificationCount)super.clone();
/* U0:   */     o.jdoFlags = 0;
/* U1:   */     o.jdoStateManager = null;
/* U2:   */     return o;
/* U3:   */   }
/* U4:   */   
/* U5:   */   private static String jdoGetkey(NotificationCount objPC)
/* U6:   */   {
/* U7:   */     return objPC.key;
/* U8:   */   }
/* U9:   */   
/* V0:   */   private static void jdoSetkey(NotificationCount objPC, String val)
/* V1:   */   {
/* V2:   */     if (objPC.jdoStateManager == null) {
/* V3:   */       objPC.key = val;
/* V4:   */     } else {
/* V5:   */       objPC.jdoStateManager.setStringField(objPC, 0, objPC.key, val);
/* V6:   */     }
/* V7:   */   }
/* V8:   */   
/* V9:   */   private static int jdoGetnotificationCount(NotificationCount objPC)
/* W0:   */   {
/* W1:   */     if ((objPC.jdoFlags > 0) && (objPC.jdoStateManager != null) && (!objPC.jdoStateManager.isLoaded(objPC, 1))) {
/* W2:   */       return objPC.jdoStateManager.getIntField(objPC, 1, objPC.notificationCount);
/* W3:   */     }
/* W4:   */     return objPC.notificationCount;
/* W5:   */   }
/* W6:   */   
/* W7:   */   private static void jdoSetnotificationCount(NotificationCount objPC, int val)
/* W8:   */   {
/* W9:   */     if ((objPC.jdoFlags != 0) && (objPC.jdoStateManager != null)) {
/* X0:   */       objPC.jdoStateManager.setIntField(objPC, 1, objPC.notificationCount, val);
/* X1:   */     } else {
/* X2:   */       objPC.notificationCount = val;
/* X3:   */     }
/* X4:   */   }
/* X5:   */ }


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.server.NotificationCount
 * JD-Core Version:    0.7.0.1
 */