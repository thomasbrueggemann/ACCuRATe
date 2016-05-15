package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public interface IPolylineDelegate extends IInterface {
   boolean equalsRemote(IPolylineDelegate var1) throws RemoteException;

   int getColor() throws RemoteException;

   String getId() throws RemoteException;

   List<LatLng> getPoints() throws RemoteException;

   float getWidth() throws RemoteException;

   float getZIndex() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isClickable() throws RemoteException;

   boolean isGeodesic() throws RemoteException;

   boolean isVisible() throws RemoteException;

   void remove() throws RemoteException;

   void setClickable(boolean var1) throws RemoteException;

   void setColor(int var1) throws RemoteException;

   void setGeodesic(boolean var1) throws RemoteException;

   void setPoints(List<LatLng> var1) throws RemoteException;

   void setVisible(boolean var1) throws RemoteException;

   void setWidth(float var1) throws RemoteException;

   void setZIndex(float var1) throws RemoteException;

   public abstract static class zza extends Binder implements IPolylineDelegate {
      public static IPolylineDelegate zzdk(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return (IPolylineDelegate)(var1 != null && var1 instanceof IPolylineDelegate?(IPolylineDelegate)var1:new IPolylineDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.remove();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            String var24 = this.getId();
            var3.writeNoException();
            var3.writeString(var24);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setPoints(var2.createTypedArrayList(LatLng.CREATOR));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            List var23 = this.getPoints();
            var3.writeNoException();
            var3.writeTypedList(var23);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setWidth(var2.readFloat());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            float var22 = this.getWidth();
            var3.writeNoException();
            var3.writeFloat(var22);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setColor(var2.readInt());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            int var21 = this.getColor();
            var3.writeNoException();
            var3.writeInt(var21);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.setZIndex(var2.readFloat());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            float var20 = this.getZIndex();
            var3.writeNoException();
            var3.writeFloat(var20);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            int var18 = var2.readInt();
            boolean var19 = false;
            if(var18 != 0) {
               var19 = true;
            }

            this.setVisible(var19);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            boolean var16 = this.isVisible();
            var3.writeNoException();
            byte var17 = 0;
            if(var16) {
               var17 = 1;
            }

            var3.writeInt(var17);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            int var14 = var2.readInt();
            boolean var15 = false;
            if(var14 != 0) {
               var15 = true;
            }

            this.setGeodesic(var15);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            boolean var12 = this.isGeodesic();
            var3.writeNoException();
            byte var13 = 0;
            if(var12) {
               var13 = 1;
            }

            var3.writeInt(var13);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            boolean var10 = this.equalsRemote(zzdk(var2.readStrongBinder()));
            var3.writeNoException();
            byte var11 = 0;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            int var9 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var9);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            int var7 = var2.readInt();
            boolean var8 = false;
            if(var7 != 0) {
               var8 = true;
            }

            this.setClickable(var8);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            boolean var5 = this.isClickable();
            var3.writeNoException();
            byte var6 = 0;
            if(var5) {
               var6 = 1;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements IPolylineDelegate {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public boolean equalsRemote(IPolylineDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getColor() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(8, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public List<LatLng> getPoints() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(4, var1, var2, 0);
            var2.readException();
            var5 = var2.createTypedArrayList(LatLng.CREATOR);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(6, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(10, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(16, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(18, var1, var2, 0);
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

      public boolean isGeodesic() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
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

      public boolean isVisible() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
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

      public void remove() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void setClickable(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setColor(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeInt(var1);
            this.zzoz.transact(7, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setGeodesic(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setPoints(List<LatLng> var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeTypedList(var1);
            this.zzoz.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setVisible(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setWidth(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(5, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setZIndex(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            var2.writeFloat(var1);
            this.zzoz.transact(9, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
