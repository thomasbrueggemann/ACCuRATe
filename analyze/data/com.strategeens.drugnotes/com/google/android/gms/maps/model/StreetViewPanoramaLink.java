package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.maps.model.class_898;

public class StreetViewPanoramaLink implements SafeParcelable {
   public static final class_898 CREATOR = new class_898();
   // $FF: renamed from: CK int
   private final int field_4214;
   public final float bearing;
   public final String panoId;

   StreetViewPanoramaLink(int var1, String var2, float var3) {
      this.field_4214 = var1;
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
      return this.field_4214;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.panoId, Float.valueOf(this.bearing)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("panoId", this.panoId).method_3424("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_898.method_5022(this, var1, var2);
   }
}
