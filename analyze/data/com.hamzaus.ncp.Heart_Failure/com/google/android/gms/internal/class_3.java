package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_172;

// $FF: renamed from: com.google.android.gms.internal.as
public interface class_3 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.am, java.lang.String, com.google.android.gms.internal.bu, int) android.os.IBinder
   IBinder method_7(class_157 var1, class_172 var2, String var3, class_13 var4, int var5) throws RemoteException;

   public abstract static class class_829 extends Binder implements class_3 {
      // $FF: renamed from: g (android.os.IBinder) com.google.android.gms.internal.as
      public static class_3 method_2009(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (class_3)(var1 != null && var1 instanceof class_3?(class_3)var1:new class_3.class_830(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            class_157 var5 = class_157.class_1317.method_4176(var2.readStrongBinder());
            class_172 var6;
            if(var2.readInt() != 0) {
               var6 = class_172.CREATOR.method_1269(var2);
            } else {
               var6 = null;
            }

            IBinder var7 = this.a(var5, var6, var2.readString(), class_13.class_1091.method_1310(var2.readStrongBinder()), var2.readInt());
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

   private static class class_830 implements class_3 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2662;

      class_830(IBinder var1) {
         this.field_2662 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.am, java.lang.String, com.google.android.gms.internal.bu, int) android.os.IBinder
      public IBinder method_7(class_157 param1, class_172 param2, String param3, class_13 param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2662;
      }
   }
}
