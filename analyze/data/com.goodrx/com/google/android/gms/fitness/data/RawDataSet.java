package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.zzp;
import com.google.android.gms.fitness.data.zzt;
import java.util.List;

@KeepName
public final class RawDataSet implements SafeParcelable {
   public static final Creator<RawDataSet> CREATOR = new zzp();
   final int mVersionCode;
   public final boolean zzawi;
   public final int zzaxg;
   public final int zzaxi;
   public final List<RawDataPoint> zzaxj;

   public RawDataSet(int var1, int var2, int var3, List<RawDataPoint> var4, boolean var5) {
      this.mVersionCode = var1;
      this.zzaxg = var2;
      this.zzaxi = var3;
      this.zzaxj = var4;
      this.zzawi = var5;
   }

   public RawDataSet(DataSet var1, List<DataSource> var2, List<DataType> var3) {
      this.mVersionCode = 3;
      this.zzaxj = var1.zzv(var2);
      this.zzawi = var1.zzuc();
      this.zzaxg = zzt.zza(var1.getDataSource(), var2);
      this.zzaxi = zzt.zza(var1.getDataType(), var3);
   }

   private boolean zza(RawDataSet var1) {
      return this.zzaxg == var1.zzaxg && this.zzawi == var1.zzawi && zzw.equal(this.zzaxj, var1.zzaxj);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawDataSet && this.zza((RawDataSet)var1);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaxg)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaxg), this.zzaxj};
      return String.format("RawDataSet{%s@[%s]}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }
}
