package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.nh
public interface class_146 extends IInterface {
   // $FF: renamed from: a (int, android.app.PendingIntent) void
   void method_771(int var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: a (int, java.lang.String[]) void
   void method_772(int var1, String[] var2) throws RemoteException;

   // $FF: renamed from: b (int, java.lang.String[]) void
   void method_773(int var1, String[] var2) throws RemoteException;

   public abstract static class class_1445 extends Binder implements class_146 {
      public class_1445() {
         this.attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
      }

      // $FF: renamed from: aN (android.os.IBinder) com.google.android.gms.internal.nh
      public static class_146 method_3755(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return (class_146)(var1 != null && var1 instanceof class_146?(class_146)var1:new class_146.class_1446(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.a(var2.readInt(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            this.b(var2.readInt(), var2.createStringArray());
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

            this.a(var5, var6);
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

   private static class class_1446 implements class_146 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3790;

      class_1446(IBinder var1) {
         this.field_3790 = var1;
      }

      // $FF: renamed from: a (int, android.app.PendingIntent) void
      public void method_771(int param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, java.lang.String[]) void
      public void method_772(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.field_3790.transact(1, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_3790;
      }

      // $FF: renamed from: b (int, java.lang.String[]) void
      public void method_773(int var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            var3.writeInt(var1);
            var3.writeStringArray(var2);
            this.field_3790.transact(2, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
