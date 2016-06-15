package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_30;

// $FF: renamed from: com.google.android.gms.internal.er
public interface class_29 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.eq) void
   void method_189(class_30 var1) throws RemoteException;

   boolean isValidPurchase(String var1) throws RemoteException;

   public abstract static class class_1384 extends Binder implements class_29 {
      public class_1384() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
      }

      // $FF: renamed from: z (android.os.IBinder) com.google.android.gms.internal.er
      public static class_29 method_2724(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            return (class_29)(var1 != null && var1 instanceof class_29?(class_29)var1:new class_29.class_1385(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            boolean var5 = this.isValidPurchase(var2.readString());
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            this.a(class_30.class_1218.method_2776(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1385 implements class_29 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3888;

      class_1385(IBinder var1) {
         this.field_3888 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.eq) void
      public void method_189(class_30 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3888;
      }

      public boolean isValidPurchase(String var1) throws RemoteException {
         boolean var2 = true;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var9 = false;

         int var7;
         try {
            var9 = true;
            var3.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            var3.writeString(var1);
            this.field_3888.transact(1, var3, var4, 0);
            var4.readException();
            var7 = var4.readInt();
            var9 = false;
         } finally {
            if(var9) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var7 == 0) {
            var2 = false;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }
   }
}
