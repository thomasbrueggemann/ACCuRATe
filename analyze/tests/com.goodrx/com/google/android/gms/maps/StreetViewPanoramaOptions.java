package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   private final int mVersionCode;
   private Boolean zzaRQ;
   private Boolean zzaRW = Boolean.valueOf(true);
   private StreetViewPanoramaCamera zzaSD;
   private String zzaSE;
   private LatLng zzaSF;
   private Integer zzaSG;
   private Boolean zzaSH = Boolean.valueOf(true);
   private Boolean zzaSI = Boolean.valueOf(true);
   private Boolean zzaSJ = Boolean.valueOf(true);

   public StreetViewPanoramaOptions() {
      this.mVersionCode = 1;
   }

   StreetViewPanoramaOptions(int var1, StreetViewPanoramaCamera var2, String var3, LatLng var4, Integer var5, byte var6, byte var7, byte var8, byte var9, byte var10) {
      this.mVersionCode = var1;
      this.zzaSD = var2;
      this.zzaSF = var4;
      this.zzaSG = var5;
      this.zzaSE = var3;
      this.zzaSH = com.google.android.gms.maps.internal.zza.zza(var6);
      this.zzaRW = com.google.android.gms.maps.internal.zza.zza(var7);
      this.zzaSI = com.google.android.gms.maps.internal.zza.zza(var8);
      this.zzaSJ = com.google.android.gms.maps.internal.zza.zza(var9);
      this.zzaRQ = com.google.android.gms.maps.internal.zza.zza(var10);
   }

   public int describeContents() {
      return 0;
   }

   public String getPanoramaId() {
      return this.zzaSE;
   }

   public LatLng getPosition() {
      return this.zzaSF;
   }

   public Integer getRadius() {
      return this.zzaSG;
   }

   public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
      return this.zzaSD;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   byte zzAa() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaSH);
   }

   byte zzAb() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaSI);
   }

   byte zzAc() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaSJ);
   }

   byte zzzL() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRQ);
   }

   byte zzzP() {
      return com.google.android.gms.maps.internal.zza.zze(this.zzaRW);
   }
}
