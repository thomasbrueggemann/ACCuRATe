package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaj;

public class GetChannelInputStreamResponse implements SafeParcelable {
   public static final Creator<GetChannelInputStreamResponse> CREATOR = new zzaj();
   public final int statusCode;
   public final int versionCode;
   public final ParcelFileDescriptor zzbsC;

   GetChannelInputStreamResponse(int var1, int var2, ParcelFileDescriptor var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsC = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaj.zza(this, var1, var2);
   }
}
