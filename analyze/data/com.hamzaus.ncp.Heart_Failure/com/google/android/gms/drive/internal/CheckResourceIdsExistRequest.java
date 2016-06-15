package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_221;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
   public static final Creator<CheckResourceIdsExistRequest> CREATOR = new class_221();
   // $FF: renamed from: Iq java.util.List
   private final List<String> field_2898;
   // $FF: renamed from: xJ int
   private final int field_2899;

   CheckResourceIdsExistRequest(int var1, List<String> var2) {
      this.field_2899 = var1;
      this.field_2898 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2899;
   }

   // $FF: renamed from: gj () java.util.List
   public List<String> method_3036() {
      return this.field_2898;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_221.method_1390(this, var1, var2);
   }
}
