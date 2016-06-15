package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_197;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.internal.class_157;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.qd
public interface class_160 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.qb) com.google.android.gms.internal.qa
   class_157 method_835(class_198 var1, class_197 var2, WalletFragmentOptions var3, class_158 var4) throws RemoteException;

   public abstract static class class_1082 extends Binder implements class_160 {
      // $FF: renamed from: bS (android.os.IBinder) com.google.android.gms.internal.qd
      public static class_160 method_4101(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (class_160)(var1 != null && var1 instanceof class_160?(class_160)var1:new class_160.class_1083(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            class_198 var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
            class_197 var6 = class_197.class_1372.method_5470(var2.readStrongBinder());
            WalletFragmentOptions var7;
            if(var2.readInt() != 0) {
               var7 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            class_157 var8 = this.a(var5, var6, var7, class_158.class_1193.method_3065(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var9 = null;
            if(var8 != null) {
               var9 = var8.asBinder();
            }

            var3.writeStrongBinder(var9);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1083 implements class_160 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_591;

      class_1083(IBinder var1) {
         this.field_591 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.qb) com.google.android.gms.internal.qa
      public class_157 method_835(class_198 param1, class_197 param2, WalletFragmentOptions param3, class_158 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_591;
      }
   }
}
