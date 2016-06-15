package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_788;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

// $FF: renamed from: com.google.android.gms.internal.qf
public interface class_156 extends IInterface {
   // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
   void method_818(int var1, FullWallet var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (int, com.google.android.gms.wallet.MaskedWallet, android.os.Bundle) void
   void method_819(int var1, MaskedWallet var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (int, boolean, android.os.Bundle) void
   void method_820(int var1, boolean var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, com.google.android.gms.internal.py, android.os.Bundle) void
   void method_821(Status var1, class_788 var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: i (int, android.os.Bundle) void
   void method_822(int var1, Bundle var2) throws RemoteException;

   public abstract static class class_1449 extends Binder implements class_156 {
      public class_1449() {
         this.attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      }

      // $FF: renamed from: bU (android.os.IBinder) com.google.android.gms.internal.qf
      public static class_156 method_4936(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            return (class_156)(var1 != null && var1 instanceof class_156?(class_156)var1:new class_156.class_1450(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            int var16 = var2.readInt();
            MaskedWallet var17;
            if(var2.readInt() != 0) {
               var17 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            Bundle var18;
            if(var2.readInt() != 0) {
               var18 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var18 = null;
            }

            this.a(var16, var17, var18);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            int var13 = var2.readInt();
            FullWallet var14;
            if(var2.readInt() != 0) {
               var14 = (FullWallet)FullWallet.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            Bundle var15;
            if(var2.readInt() != 0) {
               var15 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            this.a(var13, var14, var15);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            int var10 = var2.readInt();
            boolean var11;
            if(var2.readInt() != 0) {
               var11 = true;
            } else {
               var11 = false;
            }

            Bundle var12;
            if(var2.readInt() != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.a(var10, var11, var12);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            int var8 = var2.readInt();
            Bundle var9;
            if(var2.readInt() != 0) {
               var9 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.i(var8, var9);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            class_788 var6;
            if(var2.readInt() != 0) {
               var6 = (class_788)class_788.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

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
            var3.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1450 implements class_156 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4121;

      class_1450(IBinder var1) {
         this.field_4121 = var1;
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
      public void method_818(int param1, FullWallet param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.MaskedWallet, android.os.Bundle) void
      public void method_819(int param1, MaskedWallet param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, boolean, android.os.Bundle) void
      public void method_820(int param1, boolean param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, com.google.android.gms.internal.py, android.os.Bundle) void
      public void method_821(Status param1, class_788 param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4121;
      }

      // $FF: renamed from: i (int, android.os.Bundle) void
      public void method_822(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
