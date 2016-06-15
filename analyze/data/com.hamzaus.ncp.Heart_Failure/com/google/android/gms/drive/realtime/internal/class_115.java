package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.j
public interface class_115 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList) void
   void method_619(ParcelableEventList var1) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
   void method_620(Status var1) throws RemoteException;

   public abstract static class class_1017 extends Binder implements class_115 {
      // $FF: renamed from: Z (android.os.IBinder) com.google.android.gms.drive.realtime.internal.j
      public static class_115 method_4511(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
            return (class_115)(var1 != null && var1 instanceof class_115?(class_115)var1:new class_115.class_1018(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
            int var7 = var2.readInt();
            ParcelableEventList var8 = null;
            if(var7 != 0) {
               var8 = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(var2);
            }

            this.a(var8);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
            int var5 = var2.readInt();
            Status var6 = null;
            if(var5 != 0) {
               var6 = Status.CREATOR.createFromParcel(var2);
            }

            this.o(var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1018 implements class_115 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2799;

      class_1018(IBinder var1) {
         this.field_2799 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList) void
      public void method_619(ParcelableEventList param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2799;
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_620(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
