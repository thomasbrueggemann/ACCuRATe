package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.internal.class_289;

// $FF: renamed from: com.google.android.gms.plus.internal.b
public interface class_144 extends IInterface {
   // $FF: renamed from: a (int, android.os.Bundle, android.os.Bundle) void
   void method_721(int var1, Bundle var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (int, android.os.Bundle, android.os.ParcelFileDescriptor) void
   void method_722(int var1, Bundle var2, ParcelFileDescriptor var3) throws RemoteException;

   // $FF: renamed from: a (int, android.os.Bundle, com.google.android.gms.internal.if) void
   void method_723(int var1, Bundle var2, class_289 var3) throws RemoteException;

   // $FF: renamed from: a (int, com.google.android.gms.internal.kt) void
   void method_724(int var1, class_288 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String) void
   void method_725(DataHolder var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, java.lang.String) void
   void method_726(DataHolder var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: am (com.google.android.gms.common.api.Status) void
   void method_727(Status var1) throws RemoteException;

   // $FF: renamed from: bw (java.lang.String) void
   void method_728(String var1) throws RemoteException;

   // $FF: renamed from: bx (java.lang.String) void
   void method_729(String var1) throws RemoteException;

   // $FF: renamed from: h (int, android.os.Bundle) void
   void method_730(int var1, Bundle var2) throws RemoteException;

   public abstract static class class_1133 extends Binder implements class_144 {
      public class_1133() {
         this.attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
      }

      // $FF: renamed from: bk (android.os.IBinder) com.google.android.gms.plus.internal.b
      public static class_144 method_3254(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            return (class_144)(var1 != null && var1 instanceof class_144?(class_144)var1:new class_144.class_1134(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var23 = var2.readInt();
            Bundle var24;
            if(var2.readInt() != 0) {
               var24 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var24 = null;
            }

            Bundle var25;
            if(var2.readInt() != 0) {
               var25 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var25 = null;
            }

            this.a(var23, var24, var25);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var20 = var2.readInt();
            Bundle var21;
            if(var2.readInt() != 0) {
               var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var21 = null;
            }

            ParcelFileDescriptor var22;
            if(var2.readInt() != 0) {
               var22 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            } else {
               var22 = null;
            }

            this.a(var20, var21, var22);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            this.bw(var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var18 = var2.readInt();
            DataHolder var19 = null;
            if(var18 != 0) {
               var19 = DataHolder.CREATOR.method_4283(var2);
            }

            this.a(var19, var2.readString());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var14 = var2.readInt();
            Bundle var15;
            if(var2.readInt() != 0) {
               var15 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            int var16 = var2.readInt();
            class_289 var17 = null;
            if(var16 != 0) {
               var17 = class_289.CREATOR.method_1968(var2);
            }

            this.a(var14, var15, var17);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var12 = var2.readInt();
            DataHolder var13 = null;
            if(var12 != 0) {
               var13 = DataHolder.CREATOR.method_4283(var2);
            }

            this.a(var13, var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var10 = var2.readInt();
            Bundle var11;
            if(var2.readInt() != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.h(var10, var11);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            this.bx(var2.readString());
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var7 = var2.readInt();
            int var8 = var2.readInt();
            class_288 var9 = null;
            if(var8 != 0) {
               var9 = class_288.CREATOR.method_3618(var2);
            }

            this.a(var7, var9);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            int var5 = var2.readInt();
            Status var6 = null;
            if(var5 != 0) {
               var6 = Status.CREATOR.createFromParcel(var2);
            }

            this.am(var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1134 implements class_144 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3847;

      class_1134(IBinder var1) {
         this.field_3847 = var1;
      }

      // $FF: renamed from: a (int, android.os.Bundle, android.os.Bundle) void
      public void method_721(int param1, Bundle param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, android.os.Bundle, android.os.ParcelFileDescriptor) void
      public void method_722(int param1, Bundle param2, ParcelFileDescriptor param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, android.os.Bundle, com.google.android.gms.internal.if) void
      public void method_723(int param1, Bundle param2, class_289 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, com.google.android.gms.internal.kt) void
      public void method_724(int param1, class_288 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String) void
      public void method_725(DataHolder param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, java.lang.String) void
      public void method_726(DataHolder param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: am (com.google.android.gms.common.api.Status) void
      public void method_727(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3847;
      }

      // $FF: renamed from: bw (java.lang.String) void
      public void method_728(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            var2.writeString(var1);
            this.field_3847.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: bx (java.lang.String) void
      public void method_729(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            var2.writeString(var1);
            this.field_3847.transact(8, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: h (int, android.os.Bundle) void
      public void method_730(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
