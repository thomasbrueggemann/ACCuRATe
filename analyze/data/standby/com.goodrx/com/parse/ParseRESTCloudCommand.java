package com.parse;

import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import java.util.Map;

class ParseRESTCloudCommand extends ParseRESTCommand {
   private ParseRESTCloudCommand(String var1, ParseHttpRequest.Method var2, Map<String, ?> var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public static ParseRESTCloudCommand callFunctionCommand(String var0, Map<String, ?> var1, String var2) {
      return new ParseRESTCloudCommand(String.format("functions/%s", new Object[]{var0}), ParseHttpRequest.Method.POST, var1, var2);
   }
}
