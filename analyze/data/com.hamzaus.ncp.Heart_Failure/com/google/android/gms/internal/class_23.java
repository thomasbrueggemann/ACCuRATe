package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.je
public interface class_23 extends IInterface {
   void onAddGeofencesResult(int var1, String[] var2) throws RemoteException;

   void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2) throws RemoteException;

   void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2) throws RemoteException;

   public abstract static class class_1053 extends Binder implements class_23 {
      public class_1053() {
         this.attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
      }

      // $FF: renamed from: ar (android.os.IBinder) com.google.android.gms.internal.je
      public static class_23 method_3477(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (class_23)(var1 != null && var1 instanceof class_23?(class_23)var1:new class_23.class_1054(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.onAddGeofencesResult(var2.readInt(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.onRemoveGeofencesByRequestIdsResult(var2.readInt(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            int var5 = var2.readInt();
            PendingIntent var6;
            if(var2.readInt() != 0) {
               var6 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.onRemoveGeofencesByPendingIntentResult(var5, var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1054 implements class_23 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3060;

      class_1054(IBinder var1) {
         this.field_3060 = var1;
      }

      public IBinder asBinder() {
         return this.field_3060;
      }

      public void onAddGeofencesResult(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.field_3060.transact(1, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void onRemoveGeofencesByPendingIntentResult(int param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.field_3060.transact(2, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
