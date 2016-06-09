package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbj;

public class OnSyncMoreResponse implements SafeParcelable {
   public static final Creator<OnSyncMoreResponse> CREATOR = new zzbj();
   final int mVersionCode;
   final boolean zzaqJ;

   OnSyncMoreResponse(int var1, boolean var2) {
      this.mVersionCode = var1;
      this.zzaqJ = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbj.zza(this, var1, var2);
   }
}
