package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.auth.api.credentials.internal.SaveRequest;
import com.google.android.gms.auth.api.credentials.internal.zzi;

public interface zzj extends IInterface {
   void zza(zzi var1) throws RemoteException;

   void zza(zzi var1, CredentialRequest var2) throws RemoteException;

   void zza(zzi var1, DeleteRequest var2) throws RemoteException;

   void zza(zzi var1, GeneratePasswordRequest var2) throws RemoteException;

   void zza(zzi var1, SaveRequest var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzj {
      public static zzj zzax(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return (zzj)(var1 != null && var1 instanceof zzj?(zzj)var1:new zzj.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzi var14 = zzi.zza.zzaw(var2.readStrongBinder());
            int var15 = var2.readInt();
            CredentialRequest var16 = null;
            if(var15 != 0) {
               var16 = (CredentialRequest)CredentialRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var14, var16);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzi var11 = zzi.zza.zzaw(var2.readStrongBinder());
            int var12 = var2.readInt();
            SaveRequest var13 = null;
            if(var12 != 0) {
               var13 = (SaveRequest)SaveRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var11, var13);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzi var8 = zzi.zza.zzaw(var2.readStrongBinder());
            int var9 = var2.readInt();
            DeleteRequest var10 = null;
            if(var9 != 0) {
               var10 = (DeleteRequest)DeleteRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var8, var10);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            this.zza(zzi.zza.zzaw(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzi var5 = zzi.zza.zzaw(var2.readStrongBinder());
            int var6 = var2.readInt();
            GeneratePasswordRequest var7 = null;
            if(var6 != 0) {
               var7 = (GeneratePasswordRequest)GeneratePasswordRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzj {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzi param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzi param1, CredentialRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzi param1, DeleteRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzi param1, GeneratePasswordRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzi param1, SaveRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
