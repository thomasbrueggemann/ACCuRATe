package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ip
public class class_280 {
   // $FF: renamed from: a (java.lang.StringBuilder, java.util.HashMap) void
   public static void method_1859(StringBuilder var0, HashMap<String, String> var1) {
      var0.append("{");
      Iterator var3 = var1.keySet().iterator();

      boolean var7;
      for(boolean var4 = true; var3.hasNext(); var4 = var7) {
         String var6 = (String)var3.next();
         if(!var4) {
            var0.append(",");
            var7 = var4;
         } else {
            var7 = false;
         }

         String var8 = (String)var1.get(var6);
         var0.append("\"").append(var6).append("\":");
         if(var8 == null) {
            var0.append("null");
         } else {
            var0.append("\"").append(var8).append("\"");
         }
      }

      var0.append("}");
   }
}
