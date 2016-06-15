package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_138;

// $FF: renamed from: com.google.android.gms.analytics.g
class class_642 implements class_138 {
   // $FF: renamed from: tD com.google.android.gms.analytics.g
   private static class_642 field_3380;
   // $FF: renamed from: tn java.lang.Object
   private static Object field_3381 = new Object();
   // $FF: renamed from: tA java.lang.String
   protected String field_3382;
   // $FF: renamed from: tB java.lang.String
   protected String field_3383;
   // $FF: renamed from: tC java.lang.String
   protected String field_3384;
   // $FF: renamed from: tz java.lang.String
   protected String field_3385;

   protected class_642() {
   }

   private class_642(Context param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cp () com.google.android.gms.analytics.g
   public static class_642 method_3680() {
      return field_3380;
   }

   // $FF: renamed from: r (android.content.Context) void
   public static void method_3681(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: J (java.lang.String) boolean
   public boolean method_3682(String var1) {
      return "&an".equals(var1) || "&av".equals(var1) || "&aid".equals(var1) || "&aiid".equals(var1);
   }

   public String getValue(String var1) {
      if(var1 != null) {
         if(var1.equals("&an")) {
            return this.field_3385;
         }

         if(var1.equals("&av")) {
            return this.field_3382;
         }

         if(var1.equals("&aid")) {
            return this.field_3383;
         }

         if(var1.equals("&aiid")) {
            return this.field_3384;
         }
      }

      return null;
   }
}
