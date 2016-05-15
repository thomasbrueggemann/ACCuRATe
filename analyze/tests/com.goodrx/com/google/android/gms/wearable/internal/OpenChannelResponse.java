package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ChannelImpl;
import com.google.android.gms.wearable.internal.zzbd;

public class OpenChannelResponse implements SafeParcelable {
   public static final Creator<OpenChannelResponse> CREATOR = new zzbd();
   public final int statusCode;
   public final int versionCode;
   public final ChannelImpl zzbsc;

   OpenChannelResponse(int var1, int var2, ChannelImpl var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsc = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbd.zza(this, var1, var2);
   }
}
