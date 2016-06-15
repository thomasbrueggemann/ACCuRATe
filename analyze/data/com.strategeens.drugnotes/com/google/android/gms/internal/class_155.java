package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.qe
public interface class_155 extends IInterface {
   // $FF: renamed from: b (int, int, android.os.Bundle) void
   void method_817(int var1, int var2, Bundle var3) throws RemoteException;

   public abstract static class class_1447 extends Binder implements class_155 {
      // $FF: renamed from: bT (android.os.IBinder) com.google.android.gms.internal.qe
      public static class_155 method_4676(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
            return (class_155)(var1 != null && var1 instanceof class_155?(class_155)var1:new class_155.class_1448(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
            int var5 = var2.readInt();
            int var6 = var2.readInt();
            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.b(var5, var6, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1448 implements class_155 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3967;

      class_1448(IBinder var1) {
         this.field_3967 = var1;
      }

      public IBinder asBinder() {
         return this.field_3967;
      }

      // $FF: renamed from: b (int, int, android.os.Bundle) void
      public void method_817(int param1, int param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
