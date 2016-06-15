package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.maps.internal.q
public interface class_107 extends IInterface {
   // $FF: renamed from: c (android.location.Location) void
   void method_649(Location var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.dynamic.d) void
   void method_650(class_198 var1) throws RemoteException;

   public abstract static class class_1314 extends Binder implements class_107 {
      public class_1314() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
      }

      // $FF: renamed from: bk (android.os.IBinder) com.google.android.gms.maps.internal.q
      public static class_107 method_3404(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return (class_107)(var1 != null && var1 instanceof class_107?(class_107)var1:new class_107.class_1315(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            this.g(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            Location var5;
            if(var2.readInt() != 0) {
               var5 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.c(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1315 implements class_107 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2629;

      class_1315(IBinder var1) {
         this.field_2629 = var1;
      }

      public IBinder asBinder() {
         return this.field_2629;
      }

      // $FF: renamed from: c (android.location.Location) void
      public void method_649(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.dynamic.d) void
      public void method_650(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
