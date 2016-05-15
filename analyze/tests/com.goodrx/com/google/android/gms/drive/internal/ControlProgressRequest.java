package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ParcelableTransferPreferences;
import com.google.android.gms.drive.internal.zzj;

public class ControlProgressRequest implements SafeParcelable {
   public static final Creator<ControlProgressRequest> CREATOR = new zzj();
   final int mVersionCode;
   final DriveId zzaoz;
   final int zzaqq;
   final int zzaqr;
   final ParcelableTransferPreferences zzaqs;

   ControlProgressRequest(int var1, int var2, int var3, DriveId var4, ParcelableTransferPreferences var5) {
      this.mVersionCode = var1;
      this.zzaqq = var2;
      this.zzaqr = var3;
      this.zzaoz = var4;
      this.zzaqs = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
