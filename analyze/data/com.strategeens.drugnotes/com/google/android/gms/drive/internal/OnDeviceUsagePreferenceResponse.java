package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.class_1017;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
   public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new class_1017();
   // $FF: renamed from: CK int
   final int field_2476;
   // $FF: renamed from: QK com.google.android.gms.drive.internal.FileUploadPreferencesImpl
   final FileUploadPreferencesImpl field_2477;

   OnDeviceUsagePreferenceResponse(int var1, FileUploadPreferencesImpl var2) {
      this.field_2476 = var1;
      this.field_2477 = var2;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iN () com.google.android.gms.drive.internal.FileUploadPreferencesImpl
   public FileUploadPreferencesImpl method_3238() {
      return this.field_2477;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1017.method_5600(this, var1, var2);
   }
}
