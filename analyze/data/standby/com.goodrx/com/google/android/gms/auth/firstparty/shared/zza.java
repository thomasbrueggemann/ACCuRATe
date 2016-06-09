package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;

public class zza implements Creator<FACLConfig> {
   static void zza(FACLConfig var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.version);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzYm);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzYn, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzYo);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzYp);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzYq);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzYr);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzW(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaT(var1);
   }

   public FACLConfig zzW(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var4 = null;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      int var9 = 0;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new FACLConfig(var9, var8, var4, var7, var6, var5, var2);
      }
   }

   public FACLConfig[] zzaT(int var1) {
      return new FACLConfig[var1];
   }
}
