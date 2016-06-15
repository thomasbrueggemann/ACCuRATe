package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.internal.dy
public interface class_51 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.dynamic.d) android.os.IBinder
   IBinder method_219(class_198 var1) throws RemoteException;

   public abstract static class class_1118 extends Binder implements class_51 {
      // $FF: renamed from: s (android.os.IBinder) com.google.android.gms.internal.dy
      public static class_51 method_2690(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (class_51)(var1 != null && var1 instanceof class_51?(class_51)var1:new class_51.class_1119(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            IBinder var5 = this.b(class_198.class_1672.method_5291(var2.readStrongBinder()));
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

   private static class class_1119 implements class_51 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3234;

      class_1119(IBinder var1) {
         this.field_3234 = var1;
      }

      public IBinder asBinder() {
         return this.field_3234;
      }

      // $FF: renamed from: b (com.google.android.gms.dynamic.d) android.os.IBinder
      public IBinder method_219(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
