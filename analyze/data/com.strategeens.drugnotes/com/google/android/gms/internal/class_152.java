package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_149;

// $FF: renamed from: com.google.android.gms.internal.my
public interface class_152 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.mx, com.google.android.gms.identity.intents.UserAddressRequest, android.os.Bundle) void
   void method_815(class_149 var1, UserAddressRequest var2, Bundle var3) throws RemoteException;

   public abstract static class class_1440 extends Binder implements class_152 {
      // $FF: renamed from: aK (android.os.IBinder) com.google.android.gms.internal.my
      public static class_152 method_4128(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (class_152)(var1 != null && var1 instanceof class_152?(class_152)var1:new class_152.class_1441(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            class_149 var5 = class_149.class_1085.method_2166(var2.readStrongBinder());
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

   private static class class_1441 implements class_152 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3745;

      class_1441(IBinder var1) {
         this.field_3745 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.mx, com.google.android.gms.identity.intents.UserAddressRequest, android.os.Bundle) void
      public void method_815(class_149 param1, UserAddressRequest param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3745;
      }
   }
}
