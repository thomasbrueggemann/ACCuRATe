package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.class_1000;
import com.google.android.gms.wearable.internal.class_985;

// $FF: renamed from: com.google.android.gms.wearable.internal.ae
public interface class_187 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
   void method_976(class_1000 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.al) void
   void method_977(class_985 var1) throws RemoteException;

   // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
   void method_978(DataHolder var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.al) void
   void method_979(class_985 var1) throws RemoteException;

   public abstract static class class_1336 extends Binder implements class_187 {
      public class_1336() {
         this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
      }

      // $FF: renamed from: bY (android.os.IBinder) com.google.android.gms.wearable.internal.ae
      public static class_187 method_3413(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (class_187)(var1 != null && var1 instanceof class_187?(class_187)var1:new class_187.class_1337(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var11 = var2.readInt();
            DataHolder var12 = null;
            if(var11 != 0) {
               var12 = DataHolder.CREATOR.method_5394(var2);
            }

            this.aa(var12);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var9 = var2.readInt();
            class_1000 var10 = null;
            if(var9 != 0) {
               var10 = (class_1000)class_1000.CREATOR.createFromParcel(var2);
            }

            this.a(var10);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var7 = var2.readInt();
            class_985 var8 = null;
            if(var7 != 0) {
               var8 = (class_985)class_985.CREATOR.createFromParcel(var2);
            }

            this.a(var8);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var5 = var2.readInt();
            class_985 var6 = null;
            if(var5 != 0) {
               var6 = (class_985)class_985.CREATOR.createFromParcel(var2);
            }

            this.b(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1337 implements class_187 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4463;

      class_1337(IBinder var1) {
         this.field_4463 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
      public void method_976(class_1000 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.al) void
      public void method_977(class_985 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
      public void method_978(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4463;
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.al) void
      public void method_979(class_985 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
