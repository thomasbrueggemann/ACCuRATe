package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.zzb;

public class EndCompoundOperationRequest implements SafeParcelable {
   public static final Creator<EndCompoundOperationRequest> CREATOR = new zzb();
   final int mVersionCode;

   public EndCompoundOperationRequest() {
      this(1);
   }

   EndCompoundOperationRequest(int var1) {
      this.mVersionCode = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
