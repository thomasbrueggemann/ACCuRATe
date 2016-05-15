package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzo;
import com.google.android.gms.internal.zzow;

public class DisableFitRequest implements SafeParcelable {
   public static final Creator<DisableFitRequest> CREATOR = new zzo();
   private final int mVersionCode;
   private final zzow zzaAD;

   DisableFitRequest(int var1, IBinder var2) {
      this.mVersionCode = var1;
      this.zzaAD = zzow.zza.zzbR(var2);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD.asBinder();
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      return String.format("DisableFitRequest", new Object[0]);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }
}
