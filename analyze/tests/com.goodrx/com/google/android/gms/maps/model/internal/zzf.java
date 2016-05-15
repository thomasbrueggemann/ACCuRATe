package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public interface zzf extends IInterface {
   float getAlpha() throws RemoteException;

   String getId() throws RemoteException;

   LatLng getPosition() throws RemoteException;

   float getRotation() throws RemoteException;

   String getSnippet() throws RemoteException;

   String getTitle() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   void hideInfoWindow() throws RemoteException;

   boolean isDraggable() throws RemoteException;

   boolean isFlat() throws RemoteException;

   boolean isInfoWindowShown() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setAlpha(float var1) throws RemoteException;

   void setAnchor(float var1, float var2) throws RemoteException;

   void setDraggable(boolean var1) throws RemoteException;

   void setFlat(boolean var1) throws RemoteException;

   void setInfoWindowAnchor(float var1, float var2) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setRotation(float var1) throws RemoteException;

   void setSnippet(String var1) throws RemoteException;

   void setTitle(String var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void showInfoWindow() throws RemoteException;

   boolean zzj(zzf var1) throws RemoteException;

   void zzw(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzf {
      public static zzf zzdi(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            return (zzf)(var1 != null && var1 instanceof zzf?(zzf)var1:new zzf.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            String var28 = this.getId();
            var3.writeNoException();
            var3.writeString(var28);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            LatLng var27;
            if(var2.readInt() != 0) {
               var27 = LatLng.CREATOR.zzfz(var2);
            } else {
               var27 = null;
            }

            this.setPosition(var27);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            LatLng var26 = this.getPosition();
            var3.writeNoException();
            if(var26 != null) {
               var3.writeInt(1);
               var26.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setTitle(var2.readString());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            String var25 = this.getTitle();
            var3.writeNoException();
            var3.writeString(var25);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setSnippet(var2.readString());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            String var24 = this.getSnippet();
            var3.writeNoException();
            var3.writeString(var24);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            int var22 = var2.readInt();
            boolean var23 = false;
            if(var22 != 0) {
               var23 = true;
            }

            this.setDraggable(var23);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            boolean var20 = this.isDraggable();
            var3.writeNoException();
            byte var21 = 0;
            if(var20) {
               var21 = 1;
            }

            var3.writeInt(var21);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.showInfoWindow();
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.hideInfoWindow();
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            boolean var18 = this.isInfoWindowShown();
            var3.writeNoException();
            byte var19 = 0;
            if(var18) {
               var19 = 1;
            }

            var3.writeInt(var19);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            int var16 = var2.readInt();
            boolean var17 = false;
            if(var16 != 0) {
               var17 = true;
            }

            this.setVisible(var17);
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            boolean var14 = this.isVisible();
            var3.writeNoException();
            byte var15 = 0;
            if(var14) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            boolean var12 = this.zzj(zzdi(var2.readStrongBinder()));
            var3.writeNoException();
            byte var13 = 0;
            if(var12) {
               var13 = 1;
            }

            var3.writeInt(var13);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            int var11 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var11);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzw(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setAnchor(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            int var9 = var2.readInt();
            boolean var10 = false;
            if(var9 != 0) {
               var10 = true;
            }

            this.setFlat(var10);
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            boolean var7 = this.isFlat();
            var3.writeNoException();
            byte var8 = 0;
            if(var7) {
               var8 = 1;
            }

            var3.writeInt(var8);
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setRotation(var2.readFloat());
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            float var6 = this.getRotation();
            var3.writeNoException();
            var3.writeFloat(var6);
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setInfoWindowAnchor(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.setAlpha(var2.readFloat());
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            float var5 = this.getAlpha();
            var3.writeNoException();
            var3.writeFloat(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzf {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public float getAlpha() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(26, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
                  var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

      public float getRotation() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(23, var1, var2, 0);
            var2.readException();
            var5 = var2.readFloat();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getSnippet() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getTitle() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(6, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(17, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void hideInfoWindow() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(12, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean isDraggable() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

      public boolean isFlat() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(21, var1, var2, 0);
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

      public boolean isInfoWindowShown() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

      public boolean isVisible() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setAlpha(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(25, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setAnchor(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.zzoz.transact(19, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void setDraggable(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setFlat(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowAnchor(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.zzoz.transact(24, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void setPosition(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setRotation(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(22, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setSnippet(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeString(var1);
            this.zzoz.transact(7, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setTitle(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            var2.writeString(var1);
            this.zzoz.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void showInfoWindow() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            this.zzoz.transact(11, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean zzj(zzf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzw(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
