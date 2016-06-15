package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.internal.hk
public interface class_30 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int) com.google.android.gms.dynamic.d
   class_157 method_151(class_157 var1, int var2, int var3) throws RemoteException;

   public abstract static class class_974 extends Binder implements class_30 {
      // $FF: renamed from: M (android.os.IBinder) com.google.android.gms.internal.hk
      public static class_30 method_2749(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (class_30)(var1 != null && var1 instanceof class_30?(class_30)var1:new class_30.class_975(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            class_157 var5 = this.a(class_157.class_1317.method_4176(var2.readStrongBinder()), var2.readInt(), var2.readInt());
            var3.writeNoException();
            IBinder var6;
            if(var5 != null) {
               var6 = var5.asBinder();
            } else {
               var6 = null;
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_975 implements class_30 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2910;

      class_975(IBinder var1) {
         this.field_2910 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int) com.google.android.gms.dynamic.d
      public class_157 method_151(class_157 param1, int param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2910;
      }
   }
}
