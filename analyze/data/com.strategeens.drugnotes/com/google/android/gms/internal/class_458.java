package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_459;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.do
@ey
public final class class_458 implements SafeParcelable {
   public static final class_459 CREATOR = new class_459();
   public final String mimeType;
   public final String packageName;
   // $FF: renamed from: rG java.lang.String
   public final String field_1539;
   // $FF: renamed from: rH java.lang.String
   public final String field_1540;
   // $FF: renamed from: rI java.lang.String
   public final String field_1541;
   // $FF: renamed from: rJ java.lang.String
   public final String field_1542;
   // $FF: renamed from: rK java.lang.String
   public final String field_1543;
   public final int versionCode;

   public class_458(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
      this.versionCode = var1;
      this.field_1539 = var2;
      this.field_1540 = var3;
      this.mimeType = var4;
      this.packageName = var5;
      this.field_1541 = var6;
      this.field_1542 = var7;
      this.field_1543 = var8;
   }

   public class_458(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      this(1, var1, var2, var3, var4, var5, var6, var7);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_459.method_2923(this, var1, var2);
   }
}
