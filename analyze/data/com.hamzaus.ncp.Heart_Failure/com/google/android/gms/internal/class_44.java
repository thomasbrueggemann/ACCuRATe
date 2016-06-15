package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_433;

// $FF: renamed from: com.google.android.gms.internal.dx
public interface class_44 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.internal.dt) com.google.android.gms.internal.dv
   class_431 method_206(class_433 var1) throws RemoteException;

   public abstract static class class_885 extends Binder implements class_44 {
      public class_885() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
      }

      // $FF: renamed from: y (android.os.IBinder) com.google.android.gms.internal.dx
      public static class_44 method_2609(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (class_44)(var1 != null && var1 instanceof class_44?(class_44)var1:new class_44.class_886(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            class_433 var5;
            if(var2.readInt() != 0) {
               var5 = class_433.CREATOR.method_2599(var2);
            } else {
               var5 = null;
            }

            class_431 var6 = this.b(var5);
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_886 implements class_44 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2108;

      class_886(IBinder var1) {
         this.field_2108 = var1;
      }

      public IBinder asBinder() {
         return this.field_2108;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.dt) com.google.android.gms.internal.dv
      public class_431 method_206(class_433 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
