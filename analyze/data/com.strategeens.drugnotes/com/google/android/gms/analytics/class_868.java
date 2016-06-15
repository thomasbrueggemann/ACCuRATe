package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.analytics.class_172;

// $FF: renamed from: com.google.android.gms.analytics.ai
class class_868 implements class_172 {
   // $FF: renamed from: Cc com.google.android.gms.analytics.ai
   private static class_868 field_3717;
   // $FF: renamed from: xO java.lang.Object
   private static Object field_3718 = new Object();
   private final Context mContext;

   protected class_868(Context var1) {
      this.mContext = var1;
   }

   // $FF: renamed from: fl () com.google.android.gms.analytics.ai
   public static class_868 method_4874() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: y (android.content.Context) void
   public static void method_4875(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ac (java.lang.String) boolean
   public boolean method_4876(String var1) {
      return "&sr".equals(var1);
   }

   // $FF: renamed from: fm () java.lang.String
   protected String method_4877() {
      DisplayMetrics var1 = this.mContext.getResources().getDisplayMetrics();
      return var1.widthPixels + "x" + var1.heightPixels;
   }

   public String getValue(String var1) {
      return var1 != null && var1.equals("&sr")?this.method_4877():null;
   }
}
