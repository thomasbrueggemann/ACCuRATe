package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.bf
public interface class_3 extends IInterface {
   void onAppEvent(String var1, String var2) throws RemoteException;

   public abstract static class class_1262 extends Binder implements class_3 {
      public class_1262() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAppEventListener");
      }

      // $FF: renamed from: h (android.os.IBinder) com.google.android.gms.internal.bf
      public static class_3 method_1598(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            return (class_3)(var1 != null && var1 instanceof class_3?(class_3)var1:new class_3.class_1263(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            this.onAppEvent(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1263 implements class_3 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3780;

      class_1263(IBinder var1) {
         this.field_3780 = var1;
      }

      public IBinder asBinder() {
         return this.field_3780;
      }

      public void onAppEvent(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
            var3.writeString(var1);
            var3.writeString(var2);
            this.field_3780.transact(1, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
