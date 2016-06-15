package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_11;

// $FF: renamed from: com.google.android.gms.internal.br
public interface class_10 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.bq) void
   void method_37(class_11 var1) throws RemoteException;

   public abstract static class class_1411 extends Binder implements class_10 {
      public class_1411() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
      }

      // $FF: renamed from: j (android.os.IBinder) com.google.android.gms.internal.br
      public static class_10 method_1609(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
            return (class_10)(var1 != null && var1 instanceof class_10?(class_10)var1:new class_10.class_1412(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
            this.a(class_11.class_1409.method_1615(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1412 implements class_10 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3616;

      class_1412(IBinder var1) {
         this.field_3616 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.bq) void
      public void method_37(class_11 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3616;
      }
   }
}
