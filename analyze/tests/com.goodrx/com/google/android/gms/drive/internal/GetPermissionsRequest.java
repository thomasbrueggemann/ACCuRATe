package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzak;

public class GetPermissionsRequest implements SafeParcelable {
   public static final Creator<GetPermissionsRequest> CREATOR = new zzak();
   final int mVersionCode;
   final DriveId zzaoz;

   GetPermissionsRequest(int var1, DriveId var2) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzak.zza(this, var1, var2);
   }
}
