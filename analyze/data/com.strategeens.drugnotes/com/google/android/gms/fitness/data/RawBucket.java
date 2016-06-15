package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1044;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
   public static final Creator<RawBucket> CREATOR = new class_1044();
   // $FF: renamed from: CK int
   final int field_752;
   // $FF: renamed from: LW long
   final long field_753;
   // $FF: renamed from: TO long
   final long field_754;
   // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
   final Session field_755;
   // $FF: renamed from: UI int
   final int field_756;
   // $FF: renamed from: Ua java.util.List
   final List<RawDataSet> field_757;
   // $FF: renamed from: Ub int
   final int field_758;
   // $FF: renamed from: Uc boolean
   final boolean field_759;

   RawBucket(int var1, long var2, long var4, Session var6, int var7, List<RawDataSet> var8, int var9, boolean var10) {
      this.field_752 = var1;
      this.field_753 = var2;
      this.field_754 = var4;
      this.field_755 = var6;
      this.field_756 = var7;
      this.field_757 = var8;
      this.field_758 = var9;
      this.field_759 = var10;
   }

   public RawBucket(Bucket var1, List<DataSource> var2, List<DataType> var3) {
      this.field_752 = 2;
      this.field_753 = var1.getStartTime(TimeUnit.MILLISECONDS);
      this.field_754 = var1.getEndTime(TimeUnit.MILLISECONDS);
      this.field_755 = var1.getSession();
      this.field_756 = var1.method_5044();
      this.field_758 = var1.getBucketType();
      this.field_759 = var1.method_5045();
      List var4 = var1.getDataSets();
      this.field_757 = new ArrayList(var4.size());
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         DataSet var6 = (DataSet)var5.next();
         this.field_757.add(new RawDataSet(var6, var2, var3));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.RawBucket) boolean
   private boolean method_2206(RawBucket var1) {
      return this.field_753 == var1.field_753 && this.field_754 == var1.field_754 && this.field_756 == var1.field_756 && class_336.equal(this.field_757, var1.field_757) && this.field_758 == var1.field_758 && this.field_759 == var1.field_759;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawBucket && this.method_2206((RawBucket)var1);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_753), Long.valueOf(this.field_754), Integer.valueOf(this.field_758)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("startTime", Long.valueOf(this.field_753)).method_3424("endTime", Long.valueOf(this.field_754)).method_3424("activity", Integer.valueOf(this.field_756)).method_3424("dataSets", this.field_757).method_3424("bucketType", Integer.valueOf(this.field_758)).method_3424("serverHasMoreData", Boolean.valueOf(this.field_759)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1044.method_5741(this, var1, var2);
   }
}
