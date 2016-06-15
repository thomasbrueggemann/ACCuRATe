package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.class_1018;

public class OnContentsResponse implements SafeParcelable {
   public static final Creator<OnContentsResponse> CREATOR = new class_1018();
   // $FF: renamed from: CK int
   final int field_4289;
   // $FF: renamed from: PW com.google.android.gms.drive.Contents
   final Contents field_4290;
   // $FF: renamed from: QJ boolean
   final boolean field_4291;

   OnContentsResponse(int var1, Contents var2, boolean var3) {
      this.field_4289 = var1;
      this.field_4290 = var2;
      this.field_4291 = var3;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iL () com.google.android.gms.drive.Contents
   public Contents method_5558() {
      return this.field_4290;
   }

   // $FF: renamed from: iM () boolean
   public boolean method_5559() {
      return this.field_4291;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1018.method_5603(this, var1, var2);
   }
}
