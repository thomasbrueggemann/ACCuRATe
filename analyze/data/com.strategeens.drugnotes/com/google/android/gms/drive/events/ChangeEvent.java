package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.class_691;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
   public static final Creator<ChangeEvent> CREATOR = new class_691();
   // $FF: renamed from: CK int
   final int field_4072;
   // $FF: renamed from: OX int
   final int field_4073;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_4074;

   ChangeEvent(int var1, DriveId var2, int var3) {
      this.field_4072 = var1;
      this.field_4074 = var2;
      this.field_4073 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_4074;
   }

   public int getType() {
      return 1;
   }

   public boolean hasContentChanged() {
      return (2 & this.field_4073) != 0;
   }

   public boolean hasMetadataChanged() {
      return (1 & this.field_4073) != 0;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.field_4074, Integer.valueOf(this.field_4073)};
      return String.format(var1, "ChangeEvent [id=%s,changeFlags=%x]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_691.method_3959(this, var1, var2);
   }
}
