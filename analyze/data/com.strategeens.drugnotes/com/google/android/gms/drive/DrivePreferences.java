package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_682;

public class DrivePreferences implements SafeParcelable {
   public static final Creator<DrivePreferences> CREATOR = new class_682();
   // $FF: renamed from: CK int
   final int field_3919;
   // $FF: renamed from: Ox boolean
   final boolean field_3920;

   DrivePreferences(int var1, boolean var2) {
      this.field_3919 = var1;
      this.field_3920 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_682.method_3862(this, var1, var2);
   }
}
