package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

// $FF: renamed from: com.google.android.gms.maps.internal.u
public interface class_99 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate) void
   void method_642(IStreetViewPanoramaDelegate var1) throws RemoteException;

   public abstract static class class_1357 extends Binder implements class_99 {
      public class_1357() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
      }

      // $FF: renamed from: bo (android.os.IBinder) com.google.android.gms.maps.internal.u
      public static class_99 method_1626(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            return (class_99)(var1 != null && var1 instanceof class_99?(class_99)var1:new class_99.class_1358(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            this.a(IStreetViewPanoramaDelegate.class_1179.method_5177(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1358 implements class_99 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2747;

      class_1358(IBinder var1) {
         this.field_2747 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate) void
      public void method_642(IStreetViewPanoramaDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2747;
      }
   }
}
