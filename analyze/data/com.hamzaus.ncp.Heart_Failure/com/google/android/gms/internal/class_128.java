package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_156;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.internal.class_125;
import com.google.android.gms.internal.class_126;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.lo
public interface class_128 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.lm) com.google.android.gms.internal.ll
   class_125 method_695(class_157 var1, class_156 var2, WalletFragmentOptions var3, class_126 var4) throws RemoteException;

   public abstract static class class_1079 extends Binder implements class_128 {
      // $FF: renamed from: br (android.os.IBinder) com.google.android.gms.internal.lo
      public static class_128 method_4346(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (class_128)(var1 != null && var1 instanceof class_128?(class_128)var1:new class_128.class_1080(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            class_157 var5 = class_157.class_1317.method_4176(var2.readStrongBinder());
            class_156 var6 = class_156.class_1035.method_4324(var2.readStrongBinder());
            WalletFragmentOptions var7;
            if(var2.readInt() != 0) {
               var7 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            class_125 var8 = this.a(var5, var6, var7, class_126.class_1024.method_3823(var2.readStrongBinder()));
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

   private static class class_1080 implements class_128 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3700;

      class_1080(IBinder var1) {
         this.field_3700 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.lm) com.google.android.gms.internal.ll
      public class_125 method_695(class_157 param1, class_156 param2, WalletFragmentOptions param3, class_126 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3700;
      }
   }
}
