package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.qb
public interface class_158 extends IInterface {
   // $FF: renamed from: a (int, int, android.os.Bundle) void
   void method_824(int var1, int var2, Bundle var3) throws RemoteException;

   public abstract static class class_1193 extends Binder implements class_158 {
      public class_1193() {
         this.attachInterface(this, "com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
      }

      // $FF: renamed from: bQ (android.os.IBinder) com.google.android.gms.internal.qb
      public static class_158 method_3065(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
            return (class_158)(var1 != null && var1 instanceof class_158?(class_158)var1:new class_158.class_1194(var0));
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

   private static class class_1194 implements class_158 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3602;

      class_1194(IBinder var1) {
         this.field_3602 = var1;
      }

      // $FF: renamed from: a (int, int, android.os.Bundle) void
      public void method_824(int param1, int param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3602;
      }
   }
}
