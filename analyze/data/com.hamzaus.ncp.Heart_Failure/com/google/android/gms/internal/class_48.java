package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_45;

// $FF: renamed from: com.google.android.gms.internal.dd
public interface class_48 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.dc) void
   void method_208(class_45 var1) throws RemoteException;

   public abstract static class class_1045 extends Binder implements class_48 {
      public class_1045() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
      }

      // $FF: renamed from: q (android.os.IBinder) com.google.android.gms.internal.dd
      public static class_48 method_2675(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (class_48)(var1 != null && var1 instanceof class_48?(class_48)var1:new class_48.class_1046(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            this.a(class_45.class_1043.method_2524(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1046 implements class_48 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3917;

      class_1046(IBinder var1) {
         this.field_3917 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.dc) void
      public void method_208(class_45 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3917;
      }
   }
}
