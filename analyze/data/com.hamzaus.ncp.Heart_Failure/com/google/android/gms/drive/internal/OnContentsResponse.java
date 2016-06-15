package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.class_794;

public class OnContentsResponse implements SafeParcelable {
   public static final Creator<OnContentsResponse> CREATOR = new class_794();
   // $FF: renamed from: HD com.google.android.gms.drive.Contents
   final Contents field_4142;
   // $FF: renamed from: xJ int
   final int field_4143;

   OnContentsResponse(int var1, Contents var2) {
      this.field_4143 = var1;
      this.field_4142 = var2;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: go () com.google.android.gms.drive.Contents
   public Contents method_4363() {
      return this.field_4142;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_794.method_4419(this, var1, var2);
   }
}
