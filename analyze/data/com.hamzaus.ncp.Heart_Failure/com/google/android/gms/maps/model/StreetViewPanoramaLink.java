package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.maps.model.StreetViewPanoramaLinkCreator;

public class StreetViewPanoramaLink implements SafeParcelable {
   public static final StreetViewPanoramaLinkCreator CREATOR = new StreetViewPanoramaLinkCreator();
   public final float bearing;
   public final String panoId;
   // $FF: renamed from: xJ int
   private final int field_4095;

   StreetViewPanoramaLink(int var1, String var2, float var3) {
      this.field_4095 = var1;
      this.panoId = var2;
      if((double)var3 <= 0.0D) {
         var3 = 360.0F + var3 % 360.0F;
      }

      this.bearing = var3 % 360.0F;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaLink)) {
            return false;
         }

         StreetViewPanoramaLink var2 = (StreetViewPanoramaLink)var1;
         if(!this.panoId.equals(var2.panoId) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.field_4095;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.panoId, Float.valueOf(this.bearing)};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("panoId", this.panoId).method_4301("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      StreetViewPanoramaLinkCreator.method_4175(this, var1, var2);
   }
}
