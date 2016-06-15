package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.internal.j
public interface class_116 extends IInterface {
   void onMapClick(LatLng var1) throws RemoteException;

   public abstract static class class_1323 extends Binder implements class_116 {
      public class_1323() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
      }

      // $FF: renamed from: bd (android.os.IBinder) com.google.android.gms.maps.internal.j
      public static class_116 method_3408(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
            return (class_116)(var1 != null && var1 instanceof class_116?(class_116)var1:new class_116.class_1324(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
            LatLng var5;
            if(var2.readInt() != 0) {
               var5 = LatLng.CREATOR.method_5012(var2);
            } else {
               var5 = null;
            }

            this.onMapClick(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1324 implements class_116 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2600;

      class_1324(IBinder var1) {
         this.field_2600 = var1;
      }

      public IBinder asBinder() {
         return this.field_2600;
      }

      public void onMapClick(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
