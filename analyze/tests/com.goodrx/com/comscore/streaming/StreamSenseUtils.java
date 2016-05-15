package com.comscore.streaming;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StreamSenseUtils {
   public static void filterMap(Map<String, String> var0, Set<String> var1) {
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(!var1.contains(var3)) {
            var0.remove(var3);
         }
      }

   }
}
