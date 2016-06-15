package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_482;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_903;
import com.google.android.gms.maps.model.class_904;

public final class CameraPosition implements SafeParcelable {
   public static final class_904 CREATOR = new class_904();
   // $FF: renamed from: CK int
   private final int field_4455;
   public final float bearing;
   public final LatLng target;
   public final float tilt;
   public final float zoom;

   CameraPosition(int var1, LatLng var2, float var3, float var4, float var5) {
      class_335.method_2306(var2, "null camera target");
      boolean var7;
      if(0.0F <= var4 && var4 <= 90.0F) {
         var7 = true;
      } else {
         var7 = false;
      }

      class_335.method_2308(var7, "Tilt needs to be between 0 and 90 inclusive");
      this.field_4455 = var1;
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
         TypedArray var2 = var0.getResources().obtainAttributes(var1, class_482.styleable.MapAttrs);
         float var3;
         if(var2.hasValue(class_482.styleable.MapAttrs_cameraTargetLat)) {
            var3 = var2.getFloat(class_482.styleable.MapAttrs_cameraTargetLat, 0.0F);
         } else {
            var3 = 0.0F;
         }

         float var4;
         if(var2.hasValue(class_482.styleable.MapAttrs_cameraTargetLng)) {
            var4 = var2.getFloat(class_482.styleable.MapAttrs_cameraTargetLng, 0.0F);
         } else {
            var4 = 0.0F;
         }

         LatLng var5 = new LatLng((double)var3, (double)var4);
         CameraPosition.Builder var6 = builder();
         var6.target(var5);
         if(var2.hasValue(class_482.styleable.MapAttrs_cameraZoom)) {
            var6.zoom(var2.getFloat(class_482.styleable.MapAttrs_cameraZoom, 0.0F));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_cameraBearing)) {
            var6.bearing(var2.getFloat(class_482.styleable.MapAttrs_cameraBearing, 0.0F));
         }

         if(var2.hasValue(class_482.styleable.MapAttrs_cameraTilt)) {
            var6.tilt(var2.getFloat(class_482.styleable.MapAttrs_cameraTilt, 0.0F));
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
      return this.field_4455;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("target", this.target).method_3424("zoom", Float.valueOf(this.zoom)).method_3424("tilt", Float.valueOf(this.tilt)).method_3424("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_903.method_5035(this, var1, var2);
      } else {
         class_904.method_5037(this, var1, var2);
      }
   }

   public static final class Builder {
      private LatLng alN;
      private float alO;
      private float alP;
      private float alQ;

      public Builder() {
      }

      public Builder(CameraPosition var1) {
         this.alN = var1.target;
         this.alO = var1.zoom;
         this.alP = var1.tilt;
         this.alQ = var1.bearing;
      }

      public CameraPosition.Builder bearing(float var1) {
         this.alQ = var1;
         return this;
      }

      public CameraPosition build() {
         return new CameraPosition(this.alN, this.alO, this.alP, this.alQ);
      }

      public CameraPosition.Builder target(LatLng var1) {
         this.alN = var1;
         return this;
      }

      public CameraPosition.Builder tilt(float var1) {
         this.alP = var1;
         return this;
      }

      public CameraPosition.Builder zoom(float var1) {
         this.alO = var1;
         return this;
      }
   }
}
