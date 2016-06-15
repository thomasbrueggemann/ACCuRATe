package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_63;

// $FF: renamed from: com.google.android.gms.maps.internal.n
public interface class_104 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.l) boolean
   boolean method_645(class_63 var1) throws RemoteException;

   public abstract static class class_1501 extends Binder implements class_104 {
      public class_1501() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
      }

      // $FF: renamed from: bh (android.os.IBinder) com.google.android.gms.maps.internal.n
      public static class_104 method_3711(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (class_104)(var1 != null && var1 instanceof class_104?(class_104)var1:new class_104.class_1502(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            boolean var5 = this.a(class_63.class_1674.method_5294(var2.readStrongBinder()));
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

   private static class class_1502 implements class_104 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3887;

      class_1502(IBinder var1) {
         this.field_3887 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.l) boolean
      public boolean method_645(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3887;
      }
   }
}
