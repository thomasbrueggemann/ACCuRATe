package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzag;

public class DeleteDataItemsResponse implements SafeParcelable {
   public static final Creator<DeleteDataItemsResponse> CREATOR = new zzag();
   public final int statusCode;
   public final int versionCode;
   public final int zzbsz;

   DeleteDataItemsResponse(int var1, int var2, int var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsz = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzag.zza(this, var1, var2);
   }
}
