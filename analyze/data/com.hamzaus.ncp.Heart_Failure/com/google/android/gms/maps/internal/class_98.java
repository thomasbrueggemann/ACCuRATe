package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// $FF: renamed from: com.google.android.gms.maps.internal.r
public interface class_98 extends IInterface {
   void onStreetViewPanoramaClick(StreetViewPanoramaOrientation var1) throws RemoteException;

   public abstract static class class_842 extends Binder implements class_98 {
      public class_842() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
      }

      // $FF: renamed from: aQ (android.os.IBinder) com.google.android.gms.maps.internal.r
      public static class_98 method_1333(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            return (class_98)(var1 != null && var1 instanceof class_98?(class_98)var1:new class_98.class_843(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            StreetViewPanoramaOrientation var5;
            if(var2.readInt() != 0) {
               var5 = StreetViewPanoramaOrientation.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onStreetViewPanoramaClick(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_843 implements class_98 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2191;

      class_843(IBinder var1) {
         this.field_2191 = var1;
      }

      public IBinder asBinder() {
         return this.field_2191;
      }

      public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
