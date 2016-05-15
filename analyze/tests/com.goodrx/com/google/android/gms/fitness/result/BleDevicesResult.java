package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.result.zza;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
   public static final Creator<BleDevicesResult> CREATOR = new zza();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<BleDevice> zzaBE;

   BleDevicesResult(int var1, List<BleDevice> var2, Status var3) {
      this.mVersionCode = var1;
      this.zzaBE = Collections.unmodifiableList(var2);
      this.zzUX = var3;
   }

   private boolean zzb(BleDevicesResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzaBE, var1.zzaBE);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof BleDevicesResult && this.zzb((BleDevicesResult)var1);
   }

   public List<BleDevice> getClaimedBleDevices() {
      return this.zzaBE;
   }

   public Status getStatus() {
      return this.zzUX;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzaBE};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("bleDevices", this.zzaBE).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
