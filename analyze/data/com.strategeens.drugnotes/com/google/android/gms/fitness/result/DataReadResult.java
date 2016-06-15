package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.class_926;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
   public static final Creator<DataReadResult> CREATOR = new class_926();
   // $FF: renamed from: CK int
   private final int field_3084;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_3085;
   // $FF: renamed from: Ua java.util.List
   private final List<DataSet> field_3086;
   // $FF: renamed from: Uk java.util.List
   private final List<DataSource> field_3087;
   // $FF: renamed from: Wr java.util.List
   private final List<Bucket> field_3088;
   // $FF: renamed from: Ws int
   private int field_3089;
   // $FF: renamed from: Wt java.util.List
   private final List<DataType> field_3090;

   DataReadResult(int var1, List<RawDataSet> var2, Status var3, List<RawBucket> var4, int var5, List<DataSource> var6, List<DataType> var7) {
      this.field_3084 = var1;
      this.field_3085 = var3;
      this.field_3089 = var5;
      this.field_3087 = var6;
      this.field_3090 = var7;
      this.field_3086 = new ArrayList(var2.size());
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         RawDataSet var12 = (RawDataSet)var8.next();
         this.field_3086.add(new DataSet(var12, var6, var7));
      }

      this.field_3088 = new ArrayList(var4.size());
      Iterator var9 = var4.iterator();

      while(var9.hasNext()) {
         RawBucket var10 = (RawBucket)var9.next();
         this.field_3088.add(new Bucket(var10, var6, var7));
      }

   }

   public DataReadResult(List<DataSet> var1, List<Bucket> var2, Status var3) {
      this.field_3084 = 5;
      this.field_3086 = var1;
      this.field_3085 = var3;
      this.field_3088 = var2;
      this.field_3089 = 1;
      this.field_3087 = new ArrayList();
      this.field_3090 = new ArrayList();
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, com.google.android.gms.fitness.request.DataReadRequest) com.google.android.gms.fitness.result.DataReadResult
   public static DataReadResult method_3977(Status var0, DataReadRequest var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.getDataSources().iterator();

      while(var3.hasNext()) {
         var2.add(DataSet.create((DataSource)var3.next()));
      }

      Iterator var4 = var1.getDataTypes().iterator();

      while(var4.hasNext()) {
         DataType var5 = (DataType)var4.next();
         var2.add(DataSet.create((new DataSource.Builder()).setDataType(var5).setType(1).setName("Default").build()));
      }

      return new DataReadResult(var2, Collections.emptyList(), var0);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Bucket, java.util.List) void
   private void method_3978(Bucket var1, List<Bucket> var2) {
      Iterator var3 = var2.iterator();

      while(true) {
         if(var3.hasNext()) {
            Bucket var5 = (Bucket)var3.next();
            if(!var5.method_5043(var1)) {
               continue;
            }

            Iterator var6 = var1.getDataSets().iterator();

            while(var6.hasNext()) {
               this.method_3979((DataSet)var6.next(), var5.getDataSets());
            }

            return;
         }

         this.field_3088.add(var1);
         return;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSet, java.util.List) void
   private void method_3979(DataSet var1, List<DataSet> var2) {
      Iterator var3 = var2.iterator();

      DataSet var5;
      do {
         if(!var3.hasNext()) {
            var2.add(var1);
            return;
         }

         var5 = (DataSet)var3.next();
      } while(!var5.getDataSource().equals(var1.getDataSource()));

      var5.method_5133(var1.getDataPoints());
   }

   // $FF: renamed from: c (com.google.android.gms.fitness.result.DataReadResult) boolean
   private boolean method_3980(DataReadResult var1) {
      return this.field_3085.equals(var1.field_3085) && class_336.equal(this.field_3086, var1.field_3086) && class_336.equal(this.field_3088, var1.field_3088);
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.DataReadResult) void
   public void method_3981(DataReadResult var1) {
      Iterator var2 = var1.getDataSets().iterator();

      while(var2.hasNext()) {
         this.method_3979((DataSet)var2.next(), this.field_3086);
      }

      Iterator var3 = var1.getBuckets().iterator();

      while(var3.hasNext()) {
         this.method_3978((Bucket)var3.next(), this.field_3088);
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataReadResult && this.method_3980((DataReadResult)var1);
   }

   public List<Bucket> getBuckets() {
      return this.field_3088;
   }

   public DataSet getDataSet(DataSource var1) {
      Iterator var2 = this.field_3086.iterator();

      DataSet var4;
      do {
         if(!var2.hasNext()) {
            Object[] var3 = new Object[]{var1.getStreamIdentifier()};
            throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", var3));
         }

         var4 = (DataSet)var2.next();
      } while(!var1.equals(var4.getDataSource()));

      return var4;
   }

   public DataSet getDataSet(DataType var1) {
      Iterator var2 = this.field_3086.iterator();

      DataSet var4;
      do {
         if(!var2.hasNext()) {
            Object[] var3 = new Object[]{var1.getName()};
            throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", var3));
         }

         var4 = (DataSet)var2.next();
      } while(!var1.equals(var4.getDataType()));

      return var4;
   }

   public List<DataSet> getDataSets() {
      return this.field_3086;
   }

   public Status getStatus() {
      return this.field_3085;
   }

   int getVersionCode() {
      return this.field_3084;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3085, this.field_3086, this.field_3088};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jw () java.util.List
   List<DataSource> method_3982() {
      return this.field_3087;
   }

   // $FF: renamed from: kr () int
   public int method_3983() {
      return this.field_3089;
   }

   // $FF: renamed from: ks () java.util.List
   List<RawBucket> method_3984() {
      ArrayList var1 = new ArrayList(this.field_3088.size());
      Iterator var2 = this.field_3088.iterator();

      while(var2.hasNext()) {
         var1.add(new RawBucket((Bucket)var2.next(), this.field_3087, this.field_3090));
      }

      return var1;
   }

   // $FF: renamed from: kt () java.util.List
   List<RawDataSet> method_3985() {
      ArrayList var1 = new ArrayList(this.field_3086.size());
      Iterator var2 = this.field_3086.iterator();

      while(var2.hasNext()) {
         var1.add(new RawDataSet((DataSet)var2.next(), this.field_3087, this.field_3090));
      }

      return var1;
   }

   // $FF: renamed from: ku () java.util.List
   List<DataType> method_3986() {
      return this.field_3090;
   }

   public String toString() {
      class_336.class_1339 var1 = class_336.method_2312(this).method_3424("status", this.field_3085);
      Object var2;
      if(this.field_3086.size() > 5) {
         var2 = this.field_3086.size() + " data sets";
      } else {
         var2 = this.field_3086;
      }

      class_336.class_1339 var3 = var1.method_3424("dataSets", var2);
      Object var4;
      if(this.field_3088.size() > 5) {
         var4 = this.field_3088.size() + " buckets";
      } else {
         var4 = this.field_3088;
      }

      return var3.method_3424("buckets", var4).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_926.method_5143(this, var1, var2);
   }
}
