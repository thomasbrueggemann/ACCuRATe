package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.dynamic.d
public interface class_157 extends IInterface {
   public abstract static class class_1317 extends Binder implements class_157 {
      public class_1317() {
         this.attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
      }

      // $FF: renamed from: ag (android.os.IBinder) com.google.android.gms.dynamic.d
      public static class_157 method_4176(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (class_157)(var1 != null && var1 instanceof class_157?(class_157)var1:new class_157.class_1318(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1598968902:
            var3.writeString("com.google.android.gms.dynamic.IObjectWrapper");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1318 implements class_157 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3984;

      class_1318(IBinder var1) {
         this.field_3984 = var1;
      }

      public IBinder asBinder() {
         return this.field_3984;
      }
   }
}
