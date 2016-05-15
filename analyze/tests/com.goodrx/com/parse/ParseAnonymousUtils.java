package com.parse;

import bolts.Task;
import com.parse.LogInCallback;
import com.parse.ParseCallback2;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ParseAnonymousUtils {
   static final String AUTH_TYPE = "anonymous";

   static Map<String, String> getAuthData() {
      HashMap var0 = new HashMap();
      var0.put("id", UUID.randomUUID().toString());
      return var0;
   }

   public static boolean isLinked(ParseUser var0) {
      return var0.isLinked("anonymous");
   }

   public static void logIn(LogInCallback var0) {
      ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(), (ParseCallback2)var0);
   }

   public static Task<ParseUser> logInInBackground() {
      return ParseUser.logInWithInBackground("anonymous", getAuthData());
   }
}
