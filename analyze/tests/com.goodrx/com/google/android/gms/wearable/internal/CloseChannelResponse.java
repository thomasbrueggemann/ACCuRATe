package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzv;

public class CloseChannelResponse implements SafeParcelable {
   public static final Creator<CloseChannelResponse> CREATOR = new zzv();
   public final int statusCode;
   public final int versionCode;

   CloseChannelResponse(int var1, int var2) {
      this.versionCode = var1;
      this.statusCode = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzv.zza(this, var1, var2);
   }
}
