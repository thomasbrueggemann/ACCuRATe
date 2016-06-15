package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.class_927;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
   public static final Creator<BleDevicesResult> CREATOR = new class_927();
   // $FF: renamed from: CK int
   private final int field_2726;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_2727;
   // $FF: renamed from: Wq java.util.List
   private final List<BleDevice> field_2728;

   BleDevicesResult(int var1, List<BleDevice> var2, Status var3) {
      this.field_2726 = var1;
      this.field_2728 = Collections.unmodifiableList(var2);
      this.field_2727 = var3;
   }

   public BleDevicesResult(List<BleDevice> var1, Status var2) {
      this.field_2726 = 3;
      this.field_2728 = Collections.unmodifiableList(var1);
      this.field_2727 = var2;
   }

   // $FF: renamed from: C (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.BleDevicesResult
   public static BleDevicesResult method_3530(Status var0) {
      return new BleDevicesResult(Collections.emptyList(), var0);
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.BleDevicesResult) boolean
   private boolean method_3531(BleDevicesResult var1) {
      return this.field_2727.equals(var1.field_2727) && class_336.equal(this.field_2728, var1.field_2728);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof BleDevicesResult && this.method_3531((BleDevicesResult)var1);
   }

   public List<BleDevice> getClaimedBleDevices() {
      return this.field_2728;
   }

   public List<BleDevice> getClaimedBleDevices(DataType var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_2728.iterator();

      while(var3.hasNext()) {
         BleDevice var4 = (BleDevice)var3.next();
         if(var4.getDataTypes().contains(var1)) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableList(var2);
   }

   public Status getStatus() {
      return this.field_2727;
   }

   int getVersionCode() {
      return this.field_2726;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_2727, this.field_2728};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("status", this.field_2727).method_3424("bleDevices", this.field_2728).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_927.method_5146(this, var1, var2);
   }
}
