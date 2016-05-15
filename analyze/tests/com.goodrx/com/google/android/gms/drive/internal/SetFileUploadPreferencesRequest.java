package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.zzbr;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
   public static final Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbr();
   final int mVersionCode;
   final FileUploadPreferencesImpl zzasg;

   SetFileUploadPreferencesRequest(int var1, FileUploadPreferencesImpl var2) {
      this.mVersionCode = var1;
      this.zzasg = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbr.zza(this, var1, var2);
   }
}
