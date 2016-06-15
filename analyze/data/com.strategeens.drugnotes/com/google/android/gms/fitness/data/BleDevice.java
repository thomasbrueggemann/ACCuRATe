package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.class_1050;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_711;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
   public static final Creator<BleDevice> CREATOR = new class_1050();
   // $FF: renamed from: CK int
   private final int field_2577;
   // $FF: renamed from: TW java.lang.String
   private final String field_2578;
   // $FF: renamed from: TX java.util.List
   private final List<String> field_2579;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_2580;
   private final String mName;

   BleDevice(int var1, String var2, String var3, List<String> var4, List<DataType> var5) {
      this.field_2577 = var1;
      this.field_2578 = var2;
      this.mName = var3;
      this.field_2579 = Collections.unmodifiableList(var4);
      this.field_2580 = Collections.unmodifiableList(var5);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.BleDevice) boolean
   private boolean method_3402(BleDevice var1) {
      return this.mName.equals(var1.mName) && this.field_2578.equals(var1.field_2578) && class_711.method_4175(var1.field_2579, this.field_2579) && class_711.method_4175(this.field_2580, var1.field_2580);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof BleDevice && this.method_3402((BleDevice)var1);
   }

   public String getAddress() {
      return this.field_2578;
   }

   public List<DataType> getDataTypes() {
      return this.field_2580;
   }

   public String getName() {
      return this.mName;
   }

   public List<String> getSupportedProfiles() {
      return this.field_2579;
   }

   int getVersionCode() {
      return this.field_2577;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName, this.field_2578, this.field_2579, this.field_2580};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("name", this.mName).method_3424("address", this.field_2578).method_3424("dataTypes", this.field_2580).method_3424("supportedProfiles", this.field_2579).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1050.method_5758(this, var1, var2);
   }
}
