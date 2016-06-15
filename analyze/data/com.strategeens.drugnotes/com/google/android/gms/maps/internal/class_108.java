package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.internal.r
public interface class_108 extends IInterface {
   void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera var1) throws RemoteException;

   public abstract static class class_1142 extends Binder implements class_108 {
      public class_1142() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
      }

      // $FF: renamed from: bl (android.os.IBinder) com.google.android.gms.maps.internal.r
      public static class_108 method_1636(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return (class_108)(var1 != null && var1 instanceof class_108?(class_108)var1:new class_108.class_1143(var0));
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
               var5 = StreetViewPanoramaCamera.CREATOR.method_5030(var2);
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

   private static class class_1143 implements class_108 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1941;

      class_1143(IBinder var1) {
         this.field_1941 = var1;
      }

      public IBinder asBinder() {
         return this.field_1941;
      }

      public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
