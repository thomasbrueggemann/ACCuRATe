package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zze;

public final class FusedLocationProviderResult implements Result, SafeParcelable {
   public static final Creator<FusedLocationProviderResult> CREATOR;
   public static final FusedLocationProviderResult zzaOC;
   private final int mVersionCode;
   private final Status zzUX;

   static {
      zzaOC = new FusedLocationProviderResult(Status.zzagC);
      CREATOR = new zze();
   }

   FusedLocationProviderResult(int var1, Status var2) {
      this.mVersionCode = var1;
      this.zzUX = var2;
   }

   public FusedLocationProviderResult(Status var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
