package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.hi
public interface class_32 extends IInterface {
   // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
   void method_187(int var1, IBinder var2, Bundle var3) throws RemoteException;

   public abstract static class class_1064 extends Binder implements class_32 {
      public class_1064() {
         this.attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
      }

      // $FF: renamed from: K (android.os.IBinder) com.google.android.gms.internal.hi
      public static class_32 method_2755(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            return (class_32)(var1 != null && var1 instanceof class_32?(class_32)var1:new class_32.class_1065(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            int var5 = var2.readInt();
            IBinder var6 = var2.readStrongBinder();
            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.b(var5, var6, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1065 implements class_32 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2963;

      class_1065(IBinder var1) {
         this.field_2963 = var1;
      }

      public IBinder asBinder() {
         return this.field_2963;
      }

      // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
      public void method_187(int param1, IBinder param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
