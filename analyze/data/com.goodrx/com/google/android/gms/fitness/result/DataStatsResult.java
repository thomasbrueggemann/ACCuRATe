package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.result.DataSourceStatsResult;
import com.google.android.gms.fitness.result.zzf;
import java.util.List;

public class DataStatsResult implements Result, SafeParcelable {
   public static final Creator<DataStatsResult> CREATOR = new zzf();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<DataSourceStatsResult> zzaBL;

   DataStatsResult(int var1, Status var2, List<DataSourceStatsResult> var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaBL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   List<DataSourceStatsResult> zzvn() {
      return this.zzaBL;
   }
}
