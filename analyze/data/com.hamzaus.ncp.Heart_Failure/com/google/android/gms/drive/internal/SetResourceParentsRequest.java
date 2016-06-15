package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_779;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
   public static final Creator<SetResourceParentsRequest> CREATOR = new class_779();
   // $FF: renamed from: JC com.google.android.gms.drive.DriveId
   final DriveId field_3264;
   // $FF: renamed from: JD java.util.List
   final List<DriveId> field_3265;
   // $FF: renamed from: xJ int
   final int field_3266;

   SetResourceParentsRequest(int var1, DriveId var2, List<DriveId> var3) {
      this.field_3266 = var1;
      this.field_3264 = var2;
      this.field_3265 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_779.method_4374(this, var1, var2);
   }
}
