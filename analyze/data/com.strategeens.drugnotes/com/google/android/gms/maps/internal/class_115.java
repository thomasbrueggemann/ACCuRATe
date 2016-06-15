package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.maps.internal.i
public interface class_115 extends IInterface {
   // $FF: renamed from: d (android.location.Location) void
   void method_656(Location var1) throws RemoteException;

   // $FF: renamed from: l (com.google.android.gms.dynamic.d) void
   void method_657(class_198 var1) throws RemoteException;

   public abstract static class class_1152 extends Binder implements class_115 {
      // $FF: renamed from: bc (android.os.IBinder) com.google.android.gms.maps.internal.i
      public static class_115 method_2916(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (class_115)(var1 != null && var1 instanceof class_115?(class_115)var1:new class_115.class_1153(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            this.l(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            Location var5;
            if(var2.readInt() != 0) {
               var5 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.d(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1153 implements class_115 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4172;

      class_1153(IBinder var1) {
         this.field_4172 = var1;
      }

      public IBinder asBinder() {
         return this.field_4172;
      }

      // $FF: renamed from: d (android.location.Location) void
      public void method_656(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: l (com.google.android.gms.dynamic.d) void
      public void method_657(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
