package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUiSettingsDelegate extends IInterface {
   boolean isCompassEnabled() throws RemoteException;

   boolean isIndoorLevelPickerEnabled() throws RemoteException;

   boolean isMapToolbarEnabled() throws RemoteException;

   boolean isMyLocationButtonEnabled() throws RemoteException;

   boolean isRotateGesturesEnabled() throws RemoteException;

   boolean isScrollGesturesEnabled() throws RemoteException;

   boolean isTiltGesturesEnabled() throws RemoteException;

   boolean isZoomControlsEnabled() throws RemoteException;

   boolean isZoomGesturesEnabled() throws RemoteException;

   void setAllGesturesEnabled(boolean var1) throws RemoteException;

   void setCompassEnabled(boolean var1) throws RemoteException;

   void setIndoorLevelPickerEnabled(boolean var1) throws RemoteException;

   void setMapToolbarEnabled(boolean var1) throws RemoteException;

   void setMyLocationButtonEnabled(boolean var1) throws RemoteException;

   void setRotateGesturesEnabled(boolean var1) throws RemoteException;

   void setScrollGesturesEnabled(boolean var1) throws RemoteException;

   void setTiltGesturesEnabled(boolean var1) throws RemoteException;

   void setZoomControlsEnabled(boolean var1) throws RemoteException;

   void setZoomGesturesEnabled(boolean var1) throws RemoteException;

   public abstract static class zza extends Binder implements IUiSettingsDelegate {
      public static IUiSettingsDelegate zzdc(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            return (IUiSettingsDelegate)(var1 != null && var1 instanceof IUiSettingsDelegate?(IUiSettingsDelegate)var1:new IUiSettingsDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var41 = var2.readInt();
            boolean var42 = false;
            if(var41 != 0) {
               var42 = true;
            }

            this.setZoomControlsEnabled(var42);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var39 = var2.readInt();
            boolean var40 = false;
            if(var39 != 0) {
               var40 = true;
            }

            this.setCompassEnabled(var40);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var37 = var2.readInt();
            boolean var38 = false;
            if(var37 != 0) {
               var38 = true;
            }

            this.setMyLocationButtonEnabled(var38);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var35 = var2.readInt();
            boolean var36 = false;
            if(var35 != 0) {
               var36 = true;
            }

            this.setScrollGesturesEnabled(var36);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var33 = var2.readInt();
            boolean var34 = false;
            if(var33 != 0) {
               var34 = true;
            }

            this.setZoomGesturesEnabled(var34);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var31 = var2.readInt();
            boolean var32 = false;
            if(var31 != 0) {
               var32 = true;
            }

            this.setTiltGesturesEnabled(var32);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var29 = var2.readInt();
            boolean var30 = false;
            if(var29 != 0) {
               var30 = true;
            }

            this.setRotateGesturesEnabled(var30);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var27 = var2.readInt();
            boolean var28 = false;
            if(var27 != 0) {
               var28 = true;
            }

            this.setAllGesturesEnabled(var28);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var25 = this.isZoomControlsEnabled();
            var3.writeNoException();
            byte var26 = 0;
            if(var25) {
               var26 = 1;
            }

            var3.writeInt(var26);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var23 = this.isCompassEnabled();
            var3.writeNoException();
            byte var24 = 0;
            if(var23) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var21 = this.isMyLocationButtonEnabled();
            var3.writeNoException();
            byte var22 = 0;
            if(var21) {
               var22 = 1;
            }

            var3.writeInt(var22);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var19 = this.isScrollGesturesEnabled();
            var3.writeNoException();
            byte var20 = 0;
            if(var19) {
               var20 = 1;
            }

            var3.writeInt(var20);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var17 = this.isZoomGesturesEnabled();
            var3.writeNoException();
            byte var18 = 0;
            if(var17) {
               var18 = 1;
            }

            var3.writeInt(var18);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var15 = this.isTiltGesturesEnabled();
            var3.writeNoException();
            byte var16 = 0;
            if(var15) {
               var16 = 1;
            }

            var3.writeInt(var16);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var13 = this.isRotateGesturesEnabled();
            var3.writeNoException();
            byte var14 = 0;
            if(var13) {
               var14 = 1;
            }

            var3.writeInt(var14);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var11 = var2.readInt();
            boolean var12 = false;
            if(var11 != 0) {
               var12 = true;
            }

            this.setIndoorLevelPickerEnabled(var12);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var9 = this.isIndoorLevelPickerEnabled();
            var3.writeNoException();
            byte var10 = 0;
            if(var9) {
               var10 = 1;
            }

            var3.writeInt(var10);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            int var7 = var2.readInt();
            boolean var8 = false;
            if(var7 != 0) {
               var8 = true;
            }

            this.setMapToolbarEnabled(var8);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            boolean var5 = this.isMapToolbarEnabled();
            var3.writeNoException();
            byte var6 = 0;
            if(var5) {
               var6 = 1;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements IUiSettingsDelegate {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public boolean isCompassEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(10, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isIndoorLevelPickerEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(17, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isMapToolbarEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(19, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isMyLocationButtonEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(11, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isRotateGesturesEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(15, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isScrollGesturesEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(12, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isTiltGesturesEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(14, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isZoomControlsEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(9, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean isZoomGesturesEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            this.zzoz.transact(13, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public void setAllGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setCompassEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setIndoorLevelPickerEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMapToolbarEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMyLocationButtonEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setRotateGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setScrollGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setTiltGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZoomControlsEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZoomGesturesEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
