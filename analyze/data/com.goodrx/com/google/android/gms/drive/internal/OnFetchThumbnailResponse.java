package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbb;

public class OnFetchThumbnailResponse implements SafeParcelable {
   public static final Creator<OnFetchThumbnailResponse> CREATOR = new zzbb();
   final int mVersionCode;
   final ParcelFileDescriptor zzasr;

   OnFetchThumbnailResponse(int var1, ParcelFileDescriptor var2) {
      this.mVersionCode = var1;
      this.zzasr = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbb.zza(this, var1, var2 | 1);
   }
}
