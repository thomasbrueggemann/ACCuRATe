package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zza extends IInterface {
   com.google.android.gms.dynamic.zzd zzAn() throws RemoteException;

   com.google.android.gms.dynamic.zzd zzc(Bitmap var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zzer(String var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zzes(String var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zzet(String var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zzh(float var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zziz(int var1) throws RemoteException;

   public abstract static class zza extends Binder implements zza {
      public static zza zzdd(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (zza)(var1 != null && var1 instanceof zza?(zza)var1:new zza.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.zzd var18 = this.zziz(var2.readInt());
            var3.writeNoException();
            IBinder var19;
            if(var18 != null) {
               var19 = var18.asBinder();
            } else {
               var19 = null;
            }

            var3.writeStrongBinder(var19);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.zzd var16 = this.zzer(var2.readString());
            var3.writeNoException();
            IBinder var17 = null;
            if(var16 != null) {
               var17 = var16.asBinder();
            }

            var3.writeStrongBinder(var17);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.zzd var14 = this.zzes(var2.readString());
            var3.writeNoException();
            IBinder var15 = null;
            if(var14 != null) {
               var15 = var14.asBinder();
            }

            var3.writeStrongBinder(var15);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.zzd var12 = this.zzAn();
            var3.writeNoException();
            IBinder var13 = null;
            if(var12 != null) {
               var13 = var12.asBinder();
            }

            var3.writeStrongBinder(var13);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.zzd var10 = this.zzh(var2.readFloat());
            var3.writeNoException();
            IBinder var11 = null;
            if(var10 != null) {
               var11 = var10.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            Bitmap var7;
            if(var2.readInt() != 0) {
               var7 = (Bitmap)Bitmap.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            com.google.android.gms.dynamic.zzd var8 = this.zzc(var7);
            var3.writeNoException();
            IBinder var9 = null;
            if(var8 != null) {
               var9 = var8.asBinder();
            }

            var3.writeStrongBinder(var9);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            com.google.android.gms.dynamic.zzd var5 = this.zzet(var2.readString());
            var3.writeNoException();
            IBinder var6 = null;
            if(var5 != null) {
               var6 = var5.asBinder();
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zza {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public com.google.android.gms.dynamic.zzd zzAn() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            this.zzoz.transact(4, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public com.google.android.gms.dynamic.zzd zzc(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd zzer(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.zzoz.transact(2, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.zzd.zza.zzbs(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.zzd zzes(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.zzoz.transact(3, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.zzd.zza.zzbs(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.zzd zzet(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.zzoz.transact(7, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.zzd.zza.zzbs(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.zzd zzh(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(5, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.zzd.zza.zzbs(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public com.google.android.gms.dynamic.zzd zziz(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeInt(var1);
            this.zzoz.transact(1, var2, var3, 0);
            var3.readException();
            var6 = com.google.android.gms.dynamic.zzd.zza.zzbs(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }
   }
}
