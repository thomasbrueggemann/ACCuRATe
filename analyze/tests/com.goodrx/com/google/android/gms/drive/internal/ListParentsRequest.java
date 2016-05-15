package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzaq;

public class ListParentsRequest implements SafeParcelable {
   public static final Creator<ListParentsRequest> CREATOR = new zzaq();
   final int mVersionCode;
   final DriveId zzarP;

   ListParentsRequest(int var1, DriveId var2) {
      this.mVersionCode = var1;
      this.zzarP = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaq.zza(this, var1, var2);
   }
}
