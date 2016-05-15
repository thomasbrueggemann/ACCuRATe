package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.zzah;
import java.util.List;

public class GetAllCapabilitiesResponse implements SafeParcelable {
   public static final Creator<GetAllCapabilitiesResponse> CREATOR = new zzah();
   public final int statusCode;
   public final int versionCode;
   final List<CapabilityInfoParcelable> zzbsA;

   GetAllCapabilitiesResponse(int var1, int var2, List<CapabilityInfoParcelable> var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsA = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzah.zza(this, var1, var2);
   }
}
