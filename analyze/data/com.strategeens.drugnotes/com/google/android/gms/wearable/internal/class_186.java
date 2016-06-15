package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.class_912;
import com.google.android.gms.wearable.internal.class_915;
import com.google.android.gms.wearable.internal.class_917;
import com.google.android.gms.wearable.internal.class_918;
import com.google.android.gms.wearable.internal.class_920;
import com.google.android.gms.wearable.internal.class_922;
import com.google.android.gms.wearable.internal.class_981;
import com.google.android.gms.wearable.internal.class_990;
import com.google.android.gms.wearable.internal.class_993;
import com.google.android.gms.wearable.internal.class_998;

// $FF: renamed from: com.google.android.gms.wearable.internal.ad
public interface class_186 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
   void method_964(Status var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
   void method_965(class_998 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ap) void
   void method_966(class_981 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.at) void
   void method_967(class_993 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
   void method_968(class_990 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
   void method_969(class_912 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.r) void
   void method_970(class_917 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
   void method_971(class_915 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
   void method_972(class_920 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
   void method_973(class_918 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
   void method_974(class_922 var1) throws RemoteException;

   // $FF: renamed from: ab (com.google.android.gms.common.data.DataHolder) void
   void method_975(DataHolder var1) throws RemoteException;

   public abstract static class class_1221 extends Binder implements class_186 {
      public class_1221() {
         this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
      }

      // $FF: renamed from: bX (android.os.IBinder) com.google.android.gms.wearable.internal.ad
      public static class_186 method_4132(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (class_186)(var1 != null && var1 instanceof class_186?(class_186)var1:new class_186.class_1222(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var27 = var2.readInt();
            class_917 var28 = null;
            if(var27 != 0) {
               var28 = (class_917)class_917.CREATOR.createFromParcel(var2);
            }

            this.a(var28);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var23 = var2.readInt();
            class_981 var24 = null;
            if(var23 != 0) {
               var24 = (class_981)class_981.CREATOR.createFromParcel(var2);
            }

            this.a(var24);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var21 = var2.readInt();
            class_918 var22 = null;
            if(var21 != 0) {
               var22 = (class_918)class_918.CREATOR.createFromParcel(var2);
            }

            this.a(var22);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var19 = var2.readInt();
            DataHolder var20 = null;
            if(var19 != 0) {
               var20 = DataHolder.CREATOR.method_5394(var2);
            }

            this.ab(var20);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var17 = var2.readInt();
            class_912 var18 = null;
            if(var17 != 0) {
               var18 = (class_912)class_912.CREATOR.createFromParcel(var2);
            }

            this.a(var18);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var15 = var2.readInt();
            class_993 var16 = null;
            if(var15 != 0) {
               var16 = (class_993)class_993.CREATOR.createFromParcel(var2);
            }

            this.a(var16);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var13 = var2.readInt();
            class_922 var14 = null;
            if(var13 != 0) {
               var14 = (class_922)class_922.CREATOR.createFromParcel(var2);
            }

            this.a(var14);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var11 = var2.readInt();
            class_998 var12 = null;
            if(var11 != 0) {
               var12 = (class_998)class_998.CREATOR.createFromParcel(var2);
            }

            this.a(var12);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var9 = var2.readInt();
            class_920 var10 = null;
            if(var9 != 0) {
               var10 = (class_920)class_920.CREATOR.createFromParcel(var2);
            }

            this.a(var10);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var7 = var2.readInt();
            Status var8 = null;
            if(var7 != 0) {
               var8 = Status.CREATOR.createFromParcel(var2);
            }

            this.a(var8);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var5 = var2.readInt();
            class_990 var6 = null;
            if(var5 != 0) {
               var6 = (class_990)class_990.CREATOR.createFromParcel(var2);
            }

            this.a(var6);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var25 = var2.readInt();
            class_915 var26 = null;
            if(var25 != 0) {
               var26 = (class_915)class_915.CREATOR.createFromParcel(var2);
            }

            this.a(var26);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1222 implements class_186 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1877;

      class_1222(IBinder var1) {
         this.field_1877 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_964(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
      public void method_965(class_998 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ap) void
      public void method_966(class_981 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.at) void
      public void method_967(class_993 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
      public void method_968(class_990 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
      public void method_969(class_912 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.r) void
      public void method_970(class_917 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
      public void method_971(class_915 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
      public void method_972(class_920 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
      public void method_973(class_918 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
      public void method_974(class_922 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ab (com.google.android.gms.common.data.DataHolder) void
      public void method_975(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_1877;
      }
   }
}
