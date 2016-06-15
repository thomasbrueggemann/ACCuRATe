package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.location.b
public interface class_92 extends IInterface {
   void onLocationChanged(Location var1) throws RemoteException;

   public abstract static class class_1059 extends Binder implements class_92 {
      public class_1059() {
         this.attachInterface(this, "com.google.android.gms.location.ILocationListener");
      }

      // $FF: renamed from: aL (android.os.IBinder) com.google.android.gms.location.b
      public static class_92 method_1589(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (class_92)(var1 != null && var1 instanceof class_92?(class_92)var1:new class_92.class_1060(var0));
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

   private static class class_1060 implements class_92 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3109;

      class_1060(IBinder var1) {
         this.field_3109 = var1;
      }

      public IBinder asBinder() {
         return this.field_3109;
      }

      public void onLocationChanged(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
