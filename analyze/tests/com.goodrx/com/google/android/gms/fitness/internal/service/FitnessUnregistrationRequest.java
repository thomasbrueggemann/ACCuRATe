package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.internal.service.zzb;

public class FitnessUnregistrationRequest implements SafeParcelable {
   public static final Creator<FitnessUnregistrationRequest> CREATOR = new zzb();
   private final int mVersionCode;
   private final DataSource zzavU;

   FitnessUnregistrationRequest(int var1, DataSource var2) {
      this.mVersionCode = var1;
      this.zzavU = var2;
   }

   public int describeContents() {
      return 0;
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzavU};
      return String.format("ApplicationUnregistrationRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
