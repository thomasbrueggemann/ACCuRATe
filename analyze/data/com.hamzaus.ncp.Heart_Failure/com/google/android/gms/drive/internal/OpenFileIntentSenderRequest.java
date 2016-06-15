package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_783;

public class OpenFileIntentSenderRequest implements SafeParcelable {
   public static final Creator<OpenFileIntentSenderRequest> CREATOR = new class_783();
   // $FF: renamed from: HV java.lang.String
   final String field_3971;
   // $FF: renamed from: HW java.lang.String[]
   final String[] field_3972;
   // $FF: renamed from: HX com.google.android.gms.drive.DriveId
   final DriveId field_3973;
   // $FF: renamed from: xJ int
   final int field_3974;

   OpenFileIntentSenderRequest(int var1, String var2, String[] var3, DriveId var4) {
      this.field_3974 = var1;
      this.field_3971 = var2;
      this.field_3972 = var3;
      this.field_3973 = var4;
   }

   public OpenFileIntentSenderRequest(String var1, String[] var2, DriveId var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_783.method_4386(this, var1, var2);
   }
}
