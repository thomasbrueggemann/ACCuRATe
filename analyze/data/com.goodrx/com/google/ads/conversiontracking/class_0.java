package com.google.ads.conversiontracking;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.ads.conversiontracking.q
public interface class_0 extends IInterface {
   // $FF: renamed from: a () java.lang.String
   String method_24() throws RemoteException;

   // $FF: renamed from: a (java.lang.String) java.lang.String
   String method_25(String var1) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, boolean) void
   void method_26(String var1, boolean var2) throws RemoteException;

   // $FF: renamed from: a (boolean) boolean
   boolean method_27(boolean var1) throws RemoteException;

   public abstract static class class_114 extends Binder implements class_0 {
      // $FF: renamed from: a (android.os.IBinder) com.google.ads.conversiontracking.q
      public static class_0 method_352(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (class_0)(var1 != null && var1 instanceof class_0?(class_0)var1:new class_0.class_115(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String var12 = this.a();
            var3.writeNoException();
            var3.writeString(var12);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean var9;
            if(var2.readInt() != 0) {
               var9 = true;
            } else {
               var9 = false;
            }

            boolean var10 = this.a(var9);
            var3.writeNoException();
            byte var11 = 0;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String var8 = this.a(var2.readString());
            var3.writeNoException();
            var3.writeString(var8);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String var5 = var2.readString();
            int var6 = var2.readInt();
            boolean var7 = false;
            if(var6 != 0) {
               var7 = true;
            }

            this.a(var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_115 implements class_0 {
      // $FF: renamed from: a android.os.IBinder
      private IBinder field_611;

      class_115(IBinder var1) {
         this.field_611 = var1;
      }

      // $FF: renamed from: a () java.lang.String
      public String method_24() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.field_611.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: a (java.lang.String) java.lang.String
      public String method_25(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         String var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            var2.writeString(var1);
            this.field_611.transact(3, var2, var3, 0);
            var3.readException();
            var6 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: a (java.lang.String, boolean) void
      public void method_26(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (boolean) boolean
      public boolean method_27(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_611;
      }
   }
}
