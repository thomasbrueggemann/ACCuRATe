package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.class_973;
import com.google.android.gms.maps.internal.class_698;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
   public static final class_973 CREATOR = new class_973();
   // $FF: renamed from: CK int
   private final int field_4122;
   private Boolean akG;
   private Boolean akM = Boolean.valueOf(true);
   private StreetViewPanoramaCamera alr;
   private String als;
   private LatLng alt;
   private Integer alu;
   private Boolean alv = Boolean.valueOf(true);
   private Boolean alw = Boolean.valueOf(true);
   private Boolean alx = Boolean.valueOf(true);

   public StreetViewPanoramaOptions() {
      this.field_4122 = 1;
   }

   StreetViewPanoramaOptions(int var1, StreetViewPanoramaCamera var2, String var3, LatLng var4, Integer var5, byte var6, byte var7, byte var8, byte var9, byte var10) {
      this.field_4122 = var1;
      this.alr = var2;
      this.alt = var4;
      this.alu = var5;
      this.als = var3;
      this.alv = class_698.method_3999(var6);
      this.akM = class_698.method_3999(var7);
      this.alw = class_698.method_3999(var8);
      this.alx = class_698.method_3999(var9);
      this.akG = class_698.method_3999(var10);
   }

   public int describeContents() {
      return 0;
   }

   public Boolean getPanningGesturesEnabled() {
      return this.alw;
   }

   public String getPanoramaId() {
      return this.als;
   }

   public LatLng getPosition() {
      return this.alt;
   }

   public Integer getRadius() {
      return this.alu;
   }

   public Boolean getStreetNamesEnabled() {
      return this.alx;
   }

   public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
      return this.alr;
   }

   public Boolean getUseViewLifecycleInFragment() {
      return this.akG;
   }

   public Boolean getUserNavigationEnabled() {
      return this.alv;
   }

   int getVersionCode() {
      return this.field_4122;
   }

   public Boolean getZoomGesturesEnabled() {
      return this.akM;
   }

   // $FF: renamed from: nE () byte
   byte method_5379() {
      return class_698.method_4000(this.akG);
   }

   // $FF: renamed from: nI () byte
   byte method_5380() {
      return class_698.method_4000(this.akM);
   }

   // $FF: renamed from: nS () byte
   byte method_5381() {
      return class_698.method_4000(this.alv);
   }

   // $FF: renamed from: nT () byte
   byte method_5382() {
      return class_698.method_4000(this.alw);
   }

   // $FF: renamed from: nU () byte
   byte method_5383() {
      return class_698.method_4000(this.alx);
   }

   public StreetViewPanoramaOptions panningGesturesEnabled(boolean var1) {
      this.alw = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera var1) {
      this.alr = var1;
      return this;
   }

   public StreetViewPanoramaOptions panoramaId(String var1) {
      this.als = var1;
      return this;
   }

   public StreetViewPanoramaOptions position(LatLng var1) {
      this.alt = var1;
      return this;
   }

   public StreetViewPanoramaOptions position(LatLng var1, Integer var2) {
      this.alt = var1;
      this.alu = var2;
      return this;
   }

   public StreetViewPanoramaOptions streetNamesEnabled(boolean var1) {
      this.alx = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean var1) {
      this.akG = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions userNavigationEnabled(boolean var1) {
      this.alv = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_973.method_5413(this, var1, var2);
   }

   public StreetViewPanoramaOptions zoomGesturesEnabled(boolean var1) {
      this.akM = Boolean.valueOf(var1);
      return this;
   }
}
