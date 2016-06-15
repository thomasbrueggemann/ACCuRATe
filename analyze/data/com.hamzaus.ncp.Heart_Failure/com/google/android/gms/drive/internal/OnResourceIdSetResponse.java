package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_787;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
   public static final Creator<OnResourceIdSetResponse> CREATOR = new class_787();
   // $FF: renamed from: Iq java.util.List
   private final List<String> field_2931;
   // $FF: renamed from: xJ int
   private final int field_2932;

   OnResourceIdSetResponse(int var1, List<String> var2) {
      this.field_2932 = var1;
      this.field_2931 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2932;
   }

   // $FF: renamed from: gj () java.util.List
   public List<String> method_3103() {
      return this.field_2931;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_787.method_4398(this, var1, var2);
   }
}
