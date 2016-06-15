package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_391;

// $FF: renamed from: com.google.android.gms.internal.hj
public class class_392 implements SafeParcelable {
   public static final class_391 CREATOR = new class_391();
   // $FF: renamed from: CK int
   final int field_1219;
   // $FF: renamed from: Db android.os.Bundle
   final Bundle field_1220;
   // $FF: renamed from: id int
   public final int field_1221;

   class_392(int var1, int var2, Bundle var3) {
      this.field_1219 = var1;
      this.field_1221 = var2;
      this.field_1220 = var3;
   }

   public int describeContents() {
      class_391 var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_391 var10000 = CREATOR;
      class_391.method_2674(this, var1, var2);
   }
}
