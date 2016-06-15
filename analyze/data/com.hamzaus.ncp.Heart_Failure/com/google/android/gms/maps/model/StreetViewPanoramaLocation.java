package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocationCreator;

public class StreetViewPanoramaLocation implements SafeParcelable {
   public static final StreetViewPanoramaLocationCreator CREATOR = new StreetViewPanoramaLocationCreator();
   public final StreetViewPanoramaLink[] links;
   public final String panoId;
   public final LatLng position;
   // $FF: renamed from: xJ int
   private final int field_2993;

   StreetViewPanoramaLocation(int var1, StreetViewPanoramaLink[] var2, LatLng var3, String var4) {
      this.field_2993 = var1;
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
      return this.field_2993;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.position, this.panoId};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("panoId", this.panoId).method_4301("position", this.position.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      StreetViewPanoramaLocationCreator.method_4062(this, var1, var2);
   }
}
