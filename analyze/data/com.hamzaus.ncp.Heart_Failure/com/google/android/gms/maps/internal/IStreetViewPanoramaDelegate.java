package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.maps.internal.class_96;
import com.google.android.gms.maps.internal.class_97;
import com.google.android.gms.maps.internal.class_98;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface IStreetViewPanoramaDelegate extends IInterface {
   void animateTo(StreetViewPanoramaCamera var1, long var2) throws RemoteException;

   void enablePanning(boolean var1) throws RemoteException;

   void enableStreetNames(boolean var1) throws RemoteException;

   void enableUserNavigation(boolean var1) throws RemoteException;

   void enableZoom(boolean var1) throws RemoteException;

   StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

   StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

   boolean isPanningGesturesEnabled() throws RemoteException;

   boolean isStreetNamesEnabled() throws RemoteException;

   boolean isUserNavigationEnabled() throws RemoteException;

   boolean isZoomGesturesEnabled() throws RemoteException;

   class_157 orientationToPoint(StreetViewPanoramaOrientation var1) throws RemoteException;

   StreetViewPanoramaOrientation pointToOrientation(class_157 var1) throws RemoteException;

   void setOnStreetViewPanoramaCameraChangeListener(class_96 var1) throws RemoteException;

   void setOnStreetViewPanoramaChangeListener(class_97 var1) throws RemoteException;

   void setOnStreetViewPanoramaClickListener(class_98 var1) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setPositionWithID(String var1) throws RemoteException;

   void setPositionWithRadius(LatLng var1, int var2) throws RemoteException;

   public abstract static class class_870 extends Binder implements IStreetViewPanoramaDelegate {
      // $FF: renamed from: aT (android.os.IBinder) com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate
      public static IStreetViewPanoramaDelegate method_4071(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return (IStreetViewPanoramaDelegate)(var1 != null && var1 instanceof IStreetViewPanoramaDelegate?(IStreetViewPanoramaDelegate)var1:new IStreetViewPanoramaDelegate.class_871(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            int var30 = var2.readInt();
            boolean var31 = false;
            if(var30 != 0) {
               var31 = true;
            }

            this.enableZoom(var31);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            int var28 = var2.readInt();
            boolean var29 = false;
            if(var28 != 0) {
               var29 = true;
            }

            this.enablePanning(var29);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            int var26 = var2.readInt();
            boolean var27 = false;
            if(var26 != 0) {
               var27 = true;
            }

            this.enableUserNavigation(var27);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            int var24 = var2.readInt();
            boolean var25 = false;
            if(var24 != 0) {
               var25 = true;
            }

            this.enableStreetNames(var25);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean var22 = this.isZoomGesturesEnabled();
            var3.writeNoException();
            byte var23 = 0;
            if(var22) {
               var23 = 1;
            }

            var3.writeInt(var23);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean var20 = this.isPanningGesturesEnabled();
            var3.writeNoException();
            byte var21 = 0;
            if(var20) {
               var21 = 1;
            }

            var3.writeInt(var21);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean var18 = this.isUserNavigationEnabled();
            var3.writeNoException();
            byte var19 = 0;
            if(var18) {
               var19 = 1;
            }

            var3.writeInt(var19);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            boolean var16 = this.isStreetNamesEnabled();
            var3.writeNoException();
            byte var17 = 0;
            if(var16) {
               var17 = 1;
            }

            var3.writeInt(var17);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaCamera var15;
            if(var2.readInt() != 0) {
               var15 = StreetViewPanoramaCamera.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            this.animateTo(var15, var2.readLong());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaCamera var14 = this.getPanoramaCamera();
            var3.writeNoException();
            if(var14 != null) {
               var3.writeInt(1);
               var14.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setPositionWithID(var2.readString());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            int var12 = var2.readInt();
            LatLng var13 = null;
            if(var12 != 0) {
               var13 = LatLng.CREATOR.createFromParcel(var2);
            }

            this.setPosition(var13);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            int var10 = var2.readInt();
            LatLng var11 = null;
            if(var10 != 0) {
               var11 = LatLng.CREATOR.createFromParcel(var2);
            }

            this.setPositionWithRadius(var11, var2.readInt());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaLocation var9 = this.getStreetViewPanoramaLocation();
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setOnStreetViewPanoramaChangeListener(class_97.class_993.method_1335(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setOnStreetViewPanoramaCameraChangeListener(class_96.class_1101.method_1336(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.setOnStreetViewPanoramaClickListener(class_98.class_842.method_1333(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaOrientation var8 = this.pointToOrientation(class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            StreetViewPanoramaOrientation var5;
            if(var2.readInt() != 0) {
               var5 = StreetViewPanoramaOrientation.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            class_157 var6 = this.orientationToPoint(var5);
            var3.writeNoException();
            IBinder var7 = null;
            if(var6 != null) {
               var7 = var6.asBinder();
            }

            var3.writeStrongBinder(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_871 implements IStreetViewPanoramaDelegate {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3675;

      class_871(IBinder var1) {
         this.field_3675 = var1;
      }

      public void animateTo(StreetViewPanoramaCamera param1, long param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3675;
      }

      public void enablePanning(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void enableStreetNames(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void enableUserNavigation(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void enableZoom(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         StreetViewPanoramaCamera var5;
         label42: {
            StreetViewPanoramaCamera var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                  this.field_3675.transact(10, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = StreetViewPanoramaCamera.CREATOR.createFromParcel(var2);
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

      public StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         StreetViewPanoramaLocation var5;
         label42: {
            StreetViewPanoramaLocation var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                  this.field_3675.transact(14, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = StreetViewPanoramaLocation.CREATOR.createFromParcel(var2);
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

      public boolean isPanningGesturesEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.field_3675.transact(6, var1, var2, 0);
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

      public boolean isStreetNamesEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.field_3675.transact(8, var1, var2, 0);
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

      public boolean isUserNavigationEnabled() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.field_3675.transact(7, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            this.field_3675.transact(5, var1, var2, 0);
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

      public class_157 orientationToPoint(StreetViewPanoramaOrientation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public StreetViewPanoramaOrientation pointToOrientation(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnStreetViewPanoramaCameraChangeListener(class_96 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnStreetViewPanoramaChangeListener(class_97 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnStreetViewPanoramaClickListener(class_98 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPosition(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPositionWithID(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            var2.writeString(var1);
            this.field_3675.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setPositionWithRadius(LatLng param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
