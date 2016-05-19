package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzf;
import java.util.List;

public class ChangeResourceParentsRequest implements SafeParcelable {
   public static final Creator<ChangeResourceParentsRequest> CREATOR = new zzf();
   final int mVersionCode;
   final DriveId zzaqf;
   final List<DriveId> zzaqg;
   final List<DriveId> zzaqh;

   ChangeResourceParentsRequest(int var1, DriveId var2, List<DriveId> var3, List<DriveId> var4) {
      this.mVersionCode = var1;
      this.zzaqf = var2;
      this.zzaqg = var3;
      this.zzaqh = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }
}
