package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzpk extends IInterface {
   boolean getBooleanFlagValue(String var1, boolean var2, int var3) throws RemoteException;

   int getIntFlagValue(String var1, int var2, int var3) throws RemoteException;

   long getLongFlagValue(String var1, long var2, int var4) throws RemoteException;

   String getStringFlagValue(String var1, String var2, int var3) throws RemoteException;

   void init(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzpk {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
      }

      public static zzpk asInterface(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            return (zzpk)(var1 != null && var1 instanceof zzpk?(zzpk)var1:new zzpk.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.flags.IFlagProvider");
            this.init(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.flags.IFlagProvider");
            String var9 = var2.readString();
            boolean var10;
            if(var2.readInt() != 0) {
               var10 = true;
            } else {
               var10 = false;
            }

            boolean var11 = this.getBooleanFlagValue(var9, var10, var2.readInt());
            var3.writeNoException();
            byte var12 = 0;
            if(var11) {
               var12 = 1;
            }

            var3.writeInt(var12);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.flags.IFlagProvider");
            int var8 = this.getIntFlagValue(var2.readString(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            var3.writeInt(var8);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.flags.IFlagProvider");
            long var6 = this.getLongFlagValue(var2.readString(), var2.readLong(), var2.readInt());
            var3.writeNoException();
            var3.writeLong(var6);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.flags.IFlagProvider");
            String var5 = this.getStringFlagValue(var2.readString(), var2.readString(), var2.readInt());
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.flags.IFlagProvider");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzpk {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public boolean getBooleanFlagValue(String param1, boolean param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getIntFlagValue(String var1, int var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         int var8;
         try {
            var4.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            var4.writeString(var1);
            var4.writeInt(var2);
            var4.writeInt(var3);
            this.zzoz.transact(3, var4, var5, 0);
            var5.readException();
            var8 = var5.readInt();
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }

      public long getLongFlagValue(String var1, long var2, int var4) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();

         long var9;
         try {
            var5.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            var5.writeString(var1);
            var5.writeLong(var2);
            var5.writeInt(var4);
            this.zzoz.transact(4, var5, var6, 0);
            var6.readException();
            var9 = var6.readLong();
         } finally {
            var6.recycle();
            var5.recycle();
         }

         return var9;
      }

      public String getStringFlagValue(String var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         String var8;
         try {
            var4.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.zzoz.transact(5, var4, var5, 0);
            var5.readException();
            var8 = var5.readString();
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }

      public void init(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
