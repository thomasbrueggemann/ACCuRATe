package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_172;

// $FF: renamed from: com.google.android.gms.analytics.g
class class_838 implements class_172 {
   // $FF: renamed from: xO java.lang.Object
   private static Object field_3474 = new Object();
   // $FF: renamed from: ye com.google.android.gms.analytics.g
   private static class_838 field_3475;
   // $FF: renamed from: ya java.lang.String
   protected String field_3476;
   // $FF: renamed from: yb java.lang.String
   protected String field_3477;
   // $FF: renamed from: yc java.lang.String
   protected String field_3478;
   // $FF: renamed from: yd java.lang.String
   protected String field_3479;

   protected class_838() {
   }

   private class_838(Context param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dZ () com.google.android.gms.analytics.g
   public static class_838 method_4635() {
      return field_3475;
   }

   // $FF: renamed from: y (android.content.Context) void
   public static void method_4636(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ac (java.lang.String) boolean
   public boolean method_4637(String var1) {
      return "&an".equals(var1) || "&av".equals(var1) || "&aid".equals(var1) || "&aiid".equals(var1);
   }

   public String getValue(String var1) {
      if(var1 != null) {
         if(var1.equals("&an")) {
            return this.field_3476;
         }

         if(var1.equals("&av")) {
            return this.field_3477;
         }

         if(var1.equals("&aid")) {
            return this.field_3478;
         }

         if(var1.equals("&aiid")) {
            return this.field_3479;
         }
      }

      return null;
   }
}
