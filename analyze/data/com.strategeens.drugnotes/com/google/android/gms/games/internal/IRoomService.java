package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.IRoomServiceCallbacks;

public interface IRoomService extends IInterface {
   // $FF: renamed from: R (boolean) void
   void method_68(boolean var1) throws RemoteException;

   // $FF: renamed from: a (android.os.IBinder, com.google.android.gms.games.internal.IRoomServiceCallbacks) void
   void method_69(IBinder var1, IRoomServiceCallbacks var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, boolean) void
   void method_70(DataHolder var1, boolean var2) throws RemoteException;

   // $FF: renamed from: a (byte[], java.lang.String, int) void
   void method_71(byte[] var1, String var2, int var3) throws RemoteException;

   // $FF: renamed from: a (byte[], java.lang.String[]) void
   void method_72(byte[] var1, String[] var2) throws RemoteException;

   // $FF: renamed from: bQ (java.lang.String) void
   void method_73(String var1) throws RemoteException;

   // $FF: renamed from: bR (java.lang.String) void
   void method_74(String var1) throws RemoteException;

   // $FF: renamed from: c (java.lang.String, java.lang.String, java.lang.String) void
   void method_75(String var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: lN () void
   void method_76() throws RemoteException;

   // $FF: renamed from: lO () void
   void method_77() throws RemoteException;

   // $FF: renamed from: lP () void
   void method_78() throws RemoteException;

   // $FF: renamed from: lQ () void
   void method_79() throws RemoteException;

   // $FF: renamed from: v (java.lang.String, int) void
   void method_80(String var1, int var2) throws RemoteException;

   // $FF: renamed from: w (java.lang.String, int) void
   void method_81(String var1, int var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IRoomService {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1001:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.a(var2.readStrongBinder(), IRoomServiceCallbacks.Stub.method_5780(var2.readStrongBinder()));
            return true;
         case 1002:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lN();
            return true;
         case 1003:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lO();
            return true;
         case 1004:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.c(var2.readString(), var2.readString(), var2.readString());
            return true;
         case 1005:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lP();
            return true;
         case 1006:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            DataHolder var7;
            if(var2.readInt() != 0) {
               var7 = DataHolder.CREATOR.method_5394(var2);
            } else {
               var7 = null;
            }

            int var8 = var2.readInt();
            boolean var9 = false;
            if(var8 != 0) {
               var9 = true;
            }

            this.a(var7, var9);
            return true;
         case 1007:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lQ();
            return true;
         case 1008:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            int var5 = var2.readInt();
            boolean var6 = false;
            if(var5 != 0) {
               var6 = true;
            }

            this.R(var6);
            return true;
         case 1009:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.a(var2.createByteArray(), var2.readString(), var2.readInt());
            return true;
         case 1010:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.a(var2.createByteArray(), var2.createStringArray());
            return true;
         case 1011:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.v(var2.readString(), var2.readInt());
            return true;
         case 1012:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.w(var2.readString(), var2.readInt());
            return true;
         case 1013:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.bQ(var2.readString());
            return true;
         case 1014:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.bR(var2.readString());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IRoomService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IRoomService {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4216;

      // $FF: renamed from: R (boolean) void
      public void method_68(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.os.IBinder, com.google.android.gms.games.internal.IRoomServiceCallbacks) void
      public void method_69(IBinder param1, IRoomServiceCallbacks param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, boolean) void
      public void method_70(DataHolder param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (byte[], java.lang.String, int) void
      public void method_71(byte[] var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var4.writeByteArray(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.field_4216.transact(1009, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      // $FF: renamed from: a (byte[], java.lang.String[]) void
      public void method_72(byte[] var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var3.writeByteArray(var1);
            var3.writeStringArray(var2);
            this.field_4216.transact(1010, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_4216;
      }

      // $FF: renamed from: bQ (java.lang.String) void
      public void method_73(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var2.writeString(var1);
            this.field_4216.transact(1013, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: bR (java.lang.String) void
      public void method_74(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var2.writeString(var1);
            this.field_4216.transact(1014, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: c (java.lang.String, java.lang.String, java.lang.String) void
      public void method_75(String var1, String var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeString(var3);
            this.field_4216.transact(1004, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      // $FF: renamed from: lN () void
      public void method_76() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.field_4216.transact(1002, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: lO () void
      public void method_77() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.field_4216.transact(1003, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: lP () void
      public void method_78() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.field_4216.transact(1005, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: lQ () void
      public void method_79() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.field_4216.transact(1007, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: v (java.lang.String, int) void
      public void method_80(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4216.transact(1011, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      // $FF: renamed from: w (java.lang.String, int) void
      public void method_81(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.field_4216.transact(1012, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
