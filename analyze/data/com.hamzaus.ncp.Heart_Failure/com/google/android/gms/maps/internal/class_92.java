package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_55;

// $FF: renamed from: com.google.android.gms.maps.internal.l
public interface class_92 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.f) boolean
   boolean method_592(class_55 var1) throws RemoteException;

   public abstract static class class_1109 extends Binder implements class_92 {
      public class_1109() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
      }

      // $FF: renamed from: aK (android.os.IBinder) com.google.android.gms.maps.internal.l
      public static class_92 method_3113(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (class_92)(var1 != null && var1 instanceof class_92?(class_92)var1:new class_92.class_1110(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            boolean var5 = this.a(class_55.class_1174.method_3352(var2.readStrongBinder()));
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1110 implements class_92 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2983;

      class_1110(IBinder var1) {
         this.field_2983 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.f) boolean
      public boolean method_592(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2983;
      }
   }
}
