package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzbx;

public class TrashResourceRequest implements SafeParcelable {
   public static final Creator<TrashResourceRequest> CREATOR = new zzbx();
   final int mVersionCode;
   final DriveId zzaqj;

   TrashResourceRequest(int var1, DriveId var2) {
      this.mVersionCode = var1;
      this.zzaqj = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbx.zza(this, var1, var2);
   }
}
