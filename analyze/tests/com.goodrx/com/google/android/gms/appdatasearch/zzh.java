package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
   private static final String[] zzUb;
   private static final Map<String, Integer> zzUc;

   static {
      int var0 = 0;
      zzUb = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};

      for(zzUc = new HashMap(zzUb.length); var0 < zzUb.length; ++var0) {
         zzUc.put(zzUb[var0], Integer.valueOf(var0));
      }

   }

   public static String zzao(int var0) {
      return var0 >= 0 && var0 < zzUb.length?zzUb[var0]:null;
   }

   public static int zzbA(String var0) {
      Integer var1 = (Integer)zzUc.get(var0);
      if(var1 == null) {
         throw new IllegalArgumentException("[" + var0 + "] is not a valid global search section name");
      } else {
         return var1.intValue();
      }
   }

   public static int zzmg() {
      return zzUb.length;
   }
}
