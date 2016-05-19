package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzan;

public class GetCloudSyncSettingResponse implements SafeParcelable {
   public static final Creator<GetCloudSyncSettingResponse> CREATOR = new zzan();
   public final boolean enabled;
   public final int statusCode;
   public final int versionCode;

   GetCloudSyncSettingResponse(int var1, int var2, boolean var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.enabled = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzan.zza(this, var1, var2);
   }
}
