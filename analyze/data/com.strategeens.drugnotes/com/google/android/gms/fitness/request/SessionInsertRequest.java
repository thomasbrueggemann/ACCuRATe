package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.class_516;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_708;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
   public static final Creator<SessionInsertRequest> CREATOR = new class_516();
   // $FF: renamed from: CK int
   private final int field_4162;
   // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
   private final Session field_4163;
   // $FF: renamed from: Ua java.util.List
   private final List<DataSet> field_4164;
   // $FF: renamed from: Wh java.util.List
   private final List<DataPoint> field_4165;

   SessionInsertRequest(int var1, Session var2, List<DataSet> var3, List<DataPoint> var4) {
      this.field_4162 = var1;
      this.field_4163 = var2;
      this.field_4164 = Collections.unmodifiableList(var3);
      this.field_4165 = Collections.unmodifiableList(var4);
   }

   private SessionInsertRequest(SessionInsertRequest.Builder var1) {
      this.field_4162 = 1;
      this.field_4163 = var1.field_3566;
      this.field_4164 = Collections.unmodifiableList(var1.field_3567);
      this.field_4165 = Collections.unmodifiableList(var1.field_3568);
   }

   // $FF: synthetic method
   SessionInsertRequest(SessionInsertRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionInsertRequest) boolean
   private boolean method_5421(SessionInsertRequest var1) {
      return class_336.equal(this.field_4163, var1.field_4163) && class_336.equal(this.field_4164, var1.field_4164) && class_336.equal(this.field_4165, var1.field_4165);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof SessionInsertRequest && this.method_5421((SessionInsertRequest)var1);
   }

   public List<DataPoint> getAggregateDataPoints() {
      return this.field_4165;
   }

   public List<DataSet> getDataSets() {
      return this.field_4164;
   }

   public Session getSession() {
      return this.field_4163;
   }

   int getVersionCode() {
      return this.field_4162;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4163, this.field_4164, this.field_4165};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("session", this.field_4163).method_3424("dataSets", this.field_4164).method_3424("aggregateDataPoints", this.field_4165).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_516.method_3210(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
      private Session field_3566;
      // $FF: renamed from: Ua java.util.List
      private List<DataSet> field_3567 = new ArrayList();
      // $FF: renamed from: Wh java.util.List
      private List<DataPoint> field_3568 = new ArrayList();
      // $FF: renamed from: Wi java.util.List
      private List<DataSource> field_3569 = new ArrayList();

      // $FF: renamed from: d (com.google.android.gms.fitness.data.DataPoint) void
      private void method_4740(DataPoint var1) {
         this.method_4742(var1);
         this.method_4741(var1);
      }

      // $FF: renamed from: e (com.google.android.gms.fitness.data.DataPoint) void
      private void method_4741(DataPoint var1) {
         long var2 = this.field_3566.getStartTime(TimeUnit.NANOSECONDS);
         long var4 = this.field_3566.getEndTime(TimeUnit.NANOSECONDS);
         long var6 = var1.getStartTime(TimeUnit.NANOSECONDS);
         long var8 = var1.getEndTime(TimeUnit.NANOSECONDS);
         if(var6 != 0L && var8 != 0L) {
            TimeUnit var10 = TimeUnit.MILLISECONDS;
            if(var8 > var4) {
               var8 = class_708.method_4172(var8, TimeUnit.NANOSECONDS, var10);
            }

            boolean var11;
            if(var6 >= var2 && var8 <= var4) {
               var11 = true;
            } else {
               var11 = false;
            }

            Object[] var12 = new Object[]{var1, Long.valueOf(var2), Long.valueOf(var4)};
            class_335.method_2303(var11, "Data point %s has start and end times outside session interval [%d, %d]", var12);
            if(var8 != var1.getEndTime(TimeUnit.NANOSECONDS)) {
               Object[] var13 = new Object[]{Long.valueOf(var1.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(var8), var10};
               Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", var13));
               var1.setTimeInterval(var6, var8, TimeUnit.NANOSECONDS);
            }
         }

      }

      // $FF: renamed from: f (com.google.android.gms.fitness.data.DataPoint) void
      private void method_4742(DataPoint var1) {
         long var2 = this.field_3566.getStartTime(TimeUnit.NANOSECONDS);
         long var4 = this.field_3566.getEndTime(TimeUnit.NANOSECONDS);
         long var6 = var1.getTimestamp(TimeUnit.NANOSECONDS);
         if(var6 != 0L) {
            TimeUnit var8 = TimeUnit.MILLISECONDS;
            if(var6 < var2 || var6 > var4) {
               var6 = class_708.method_4172(var6, TimeUnit.NANOSECONDS, var8);
            }

            boolean var9;
            if(var6 >= var2 && var6 <= var4) {
               var9 = true;
            } else {
               var9 = false;
            }

            Object[] var10 = new Object[]{var1, Long.valueOf(var2), Long.valueOf(var4)};
            class_335.method_2303(var9, "Data point %s has time stamp outside session interval [%d, %d]", var10);
            if(var1.getTimestamp(TimeUnit.NANOSECONDS) != var6) {
               Object[] var11 = new Object[]{Long.valueOf(var1.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(var6), var8};
               Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", var11));
               var1.setTimestamp(var6, TimeUnit.NANOSECONDS);
            }
         }

      }

      // $FF: renamed from: ki () void
      private void method_4743() {
         Iterator var1 = this.field_3567.iterator();

         while(var1.hasNext()) {
            Iterator var3 = ((DataSet)var1.next()).getDataPoints().iterator();

            while(var3.hasNext()) {
               this.method_4740((DataPoint)var3.next());
            }
         }

         Iterator var2 = this.field_3568.iterator();

         while(var2.hasNext()) {
            this.method_4740((DataPoint)var2.next());
         }

      }

      public SessionInsertRequest.Builder addAggregateDataPoint(DataPoint var1) {
         boolean var2;
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_335.method_2308(var2, "Must specify a valid aggregate data point.");
         long var3 = var1.getStartTime(TimeUnit.NANOSECONDS);
         long var5 = var1.getEndTime(TimeUnit.NANOSECONDS);
         boolean var7;
         if(var3 > 0L && var5 > var3) {
            var7 = true;
         } else {
            var7 = false;
         }

         class_335.method_2309(var7, "Aggregate data point should have valid start and end times: %s", new Object[]{var1});
         DataSource var8 = var1.getDataSource();
         boolean var9;
         if(!this.field_3569.contains(var8)) {
            var9 = true;
         } else {
            var9 = false;
         }

         class_335.method_2303(var9, "Data set/Aggregate data point for this data source %s is already added.", new Object[]{var8});
         this.field_3569.add(var8);
         this.field_3568.add(var1);
         return this;
      }

      public SessionInsertRequest.Builder addDataSet(DataSet var1) {
         byte var2 = 1;
         byte var3;
         if(var1 != null) {
            var3 = var2;
         } else {
            var3 = 0;
         }

         class_335.method_2308((boolean)var3, "Must specify a valid data set.");
         DataSource var4 = var1.getDataSource();
         byte var5;
         if(!this.field_3569.contains(var4)) {
            var5 = var2;
         } else {
            var5 = 0;
         }

         Object[] var6 = new Object[var2];
         var6[0] = var4;
         class_335.method_2303((boolean)var5, "Data set for this data source %s is already added.", var6);
         if(var1.getDataPoints().isEmpty()) {
            var2 = 0;
         }

         class_335.method_2308((boolean)var2, "No data points specified in the input data set.");
         this.field_3569.add(var4);
         this.field_3567.add(var1);
         return this;
      }

      public SessionInsertRequest build() {
         boolean var1 = true;
         boolean var2;
         if(this.field_3566 != null) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_335.method_2302(var2, "Must specify a valid session.");
         if(this.field_3566.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
            var1 = false;
         }

         class_335.method_2302(var1, "Must specify a valid end time, cannot insert a continuing session.");
         this.method_4743();
         return new SessionInsertRequest(this);
      }

      public SessionInsertRequest.Builder setSession(Session var1) {
         this.field_3566 = var1;
         return this;
      }
   }
}
