package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.location.a
public interface class_86 extends IInterface {
   void onLocationChanged(Location var1) throws RemoteException;

   public abstract static class class_898 extends Binder implements class_86 {
      public class_898() {
         this.attachInterface(this, "com.google.android.gms.location.ILocationListener");
      }

      // $FF: renamed from: aq (android.os.IBinder) com.google.android.gms.location.a
      public static class_86 method_2001(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (class_86)(var1 != null && var1 instanceof class_86?(class_86)var1:new class_86.class_899(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.ILocationListener");
            Location var5;
            if(var2.readInt() != 0) {
               var5 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onLocationChanged(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.ILocationListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_899 implements class_86 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2129;

      class_899(IBinder var1) {
         this.field_2129 = var1;
      }

      public IBinder asBinder() {
         return this.field_2129;
      }

      public void onLocationChanged(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
