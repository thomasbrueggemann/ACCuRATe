package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_398;

// $FF: renamed from: com.google.android.gms.internal.hv
public interface class_25 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
   void method_177(Status var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, android.os.ParcelFileDescriptor) void
   void method_178(Status var1, ParcelFileDescriptor var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, boolean) void
   void method_179(Status var1, boolean var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.hl$b) void
   void method_180(class_398.class_1610 var1) throws RemoteException;

   public abstract static class class_1326 extends Binder implements class_25 {
      public class_1326() {
         this.attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      }

      // $FF: renamed from: F (android.os.IBinder) com.google.android.gms.internal.hv
      public static class_25 method_2670(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return (class_25)(var1 != null && var1 instanceof class_25?(class_25)var1:new class_25.class_1327(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int var13 = var2.readInt();
            Status var14 = null;
            if(var13 != 0) {
               var14 = Status.CREATOR.createFromParcel(var2);
            }

            this.a(var14);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            Status var10;
            if(var2.readInt() != 0) {
               var10 = Status.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            int var11 = var2.readInt();
            ParcelFileDescriptor var12 = null;
            if(var11 != 0) {
               var12 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            }

            this.a(var10, var12);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int var7 = var2.readInt();
            Status var8 = null;
            if(var7 != 0) {
               var8 = Status.CREATOR.createFromParcel(var2);
            }

            boolean var9;
            if(var2.readInt() != 0) {
               var9 = true;
            } else {
               var9 = false;
            }

            this.a(var8, var9);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int var5 = var2.readInt();
            class_398.class_1610 var6 = null;
            if(var5 != 0) {
               var6 = class_398.class_1610.CREATOR.method_2686(var2);
            }

            this.a(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1327 implements class_25 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2598;

      class_1327(IBinder var1) {
         this.field_2598 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_177(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, android.os.ParcelFileDescriptor) void
      public void method_178(Status param1, ParcelFileDescriptor param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, boolean) void
      public void method_179(Status param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hl$b) void
      public void method_180(class_398.class_1610 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2598;
      }
   }
}
