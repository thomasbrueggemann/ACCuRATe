package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.class_1042;
import com.google.android.gms.fitness.data.class_1053;
import com.google.android.gms.internal.class_336;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
   public static final Creator<RawDataSet> CREATOR = new class_1042();
   // $FF: renamed from: CK int
   final int field_2820;
   // $FF: renamed from: UJ int
   final int field_2821;
   // $FF: renamed from: UL int
   final int field_2822;
   // $FF: renamed from: UM java.util.List
   final List<RawDataPoint> field_2823;
   // $FF: renamed from: Uc boolean
   final boolean field_2824;

   RawDataSet(int var1, int var2, int var3, List<RawDataPoint> var4, boolean var5) {
      this.field_2820 = var1;
      this.field_2821 = var2;
      this.field_2822 = var3;
      this.field_2823 = var4;
      this.field_2824 = var5;
   }

   public RawDataSet(DataSet var1, List<DataSource> var2, List<DataType> var3) {
      this.field_2820 = 2;
      this.field_2823 = var1.method_5135(var2);
      this.field_2824 = var1.method_5136();
      this.field_2821 = class_1053.method_5779(var1.getDataSource(), var2);
      this.field_2822 = class_1053.method_5779(var1.getDataType(), var3);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataSet) boolean
   private boolean method_3726(RawDataSet var1) {
      return this.field_2821 == var1.field_2821 && this.field_2822 == var1.field_2822 && this.field_2824 == var1.field_2824 && class_336.equal(this.field_2823, var1.field_2823);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof RawDataSet && this.method_3726((RawDataSet)var1);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_2821), Integer.valueOf(this.field_2822)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_2821), Integer.valueOf(this.field_2822), this.field_2823};
      return String.format("RawDataSet{%s@[%s, %s]}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1042.method_5735(this, var1, var2);
   }
}
