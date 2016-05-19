package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzr;

public class ChannelReceiveFileResponse implements SafeParcelable {
   public static final Creator<ChannelReceiveFileResponse> CREATOR = new zzr();
   public final int statusCode;
   public final int versionCode;

   ChannelReceiveFileResponse(int var1, int var2) {
      this.versionCode = var1;
      this.statusCode = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
