package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.class_587;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
   public static final Creator<ChangeEvent> CREATOR = new class_587();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_3979;
   // $FF: renamed from: Id int
   final int field_3980;
   // $FF: renamed from: xJ int
   final int field_3981;

   ChangeEvent(int var1, DriveId var2, int var3) {
      this.field_3981 = var1;
      this.field_3979 = var2;
      this.field_3980 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_3979;
   }

   public int getType() {
      return 1;
   }

   public boolean hasContentChanged() {
      return (2 & this.field_3980) != 0;
   }

   public boolean hasMetadataChanged() {
      return (1 & this.field_3980) != 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_3979, Integer.valueOf(this.field_3980)};
      return String.format("ChangeEvent [id=%s,changeFlags=%x]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_587.method_3313(this, var1, var2);
   }
}
