package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_432;

// $FF: renamed from: com.google.android.gms.internal.dt
public final class class_433 implements SafeParcelable {
   public static final class_432 CREATOR = new class_432();
   public final ApplicationInfo applicationInfo;
   // $FF: renamed from: kL java.lang.String
   public final String field_1900;
   // $FF: renamed from: kO com.google.android.gms.internal.ew
   public final class_373 field_1901;
   // $FF: renamed from: kR com.google.android.gms.internal.am
   public final class_172 field_1902;
   // $FF: renamed from: pU android.os.Bundle
   public final Bundle field_1903;
   // $FF: renamed from: pV com.google.android.gms.internal.aj
   public final class_182 field_1904;
   // $FF: renamed from: pW android.content.pm.PackageInfo
   public final PackageInfo field_1905;
   // $FF: renamed from: pX java.lang.String
   public final String field_1906;
   // $FF: renamed from: pY java.lang.String
   public final String field_1907;
   // $FF: renamed from: pZ java.lang.String
   public final String field_1908;
   // $FF: renamed from: qa android.os.Bundle
   public final Bundle field_1909;
   public final int versionCode;

   class_433(int var1, Bundle var2, class_182 var3, class_172 var4, String var5, ApplicationInfo var6, PackageInfo var7, String var8, String var9, String var10, class_373 var11, Bundle var12) {
      this.versionCode = var1;
      this.field_1903 = var2;
      this.field_1904 = var3;
      this.field_1902 = var4;
      this.field_1900 = var5;
      this.applicationInfo = var6;
      this.field_1905 = var7;
      this.field_1906 = var8;
      this.field_1907 = var9;
      this.field_1908 = var10;
      this.field_1901 = var11;
      this.field_1909 = var12;
   }

   public class_433(Bundle var1, class_182 var2, class_172 var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, String var9, class_373 var10, Bundle var11) {
      this(2, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public class_433(class_433.class_1158 var1, String var2) {
      this(var1.field_3356, var1.field_3357, var1.field_3355, var1.field_3353, var1.applicationInfo, var1.field_3358, var2, var1.field_3359, var1.field_3360, var1.field_3354, var1.field_3361);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_432.method_2598(this, var1, var2);
   }

   public static final class class_1158 {
      public final ApplicationInfo applicationInfo;
      // $FF: renamed from: kL java.lang.String
      public final String field_3353;
      // $FF: renamed from: kO com.google.android.gms.internal.ew
      public final class_373 field_3354;
      // $FF: renamed from: kR com.google.android.gms.internal.am
      public final class_172 field_3355;
      // $FF: renamed from: pU android.os.Bundle
      public final Bundle field_3356;
      // $FF: renamed from: pV com.google.android.gms.internal.aj
      public final class_182 field_3357;
      // $FF: renamed from: pW android.content.pm.PackageInfo
      public final PackageInfo field_3358;
      // $FF: renamed from: pY java.lang.String
      public final String field_3359;
      // $FF: renamed from: pZ java.lang.String
      public final String field_3360;
      // $FF: renamed from: qa android.os.Bundle
      public final Bundle field_3361;

      public class_1158(Bundle var1, class_182 var2, class_172 var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, class_373 var9, Bundle var10) {
         this.field_3356 = var1;
         this.field_3357 = var2;
         this.field_3355 = var3;
         this.field_3353 = var4;
         this.applicationInfo = var5;
         this.field_3358 = var6;
         this.field_3359 = var7;
         this.field_3360 = var8;
         this.field_3354 = var9;
         this.field_3361 = var10;
      }
   }
}
