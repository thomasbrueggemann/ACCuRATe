package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public class zzf implements Creator<AdOverlayInfoParcel> {
   static void zza(AdOverlayInfoParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzEA, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzfs(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.zzft(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzfu(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (IBinder)var0.zzfv(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzEF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzEG);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzEH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (IBinder)var0.zzfx(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 11, var0.orientation);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 12, var0.zzEJ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (String)var0.url, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (Parcelable)var0.zzrl, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (IBinder)var0.zzfw(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 17, (Parcelable)var0.zzEM, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, (String)var0.zzEL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzg(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzz(var1);
   }

   public AdOverlayInfoParcel zzg(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      AdLauncherIntentInfoParcel var4 = null;
      IBinder var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;
      IBinder var8 = null;
      String var9 = null;
      boolean var10 = false;
      String var11 = null;
      IBinder var12 = null;
      int var13 = 0;
      int var14 = 0;
      String var15 = null;
      VersionInfoParcel var16 = null;
      IBinder var17 = null;
      String var18 = null;
      InterstitialAdParameterParcel var19 = null;

      while(var1.dataPosition() < var2) {
         int var20 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var20)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var20);
            break;
         case 2:
            var4 = (AdLauncherIntentInfoParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var20, AdLauncherIntentInfoParcel.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var20);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var20);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var20);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var20);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var20);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var20);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var20);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 14:
            var16 = (VersionInfoParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var20, VersionInfoParcel.CREATOR);
            break;
         case 15:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var20);
            break;
         case 16:
            var18 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 17:
            var19 = (InterstitialAdParameterParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var20, InterstitialAdParameterParcel.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var20);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AdOverlayInfoParcel(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
      }
   }

   public AdOverlayInfoParcel[] zzz(int var1) {
      return new AdOverlayInfoParcel[var1];
   }
}
