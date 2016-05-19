package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Creator<AdRequestInfoParcel> {
   static void zza(AdRequestInfoParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, (Bundle)var0.zzHs, false);
      zzb.zza(var1, 3, (Parcelable)var0.zzHt, var2, false);
      zzb.zza(var1, 4, (Parcelable)var0.zzrp, var2, false);
      zzb.zza(var1, 5, (String)var0.zzrj, false);
      zzb.zza(var1, 6, (Parcelable)var0.applicationInfo, var2, false);
      zzb.zza(var1, 7, (Parcelable)var0.zzHu, var2, false);
      zzb.zza(var1, 8, (String)var0.zzHv, false);
      zzb.zza(var1, 9, (String)var0.zzHw, false);
      zzb.zza(var1, 10, (String)var0.zzHx, false);
      zzb.zza(var1, 11, (Parcelable)var0.zzrl, var2, false);
      zzb.zza(var1, 12, (Bundle)var0.zzHy, false);
      zzb.zzc(var1, 13, var0.zzHz);
      zzb.zzb(var1, 14, var0.zzrH, false);
      zzb.zza(var1, 15, (Bundle)var0.zzHA, false);
      zzb.zza(var1, 17, (Parcelable)var0.zzHC, var2, false);
      zzb.zza(var1, 16, var0.zzHB);
      zzb.zzc(var1, 19, var0.zzHE);
      zzb.zzc(var1, 18, var0.zzHD);
      zzb.zza(var1, 21, (String)var0.zzHG, false);
      zzb.zza(var1, 20, var0.zzHF);
      zzb.zza(var1, 25, var0.zzHH);
      zzb.zzb(var1, 27, var0.zzHJ, false);
      zzb.zza(var1, 26, (String)var0.zzHI, false);
      zzb.zza(var1, 29, (Parcelable)var0.zzrD, var2, false);
      zzb.zza(var1, 28, (String)var0.zzri, false);
      zzb.zza(var1, 31, var0.zzHL);
      zzb.zzb(var1, 30, var0.zzHK, false);
      zzb.zza(var1, 34, var0.zzHO);
      zzb.zzc(var1, 35, var0.zzHP);
      zzb.zza(var1, 32, (Parcelable)var0.zzHM, var2, false);
      zzb.zza(var1, 33, (String)var0.zzHN, false);
      zzb.zzc(var1, 36, var0.zzHQ);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzi(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzG(var1);
   }

   public AdRequestInfoParcel[] zzG(int var1) {
      return new AdRequestInfoParcel[var1];
   }

   public AdRequestInfoParcel zzi(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      Bundle var4 = null;
      AdRequestParcel var5 = null;
      AdSizeParcel var6 = null;
      String var7 = null;
      ApplicationInfo var8 = null;
      PackageInfo var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      VersionInfoParcel var13 = null;
      Bundle var14 = null;
      int var15 = 0;
      ArrayList var16 = null;
      Bundle var17 = null;
      boolean var18 = false;
      Messenger var19 = null;
      int var20 = 0;
      int var21 = 0;
      float var22 = 0.0F;
      String var23 = null;
      long var24 = 0L;
      String var26 = null;
      ArrayList var27 = null;
      String var28 = null;
      NativeAdOptionsParcel var29 = null;
      ArrayList var30 = null;
      long var31 = 0L;
      CapabilityParcel var33 = null;
      String var34 = null;
      float var35 = 0.0F;
      int var36 = 0;
      int var37 = 0;

      while(var1.dataPosition() < var2) {
         int var38 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var38)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var38);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var38);
            break;
         case 3:
            var5 = (AdRequestParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, AdRequestParcel.CREATOR);
            break;
         case 4:
            var6 = (AdSizeParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, AdSizeParcel.CREATOR);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 6:
            var8 = (ApplicationInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, ApplicationInfo.CREATOR);
            break;
         case 7:
            var9 = (PackageInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, PackageInfo.CREATOR);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 11:
            var13 = (VersionInfoParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, VersionInfoParcel.CREATOR);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var38);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var38);
            break;
         case 14:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var38);
            break;
         case 15:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var38);
            break;
         case 16:
            var18 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var38);
            break;
         case 17:
            var19 = (Messenger)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, Messenger.CREATOR);
            break;
         case 18:
            var20 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var38);
            break;
         case 19:
            var21 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var38);
            break;
         case 20:
            var22 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var38);
            break;
         case 21:
            var23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 22:
         case 23:
         case 24:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var38);
            break;
         case 25:
            var24 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var38);
            break;
         case 26:
            var26 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 27:
            var27 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var38);
            break;
         case 28:
            var28 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 29:
            var29 = (NativeAdOptionsParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, NativeAdOptionsParcel.CREATOR);
            break;
         case 30:
            var30 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var38);
            break;
         case 31:
            var31 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var38);
            break;
         case 32:
            var33 = (CapabilityParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var38, CapabilityParcel.CREATOR);
            break;
         case 33:
            var34 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var38);
            break;
         case 34:
            var35 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var38);
            break;
         case 35:
            var36 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var38);
            break;
         case 36:
            var37 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var38);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AdRequestInfoParcel(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var26, var27, var28, var29, var30, var31, var33, var34, var35, var36, var37);
      }
   }
}
