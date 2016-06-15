package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_504;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
   public static final Creator<DataReadRequest> CREATOR = new class_504();
   public static final int NO_LIMIT;
   // $FF: renamed from: CK int
   private final int field_3894;
   // $FF: renamed from: LW long
   private final long field_3895;
   // $FF: renamed from: TO long
   private final long field_3896;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_3897;
   // $FF: renamed from: Ub int
   private final int field_3898;
   // $FF: renamed from: VH java.util.List
   private final List<DataSource> field_3899;
   // $FF: renamed from: VL java.util.List
   private final List<DataType> field_3900;
   // $FF: renamed from: VM java.util.List
   private final List<DataSource> field_3901;
   // $FF: renamed from: VN long
   private final long field_3902;
   // $FF: renamed from: VO com.google.android.gms.fitness.data.DataSource
   private final DataSource field_3903;
   // $FF: renamed from: VP int
   private final int field_3904;
   // $FF: renamed from: VQ boolean
   private final boolean field_3905;
   // $FF: renamed from: VR boolean
   private final boolean field_3906;

   DataReadRequest(int var1, List<DataType> var2, List<DataSource> var3, long var4, long var6, List<DataType> var8, List<DataSource> var9, int var10, long var11, DataSource var13, int var14, boolean var15, boolean var16) {
      this.field_3894 = var1;
      this.field_3897 = Collections.unmodifiableList(var2);
      this.field_3899 = Collections.unmodifiableList(var3);
      this.field_3895 = var4;
      this.field_3896 = var6;
      this.field_3900 = Collections.unmodifiableList(var8);
      this.field_3901 = Collections.unmodifiableList(var9);
      this.field_3898 = var10;
      this.field_3902 = var11;
      this.field_3903 = var13;
      this.field_3904 = var14;
      this.field_3905 = var15;
      this.field_3906 = var16;
   }

   private DataReadRequest(DataReadRequest.Builder var1) {
      this.field_3894 = 2;
      this.field_3897 = Collections.unmodifiableList(var1.field_2780);
      this.field_3899 = Collections.unmodifiableList(var1.field_2782);
      this.field_3895 = var1.field_2778;
      this.field_3896 = var1.field_2779;
      this.field_3900 = Collections.unmodifiableList(var1.field_2783);
      this.field_3901 = Collections.unmodifiableList(var1.field_2784);
      this.field_3898 = var1.field_2781;
      this.field_3902 = var1.field_2785;
      this.field_3903 = var1.field_2786;
      this.field_3904 = var1.field_2787;
      this.field_3905 = var1.field_2788;
      this.field_3906 = var1.field_2789;
   }

   // $FF: synthetic method
   DataReadRequest(DataReadRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest) boolean
   private boolean method_5124(DataReadRequest var1) {
      return this.field_3897.equals(var1.field_3897) && this.field_3899.equals(var1.field_3899) && this.field_3895 == var1.field_3895 && this.field_3896 == var1.field_3896 && this.field_3898 == var1.field_3898 && this.field_3901.equals(var1.field_3901) && this.field_3900.equals(var1.field_3900) && class_336.equal(this.field_3903, var1.field_3903) && this.field_3902 == var1.field_3902 && this.field_3906 == var1.field_3906;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataReadRequest && this.method_5124((DataReadRequest)var1);
   }

   public DataSource getActivityDataSource() {
      return this.field_3903;
   }

   public List<DataSource> getAggregatedDataSources() {
      return this.field_3901;
   }

   public List<DataType> getAggregatedDataTypes() {
      return this.field_3900;
   }

   public long getBucketDuration(TimeUnit var1) {
      return var1.convert(this.field_3902, TimeUnit.MILLISECONDS);
   }

   public int getBucketType() {
      return this.field_3898;
   }

   public List<DataSource> getDataSources() {
      return this.field_3899;
   }

   public List<DataType> getDataTypes() {
      return this.field_3897;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.field_3896, TimeUnit.MILLISECONDS);
   }

   public int getLimit() {
      return this.field_3904;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.field_3895, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.field_3894;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3898), Long.valueOf(this.field_3895), Long.valueOf(this.field_3896)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jV () boolean
   public boolean method_5125() {
      return this.field_3906;
   }

   // $FF: renamed from: jW () boolean
   public boolean method_5126() {
      return this.field_3905;
   }

   // $FF: renamed from: jX () long
   public long method_5127() {
      return this.field_3902;
   }

   // $FF: renamed from: jo () long
   public long method_5128() {
      return this.field_3895;
   }

   // $FF: renamed from: jp () long
   public long method_5129() {
      return this.field_3896;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataReadRequest{");
      if(!this.field_3897.isEmpty()) {
         Iterator var17 = this.field_3897.iterator();

         while(var17.hasNext()) {
            var1.append(((DataType)var17.next()).method_5487()).append(" ");
         }
      }

      if(!this.field_3899.isEmpty()) {
         Iterator var15 = this.field_3899.iterator();

         while(var15.hasNext()) {
            var1.append(((DataSource)var15.next()).toDebugString()).append(" ");
         }
      }

      if(this.field_3898 != 0) {
         var1.append("bucket by ").append(Bucket.method_5042(this.field_3898));
         if(this.field_3902 > 0L) {
            var1.append(" >").append(this.field_3902).append("ms");
         }

         var1.append(": ");
      }

      if(!this.field_3900.isEmpty()) {
         Iterator var10 = this.field_3900.iterator();

         while(var10.hasNext()) {
            var1.append(((DataType)var10.next()).method_5487()).append(" ");
         }
      }

      if(!this.field_3901.isEmpty()) {
         Iterator var8 = this.field_3901.iterator();

         while(var8.hasNext()) {
            var1.append(((DataSource)var8.next()).toDebugString()).append(" ");
         }
      }

      Object[] var3 = new Object[]{Long.valueOf(this.field_3895), Long.valueOf(this.field_3895), Long.valueOf(this.field_3896), Long.valueOf(this.field_3896)};
      var1.append(String.format("(%tF %tT - %tF %tT)", var3));
      if(this.field_3903 != null) {
         var1.append("activities: ").append(this.field_3903.toDebugString());
      }

      if(this.field_3906) {
         var1.append(" +server");
      }

      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_504.method_3174(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: LW long
      private long field_2778;
      // $FF: renamed from: TO long
      private long field_2779;
      // $FF: renamed from: TY java.util.List
      private List<DataType> field_2780 = new ArrayList();
      // $FF: renamed from: Ub int
      private int field_2781 = 0;
      // $FF: renamed from: VH java.util.List
      private List<DataSource> field_2782 = new ArrayList();
      // $FF: renamed from: VL java.util.List
      private List<DataType> field_2783 = new ArrayList();
      // $FF: renamed from: VM java.util.List
      private List<DataSource> field_2784 = new ArrayList();
      // $FF: renamed from: VN long
      private long field_2785 = 0L;
      // $FF: renamed from: VO com.google.android.gms.fitness.data.DataSource
      private DataSource field_2786;
      // $FF: renamed from: VP int
      private int field_2787 = 0;
      // $FF: renamed from: VQ boolean
      private boolean field_2788 = false;
      // $FF: renamed from: VR boolean
      private boolean field_2789 = false;

      public DataReadRequest.Builder aggregate(DataSource var1, DataType var2) {
         class_335.method_2306(var1, "Attempting to add a null data source");
         boolean var4;
         if(!this.field_2782.contains(var1)) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2302(var4, "Cannot add the same data source for aggregated and detailed");
         DataType var5 = var1.getDataType();
         class_335.method_2309(DataType.AGGREGATE_INPUT_TYPES.contains(var5), "Unsupported input data type specified for aggregation: %s", new Object[]{var5});
         class_335.method_2309(DataType.getAggregatesForInput(var5).contains(var2), "Invalid output aggregate data type specified: %s -> %s", new Object[]{var5, var2});
         if(!this.field_2784.contains(var1)) {
            this.field_2784.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder aggregate(DataType var1, DataType var2) {
         class_335.method_2306(var1, "Attempting to use a null data type");
         boolean var4;
         if(!this.field_2780.contains(var1)) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2302(var4, "Cannot add the same data type as aggregated and detailed");
         class_335.method_2309(DataType.AGGREGATE_INPUT_TYPES.contains(var1), "Unsupported input data type specified for aggregation: %s", new Object[]{var1});
         class_335.method_2309(DataType.getAggregatesForInput(var1).contains(var2), "Invalid output aggregate data type specified: %s -> %s", new Object[]{var1, var2});
         if(!this.field_2783.contains(var1)) {
            this.field_2783.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder bucketByActivitySegment(int var1, TimeUnit var2) {
         boolean var3;
         if(this.field_2781 == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{Integer.valueOf(this.field_2781)};
         class_335.method_2309(var3, "Bucketing strategy already set to %s", var4);
         boolean var5;
         if(var1 > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         Object[] var6 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
         this.field_2781 = 4;
         this.field_2785 = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByActivitySegment(int var1, TimeUnit var2, DataSource var3) {
         boolean var4;
         if(this.field_2781 == 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         Object[] var5 = new Object[]{Integer.valueOf(this.field_2781)};
         class_335.method_2309(var4, "Bucketing strategy already set to %s", var5);
         boolean var6;
         if(var1 > 0) {
            var6 = true;
         } else {
            var6 = false;
         }

         Object[] var7 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var6, "Must specify a valid minimum duration for an activity segment: %d", var7);
         boolean var8;
         if(var3 != null) {
            var8 = true;
         } else {
            var8 = false;
         }

         class_335.method_2308(var8, "Invalid activity data source specified");
         class_335.method_2309(var3.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[]{var3});
         this.field_2786 = var3;
         this.field_2781 = 4;
         this.field_2785 = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByActivityType(int var1, TimeUnit var2) {
         boolean var3;
         if(this.field_2781 == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{Integer.valueOf(this.field_2781)};
         class_335.method_2309(var3, "Bucketing strategy already set to %s", var4);
         boolean var5;
         if(var1 > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         Object[] var6 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
         this.field_2781 = 3;
         this.field_2785 = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByActivityType(int var1, TimeUnit var2, DataSource var3) {
         boolean var4;
         if(this.field_2781 == 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         Object[] var5 = new Object[]{Integer.valueOf(this.field_2781)};
         class_335.method_2309(var4, "Bucketing strategy already set to %s", var5);
         boolean var6;
         if(var1 > 0) {
            var6 = true;
         } else {
            var6 = false;
         }

         Object[] var7 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var6, "Must specify a valid minimum duration for an activity segment: %d", var7);
         boolean var8;
         if(var3 != null) {
            var8 = true;
         } else {
            var8 = false;
         }

         class_335.method_2308(var8, "Invalid activity data source specified");
         class_335.method_2309(var3.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[]{var3});
         this.field_2786 = var3;
         this.field_2781 = 3;
         this.field_2785 = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketBySession(int var1, TimeUnit var2) {
         boolean var3;
         if(this.field_2781 == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{Integer.valueOf(this.field_2781)};
         class_335.method_2309(var3, "Bucketing strategy already set to %s", var4);
         boolean var5;
         if(var1 > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         Object[] var6 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
         this.field_2781 = 2;
         this.field_2785 = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest.Builder bucketByTime(int var1, TimeUnit var2) {
         boolean var3;
         if(this.field_2781 == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{Integer.valueOf(this.field_2781)};
         class_335.method_2309(var3, "Bucketing strategy already set to %s", var4);
         boolean var5;
         if(var1 > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         Object[] var6 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
         this.field_2781 = 1;
         this.field_2785 = var2.toMillis((long)var1);
         return this;
      }

      public DataReadRequest build() {
         byte var1 = 1;
         byte var2;
         if(this.field_2782.isEmpty() && this.field_2780.isEmpty() && this.field_2784.isEmpty() && this.field_2783.isEmpty()) {
            var2 = 0;
         } else {
            var2 = var1;
         }

         class_335.method_2302((boolean)var2, "Must add at least one data source (aggregated or detailed)");
         byte var3;
         if(this.field_2778 > 0L) {
            var3 = var1;
         } else {
            var3 = 0;
         }

         Object[] var4 = new Object[var1];
         var4[0] = Long.valueOf(this.field_2778);
         class_335.method_2303((boolean)var3, "Invalid start time: %s", var4);
         byte var5;
         if(this.field_2779 > 0L && this.field_2779 > this.field_2778) {
            var5 = var1;
         } else {
            var5 = 0;
         }

         Object[] var6 = new Object[var1];
         var6[0] = Long.valueOf(this.field_2779);
         class_335.method_2303((boolean)var5, "Invalid end time: %s", var6);
         byte var7;
         if(this.field_2784.isEmpty() && this.field_2783.isEmpty()) {
            var7 = var1;
         } else {
            var7 = 0;
         }

         if((var7 == 0 || this.field_2781 != 0) && (var7 != 0 || this.field_2781 == 0)) {
            var1 = 0;
         }

         class_335.method_2302((boolean)var1, "Must specify a valid bucketing strategy while requesting aggregation");
         return new DataReadRequest(this);
      }

      public DataReadRequest.Builder enableServerQueries() {
         this.field_2789 = true;
         return this;
      }

      public DataReadRequest.Builder read(DataSource var1) {
         class_335.method_2306(var1, "Attempting to add a null data source");
         boolean var3;
         if(!this.field_2784.contains(var1)) {
            var3 = true;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "Cannot add the same data source as aggregated and detailed");
         if(!this.field_2782.contains(var1)) {
            this.field_2782.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder read(DataType var1) {
         class_335.method_2306(var1, "Attempting to use a null data type");
         boolean var3;
         if(!this.field_2783.contains(var1)) {
            var3 = true;
         } else {
            var3 = false;
         }

         class_335.method_2302(var3, "Cannot add the same data type as aggregated and detailed");
         if(!this.field_2780.contains(var1)) {
            this.field_2780.add(var1);
         }

         return this;
      }

      public DataReadRequest.Builder setLimit(int var1) {
         boolean var2;
         if(var1 > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         Object[] var3 = new Object[]{Integer.valueOf(var1)};
         class_335.method_2309(var2, "Invalid limit %d is specified", var3);
         this.field_2787 = var1;
         return this;
      }

      public DataReadRequest.Builder setTimeRange(long var1, long var3, TimeUnit var5) {
         this.field_2778 = var5.toMillis(var1);
         this.field_2779 = var5.toMillis(var3);
         return this;
      }
   }
}
