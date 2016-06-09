package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzae;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.internal.zzow;

public class StopBleScanRequest implements SafeParcelable {
   public static final Creator<StopBleScanRequest> CREATOR = new zzae();
   private final int mVersionCode;
   private final zzow zzaAD;
   private final zzq zzaBA;

   StopBleScanRequest(int var1, IBinder var2, IBinder var3) {
      this.mVersionCode = var1;
      this.zzaBA = zzq.zza.zzbU(var2);
      this.zzaAD = zzow.zza.zzbR(var3);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzae.zza(this, var1, var2);
   }

   public IBinder zzvg() {
      return this.zzaBA.asBinder();
   }
}
