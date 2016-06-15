package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.StreetViewPanoramaOptionsCreator;
import com.google.android.gms.maps.internal.class_593;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
   public static final StreetViewPanoramaOptionsCreator CREATOR = new StreetViewPanoramaOptionsCreator();
   // $FF: renamed from: ZS com.google.android.gms.maps.model.StreetViewPanoramaCamera
   private StreetViewPanoramaCamera field_4018;
   // $FF: renamed from: ZT java.lang.String
   private String field_4019;
   // $FF: renamed from: ZU com.google.android.gms.maps.model.LatLng
   private LatLng field_4020;
   // $FF: renamed from: ZV java.lang.Integer
   private Integer field_4021;
   // $FF: renamed from: ZW java.lang.Boolean
   private Boolean field_4022 = Boolean.valueOf(true);
   // $FF: renamed from: ZX java.lang.Boolean
   private Boolean field_4023 = Boolean.valueOf(true);
   // $FF: renamed from: ZY java.lang.Boolean
   private Boolean field_4024 = Boolean.valueOf(true);
   // $FF: renamed from: Zq java.lang.Boolean
   private Boolean field_4025;
   // $FF: renamed from: Zw java.lang.Boolean
   private Boolean field_4026 = Boolean.valueOf(true);
   // $FF: renamed from: xJ int
   private final int field_4027;

   public StreetViewPanoramaOptions() {
      this.field_4027 = 1;
   }

   StreetViewPanoramaOptions(int var1, StreetViewPanoramaCamera var2, String var3, LatLng var4, Integer var5, byte var6, byte var7, byte var8, byte var9, byte var10) {
      this.field_4027 = var1;
      this.field_4018 = var2;
      this.field_4020 = var4;
      this.field_4021 = var5;
      this.field_4019 = var3;
      this.field_4022 = class_593.method_3333(var6);
      this.field_4026 = class_593.method_3333(var7);
      this.field_4023 = class_593.method_3333(var8);
      this.field_4024 = class_593.method_3333(var9);
      this.field_4025 = class_593.method_3333(var10);
   }

   public int describeContents() {
      return 0;
   }

   public Boolean getPanningGesturesEnabled() {
      return this.field_4023;
   }

   public String getPanoramaId() {
      return this.field_4019;
   }

   public LatLng getPosition() {
      return this.field_4020;
   }

   public Integer getRadius() {
      return this.field_4021;
   }

   public Boolean getStreetNamesEnabled() {
      return this.field_4024;
   }

   public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
      return this.field_4018;
   }

   public Boolean getUseViewLifecycleInFragment() {
      return this.field_4025;
   }

   public Boolean getUserNavigationEnabled() {
      return this.field_4022;
   }

   int getVersionCode() {
      return this.field_4027;
   }

   public Boolean getZoomGesturesEnabled() {
      return this.field_4026;
   }

   // $FF: renamed from: jA () byte
   byte method_4275() {
      return class_593.method_3334(this.field_4024);
   }

   // $FF: renamed from: jm () byte
   byte method_4276() {
      return class_593.method_3334(this.field_4025);
   }

   // $FF: renamed from: jq () byte
   byte method_4277() {
      return class_593.method_3334(this.field_4026);
   }

   // $FF: renamed from: jy () byte
   byte method_4278() {
      return class_593.method_3334(this.field_4022);
   }

   // $FF: renamed from: jz () byte
   byte method_4279() {
      return class_593.method_3334(this.field_4023);
   }

   public StreetViewPanoramaOptions panningGesturesEnabled(boolean var1) {
      this.field_4023 = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera var1) {
      this.field_4018 = var1;
      return this;
   }

   public StreetViewPanoramaOptions panoramaId(String var1) {
      this.field_4019 = var1;
      return this;
   }

   public StreetViewPanoramaOptions position(LatLng var1) {
      this.field_4020 = var1;
      return this;
   }

   public StreetViewPanoramaOptions position(LatLng var1, Integer var2) {
      this.field_4020 = var1;
      this.field_4021 = var2;
      return this;
   }

   public StreetViewPanoramaOptions streetNamesEnabled(boolean var1) {
      this.field_4024 = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean var1) {
      this.field_4025 = Boolean.valueOf(var1);
      return this;
   }

   public StreetViewPanoramaOptions userNavigationEnabled(boolean var1) {
      this.field_4022 = Boolean.valueOf(var1);
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      StreetViewPanoramaOptionsCreator.method_2284(this, var1, var2);
   }

   public StreetViewPanoramaOptions zoomGesturesEnabled(boolean var1) {
      this.field_4026 = Boolean.valueOf(var1);
      return this;
   }
}
