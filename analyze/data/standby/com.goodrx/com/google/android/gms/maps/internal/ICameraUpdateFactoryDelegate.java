package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ICameraUpdateFactoryDelegate extends IInterface {
   com.google.android.gms.dynamic.zzd newCameraPosition(CameraPosition var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd newLatLng(LatLng var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd newLatLngBounds(LatLngBounds var1, int var2) throws RemoteException;

   com.google.android.gms.dynamic.zzd newLatLngBoundsWithSize(LatLngBounds var1, int var2, int var3, int var4) throws RemoteException;

   com.google.android.gms.dynamic.zzd newLatLngZoom(LatLng var1, float var2) throws RemoteException;

   com.google.android.gms.dynamic.zzd scrollBy(float var1, float var2) throws RemoteException;

   com.google.android.gms.dynamic.zzd zoomBy(float var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zoomByWithFocus(float var1, int var2, int var3) throws RemoteException;

   com.google.android.gms.dynamic.zzd zoomIn() throws RemoteException;

   com.google.android.gms.dynamic.zzd zoomOut() throws RemoteException;

   com.google.android.gms.dynamic.zzd zoomTo(float var1) throws RemoteException;

   public abstract static class zza extends Binder implements ICameraUpdateFactoryDelegate {
      public static ICameraUpdateFactoryDelegate zzcs(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            return (ICameraUpdateFactoryDelegate)(var1 != null && var1 instanceof ICameraUpdateFactoryDelegate?(ICameraUpdateFactoryDelegate)var1:new ICameraUpdateFactoryDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com.google.android.gms.dynamic.zzd var30 = this.zoomIn();
            var3.writeNoException();
            IBinder var31 = null;
            if(var30 != null) {
               var31 = var30.asBinder();
            }

            var3.writeStrongBinder(var31);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com.google.android.gms.dynamic.zzd var28 = this.zoomOut();
            var3.writeNoException();
            IBinder var29 = null;
            if(var28 != null) {
               var29 = var28.asBinder();
            }

            var3.writeStrongBinder(var29);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com.google.android.gms.dynamic.zzd var26 = this.scrollBy(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            IBinder var27 = null;
            if(var26 != null) {
               var27 = var26.asBinder();
            }

            var3.writeStrongBinder(var27);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com.google.android.gms.dynamic.zzd var24 = this.zoomTo(var2.readFloat());
            var3.writeNoException();
            IBinder var25 = null;
            if(var24 != null) {
               var25 = var24.asBinder();
            }

            var3.writeStrongBinder(var25);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com.google.android.gms.dynamic.zzd var22 = this.zoomBy(var2.readFloat());
            var3.writeNoException();
            IBinder var23 = null;
            if(var22 != null) {
               var23 = var22.asBinder();
            }

            var3.writeStrongBinder(var23);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com.google.android.gms.dynamic.zzd var20 = this.zoomByWithFocus(var2.readFloat(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            IBinder var21 = null;
            if(var20 != null) {
               var21 = var20.asBinder();
            }

            var3.writeStrongBinder(var21);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            CameraPosition var17;
            if(var2.readInt() != 0) {
               var17 = CameraPosition.CREATOR.zzfv(var2);
            } else {
               var17 = null;
            }

            com.google.android.gms.dynamic.zzd var18 = this.newCameraPosition(var17);
            var3.writeNoException();
            IBinder var19 = null;
            if(var18 != null) {
               var19 = var18.asBinder();
            }

            var3.writeStrongBinder(var19);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLng var14;
            if(var2.readInt() != 0) {
               var14 = LatLng.CREATOR.zzfz(var2);
            } else {
               var14 = null;
            }

            com.google.android.gms.dynamic.zzd var15 = this.newLatLng(var14);
            var3.writeNoException();
            IBinder var16 = null;
            if(var15 != null) {
               var16 = var15.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLng var11;
            if(var2.readInt() != 0) {
               var11 = LatLng.CREATOR.zzfz(var2);
            } else {
               var11 = null;
            }

            com.google.android.gms.dynamic.zzd var12 = this.newLatLngZoom(var11, var2.readFloat());
            var3.writeNoException();
            IBinder var13 = null;
            if(var12 != null) {
               var13 = var12.asBinder();
            }

            var3.writeStrongBinder(var13);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLngBounds var8;
            if(var2.readInt() != 0) {
               var8 = LatLngBounds.CREATOR.zzfy(var2);
            } else {
               var8 = null;
            }

            com.google.android.gms.dynamic.zzd var9 = this.newLatLngBounds(var8, var2.readInt());
            var3.writeNoException();
            IBinder var10 = null;
            if(var9 != null) {
               var10 = var9.asBinder();
            }

            var3.writeStrongBinder(var10);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            LatLngBounds var5;
            if(var2.readInt() != 0) {
               var5 = LatLngBounds.CREATOR.zzfy(var2);
            } else {
               var5 = null;
            }

            com.google.android.gms.dynamic.zzd var6 = this.newLatLngBoundsWithSize(var5, var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            IBinder var7 = null;
            if(var6 != null) {
               var7 = var6.asBinder();
            }

            var3.writeStrongBinder(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements ICameraUpdateFactoryDelegate {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public com.google.android.gms.dynamic.zzd newCameraPosition(CameraPosition param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd newLatLng(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd newLatLngBounds(LatLngBounds param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd newLatLngBoundsWithSize(LatLngBounds param1, int param2, int param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd newLatLngZoom(LatLng param1, float param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd scrollBy(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var7;
         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.zzoz.transact(3, var3, var4, 0);
            var4.readException();
            var7 = com.google.android.gms.dynamic.zzd.zza.zzbs(var4.readStrongBinder());
         } finally {
            var4.recycle();
            var3.recycle();
         }

         return var7;
      }

      public com.google.android.gms.dynamic.zzd zoomBy(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
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

      public com.google.android.gms.dynamic.zzd zoomByWithFocus(float var1, int var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var8;
         try {
            var4.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var4.writeFloat(var1);
            var4.writeInt(var2);
            var4.writeInt(var3);
            this.zzoz.transact(6, var4, var5, 0);
            var5.readException();
            var8 = com.google.android.gms.dynamic.zzd.zza.zzbs(var5.readStrongBinder());
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }

      public com.google.android.gms.dynamic.zzd zoomIn() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public com.google.android.gms.dynamic.zzd zoomOut() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public com.google.android.gms.dynamic.zzd zoomTo(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(4, var2, var3, 0);
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
