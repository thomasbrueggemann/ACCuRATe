package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;

// $FF: renamed from: com.google.android.gms.internal.fl
public interface class_38 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.internal.fh) com.google.android.gms.internal.fj
   class_438 method_196(class_440 var1) throws RemoteException;

   public abstract static class class_1388 extends Binder implements class_38 {
      public class_1388() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
      }

      // $FF: renamed from: C (android.os.IBinder) com.google.android.gms.internal.fl
      public static class_38 method_2829(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (class_38)(var1 != null && var1 instanceof class_38?(class_38)var1:new class_38.class_1389(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            class_440 var5;
            if(var2.readInt() != 0) {
               var5 = class_440.CREATOR.method_2883(var2);
            } else {
               var5 = null;
            }

            class_438 var6 = this.b(var5);
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1389 implements class_38 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3063;

      class_1389(IBinder var1) {
         this.field_3063 = var1;
      }

      public IBinder asBinder() {
         return this.field_3063;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.fh) com.google.android.gms.internal.fj
      public class_438 method_196(class_440 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
