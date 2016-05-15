package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.personalized.PlaceUserData;
import com.google.android.gms.location.places.personalized.zzc;

public class PlaceAliasResult implements Result, SafeParcelable {
   public static final Creator<PlaceAliasResult> CREATOR = new zzc();
   final int mVersionCode;
   private final Status zzUX;
   final PlaceUserData zzaRf;

   PlaceAliasResult(int var1, Status var2, PlaceUserData var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaRf = var3;
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   public PlaceUserData zzzC() {
      return this.zzaRf;
   }
}
