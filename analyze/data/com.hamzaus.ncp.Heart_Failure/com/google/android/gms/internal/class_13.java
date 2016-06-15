package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_11;

// $FF: renamed from: com.google.android.gms.internal.bu
public interface class_13 extends IInterface {
   // $FF: renamed from: m (java.lang.String) com.google.android.gms.internal.bv
   class_11 method_24(String var1) throws RemoteException;

   public abstract static class class_1091 extends Binder implements class_13 {
      public class_1091() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      }

      // $FF: renamed from: i (android.os.IBinder) com.google.android.gms.internal.bu
      public static class_13 method_1310(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (class_13)(var1 != null && var1 instanceof class_13?(class_13)var1:new class_13.class_1092(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            class_11 var5 = this.m(var2.readString());
            var3.writeNoException();
            IBinder var6;
            if(var5 != null) {
               var6 = var5.asBinder();
            } else {
               var6 = null;
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1092 implements class_13 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3982;

      class_1092(IBinder var1) {
         this.field_3982 = var1;
      }

      public IBinder asBinder() {
         return this.field_3982;
      }

      // $FF: renamed from: m (java.lang.String) com.google.android.gms.internal.bv
      public class_11 method_24(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         class_11 var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var2.writeString(var1);
            this.field_3982.transact(1, var2, var3, 0);
            var3.readException();
            var6 = class_11.class_1093.method_1305(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }
   }
}
