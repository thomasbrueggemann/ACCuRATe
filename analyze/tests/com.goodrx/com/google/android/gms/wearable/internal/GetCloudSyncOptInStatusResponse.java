package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzam;

public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
   public static final Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzam();
   public final int statusCode;
   public final int versionCode;
   public final boolean zzbsE;
   public final boolean zzbsF;

   GetCloudSyncOptInStatusResponse(int var1, int var2, boolean var3, boolean var4) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsE = var3;
      this.zzbsF = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzam.zza(this, var1, var2);
   }
}
