package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.internal.OnEventResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.ag
public interface class_190 extends IInterface {
   // $FF: renamed from: c (com.google.android.gms.drive.internal.OnEventResponse) void
   void method_1011(OnEventResponse var1) throws RemoteException;

   public abstract static class class_1244 extends Binder implements class_190 {
      public class_1244() {
         this.attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
      }

      // $FF: renamed from: Z (android.os.IBinder) com.google.android.gms.drive.internal.ag
      public static class_190 method_4904(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
            return (class_190)(var1 != null && var1 instanceof class_190?(class_190)var1:new class_190.class_1245(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
            OnEventResponse var5;
            if(var2.readInt() != 0) {
               var5 = (OnEventResponse)OnEventResponse.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.c(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IEventCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1245 implements class_190 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4446;

      class_1245(IBinder var1) {
         this.field_4446 = var1;
      }

      public IBinder asBinder() {
         return this.field_4446;
      }

      // $FF: renamed from: c (com.google.android.gms.drive.internal.OnEventResponse) void
      public void method_1011(OnEventResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
