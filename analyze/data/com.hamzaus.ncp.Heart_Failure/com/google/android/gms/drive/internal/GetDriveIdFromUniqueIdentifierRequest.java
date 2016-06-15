package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_220;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
   public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new class_220();
   // $FF: renamed from: Jm java.lang.String
   final String field_3985;
   // $FF: renamed from: Jn boolean
   final boolean field_3986;
   // $FF: renamed from: xJ int
   final int field_3987;

   GetDriveIdFromUniqueIdentifierRequest(int var1, String var2, boolean var3) {
      this.field_3987 = var1;
      this.field_3985 = var2;
      this.field_3986 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_220.method_1387(this, var1, var2);
   }
}
