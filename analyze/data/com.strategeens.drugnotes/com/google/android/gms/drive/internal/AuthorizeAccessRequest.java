package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_249;

public class AuthorizeAccessRequest implements SafeParcelable {
   public static final Creator<AuthorizeAccessRequest> CREATOR = new class_249();
   // $FF: renamed from: CK int
   final int field_4068;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_4069;
   // $FF: renamed from: Pn long
   final long field_4070;

   AuthorizeAccessRequest(int var1, long var2, DriveId var4) {
      this.field_4068 = var1;
      this.field_4070 = var2;
      this.field_4069 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_249.method_1648(this, var1, var2);
   }
}
