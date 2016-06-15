package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.class_1043;
import com.google.android.gms.fitness.data.class_1053;
import com.google.android.gms.internal.class_336;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
   public static final Creator<RawDataPoint> CREATOR = new class_1043();
   // $FF: renamed from: CK int
   final int field_4202;
   // $FF: renamed from: UJ int
   final int field_4203;
   // $FF: renamed from: UK int
   final int field_4204;
   // $FF: renamed from: Ud long
   final long field_4205;
   // $FF: renamed from: Ue long
   final long field_4206;
   // $FF: renamed from: Uf com.google.android.gms.fitness.data.Value[]
   final Value[] field_4207;
   // $FF: renamed from: Uh long
   final long field_4208;
   // $FF: renamed from: Ui long
   final long field_4209;

   RawDataPoint(int var1, long var2, long var4, Value[] var6, int var7, int var8, long var9, long var11) {
      this.field_4202 = var1;
      this.field_4205 = var2;
      this.field_4206 = var4;
      this.field_4203 = var7;
      this.field_4204 = var8;
      this.field_4208 = var9;
      this.field_4209 = var11;
      this.field_4207 = var6;
   }

   RawDataPoint(DataPoint var1, List<DataSource> var2) {
      this.field_4202 = 4;
      this.field_4205 = var1.getTimestamp(TimeUnit.NANOSECONDS);
      this.field_4206 = var1.getStartTime(TimeUnit.NANOSECONDS);
      this.field_4207 = var1.method_4295();
      this.field_4203 = class_1053.method_5779(var1.getDataSource(), var2);
      this.field_4204 = class_1053.method_5779(var1.getOriginalDataSource(), var2);
      this.field_4208 = var1.method_4296();
      this.field_4209 = var1.method_4297();
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataPoint) boolean
   private boolean method_5445(RawDataPoint var1) {
      return this.field_4205 == var1.field_4205 && this.field_4206 == var1.field_4206 && Arrays.equals(this.field_4207, var1.field_4207) && this.field_4203 == var1.field_4203 && this.field_4204 == var1.field_4204 && this.field_4208 == var1.field_4208;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawDataPoint && this.method_5445((RawDataPoint)var1);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_4205), Long.valueOf(this.field_4206)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Arrays.toString(this.field_4207), Long.valueOf(this.field_4206), Long.valueOf(this.field_4205), Integer.valueOf(this.field_4203), Integer.valueOf(this.field_4204)};
      return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1043.method_5738(this, var1, var2);
   }
}
