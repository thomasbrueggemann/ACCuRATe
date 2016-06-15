package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.internal.i
public interface class_105 extends IInterface {
   void onMapClick(LatLng var1) throws RemoteException;

   public abstract static class class_850 extends Binder implements class_105 {
      public class_850() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
      }

      // $FF: renamed from: aH (android.os.IBinder) com.google.android.gms.maps.internal.i
      public static class_105 method_2529(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
            return (class_105)(var1 != null && var1 instanceof class_105?(class_105)var1:new class_105.class_851(var0));
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
               var5 = LatLng.CREATOR.createFromParcel(var2);
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

   private static class class_851 implements class_105 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4059;

      class_851(IBinder var1) {
         this.field_4059 = var1;
      }

      public IBinder asBinder() {
         return this.field_4059;
      }

      public void onMapClick(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
