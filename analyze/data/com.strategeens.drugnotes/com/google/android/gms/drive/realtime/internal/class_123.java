package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.h
public interface class_123 extends IInterface {
   // $FF: renamed from: c (boolean, boolean) void
   void method_673(boolean var1, boolean var2) throws RemoteException;

   public abstract static class class_1154 extends Binder implements class_123 {
      // $FF: renamed from: ag (android.os.IBinder) com.google.android.gms.drive.realtime.internal.h
      public static class_123 method_5290(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            return (class_123)(var1 != null && var1 instanceof class_123?(class_123)var1:new class_123.class_1155(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            int var6 = var2.readInt();
            boolean var7 = false;
            if(var6 != 0) {
               var7 = true;
            }

            this.c(var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1155 implements class_123 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1534;

      class_1155(IBinder var1) {
         this.field_1534 = var1;
      }

      public IBinder asBinder() {
         return this.field_1534;
      }

      // $FF: renamed from: c (boolean, boolean) void
      public void method_673(boolean param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
