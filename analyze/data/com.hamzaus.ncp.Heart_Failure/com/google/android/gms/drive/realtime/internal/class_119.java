package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.d
public interface class_119 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
   void method_627(ParcelableCollaborator var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
   void method_628(ParcelableCollaborator var1) throws RemoteException;

   public abstract static class class_983 extends Binder implements class_119 {
      // $FF: renamed from: T (android.os.IBinder) com.google.android.gms.drive.realtime.internal.d
      public static class_119 method_2782(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return (class_119)(var1 != null && var1 instanceof class_119?(class_119)var1:new class_119.class_984(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            int var7 = var2.readInt();
            ParcelableCollaborator var8 = null;
            if(var7 != 0) {
               var8 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(var2);
            }

            this.a(var8);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            int var5 = var2.readInt();
            ParcelableCollaborator var6 = null;
            if(var5 != 0) {
               var6 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(var2);
            }

            this.b(var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_984 implements class_119 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2994;

      class_984(IBinder var1) {
         this.field_2994 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
      public void method_627(ParcelableCollaborator param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2994;
      }

      // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
      public void method_628(ParcelableCollaborator param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
