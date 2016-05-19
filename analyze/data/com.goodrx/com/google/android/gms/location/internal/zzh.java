package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzh extends IInterface {
   void zza(int var1, PendingIntent var2) throws RemoteException;

   void zza(int var1, String[] var2) throws RemoteException;

   void zzb(int var1, String[] var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzh {
      public static zzh zzci(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (zzh)(var1 != null && var1 instanceof zzh?(zzh)var1:new zzh.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.zza(var2.readInt(), var2.createStringArray());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.zzb(var2.readInt(), var2.createStringArray());
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            int var5 = var2.readInt();
            PendingIntent var6;
            if(var2.readInt() != 0) {
               var6 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.zza(var5, var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzh {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(int param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.zzoz.transact(1, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void zzb(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.zzoz.transact(2, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
