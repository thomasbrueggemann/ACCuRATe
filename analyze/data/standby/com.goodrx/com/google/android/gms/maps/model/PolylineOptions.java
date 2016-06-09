package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zzi;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
   public static final zzi CREATOR = new zzi();
   private int mColor = -16777216;
   private final int mVersionCode;
   private final List<LatLng> zzaTJ;
   private boolean zzaTL = false;
   private float zzaTh = 0.0F;
   private boolean zzaTi = true;
   private float zzaTm = 10.0F;
   private boolean zzaTr = false;

   public PolylineOptions() {
      this.mVersionCode = 1;
      this.zzaTJ = new ArrayList();
   }

   PolylineOptions(int var1, List var2, float var3, int var4, float var5, boolean var6, boolean var7, boolean var8) {
      this.mVersionCode = var1;
      this.zzaTJ = var2;
      this.zzaTm = var3;
      this.mColor = var4;
      this.zzaTh = var5;
      this.zzaTi = var6;
      this.zzaTL = var7;
      this.zzaTr = var8;
   }

   public int describeContents() {
      return 0;
   }

   public int getColor() {
      return this.mColor;
   }

   public List<LatLng> getPoints() {
      return this.zzaTJ;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public float getWidth() {
      return this.zzaTm;
   }

   public float getZIndex() {
      return this.zzaTh;
   }

   public boolean isClickable() {
      return this.zzaTr;
   }

   public boolean isGeodesic() {
      return this.zzaTL;
   }

   public boolean isVisible() {
      return this.zzaTi;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
