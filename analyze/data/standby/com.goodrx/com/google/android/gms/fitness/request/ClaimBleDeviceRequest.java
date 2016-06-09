package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.internal.zzow;

public class ClaimBleDeviceRequest implements SafeParcelable {
   public static final Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
   private final int mVersionCode;
   private final String zzaAB;
   private final BleDevice zzaAC;
   private final zzow zzaAD;

   ClaimBleDeviceRequest(int var1, String var2, BleDevice var3, IBinder var4) {
      this.mVersionCode = var1;
      this.zzaAB = var2;
      this.zzaAC = var3;
      this.zzaAD = zzow.zza.zzbR(var4);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public String getDeviceAddress() {
      return this.zzaAB;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzaAB, this.zzaAC};
      return String.format("ClaimBleDeviceRequest{%s %s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public BleDevice zzuK() {
      return this.zzaAC;
   }
}
