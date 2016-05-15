package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public interface zzi extends IInterface {
   void zza(Status var1, Credential var2) throws RemoteException;

   void zza(Status var1, String var2) throws RemoteException;

   void zzg(Status var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzi {
      public static zzi zzaw(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
            return (zzi)(var1 != null && var1 instanceof zzi?(zzi)var1:new zzi.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
            Status var7;
            if(var2.readInt() != 0) {
               var7 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            Credential var8;
            if(var2.readInt() != 0) {
               var8 = (Credential)Credential.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.zza(var7, var8);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
            Status var6;
            if(var2.readInt() != 0) {
               var6 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.zzg(var6);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5, var2.readString());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzi {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(Status param1, Credential param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzg(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
