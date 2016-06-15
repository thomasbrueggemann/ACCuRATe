package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.internal.class_1026;

public class SetDrivePreferencesRequest implements SafeParcelable {
   public static final Creator<SetDrivePreferencesRequest> CREATOR = new class_1026();
   // $FF: renamed from: CK int
   final int field_1744;
   // $FF: renamed from: QN com.google.android.gms.drive.DrivePreferences
   final DrivePreferences field_1745;

   SetDrivePreferencesRequest(int var1, DrivePreferences var2) {
      this.field_1744 = var1;
      this.field_1745 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1026.method_5630(this, var1, var2);
   }
}
