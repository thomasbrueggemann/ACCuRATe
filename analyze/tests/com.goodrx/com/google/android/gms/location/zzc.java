package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

public interface zzc extends IInterface {
   void onLocationAvailability(LocationAvailability var1) throws RemoteException;

   void onLocationResult(LocationResult var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzc {
      public static zzc zzce(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            return (zzc)(var1 != null && var1 instanceof zzc?(zzc)var1:new zzc.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.ILocationCallback");
            int var7 = var2.readInt();
            LocationResult var8 = null;
            if(var7 != 0) {
               var8 = (LocationResult)LocationResult.CREATOR.createFromParcel(var2);
            }

            this.onLocationResult(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.ILocationCallback");
            int var5 = var2.readInt();
            LocationAvailability var6 = null;
            if(var5 != 0) {
               var6 = LocationAvailability.CREATOR.createFromParcel(var2);
            }

            this.onLocationAvailability(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.ILocationCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzc {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onLocationAvailability(LocationAvailability param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onLocationResult(LocationResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
