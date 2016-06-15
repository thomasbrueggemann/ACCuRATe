package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.lm
public interface class_126 extends IInterface {
   // $FF: renamed from: a (int, int, android.os.Bundle) void
   void method_685(int var1, int var2, Bundle var3) throws RemoteException;

   public abstract static class class_1024 extends Binder implements class_126 {
      public class_1024() {
         this.attachInterface(this, "com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
      }

      // $FF: renamed from: bp (android.os.IBinder) com.google.android.gms.internal.lm
      public static class_126 method_3823(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
            return (class_126)(var1 != null && var1 instanceof class_126?(class_126)var1:new class_126.class_1025(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
            int var5 = var2.readInt();
            int var6 = var2.readInt();
            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.a(var5, var6, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1025 implements class_126 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2822;

      class_1025(IBinder var1) {
         this.field_2822 = var1;
      }

      // $FF: renamed from: a (int, int, android.os.Bundle) void
      public void method_685(int param1, int param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2822;
      }
   }
}
