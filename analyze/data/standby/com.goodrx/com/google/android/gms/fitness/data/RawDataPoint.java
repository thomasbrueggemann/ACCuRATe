package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.zzo;
import com.google.android.gms.fitness.data.zzt;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawDataPoint implements SafeParcelable {
   public static final Creator<RawDataPoint> CREATOR = new zzo();
   final int mVersionCode;
   public final long zzawj;
   public final long zzawk;
   public final Value[] zzawl;
   public final long zzawn;
   public final long zzawo;
   public final int zzaxg;
   public final int zzaxh;

   public RawDataPoint(int var1, long var2, long var4, Value[] var6, int var7, int var8, long var9, long var11) {
      this.mVersionCode = var1;
      this.zzawj = var2;
      this.zzawk = var4;
      this.zzaxg = var7;
      this.zzaxh = var8;
      this.zzawn = var9;
      this.zzawo = var11;
      this.zzawl = var6;
   }

   RawDataPoint(DataPoint var1, List<DataSource> var2) {
      this.mVersionCode = 4;
      this.zzawj = var1.getTimestamp(TimeUnit.NANOSECONDS);
      this.zzawk = var1.getStartTime(TimeUnit.NANOSECONDS);
      this.zzawl = var1.zzuf();
      this.zzaxg = zzt.zza(var1.getDataSource(), var2);
      this.zzaxh = zzt.zza(var1.getOriginalDataSource(), var2);
      this.zzawn = var1.zzug();
      this.zzawo = var1.zzuh();
   }

   private boolean zza(RawDataPoint var1) {
      return this.zzawj == var1.zzawj && this.zzawk == var1.zzawk && Arrays.equals(this.zzawl, var1.zzawl) && this.zzaxg == var1.zzaxg && this.zzaxh == var1.zzaxh && this.zzawn == var1.zzawn;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawDataPoint && this.zza((RawDataPoint)var1);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzawj), Long.valueOf(this.zzawk)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Arrays.toString(this.zzawl), Long.valueOf(this.zzawk), Long.valueOf(this.zzawj), Integer.valueOf(this.zzaxg), Integer.valueOf(this.zzaxh)};
      return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }
}
