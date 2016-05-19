package com.parse;

import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import java.util.HashMap;
import java.util.Map;

class ParseRESTConfigCommand extends ParseRESTCommand {
   public ParseRESTConfigCommand(String var1, ParseHttpRequest.Method var2, Map<String, ?> var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public static ParseRESTConfigCommand fetchConfigCommand(String var0) {
      return new ParseRESTConfigCommand("config", ParseHttpRequest.Method.GET, (Map)null, var0);
   }

   public static ParseRESTConfigCommand updateConfigCommand(Map<String, ?> var0, String var1) {
      HashMap var2 = null;
      if(var0 != null) {
         var2 = new HashMap();
         var2.put("params", var0);
      }

      return new ParseRESTConfigCommand("config", ParseHttpRequest.Method.PUT, var2, var1);
   }
}
