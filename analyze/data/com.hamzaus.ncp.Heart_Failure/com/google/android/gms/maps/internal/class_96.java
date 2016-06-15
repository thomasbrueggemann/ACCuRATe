package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.internal.p
public interface class_96 extends IInterface {
   void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera var1) throws RemoteException;

   public abstract static class class_1101 extends Binder implements class_96 {
      public class_1101() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
      }

      // $FF: renamed from: aO (android.os.IBinder) com.google.android.gms.maps.internal.p
      public static class_96 method_1336(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return (class_96)(var1 != null && var1 instanceof class_96?(class_96)var1:new class_96.class_1102(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            StreetViewPanoramaCamera var5;
            if(var2.readInt() != 0) {
               var5 = StreetViewPanoramaCamera.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onStreetViewPanoramaCameraChange(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1102 implements class_96 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2959;

      class_1102(IBinder var1) {
         this.field_2959 = var1;
      }

      public IBinder asBinder() {
         return this.field_2959;
      }

      public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
