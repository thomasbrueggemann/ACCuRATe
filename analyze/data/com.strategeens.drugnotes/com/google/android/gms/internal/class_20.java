package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.internal.ju
public interface class_20 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int) com.google.android.gms.dynamic.d
   class_198 method_170(class_198 var1, int var2, int var3) throws RemoteException;

   public abstract static class class_1129 extends Binder implements class_20 {
      // $FF: renamed from: R (android.os.IBinder) com.google.android.gms.internal.ju
      public static class_20 method_2740(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (class_20)(var1 != null && var1 instanceof class_20?(class_20)var1:new class_20.class_1130(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            class_198 var5 = this.a(class_198.class_1672.method_5291(var2.readStrongBinder()), var2.readInt(), var2.readInt());
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

   private static class class_1130 implements class_20 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3080;

      class_1130(IBinder var1) {
         this.field_3080 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int) com.google.android.gms.dynamic.d
      public class_198 method_170(class_198 param1, int param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3080;
      }
   }
}
