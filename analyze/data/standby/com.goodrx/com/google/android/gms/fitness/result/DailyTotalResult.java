package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.result.zzb;

public class DailyTotalResult implements Result, SafeParcelable {
   public static final Creator<DailyTotalResult> CREATOR = new zzb();
   private final int mVersionCode;
   private final Status zzUX;
   private final DataSet zzaxn;

   DailyTotalResult(int var1, Status var2, DataSet var3) {
      this.mVersionCode = var1;
      this.zzUX = var2;
      this.zzaxn = var3;
   }

   private boolean zzb(DailyTotalResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzaxn, var1.zzaxn);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DailyTotalResult && this.zzb((DailyTotalResult)var1);
   }

   public Status getStatus() {
      return this.zzUX;
   }

   @Nullable
   public DataSet getTotal() {
      return this.zzaxn;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzaxn};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataPoint", this.zzaxn).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
