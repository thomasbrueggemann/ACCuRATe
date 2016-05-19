package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.zzn;

public class PartialDriveId implements SafeParcelable {
   public static final Creator<PartialDriveId> CREATOR = new zzn();
   final int mVersionCode;
   final String zzaoL;
   final long zzaoM;
   final int zzaoN;

   PartialDriveId(int var1, String var2, long var3, int var5) {
      this.mVersionCode = var1;
      this.zzaoL = var2;
      this.zzaoM = var3;
      this.zzaoN = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
