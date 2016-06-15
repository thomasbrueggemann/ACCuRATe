package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.internal.cp
public interface class_41 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d) android.os.IBinder
   IBinder method_202(class_157 var1) throws RemoteException;

   public abstract static class class_1037 extends Binder implements class_41 {
      // $FF: renamed from: n (android.os.IBinder) com.google.android.gms.internal.cp
      public static class_41 method_4172(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (class_41)(var1 != null && var1 instanceof class_41?(class_41)var1:new class_41.class_1038(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            IBinder var5 = this.a(class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1038 implements class_41 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3685;

      class_1038(IBinder var1) {
         this.field_3685 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d) android.os.IBinder
      public IBinder method_202(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3685;
      }
   }
}
