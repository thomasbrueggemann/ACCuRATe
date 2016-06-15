package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.oj
public interface class_164 extends IInterface {
   // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
   void method_837(int var1, Bundle var2, int var3, Intent var4) throws RemoteException;

   public abstract static class class_1281 extends Binder implements class_164 {
      public class_1281() {
         this.attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
      }

      // $FF: renamed from: bF (android.os.IBinder) com.google.android.gms.internal.oj
      public static class_164 method_3139(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            return (class_164)(var1 != null && var1 instanceof class_164?(class_164)var1:new class_164.class_1282(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            int var5 = var2.readInt();
            Bundle var6;
            if(var2.readInt() != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            int var7 = var2.readInt();
            Intent var8;
            if(var2.readInt() != 0) {
               var8 = (Intent)Intent.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var5, var6, var7, var8);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1282 implements class_164 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3883;

      class_1282(IBinder var1) {
         this.field_3883 = var1;
      }

      // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
      public void method_837(int param1, Bundle param2, int param3, Intent param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3883;
      }
   }
}
