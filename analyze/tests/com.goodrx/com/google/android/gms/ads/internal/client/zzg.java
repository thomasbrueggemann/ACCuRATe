package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import java.util.ArrayList;

public class zzg implements Creator<AdRequestParcel> {
   static void zza(AdRequestParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zztC);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Bundle)var0.extras, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zztD);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 5, var0.zztE, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zztF);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zztG);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zztH);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zztI, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (Parcelable)var0.zztJ, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (Parcelable)var0.zztK, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (String)var0.zztL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (Bundle)var0.zztM, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (Bundle)var0.zztN, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 15, var0.zztO, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 17, (String)var0.zztQ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, (String)var0.zztP, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 18, var0.zztR);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzb(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzl(var1);
   }

   public AdRequestParcel zzb(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      long var4 = 0L;
      Bundle var6 = null;
      int var7 = 0;
      ArrayList var8 = null;
      boolean var9 = false;
      int var10 = 0;
      boolean var11 = false;
      String var12 = null;
      SearchAdRequestParcel var13 = null;
      Location var14 = null;
      String var15 = null;
      Bundle var16 = null;
      Bundle var17 = null;
      ArrayList var18 = null;
      String var19 = null;
      String var20 = null;
      boolean var21 = false;

      while(var1.dataPosition() < var2) {
         int var22 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var22)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var22);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var22);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var22);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var22);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var22);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var22);
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var22);
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var22);
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var22);
            break;
         case 10:
            var13 = (SearchAdRequestParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var22, SearchAdRequestParcel.CREATOR);
            break;
         case 11:
            var14 = (Location)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var22, Location.CREATOR);
            break;
         case 12:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var22);
            break;
         case 13:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var22);
            break;
         case 14:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var22);
            break;
         case 15:
            var18 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var22);
            break;
         case 16:
            var19 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var22);
            break;
         case 17:
            var20 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var22);
            break;
         case 18:
            var21 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var22);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var22);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AdRequestParcel(var3, var4, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21);
      }
   }

   public AdRequestParcel[] zzl(int var1) {
      return new AdRequestParcel[var1];
   }
}
