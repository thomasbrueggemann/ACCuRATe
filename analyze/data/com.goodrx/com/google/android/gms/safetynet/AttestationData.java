package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.safetynet.zza;

public class AttestationData implements SafeParcelable {
   public static final Creator<AttestationData> CREATOR = new zza();
   public final int mVersionCode;
   private String zzbgu;

   AttestationData(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzbgu = var2;
   }

   public int describeContents() {
      return 0;
   }

   public String getJwsResult() {
      return this.zzbgu;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
