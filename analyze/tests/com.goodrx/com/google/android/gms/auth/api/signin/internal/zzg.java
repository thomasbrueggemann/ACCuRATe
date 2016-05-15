package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

public interface zzg extends IInterface {
   void zza(GoogleSignInAccount var1, Status var2) throws RemoteException;

   void zza(Status var1, SignInAccount var2) throws RemoteException;

   void zza(Status var1, String var2, String var3, long var4) throws RemoteException;

   void zzk(Status var1) throws RemoteException;

   void zzl(Status var1) throws RemoteException;

   void zzm(Status var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzg {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
      }

      public static zzg zzaC(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            return (zzg)(var1 != null && var1 instanceof zzg?(zzg)var1:new zzg.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            Status var11;
            if(var2.readInt() != 0) {
               var11 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            SignInAccount var12;
            if(var2.readInt() != 0) {
               var12 = (SignInAccount)SignInAccount.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.zza(var11, var12);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            Status var10;
            if(var2.readInt() != 0) {
               var10 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.zzk(var10);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            Status var9;
            if(var2.readInt() != 0) {
               var9 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.zza(var9, var2.readString(), var2.readString(), var2.readLong());
            var3.writeNoException();
            return true;
         case 101:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            GoogleSignInAccount var7;
            if(var2.readInt() != 0) {
               var7 = (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            Status var8;
            if(var2.readInt() != 0) {
               var8 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.zza(var7, var8);
            var3.writeNoException();
            return true;
         case 102:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            Status var6;
            if(var2.readInt() != 0) {
               var6 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.zzl(var6);
            var3.writeNoException();
            return true;
         case 103:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = (Status)Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zzm(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzg {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(GoogleSignInAccount param1, Status param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1, SignInAccount param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Status param1, String param2, String param3, long param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzk(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzl(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzm(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
