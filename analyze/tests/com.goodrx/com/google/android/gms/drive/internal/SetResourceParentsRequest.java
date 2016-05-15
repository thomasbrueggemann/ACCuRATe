package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzbt;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
   public static final Creator<SetResourceParentsRequest> CREATOR = new zzbt();
   final int mVersionCode;
   final DriveId zzaqf;
   final List<DriveId> zzasC;

   SetResourceParentsRequest(int var1, DriveId var2, List<DriveId> var3) {
      this.mVersionCode = var1;
      this.zzaqf = var2;
      this.zzasC = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbt.zza(this, var1, var2);
   }
}
