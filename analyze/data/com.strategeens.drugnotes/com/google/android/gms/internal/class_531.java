package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_533;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.y
@ey
public final class class_531 implements SafeParcelable {
   public static final class_533 CREATOR = new class_533();
   // $FF: renamed from: mi boolean
   public final boolean field_2512;
   // $FF: renamed from: ms boolean
   public final boolean field_2513;
   public final int versionCode;

   class_531(int var1, boolean var2, boolean var3) {
      this.versionCode = var1;
      this.field_2512 = var2;
      this.field_2513 = var3;
   }

   public class_531(boolean var1, boolean var2) {
      this.versionCode = 1;
      this.field_2512 = var1;
      this.field_2513 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_533.method_3276(this, var1, var2);
   }
}
