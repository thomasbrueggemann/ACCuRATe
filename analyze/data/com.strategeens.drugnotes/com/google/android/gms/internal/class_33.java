package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.internal.ep
public interface class_33 extends IInterface {
   // $FF: renamed from: c (com.google.android.gms.dynamic.d) android.os.IBinder
   IBinder method_191(class_198 var1) throws RemoteException;

   public abstract static class class_1386 extends Binder implements class_33 {
      // $FF: renamed from: x (android.os.IBinder) com.google.android.gms.internal.ep
      public static class_33 method_5388(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (class_33)(var1 != null && var1 instanceof class_33?(class_33)var1:new class_33.class_1387(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            IBinder var5 = this.c(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1387 implements class_33 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4134;

      class_1387(IBinder var1) {
         this.field_4134 = var1;
      }

      public IBinder asBinder() {
         return this.field_4134;
      }

      // $FF: renamed from: c (com.google.android.gms.dynamic.d) android.os.IBinder
      public IBinder method_191(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
