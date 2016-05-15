package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzbi;

public class SendMessageResponse implements SafeParcelable {
   public static final Creator<SendMessageResponse> CREATOR = new zzbi();
   public final int statusCode;
   public final int versionCode;
   public final int zzaNj;

   SendMessageResponse(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzaNj = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbi.zza(this, var1, var2);
   }
}
