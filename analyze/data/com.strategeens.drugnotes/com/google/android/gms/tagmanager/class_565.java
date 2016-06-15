package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.m
class class_565 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2667;
   private static final String VALUE;

   static {
      field_2667 = class_520.field_2183.toString();
      VALUE = class_519.field_2175.toString();
   }

   public class_565() {
      String var1 = field_2667;
      String[] var2 = new String[]{VALUE};
      super(var1, var2);
   }

   // $FF: renamed from: ph () java.lang.String
   public static String method_3452() {
      return field_2667;
   }

   // $FF: renamed from: pi () java.lang.String
   public static String method_3453() {
      return VALUE;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      return (class_57.class_1084)var1.get(VALUE);
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
