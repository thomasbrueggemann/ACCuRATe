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
   void method_31(ParcelFileDescriptor var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.games.internal.ConnectionInfo) void
   void method_32(ConnectionInfo var1) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, byte[], int) void
   void method_33(String var1, byte[] var2, int var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String[]) void
   void method_34(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: al (android.os.IBinder) void
   void method_35(IBinder var1) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, java.lang.String[]) void
   void method_36(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: bg (java.lang.String) void
   void method_37(String var1) throws RemoteException;

   // $FF: renamed from: bh (java.lang.String) void
   void method_38(String var1) throws RemoteException;

   // $FF: renamed from: bi (java.lang.String) void
   void method_39(String var1) throws RemoteException;

   // $FF: renamed from: bj (java.lang.String) void
   void method_40(String var1) throws RemoteException;

   // $FF: renamed from: bk (java.lang.String) void
   void method_41(String var1) throws RemoteException;

   // $FF: renamed from: bl (java.lang.String) void
   void method_42(String var1) throws RemoteException;

   // $FF: renamed from: bm (java.lang.String) void
   void method_43(String var1) throws RemoteException;

   // $FF: renamed from: c (int, int, java.lang.String) void
   void method_44(int var1, int var2, String var3) throws RemoteException;

   // $FF: renamed from: c (java.lang.String, java.lang.String[]) void
   void method_45(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: ck (int) void
   void method_46(int var1) throws RemoteException;

   // $FF: renamed from: d (java.lang.String, java.lang.String[]) void
   void method_47(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: e (java.lang.String, java.lang.String[]) void
   void method_48(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: f (java.lang.String, java.lang.String[]) void
   void method_49(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: g (java.lang.String, java.lang.String[]) void
   void method_50(String var1, String[] var2) throws RemoteException;

   // $FF: renamed from: hE () void
   void method_51() throws RemoteException;

   // $FF: renamed from: hF () void
   void method_52() throws RemoteException;

   void onP2PConnected(String var1) throws RemoteException;

   void onP2PDisconnected(String var1) throws RemoteException;

   // $FF: renamed from: t (java.lang.String, int) void
   void method_53(String var1, int var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IRoomServiceCallbacks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
      }

      // $FF: renamed from: am (android.os.IBinder) com.google.android.gms.games.internal.IRoomServiceCallbacks
      public static IRoomServiceCallbacks method_4515(IBinder var0) {
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
            this.bg(var2.readString());
            return true;
         case 1004:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bh(var2.readString());
            return true;
         case 1005:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bi(var2.readString());
            return true;
         case 1006:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bj(var2.readString());
            return true;
         case 1007:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bk(var2.readString());
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
            this.hE();
            return true;
         case 1017:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.g(var2.readString(), var2.createStringArray());
            return true;
         case 1018:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bl(var2.readString());
            return true;
         case 1019:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bm(var2.readString());
            return true;
         case 1020:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.ck(var2.readInt());
            return true;
         case 1021:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.al(var2.readStrongBinder());
            return true;
         case 1022:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            int var7 = var2.readInt();
            ConnectionInfo var8 = null;
            if(var7 != 0) {
               var8 = ConnectionInfo.CREATOR.method_4464(var2);
            }

            this.a(var8);
            return true;
         case 1023:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.hF();
            return true;
         case 1024:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            int var5 = var2.readInt();
            ParcelFileDescriptor var6 = null;
            if(var5 != 0) {
               var6 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var2.readInt());
            return true;
         case 1025:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.t(var2.readString(), var2.readInt());
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
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3893;

      Proxy(IBinder var1) {
         this.field_3893 = var1;
      }

      // $FF: renamed from: a (android.os.ParcelFileDescriptor, int) void
      public void method_31(ParcelFileDescriptor param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.games.internal.ConnectionInfo) void
      public void method_32(ConnectionInfo param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, byte[], int) void
      public void method_33(String var1, byte[] var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var4.writeString(var1);
            var4.writeByteArray(var2);
            var4.writeInt(var3);
            this.field_3893.transact(1002, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      // $FF: renamed from: a (java.lang.String, java.lang.String[]) void
      public void method_34(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1008, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: al (android.os.IBinder) void
      public void method_35(IBinder var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeStrongBinder(var1);
            this.field_3893.transact(1021, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_3893;
      }

      // $FF: renamed from: b (java.lang.String, java.lang.String[]) void
      public void method_36(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1009, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: bg (java.lang.String) void
      public void method_37(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1003, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bh (java.lang.String) void
      public void method_38(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1004, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bi (java.lang.String) void
      public void method_39(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1005, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bj (java.lang.String) void
      public void method_40(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1006, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bk (java.lang.String) void
      public void method_41(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1007, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bl (java.lang.String) void
      public void method_42(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1018, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bm (java.lang.String) void
      public void method_43(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1019, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: c (int, int, java.lang.String) void
      public void method_44(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.field_3893.transact(1001, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      // $FF: renamed from: c (java.lang.String, java.lang.String[]) void
      public void method_45(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1010, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: ck (int) void
      public void method_46(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeInt(var1);
            this.field_3893.transact(1020, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: d (java.lang.String, java.lang.String[]) void
      public void method_47(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1011, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: e (java.lang.String, java.lang.String[]) void
      public void method_48(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1012, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: f (java.lang.String, java.lang.String[]) void
      public void method_49(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1013, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: g (java.lang.String, java.lang.String[]) void
      public void method_50(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.field_3893.transact(1017, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: hE () void
      public void method_51() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.field_3893.transact(1016, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: hF () void
      public void method_52() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.field_3893.transact(1023, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void onP2PConnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1014, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void onP2PDisconnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.field_3893.transact(1015, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: t (java.lang.String, int) void
      public void method_53(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_3893.transact(1025, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
