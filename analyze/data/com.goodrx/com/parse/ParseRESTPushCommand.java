package com.parse;

import com.parse.ParseInstallation;
import com.parse.ParseQuery;
import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import java.util.Set;
import org.json.JSONObject;

class ParseRESTPushCommand extends ParseRESTCommand {
   static final String KEY_CHANNELS = "channels";
   static final String KEY_DATA = "data";
   static final String KEY_DEVICE_TYPE = "deviceType";
   static final String KEY_EXPIRATION_INTERVAL = "expiration_interval";
   static final String KEY_EXPIRATION_TIME = "expiration_time";
   static final String KEY_WHERE = "where";

   public ParseRESTPushCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public static ParseRESTPushCommand sendPushCommand(ParseQuery.State<ParseInstallation> param0, Set<String> param1, String param2, Long param3, Long param4, JSONObject param5, String param6) {
      // $FF: Couldn't be decompiled
   }
}
