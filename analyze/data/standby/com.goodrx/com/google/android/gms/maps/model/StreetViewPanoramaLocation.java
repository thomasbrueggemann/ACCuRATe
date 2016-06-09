package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.zzl;

public class StreetViewPanoramaLocation implements SafeParcelable {
   public static final zzl CREATOR = new zzl();
   public final StreetViewPanoramaLink[] links;
   private final int mVersionCode;
   public final String panoId;
   public final LatLng position;

   StreetViewPanoramaLocation(int var1, StreetViewPanoramaLink[] var2, LatLng var3, String var4) {
      this.mVersionCode = var1;
      this.links = var2;
      this.position = var3;
      this.panoId = var4;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaLocation)) {
            return false;
         }

         StreetViewPanoramaLocation var2 = (StreetViewPanoramaLocation)var1;
         if(!this.panoId.equals(var2.panoId) || !this.position.equals(var2.position)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.position, this.panoId};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("panoId", this.panoId).zzg("position", this.position.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }
}
