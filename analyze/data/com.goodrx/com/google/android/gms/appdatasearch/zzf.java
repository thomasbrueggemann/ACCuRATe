package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall;

public class zzf implements Creator<GetRecentContextCall.Request> {
   static void zza(GetRecentContextCall.Request var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzTT, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzTU);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzTV);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzTW);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzTX, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzv(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzam(var1);
   }

   public GetRecentContextCall.Request[] zzam(int var1) {
      return new GetRecentContextCall.Request[var1];
   }

   public GetRecentContextCall.Request zzv(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      boolean var6 = false;
      Account var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var7 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, Account.CREATOR);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 1000:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new GetRecentContextCall.Request(var8, var7, var6, var5, var3, var2);
      }
   }
}
