package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzo;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
   public static final Creator<CreateFolderRequest> CREATOR = new zzo();
   final int mVersionCode;
   final MetadataBundle zzaqw;
   final DriveId zzaqy;

   CreateFolderRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.mVersionCode = var1;
      this.zzaqy = (DriveId)zzx.zzz(var2);
      this.zzaqw = (MetadataBundle)zzx.zzz(var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }
}
