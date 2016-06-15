package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_204;

public class AuthorizeAccessRequest implements SafeParcelable {
   public static final Creator<AuthorizeAccessRequest> CREATOR = new class_204();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_3975;
   // $FF: renamed from: Ip long
   final long field_3976;
   // $FF: renamed from: xJ int
   final int field_3977;

   AuthorizeAccessRequest(int var1, long var2, DriveId var4) {
      this.field_3977 = var1;
      this.field_3976 = var2;
      this.field_3975 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_204.method_1340(this, var1, var2);
   }
}
