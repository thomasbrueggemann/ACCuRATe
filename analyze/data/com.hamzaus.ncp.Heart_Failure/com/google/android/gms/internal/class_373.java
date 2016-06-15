package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_372;

// $FF: renamed from: com.google.android.gms.internal.ew
public final class class_373 implements SafeParcelable {
   public static final class_372 CREATOR = new class_372();
   // $FF: renamed from: st java.lang.String
   public String field_1607;
   // $FF: renamed from: su int
   public int field_1608;
   // $FF: renamed from: sv int
   public int field_1609;
   // $FF: renamed from: sw boolean
   public boolean field_1610;
   public final int versionCode;

   public class_373(int var1, int var2, boolean var3) {
      StringBuilder var4 = (new StringBuilder()).append("afma-sdk-a-v").append(var1).append(".").append(var2).append(".");
      String var5;
      if(var3) {
         var5 = "0";
      } else {
         var5 = "1";
      }

      this(1, var4.append(var5).toString(), var1, var2, var3);
   }

   class_373(int var1, String var2, int var3, int var4, boolean var5) {
      this.versionCode = var1;
      this.field_1607 = var2;
      this.field_1608 = var3;
      this.field_1609 = var4;
      this.field_1610 = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_372.method_2373(this, var1, var2);
   }
}
