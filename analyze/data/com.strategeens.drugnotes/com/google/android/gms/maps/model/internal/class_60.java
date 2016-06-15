package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.model.internal.h
public interface class_60 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.h) boolean
   boolean method_291(class_60 var1) throws RemoteException;

   LatLng getCenter() throws RemoteException;

   int getFillColor() throws RemoteException;

   String getId() throws RemoteException;

   double getRadius() throws RemoteException;

   int getStrokeColor() throws RemoteException;

   float getStrokeWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setCenter(LatLng var1) throws RemoteException;

   void setFillColor(int var1) throws RemoteException;

   void setRadius(double var1) throws RemoteException;

   void setStrokeColor(int var1) throws RemoteException;

   void setStrokeWidth(float var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class class_1063 extends Binder implements class_60 {
      // $FF: renamed from: bw (android.os.IBinder) com.google.android.gms.maps.model.internal.h
      public static class_60 method_1597(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            return (class_60)(var1 != null && var1 instanceof class_60?(class_60)var1:new class_60.class_1064(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            String var20 = this.getId();
            var3.writeNoException();
            var3.writeString(var20);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            LatLng var19;
            if(var2.readInt() != 0) {
               var19 = LatLng.CREATOR.method_5012(var2);
            } else {
               var19 = null;
            }

            this.setCenter(var19);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            LatLng var18 = this.getCenter();
            var3.writeNoException();
            if(var18 != null) {
               var3.writeInt(1);
               var18.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setRadius(var2.readDouble());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            double var16 = this.getRadius();
            var3.writeNoException();
            var3.writeDouble(var16);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setStrokeWidth(var2.readFloat());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            float var15 = this.getStrokeWidth();
            var3.writeNoException();
            var3.writeFloat(var15);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setStrokeColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            int var14 = this.getStrokeColor();
            var3.writeNoException();
            var3.writeInt(var14);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setFillColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            int var13 = this.getFillColor();
            var3.writeNoException();
            var3.writeInt(var13);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            float var12 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var12);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            int var10 = var2.readInt();
            boolean var11 = false;
            if(var10 != 0) {
               var11 = true;
            }

            this.setVisible(var11);
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            boolean var8 = this.isVisible();
            var3.writeNoException();
            byte var9 = 0;
            if(var8) {
               var9 = 1;
            }

            var3.writeInt(var9);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            boolean var6 = this.a(method_1597(var2.readStrongBinder()));
            var3.writeNoException();
            byte var7 = 0;
            if(var6) {
               var7 = 1;
            }

            var3.writeInt(var7);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            int var5 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1064 implements class_60 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4404;

      class_1064(IBinder var1) {
         this.field_4404 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.h) boolean
      public boolean method_291(class_60 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4404;
      }

      public LatLng getCenter() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         LatLng var5;
         label42: {
            LatLng var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
                  this.field_4404.transact(4, var1, var2, 0);
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

      public int getFillColor() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(12, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public double getRadius() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         double var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(6, var1, var2, 0);
            var2.readException();
            var5 = var2.readDouble();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public int getStrokeColor() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(10, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public float getStrokeWidth() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         float var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(8, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(14, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(18, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(16, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            this.field_4404.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setCenter(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setFillColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeInt(var1);
            this.field_4404.transact(11, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setRadius(double var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var3.writeDouble(var1);
            this.field_4404.transact(5, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void setStrokeColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeInt(var1);
            this.field_4404.transact(9, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setStrokeWidth(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeFloat(var1);
            this.field_4404.transact(7, var2, var3, 0);
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
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.ICircleDelegate");
            var2.writeFloat(var1);
            this.field_4404.transact(13, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
