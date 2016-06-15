package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.games.internal.ConnectionInfo;

public interface IRoomServiceCallbacks extends IInterface {
   // $FF: renamed from: a (android.os.ParcelFileDescriptor, int) void
   void method_43(ParcelFileDescriptor var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.ConnectionInfo) void
   void method_44(ConnectionInfo var1) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, byte[], int) void
   void method_45(String var1, byte[] var2, int var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String[]) void
   void method_46(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: aG (android.os.IBinder) void
   void method_47(IBinder var1) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, java.lang.String[]) void
   void method_48(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: bS (java.lang.String) void
   void method_49(String var1) throws RemoteException;

   // $FF: renamed from: bT (java.lang.String) void
   void method_50(String var1) throws RemoteException;

   // $FF: renamed from: bU (java.lang.String) void
   void method_51(String var1) throws RemoteException;

   // $FF: renamed from: bV (java.lang.String) void
   void method_52(String var1) throws RemoteException;

   // $FF: renamed from: bW (java.lang.String) void
   void method_53(String var1) throws RemoteException;

   // $FF: renamed from: bX (java.lang.String) void
   void method_54(String var1) throws RemoteException;

   // $FF: renamed from: c (int, int, java.lang.String) void
   void method_55(int var1, int var2, String var3) throws RemoteException;

   // $FF: renamed from: c (java.lang.String, byte[]) void
   void method_56(String var1, byte[] var2) throws RemoteException;

   // $FF: renamed from: c (java.lang.String, java.lang.String[]) void
   void method_57(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: d (java.lang.String, java.lang.String[]) void
   void method_58(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: dX (int) void
   void method_59(int var1) throws RemoteException;

   // $FF: renamed from: e (java.lang.String, java.lang.String[]) void
   void method_60(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: f (java.lang.String, java.lang.String[]) void
   void method_61(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: g (java.lang.String, java.lang.String[]) void
   void method_62(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: j (java.lang.String, boolean) void
   void method_63(String var1, boolean var2) throws RemoteException;

   // $FF: renamed from: lR () void
   void method_64() throws RemoteException;

   // $FF: renamed from: lS () void
   void method_65() throws RemoteException;

   void onP2PConnected(String var1) throws RemoteException;

   void onP2PDisconnected(String var1) throws RemoteException;

   // $FF: renamed from: x (java.lang.String, int) void
   void method_66(String var1, int var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IRoomServiceCallbacks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
      }

      // $FF: renamed from: aH (android.os.IBinder) com.google.android.gms.games.internal.IRoomServiceCallbacks
      public static IRoomServiceCallbacks method_5780(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (IRoomServiceCallbacks)(var1 != null && var1 instanceof IRoomServiceCallbacks?(IRoomServiceCallbacks)var1:new IRoomServiceCallbacks.Proxy(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1001:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.c(var2.readInt(), var2.readInt(), var2.readString());
            return true;
         case 1002:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.a(var2.readString(), var2.createByteArray(), var2.readInt());
            return true;
         case 1003:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bS(var2.readString());
            return true;
         case 1004:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bT(var2.readString());
            return true;
         case 1005:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bU(var2.readString());
            return true;
         case 1006:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bV(var2.readString());
            return true;
         case 1007:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bW(var2.readString());
            return true;
         case 1008:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.a(var2.readString(), var2.createStringArray());
            return true;
         case 1009:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.b(var2.readString(), var2.createStringArray());
            return true;
         case 1010:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.c(var2.readString(), var2.createStringArray());
            return true;
         case 1011:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.d(var2.readString(), var2.createStringArray());
            return true;
         case 1012:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.e(var2.readString(), var2.createStringArray());
            return true;
         case 1013:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.f(var2.readString(), var2.createStringArray());
            return true;
         case 1014:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.onP2PConnected(var2.readString());
            return true;
         case 1015:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.onP2PDisconnected(var2.readString());
            return true;
         case 1016:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.lR();
            return true;
         case 1017:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.g(var2.readString(), var2.createStringArray());
            return true;
         case 1018:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.c(var2.readString(), var2.createByteArray());
            return true;
         case 1019:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bX(var2.readString());
            return true;
         case 1020:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.dX(var2.readInt());
            return true;
         case 1021:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.aG(var2.readStrongBinder());
            return true;
         case 1022:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            int var9 = var2.readInt();
            ConnectionInfo var10 = null;
            if(var9 != 0) {
               var10 = ConnectionInfo.CREATOR.method_5691(var2);
            }

            this.a(var10);
            return true;
         case 1023:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.lS();
            return true;
         case 1024:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            int var7 = var2.readInt();
            ParcelFileDescriptor var8 = null;
            if(var7 != 0) {
               var8 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            }

            this.a(var8, var2.readInt());
            return true;
         case 1025:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.x(var2.readString(), var2.readInt());
            return true;
         case 1026:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            String var5 = var2.readString();
            boolean var6;
            if(var2.readInt() != 0) {
               var6 = true;
            } else {
               var6 = false;
            }

            this.j(var5, var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IRoomServiceCallbacks {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3969;

      Proxy(IBinder var1) {
         this.field_3969 = var1;
      }

      // $FF: renamed from: a (android.os.ParcelFileDescriptor, int) void
      public void method_43(ParcelFileDescriptor param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.ConnectionInfo) void
      public void method_44(ConnectionInfo param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, byte[], int) void
      public void method_45(String var1, byte[] var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var4.writeString(var1);
            var4.writeByteArray(var2);
            var4.writeInt(var3);
            this.field_3969.transact(1002, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      // $FF: renamed from: a (java.lang.String, java.lang.String[]) void
      public void method_46(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1008, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: aG (android.os.IBinder) void
      public void method_47(IBinder var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeStrongBinder(var1);
            this.field_3969.transact(1021, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_3969;
      }

      // $FF: renamed from: b (java.lang.String, java.lang.String[]) void
      public void method_48(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1009, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: bS (java.lang.String) void
      public void method_49(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1003, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bT (java.lang.String) void
      public void method_50(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1004, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bU (java.lang.String) void
      public void method_51(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1005, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bV (java.lang.String) void
      public void method_52(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1006, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bW (java.lang.String) void
      public void method_53(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1007, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bX (java.lang.String) void
      public void method_54(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1019, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: c (int, int, java.lang.String) void
      public void method_55(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.field_3969.transact(1001, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      // $FF: renamed from: c (java.lang.String, byte[]) void
      public void method_56(String var1, byte[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeByteArray(var2);
            this.field_3969.transact(1018, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: c (java.lang.String, java.lang.String[]) void
      public void method_57(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1010, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: d (java.lang.String, java.lang.String[]) void
      public void method_58(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1011, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: dX (int) void
      public void method_59(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeInt(var1);
            this.field_3969.transact(1020, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: e (java.lang.String, java.lang.String[]) void
      public void method_60(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1012, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: f (java.lang.String, java.lang.String[]) void
      public void method_61(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1013, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: g (java.lang.String, java.lang.String[]) void
      public void method_62(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3969.transact(1017, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: j (java.lang.String, boolean) void
      public void method_63(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: lR () void
      public void method_64() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.field_3969.transact(1016, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: lS () void
      public void method_65() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.field_3969.transact(1023, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void onP2PConnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1014, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void onP2PDisconnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3969.transact(1015, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: x (java.lang.String, int) void
      public void method_66(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_3969.transact(1025, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
