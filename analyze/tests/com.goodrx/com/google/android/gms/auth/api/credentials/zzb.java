package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;

public class zzb implements Creator<CredentialPickerConfig> {
   static void zza(CredentialPickerConfig var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.shouldShowAddAccountButton());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.shouldShowCancelButton());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.isForNewAccount());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaA(var1);
   }

   public CredentialPickerConfig zzF(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var4 = false;
      boolean var5 = false;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 1000:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new CredentialPickerConfig(var6, var5, var4, var2);
      }
   }

   public CredentialPickerConfig[] zzaA(int var1) {
      return new CredentialPickerConfig[var1];
   }
}
