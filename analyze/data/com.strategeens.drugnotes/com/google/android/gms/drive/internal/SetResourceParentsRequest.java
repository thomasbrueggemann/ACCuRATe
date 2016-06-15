package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1028;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
   public static final Creator<SetResourceParentsRequest> CREATOR = new class_1028();
   // $FF: renamed from: CK int
   final int field_3215;
   // $FF: renamed from: QW com.google.android.gms.drive.DriveId
   final DriveId field_3216;
   // $FF: renamed from: QX java.util.List
   final List<DriveId> field_3217;

   SetResourceParentsRequest(int var1, DriveId var2, List<DriveId> var3) {
      this.field_3215 = var1;
      this.field_3216 = var2;
      this.field_3217 = var3;
   }

   public SetResourceParentsRequest(DriveId var1, List<DriveId> var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1028.method_5636(this, var1, var2);
   }
}
