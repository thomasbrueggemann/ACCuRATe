package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.class_864;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.analytics.ac
public class class_865 {
   // $FF: renamed from: a (com.google.android.gms.analytics.ab, long) java.lang.String
   public static String method_4850(class_864 var0, long var1) {
      StringBuilder var3 = new StringBuilder();
      var3.append(var0.method_4846());
      if(var0.method_4848() > 0L) {
         long var6 = var1 - var0.method_4848();
         if(var6 >= 0L) {
            var3.append("&qt").append("=").append(var6);
         }
      }

      var3.append("&z").append("=").append(var0.method_4847());
      return var3.toString();
   }

   public static String encode(String var0) {
      try {
         String var2 = URLEncoder.encode(var0, "UTF-8");
         return var2;
      } catch (UnsupportedEncodingException var3) {
         throw new AssertionError("URL encoding failed for: " + var0);
      }
   }

   // $FF: renamed from: z (java.util.Map) java.util.Map
   static Map<String, String> method_4851(Map<String, String> var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).startsWith("&") && var3.getValue() != null) {
            String var4 = ((String)var3.getKey()).substring(1);
            if(!TextUtils.isEmpty(var4)) {
               var1.put(var4, var3.getValue());
            }
         }
      }

      return var1;
   }
}
