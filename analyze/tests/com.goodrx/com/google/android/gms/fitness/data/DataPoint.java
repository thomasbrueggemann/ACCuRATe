package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.zzd;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
   public static final Creator<DataPoint> CREATOR = new zzd();
   private final int mVersionCode;
   private final DataSource zzavU;
   private long zzawj;
   private long zzawk;
   private final Value[] zzawl;
   private DataSource zzawm;
   private long zzawn;
   private long zzawo;

   DataPoint(int var1, DataSource var2, long var3, long var5, Value[] var7, DataSource var8, long var9, long var11) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzawm = var8;
      this.zzawj = var3;
      this.zzawk = var5;
      this.zzawl = var7;
      this.zzawn = var9;
      this.zzawo = var11;
   }

   public DataPoint(DataSource var1, DataSource var2, RawDataPoint var3) {
      this(4, var1, zza(Long.valueOf(var3.zzawj), 0L), zza(Long.valueOf(var3.zzawk), 0L), var3.zzawl, var2, zza(Long.valueOf(var3.zzawn), 0L), zza(Long.valueOf(var3.zzawo), 0L));
   }

   DataPoint(List<DataSource> var1, RawDataPoint var2) {
      this(zza(var1, var2.zzaxg), zza(var1, var2.zzaxh), var2);
   }

   private static long zza(Long var0, long var1) {
      if(var0 != null) {
         var1 = var0.longValue();
      }

      return var1;
   }

   private static DataSource zza(List<DataSource> var0, int var1) {
      return var1 >= 0 && var1 < var0.size()?(DataSource)var0.get(var1):null;
   }

   private boolean zza(DataPoint var1) {
      return zzw.equal(this.zzavU, var1.zzavU) && this.zzawj == var1.zzawj && this.zzawk == var1.zzawk && Arrays.equals(this.zzawl, var1.zzawl) && zzw.equal(this.getOriginalDataSource(), var1.getOriginalDataSource());
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataPoint && this.zza((DataPoint)var1);
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   public DataSource getOriginalDataSource() {
      return this.zzawm != null?this.zzawm:this.zzavU;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.zzawk, TimeUnit.NANOSECONDS);
   }

   public long getTimestamp(TimeUnit var1) {
      return var1.convert(this.zzawj, TimeUnit.NANOSECONDS);
   }

   public long getTimestampNanos() {
      return this.zzawj;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU, Long.valueOf(this.zzawj), Long.valueOf(this.zzawk)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Arrays.toString(this.zzawl), Long.valueOf(this.zzawk), Long.valueOf(this.zzawj), Long.valueOf(this.zzawn), Long.valueOf(this.zzawo), this.zzavU.toDebugString(), null};
      String var2;
      if(this.zzawm != null) {
         var2 = this.zzawm.toDebugString();
      } else {
         var2 = "N/A";
      }

      var1[6] = var2;
      return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }

   public Value[] zzuf() {
      return this.zzawl;
   }

   public long zzug() {
      return this.zzawn;
   }

   public long zzuh() {
      return this.zzawo;
   }

   public long zzuj() {
      return this.zzawk;
   }
}
