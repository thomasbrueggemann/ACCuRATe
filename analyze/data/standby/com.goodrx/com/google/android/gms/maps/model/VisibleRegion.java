package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.zzp;

public final class VisibleRegion implements SafeParcelable {
   public static final zzp CREATOR = new zzp();
   public final LatLng farLeft;
   public final LatLng farRight;
   public final LatLngBounds latLngBounds;
   private final int mVersionCode;
   public final LatLng nearLeft;
   public final LatLng nearRight;

   VisibleRegion(int var1, LatLng var2, LatLng var3, LatLng var4, LatLng var5, LatLngBounds var6) {
      this.mVersionCode = var1;
      this.nearLeft = var2;
      this.nearRight = var3;
      this.farLeft = var4;
      this.farRight = var5;
      this.latLngBounds = var6;
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
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("nearLeft", this.nearLeft).zzg("nearRight", this.nearRight).zzg("farLeft", this.farLeft).zzg("farRight", this.farRight).zzg("latLngBounds", this.latLngBounds).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }
}
