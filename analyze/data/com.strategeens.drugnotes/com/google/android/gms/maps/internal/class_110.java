package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.maps.model.internal.class_63;

// $FF: renamed from: com.google.android.gms.maps.internal.d
public interface class_110 extends IInterface {
   // $FF: renamed from: f (com.google.android.gms.maps.model.internal.l) com.google.android.gms.dynamic.d
   class_198 method_651(class_63 var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.maps.model.internal.l) com.google.android.gms.dynamic.d
   class_198 method_652(class_63 var1) throws RemoteException;

   public abstract static class class_1486 extends Binder implements class_110 {
      public class_1486() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
      }

      // $FF: renamed from: aU (android.os.IBinder) com.google.android.gms.maps.internal.d
      public static class_110 method_3713(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (class_110)(var1 != null && var1 instanceof class_110?(class_110)var1:new class_110.class_1487(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            class_198 var7 = this.f(class_63.class_1674.method_5294(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            class_198 var5 = this.g(class_63.class_1674.method_5294(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var6 = null;
            if(var5 != null) {
               var6 = var5.asBinder();
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1487 implements class_110 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3754;

      class_1487(IBinder var1) {
         this.field_3754 = var1;
      }

      public IBinder asBinder() {
         return this.field_3754;
      }

      // $FF: renamed from: f (com.google.android.gms.maps.model.internal.l) com.google.android.gms.dynamic.d
      public class_198 method_651(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.maps.model.internal.l) com.google.android.gms.dynamic.d
      public class_198 method_652(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
