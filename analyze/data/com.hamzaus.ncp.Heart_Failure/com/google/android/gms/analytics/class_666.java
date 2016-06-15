package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.analytics.class_138;

// $FF: renamed from: com.google.android.gms.analytics.ae
class class_666 implements class_138 {
   // $FF: renamed from: tn java.lang.Object
   private static Object field_3568 = new Object();
   // $FF: renamed from: wW com.google.android.gms.analytics.ae
   private static class_666 field_3569;
   private final Context mContext;

   protected class_666(Context var1) {
      this.mContext = var1;
   }

   // $FF: renamed from: dq () com.google.android.gms.analytics.ae
   public static class_666 method_3867() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: r (android.content.Context) void
   public static void method_3868(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: J (java.lang.String) boolean
   public boolean method_3869(String var1) {
      return "&sr".equals(var1);
   }

   // $FF: renamed from: dr () java.lang.String
   protected String method_3870() {
      DisplayMetrics var1 = this.mContext.getResources().getDisplayMetrics();
      return var1.widthPixels + "x" + var1.heightPixels;
   }

   public String getValue(String var1) {
      return var1 != null && var1.equals("&sr")?this.method_3870():null;
   }
}
