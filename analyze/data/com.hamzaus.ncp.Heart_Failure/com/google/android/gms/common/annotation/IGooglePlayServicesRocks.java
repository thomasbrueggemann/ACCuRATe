package com.google.android.gms.common.annotation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGooglePlayServicesRocks extends IInterface {
   public abstract static class Stub extends Binder implements IGooglePlayServicesRocks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
      }

      public static IGooglePlayServicesRocks asInterface(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
            return (IGooglePlayServicesRocks)(var1 != null && var1 instanceof IGooglePlayServicesRocks?(IGooglePlayServicesRocks)var1:new IGooglePlayServicesRocks.class_1167(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1598968902:
            var3.writeString("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1167 implements IGooglePlayServicesRocks {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3124;

      class_1167(IBinder var1) {
         this.field_3124 = var1;
      }

      public IBinder asBinder() {
         return this.field_3124;
      }
   }
}
