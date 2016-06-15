package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.class_928;
import com.google.android.gms.internal.class_336;

public class DataTypeResult implements Result, SafeParcelable {
   public static final Creator<DataTypeResult> CREATOR = new class_928();
   // $FF: renamed from: CK int
   private final int field_4135;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_4136;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_4137;

   DataTypeResult(int var1, Status var2, DataType var3) {
      this.field_4135 = var1;
      this.field_4136 = var2;
      this.field_4137 = var3;
   }

   public DataTypeResult(Status var1, DataType var2) {
      this.field_4135 = 2;
      this.field_4136 = var1;
      this.field_4137 = var2;
   }

   // $FF: renamed from: E (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataTypeResult
   public static DataTypeResult method_5391(Status var0) {
      return new DataTypeResult(var0, (DataType)null);
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.DataTypeResult) boolean
   private boolean method_5392(DataTypeResult var1) {
      return this.field_4136.equals(var1.field_4136) && class_336.equal(this.field_4137, var1.field_4137);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataTypeResult && this.method_5392((DataTypeResult)var1);
   }

   public DataType getDataType() {
      return this.field_4137;
   }

   public Status getStatus() {
      return this.field_4136;
   }

   int getVersionCode() {
      return this.field_4135;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4136, this.field_4137};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("status", this.field_4136).method_3424("dataType", this.field_4137).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_928.method_5149(this, var1, var2);
   }
}
