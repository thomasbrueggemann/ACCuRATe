package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.GetCallback;
import com.parse.ParseCallback2;
import com.parse.ParseClassName;
import com.parse.ParseCorePlugins;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseSessionController;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ParseClassName("_Session")
public class ParseSession extends ParseObject {
   private static final String KEY_CREATED_WITH = "createdWith";
   private static final String KEY_EXPIRES_AT = "expiresAt";
   private static final String KEY_INSTALLATION_ID = "installationId";
   private static final String KEY_RESTRICTED = "restricted";
   private static final String KEY_SESSION_TOKEN = "sessionToken";
   private static final String KEY_USER = "user";
   private static final List<String> READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[]{"sessionToken", "createdWith", "restricted", "user", "expiresAt", "installationId"}));

   public static Task<ParseSession> getCurrentSessionInBackground() {
      return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation() {
         public Task<ParseSession> then(Task<String> var1) throws Exception {
            String var2 = (String)var1.getResult();
            return var2 == null?Task.forResult((Object)null):ParseSession.getSessionController().getSessionAsync(var2).onSuccess(new Continuation() {
               public ParseSession then(Task<ParseObject.State> var1) throws Exception {
                  return (ParseSession)ParseObject.from((ParseObject.State)var1.getResult());
               }
            });
         }
      });
   }

   public static void getCurrentSessionInBackground(GetCallback<ParseSession> var0) {
      ParseTaskUtils.callbackOnMainThreadAsync(getCurrentSessionInBackground(), (ParseCallback2)var0);
   }

   public static ParseQuery<ParseSession> getQuery() {
      return ParseQuery.getQuery(ParseSession.class);
   }

   private static ParseSessionController getSessionController() {
      return ParseCorePlugins.getInstance().getSessionController();
   }

   static boolean isRevocableSessionToken(String var0) {
      return var0.contains("r:");
   }

   static Task<Void> revokeAsync(String var0) {
      return var0 != null && isRevocableSessionToken(var0)?getSessionController().revokeAsync(var0):Task.forResult((Object)null);
   }

   static Task<String> upgradeToRevocableSessionAsync(String var0) {
      return var0 != null && !isRevocableSessionToken(var0)?getSessionController().upgradeToRevocable(var0).onSuccess(new Continuation() {
         public String then(Task<ParseObject.State> var1) throws Exception {
            return ((ParseSession)ParseObject.from((ParseObject.State)var1.getResult())).getSessionToken();
         }
      }):Task.forResult(var0);
   }

   public String getSessionToken() {
      return this.getString("sessionToken");
   }

   boolean isKeyMutable(String var1) {
      return !READ_ONLY_KEYS.contains(var1);
   }

   boolean needsDefaultACL() {
      return false;
   }
}
