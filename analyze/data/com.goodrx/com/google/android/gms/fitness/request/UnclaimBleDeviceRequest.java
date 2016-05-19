package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzag;
import com.google.android.gms.internal.zzow;

public class UnclaimBleDeviceRequest implements SafeParcelable {
   public static final Creator<UnclaimBleDeviceRequest> CREATOR = new zzag();
   private final int mVersionCode;
   private final String zzaAB;
   private final zzow zzaAD;

   UnclaimBleDeviceRequest(int var1, String var2, IBinder var3) {
      this.mVersionCode = var1;
      this.zzaAB = var2;
      this.zzaAD = zzow.zza.zzbR(var3);
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
      Object[] var1 = new Object[]{this.zzaAB};
      return String.format("UnclaimBleDeviceRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzag.zza(this, var1, var2);
   }
}
