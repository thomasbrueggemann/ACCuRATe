package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzs;

public class ChannelSendFileResponse implements SafeParcelable {
   public static final Creator<ChannelSendFileResponse> CREATOR = new zzs();
   public final int statusCode;
   public final int versionCode;

   ChannelSendFileResponse(int var1, int var2) {
      this.versionCode = var1;
      this.statusCode = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzs.zza(this, var1, var2);
   }
}
