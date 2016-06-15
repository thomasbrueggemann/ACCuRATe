package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;

// $FF: renamed from: com.google.android.gms.maps.internal.e
public interface class_101 extends IInterface {
   void onCameraChange(CameraPosition var1) throws RemoteException;

   public abstract static class class_812 extends Binder implements class_101 {
      public class_812() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
      }

      // $FF: renamed from: aD (android.os.IBinder) com.google.android.gms.maps.internal.e
      public static class_101 method_4017(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            return (class_101)(var1 != null && var1 instanceof class_101?(class_101)var1:new class_101.class_813(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            CameraPosition var5;
            if(var2.readInt() != 0) {
               var5 = CameraPosition.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onCameraChange(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_813 implements class_101 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_733;

      class_813(IBinder var1) {
         this.field_733 = var1;
      }

      public IBinder asBinder() {
         return this.field_733;
      }

      public void onCameraChange(CameraPosition param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
