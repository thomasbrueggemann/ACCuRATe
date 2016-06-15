package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_463;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.class_531;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.dr
@ey
public final class class_462 implements SafeParcelable {
   public static final class_463 CREATOR = new class_463();
   // $FF: renamed from: lO com.google.android.gms.internal.gs
   public final class_369 field_1555;
   public final int orientation;
   // $FF: renamed from: rH java.lang.String
   public final String field_1556;
   // $FF: renamed from: sb com.google.android.gms.internal.do
   public final class_458 field_1557;
   // $FF: renamed from: sc com.google.android.gms.internal.t
   public final class_67 field_1558;
   // $FF: renamed from: sd com.google.android.gms.internal.ds
   public final class_49 field_1559;
   // $FF: renamed from: se com.google.android.gms.internal.gu
   public final class_371 field_1560;
   // $FF: renamed from: sf com.google.android.gms.internal.cb
   public final class_45 field_1561;
   // $FF: renamed from: sg java.lang.String
   public final String field_1562;
   // $FF: renamed from: sh boolean
   public final boolean field_1563;
   // $FF: renamed from: si java.lang.String
   public final String field_1564;
   // $FF: renamed from: sj com.google.android.gms.internal.dv
   public final class_50 field_1565;
   // $FF: renamed from: sk int
   public final int field_1566;
   // $FF: renamed from: sl com.google.android.gms.internal.ce
   public final class_47 field_1567;
   // $FF: renamed from: sm java.lang.String
   public final String field_1568;
   // $FF: renamed from: sn com.google.android.gms.internal.y
   public final class_531 field_1569;
   public final int versionCode;

   class_462(int var1, class_458 var2, IBinder var3, IBinder var4, IBinder var5, IBinder var6, String var7, boolean var8, String var9, IBinder var10, int var11, int var12, String var13, class_369 var14, IBinder var15, String var16, class_531 var17) {
      this.versionCode = var1;
      this.field_1557 = var2;
      this.field_1558 = (class_67)class_960.method_5292(class_198.class_1672.method_5291(var3));
      this.field_1559 = (class_49)class_960.method_5292(class_198.class_1672.method_5291(var4));
      this.field_1560 = (class_371)class_960.method_5292(class_198.class_1672.method_5291(var5));
      this.field_1561 = (class_45)class_960.method_5292(class_198.class_1672.method_5291(var6));
      this.field_1562 = var7;
      this.field_1563 = var8;
      this.field_1564 = var9;
      this.field_1565 = (class_50)class_960.method_5292(class_198.class_1672.method_5291(var10));
      this.orientation = var11;
      this.field_1566 = var12;
      this.field_1556 = var13;
      this.field_1555 = var14;
      this.field_1567 = (class_47)class_960.method_5292(class_198.class_1672.method_5291(var15));
      this.field_1568 = var16;
      this.field_1569 = var17;
   }

   public class_462(class_458 var1, class_67 var2, class_49 var3, class_50 var4, class_369 var5) {
      this.versionCode = 4;
      this.field_1557 = var1;
      this.field_1558 = var2;
      this.field_1559 = var3;
      this.field_1560 = null;
      this.field_1561 = null;
      this.field_1562 = null;
      this.field_1563 = false;
      this.field_1564 = null;
      this.field_1565 = var4;
      this.orientation = -1;
      this.field_1566 = 4;
      this.field_1556 = null;
      this.field_1555 = var5;
      this.field_1567 = null;
      this.field_1568 = null;
      this.field_1569 = null;
   }

   public class_462(class_67 var1, class_49 var2, class_45 var3, class_50 var4, class_371 var5, boolean var6, int var7, String var8, class_369 var9, class_47 var10) {
      this.versionCode = 4;
      this.field_1557 = null;
      this.field_1558 = var1;
      this.field_1559 = var2;
      this.field_1560 = var5;
      this.field_1561 = var3;
      this.field_1562 = null;
      this.field_1563 = var6;
      this.field_1564 = null;
      this.field_1565 = var4;
      this.orientation = var7;
      this.field_1566 = 3;
      this.field_1556 = var8;
      this.field_1555 = var9;
      this.field_1567 = var10;
      this.field_1568 = null;
      this.field_1569 = null;
   }

   public class_462(class_67 var1, class_49 var2, class_45 var3, class_50 var4, class_371 var5, boolean var6, int var7, String var8, String var9, class_369 var10, class_47 var11) {
      this.versionCode = 4;
      this.field_1557 = null;
      this.field_1558 = var1;
      this.field_1559 = var2;
      this.field_1560 = var5;
      this.field_1561 = var3;
      this.field_1562 = var9;
      this.field_1563 = var6;
      this.field_1564 = var8;
      this.field_1565 = var4;
      this.orientation = var7;
      this.field_1566 = 3;
      this.field_1556 = null;
      this.field_1555 = var10;
      this.field_1567 = var11;
      this.field_1568 = null;
      this.field_1569 = null;
   }

   public class_462(class_67 var1, class_49 var2, class_50 var3, class_371 var4, int var5, class_369 var6, String var7, class_531 var8) {
      this.versionCode = 4;
      this.field_1557 = null;
      this.field_1558 = var1;
      this.field_1559 = var2;
      this.field_1560 = var4;
      this.field_1561 = null;
      this.field_1562 = null;
      this.field_1563 = false;
      this.field_1564 = null;
      this.field_1565 = var3;
      this.orientation = var5;
      this.field_1566 = 1;
      this.field_1556 = null;
      this.field_1555 = var6;
      this.field_1567 = null;
      this.field_1568 = var7;
      this.field_1569 = var8;
   }

   public class_462(class_67 var1, class_49 var2, class_50 var3, class_371 var4, boolean var5, int var6, class_369 var7) {
      this.versionCode = 4;
      this.field_1557 = null;
      this.field_1558 = var1;
      this.field_1559 = var2;
      this.field_1560 = var4;
      this.field_1561 = null;
      this.field_1562 = null;
      this.field_1563 = var5;
      this.field_1564 = null;
      this.field_1565 = var3;
      this.orientation = var6;
      this.field_1566 = 2;
      this.field_1556 = null;
      this.field_1555 = var7;
      this.field_1567 = null;
      this.field_1568 = null;
      this.field_1569 = null;
   }

   // $FF: renamed from: a (android.content.Intent, com.google.android.gms.internal.dr) void
   public static void method_2936(Intent var0, class_462 var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var1);
      var0.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var2);
   }

   // $FF: renamed from: b (android.content.Intent) com.google.android.gms.internal.dr
   public static class_462 method_2937(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         var2.setClassLoader(dr.class.getClassLoader());
         class_462 var3 = (class_462)var2.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: renamed from: ck () android.os.IBinder
   IBinder method_2938() {
      return class_960.method_5293(this.field_1558).asBinder();
   }

   // $FF: renamed from: cl () android.os.IBinder
   IBinder method_2939() {
      return class_960.method_5293(this.field_1559).asBinder();
   }

   // $FF: renamed from: cm () android.os.IBinder
   IBinder method_2940() {
      return class_960.method_5293(this.field_1560).asBinder();
   }

   // $FF: renamed from: cn () android.os.IBinder
   IBinder method_2941() {
      return class_960.method_5293(this.field_1561).asBinder();
   }

   // $FF: renamed from: co () android.os.IBinder
   IBinder method_2942() {
      return class_960.method_5293(this.field_1567).asBinder();
   }

   // $FF: renamed from: cp () android.os.IBinder
   IBinder method_2943() {
      return class_960.method_5293(this.field_1565).asBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_463.method_2944(this, var1, var2);
   }
}
