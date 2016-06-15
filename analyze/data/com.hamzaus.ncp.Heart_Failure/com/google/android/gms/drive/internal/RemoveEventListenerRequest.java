package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_781;

public class RemoveEventListenerRequest implements SafeParcelable {
   public static final Creator<RemoveEventListenerRequest> CREATOR = new class_781();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_3511;
   // $FF: renamed from: In int
   final int field_3512;
   // $FF: renamed from: xJ int
   final int field_3513;

   RemoveEventListenerRequest(int var1, DriveId var2, int var3) {
      this.field_3513 = var1;
      this.field_3511 = var2;
      this.field_3512 = var3;
   }

   public RemoveEventListenerRequest(DriveId var1, int var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_781.method_4380(this, var1, var2);
   }
}
