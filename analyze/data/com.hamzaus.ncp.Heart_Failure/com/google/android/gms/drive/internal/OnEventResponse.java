package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;
import com.google.android.gms.drive.internal.class_791;

public class OnEventResponse implements SafeParcelable {
   public static final Creator<OnEventResponse> CREATOR = new class_791();
   // $FF: renamed from: In int
   final int field_2888;
   // $FF: renamed from: Jv com.google.android.gms.drive.events.ChangeEvent
   final ChangeEvent field_2889;
   // $FF: renamed from: Jw com.google.android.gms.drive.events.FileConflictEvent
   final FileConflictEvent field_2890;
   // $FF: renamed from: xJ int
   final int field_2891;

   OnEventResponse(int var1, int var2, ChangeEvent var3, FileConflictEvent var4) {
      this.field_2891 = var1;
      this.field_2888 = var2;
      this.field_2889 = var3;
      this.field_2890 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getEventType() {
      return this.field_2888;
   }

   // $FF: renamed from: gr () com.google.android.gms.drive.events.ChangeEvent
   public ChangeEvent method_2988() {
      return this.field_2889;
   }

   // $FF: renamed from: gs () com.google.android.gms.drive.events.FileConflictEvent
   public FileConflictEvent method_2989() {
      return this.field_2890;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_791.method_4410(this, var1, var2);
   }
}
