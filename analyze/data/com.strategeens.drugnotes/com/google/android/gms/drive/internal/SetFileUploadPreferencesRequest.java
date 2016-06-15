package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.class_1029;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
   public static final Creator<SetFileUploadPreferencesRequest> CREATOR = new class_1029();
   // $FF: renamed from: CK int
   final int field_1930;
   // $FF: renamed from: QK com.google.android.gms.drive.internal.FileUploadPreferencesImpl
   final FileUploadPreferencesImpl field_1931;

   SetFileUploadPreferencesRequest(int var1, FileUploadPreferencesImpl var2) {
      this.field_1930 = var1;
      this.field_1931 = var2;
   }

   public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1029.method_5639(this, var1, var2);
   }
}
