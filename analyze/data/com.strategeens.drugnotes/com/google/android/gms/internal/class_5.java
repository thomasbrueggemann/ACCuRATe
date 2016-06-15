package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_43;

// $FF: renamed from: com.google.android.gms.internal.be
public interface class_5 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.cy, int) android.os.IBinder
   IBinder method_9(class_198 var1, class_237 var2, String var3, class_43 var4, int var5) throws RemoteException;

   public abstract static class class_1542 extends Binder implements class_5 {
      // $FF: renamed from: g (android.os.IBinder) com.google.android.gms.internal.be
      public static class_5 method_5842(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (class_5)(var1 != null && var1 instanceof class_5?(class_5)var1:new class_5.class_1543(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            class_198 var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
            class_237 var6;
            if(var2.readInt() != 0) {
               var6 = class_237.CREATOR.method_1600(var2);
            } else {
               var6 = null;
            }

            IBinder var7 = this.a(var5, var6, var2.readString(), class_43.class_1175.method_2913(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1543 implements class_5 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4033;

      class_1543(IBinder var1) {
         this.field_4033 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.cy, int) android.os.IBinder
      public IBinder method_9(class_198 param1, class_237 param2, String param3, class_43 param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4033;
      }
   }
}
