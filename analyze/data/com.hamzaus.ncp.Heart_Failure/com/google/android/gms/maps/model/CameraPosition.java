package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_443;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.CameraPositionCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_692;

public final class CameraPosition implements SafeParcelable {
   public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
   public final float bearing;
   public final LatLng target;
   public final float tilt;
   // $FF: renamed from: xJ int
   private final int field_4304;
   public final float zoom;

   CameraPosition(int var1, LatLng var2, float var3, float var4, float var5) {
      class_347.method_2166(var2, "null camera target");
      boolean var7;
      if(0.0F <= var4 && var4 <= 90.0F) {
         var7 = true;
      } else {
         var7 = false;
      }

      class_347.method_2168(var7, "Tilt needs to be between 0 and 90 inclusive");
      this.field_4304 = var1;
      this.target = var2;
      this.zoom = var3;
      this.tilt = var4 + 0.0F;
      if((double)var5 <= 0.0D) {
         var5 = 360.0F + var5 % 360.0F;
      }

      this.bearing = var5 % 360.0F;
   }

   public CameraPosition(LatLng var1, float var2, float var3, float var4) {
      this(1, var1, var2, var3, var4);
   }

   public static CameraPosition.Builder builder() {
      return new CameraPosition.Builder();
   }

   public static CameraPosition.Builder builder(CameraPosition var0) {
      return new CameraPosition.Builder(var0);
   }

   public static CameraPosition createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, class_443.styleable.MapAttrs);
         float var3;
         if(var2.hasValue(2)) {
            var3 = var2.getFloat(2, 0.0F);
         } else {
            var3 = 0.0F;
         }

         float var4;
         if(var2.hasValue(3)) {
            var4 = var2.getFloat(3, 0.0F);
         } else {
            var4 = 0.0F;
         }

         LatLng var5 = new LatLng((double)var3, (double)var4);
         CameraPosition.Builder var6 = builder();
         var6.target(var5);
         if(var2.hasValue(5)) {
            var6.zoom(var2.getFloat(5, 0.0F));
         }

         if(var2.hasValue(1)) {
            var6.bearing(var2.getFloat(1, 0.0F));
         }

         if(var2.hasValue(4)) {
            var6.tilt(var2.getFloat(4, 0.0F));
         }

         return var6.build();
      }
   }

   public static final CameraPosition fromLatLngZoom(LatLng var0, float var1) {
      return new CameraPosition(var0, var1, 0.0F, 0.0F);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof CameraPosition)) {
            return false;
         }

         CameraPosition var2 = (CameraPosition)var1;
         if(!this.target.equals(var2.target) || Float.floatToIntBits(this.zoom) != Float.floatToIntBits(var2.zoom) || Float.floatToIntBits(this.tilt) != Float.floatToIntBits(var2.tilt) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.field_4304;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("target", this.target).method_4301("zoom", Float.valueOf(this.zoom)).method_4301("tilt", Float.valueOf(this.tilt)).method_4301("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_692.method_4009(this, var1, var2);
      } else {
         CameraPositionCreator.method_4006(this, var1, var2);
      }
   }

   public static final class Builder {
      private LatLng aak;
      private float aal;
      private float aam;
      private float aan;

      public Builder() {
      }

      public Builder(CameraPosition var1) {
         this.aak = var1.target;
         this.aal = var1.zoom;
         this.aam = var1.tilt;
         this.aan = var1.bearing;
      }

      public CameraPosition.Builder bearing(float var1) {
         this.aan = var1;
         return this;
      }

      public CameraPosition build() {
         return new CameraPosition(this.aak, this.aal, this.aam, this.aan);
      }

      public CameraPosition.Builder target(LatLng var1) {
         this.aak = var1;
         return this;
      }

      public CameraPosition.Builder tilt(float var1) {
         this.aam = var1;
         return this;
      }

      public CameraPosition.Builder zoom(float var1) {
         this.aal = var1;
         return this;
      }
   }
}
