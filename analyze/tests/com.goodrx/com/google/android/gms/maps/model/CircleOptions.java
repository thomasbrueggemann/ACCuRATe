package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zzb;

public final class CircleOptions implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   private final int mVersionCode;
   private LatLng zzaTc = null;
   private double zzaTd = 0.0D;
   private float zzaTe = 10.0F;
   private int zzaTf = -16777216;
   private int zzaTg = 0;
   private float zzaTh = 0.0F;
   private boolean zzaTi = true;

   public CircleOptions() {
      this.mVersionCode = 1;
   }

   CircleOptions(int var1, LatLng var2, double var3, float var5, int var6, int var7, float var8, boolean var9) {
      this.mVersionCode = var1;
      this.zzaTc = var2;
      this.zzaTd = var3;
      this.zzaTe = var5;
      this.zzaTf = var6;
      this.zzaTg = var7;
      this.zzaTh = var8;
      this.zzaTi = var9;
   }

   public int describeContents() {
      return 0;
   }

   public LatLng getCenter() {
      return this.zzaTc;
   }

   public int getFillColor() {
      return this.zzaTg;
   }

   public double getRadius() {
      return this.zzaTd;
   }

   public int getStrokeColor() {
      return this.zzaTf;
   }

   public float getStrokeWidth() {
      return this.zzaTe;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public float getZIndex() {
      return this.zzaTh;
   }

   public boolean isVisible() {
      return this.zzaTi;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
