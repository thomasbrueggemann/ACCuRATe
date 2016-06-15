package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.class_899;

public class StreetViewPanoramaLocation implements SafeParcelable {
   public static final class_899 CREATOR = new class_899();
   // $FF: renamed from: CK int
   private final int field_2895;
   public final StreetViewPanoramaLink[] links;
   public final String panoId;
   public final LatLng position;

   StreetViewPanoramaLocation(int var1, StreetViewPanoramaLink[] var2, LatLng var3, String var4) {
      this.field_2895 = var1;
      this.links = var2;
      this.position = var3;
      this.panoId = var4;
   }

   public StreetViewPanoramaLocation(StreetViewPanoramaLink[] var1, LatLng var2, String var3) {
      this(1, var1, var2, var3);
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
      return this.field_2895;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.position, this.panoId};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("panoId", this.panoId).method_3424("position", this.position.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_899.method_5025(this, var1, var2);
   }
}
