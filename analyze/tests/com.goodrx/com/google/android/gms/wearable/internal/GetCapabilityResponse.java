package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.zzai;

public class GetCapabilityResponse implements SafeParcelable {
   public static final Creator<GetCapabilityResponse> CREATOR = new zzai();
   public final int statusCode;
   public final int versionCode;
   public final CapabilityInfoParcelable zzbsB;

   GetCapabilityResponse(int var1, int var2, CapabilityInfoParcelable var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsB = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzai.zza(this, var1, var2);
   }
}
