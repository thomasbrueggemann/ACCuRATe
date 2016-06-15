package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.gs
@ey
public final class class_369 implements SafeParcelable {
   public static final class_370 CREATOR = new class_370();
   public final int versionCode;
   // $FF: renamed from: wS java.lang.String
   public String field_1121;
   // $FF: renamed from: wT int
   public int field_1122;
   // $FF: renamed from: wU int
   public int field_1123;
   // $FF: renamed from: wV boolean
   public boolean field_1124;

   public class_369(int var1, int var2, boolean var3) {
      StringBuilder var4 = (new StringBuilder()).append("afma-sdk-a-v").append(var1).append(".").append(var2).append(".");
      String var5;
      if(var3) {
         var5 = "0";
      } else {
         var5 = "1";
      }

      this(1, var4.append(var5).toString(), var1, var2, var3);
   }

   class_369(int var1, String var2, int var3, int var4, boolean var5) {
      this.versionCode = var1;
      this.field_1121 = var2;
      this.field_1122 = var3;
      this.field_1123 = var4;
      this.field_1124 = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_370.method_2512(this, var1, var2);
   }
}
