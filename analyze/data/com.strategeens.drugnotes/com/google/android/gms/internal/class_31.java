package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_32;

// $FF: renamed from: com.google.android.gms.internal.en
public interface class_31 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.em) void
   void method_190(class_32 var1) throws RemoteException;

   public abstract static class class_1093 extends Binder implements class_31 {
      public class_1093() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
      }

      // $FF: renamed from: v (android.os.IBinder) com.google.android.gms.internal.en
      public static class_31 method_2711(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (class_31)(var1 != null && var1 instanceof class_31?(class_31)var1:new class_31.class_1094(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            this.a(class_32.class_1290.method_2736(var2.readStrongBinder()));
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

   private static class class_1094 implements class_31 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_747;

      class_1094(IBinder var1) {
         this.field_747 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.em) void
      public void method_190(class_32 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_747;
      }
   }
}
