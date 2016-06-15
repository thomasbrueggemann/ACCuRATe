package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.internal.df
public interface class_46 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.dynamic.d) android.os.IBinder
   IBinder method_207(class_157 var1) throws RemoteException;

   public abstract static class class_1041 extends Binder implements class_46 {
      // $FF: renamed from: s (android.os.IBinder) com.google.android.gms.internal.df
      public static class_46 method_4498(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (class_46)(var1 != null && var1 instanceof class_46?(class_46)var1:new class_46.class_1042(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            IBinder var5 = this.b(class_157.class_1317.method_4176(var2.readStrongBinder()));
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

   private static class class_1042 implements class_46 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3352;

      class_1042(IBinder var1) {
         this.field_3352 = var1;
      }

      public IBinder asBinder() {
         return this.field_3352;
      }

      // $FF: renamed from: b (com.google.android.gms.dynamic.d) android.os.IBinder
      public IBinder method_207(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
