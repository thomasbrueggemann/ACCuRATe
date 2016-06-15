package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

// $FF: renamed from: com.google.android.gms.internal.iq
public interface class_14 extends IInterface {
   // $FF: renamed from: a (double, double, boolean) void
   void method_86(double var1, double var3, boolean var5) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions) void
   void method_87(String var1, LaunchOptions var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String, long) void
   void method_88(String var1, String var2, long var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, byte[], long) void
   void method_89(String var1, byte[] var2, long var3) throws RemoteException;

   // $FF: renamed from: a (boolean, double, boolean) void
   void method_90(boolean var1, double var2, boolean var4) throws RemoteException;

   // $FF: renamed from: aH (java.lang.String) void
   void method_91(String var1) throws RemoteException;

   // $FF: renamed from: aI (java.lang.String) void
   void method_92(String var1) throws RemoteException;

   // $FF: renamed from: aJ (java.lang.String) void
   void method_93(String var1) throws RemoteException;

   void disconnect() throws RemoteException;

   // $FF: renamed from: fY () void
   void method_94() throws RemoteException;

   // $FF: renamed from: g (java.lang.String, boolean) void
   void method_95(String var1, boolean var2) throws RemoteException;

   // $FF: renamed from: gl () void
   void method_96() throws RemoteException;

   // $FF: renamed from: k (java.lang.String, java.lang.String) void
   void method_97(String var1, String var2) throws RemoteException;

   public abstract static class class_1402 extends Binder implements class_14 {
      // $FF: renamed from: M (android.os.IBinder) com.google.android.gms.internal.iq
      public static class_14 method_5444(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (class_14)(var1 != null && var1 instanceof class_14?(class_14)var1:new class_14.class_1403(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.disconnect();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            String var17 = var2.readString();
            int var18 = var2.readInt();
            boolean var19 = false;
            if(var18 != 0) {
               var19 = true;
            }

            this.g(var17, var19);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.k(var2.readString(), var2.readString());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.gl();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.aH(var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.fY();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            double var12 = var2.readDouble();
            double var14 = var2.readDouble();
            boolean var16;
            if(var2.readInt() != 0) {
               var16 = true;
            } else {
               var16 = false;
            }

            this.a(var12, var14, var16);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            boolean var7;
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            double var8 = var2.readDouble();
            int var10 = var2.readInt();
            boolean var11 = false;
            if(var10 != 0) {
               var11 = true;
            }

            this.a(var7, var8, var11);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.a(var2.readString(), var2.readString(), var2.readLong());
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.a(var2.readString(), var2.createByteArray(), var2.readLong());
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.aI(var2.readString());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.aJ(var2.readString());
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            String var5 = var2.readString();
            LaunchOptions var6;
            if(var2.readInt() != 0) {
               var6 = (LaunchOptions)LaunchOptions.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.a(var5, var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1403 implements class_14 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4424;

      class_1403(IBinder var1) {
         this.field_4424 = var1;
      }

      // $FF: renamed from: a (double, double, boolean) void
      public void method_86(double param1, double param3, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions) void
      public void method_87(String param1, LaunchOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, java.lang.String, long) void
      public void method_88(String var1, String var2, long var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var5.writeString(var1);
            var5.writeString(var2);
            var5.writeLong(var3);
            this.field_4424.transact(9, var5, (Parcel)null, 1);
         } finally {
            var5.recycle();
         }

      }

      // $FF: renamed from: a (java.lang.String, byte[], long) void
      public void method_89(String var1, byte[] var2, long var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var5.writeString(var1);
            var5.writeByteArray(var2);
            var5.writeLong(var3);
            this.field_4424.transact(10, var5, (Parcel)null, 1);
         } finally {
            var5.recycle();
         }

      }

      // $FF: renamed from: a (boolean, double, boolean) void
      public void method_90(boolean param1, double param2, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: aH (java.lang.String) void
      public void method_91(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.field_4424.transact(5, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: aI (java.lang.String) void
      public void method_92(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.field_4424.transact(11, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: aJ (java.lang.String) void
      public void method_93(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.field_4424.transact(12, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_4424;
      }

      public void disconnect() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.field_4424.transact(1, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: fY () void
      public void method_94() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.field_4424.transact(6, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: g (java.lang.String, boolean) void
      public void method_95(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: gl () void
      public void method_96() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.field_4424.transact(4, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: k (java.lang.String, java.lang.String) void
      public void method_97(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_4424.transact(3, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
