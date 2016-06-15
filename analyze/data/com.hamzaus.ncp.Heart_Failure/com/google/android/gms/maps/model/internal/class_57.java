package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.maps.model.internal.a
public interface class_57 extends IInterface {
   // $FF: renamed from: b (android.graphics.Bitmap) com.google.android.gms.dynamic.d
   class_157 method_320(Bitmap var1) throws RemoteException;

   // $FF: renamed from: bs (java.lang.String) com.google.android.gms.dynamic.d
   class_157 method_321(String var1) throws RemoteException;

   // $FF: renamed from: bt (java.lang.String) com.google.android.gms.dynamic.d
   class_157 method_322(String var1) throws RemoteException;

   // $FF: renamed from: bu (java.lang.String) com.google.android.gms.dynamic.d
   class_157 method_323(String var1) throws RemoteException;

   // $FF: renamed from: c (float) com.google.android.gms.dynamic.d
   class_157 method_324(float var1) throws RemoteException;

   // $FF: renamed from: cX (int) com.google.android.gms.dynamic.d
   class_157 method_325(int var1) throws RemoteException;

   // $FF: renamed from: jM () com.google.android.gms.dynamic.d
   class_157 method_326() throws RemoteException;

   public abstract static class class_1013 extends Binder implements class_57 {
      // $FF: renamed from: aX (android.os.IBinder) com.google.android.gms.maps.model.internal.a
      public static class_57 method_4549(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (class_57)(var1 != null && var1 instanceof class_57?(class_57)var1:new class_57.class_1014(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            class_157 var18 = this.cX(var2.readInt());
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
            class_157 var16 = this.bs(var2.readString());
            var3.writeNoException();
            IBinder var17 = null;
            if(var16 != null) {
               var17 = var16.asBinder();
            }

            var3.writeStrongBinder(var17);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            class_157 var14 = this.bt(var2.readString());
            var3.writeNoException();
            IBinder var15 = null;
            if(var14 != null) {
               var15 = var14.asBinder();
            }

            var3.writeStrongBinder(var15);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            class_157 var12 = this.jM();
            var3.writeNoException();
            IBinder var13 = null;
            if(var12 != null) {
               var13 = var12.asBinder();
            }

            var3.writeStrongBinder(var13);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            class_157 var10 = this.c(var2.readFloat());
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

            class_157 var8 = this.b(var7);
            var3.writeNoException();
            IBinder var9 = null;
            if(var8 != null) {
               var9 = var8.asBinder();
            }

            var3.writeStrongBinder(var9);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            class_157 var5 = this.bu(var2.readString());
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

   private static class class_1014 implements class_57 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2790;

      class_1014(IBinder var1) {
         this.field_2790 = var1;
      }

      public IBinder asBinder() {
         return this.field_2790;
      }

      // $FF: renamed from: b (android.graphics.Bitmap) com.google.android.gms.dynamic.d
      public class_157 method_320(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: bs (java.lang.String) com.google.android.gms.dynamic.d
      public class_157 method_321(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_157 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.field_2790.transact(2, var2, var3, 0);
            var3.readException();
            var6 = class_157.class_1317.method_4176(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: bt (java.lang.String) com.google.android.gms.dynamic.d
      public class_157 method_322(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_157 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.field_2790.transact(3, var2, var3, 0);
            var3.readException();
            var6 = class_157.class_1317.method_4176(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: bu (java.lang.String) com.google.android.gms.dynamic.d
      public class_157 method_323(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_157 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeString(var1);
            this.field_2790.transact(7, var2, var3, 0);
            var3.readException();
            var6 = class_157.class_1317.method_4176(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: c (float) com.google.android.gms.dynamic.d
      public class_157 method_324(float var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_157 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeFloat(var1);
            this.field_2790.transact(5, var2, var3, 0);
            var3.readException();
            var6 = class_157.class_1317.method_4176(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: cX (int) com.google.android.gms.dynamic.d
      public class_157 method_325(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_157 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            var2.writeInt(var1);
            this.field_2790.transact(1, var2, var3, 0);
            var3.readException();
            var6 = class_157.class_1317.method_4176(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: jM () com.google.android.gms.dynamic.d
      public class_157 method_326() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_157 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            this.field_2790.transact(4, var1, var2, 0);
            var2.readException();
            var5 = class_157.class_1317.method_4176(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
