package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.maps.internal.class_695;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {
   LatLng fromScreenLocation(class_198 var1) throws RemoteException;

   LatLng fromScreenLocation2(class_695 var1) throws RemoteException;

   VisibleRegion getVisibleRegion() throws RemoteException;

   class_198 toScreenLocation(LatLng var1) throws RemoteException;

   class_695 toScreenLocation2(LatLng var1) throws RemoteException;

   public abstract static class class_1343 extends Binder implements IProjectionDelegate {
      // $FF: renamed from: bp (android.os.IBinder) com.google.android.gms.maps.internal.IProjectionDelegate
      public static IProjectionDelegate method_3725(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (IProjectionDelegate)(var1 != null && var1 instanceof IProjectionDelegate?(IProjectionDelegate)var1:new IProjectionDelegate.class_1344(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            LatLng var15 = this.fromScreenLocation(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            if(var15 != null) {
               var3.writeInt(1);
               var15.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            LatLng var12;
            if(var2.readInt() != 0) {
               var12 = LatLng.CREATOR.method_5012(var2);
            } else {
               var12 = null;
            }

            class_198 var13 = this.toScreenLocation(var12);
            var3.writeNoException();
            IBinder var14 = null;
            if(var13 != null) {
               var14 = var13.asBinder();
            }

            var3.writeStrongBinder(var14);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            VisibleRegion var11 = this.getVisibleRegion();
            var3.writeNoException();
            if(var11 != null) {
               var3.writeInt(1);
               var11.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            int var8 = var2.readInt();
            class_695 var9 = null;
            if(var8 != 0) {
               var9 = class_695.CREATOR.method_3997(var2);
            }

            LatLng var10 = this.fromScreenLocation2(var9);
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            int var5 = var2.readInt();
            LatLng var6 = null;
            if(var5 != 0) {
               var6 = LatLng.CREATOR.method_5012(var2);
            }

            class_695 var7 = this.toScreenLocation2(var6);
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               var7.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1344 implements IProjectionDelegate {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2659;

      class_1344(IBinder var1) {
         this.field_2659 = var1;
      }

      public IBinder asBinder() {
         return this.field_2659;
      }

      public LatLng fromScreenLocation(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public LatLng fromScreenLocation2(class_695 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public VisibleRegion getVisibleRegion() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         VisibleRegion var5;
         label42: {
            VisibleRegion var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                  this.field_2659.transact(3, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = VisibleRegion.CREATOR.method_4966(var2);
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

      public class_198 toScreenLocation(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_695 toScreenLocation2(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
