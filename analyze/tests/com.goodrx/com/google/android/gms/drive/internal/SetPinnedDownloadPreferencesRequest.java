package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ParcelableTransferPreferences;
import com.google.android.gms.drive.internal.zzbs;

public class SetPinnedDownloadPreferencesRequest implements SafeParcelable {
   public static final Creator<SetPinnedDownloadPreferencesRequest> CREATOR = new zzbs();
   final int mVersionCode;
   final ParcelableTransferPreferences zzasu;

   SetPinnedDownloadPreferencesRequest(int var1, ParcelableTransferPreferences var2) {
      this.mVersionCode = var1;
      this.zzasu = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbs.zza(this, var1, var2);
   }
}
