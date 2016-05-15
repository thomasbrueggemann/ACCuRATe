package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzp;
import com.google.android.gms.internal.zzox;

public class GetSyncInfoRequest implements SafeParcelable {
   public static final Creator<GetSyncInfoRequest> CREATOR = new zzp();
   private final int mVersionCode;
   private final zzox zzaBb;

   GetSyncInfoRequest(int var1, IBinder var2) {
      this.mVersionCode = var1;
      this.zzaBb = zzox.zza.zzbS(var2);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaBb.asBinder();
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersionCode), this.zzaBb};
      return String.format("GetSyncInfoRequest {%d, %s, %s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }
}
