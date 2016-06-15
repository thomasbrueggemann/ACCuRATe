package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_205;

public class AddEventListenerRequest implements SafeParcelable {
   public static final Creator<AddEventListenerRequest> CREATOR = new class_205();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_3716;
   // $FF: renamed from: In int
   final int field_3717;
   // $FF: renamed from: Io android.app.PendingIntent
   final PendingIntent field_3718;
   // $FF: renamed from: xJ int
   final int field_3719;

   AddEventListenerRequest(int var1, DriveId var2, int var3, PendingIntent var4) {
      this.field_3719 = var1;
      this.field_3716 = var2;
      this.field_3717 = var3;
      this.field_3718 = var4;
   }

   public AddEventListenerRequest(DriveId var1, int var2, PendingIntent var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_205.method_1343(this, var1, var2);
   }
}
