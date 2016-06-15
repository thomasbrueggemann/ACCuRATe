package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.iy
public interface class_16 extends IInterface {
   // $FF: renamed from: g (int, android.os.Bundle) void
   void method_69(int var1, Bundle var2) throws RemoteException;

   public abstract static class class_1085 extends Binder implements class_16 {
      public class_1085() {
         this.attachInterface(this, "com.google.android.gms.identity.intents.internal.IAddressCallbacks");
      }

      // $FF: renamed from: ao (android.os.IBinder) com.google.android.gms.internal.iy
      public static class_16 method_3863(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressCallbacks");
            return (class_16)(var1 != null && var1 instanceof class_16?(class_16)var1:new class_16.class_1086(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressCallbacks");
            int var5 = var2.readInt();
            Bundle var6;
            if(var2.readInt() != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.g(var5, var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.identity.intents.internal.IAddressCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1086 implements class_16 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3474;

      class_1086(IBinder var1) {
         this.field_3474 = var1;
      }

      public IBinder asBinder() {
         return this.field_3474;
      }

      // $FF: renamed from: g (int, android.os.Bundle) void
      public void method_69(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
