package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.internal.class_1013;

public class OnDrivePreferencesResponse implements SafeParcelable {
   public static final Creator<OnDrivePreferencesResponse> CREATOR = new class_1013();
   // $FF: renamed from: CK int
   final int field_3221;
   // $FF: renamed from: QN com.google.android.gms.drive.DrivePreferences
   DrivePreferences field_3222;

   OnDrivePreferencesResponse(int var1, DrivePreferences var2) {
      this.field_3221 = var1;
      this.field_3222 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1013.method_5588(this, var1, var2);
   }
}
