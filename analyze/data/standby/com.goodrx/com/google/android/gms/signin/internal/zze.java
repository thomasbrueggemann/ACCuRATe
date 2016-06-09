package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.zzd;

public interface zze extends IInterface {
   void zza(int var1, Account var2, zzd var3) throws RemoteException;

   void zza(AuthAccountRequest var1, zzd var2) throws RemoteException;

   void zza(ResolveAccountRequest var1, zzt var2) throws RemoteException;

   void zza(zzp var1, int var2, boolean var3) throws RemoteException;

   void zza(CheckServerAuthResult var1) throws RemoteException;

   void zza(RecordConsentRequest var1, zzd var2) throws RemoteException;

   void zza(SignInRequest var1, zzd var2) throws RemoteException;

   void zzav(boolean var1) throws RemoteException;

   void zzb(zzd var1) throws RemoteException;

   void zzka(int var1) throws RemoteException;

   public abstract static class zza extends Binder implements zze {
      public static zze zzeb(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (zze)(var1 != null && var1 instanceof zze?(zze)var1:new zze.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int var21 = var2.readInt();
            AuthAccountRequest var22 = null;
            if(var21 != 0) {
               var22 = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var22, zzd.zza.zzea(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int var19 = var2.readInt();
            CheckServerAuthResult var20 = null;
            if(var19 != 0) {
               var20 = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(var2);
            }

            this.zza(var20);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            boolean var18;
            if(var2.readInt() != 0) {
               var18 = true;
            } else {
               var18 = false;
            }

            this.zzav(var18);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int var16 = var2.readInt();
            ResolveAccountRequest var17 = null;
            if(var16 != 0) {
               var17 = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var17, zzt.zza.zzaT(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            this.zzka(var2.readInt());
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int var13 = var2.readInt();
            int var14 = var2.readInt();
            Account var15 = null;
            if(var14 != 0) {
               var15 = (Account)Account.CREATOR.createFromParcel(var2);
            }

            this.zza(var13, var15, zzd.zza.zzea(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            zzp var9 = zzp.zza.zzaP(var2.readStrongBinder());
            int var10 = var2.readInt();
            int var11 = var2.readInt();
            boolean var12 = false;
            if(var11 != 0) {
               var12 = true;
            }

            this.zza(var9, var10, var12);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int var7 = var2.readInt();
            RecordConsentRequest var8 = null;
            if(var7 != 0) {
               var8 = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var8, zzd.zza.zzea(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            this.zzb(zzd.zza.zzea(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            int var5 = var2.readInt();
            SignInRequest var6 = null;
            if(var5 != 0) {
               var6 = (SignInRequest)SignInRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var6, zzd.zza.zzea(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.signin.internal.ISignInService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zze {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(int param1, Account param2, zzd param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(AuthAccountRequest param1, zzd param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(ResolveAccountRequest param1, zzt param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzp param1, int param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(CheckServerAuthResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(RecordConsentRequest param1, zzd param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(SignInRequest param1, zzd param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzav(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzka(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            var2.writeInt(var1);
            this.zzoz.transact(7, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
