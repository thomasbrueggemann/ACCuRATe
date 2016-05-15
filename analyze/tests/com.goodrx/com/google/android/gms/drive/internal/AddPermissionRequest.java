package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;
import com.google.android.gms.drive.internal.zzb;

public class AddPermissionRequest implements SafeParcelable {
   public static final Creator<AddPermissionRequest> CREATOR = new zzb();
   final int mVersionCode;
   final String zzaoV;
   final DriveId zzaoz;
   final Permission zzaqa;
   final boolean zzaqb;
   final String zzaqc;
   final boolean zzaqd;

   AddPermissionRequest(int var1, DriveId var2, Permission var3, boolean var4, String var5, boolean var6, String var7) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzaqa = var3;
      this.zzaqb = var4;
      this.zzaqc = var5;
      this.zzaqd = var6;
      this.zzaoV = var7;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
