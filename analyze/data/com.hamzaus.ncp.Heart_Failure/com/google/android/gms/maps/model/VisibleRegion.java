package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.maps.internal.class_592;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegionCreator;
import com.google.android.gms.maps.model.class_687;

public final class VisibleRegion implements SafeParcelable {
   public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
   public final LatLng farLeft;
   public final LatLng farRight;
   public final LatLngBounds latLngBounds;
   public final LatLng nearLeft;
   public final LatLng nearRight;
   // $FF: renamed from: xJ int
   private final int field_3873;

   VisibleRegion(int var1, LatLng var2, LatLng var3, LatLng var4, LatLng var5, LatLngBounds var6) {
      this.field_3873 = var1;
      this.nearLeft = var2;
      this.nearRight = var3;
      this.farLeft = var4;
      this.farRight = var5;
      this.latLngBounds = var6;
   }

   public VisibleRegion(LatLng var1, LatLng var2, LatLng var3, LatLng var4, LatLngBounds var5) {
      this(1, var1, var2, var3, var4, var5);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof VisibleRegion)) {
            return false;
         }

         VisibleRegion var2 = (VisibleRegion)var1;
         if(!this.nearLeft.equals(var2.nearLeft) || !this.nearRight.equals(var2.nearRight) || !this.farLeft.equals(var2.farLeft) || !this.farRight.equals(var2.farRight) || !this.latLngBounds.equals(var2.latLngBounds)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.field_3873;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("nearLeft", this.nearLeft).method_4301("nearRight", this.nearRight).method_4301("farLeft", this.farLeft).method_4301("farRight", this.farRight).method_4301("latLngBounds", this.latLngBounds).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_592.method_3332()) {
         class_687.method_4003(this, var1, var2);
      } else {
         VisibleRegionCreator.method_3951(this, var1, var2);
      }
   }
}
