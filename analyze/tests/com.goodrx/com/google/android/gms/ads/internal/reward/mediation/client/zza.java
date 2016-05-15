package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.dynamic.zzd;

public interface zza extends IInterface {
   void zza(zzd var1, RewardItemParcel var2) throws RemoteException;

   void zzb(zzd var1, int var2) throws RemoteException;

   void zzc(zzd var1, int var2) throws RemoteException;

   void zzg(zzd var1) throws RemoteException;

   void zzh(zzd var1) throws RemoteException;

   void zzi(zzd var1) throws RemoteException;

   void zzj(zzd var1) throws RemoteException;

   void zzk(zzd var1) throws RemoteException;

   void zzl(zzd var1) throws RemoteException;

   void zzm(zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zza {
      public static zza zzae(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            return (zza)(var1 != null && var1 instanceof zza?(zza)var1:new zza.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzg(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzb(zzd.zza.zzbs(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzh(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzi(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzj(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzk(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            zzd var5 = zzd.zza.zzbs(var2.readStrongBinder());
            RewardItemParcel var6;
            if(var2.readInt() != 0) {
               var6 = RewardItemParcel.CREATOR.zzo(var2);
            } else {
               var6 = null;
            }

            this.zza(var5, var6);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzl(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzc(zzd.zza.zzbs(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            this.zzm(zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zza {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzd param1, RewardItemParcel param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(zzd param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzc(zzd param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzg(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzh(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzi(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzj(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzk(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzl(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzm(zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
