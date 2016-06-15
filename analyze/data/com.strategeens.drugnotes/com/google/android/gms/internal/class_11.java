package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.internal.bq
public interface class_11 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d) void
   void method_38(class_198 var1) throws RemoteException;

   // $FF: renamed from: av () void
   void method_39() throws RemoteException;

   // $FF: renamed from: aw () void
   void method_40() throws RemoteException;

   // $FF: renamed from: bA () java.lang.String
   String method_41() throws RemoteException;

   // $FF: renamed from: bz () java.lang.String
   String method_42() throws RemoteException;

   public abstract static class class_1409 extends Binder implements class_11 {
      public class_1409() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
      }

      // $FF: renamed from: i (android.os.IBinder) com.google.android.gms.internal.bq
      public static class_11 method_1615(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            return (class_11)(var1 != null && var1 instanceof class_11?(class_11)var1:new class_11.class_1410(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            String var6 = this.bz();
            var3.writeNoException();
            var3.writeString(var6);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            String var5 = this.bA();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.a(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.av();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.aw();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1410 implements class_11 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3210;

      class_1410(IBinder var1) {
         this.field_3210 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d) void
      public void method_38(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3210;
      }

      // $FF: renamed from: av () void
      public void method_39() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.field_3210.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: aw () void
      public void method_40() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.field_3210.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: bA () java.lang.String
      public String method_41() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.field_3210.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: bz () java.lang.String
      public String method_42() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
            this.field_3210.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
