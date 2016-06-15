package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1007;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
   public static final Creator<OnResourceIdSetResponse> CREATOR = new class_1007();
   // $FF: renamed from: CK int
   private final int field_2795;
   // $FF: renamed from: Po java.util.List
   private final List<String> field_2796;

   OnResourceIdSetResponse(int var1, List<String> var2) {
      this.field_2795 = var1;
      this.field_2796 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2795;
   }

   // $FF: renamed from: iF () java.util.List
   public List<String> method_3695() {
      return this.field_2796;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1007.method_5570(this, var1, var2);
   }
}
