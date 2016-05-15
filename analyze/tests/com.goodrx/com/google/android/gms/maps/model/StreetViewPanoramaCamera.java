package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.zzj;

public class StreetViewPanoramaCamera implements SafeParcelable {
   public static final zzj CREATOR = new zzj();
   public final float bearing;
   private final int mVersionCode;
   public final float tilt;
   public final float zoom;
   private StreetViewPanoramaOrientation zzaTN;

   StreetViewPanoramaCamera(int var1, float var2, float var3, float var4) {
      boolean var5;
      if(-90.0F <= var3 && var3 <= 90.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzx.zzb(var5, "Tilt needs to be between -90 and 90 inclusive");
      this.mVersionCode = var1;
      if((double)var2 <= 0.0D) {
         var2 = 0.0F;
      }

      this.zoom = var2;
      this.tilt = var3 + 0.0F;
      float var6;
      if((double)var4 <= 0.0D) {
         var6 = 360.0F + var4 % 360.0F;
      } else {
         var6 = var4;
      }

      this.bearing = var6 % 360.0F;
      this.zzaTN = (new StreetViewPanoramaOrientation.Builder()).tilt(var3).bearing(var4).build();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaCamera)) {
            return false;
         }

         StreetViewPanoramaCamera var2 = (StreetViewPanoramaCamera)var1;
         if(Float.floatToIntBits(this.zoom) != Float.floatToIntBits(var2.zoom) || Float.floatToIntBits(this.tilt) != Float.floatToIntBits(var2.tilt) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
