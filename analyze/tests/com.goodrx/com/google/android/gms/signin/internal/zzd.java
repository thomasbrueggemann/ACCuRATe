package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;

public interface zzd extends IInterface {
   void zza(ConnectionResult var1, AuthAccountResult var2) throws RemoteException;

   void zza(Status var1, GoogleSignInAccount var2) throws RemoteException;

   void zzb(SignInResponse var1) throws RemoteException;

   void zzbl(Status var1) throws RemoteException;

   void zzbm(Status var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzd {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
      }

      public static zzd zzea(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            return (zzd)(var1 != null && var1 instanceof zzd?(zzd)var1:new zzd.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 3:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            ConnectionResult var10;
            if(var2.readInt() != 0) {
               var10 = (ConnectionResult)ConnectionResult.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            AuthAccountResult var11;
            if(var2.readInt() != 0) {
               var11 = (AuthAccountResult)AuthAccountResult.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.zza(var10, var11);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            Status var9;
            if(var2.readInt() != 0) {
               var9 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.zzbl(var9);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            Status var8;
            if(var2.readInt() != 0) {
               var8 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.zzbm(var8);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            Status var6;
            if(var2.readInt() != 0) {
               var6 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            GoogleSignInAccount var7;
            if(var2.readInt() != 0) {
               var7 = (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.zza(var6, var7);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            SignInResponse var5;
            if(var2.readInt() != 0) {
               var5 = (SignInResponse)SignInResponse.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zzb(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzd {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(ConnectionResult param1, AuthAccountResult param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1, GoogleSignInAccount param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(SignInResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzbl(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzbm(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
