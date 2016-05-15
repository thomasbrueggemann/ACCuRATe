package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;

public class zzd implements Creator<HintRequest> {
   static void zza(HintRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getHintPickerConfig(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.isEmailAddressIdentifierSupported());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzmy());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String[])var0.getAccountTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzH(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaC(var1);
   }

   public HintRequest zzH(Parcel var1) {
      String[] var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      CredentialPickerConfig var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var6 = (CredentialPickerConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, CredentialPickerConfig.CREATOR);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var8);
            break;
         case 1000:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new HintRequest(var7, var6, var5, var3, var2);
      }
   }

   public HintRequest[] zzaC(int var1) {
      return new HintRequest[var1];
   }
}
