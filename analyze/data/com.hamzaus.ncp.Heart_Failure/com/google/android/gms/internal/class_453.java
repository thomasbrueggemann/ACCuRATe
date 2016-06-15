package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_450;

// $FF: renamed from: com.google.android.gms.internal.w
public final class class_453 implements SafeParcelable {
   public static final class_450 CREATOR = new class_450();
   // $FF: renamed from: kZ boolean
   public final boolean field_2733;
   // $FF: renamed from: lb boolean
   public final boolean field_2734;
   public final int versionCode;

   class_453(int var1, boolean var2, boolean var3) {
      this.versionCode = var1;
      this.field_2733 = var2;
      this.field_2734 = var3;
   }

   public class_453(boolean var1, boolean var2) {
      this.versionCode = 1;
      this.field_2733 = var1;
      this.field_2734 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_450.method_2786(this, var1, var2);
   }
}
