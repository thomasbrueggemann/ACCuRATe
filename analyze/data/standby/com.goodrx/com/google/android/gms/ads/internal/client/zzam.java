package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;

public class zzam implements Creator<SearchAdRequestParcel> {
   static void zza(SearchAdRequestParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzvd);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.backgroundColor);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzve);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzvf);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzvg);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzvh);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.zzvi);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 9, var0.zzvj);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (String)var0.zzvk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 11, var0.zzvl);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (String)var0.zzvm, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 13, var0.zzvn);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 14, var0.zzvo);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (String)var0.zzvp, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzd(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzo(var1);
   }

   public SearchAdRequestParcel zzd(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      int var15 = 0;
      int var16 = 0;
      String var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var18)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 14:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 15:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SearchAdRequestParcel(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   public SearchAdRequestParcel[] zzo(int var1) {
      return new SearchAdRequestParcel[var1];
   }
}
