package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemParcelable;
import com.google.android.gms.wearable.internal.zzbf;

public class PutDataResponse implements SafeParcelable {
   public static final Creator<PutDataResponse> CREATOR = new zzbf();
   public final int statusCode;
   public final int versionCode;
   public final DataItemParcelable zzbsJ;

   PutDataResponse(int var1, int var2, DataItemParcelable var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbf.zza(this, var1, var2);
   }
}
