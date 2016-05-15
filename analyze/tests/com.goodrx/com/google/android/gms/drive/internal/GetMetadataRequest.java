package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzaj;

public class GetMetadataRequest implements SafeParcelable {
   public static final Creator<GetMetadataRequest> CREATOR = new zzaj();
   final int mVersionCode;
   final DriveId zzaqj;
   final boolean zzarN;

   GetMetadataRequest(int var1, DriveId var2, boolean var3) {
      this.mVersionCode = var1;
      this.zzaqj = var2;
      this.zzarN = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaj.zza(this, var1, var2);
   }
}
