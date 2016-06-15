package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.ci;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.class_423;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_453;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;

// $FF: renamed from: com.google.android.gms.internal.ci
public final class class_424 implements SafeParcelable {
   public static final class_423 CREATOR = new class_423();
   // $FF: renamed from: kO com.google.android.gms.internal.ew
   public final class_373 field_1859;
   // $FF: renamed from: nZ java.lang.String
   public final String field_1860;
   // $FF: renamed from: oA java.lang.String
   public final String field_1861;
   // $FF: renamed from: oB com.google.android.gms.internal.cm
   public final class_40 field_1862;
   // $FF: renamed from: oC int
   public final int field_1863;
   // $FF: renamed from: oD com.google.android.gms.internal.be
   public final class_9 field_1864;
   // $FF: renamed from: oE java.lang.String
   public final String field_1865;
   // $FF: renamed from: oF com.google.android.gms.internal.w
   public final class_453 field_1866;
   public final int orientation;
   // $FF: renamed from: ot com.google.android.gms.internal.cf
   public final class_421 field_1867;
   // $FF: renamed from: ou com.google.android.gms.internal.u
   public final class_63 field_1868;
   // $FF: renamed from: ov com.google.android.gms.internal.cj
   public final class_43 field_1869;
   // $FF: renamed from: ow com.google.android.gms.internal.ey
   public final class_369 field_1870;
   // $FF: renamed from: ox com.google.android.gms.internal.bb
   public final class_8 field_1871;
   // $FF: renamed from: oy java.lang.String
   public final String field_1872;
   // $FF: renamed from: oz boolean
   public final boolean field_1873;
   public final int versionCode;

   class_424(int var1, class_421 var2, IBinder var3, IBinder var4, IBinder var5, IBinder var6, String var7, boolean var8, String var9, IBinder var10, int var11, int var12, String var13, class_373 var14, IBinder var15, String var16, class_453 var17) {
      this.versionCode = var1;
      this.field_1867 = var2;
      this.field_1868 = (class_63)class_741.method_4177(class_157.class_1317.method_4176(var3));
      this.field_1869 = (class_43)class_741.method_4177(class_157.class_1317.method_4176(var4));
      this.field_1870 = (class_369)class_741.method_4177(class_157.class_1317.method_4176(var5));
      this.field_1871 = (class_8)class_741.method_4177(class_157.class_1317.method_4176(var6));
      this.field_1872 = var7;
      this.field_1873 = var8;
      this.field_1861 = var9;
      this.field_1862 = (class_40)class_741.method_4177(class_157.class_1317.method_4176(var10));
      this.orientation = var11;
      this.field_1863 = var12;
      this.field_1860 = var13;
      this.field_1859 = var14;
      this.field_1864 = (class_9)class_741.method_4177(class_157.class_1317.method_4176(var15));
      this.field_1865 = var16;
      this.field_1866 = var17;
   }

   public class_424(class_421 var1, class_63 var2, class_43 var3, class_40 var4, class_373 var5) {
      this.versionCode = 4;
      this.field_1867 = var1;
      this.field_1868 = var2;
      this.field_1869 = var3;
      this.field_1870 = null;
      this.field_1871 = null;
      this.field_1872 = null;
      this.field_1873 = false;
      this.field_1861 = null;
      this.field_1862 = var4;
      this.orientation = -1;
      this.field_1863 = 4;
      this.field_1860 = null;
      this.field_1859 = var5;
      this.field_1864 = null;
      this.field_1865 = null;
      this.field_1866 = null;
   }

   public class_424(class_63 var1, class_43 var2, class_8 var3, class_40 var4, class_369 var5, boolean var6, int var7, String var8, class_373 var9, class_9 var10) {
      this.versionCode = 4;
      this.field_1867 = null;
      this.field_1868 = var1;
      this.field_1869 = var2;
      this.field_1870 = var5;
      this.field_1871 = var3;
      this.field_1872 = null;
      this.field_1873 = var6;
      this.field_1861 = null;
      this.field_1862 = var4;
      this.orientation = var7;
      this.field_1863 = 3;
      this.field_1860 = var8;
      this.field_1859 = var9;
      this.field_1864 = var10;
      this.field_1865 = null;
      this.field_1866 = null;
   }

   public class_424(class_63 var1, class_43 var2, class_8 var3, class_40 var4, class_369 var5, boolean var6, int var7, String var8, String var9, class_373 var10, class_9 var11) {
      this.versionCode = 4;
      this.field_1867 = null;
      this.field_1868 = var1;
      this.field_1869 = var2;
      this.field_1870 = var5;
      this.field_1871 = var3;
      this.field_1872 = var9;
      this.field_1873 = var6;
      this.field_1861 = var8;
      this.field_1862 = var4;
      this.orientation = var7;
      this.field_1863 = 3;
      this.field_1860 = null;
      this.field_1859 = var10;
      this.field_1864 = var11;
      this.field_1865 = null;
      this.field_1866 = null;
   }

   public class_424(class_63 var1, class_43 var2, class_40 var3, class_369 var4, int var5, class_373 var6, String var7, class_453 var8) {
      this.versionCode = 4;
      this.field_1867 = null;
      this.field_1868 = var1;
      this.field_1869 = var2;
      this.field_1870 = var4;
      this.field_1871 = null;
      this.field_1872 = null;
      this.field_1873 = false;
      this.field_1861 = null;
      this.field_1862 = var3;
      this.orientation = var5;
      this.field_1863 = 1;
      this.field_1860 = null;
      this.field_1859 = var6;
      this.field_1864 = null;
      this.field_1865 = var7;
      this.field_1866 = var8;
   }

   public class_424(class_63 var1, class_43 var2, class_40 var3, class_369 var4, boolean var5, int var6, class_373 var7) {
      this.versionCode = 4;
      this.field_1867 = null;
      this.field_1868 = var1;
      this.field_1869 = var2;
      this.field_1870 = var4;
      this.field_1871 = null;
      this.field_1872 = null;
      this.field_1873 = var5;
      this.field_1861 = null;
      this.field_1862 = var3;
      this.orientation = var6;
      this.field_1863 = 2;
      this.field_1860 = null;
      this.field_1859 = var7;
      this.field_1864 = null;
      this.field_1865 = null;
      this.field_1866 = null;
   }

   // $FF: renamed from: a (android.content.Intent) com.google.android.gms.internal.ci
   public static class_424 method_2569(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         var2.setClassLoader(ci.class.getClassLoader());
         class_424 var3 = (class_424)var2.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: renamed from: a (android.content.Intent, com.google.android.gms.internal.ci) void
   public static void method_2570(Intent var0, class_424 var1) {
      Bundle var2 = new Bundle(1);
      var2.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var1);
      var0.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", var2);
   }

   // $FF: renamed from: aP () android.os.IBinder
   IBinder method_2571() {
      return class_741.method_4178(this.field_1868).asBinder();
   }

   // $FF: renamed from: aQ () android.os.IBinder
   IBinder method_2572() {
      return class_741.method_4178(this.field_1869).asBinder();
   }

   // $FF: renamed from: aR () android.os.IBinder
   IBinder method_2573() {
      return class_741.method_4178(this.field_1870).asBinder();
   }

   // $FF: renamed from: aS () android.os.IBinder
   IBinder method_2574() {
      return class_741.method_4178(this.field_1871).asBinder();
   }

   // $FF: renamed from: aT () android.os.IBinder
   IBinder method_2575() {
      return class_741.method_4178(this.field_1864).asBinder();
   }

   // $FF: renamed from: aU () android.os.IBinder
   IBinder method_2576() {
      return class_741.method_4178(this.field_1862).asBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_423.method_2566(this, var1, var2);
   }
}
