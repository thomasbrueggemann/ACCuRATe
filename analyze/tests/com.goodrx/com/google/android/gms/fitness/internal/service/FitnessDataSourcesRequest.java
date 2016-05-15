package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.zza;
import java.util.Collections;
import java.util.List;

public class FitnessDataSourcesRequest implements SafeParcelable {
   public static final Creator<FitnessDataSourcesRequest> CREATOR = new zza();
   private final int mVersionCode;
   private final List<DataType> zzawe;

   FitnessDataSourcesRequest(int var1, List<DataType> var2) {
      this.mVersionCode = var1;
      this.zzawe = var2;
   }

   public int describeContents() {
      return 0;
   }

   public List<DataType> getDataTypes() {
      return Collections.unmodifiableList(this.zzawe);
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      return zzw.zzy(this).zzg("dataTypes", this.zzawe).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
