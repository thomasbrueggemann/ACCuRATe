package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.zze;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
   public static final Creator<DataSourcesResult> CREATOR = new zze();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<DataSource> zzaAF;

   DataSourcesResult(int var1, List<DataSource> var2, Status var3) {
      this.mVersionCode = var1;
      this.zzaAF = Collections.unmodifiableList(var2);
      this.zzUX = var3;
   }

   private boolean zzb(DataSourcesResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzaAF, var1.zzaAF);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataSourcesResult && this.zzb((DataSourcesResult)var1);
   }

   public List<DataSource> getDataSources() {
      return this.zzaAF;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzaAF};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataSets", this.zzaAF).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
