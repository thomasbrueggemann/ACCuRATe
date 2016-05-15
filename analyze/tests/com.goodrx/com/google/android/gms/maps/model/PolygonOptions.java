package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zzh;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
   public static final zzh CREATOR = new zzh();
   private final int mVersionCode;
   private final List<LatLng> zzaTJ;
   private final List<List<LatLng>> zzaTK;
   private boolean zzaTL = false;
   private float zzaTe = 10.0F;
   private int zzaTf = -16777216;
   private int zzaTg = 0;
   private float zzaTh = 0.0F;
   private boolean zzaTi = true;
   private boolean zzaTr = false;

   public PolygonOptions() {
      this.mVersionCode = 1;
      this.zzaTJ = new ArrayList();
      this.zzaTK = new ArrayList();
   }

   PolygonOptions(int var1, List<LatLng> var2, List var3, float var4, int var5, int var6, float var7, boolean var8, boolean var9, boolean var10) {
      this.mVersionCode = var1;
      this.zzaTJ = var2;
      this.zzaTK = var3;
      this.zzaTe = var4;
      this.zzaTf = var5;
      this.zzaTg = var6;
      this.zzaTh = var7;
      this.zzaTi = var8;
      this.zzaTL = var9;
      this.zzaTr = var10;
   }

   public int describeContents() {
      return 0;
   }

   public int getFillColor() {
      return this.zzaTg;
   }

   public List<LatLng> getPoints() {
      return this.zzaTJ;
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
      zzh.zza(this, var1, var2);
   }

   List zzAl() {
      return this.zzaTK;
   }
}
