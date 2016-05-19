package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzcb;

public class UpdatePermissionRequest implements SafeParcelable {
   public static final Creator<UpdatePermissionRequest> CREATOR = new zzcb();
   final int mVersionCode;
   final String zzaoV;
   final DriveId zzaoz;
   final String zzapk;
   final boolean zzaqd;
   final int zzasE;

   UpdatePermissionRequest(int var1, DriveId var2, String var3, int var4, boolean var5, String var6) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzapk = var3;
      this.zzasE = var4;
      this.zzaqd = var5;
      this.zzaoV = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzcb.zza(this, var1, var2);
   }
}
