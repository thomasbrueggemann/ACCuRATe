package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.FACLData;

public class zzb implements Creator<FACLData> {
   static void zza(FACLData var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.version);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzYs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzYt, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzYu);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzYv, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzX(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaU(var1);
   }

   public FACLData zzX(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      FACLConfig var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = (FACLConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, FACLConfig.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new FACLData(var7, var6, var5, var2, var3);
      }
   }

   public FACLData[] zzaU(int var1) {
      return new FACLData[var1];
   }
}
