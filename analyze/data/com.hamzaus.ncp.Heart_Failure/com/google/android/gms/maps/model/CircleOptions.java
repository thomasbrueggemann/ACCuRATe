package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.CircleOptionsCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_691;

public final class CircleOptions implements SafeParcelable {
   public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
   private LatLng aap = null;
   private double aaq = 0.0D;
   private float aar = 10.0F;
   private int aas = -16777216;
   private int aat = 0;
   private float aau = 0.0F;
   private boolean aav = true;
   // $FF: renamed from: xJ int
   private final int field_4016;

   public CircleOptions() {
      this.field_4016 = 1;
   }

   CircleOptions(int var1, LatLng var2, double var3, float var5, int var6, int var7, float var8, boolean var9) {
      this.field_4016 = var1;
      this.aap = var2;
      this.aaq = var3;
      this.aar = var5;
      this.aas = var6;
      this.aat = var7;
      this.aau = var8;
      this.aav = var9;
   }

   public CircleOptions center(LatLng var1) {
      this.aap = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CircleOptions fillColor(int var1) {
      this.aat = var1;
      return this;
   }

   public LatLng getCenter() {
      return this.aap;
   }

   public int getFillColor() {
      return this.aat;
   }

   public double getRadius() {
      return this.aaq;
   }

   public int getStrokeColor() {
      return this.aas;
   }

   public float getStrokeWidth() {
      return this.aar;
   }

   int getVersionCode() {
      return this.field_4016;
   }

   public float getZIndex() {
      return this.aau;
   }

   public boolean isVisible() {
      return this.aav;
   }

   public CircleOptions radius(double var1) {
      this.aaq = var1;
      return this;
   }

   public CircleOptions strokeColor(int var1) {
      this.aas = var1;
      return this;
   }

   public CircleOptions strokeWidth(float var1) {
      this.aar = var1;
      return this;
   }

   public CircleOptions visible(boolean var1) {
      this.aav = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_691.method_4008(this, var1, var2);
      } else {
         CircleOptionsCreator.method_4164(this, var1, var2);
      }
   }

   public CircleOptions zIndex(float var1) {
      this.aau = var1;
      return this;
   }
}
