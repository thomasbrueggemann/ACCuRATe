package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlayOptionsCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.class_690;

public final class GroundOverlayOptions implements SafeParcelable {
   public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
   public static final float NO_DIMENSION = -1.0F;
   private float aaA;
   private LatLngBounds aaB;
   private float aaC = 0.0F;
   private float aaD = 0.5F;
   private float aaE = 0.5F;
   private float aan;
   private float aau;
   private boolean aav = true;
   private BitmapDescriptor aax;
   private LatLng aay;
   private float aaz;
   // $FF: renamed from: xJ int
   private final int field_3116;

   public GroundOverlayOptions() {
      this.field_3116 = 1;
   }

   GroundOverlayOptions(int var1, IBinder var2, LatLng var3, float var4, float var5, LatLngBounds var6, float var7, float var8, boolean var9, float var10, float var11, float var12) {
      this.field_3116 = var1;
      this.aax = new BitmapDescriptor(class_157.class_1317.method_4176(var2));
      this.aay = var3;
      this.aaz = var4;
      this.aaA = var5;
      this.aaB = var6;
      this.aan = var7;
      this.aau = var8;
      this.aav = var9;
      this.aaC = var10;
      this.aaD = var11;
      this.aaE = var12;
   }

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, float, float) com.google.android.gms.maps.model.GroundOverlayOptions
   private GroundOverlayOptions method_3308(LatLng var1, float var2, float var3) {
      this.aay = var1;
      this.aaz = var2;
      this.aaA = var3;
      return this;
   }

   public GroundOverlayOptions anchor(float var1, float var2) {
      this.aaD = var1;
      this.aaE = var2;
      return this;
   }

   public GroundOverlayOptions bearing(float var1) {
      this.aan = (360.0F + var1 % 360.0F) % 360.0F;
      return this;
   }

   public int describeContents() {
      return 0;
   }

   public float getAnchorU() {
      return this.aaD;
   }

   public float getAnchorV() {
      return this.aaE;
   }

   public float getBearing() {
      return this.aan;
   }

   public LatLngBounds getBounds() {
      return this.aaB;
   }

   public float getHeight() {
      return this.aaA;
   }

   public BitmapDescriptor getImage() {
      return this.aax;
   }

   public LatLng getLocation() {
      return this.aay;
   }

   public float getTransparency() {
      return this.aaC;
   }

   int getVersionCode() {
      return this.field_3116;
   }

   public float getWidth() {
      return this.aaz;
   }

   public float getZIndex() {
      return this.aau;
   }

   public GroundOverlayOptions image(BitmapDescriptor var1) {
      this.aax = var1;
      return this;
   }

   public boolean isVisible() {
      return this.aav;
   }

   // $FF: renamed from: jI () android.os.IBinder
   IBinder method_3309() {
      return this.aax.method_1958().asBinder();
   }

   public GroundOverlayOptions position(LatLng var1, float var2) {
      boolean var3 = true;
      boolean var4;
      if(this.aaB == null) {
         var4 = var3;
      } else {
         var4 = false;
      }

      class_347.method_2161(var4, "Position has already been set using positionFromBounds");
      boolean var5;
      if(var1 != null) {
         var5 = var3;
      } else {
         var5 = false;
      }

      class_347.method_2168(var5, "Location must be specified");
      if(var2 < 0.0F) {
         var3 = false;
      }

      class_347.method_2168(var3, "Width must be non-negative");
      return this.method_3308(var1, var2, -1.0F);
   }

   public GroundOverlayOptions position(LatLng var1, float var2, float var3) {
      boolean var4 = true;
      boolean var5;
      if(this.aaB == null) {
         var5 = var4;
      } else {
         var5 = false;
      }

      class_347.method_2161(var5, "Position has already been set using positionFromBounds");
      boolean var6;
      if(var1 != null) {
         var6 = var4;
      } else {
         var6 = false;
      }

      class_347.method_2168(var6, "Location must be specified");
      boolean var7;
      if(var2 >= 0.0F) {
         var7 = var4;
      } else {
         var7 = false;
      }

      class_347.method_2168(var7, "Width must be non-negative");
      if(var3 < 0.0F) {
         var4 = false;
      }

      class_347.method_2168(var4, "Height must be non-negative");
      return this.method_3308(var1, var2, var3);
   }

   public GroundOverlayOptions positionFromBounds(LatLngBounds var1) {
      boolean var2;
      if(this.aay == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      Object[] var3 = new Object[]{this.aay};
      class_347.method_2162(var2, "Position has already been set using position: %s", var3);
      this.aaB = var1;
      return this;
   }

   public GroundOverlayOptions transparency(float var1) {
      boolean var2;
      if(var1 >= 0.0F && var1 <= 1.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_347.method_2168(var2, "Transparency must be in the range [0..1]");
      this.aaC = var1;
      return this;
   }

   public GroundOverlayOptions visible(boolean var1) {
      this.aav = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_690.method_4007(this, var1, var2);
      } else {
         GroundOverlayOptionsCreator.method_4167(this, var1, var2);
      }
   }

   public GroundOverlayOptions zIndex(float var1) {
      this.aau = var1;
      return this;
   }
}
