package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public class zzc implements Creator<CredentialRequest> {
   static void zza(CredentialRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.isPasswordLoginSupported());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String[])var0.getAccountTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getCredentialPickerConfig(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.getCredentialHintPickerConfig(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaB(var1);
   }

   public CredentialRequest zzG(Parcel var1) {
      boolean var2 = false;
      CredentialPickerConfig var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      CredentialPickerConfig var5 = null;
      String[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var8);
            break;
         case 3:
            var5 = (CredentialPickerConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, CredentialPickerConfig.CREATOR);
            break;
         case 4:
            var3 = (CredentialPickerConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, CredentialPickerConfig.CREATOR);
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
         return new CredentialRequest(var7, var2, var6, var5, var3);
      }
   }

   public CredentialRequest[] zzaB(int var1) {
      return new CredentialRequest[var1];
   }
}
