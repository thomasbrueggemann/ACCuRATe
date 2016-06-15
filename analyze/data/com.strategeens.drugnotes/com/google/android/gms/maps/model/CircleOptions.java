package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_888;
import com.google.android.gms.maps.model.class_902;

public final class CircleOptions implements SafeParcelable {
   public static final class_902 CREATOR = new class_902();
   // $FF: renamed from: CK int
   private final int field_4120;
   private LatLng alS = null;
   private double alT = 0.0D;
   private float alU = 10.0F;
   private int alV = -16777216;
   private int alW = 0;
   private float alX = 0.0F;
   private boolean alY = true;

   public CircleOptions() {
      this.field_4120 = 1;
   }

   CircleOptions(int var1, LatLng var2, double var3, float var5, int var6, int var7, float var8, boolean var9) {
      this.field_4120 = var1;
      this.alS = var2;
      this.alT = var3;
      this.alU = var5;
      this.alV = var6;
      this.alW = var7;
      this.alX = var8;
      this.alY = var9;
   }

   public CircleOptions center(LatLng var1) {
      this.alS = var1;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public CircleOptions fillColor(int var1) {
      this.alW = var1;
      return this;
   }

   public LatLng getCenter() {
      return this.alS;
   }

   public int getFillColor() {
      return this.alW;
   }

   public double getRadius() {
      return this.alT;
   }

   public int getStrokeColor() {
      return this.alV;
   }

   public float getStrokeWidth() {
      return this.alU;
   }

   int getVersionCode() {
      return this.field_4120;
   }

   public float getZIndex() {
      return this.alX;
   }

   public boolean isVisible() {
      return this.alY;
   }

   public CircleOptions radius(double var1) {
      this.alT = var1;
      return this;
   }

   public CircleOptions strokeColor(int var1) {
      this.alV = var1;
      return this;
   }

   public CircleOptions strokeWidth(float var1) {
      this.alU = var1;
      return this;
   }

   public CircleOptions visible(boolean var1) {
      this.alY = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_888.method_5002(this, var1, var2);
      } else {
         class_902.method_5032(this, var1, var2);
      }
   }

   public CircleOptions zIndex(float var1) {
      this.alX = var1;
      return this;
   }
}
