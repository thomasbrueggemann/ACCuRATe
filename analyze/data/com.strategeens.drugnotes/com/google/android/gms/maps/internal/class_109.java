package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

// $FF: renamed from: com.google.android.gms.maps.internal.s
public interface class_109 extends IInterface {
   void onStreetViewPanoramaChange(StreetViewPanoramaLocation var1) throws RemoteException;

   public abstract static class class_1503 extends Binder implements class_109 {
      public class_1503() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
      }

      // $FF: renamed from: bm (android.os.IBinder) com.google.android.gms.maps.internal.s
      public static class_109 method_1635(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
            return (class_109)(var1 != null && var1 instanceof class_109?(class_109)var1:new class_109.class_1504(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
            StreetViewPanoramaLocation var5;
            if(var2.readInt() != 0) {
               var5 = StreetViewPanoramaLocation.CREATOR.method_5026(var2);
            } else {
               var5 = null;
            }

            this.onStreetViewPanoramaChange(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1504 implements class_109 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3756;

      class_1504(IBinder var1) {
         this.field_3756 = var1;
      }

      public IBinder asBinder() {
         return this.field_3756;
      }

      public void onStreetViewPanoramaChange(StreetViewPanoramaLocation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
