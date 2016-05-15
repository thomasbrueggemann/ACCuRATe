package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
public final class RawBucket implements SafeParcelable {
   public static final Creator<RawBucket> CREATOR = new zzn();
   final int mVersionCode;
   public final long zzRD;
   public final long zzavV;
   public final Session zzavX;
   public final List<RawDataSet> zzawg;
   public final int zzawh;
   public final boolean zzawi;
   public final int zzaxf;

   public RawBucket(int var1, long var2, long var4, Session var6, int var7, List<RawDataSet> var8, int var9, boolean var10) {
      this.mVersionCode = var1;
      this.zzRD = var2;
      this.zzavV = var4;
      this.zzavX = var6;
      this.zzaxf = var7;
      this.zzawg = var8;
      this.zzawh = var9;
      this.zzawi = var10;
   }

   public RawBucket(Bucket var1, List<DataSource> var2, List<DataType> var3) {
      this.mVersionCode = 2;
      this.zzRD = var1.getStartTime(TimeUnit.MILLISECONDS);
      this.zzavV = var1.getEndTime(TimeUnit.MILLISECONDS);
      this.zzavX = var1.getSession();
      this.zzaxf = var1.zzub();
      this.zzawh = var1.getBucketType();
      this.zzawi = var1.zzuc();
      List var4 = var1.getDataSets();
      this.zzawg = new ArrayList(var4.size());
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         DataSet var6 = (DataSet)var5.next();
         this.zzawg.add(new RawDataSet(var6, var2, var3));
      }

   }

   private boolean zza(RawBucket var1) {
      return this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && this.zzaxf == var1.zzaxf && zzw.equal(this.zzawg, var1.zzawg) && this.zzawh == var1.zzawh && this.zzawi == var1.zzawi;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawBucket && this.zza((RawBucket)var1);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Integer.valueOf(this.zzawh)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("activity", Integer.valueOf(this.zzaxf)).zzg("dataSets", this.zzawg).zzg("bucketType", Integer.valueOf(this.zzawh)).zzg("serverHasMoreData", Boolean.valueOf(this.zzawi)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
