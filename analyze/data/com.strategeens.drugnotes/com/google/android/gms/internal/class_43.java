package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_42;

// $FF: renamed from: com.google.android.gms.internal.cy
public interface class_43 extends IInterface {
   // $FF: renamed from: x (java.lang.String) com.google.android.gms.internal.cz
   class_42 method_210(String var1) throws RemoteException;

   // $FF: renamed from: y (java.lang.String) boolean
   boolean method_211(String var1) throws RemoteException;

   public abstract static class class_1175 extends Binder implements class_43 {
      public class_1175() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      }

      // $FF: renamed from: n (android.os.IBinder) com.google.android.gms.internal.cy
      public static class_43 method_2913(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (class_43)(var1 != null && var1 instanceof class_43?(class_43)var1:new class_43.class_1176(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            class_42 var7 = this.x(var2.readString());
            var3.writeNoException();
            IBinder var8;
            if(var7 != null) {
               var8 = var7.asBinder();
            } else {
               var8 = null;
            }

            var3.writeStrongBinder(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            boolean var5 = this.y(var2.readString());
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1176 implements class_43 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1765;

      class_1176(IBinder var1) {
         this.field_1765 = var1;
      }

      public IBinder asBinder() {
         return this.field_1765;
      }

      // $FF: renamed from: x (java.lang.String) com.google.android.gms.internal.cz
      public class_42 method_210(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_42 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var2.writeString(var1);
            this.field_1765.transact(1, var2, var3, 0);
            var3.readException();
            var6 = class_42.class_1355.method_3002(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      // $FF: renamed from: y (java.lang.String) boolean
      public boolean method_211(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var9 = false;

         int var6;
         try {
            var9 = true;
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var2.writeString(var1);
            this.field_1765.transact(2, var2, var3, 0);
            var3.readException();
            var6 = var3.readInt();
            var9 = false;
         } finally {
            if(var9) {
               var3.recycle();
               var2.recycle();
            }
         }

         boolean var7 = false;
         if(var6 != 0) {
            var7 = true;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }
   }
}
