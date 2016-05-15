package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.internal.zzao;

@Deprecated
public class GetConfigResponse implements SafeParcelable {
   public static final Creator<GetConfigResponse> CREATOR = new zzao();
   public final int statusCode;
   public final int versionCode;
   public final ConnectionConfiguration zzbsG;

   GetConfigResponse(int var1, int var2, ConnectionConfiguration var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsG = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzao.zza(this, var1, var2);
   }
}
