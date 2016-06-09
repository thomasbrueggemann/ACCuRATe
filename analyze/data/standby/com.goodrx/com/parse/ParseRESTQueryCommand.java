package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRESTCommand;
import com.parse.ParseTextUtils;
import com.parse.PointerEncoder;
import com.parse.http.ParseHttpRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.json.JSONObject;

class ParseRESTQueryCommand extends ParseRESTCommand {
   private ParseRESTQueryCommand(String var1, ParseHttpRequest.Method var2, Map<String, ?> var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public static <T extends ParseObject> ParseRESTQueryCommand countCommand(ParseQuery.State<T> var0, String var1) {
      Object[] var2 = new Object[]{var0.className()};
      String var3 = String.format("classes/%s", var2);
      Map var4 = encode(var0, true);
      return new ParseRESTQueryCommand(var3, ParseHttpRequest.Method.GET, var4, var1);
   }

   static <T extends ParseObject> Map<String, String> encode(ParseQuery.State<T> var0, boolean var1) {
      PointerEncoder var2 = PointerEncoder.get();
      HashMap var3 = new HashMap();
      List var4 = var0.order();
      if(!var4.isEmpty()) {
         var3.put("order", ParseTextUtils.join(",", var4));
      }

      ParseQuery.QueryConstraints var5 = var0.constraints();
      if(!var5.isEmpty()) {
         JSONObject var20 = (JSONObject)var2.encode(var5);
         String var21;
         if(!(var20 instanceof JSONObject)) {
            var21 = var20.toString();
         } else {
            var21 = JSONObjectInstrumentation.toString((JSONObject)var20);
         }

         var3.put("where", var21);
      }

      Set var6 = var0.selectedKeys();
      if(var6 != null) {
         var3.put("keys", ParseTextUtils.join(",", var6));
      }

      Set var7 = var0.includes();
      if(!var7.isEmpty()) {
         var3.put("include", ParseTextUtils.join(",", var7));
      }

      if(var1) {
         var3.put("count", Integer.toString(1));
      } else {
         int var8 = var0.limit();
         if(var8 >= 0) {
            var3.put("limit", Integer.toString(var8));
         }

         int var9 = var0.skip();
         if(var9 > 0) {
            var3.put("skip", Integer.toString(var9));
         }
      }

      Iterator var11 = var0.extraOptions().entrySet().iterator();

      while(var11.hasNext()) {
         Entry var13 = (Entry)var11.next();
         Object var14 = var2.encode(var13.getValue());
         var3.put(var13.getKey(), var14.toString());
      }

      if(var0.isTracingEnabled()) {
         var3.put("trace", Integer.toString(1));
      }

      return var3;
   }

   public static <T extends ParseObject> ParseRESTQueryCommand findCommand(ParseQuery.State<T> var0, String var1) {
      Object[] var2 = new Object[]{var0.className()};
      String var3 = String.format("classes/%s", var2);
      Map var4 = encode(var0, false);
      return new ParseRESTQueryCommand(var3, ParseHttpRequest.Method.GET, var4, var1);
   }
}
