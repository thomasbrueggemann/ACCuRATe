package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzad;

public class DriveServiceResponse implements SafeParcelable {
   public static final Creator<DriveServiceResponse> CREATOR = new zzad();
   final int mVersionCode;
   final IBinder zzarB;

   DriveServiceResponse(int var1, IBinder var2) {
      this.mVersionCode = var1;
      this.zzarB = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzad.zza(this, var1, var2);
   }
}
