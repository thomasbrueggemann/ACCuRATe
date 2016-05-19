package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.PartialDriveId;
import com.google.android.gms.drive.metadata.internal.zzl;
import java.util.ArrayList;
import java.util.List;

public class ParentDriveIdSet implements SafeParcelable {
   public static final Creator<ParentDriveIdSet> CREATOR = new zzl();
   final int mVersionCode;
   final List<PartialDriveId> zzasS;

   public ParentDriveIdSet() {
      this(1, new ArrayList());
   }

   ParentDriveIdSet(int var1, List<PartialDriveId> var2) {
      this.mVersionCode = var1;
      this.zzasS = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }
}
