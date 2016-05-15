package com.parse;

import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import java.util.Map;
import org.json.JSONObject;

class ParseRESTAnalyticsCommand extends ParseRESTCommand {
   static final String EVENT_APP_OPENED = "AppOpened";
   private static final String KEY_AT = "at";
   private static final String KEY_DIMENSIONS = "dimensions";
   private static final String KEY_PUSH_HASH = "push_hash";
   private static final String PATH = "events/%s";

   public ParseRESTAnalyticsCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public static ParseRESTAnalyticsCommand trackAppOpenedCommand(String var0, String var1) {
      return trackEventCommand("AppOpened", var0, (Map)null, var1);
   }

   static ParseRESTAnalyticsCommand trackEventCommand(String param0, String param1, Map<String, String> param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public static ParseRESTAnalyticsCommand trackEventCommand(String var0, Map<String, String> var1, String var2) {
      return trackEventCommand(var0, (String)null, var1, var2);
   }
}
