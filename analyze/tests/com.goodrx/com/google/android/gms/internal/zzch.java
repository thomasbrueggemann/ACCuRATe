package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzch extends IInterface {
   double getScale() throws RemoteException;

   Uri getUri() throws RemoteException;

   com.google.android.gms.dynamic.zzd zzdJ() throws RemoteException;

   public abstract static class zza extends Binder implements zzch {
      public static zzch zzt(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            return (zzch)(var1 != null && var1 instanceof zzch?(zzch)var1:new zzch.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            com.google.android.gms.dynamic.zzd var8 = this.zzdJ();
            var3.writeNoException();
            IBinder var9;
            if(var8 != null) {
               var9 = var8.asBinder();
            } else {
               var9 = null;
            }

            var3.writeStrongBinder(var9);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            Uri var7 = this.getUri();
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               var7.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            double var5 = this.getScale();
            var3.writeNoException();
            var3.writeDouble(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzch {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public double getScale() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         double var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.zzoz.transact(3, var1, var2, 0);
            var2.readException();
            var5 = var2.readDouble();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public Uri getUri() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Uri var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
               this.zzoz.transact(2, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Uri)Uri.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public com.google.android.gms.dynamic.zzd zzdJ() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
