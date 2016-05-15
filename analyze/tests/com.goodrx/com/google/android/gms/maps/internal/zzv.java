package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

public interface zzv extends IInterface {
   void zza(IPolylineDelegate var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzv {
      public static zzv zzcR(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnPolylineClickListener");
            return (zzv)(var1 != null && var1 instanceof zzv?(zzv)var1:new zzv.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnPolylineClickListener");
            this.zza(IPolylineDelegate.zza.zzdk(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnPolylineClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzv {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(IPolylineDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
