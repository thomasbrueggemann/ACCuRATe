package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.zzk;

public class StreetViewPanoramaLink implements SafeParcelable {
   public static final zzk CREATOR = new zzk();
   public final float bearing;
   private final int mVersionCode;
   public final String panoId;

   StreetViewPanoramaLink(int var1, String var2, float var3) {
      this.mVersionCode = var1;
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
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.panoId, Float.valueOf(this.bearing)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("panoId", this.panoId).zzg("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
