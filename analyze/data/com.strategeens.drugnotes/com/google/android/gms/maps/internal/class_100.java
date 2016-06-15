package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// $FF: renamed from: com.google.android.gms.maps.internal.t
public interface class_100 extends IInterface {
   void onStreetViewPanoramaClick(StreetViewPanoramaOrientation var1) throws RemoteException;

   public abstract static class class_1159 extends Binder implements class_100 {
      public class_1159() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
      }

      // $FF: renamed from: bn (android.os.IBinder) com.google.android.gms.maps.internal.t
      public static class_100 method_1633(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            return (class_100)(var1 != null && var1 instanceof class_100?(class_100)var1:new class_100.class_1160(var0));
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
               var5 = StreetViewPanoramaOrientation.CREATOR.method_4974(var2);
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

   private static class class_1160 implements class_100 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1721;

      class_1160(IBinder var1) {
         this.field_1721 = var1;
      }

      public IBinder asBinder() {
         return this.field_1721;
      }

      public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
