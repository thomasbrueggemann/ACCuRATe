package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.class_770;
import com.google.android.gms.wearable.internal.class_773;

// $FF: renamed from: com.google.android.gms.wearable.internal.ac
public interface class_150 extends IInterface {
   // $FF: renamed from: Y (com.google.android.gms.common.data.DataHolder) void
   void method_799(DataHolder var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.af) void
   void method_800(class_773 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
   void method_801(class_770 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ai) void
   void method_802(class_770 var1) throws RemoteException;

   public abstract static class class_1306 extends Binder implements class_150 {
      public class_1306() {
         this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
      }

      // $FF: renamed from: bx (android.os.IBinder) com.google.android.gms.wearable.internal.ac
      public static class_150 method_3168(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (class_150)(var1 != null && var1 instanceof class_150?(class_150)var1:new class_150.class_1307(var0));
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
               var12 = DataHolder.CREATOR.method_4283(var2);
            }

            this.Y(var12);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var9 = var2.readInt();
            class_773 var10 = null;
            if(var9 != 0) {
               var10 = (class_773)class_773.CREATOR.createFromParcel(var2);
            }

            this.a(var10);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var7 = var2.readInt();
            class_770 var8 = null;
            if(var7 != 0) {
               var8 = (class_770)class_770.CREATOR.createFromParcel(var2);
            }

            this.a(var8);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            int var5 = var2.readInt();
            class_770 var6 = null;
            if(var5 != 0) {
               var6 = (class_770)class_770.CREATOR.createFromParcel(var2);
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

   private static class class_1307 implements class_150 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4366;

      class_1307(IBinder var1) {
         this.field_4366 = var1;
      }

      // $FF: renamed from: Y (com.google.android.gms.common.data.DataHolder) void
      public void method_799(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.af) void
      public void method_800(class_773 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
      public void method_801(class_770 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4366;
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ai) void
      public void method_802(class_770 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
