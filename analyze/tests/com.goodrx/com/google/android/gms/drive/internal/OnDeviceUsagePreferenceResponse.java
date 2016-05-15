package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.zzax;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
   public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzax();
   final int mVersionCode;
   final FileUploadPreferencesImpl zzasg;

   OnDeviceUsagePreferenceResponse(int var1, FileUploadPreferencesImpl var2) {
      this.mVersionCode = var1;
      this.zzasg = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzax.zza(this, var1, var2);
   }
}
