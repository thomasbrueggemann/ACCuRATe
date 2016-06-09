package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.LargeParcelTeleporter;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh implements Creator<AdResponseParcel> {
   static void zza(AdResponseParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, (String)var0.zzEF, false);
      zzb.zza(var1, 3, (String)var0.body, false);
      zzb.zzb(var1, 4, var0.zzBQ, false);
      zzb.zzc(var1, 5, var0.errorCode);
      zzb.zzb(var1, 6, var0.zzBR, false);
      zzb.zza(var1, 7, var0.zzHS);
      zzb.zza(var1, 8, var0.zzHT);
      zzb.zza(var1, 9, var0.zzHU);
      zzb.zzb(var1, 10, var0.zzHV, false);
      zzb.zza(var1, 11, var0.zzBU);
      zzb.zzc(var1, 12, var0.orientation);
      zzb.zza(var1, 13, (String)var0.zzHW, false);
      zzb.zza(var1, 14, var0.zzHX);
      zzb.zza(var1, 15, (String)var0.zzHY, false);
      zzb.zza(var1, 19, (String)var0.zzIa, false);
      zzb.zza(var1, 18, var0.zzHZ);
      zzb.zza(var1, 21, (String)var0.zzIb, false);
      zzb.zza(var1, 23, var0.zzuk);
      zzb.zza(var1, 22, var0.zzIc);
      zzb.zza(var1, 25, var0.zzId);
      zzb.zza(var1, 24, var0.zzHB);
      zzb.zzc(var1, 27, var0.zzIf);
      zzb.zza(var1, 26, var0.zzIe);
      zzb.zza(var1, 29, (String)var0.zzIh, false);
      zzb.zza(var1, 28, (Parcelable)var0.zzIg, var2, false);
      zzb.zza(var1, 31, var0.zzul);
      zzb.zza(var1, 30, (String)var0.zzIi, false);
      zzb.zzb(var1, 34, var0.zzIk, false);
      zzb.zzb(var1, 35, var0.zzIl, false);
      zzb.zza(var1, 32, var0.zzum);
      zzb.zza(var1, 33, (Parcelable)var0.zzIj, var2, false);
      zzb.zza(var1, 36, var0.zzIm);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzj(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzH(var1);
   }

   public AdResponseParcel[] zzH(int var1) {
      return new AdResponseParcel[var1];
   }

   public AdResponseParcel zzj(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      ArrayList var6 = null;
      int var7 = 0;
      ArrayList var8 = null;
      long var9 = 0L;
      boolean var11 = false;
      long var12 = 0L;
      ArrayList var14 = null;
      long var15 = 0L;
      int var17 = 0;
      String var18 = null;
      long var19 = 0L;
      String var21 = null;
      boolean var22 = false;
      String var23 = null;
      String var24 = null;
      boolean var25 = false;
      boolean var26 = false;
      boolean var27 = false;
      boolean var28 = false;
      boolean var29 = false;
      int var30 = 0;
      LargeParcelTeleporter var31 = null;
      String var32 = null;
      String var33 = null;
      boolean var34 = false;
      boolean var35 = false;
      RewardItemParcel var36 = null;
      ArrayList var37 = null;
      ArrayList var38 = null;
      boolean var39 = false;

      while(var1.dataPosition() < var2) {
         int var40 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var40)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var40);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var40);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var40);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var40);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var40);
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var40);
            break;
         case 10:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var40);
            break;
         case 11:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var40);
            break;
         case 12:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var40);
            break;
         case 13:
            var18 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 14:
            var19 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var40);
            break;
         case 15:
            var21 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 16:
         case 17:
         case 20:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var40);
            break;
         case 18:
            var22 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 19:
            var23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 21:
            var24 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 22:
            var25 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 23:
            var26 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 24:
            var27 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 25:
            var28 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 26:
            var29 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 27:
            var30 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var40);
            break;
         case 28:
            var31 = (LargeParcelTeleporter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var40, LargeParcelTeleporter.CREATOR);
            break;
         case 29:
            var32 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 30:
            var33 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var40);
            break;
         case 31:
            var34 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 32:
            var35 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
            break;
         case 33:
            var36 = (RewardItemParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var40, RewardItemParcel.CREATOR);
            break;
         case 34:
            var37 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var40);
            break;
         case 35:
            var38 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var40);
            break;
         case 36:
            var39 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var40);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AdResponseParcel(var3, var4, var5, var6, var7, var8, var9, var11, var12, var14, var15, var17, var18, var19, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39);
      }
   }
}
