package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzr;

public class DisconnectRequest implements SafeParcelable {
   public static final Creator<DisconnectRequest> CREATOR = new zzr();
   final int mVersionCode;

   public DisconnectRequest() {
      this(1);
   }

   DisconnectRequest(int var1) {
      this.mVersionCode = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
