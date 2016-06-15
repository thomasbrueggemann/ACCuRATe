package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.internal.class_526;

// $FF: renamed from: com.google.android.gms.maps.model.internal.i
public interface class_61 extends IInterface {
   // $FF: renamed from: a (float, float) void
   void method_292(float var1, float var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.a) void
   void method_293(class_526 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.i) boolean
   boolean method_294(class_61 var1) throws RemoteException;

   float getBearing() throws RemoteException;

   LatLngBounds getBounds() throws RemoteException;

   float getHeight() throws RemoteException;

   String getId() throws RemoteException;

   LatLng getPosition() throws RemoteException;

   float getTransparency() throws RemoteException;

   float getWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isVisible() throws RemoteException;

   // $FF: renamed from: m (com.google.android.gms.dynamic.d) void
   void method_295(class_198 var1) throws RemoteException;

   void remove() throws RemoteException;

   void setBearing(float var1) throws RemoteException;

   void setDimensions(float var1) throws RemoteException;

   void setPosition(LatLng var1) throws RemoteException;

   void setPositionFromBounds(LatLngBounds var1) throws RemoteException;

   void setTransparency(float var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class class_1676 extends Binder implements class_61 {
      // $FF: renamed from: bx (android.os.IBinder) com.google.android.gms.maps.model.internal.i
      public static class_61 method_5612(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return (class_61)(var1 != null && var1 instanceof class_61?(class_61)var1:new class_61.class_1677(var0));
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
            String var24 = this.getId();
            var3.writeNoException();
            var3.writeString(var24);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var22 = var2.readInt();
            LatLng var23 = null;
            if(var22 != 0) {
               var23 = LatLng.CREATOR.method_5012(var2);
            }

            this.setPosition(var23);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLng var21 = this.getPosition();
            var3.writeNoException();
            if(var21 != null) {
               var3.writeInt(1);
               var21.writeToParcel(var3, 1);
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
            this.a(var2.readFloat(), var2.readFloat());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var20 = this.getWidth();
            var3.writeNoException();
            var3.writeFloat(var20);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var19 = this.getHeight();
            var3.writeNoException();
            var3.writeFloat(var19);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var17 = var2.readInt();
            LatLngBounds var18 = null;
            if(var17 != 0) {
               var18 = LatLngBounds.CREATOR.method_5000(var2);
            }

            this.setPositionFromBounds(var18);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            LatLngBounds var16 = this.getBounds();
            var3.writeNoException();
            if(var16 != null) {
               var3.writeInt(1);
               var16.writeToParcel(var3, 1);
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
            float var15 = this.getBearing();
            var3.writeNoException();
            var3.writeFloat(var15);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var14 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var14);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var13;
            if(var2.readInt() != 0) {
               var13 = true;
            } else {
               var13 = false;
            }

            this.setVisible(var13);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var11 = this.isVisible();
            var3.writeNoException();
            byte var12 = 0;
            if(var11) {
               var12 = 1;
            }

            var3.writeInt(var12);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.setTransparency(var2.readFloat());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            float var10 = this.getTransparency();
            var3.writeNoException();
            var3.writeFloat(var10);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            boolean var8 = this.a(method_5612(var2.readStrongBinder()));
            var3.writeNoException();
            byte var9 = 0;
            if(var8) {
               var9 = 1;
            }

            var3.writeInt(var9);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var7 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var7);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.m(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            int var5 = var2.readInt();
            class_526 var6 = null;
            if(var5 != 0) {
               var6 = class_526.CREATOR.method_3254(var2);
            }

            this.a(var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1677 implements class_61 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4011;

      class_1677(IBinder var1) {
         this.field_4011 = var1;
      }

      // $FF: renamed from: a (float, float) void
      public void method_292(float var1, float var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var3.writeFloat(var1);
            var3.writeFloat(var2);
            this.field_4011.transact(6, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.a) void
      public void method_293(class_526 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.i) boolean
      public boolean method_294(class_61 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4011;
      }

      public float getBearing() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.field_4011.transact(12, var1, var2, 0);
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
                  this.field_4011.transact(10, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = LatLngBounds.CREATOR.method_5000(var2);
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
            this.field_4011.transact(8, var1, var2, 0);
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
            this.field_4011.transact(2, var1, var2, 0);
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
                  this.field_4011.transact(4, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = LatLng.CREATOR.method_5012(var2);
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
            this.field_4011.transact(18, var1, var2, 0);
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
            this.field_4011.transact(7, var1, var2, 0);
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
            this.field_4011.transact(14, var1, var2, 0);
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
            this.field_4011.transact(20, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.field_4011.transact(16, var1, var2, 0);
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

      // $FF: renamed from: m (com.google.android.gms.dynamic.d) void
      public void method_295(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            this.field_4011.transact(1, var1, var2, 0);
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
            this.field_4011.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setDimensions(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            var2.writeFloat(var1);
            this.field_4011.transact(5, var2, var3, 0);
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
            this.field_4011.transact(17, var2, var3, 0);
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
            this.field_4011.transact(13, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
