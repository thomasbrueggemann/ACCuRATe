package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface zzc extends IInterface {
   float getBearing() throws RemoteException;

   LatLngBounds getBounds() throws RemoteException;

   float getHeight() throws RemoteException;

   String getId() throws RemoteException;

   LatLng getPosition() throws RemoteException;

   float getTransparency() throws RemoteException;

   float getWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isClickable() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setBearing(float var1) throws RemoteException;

   void setClickable(boolean var1) throws RemoteException;

   void setDimensions(float var1) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setPositionFromBounds(LatLngBounds var1) throws RemoteException;

   void setTransparency(float var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   void zza(float var1, float var2) throws RemoteException;

   boolean zzb(zzc var1) throws RemoteException;

   void zzv(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzc {
      public static zzc zzdf(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return (zzc)(var1 != null && var1 instanceof zzc?(zzc)var1:new zzc.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            String var26 = this.getId();
            var3.writeNoException();
            var3.writeString(var26);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var24 = var2.readInt();
            LatLng var25 = null;
            if(var24 != 0) {
               var25 = LatLng.CREATOR.zzfz(var2);
            }

            this.setPosition(var25);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLng var23 = this.getPosition();
            var3.writeNoException();
            if(var23 != null) {
               var3.writeInt(1);
               var23.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setDimensions(var2.readFloat());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zza(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var22 = this.getWidth();
            var3.writeNoException();
            var3.writeFloat(var22);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var21 = this.getHeight();
            var3.writeNoException();
            var3.writeFloat(var21);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var19 = var2.readInt();
            LatLngBounds var20 = null;
            if(var19 != 0) {
               var20 = LatLngBounds.CREATOR.zzfy(var2);
            }

            this.setPositionFromBounds(var20);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLngBounds var18 = this.getBounds();
            var3.writeNoException();
            if(var18 != null) {
               var3.writeInt(1);
               var18.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setBearing(var2.readFloat());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var17 = this.getBearing();
            var3.writeNoException();
            var3.writeFloat(var17);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var16 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var16);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var15;
            if(var2.readInt() != 0) {
               var15 = true;
            } else {
               var15 = false;
            }

            this.setVisible(var15);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var13 = this.isVisible();
            var3.writeNoException();
            byte var14 = 0;
            if(var13) {
               var14 = 1;
            }

            var3.writeInt(var14);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setTransparency(var2.readFloat());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var12 = this.getTransparency();
            var3.writeNoException();
            var3.writeFloat(var12);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var10 = this.zzb(zzdf(var2.readStrongBinder()));
            var3.writeNoException();
            byte var11 = 0;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var9 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var9);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzv(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var7 = var2.readInt();
            boolean var8 = false;
            if(var7 != 0) {
               var8 = true;
            }

            this.setClickable(var8);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var5 = this.isClickable();
            var3.writeNoException();
            byte var6 = 0;
            if(var5) {
               var6 = 1;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
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

      public float getBearing() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(12, var1, var2, 0);
            var2.readException();
            var5 = var2.readFloat();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public LatLngBounds getBounds() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         LatLngBounds var5;
         label42: {
            LatLngBounds var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                  this.zzoz.transact(10, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = LatLngBounds.CREATOR.zzfy(var2);
                     var8 = false;
                     break label41;
                  }

                  var8 = false;
               } finally {
                  if(var8) {
                     var2.recycle();
                     var1.recycle();
                  }
               }

               var5 = null;
               break label42;
            }

            var5 = var6;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public float getHeight() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
            var5 = var2.readFloat();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public LatLng getPosition() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         LatLng var5;
         label42: {
            LatLng var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                  this.zzoz.transact(4, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = LatLng.CREATOR.zzfz(var2);
                     var8 = false;
                     break label41;
                  }

                  var8 = false;
               } finally {
                  if(var8) {
                     var2.recycle();
                     var1.recycle();
                  }
               }

               var5 = null;
               break label42;
            }

            var5 = var6;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public float getTransparency() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(18, var1, var2, 0);
            var2.readException();
            var5 = var2.readFloat();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public float getWidth() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(7, var1, var2, 0);
            var2.readException();
            var5 = var2.readFloat();
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(14, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(20, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isClickable() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(23, var1, var2, 0);
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

      public boolean isVisible() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(16, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setBearing(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setClickable(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setDimensions(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setPosition(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPositionFromBounds(LatLngBounds param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setTransparency(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(17, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setZIndex(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(13, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void zza(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.zzoz.transact(6, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public boolean zzb(zzc param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzv(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
