package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1031;

public class OpenFileIntentSenderRequest implements SafeParcelable {
   public static final Creator<OpenFileIntentSenderRequest> CREATOR = new class_1031();
   // $FF: renamed from: CK int
   final int field_4063;
   // $FF: renamed from: OH java.lang.String
   final String field_4064;
   // $FF: renamed from: OI java.lang.String[]
   final String[] field_4065;
   // $FF: renamed from: OJ com.google.android.gms.drive.DriveId
   final DriveId field_4066;

   OpenFileIntentSenderRequest(int var1, String var2, String[] var3, DriveId var4) {
      this.field_4063 = var1;
      this.field_4064 = var2;
      this.field_4065 = var3;
      this.field_4066 = var4;
   }

   public OpenFileIntentSenderRequest(String var1, String[] var2, DriveId var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1031.method_5647(this, var1, var2);
   }
}
