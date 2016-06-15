package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_441;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gs;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.fh
@ey
public final class class_440 implements SafeParcelable {
   public static final class_441 CREATOR = new class_441();
   public final ApplicationInfo applicationInfo;
   // $FF: renamed from: lL java.lang.String
   public final String field_1459;
   // $FF: renamed from: lO com.google.android.gms.internal.gs
   public final class_369 field_1460;
   // $FF: renamed from: lS com.google.android.gms.internal.ay
   public final class_237 field_1461;
   // $FF: renamed from: mc java.util.List
   public final List<String> field_1462;
   // $FF: renamed from: tK android.os.Bundle
   public final Bundle field_1463;
   // $FF: renamed from: tL com.google.android.gms.internal.av
   public final class_218 field_1464;
   // $FF: renamed from: tM android.content.pm.PackageInfo
   public final PackageInfo field_1465;
   // $FF: renamed from: tN java.lang.String
   public final String field_1466;
   // $FF: renamed from: tO java.lang.String
   public final String field_1467;
   // $FF: renamed from: tP java.lang.String
   public final String field_1468;
   // $FF: renamed from: tQ android.os.Bundle
   public final Bundle field_1469;
   // $FF: renamed from: tR int
   public final int field_1470;
   // $FF: renamed from: tS android.os.Bundle
   public final Bundle field_1471;
   // $FF: renamed from: tT boolean
   public final boolean field_1472;
   public final int versionCode;

   class_440(int var1, Bundle var2, av var3, ay var4, String var5, ApplicationInfo var6, PackageInfo var7, String var8, String var9, String var10, gs var11, Bundle var12, int var13, List<String> var14, Bundle var15, boolean var16) {
      this.versionCode = var1;
      this.field_1463 = var2;
      this.field_1464 = var3;
      this.field_1461 = var4;
      this.field_1459 = var5;
      this.applicationInfo = var6;
      this.field_1465 = var7;
      this.field_1466 = var8;
      this.field_1467 = var9;
      this.field_1468 = var10;
      this.field_1460 = var11;
      this.field_1469 = var12;
      this.field_1470 = var13;
      this.field_1462 = var14;
      this.field_1471 = var15;
      this.field_1472 = var16;
   }

   public class_440(Bundle var1, av var2, ay var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, String var9, gs var10, Bundle var11, int var12, List<String> var13, Bundle var14, boolean var15) {
      this(4, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public class_440(class_440.class_1527 var1, String var2) {
      this(var1.field_4342, var1.field_4343, var1.field_4340, var1.field_4338, var1.applicationInfo, var1.field_4344, var2, var1.field_4345, var1.field_4346, var1.field_4339, var1.field_4347, var1.field_4348, var1.field_4341, var1.field_4349, var1.field_4350);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_441.method_2882(this, var1, var2);
   }

   @ey
   public static final class class_1527 {
      public final ApplicationInfo applicationInfo;
      // $FF: renamed from: lL java.lang.String
      public final String field_4338;
      // $FF: renamed from: lO com.google.android.gms.internal.gs
      public final class_369 field_4339;
      // $FF: renamed from: lS com.google.android.gms.internal.ay
      public final class_237 field_4340;
      // $FF: renamed from: mc java.util.List
      public final List<String> field_4341;
      // $FF: renamed from: tK android.os.Bundle
      public final Bundle field_4342;
      // $FF: renamed from: tL com.google.android.gms.internal.av
      public final class_218 field_4343;
      // $FF: renamed from: tM android.content.pm.PackageInfo
      public final PackageInfo field_4344;
      // $FF: renamed from: tO java.lang.String
      public final String field_4345;
      // $FF: renamed from: tP java.lang.String
      public final String field_4346;
      // $FF: renamed from: tQ android.os.Bundle
      public final Bundle field_4347;
      // $FF: renamed from: tR int
      public final int field_4348;
      // $FF: renamed from: tS android.os.Bundle
      public final Bundle field_4349;
      // $FF: renamed from: tT boolean
      public final boolean field_4350;

      public class_1527(Bundle var1, av var2, ay var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, gs var9, Bundle var10, List<String> var11, Bundle var12, boolean var13) {
         this.field_4342 = var1;
         this.field_4343 = var2;
         this.field_4340 = var3;
         this.field_4338 = var4;
         this.applicationInfo = var5;
         this.field_4344 = var6;
         this.field_4345 = var7;
         this.field_4346 = var8;
         this.field_4339 = var9;
         this.field_4347 = var10;
         this.field_4350 = var13;
         if(var11 != null && var11.size() > 0) {
            this.field_4348 = 2;
            this.field_4341 = var11;
         } else {
            this.field_4348 = 0;
            this.field_4341 = null;
         }

         this.field_4349 = var12;
      }
   }
}
