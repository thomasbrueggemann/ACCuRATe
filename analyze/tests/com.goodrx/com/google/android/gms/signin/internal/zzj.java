package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.SignInResponse;

public class zzj implements Creator<SignInResponse> {
   static void zza(SignInResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzqY(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzFP(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgV(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkd(var1);
   }

   public SignInResponse zzgV(Parcel var1) {
      ResolveAccountResponse var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;

      ConnectionResult var5;
      ResolveAccountResponse var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         ConnectionResult var8;
         int var9;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            ConnectionResult var10 = (ConnectionResult)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, ConnectionResult.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = (ResolveAccountResponse)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, ResolveAccountResponse.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SignInResponse(var4, var5, var2);
      }
   }

   public SignInResponse[] zzkd(int var1) {
      return new SignInResponse[var1];
   }
}
