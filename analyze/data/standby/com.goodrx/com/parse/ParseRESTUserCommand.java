package com.parse;

import bolts.Task;
import com.parse.ParseRESTCommand;
import com.parse.PointerEncoder;
import com.parse.ProgressCallback;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRESTUserCommand extends ParseRESTCommand {
   private static final String HEADER_REVOCABLE_SESSION = "X-Parse-Revocable-Session";
   private static final String HEADER_TRUE = "1";
   private boolean isRevocableSessionEnabled;
   private int statusCode;

   private ParseRESTUserCommand(String var1, ParseHttpRequest.Method var2, Map<String, ?> var3, String var4) {
      this(var1, var2, var3, var4, false);
   }

   private ParseRESTUserCommand(String var1, ParseHttpRequest.Method var2, Map<String, ?> var3, String var4, boolean var5) {
      super(var1, var2, var3, var4);
      this.isRevocableSessionEnabled = var5;
   }

   private ParseRESTUserCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4, boolean var5) {
      super(var1, var2, var3, var4);
      this.isRevocableSessionEnabled = var5;
   }

   public static ParseRESTUserCommand getCurrentUserCommand(String var0) {
      return new ParseRESTUserCommand("users/me", ParseHttpRequest.Method.GET, (Map)null, var0);
   }

   public static ParseRESTUserCommand logInUserCommand(String var0, String var1, boolean var2) {
      HashMap var3 = new HashMap();
      var3.put("username", var0);
      var3.put("password", var1);
      return new ParseRESTUserCommand("login", ParseHttpRequest.Method.GET, var3, (String)null, var2);
   }

   public static ParseRESTUserCommand resetPasswordResetCommand(String var0) {
      HashMap var1 = new HashMap();
      var1.put("email", var0);
      return new ParseRESTUserCommand("requestPasswordReset", ParseHttpRequest.Method.POST, var1, (String)null);
   }

   public static ParseRESTUserCommand serviceLogInUserCommand(String var0, Map<String, String> var1, boolean var2) {
      JSONObject var6;
      try {
         JSONObject var3 = new JSONObject();
         var3.put(var0, PointerEncoder.get().encode(var1));
         var6 = new JSONObject();
         var6.put("authData", var3);
      } catch (JSONException var7) {
         throw new RuntimeException("could not serialize object to JSON");
      }

      return serviceLogInUserCommand((JSONObject)var6, (String)null, var2);
   }

   public static ParseRESTUserCommand serviceLogInUserCommand(JSONObject var0, String var1, boolean var2) {
      return new ParseRESTUserCommand("users", ParseHttpRequest.Method.POST, var0, var1, var2);
   }

   public static ParseRESTUserCommand signUpUserCommand(JSONObject var0, String var1, boolean var2) {
      return new ParseRESTUserCommand("classes/_User", ParseHttpRequest.Method.POST, var0, var1, var2);
   }

   protected void addAdditionalHeaders(ParseHttpRequest.Builder var1) {
      super.addAdditionalHeaders(var1);
      if(this.isRevocableSessionEnabled) {
         var1.addHeader("X-Parse-Revocable-Session", "1");
      }

   }

   public int getStatusCode() {
      return this.statusCode;
   }

   protected Task<JSONObject> onResponseAsync(ParseHttpResponse var1, ProgressCallback var2) {
      this.statusCode = var1.getStatusCode();
      return super.onResponseAsync(var1, var2);
   }
}
