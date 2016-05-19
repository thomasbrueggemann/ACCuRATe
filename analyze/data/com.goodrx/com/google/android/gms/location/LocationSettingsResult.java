package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.zzg;

public final class LocationSettingsResult implements Result, SafeParcelable {
   public static final Creator<LocationSettingsResult> CREATOR = new zzg();
   private final int mVersionCode;
   private final Status zzUX;
   private final LocationSettingsStates zzaOi;

   LocationSettingsResult(int var1, Status var2, LocationSettingsStates var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaOi = var3;
   }

   public int describeContents() {
      return 0;
   }

   public LocationSettingsStates getLocationSettingsStates() {
      return this.zzaOi;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
