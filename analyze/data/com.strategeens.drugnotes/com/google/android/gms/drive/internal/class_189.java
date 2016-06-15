package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.drive.internal.ah
public interface class_189 extends IInterface {
   // $FF: renamed from: M (boolean) void
   void method_1010(boolean var1) throws RemoteException;

   public abstract static class class_1123 extends Binder implements class_189 {
      // $FF: renamed from: aa (android.os.IBinder) com.google.android.gms.drive.internal.ah
      public static class_189 method_5230(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return (class_189)(var1 != null && var1 instanceof class_189?(class_189)var1:new class_189.class_1124(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.M(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1124 implements class_189 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1253;

      class_1124(IBinder var1) {
         this.field_1253 = var1;
      }

      // $FF: renamed from: M (boolean) void
      public void method_1010(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_1253;
      }
   }
}
