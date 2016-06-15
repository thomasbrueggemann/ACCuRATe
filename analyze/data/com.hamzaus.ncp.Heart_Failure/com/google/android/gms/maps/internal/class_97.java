package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

// $FF: renamed from: com.google.android.gms.maps.internal.q
public interface class_97 extends IInterface {
   void onStreetViewPanoramaChange(StreetViewPanoramaLocation var1) throws RemoteException;

   public abstract static class class_993 extends Binder implements class_97 {
      public class_993() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
      }

      // $FF: renamed from: aP (android.os.IBinder) com.google.android.gms.maps.internal.q
      public static class_97 method_1335(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
            return (class_97)(var1 != null && var1 instanceof class_97?(class_97)var1:new class_97.class_994(var0));
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
               var5 = StreetViewPanoramaLocation.CREATOR.createFromParcel(var2);
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

   private static class class_994 implements class_97 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2800;

      class_994(IBinder var1) {
         this.field_2800 = var1;
      }

      public IBinder asBinder() {
         return this.field_2800;
      }

      public void onStreetViewPanoramaChange(StreetViewPanoramaLocation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
