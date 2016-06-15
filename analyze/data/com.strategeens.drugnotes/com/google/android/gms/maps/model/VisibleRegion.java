package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.maps.internal.class_1056;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.class_879;
import com.google.android.gms.maps.model.class_881;

public final class VisibleRegion implements SafeParcelable {
   public static final class_879 CREATOR = new class_879();
   // $FF: renamed from: CK int
   private final int field_3954;
   public final LatLng farLeft;
   public final LatLng farRight;
   public final LatLngBounds latLngBounds;
   public final LatLng nearLeft;
   public final LatLng nearRight;

   VisibleRegion(int var1, LatLng var2, LatLng var3, LatLng var4, LatLng var5, LatLngBounds var6) {
      this.field_3954 = var1;
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
      return this.field_3954;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("nearLeft", this.nearLeft).method_3424("nearRight", this.nearRight).method_3424("farLeft", this.farLeft).method_3424("farRight", this.farRight).method_3424("latLngBounds", this.latLngBounds).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(class_1056.method_5858()) {
         class_881.method_4969(this, var1, var2);
      } else {
         class_879.method_4965(this, var1, var2);
      }
   }
}
