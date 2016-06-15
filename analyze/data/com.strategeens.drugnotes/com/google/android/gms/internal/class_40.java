package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.cm
public interface class_40 extends IInterface {
   // $FF: renamed from: bN () android.os.Bundle
   Bundle method_198() throws RemoteException;

   public abstract static class class_1167 extends Binder implements class_40 {
      // $FF: renamed from: m (android.os.IBinder) com.google.android.gms.internal.cm
      public static class_40 method_3041(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            return (class_40)(var1 != null && var1 instanceof class_40?(class_40)var1:new class_40.class_1168(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            Bundle var5 = this.bN();
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1168 implements class_40 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3190;

      class_1168(IBinder var1) {
         this.field_3190 = var1;
      }

      public IBinder asBinder() {
         return this.field_3190;
      }

      // $FF: renamed from: bN () android.os.Bundle
      public Bundle method_198() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
               this.field_3190.transact(1, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }
   }
}
