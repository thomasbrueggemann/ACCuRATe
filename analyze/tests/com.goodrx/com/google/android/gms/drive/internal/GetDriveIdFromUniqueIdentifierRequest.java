package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzai;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
   public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzai();
   final int mVersionCode;
   final String zzaoZ;
   final boolean zzarM;

   GetDriveIdFromUniqueIdentifierRequest(int var1, String var2, boolean var3) {
      this.mVersionCode = var1;
      this.zzaoZ = var2;
      this.zzarM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzai.zza(this, var1, var2);
   }
}
