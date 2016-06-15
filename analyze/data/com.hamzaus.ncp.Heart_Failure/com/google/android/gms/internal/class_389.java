package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.fp
public class class_389 {
   // $FF: renamed from: xW java.lang.String[]
   private static final String[] field_1755;
   // $FF: renamed from: xX java.util.Map
   private static final Map<String, Integer> field_1756;

   static {
      int var0 = 0;
      field_1755 = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};

      for(field_1756 = new HashMap(field_1755.length); var0 < field_1755.length; ++var0) {
         field_1756.put(field_1755[var0], Integer.valueOf(var0));
      }

   }

   // $FF: renamed from: H (int) java.lang.String
   public static String method_2467(int var0) {
      return var0 >= 0 && var0 < field_1755.length?field_1755[var0]:null;
   }

   // $FF: renamed from: Y (java.lang.String) int
   public static int method_2468(String var0) {
      Integer var1 = (Integer)field_1756.get(var0);
      if(var1 == null) {
         throw new IllegalArgumentException("[" + var0 + "] is not a valid global search section name");
      } else {
         return var1.intValue();
      }
   }

   // $FF: renamed from: dK () int
   public static int method_2469() {
      return field_1755.length;
   }
}
