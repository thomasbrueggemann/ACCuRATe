package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ho
public class class_395 {
   // $FF: renamed from: Df java.lang.String[]
   private static final String[] field_1229;
   // $FF: renamed from: Dg java.util.Map
   private static final Map<String, Integer> field_1230;

   static {
      int var0 = 0;
      field_1229 = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};

      for(field_1230 = new HashMap(field_1229.length); var0 < field_1229.length; ++var0) {
         field_1230.put(field_1229[var0], Integer.valueOf(var0));
      }

   }

   // $FF: renamed from: P (int) java.lang.String
   public static String method_2681(int var0) {
      return var0 >= 0 && var0 < field_1229.length?field_1229[var0]:null;
   }

   // $FF: renamed from: as (java.lang.String) int
   public static int method_2682(String var0) {
      Integer var1 = (Integer)field_1230.get(var0);
      if(var1 == null) {
         throw new IllegalArgumentException("[" + var0 + "] is not a valid global search section name");
      } else {
         return var1.intValue();
      }
   }

   // $FF: renamed from: fF () int
   public static int method_2683() {
      return field_1229.length;
   }
}
