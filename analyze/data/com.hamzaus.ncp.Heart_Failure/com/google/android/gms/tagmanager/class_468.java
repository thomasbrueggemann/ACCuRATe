package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.m
class class_468 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2826;
   private static final String VALUE;

   static {
      field_2826 = class_445.field_2386.toString();
      VALUE = class_444.field_2381.toString();
   }

   public class_468() {
      String var1 = field_2826;
      String[] var2 = new String[]{VALUE};
      super(var1, var2);
   }

   // $FF: renamed from: lf () java.lang.String
   public static String method_2884() {
      return field_2826;
   }

   // $FF: renamed from: lg () java.lang.String
   public static String method_2885() {
      return VALUE;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      return (class_52.class_816)var1.get(VALUE);
   }
}
