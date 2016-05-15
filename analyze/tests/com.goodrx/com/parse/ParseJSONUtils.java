package com.parse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSONUtils {
   public static JSONObject create(JSONObject var0, Collection<String> var1) {
      JSONObject var2 = new JSONObject();
      Iterator var3 = var0.keys();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         if(!var1.contains(var4)) {
            try {
               var2.put(var4, var0.opt(var4));
            } catch (JSONException var6) {
               throw new RuntimeException(var6);
            }
         }
      }

      return var2;
   }

   public static int getInt(JSONObject var0, List<String> var1) throws JSONException {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();

         try {
            int var5 = var0.getInt(var3);
            return var5;
         } catch (JSONException var6) {
            ;
         }
      }

      throw new JSONException("No value for " + var1);
   }

   public static Iterable<String> keys(final JSONObject var0) {
      return new Iterable() {
         public Iterator<String> iterator() {
            return var0.keys();
         }
      };
   }
}
