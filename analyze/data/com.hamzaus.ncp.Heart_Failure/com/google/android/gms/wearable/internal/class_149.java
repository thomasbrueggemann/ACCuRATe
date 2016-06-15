package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.class_700;
import com.google.android.gms.wearable.internal.class_703;
import com.google.android.gms.wearable.internal.class_705;
import com.google.android.gms.wearable.internal.class_706;
import com.google.android.gms.wearable.internal.class_708;
import com.google.android.gms.wearable.internal.class_710;
import com.google.android.gms.wearable.internal.class_760;
import com.google.android.gms.wearable.internal.class_764;
import com.google.android.gms.wearable.internal.class_766;

// $FF: renamed from: com.google.android.gms.wearable.internal.ab
public interface class_149 extends IInterface {
   // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
   void method_778(DataHolder var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
   void method_779(Status var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.am) void
   void method_780(class_764 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.aq) void
   void method_781(class_760 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.as) void
   void method_782(class_766 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
   void method_783(class_700 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.r) void
   void method_784(class_705 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
   void method_785(class_703 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
   void method_786(class_708 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
   void method_787(class_706 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
   void method_788(class_710 var1) throws RemoteException;

   public abstract static class class_872 extends Binder implements class_149 {
      public class_872() {
         this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
      }

      // $FF: renamed from: bw (android.os.IBinder) com.google.android.gms.wearable.internal.ab
      public static class_149 method_3663(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (class_149)(var1 != null && var1 instanceof class_149?(class_149)var1:new class_149.class_873(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var25 = var2.readInt();
            class_705 var26 = null;
            if(var25 != 0) {
               var26 = (class_705)class_705.CREATOR.createFromParcel(var2);
            }

            this.a(var26);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var23 = var2.readInt();
            class_764 var24 = null;
            if(var23 != 0) {
               var24 = (class_764)class_764.CREATOR.createFromParcel(var2);
            }

            this.a(var24);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var21 = var2.readInt();
            class_708 var22 = null;
            if(var21 != 0) {
               var22 = (class_708)class_708.CREATOR.createFromParcel(var2);
            }

            this.a(var22);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var19 = var2.readInt();
            DataHolder var20 = null;
            if(var19 != 0) {
               var20 = DataHolder.CREATOR.method_4283(var2);
            }

            this.Z(var20);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var17 = var2.readInt();
            class_700 var18 = null;
            if(var17 != 0) {
               var18 = (class_700)class_700.CREATOR.createFromParcel(var2);
            }

            this.a(var18);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var15 = var2.readInt();
            class_760 var16 = null;
            if(var15 != 0) {
               var16 = (class_760)class_760.CREATOR.createFromParcel(var2);
            }

            this.a(var16);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var13 = var2.readInt();
            class_706 var14 = null;
            if(var13 != 0) {
               var14 = (class_706)class_706.CREATOR.createFromParcel(var2);
            }

            this.a(var14);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var11 = var2.readInt();
            class_710 var12 = null;
            if(var11 != 0) {
               var12 = (class_710)class_710.CREATOR.createFromParcel(var2);
            }

            this.a(var12);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            int var9 = var2.readInt();
            class_703 var10 = null;
            if(var9 != 0) {
               var10 = (class_703)class_703.CREATOR.createFromParcel(var2);
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
            class_766 var6 = null;
            if(var5 != 0) {
               var6 = (class_766)class_766.CREATOR.createFromParcel(var2);
            }

            this.a(var6);
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

   private static class class_873 implements class_149 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2088;

      class_873(IBinder var1) {
         this.field_2088 = var1;
      }

      // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
      public void method_778(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_779(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.am) void
      public void method_780(class_764 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.aq) void
      public void method_781(class_760 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.as) void
      public void method_782(class_766 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
      public void method_783(class_700 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.r) void
      public void method_784(class_705 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
      public void method_785(class_703 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
      public void method_786(class_708 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
      public void method_787(class_706 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
      public void method_788(class_710 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2088;
      }
   }
}
