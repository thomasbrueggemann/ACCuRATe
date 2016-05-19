package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
public final class AdOverlayInfoParcel implements SafeParcelable {
   public static final zzf CREATOR = new zzf();
   public final int orientation;
   public final String url;
   public final int versionCode;
   public final AdLauncherIntentInfoParcel zzEA;
   public final com.google.android.gms.ads.internal.client.zza zzEB;
   public final zzg zzEC;
   public final zzjp zzED;
   public final zzdb zzEE;
   public final String zzEF;
   public final boolean zzEG;
   public final String zzEH;
   public final zzp zzEI;
   public final int zzEJ;
   public final zzdh zzEK;
   public final String zzEL;
   public final InterstitialAdParameterParcel zzEM;
   public final VersionInfoParcel zzrl;

   AdOverlayInfoParcel(int var1, AdLauncherIntentInfoParcel var2, IBinder var3, IBinder var4, IBinder var5, IBinder var6, String var7, boolean var8, String var9, IBinder var10, int var11, int var12, String var13, VersionInfoParcel var14, IBinder var15, String var16, InterstitialAdParameterParcel var17) {
      this.versionCode = var1;
      this.zzEA = var2;
      this.zzEB = (com.google.android.gms.ads.internal.client.zza)com.google.android.gms.dynamic.zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbs(var3));
      this.zzEC = (zzg)com.google.android.gms.dynamic.zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbs(var4));
      this.zzED = (zzjp)com.google.android.gms.dynamic.zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbs(var5));
      this.zzEE = (zzdb)com.google.android.gms.dynamic.zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbs(var6));
      this.zzEF = var7;
      this.zzEG = var8;
      this.zzEH = var9;
      this.zzEI = (zzp)com.google.android.gms.dynamic.zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbs(var10));
      this.orientation = var11;
      this.zzEJ = var12;
      this.url = var13;
      this.zzrl = var14;
      this.zzEK = (zzdh)com.google.android.gms.dynamic.zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbs(var15));
      this.zzEL = var16;
      this.zzEM = var17;
   }

   public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza var1, zzg var2, zzp var3, zzjp var4, boolean var5, int var6, VersionInfoParcel var7) {
      this.versionCode = 4;
      this.zzEA = null;
      this.zzEB = var1;
      this.zzEC = var2;
      this.zzED = var4;
      this.zzEE = null;
      this.zzEF = null;
      this.zzEG = var5;
      this.zzEH = null;
      this.zzEI = var3;
      this.orientation = var6;
      this.zzEJ = 2;
      this.url = null;
      this.zzrl = var7;
      this.zzEK = null;
      this.zzEL = null;
      this.zzEM = null;
   }

   public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza var1, zzg var2, zzdb var3, zzp var4, zzjp var5, boolean var6, int var7, String var8, VersionInfoParcel var9, zzdh var10) {
      this.versionCode = 4;
      this.zzEA = null;
      this.zzEB = var1;
      this.zzEC = var2;
      this.zzED = var5;
      this.zzEE = var3;
      this.zzEF = null;
      this.zzEG = var6;
      this.zzEH = null;
      this.zzEI = var4;
      this.orientation = var7;
      this.zzEJ = 3;
      this.url = var8;
      this.zzrl = var9;
      this.zzEK = var10;
      this.zzEL = null;
      this.zzEM = null;
   }

   public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza var1, zzg var2, zzdb var3, zzp var4, zzjp var5, boolean var6, int var7, String var8, String var9, VersionInfoParcel var10, zzdh var11) {
      this.versionCode = 4;
      this.zzEA = null;
      this.zzEB = var1;
      this.zzEC = var2;
      this.zzED = var5;
      this.zzEE = var3;
      this.zzEF = var9;
      this.zzEG = var6;
      this.zzEH = var8;
      this.zzEI = var4;
      this.orientation = var7;
      this.zzEJ = 3;
      this.url = null;
      this.zzrl = var10;
      this.zzEK = var11;
      this.zzEL = null;
      this.zzEM = null;
   }

   public AdOverlayInfoParcel(AdLauncherIntentInfoParcel var1, com.google.android.gms.ads.internal.client.zza var2, zzg var3, zzp var4, VersionInfoParcel var5) {
      this.versionCode = 4;
      this.zzEA = var1;
      this.zzEB = var2;
      this.zzEC = var3;
      this.zzED = null;
      this.zzEE = null;
      this.zzEF = null;
      this.zzEG = false;
      this.zzEH = null;
      this.zzEI = var4;
      this.orientation = -1;
      this.zzEJ = 4;
      this.url = null;
      this.zzrl = var5;
      this.zzEK = null;
      this.zzEL = null;
      this.zzEM = null;
   }

   public static void zza(Intent var0, AdOverlayInfoParcel var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var1);
      var0.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var2);
   }

   public static AdOverlayInfoParcel zzb(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         var2.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
         AdOverlayInfoParcel var3 = (AdOverlayInfoParcel)var2.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   IBinder zzfs() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzEB).asBinder();
   }

   IBinder zzft() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzEC).asBinder();
   }

   IBinder zzfu() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzED).asBinder();
   }

   IBinder zzfv() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzEE).asBinder();
   }

   IBinder zzfw() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzEK).asBinder();
   }

   IBinder zzfx() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzEI).asBinder();
   }
}
