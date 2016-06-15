package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.class_315;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.iy;

// $FF: renamed from: com.google.android.gms.internal.bn
@ey
public final class class_242 {
   // $FF: renamed from: ph com.google.android.gms.internal.iy
   public static iy<String> field_471 = method_1612("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
   // $FF: renamed from: pi com.google.android.gms.internal.iy
   public static iy<String> field_472 = method_1612("gads:sdk_core_experiment_id", (String)null);
   // $FF: renamed from: pj com.google.android.gms.internal.iy
   public static iy<Boolean> field_473 = method_1614("gads:sdk_crash_report_enabled", false);
   // $FF: renamed from: pk com.google.android.gms.internal.iy
   public static iy<Boolean> field_474 = method_1614("gads:sdk_crash_report_full_stacktrace", false);
   // $FF: renamed from: pl com.google.android.gms.internal.iy
   public static iy<Boolean> field_475 = method_1614("gads:block_autoclicks", false);
   // $FF: renamed from: pm com.google.android.gms.internal.iy
   public static iy<String> field_476 = method_1612("gads:block_autoclicks_experiment_id", (String)null);
   // $FF: renamed from: pn com.google.android.gms.internal.iy
   public static iy<Boolean> field_477;
   // $FF: renamed from: po com.google.android.gms.internal.iy
   public static iy<String> field_478;
   // $FF: renamed from: pp com.google.android.gms.internal.iy
   public static iy<Boolean> field_479;
   // $FF: renamed from: pq com.google.android.gms.internal.iy
   public static iy<Integer> field_480;
   // $FF: renamed from: pr com.google.android.gms.internal.iy
   public static iy<Integer> field_481;
   // $FF: renamed from: ps com.google.android.gms.internal.iy
   public static iy<Integer> field_482;
   // $FF: renamed from: pt com.google.android.gms.internal.iy
   public static iy<Integer> field_483;
   // $FF: renamed from: pu com.google.android.gms.internal.iy
   public static iy<Integer> field_484;
   // $FF: renamed from: pv android.os.Bundle
   private static final Bundle field_485 = new Bundle();
   // $FF: renamed from: pw boolean
   private static boolean field_486 = false;

   static {
      field_486 = true;
      field_479 = method_1614("gads:enable_content_fetching", false);
      field_480 = method_1611("gads:content_length_weight", 1);
      field_481 = method_1611("gads:content_age_weight", 1);
      field_482 = method_1611("gads:min_content_len", 11);
      field_483 = method_1611("gads:fingerprint_number", 10);
      field_484 = method_1611("gads:sleep_sec", 10);
      field_477 = method_1614("gads:spam_app_context:enabled", false);
      field_478 = method_1612("gads:spam_app_context:experiment_id", (String)null);
   }

   // $FF: renamed from: a (java.lang.String, int) com.google.android.gms.internal.iy
   private static iy<Integer> method_1611(String var0, int var1) {
      field_485.putInt(var0, var1);
      return class_315.method_2211(var0, Integer.valueOf(var1));
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) com.google.android.gms.internal.iy
   private static iy<String> method_1612(String var0, String var1) {
      field_485.putString(var0, var1);
      return class_315.method_2213(var0, var1);
   }

   // $FF: renamed from: by () android.os.Bundle
   public static Bundle method_1613() {
      return field_485;
   }

   // $FF: renamed from: c (java.lang.String, boolean) com.google.android.gms.internal.iy
   private static iy<Boolean> method_1614(String var0, boolean var1) {
      field_485.putBoolean(var0, var1);
      return class_315.method_2212(var0, var1);
   }
}
