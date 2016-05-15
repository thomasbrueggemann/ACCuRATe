package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;

public interface zzkg extends IInterface {
   void zza(GetRecentContextCall.Response var1) throws RemoteException;

   void zza(Status var1) throws RemoteException;

   void zza(Status var1, ParcelFileDescriptor var2) throws RemoteException;

   void zza(Status var1, boolean var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzkg {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      }

      public static zzkg zzah(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return (zzkg)(var1 != null && var1 instanceof zzkg?(zzkg)var1:new zzkg.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            Status var11;
            if(var2.readInt() != 0) {
               var11 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.zza(var11);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            Status var9;
            if(var2.readInt() != 0) {
               var9 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            ParcelFileDescriptor var10;
            if(var2.readInt() != 0) {
               var10 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.zza(var9, var10);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            Status var7;
            if(var2.readInt() != 0) {
               var7 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            boolean var8;
            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.zza(var7, var8);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            int var5 = var2.readInt();
            GetRecentContextCall.Response var6 = null;
            if(var5 != 0) {
               var6 = GetRecentContextCall.Response.CREATOR.zzw(var2);
            }

            this.zza(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzkg {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(GetRecentContextCall.Response param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1, ParcelFileDescriptor param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
