package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.class_115;

public interface ILocationSourceDelegate extends IInterface {
   void activate(class_115 var1) throws RemoteException;

   void deactivate() throws RemoteException;

   public abstract static class class_1539 extends Binder implements ILocationSourceDelegate {
      public class_1539() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
      }

      // $FF: renamed from: aW (android.os.IBinder) com.google.android.gms.maps.internal.ILocationSourceDelegate
      public static ILocationSourceDelegate method_5119(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            return (ILocationSourceDelegate)(var1 != null && var1 instanceof ILocationSourceDelegate?(ILocationSourceDelegate)var1:new ILocationSourceDelegate.class_1540(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            this.activate(class_115.class_1152.method_2916(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            this.deactivate();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1540 implements ILocationSourceDelegate {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4372;

      class_1540(IBinder var1) {
         this.field_4372 = var1;
      }

      public void activate(class_115 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4372;
      }

      public void deactivate() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            this.field_4372.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
