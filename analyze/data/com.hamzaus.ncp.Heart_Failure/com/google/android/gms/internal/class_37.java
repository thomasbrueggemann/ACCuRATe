package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.internal.fw
public interface class_37 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
   void method_192(Status var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, android.os.ParcelFileDescriptor) void
   void method_193(Status var1, ParcelFileDescriptor var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, boolean) void
   void method_194(Status var1, boolean var2) throws RemoteException;

   public abstract static class class_1066 extends Binder implements class_37 {
      public class_1066() {
         this.attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      }

      // $FF: renamed from: B (android.os.IBinder) com.google.android.gms.internal.fw
      public static class_37 method_2475(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return (class_37)(var1 != null && var1 instanceof class_37?(class_37)var1:new class_37.class_1067(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int var11 = var2.readInt();
            Status var12 = null;
            if(var11 != 0) {
               var12 = Status.CREATOR.createFromParcel(var2);
            }

            this.a(var12);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            Status var8;
            if(var2.readInt() != 0) {
               var8 = Status.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            int var9 = var2.readInt();
            ParcelFileDescriptor var10 = null;
            if(var9 != 0) {
               var10 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            }

            this.a(var8, var10);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int var5 = var2.readInt();
            Status var6 = null;
            if(var5 != 0) {
               var6 = Status.CREATOR.createFromParcel(var2);
            }

            boolean var7;
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var6, var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1067 implements class_37 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3628;

      class_1067(IBinder var1) {
         this.field_3628 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_192(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, android.os.ParcelFileDescriptor) void
      public void method_193(Status param1, ParcelFileDescriptor param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, boolean) void
      public void method_194(Status param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3628;
      }
   }
}
