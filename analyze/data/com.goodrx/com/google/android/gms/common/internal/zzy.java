package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public class zzy implements Creator<ResolveAccountRequest> {
   static void zza(ResolveAccountRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getAccount(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getSessionId());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzqW(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzap(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbW(var1);
   }

   public ResolveAccountRequest zzap(Parcel var1) {
      GoogleSignInAccount var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Account var5 = null;

      int var6;
      GoogleSignInAccount var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         int var9;
         Account var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var3;
            var10 = var5;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Account var14 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Account.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var3;
            break;
         case 3:
            int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = (GoogleSignInAccount)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, GoogleSignInAccount.CREATOR);
            var9 = var3;
            var10 = var5;
            var11 = var6;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var3;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var3 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ResolveAccountRequest(var6, var5, var3, var2);
      }
   }

   public ResolveAccountRequest[] zzbW(int var1) {
      return new ResolveAccountRequest[var1];
   }
}
