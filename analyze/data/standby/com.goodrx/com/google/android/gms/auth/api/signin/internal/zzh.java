package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.zzg;

public interface zzh extends IInterface {
   void zza(zzg var1, GoogleSignInOptions var2) throws RemoteException;

   void zza(zzg var1, SignInConfiguration var2) throws RemoteException;

   void zza(zzg var1, SignInConfiguration var2, SignInAccount var3, String var4) throws RemoteException;

   void zzb(zzg var1, GoogleSignInOptions var2) throws RemoteException;

   void zzb(zzg var1, SignInConfiguration var2) throws RemoteException;

   void zzc(zzg var1, GoogleSignInOptions var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzh {
      public static zzh zzaD(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (zzh)(var1 != null && var1 instanceof zzh?(zzh)var1:new zzh.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzg var16 = zzg.zza.zzaC(var2.readStrongBinder());
            SignInConfiguration var17;
            if(var2.readInt() != 0) {
               var17 = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            this.zza(var16, var17);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzg var14 = zzg.zza.zzaC(var2.readStrongBinder());
            SignInConfiguration var15;
            if(var2.readInt() != 0) {
               var15 = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            this.zzb(var14, var15);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzg var11 = zzg.zza.zzaC(var2.readStrongBinder());
            SignInConfiguration var12;
            if(var2.readInt() != 0) {
               var12 = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            SignInAccount var13;
            if(var2.readInt() != 0) {
               var13 = (SignInAccount)SignInAccount.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.zza(var11, var12, var13, var2.readString());
            var3.writeNoException();
            return true;
         case 101:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzg var9 = zzg.zza.zzaC(var2.readStrongBinder());
            GoogleSignInOptions var10;
            if(var2.readInt() != 0) {
               var10 = (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.zza(var9, var10);
            var3.writeNoException();
            return true;
         case 102:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzg var7 = zzg.zza.zzaC(var2.readStrongBinder());
            GoogleSignInOptions var8;
            if(var2.readInt() != 0) {
               var8 = (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.zzb(var7, var8);
            var3.writeNoException();
            return true;
         case 103:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzg var5 = zzg.zza.zzaC(var2.readStrongBinder());
            GoogleSignInOptions var6;
            if(var2.readInt() != 0) {
               var6 = (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.zzc(var5, var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzh {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzg param1, GoogleSignInOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzg param1, SignInConfiguration param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzg param1, SignInConfiguration param2, SignInAccount param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzg param1, GoogleSignInOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzg param1, SignInConfiguration param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzc(zzg param1, GoogleSignInOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
