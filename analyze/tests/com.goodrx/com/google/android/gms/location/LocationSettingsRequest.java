package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzf;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
   public static final Creator<LocationSettingsRequest> CREATOR = new zzf();
   private final int mVersionCode;
   private final List<LocationRequest> zzaBm;
   private final boolean zzaOf;
   private final boolean zzaOg;

   LocationSettingsRequest(int var1, List<LocationRequest> var2, boolean var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzaBm = var2;
      this.zzaOf = var3;
      this.zzaOg = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public List<LocationRequest> zzuZ() {
      return Collections.unmodifiableList(this.zzaBm);
   }

   public boolean zzyK() {
      return this.zzaOf;
   }

   public boolean zzyL() {
      return this.zzaOg;
   }
}
