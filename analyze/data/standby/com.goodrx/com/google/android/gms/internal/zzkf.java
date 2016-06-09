package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.internal.zzkg;

public interface zzkf extends IInterface {
   void zza(GetRecentContextCall.Request var1, zzkg var2) throws RemoteException;

   void zza(zzkg var1) throws RemoteException;

   void zza(zzkg var1, String var2, String var3) throws RemoteException;

   void zza(zzkg var1, String var2, UsageInfo[] var3) throws RemoteException;

   void zza(zzkg var1, boolean var2) throws RemoteException;

   void zzb(zzkg var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzkf {
      public static zzkf zzag(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (zzkf)(var1 != null && var1 instanceof zzkf?(zzkf)var1:new zzkf.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.zza(zzkg.zza.zzah(var2.readStrongBinder()), var2.readString(), (UsageInfo[])var2.createTypedArray(UsageInfo.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.zza(zzkg.zza.zzah(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.zzb(zzkg.zza.zzah(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            zzkg var6 = zzkg.zza.zzah(var2.readStrongBinder());
            boolean var7;
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.zza(var6, var7);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            GetRecentContextCall.Request var5;
            if(var2.readInt() != 0) {
               var5 = GetRecentContextCall.Request.CREATOR.zzv(var2);
            } else {
               var5 = null;
            }

            this.zza(var5, zzkg.zza.zzah(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.zza(zzkg.zza.zzah(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzkf {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(GetRecentContextCall.Request param1, zzkg param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzkg param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzkg param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzkg param1, String param2, UsageInfo[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzkg param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzkg param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
