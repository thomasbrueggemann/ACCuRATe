package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.maps.model.internal.class_55;

// $FF: renamed from: com.google.android.gms.maps.internal.d
public interface class_100 extends IInterface {
   // $FF: renamed from: f (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
   class_157 method_598(class_55 var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
   class_157 method_599(class_55 var1) throws RemoteException;

   public abstract static class class_1147 extends Binder implements class_100 {
      public class_1147() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
      }

      // $FF: renamed from: az (android.os.IBinder) com.google.android.gms.maps.internal.d
      public static class_100 method_3115(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (class_100)(var1 != null && var1 instanceof class_100?(class_100)var1:new class_100.class_1148(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            class_157 var7 = this.f(class_55.class_1174.method_3352(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            class_157 var5 = this.g(class_55.class_1174.method_3352(var2.readStrongBinder()));
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

   private static class class_1148 implements class_100 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3612;

      class_1148(IBinder var1) {
         this.field_3612 = var1;
      }

      public IBinder asBinder() {
         return this.field_3612;
      }

      // $FF: renamed from: f (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
      public class_157 method_598(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
      public class_157 method_599(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
