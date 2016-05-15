package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzbq;

public class RemovePermissionRequest implements SafeParcelable {
   public static final Creator<RemovePermissionRequest> CREATOR = new zzbq();
   final int mVersionCode;
   final String zzaoV;
   final DriveId zzaoz;
   final String zzapk;
   final boolean zzaqd;

   RemovePermissionRequest(int var1, DriveId var2, String var3, boolean var4, String var5) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzapk = var3;
      this.zzaqd = var4;
      this.zzaoV = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbq.zza(this, var1, var2);
   }
}
