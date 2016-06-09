package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_54;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zza;

public final class CameraPosition implements SafeParcelable {
   public static final zza CREATOR = new zza();
   public final float bearing;
   private final int mVersionCode;
   public final LatLng target;
   public final float tilt;
   public final float zoom;

   CameraPosition(int var1, LatLng var2, float var3, float var4, float var5) {
      zzx.zzb(var2, "null camera target");
      boolean var7;
      if(0.0F <= var4 && var4 <= 90.0F) {
         var7 = true;
      } else {
         var7 = false;
      }

      Object[] var8 = new Object[]{Float.valueOf(var4)};
      zzx.zzb(var7, "Tilt needs to be between 0 and 90 inclusive: %s", var8);
      this.mVersionCode = var1;
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

   public static CameraPosition createFromAttributes(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, class_54.styleable.MapAttrs);
         float var3;
         if(var2.hasValue(class_54.styleable.MapAttrs_cameraTargetLat)) {
            var3 = var2.getFloat(class_54.styleable.MapAttrs_cameraTargetLat, 0.0F);
         } else {
            var3 = 0.0F;
         }

         float var4;
         if(var2.hasValue(class_54.styleable.MapAttrs_cameraTargetLng)) {
            var4 = var2.getFloat(class_54.styleable.MapAttrs_cameraTargetLng, 0.0F);
         } else {
            var4 = 0.0F;
         }

         LatLng var5 = new LatLng((double)var3, (double)var4);
         CameraPosition.Builder var6 = builder();
         var6.target(var5);
         if(var2.hasValue(class_54.styleable.MapAttrs_cameraZoom)) {
            var6.zoom(var2.getFloat(class_54.styleable.MapAttrs_cameraZoom, 0.0F));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_cameraBearing)) {
            var6.bearing(var2.getFloat(class_54.styleable.MapAttrs_cameraBearing, 0.0F));
         }

         if(var2.hasValue(class_54.styleable.MapAttrs_cameraTilt)) {
            var6.tilt(var2.getFloat(class_54.styleable.MapAttrs_cameraTilt, 0.0F));
         }

         return var6.build();
      }
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
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("target", this.target).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public static final class Builder {
      private LatLng zzaSX;
      private float zzaSY;
      private float zzaSZ;
      private float zzaTa;

      public CameraPosition.Builder bearing(float var1) {
         this.zzaTa = var1;
         return this;
      }

      public CameraPosition build() {
         return new CameraPosition(this.zzaSX, this.zzaSY, this.zzaSZ, this.zzaTa);
      }

      public CameraPosition.Builder target(LatLng var1) {
         this.zzaSX = var1;
         return this;
      }

      public CameraPosition.Builder tilt(float var1) {
         this.zzaSZ = var1;
         return this;
      }

      public CameraPosition.Builder zoom(float var1) {
         this.zzaSY = var1;
         return this;
      }
   }
}
