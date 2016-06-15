package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_328;

// $FF: renamed from: com.google.android.gms.internal.ih
public interface class_16 extends IInterface {
   // $FF: renamed from: a (int, java.lang.String, android.app.PendingIntent) void
   void method_111(int var1, String var2, PendingIntent var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.if) void
   void method_112(class_328 var1) throws RemoteException;

   public abstract static class class_1395 extends Binder implements class_16 {
      public class_1395() {
         this.attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
      }

      // $FF: renamed from: K (android.os.IBinder) com.google.android.gms.internal.ih
      public static class_16 method_5384(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return (class_16)(var1 != null && var1 instanceof class_16?(class_16)var1:new class_16.class_1396(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            int var9 = var2.readInt();
            class_328 var10 = null;
            if(var9 != 0) {
               var10 = class_328.CREATOR.method_2291(var2);
            }

            this.a(var10);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            int var5 = var2.readInt();
            String var6 = var2.readString();
            int var7 = var2.readInt();
            PendingIntent var8 = null;
            if(var7 != 0) {
               var8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            }

            this.a(var5, var6, var8);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1396 implements class_16 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4160;

      class_1396(IBinder var1) {
         this.field_4160 = var1;
      }

      // $FF: renamed from: a (int, java.lang.String, android.app.PendingIntent) void
      public void method_111(int param1, String param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.if) void
      public void method_112(class_328 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4160;
      }
   }
}
