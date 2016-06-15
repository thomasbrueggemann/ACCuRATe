package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_63;

// $FF: renamed from: com.google.android.gms.maps.internal.e
public interface class_111 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.l, int, int) android.graphics.Bitmap
   Bitmap method_653(class_63 var1, int var2, int var3) throws RemoteException;

   public abstract static class class_1080 extends Binder implements class_111 {
      // $FF: renamed from: aV (android.os.IBinder) com.google.android.gms.maps.internal.e
      public static class_111 method_5056(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return (class_111)(var1 != null && var1 instanceof class_111?(class_111)var1:new class_111.class_1081(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            Bitmap var5 = this.a(class_63.class_1674.method_5294(var2.readStrongBinder()), var2.readInt(), var2.readInt());
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1081 implements class_111 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_590;

      class_1081(IBinder var1) {
         this.field_590 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.l, int, int) android.graphics.Bitmap
      public Bitmap method_653(class_63 param1, int param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_590;
      }
   }
}
