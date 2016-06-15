package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.maps.model.StreetViewPanoramaCameraCreator;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanoramaCamera implements SafeParcelable {
   public static final StreetViewPanoramaCameraCreator CREATOR = new StreetViewPanoramaCameraCreator();
   private StreetViewPanoramaOrientation aaY;
   public final float bearing;
   public final float tilt;
   // $FF: renamed from: xJ int
   private final int field_4303;
   public final float zoom;

   public StreetViewPanoramaCamera(float var1, float var2, float var3) {
      this(1, var1, var2, var3);
   }

   StreetViewPanoramaCamera(int var1, float var2, float var3, float var4) {
      boolean var5;
      if(-90.0F <= var3 && var3 <= 90.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      class_347.method_2168(var5, "Tilt needs to be between -90 and 90 inclusive");
      this.field_4303 = var1;
      this.zoom = var2;
      this.tilt = 0.0F + var3;
      float var6;
      if((double)var4 <= 0.0D) {
         var6 = 360.0F + var4 % 360.0F;
      } else {
         var6 = var4;
      }

      this.bearing = var6 % 360.0F;
      this.aaY = (new StreetViewPanoramaOrientation.Builder()).tilt(var3).bearing(var4).build();
   }

   public static StreetViewPanoramaCamera.Builder builder() {
      return new StreetViewPanoramaCamera.Builder();
   }

   public static StreetViewPanoramaCamera.Builder builder(StreetViewPanoramaCamera var0) {
      return new StreetViewPanoramaCamera.Builder(var0);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaCamera)) {
            return false;
         }

         StreetViewPanoramaCamera var2 = (StreetViewPanoramaCamera)var1;
         if(Float.floatToIntBits(this.zoom) != Float.floatToIntBits(var2.zoom) || Float.floatToIntBits(this.tilt) != Float.floatToIntBits(var2.tilt) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   public StreetViewPanoramaOrientation getOrientation() {
      return this.aaY;
   }

   int getVersionCode() {
      return this.field_4303;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("zoom", Float.valueOf(this.zoom)).method_4301("tilt", Float.valueOf(this.tilt)).method_4301("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      StreetViewPanoramaCameraCreator.method_3323(this, var1, var2);
   }

   public static final class Builder {
      public float bearing;
      public float tilt;
      public float zoom;

      public Builder() {
      }

      public Builder(StreetViewPanoramaCamera var1) {
         this.zoom = var1.zoom;
         this.bearing = var1.bearing;
         this.tilt = var1.tilt;
      }

      public StreetViewPanoramaCamera.Builder bearing(float var1) {
         this.bearing = var1;
         return this;
      }

      public StreetViewPanoramaCamera build() {
         return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
      }

      public StreetViewPanoramaCamera.Builder orientation(StreetViewPanoramaOrientation var1) {
         this.tilt = var1.tilt;
         this.bearing = var1.bearing;
         return this;
      }

      public StreetViewPanoramaCamera.Builder tilt(float var1) {
         this.tilt = var1;
         return this;
      }

      public StreetViewPanoramaCamera.Builder zoom(float var1) {
         this.zoom = var1;
         return this;
      }
   }
}
