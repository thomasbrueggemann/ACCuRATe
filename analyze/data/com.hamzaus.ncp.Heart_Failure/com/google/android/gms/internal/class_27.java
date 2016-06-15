package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

// $FF: renamed from: com.google.android.gms.internal.gm
public interface class_27 extends IInterface {
   // $FF: renamed from: a (double, double, boolean) void
   void method_125(double var1, double var3, boolean var5) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions) void
   void method_126(String var1, LaunchOptions var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String, long) void
   void method_127(String var1, String var2, long var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, byte[], long) void
   void method_128(String var1, byte[] var2, long var3) throws RemoteException;

   // $FF: renamed from: a (boolean, double, boolean) void
   void method_129(boolean var1, double var2, boolean var4) throws RemoteException;

   // $FF: renamed from: am (java.lang.String) void
   void method_130(String var1) throws RemoteException;

   // $FF: renamed from: an (java.lang.String) void
   void method_131(String var1) throws RemoteException;

   // $FF: renamed from: ao (java.lang.String) void
   void method_132(String var1) throws RemoteException;

   void disconnect() throws RemoteException;

   // $FF: renamed from: e (java.lang.String, boolean) void
   void method_133(String var1, boolean var2) throws RemoteException;

   // $FF: renamed from: eb () void
   void method_134() throws RemoteException;

   // $FF: renamed from: ek () void
   void method_135() throws RemoteException;

   // $FF: renamed from: h (java.lang.String, java.lang.String) void
   void method_136(String var1, String var2) throws RemoteException;

   public abstract static class class_1058 extends Binder implements class_27 {
      // $FF: renamed from: H (android.os.IBinder) com.google.android.gms.internal.gm
      public static class_27 method_3805(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (class_27)(var1 != null && var1 instanceof class_27?(class_27)var1:new class_27.class_1059(var0));
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

            this.e(var17, var19);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.h(var2.readString(), var2.readString());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.ek();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.am(var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.eb();
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
            this.an(var2.readString());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.ao(var2.readString());
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

   private static class class_1059 implements class_27 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4100;

      class_1059(IBinder var1) {
         this.field_4100 = var1;
      }

      // $FF: renamed from: a (double, double, boolean) void
      public void method_125(double param1, double param3, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions) void
      public void method_126(String param1, LaunchOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, java.lang.String, long) void
      public void method_127(String var1, String var2, long var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var5.writeString(var1);
            var5.writeString(var2);
            var5.writeLong(var3);
            this.field_4100.transact(9, var5, (Parcel)null, 1);
         } finally {
            var5.recycle();
         }

      }

      // $FF: renamed from: a (java.lang.String, byte[], long) void
      public void method_128(String var1, byte[] var2, long var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var5.writeString(var1);
            var5.writeByteArray(var2);
            var5.writeLong(var3);
            this.field_4100.transact(10, var5, (Parcel)null, 1);
         } finally {
            var5.recycle();
         }

      }

      // $FF: renamed from: a (boolean, double, boolean) void
      public void method_129(boolean param1, double param2, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: am (java.lang.String) void
      public void method_130(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.field_4100.transact(5, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: an (java.lang.String) void
      public void method_131(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.field_4100.transact(11, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      // $FF: renamed from: ao (java.lang.String) void
      public void method_132(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.field_4100.transact(12, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_4100;
      }

      public void disconnect() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.field_4100.transact(1, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: e (java.lang.String, boolean) void
      public void method_133(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: eb () void
      public void method_134() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.field_4100.transact(6, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: ek () void
      public void method_135() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.field_4100.transact(4, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      // $FF: renamed from: h (java.lang.String, java.lang.String) void
      public void method_136(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_4100.transact(3, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
