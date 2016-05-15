package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zzg;

public final class PointOfInterest implements SafeParcelable {
   public static final zzg CREATOR = new zzg();
   private final int mVersionCode;
   public final String name;
   public final LatLng zzaTG;
   public final String zzaTH;

   PointOfInterest(int var1, LatLng var2, String var3, String var4) {
      this.mVersionCode = var1;
      this.zzaTG = var2;
      this.zzaTH = var3;
      this.name = var4;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
