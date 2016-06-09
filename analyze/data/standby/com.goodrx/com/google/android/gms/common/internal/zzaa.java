package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;

public class zzaa implements Creator<SignInButtonConfig> {
   static void zza(SignInButtonConfig var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzrb());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzrc());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable[])var0.zzrd(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzar(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbY(var1);
   }

   public SignInButtonConfig zzar(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Scope[] var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 4:
            var4 = (Scope[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7, Scope.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SignInButtonConfig(var6, var5, var2, var4);
      }
   }

   public SignInButtonConfig[] zzbY(int var1) {
      return new SignInButtonConfig[var1];
   }
}
