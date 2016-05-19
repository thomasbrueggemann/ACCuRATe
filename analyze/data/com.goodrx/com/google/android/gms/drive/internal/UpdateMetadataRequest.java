package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzca;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
   public static final Creator<UpdateMetadataRequest> CREATOR = new zzca();
   final int mVersionCode;
   final DriveId zzaqj;
   final MetadataBundle zzaqk;

   UpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.mVersionCode = var1;
      this.zzaqj = var2;
      this.zzaqk = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzca.zza(this, var1, var2);
   }
}
