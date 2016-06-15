package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.class_1036;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet implements SafeParcelable {
   public static final Creator<DataSet> CREATOR = new class_1036();
   // $FF: renamed from: CK int
   private final int field_3911;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_3912;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_3913;
   // $FF: renamed from: Uc boolean
   private boolean field_3914;
   // $FF: renamed from: Uj java.util.List
   private final List<DataPoint> field_3915;
   // $FF: renamed from: Uk java.util.List
   private final List<DataSource> field_3916;

   DataSet(int var1, DataSource var2, DataType var3, List<RawDataPoint> var4, List<DataSource> var5, boolean var6) {
      this.field_3914 = false;
      this.field_3911 = var1;
      this.field_3913 = var2;
      this.field_3912 = var3;
      this.field_3914 = var6;
      this.field_3915 = new ArrayList(var4.size());
      if(var1 < 2) {
         var5 = Collections.singletonList(var2);
      }

      this.field_3916 = var5;
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         RawDataPoint var8 = (RawDataPoint)var7.next();
         this.field_3915.add(new DataPoint(this.field_3916, var8));
      }

   }

   private DataSet(DataSource var1, DataType var2) {
      this.field_3914 = false;
      this.field_3911 = 3;
      this.field_3913 = (DataSource)class_335.method_2311(var1);
      this.field_3912 = (DataType)class_335.method_2311(var2);
      this.field_3915 = new ArrayList();
      this.field_3916 = new ArrayList();
      this.field_3916.add(this.field_3913);
   }

   public DataSet(RawDataSet var1, List<DataSource> var2, List<DataType> var3) {
      this(3, (DataSource)method_5132(var2, var1.field_2821), (DataType)method_5132(var3, var1.field_2822), var1.field_2823, var2, var1.field_2824);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSet) boolean
   private boolean method_5131(DataSet var1) {
      return class_336.equal(this.field_3912, var1.field_3912) && class_336.equal(this.field_3913, var1.field_3913) && class_336.equal(this.field_3915, var1.field_3915) && this.field_3914 == var1.field_3914;
   }

   public static DataSet create(DataSource var0) {
      class_335.method_2306(var0, "DataSource should be specified");
      return new DataSet(var0, var0.getDataType());
   }

   // $FF: renamed from: d (java.util.List, int) java.lang.Object
   private static <T> T method_5132(List<T> var0, int var1) {
      return var1 >= 0 && var1 < var0.size()?var0.get(var1):null;
   }

   // $FF: renamed from: a (java.lang.Iterable) void
   public void method_5133(Iterable<DataPoint> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.method_5134((DataPoint)var2.next());
      }

   }

   public void add(DataPoint var1) {
      DataSource var2 = var1.getDataSource();
      boolean var3 = var2.getStreamIdentifier().equals(this.field_3913.getStreamIdentifier());
      Object[] var4 = new Object[]{var2, this.field_3913};
      class_335.method_2309(var3, "Conflicting data sources found %s vs %s", var4);
      boolean var5 = var1.getDataType().getName().equals(this.field_3912.getName());
      Object[] var6 = new Object[]{var1.getDataType(), this.field_3912};
      class_335.method_2309(var5, "Conflicting data types found %s vs %s", var6);
      boolean var7;
      if(var1.getTimestamp(TimeUnit.NANOSECONDS) > 0L) {
         var7 = true;
      } else {
         var7 = false;
      }

      class_335.method_2309(var7, "Data point does not have the timestamp set: %s", new Object[]{var1});
      boolean var8;
      if(var1.getStartTime(TimeUnit.NANOSECONDS) <= var1.getEndTime(TimeUnit.NANOSECONDS)) {
         var8 = true;
      } else {
         var8 = false;
      }

      class_335.method_2309(var8, "Data point with start time greater than end time found: %s", new Object[]{var1});
      this.method_5134(var1);
   }

   public void addAll(Iterable<DataPoint> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.add((DataPoint)var2.next());
      }

   }

   // $FF: renamed from: b (com.google.android.gms.fitness.data.DataPoint) void
   public void method_5134(DataPoint var1) {
      this.field_3915.add(var1);
      DataSource var3 = var1.getOriginalDataSource();
      if(var3 != null && !this.field_3916.contains(var3)) {
         this.field_3916.add(var3);
      }

   }

   public DataPoint createDataPoint() {
      return DataPoint.create(this.field_3913);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataSet && this.method_5131((DataSet)var1);
   }

   // $FF: renamed from: f (java.util.List) java.util.List
   List<RawDataPoint> method_5135(List<DataSource> var1) {
      ArrayList var2 = new ArrayList(this.field_3915.size());
      Iterator var3 = this.field_3915.iterator();

      while(var3.hasNext()) {
         var2.add(new RawDataPoint((DataPoint)var3.next(), var1));
      }

      return var2;
   }

   public List<DataPoint> getDataPoints() {
      return Collections.unmodifiableList(this.field_3915);
   }

   public DataSource getDataSource() {
      return this.field_3913;
   }

   public DataType getDataType() {
      return this.field_3912;
   }

   int getVersionCode() {
      return this.field_3911;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3912, this.field_3913};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jn () boolean
   public boolean method_5136() {
      return this.field_3914;
   }

   // $FF: renamed from: jv () java.util.List
   List<RawDataPoint> method_5137() {
      return this.method_5135(this.field_3916);
   }

   // $FF: renamed from: jw () java.util.List
   List<DataSource> method_5138() {
      return this.field_3916;
   }

   public String toString() {
      Object var1 = this.method_5137();
      Object[] var2 = new Object[]{this.field_3913.toDebugString(), null};
      if(this.field_3915.size() >= 10) {
         Object[] var3 = new Object[]{Integer.valueOf(this.field_3915.size()), ((List)var1).subList(0, 5)};
         var1 = String.format("%d data points, first 5: %s", var3);
      }

      var2[1] = var1;
      return String.format("DataSet{%s %s}", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1036.method_5717(this, var1, var2);
   }
}
