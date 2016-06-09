package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzc;

public class DriveFileRange implements SafeParcelable {
   public static final Creator<DriveFileRange> CREATOR = new zzc();
   final int mVersionCode;
   final long zzaoJ;
   final long zzaoK;

   DriveFileRange(int var1, long var2, long var4) {
      this.mVersionCode = var1;
      this.zzaoJ = var2;
      this.zzaoK = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
