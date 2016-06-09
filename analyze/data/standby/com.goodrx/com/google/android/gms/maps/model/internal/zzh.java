package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzh extends IInterface {
   void clearTileCache() throws RemoteException;

   boolean getFadeIn() throws RemoteException;

   String getId() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setFadeIn(boolean var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   boolean zza(zzh var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzh {
      public static zzh zzdl(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            return (zzh)(var1 != null && var1 instanceof zzh?(zzh)var1:new zzh.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.clearTileCache();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            String var17 = this.getId();
            var3.writeNoException();
            var3.writeString(var17);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            float var16 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var16);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            int var14 = var2.readInt();
            boolean var15 = false;
            if(var14 != 0) {
               var15 = true;
            }

            this.setVisible(var15);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            boolean var12 = this.isVisible();
            var3.writeNoException();
            byte var13 = 0;
            if(var12) {
               var13 = 1;
            }

            var3.writeInt(var13);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            boolean var10 = this.zza(zzdl(var2.readStrongBinder()));
            var3.writeNoException();
            byte var11 = 0;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            int var9 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var9);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            int var7 = var2.readInt();
            boolean var8 = false;
            if(var7 != 0) {
               var8 = true;
            }

            this.setFadeIn(var8);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            boolean var5 = this.getFadeIn();
            var3.writeNoException();
            byte var6 = 0;
            if(var5) {
               var6 = 1;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
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

      public void clearTileCache() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean getFadeIn() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
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

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.zzoz.transact(3, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public float getZIndex() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.zzoz.transact(5, var1, var2, 0);
            var2.readException();
            var5 = var2.readFloat();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public int hashCodeRemote() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.zzoz.transact(9, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isVisible() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.zzoz.transact(7, var1, var2, 0);
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

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setFadeIn(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZIndex(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(4, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public boolean zza(zzh param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
