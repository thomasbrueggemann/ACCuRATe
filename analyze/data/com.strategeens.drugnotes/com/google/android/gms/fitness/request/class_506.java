package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.request.class_507;

// $FF: renamed from: com.google.android.gms.fitness.request.b
public class class_506 implements SafeParcelable {
   public static final Creator<b> CREATOR = new class_507();
   // $FF: renamed from: CK int
   private final int field_1909;
   // $FF: renamed from: VF java.lang.String
   private final String field_1910;
   // $FF: renamed from: VG com.google.android.gms.fitness.data.BleDevice
   private final BleDevice field_1911;

   class_506(int var1, String var2, BleDevice var3) {
      this.field_1909 = var1;
      this.field_1910 = var2;
      this.field_1911 = var3;
   }

   public class_506(BleDevice var1) {
      this(2, var1.getAddress(), var1);
   }

   public class_506(String var1) {
      this(2, var1, (BleDevice)null);
   }

   public int describeContents() {
      return 0;
   }

   public String getDeviceAddress() {
      return this.field_1910;
   }

   int getVersionCode() {
      return this.field_1909;
   }

   // $FF: renamed from: jQ () com.google.android.gms.fitness.data.BleDevice
   public BleDevice method_3180() {
      return this.field_1911;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1910, this.field_1911};
      return String.format("ClaimBleDeviceRequest{%s %s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_507.method_3181(this, var1, var2);
   }
}
