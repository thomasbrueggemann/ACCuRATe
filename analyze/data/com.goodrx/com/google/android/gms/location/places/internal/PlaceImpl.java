package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import com.google.android.gms.location.places.internal.zzl;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl implements SafeParcelable, Place {
   public static final zzl CREATOR = new zzl();
   private final String mName;
   final int mVersionCode;
   private final LatLng zzaPc;
   private final List<Integer> zzaPd;
   private final String zzaPe;
   private final Uri zzaPf;
   private final String zzaQA;
   private final boolean zzaQB;
   private final float zzaQC;
   private final int zzaQD;
   private final long zzaQE;
   private final List<Integer> zzaQF;
   private final String zzaQG;
   private final List<String> zzaQH;
   private final Map<Integer, String> zzaQI;
   private final TimeZone zzaQJ;
   private Locale zzaQr;
   private final Bundle zzaQw;
   @Deprecated
   private final PlaceLocalization zzaQx;
   private final float zzaQy;
   private final LatLngBounds zzaQz;
   private final String zzawc;
   private final String zzyv;

   PlaceImpl(int var1, String var2, List<Integer> var3, List<Integer> var4, Bundle var5, String var6, String var7, String var8, String var9, List<String> var10, LatLng var11, float var12, LatLngBounds var13, String var14, Uri var15, boolean var16, float var17, int var18, long var19, PlaceLocalization var21) {
      this.mVersionCode = var1;
      this.zzyv = var2;
      this.zzaPd = Collections.unmodifiableList(var3);
      this.zzaQF = var4;
      if(var5 == null) {
         var5 = new Bundle();
      }

      this.zzaQw = var5;
      this.mName = var6;
      this.zzawc = var7;
      this.zzaPe = var8;
      this.zzaQG = var9;
      if(var10 == null) {
         var10 = Collections.emptyList();
      }

      this.zzaQH = var10;
      this.zzaPc = var11;
      this.zzaQy = var12;
      this.zzaQz = var13;
      if(var14 == null) {
         var14 = "UTC";
      }

      this.zzaQA = var14;
      this.zzaPf = var15;
      this.zzaQB = var16;
      this.zzaQC = var17;
      this.zzaQD = var18;
      this.zzaQE = var19;
      this.zzaQI = Collections.unmodifiableMap(new HashMap());
      this.zzaQJ = null;
      this.zzaQr = null;
      this.zzaQx = var21;
   }

   public int describeContents() {
      zzl var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlaceImpl)) {
            return false;
         }

         PlaceImpl var2 = (PlaceImpl)var1;
         if(!this.zzyv.equals(var2.zzyv) || !zzw.equal(this.zzaQr, var2.zzaQr) || this.zzaQE != var2.zzaQE) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzzw();
   }

   public String getAddress() {
      return this.zzawc;
   }

   public String getId() {
      return this.zzyv;
   }

   public LatLng getLatLng() {
      return this.zzaPc;
   }

   public String getName() {
      return this.mName;
   }

   public String getPhoneNumber() {
      return this.zzaPe;
   }

   public List<Integer> getPlaceTypes() {
      return this.zzaPd;
   }

   public int getPriceLevel() {
      return this.zzaQD;
   }

   public float getRating() {
      return this.zzaQC;
   }

   public LatLngBounds getViewport() {
      return this.zzaQz;
   }

   public Uri getWebsiteUri() {
      return this.zzaPf;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzyv, this.zzaQr, Long.valueOf(this.zzaQE)};
      return zzw.hashCode(var1);
   }

   @SuppressLint({"DefaultLocale"})
   public String toString() {
      return zzw.zzy(this).zzg("id", this.zzyv).zzg("placeTypes", this.zzaPd).zzg("locale", this.zzaQr).zzg("name", this.mName).zzg("address", this.zzawc).zzg("phoneNumber", this.zzaPe).zzg("latlng", this.zzaPc).zzg("viewport", this.zzaQz).zzg("websiteUri", this.zzaPf).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaQB)).zzg("priceLevel", Integer.valueOf(this.zzaQD)).zzg("timestampSecs", Long.valueOf(this.zzaQE)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl var10000 = CREATOR;
      zzl.zza(this, var1, var2);
   }

   public List<Integer> zzzn() {
      return this.zzaQF;
   }

   public float zzzo() {
      return this.zzaQy;
   }

   public String zzzp() {
      return this.zzaQG;
   }

   public List<String> zzzq() {
      return this.zzaQH;
   }

   public boolean zzzr() {
      return this.zzaQB;
   }

   public long zzzs() {
      return this.zzaQE;
   }

   public Bundle zzzt() {
      return this.zzaQw;
   }

   public String zzzu() {
      return this.zzaQA;
   }

   @Deprecated
   public PlaceLocalization zzzv() {
      return this.zzaQx;
   }

   public Place zzzw() {
      return this;
   }
}
