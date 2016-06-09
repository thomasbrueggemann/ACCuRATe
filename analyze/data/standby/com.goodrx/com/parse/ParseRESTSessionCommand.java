package com.parse;

import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import org.json.JSONObject;

class ParseRESTSessionCommand extends ParseRESTCommand {
   private ParseRESTSessionCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public static ParseRESTSessionCommand getCurrentSessionCommand(String var0) {
      return new ParseRESTSessionCommand("sessions/me", ParseHttpRequest.Method.GET, (JSONObject)null, var0);
   }

   public static ParseRESTSessionCommand revoke(String var0) {
      return new ParseRESTSessionCommand("logout", ParseHttpRequest.Method.POST, new JSONObject(), var0);
   }

   public static ParseRESTSessionCommand upgradeToRevocableSessionCommand(String var0) {
      return new ParseRESTSessionCommand("upgradeToRevocableSession", ParseHttpRequest.Method.POST, new JSONObject(), var0);
   }
}
