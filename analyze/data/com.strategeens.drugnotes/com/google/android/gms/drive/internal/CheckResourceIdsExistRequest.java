package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_271;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
   public static final Creator<CheckResourceIdsExistRequest> CREATOR = new class_271();
   // $FF: renamed from: CK int
   private final int field_2756;
   // $FF: renamed from: Po java.util.List
   private final List<String> field_2757;

   CheckResourceIdsExistRequest(int var1, List<String> var2) {
      this.field_2756 = var1;
      this.field_2757 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2756;
   }

   // $FF: renamed from: iF () java.util.List
   public List<String> method_3617() {
      return this.field_2757;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_271.method_1732(this, var1, var2);
   }
}
