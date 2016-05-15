package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.internal.zzap;

public class GetConfigsResponse implements SafeParcelable {
   public static final Creator<GetConfigsResponse> CREATOR = new zzap();
   public final int statusCode;
   public final int versionCode;
   public final ConnectionConfiguration[] zzbsH;

   GetConfigsResponse(int var1, int var2, ConnectionConfiguration[] var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsH = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzap.zza(this, var1, var2);
   }
}
