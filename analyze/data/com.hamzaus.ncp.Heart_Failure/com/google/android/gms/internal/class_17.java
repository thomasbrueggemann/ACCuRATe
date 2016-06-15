package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_16;

// $FF: renamed from: com.google.android.gms.internal.iz
public interface class_17 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.iy, com.google.android.gms.identity.intents.UserAddressRequest, android.os.Bundle) void
   void method_70(class_16 var1, UserAddressRequest var2, Bundle var3) throws RemoteException;

   public abstract static class class_1033 extends Binder implements class_17 {
      // $FF: renamed from: ap (android.os.IBinder) com.google.android.gms.internal.iz
      public static class_17 method_4299(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (class_17)(var1 != null && var1 instanceof class_17?(class_17)var1:new class_17.class_1034(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            class_16 var5 = class_16.class_1085.method_3863(var2.readStrongBinder());
            UserAddressRequest var6;
            if(var2.readInt() != 0) {
               var6 = (UserAddressRequest)UserAddressRequest.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.a(var5, var6, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1034 implements class_17 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2907;

      class_1034(IBinder var1) {
         this.field_2907 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.iy, com.google.android.gms.identity.intents.UserAddressRequest, android.os.Bundle) void
      public void method_70(class_16 param1, UserAddressRequest param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2907;
      }
   }
}
