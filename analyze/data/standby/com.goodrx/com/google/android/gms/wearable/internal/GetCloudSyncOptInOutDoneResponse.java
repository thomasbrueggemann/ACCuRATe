package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzal;

public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
   public static final Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new zzal();
   public final int statusCode;
   public final int versionCode;
   public final boolean zzbsD;

   GetCloudSyncOptInOutDoneResponse(int var1, int var2, boolean var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsD = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzal.zza(this, var1, var2);
   }
}
