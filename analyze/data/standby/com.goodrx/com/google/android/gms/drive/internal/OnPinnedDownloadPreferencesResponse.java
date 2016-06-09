package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ParcelableTransferPreferences;
import com.google.android.gms.drive.internal.zzbf;

public class OnPinnedDownloadPreferencesResponse implements SafeParcelable {
   public static final Creator<OnPinnedDownloadPreferencesResponse> CREATOR = new zzbf();
   final int mVersionCode;
   final ParcelableTransferPreferences zzasu;

   OnPinnedDownloadPreferencesResponse(int var1, ParcelableTransferPreferences var2) {
      this.mVersionCode = var1;
      this.zzasu = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbf.zza(this, var1, var2);
   }
}
