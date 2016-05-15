package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzc;

public class AuthorizeAccessRequest implements SafeParcelable {
   public static final Creator<AuthorizeAccessRequest> CREATOR = new zzc();
   final int mVersionCode;
   final DriveId zzaoz;
   final long zzaqe;

   AuthorizeAccessRequest(int var1, long var2, DriveId var4) {
      this.mVersionCode = var1;
      this.zzaqe = var2;
      this.zzaoz = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
