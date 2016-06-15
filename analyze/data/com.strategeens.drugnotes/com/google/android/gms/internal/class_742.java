package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_743;

// $FF: renamed from: com.google.android.gms.internal.kk
public class class_742 implements SafeParcelable {
   public static final class_743 CREATOR = new class_743();
   // $FF: renamed from: CK int
   final int field_3402;
   // $FF: renamed from: ND java.lang.String
   public final String field_3403;
   // $FF: renamed from: NE int
   public final int field_3404;

   public class_742(int var1, String var2, int var3) {
      this.field_3402 = var1;
      this.field_3403 = var2;
      this.field_3404 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_743.method_4312(this, var1, var2);
   }
}
