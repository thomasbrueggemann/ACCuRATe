package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_703;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.class_1037;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_708;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
   public static final Creator<DataPoint> CREATOR = new class_1037();
   // $FF: renamed from: CK int
   private final int field_3388;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_3389;
   // $FF: renamed from: Ud long
   private long field_3390;
   // $FF: renamed from: Ue long
   private long field_3391;
   // $FF: renamed from: Uf com.google.android.gms.fitness.data.Value[]
   private final Value[] field_3392;
   // $FF: renamed from: Ug com.google.android.gms.fitness.data.DataSource
   private DataSource field_3393;
   // $FF: renamed from: Uh long
   private long field_3394;
   // $FF: renamed from: Ui long
   private long field_3395;

   DataPoint(int var1, DataSource var2, long var3, long var5, Value[] var7, DataSource var8, long var9, long var11) {
      this.field_3388 = var1;
      this.field_3389 = var2;
      this.field_3393 = var8;
      this.field_3390 = var3;
      this.field_3391 = var5;
      this.field_3392 = var7;
      this.field_3394 = var9;
      this.field_3395 = var11;
   }

   private DataPoint(DataSource var1) {
      this.field_3388 = 4;
      this.field_3389 = (DataSource)class_335.method_2306(var1, "Data source cannot be null");
      List var2 = var1.getDataType().getFields();
      this.field_3392 = new Value[var2.size()];
      Iterator var3 = var2.iterator();

      for(int var4 = 0; var3.hasNext(); ++var4) {
         Field var5 = (Field)var3.next();
         this.field_3392[var4] = new Value(var5.getFormat());
      }

   }

   DataPoint(List<DataSource> var1, RawDataPoint var2) {
      this(4, method_4292(var1, var2.field_4203), var2.field_4205, var2.field_4206, var2.field_4207, method_4292(var1, var2.field_4204), var2.field_4208, var2.field_4209);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataPoint) boolean
   private boolean method_4291(DataPoint var1) {
      return class_336.equal(this.field_3389, var1.field_3389) && this.field_3390 == var1.field_3390 && this.field_3391 == var1.field_3391 && Arrays.equals(this.field_3392, var1.field_3392) && class_336.equal(this.field_3393, var1.field_3393);
   }

   // $FF: renamed from: c (java.util.List, int) com.google.android.gms.fitness.data.DataSource
   private static DataSource method_4292(List<DataSource> var0, int var1) {
      return var1 >= 0 && var1 < var0.size()?(DataSource)var0.get(var1):null;
   }

   // $FF: renamed from: cL (int) void
   private void method_4293(int var1) {
      List var2 = this.getDataType().getFields();
      int var3 = var2.size();
      boolean var4;
      if(var1 == var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      Object[] var5 = new Object[]{Integer.valueOf(var1), Integer.valueOf(var3), var2};
      class_335.method_2309(var4, "Attempting to insert %s values, but needed %s: %s", var5);
   }

   public static DataPoint create(DataSource var0) {
      return new DataPoint(var0);
   }

   public static DataPoint extract(Intent var0) {
      return var0 == null?null:(DataPoint)class_703.method_4019(var0, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
   }

   // $FF: renamed from: jq () boolean
   private boolean method_4294() {
      return this.getDataType() == DataType.TYPE_LOCATION_SAMPLE;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataPoint && this.method_4291((DataPoint)var1);
   }

   public DataSource getDataSource() {
      return this.field_3389;
   }

   public DataType getDataType() {
      return this.field_3389.getDataType();
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.field_3390, TimeUnit.NANOSECONDS);
   }

   public DataSource getOriginalDataSource() {
      return this.field_3393;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.field_3391, TimeUnit.NANOSECONDS);
   }

   public long getTimestamp(TimeUnit var1) {
      return var1.convert(this.field_3390, TimeUnit.NANOSECONDS);
   }

   public long getTimestampNanos() {
      return this.field_3390;
   }

   public Value getValue(Field var1) {
      int var2 = this.getDataType().indexOf(var1);
      return this.field_3392[var2];
   }

   public int getVersionCode() {
      return this.field_3388;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3389, Long.valueOf(this.field_3390), Long.valueOf(this.field_3391)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jr () com.google.android.gms.fitness.data.Value[]
   public Value[] method_4295() {
      return this.field_3392;
   }

   // $FF: renamed from: js () long
   public long method_4296() {
      return this.field_3394;
   }

   // $FF: renamed from: jt () long
   public long method_4297() {
      return this.field_3395;
   }

   // $FF: renamed from: ju () long
   public long method_4298() {
      return this.field_3391;
   }

   public DataPoint setFloatValues(float... var1) {
      this.method_4293(var1.length);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field_3392[var2].setFloat(var1[var2]);
      }

      return this;
   }

   public DataPoint setIntValues(int... var1) {
      this.method_4293(var1.length);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field_3392[var2].setInt(var1[var2]);
      }

      return this;
   }

   public DataPoint setTimeInterval(long var1, long var3, TimeUnit var5) {
      this.field_3391 = var5.toNanos(var1);
      this.field_3390 = var5.toNanos(var3);
      return this;
   }

   public DataPoint setTimestamp(long var1, TimeUnit var3) {
      this.field_3390 = var3.toNanos(var1);
      if(this.method_4294() && class_708.method_4173(var3)) {
         Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
         this.field_3390 = class_708.method_4172(this.field_3390, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
      }

      return this;
   }

   public String toString() {
      Object[] var1 = new Object[]{Arrays.toString(this.field_3392), Long.valueOf(this.field_3391), Long.valueOf(this.field_3390), Long.valueOf(this.field_3394), Long.valueOf(this.field_3395), this.field_3389, this.field_3393};
      return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1037.method_5720(this, var1, var2);
   }
}
