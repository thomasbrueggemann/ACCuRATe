package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzby;

public class UnsubscribeResourceRequest implements SafeParcelable {
   public static final Creator<UnsubscribeResourceRequest> CREATOR = new zzby();
   final int mVersionCode;
   final DriveId zzaqj;

   UnsubscribeResourceRequest(int var1, DriveId var2) {
      this.mVersionCode = var1;
      this.zzaqj = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzby.zza(this, var1, var2);
   }
}
