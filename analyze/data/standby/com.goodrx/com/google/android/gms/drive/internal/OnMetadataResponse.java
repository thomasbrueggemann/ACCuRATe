package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbe;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
   public static final Creator<OnMetadataResponse> CREATOR = new zzbe();
   final int mVersionCode;
   final MetadataBundle zzaqw;

   OnMetadataResponse(int var1, MetadataBundle var2) {
      this.mVersionCode = var1;
      this.zzaqw = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbe.zza(this, var1, var2);
   }
}
