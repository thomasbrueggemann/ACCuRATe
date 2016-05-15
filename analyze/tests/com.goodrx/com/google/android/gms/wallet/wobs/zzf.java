package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.wobs.TextModuleData;

public class zzf implements Creator<TextModuleData> {
   static void zza(TextModuleData var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbqO, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.body, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhT(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlu(var1);
   }

   public TextModuleData zzhT(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new TextModuleData(var4, var5, var2);
      }
   }

   public TextModuleData[] zzlu(int var1) {
      return new TextModuleData[var1];
   }
}
