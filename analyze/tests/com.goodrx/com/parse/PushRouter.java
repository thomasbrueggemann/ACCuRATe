package com.parse;

import com.parse.ParseFileUtils;
import com.parse.ParsePlugins;
import com.parse.PushHistory;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class PushRouter {
   private static final String LEGACY_STATE_LOCATION = "pushState";
   private static int MAX_HISTORY_LENGTH = 10;
   private static final String STATE_LOCATION = "push";
   private static final String TAG = "com.parse.ParsePushRouter";
   private static PushRouter instance;
   private final File diskState;
   private final PushHistory history;

   private PushRouter(File var1, PushHistory var2) {
      this.diskState = var1;
      this.history = var2;
   }

   public static PushRouter getInstance() {
      synchronized(PushRouter.class){}

      PushRouter var1;
      try {
         if(instance == null) {
            instance = pushRouterFromState(new File(ParsePlugins.get().getFilesDir(), "push"), new File(ParsePlugins.get().getParseDir(), "pushState"), MAX_HISTORY_LENGTH);
         }

         var1 = instance;
      } finally {
         ;
      }

      return var1;
   }

   static PushRouter pushRouterFromState(File var0, File var1, int var2) {
      JSONObject var3 = readJSONFileQuietly(var0);
      JSONObject var4;
      if(var3 != null) {
         var4 = var3.optJSONObject("history");
      } else {
         var4 = null;
      }

      PushHistory var5 = new PushHistory(var2, var4);
      String var6 = var5.getLastReceivedTimestamp();
      boolean var7 = false;
      if(var6 == null) {
         JSONObject var10 = readJSONFileQuietly(var1);
         var7 = false;
         if(var10 != null) {
            String var11 = var10.optString("lastTime", (String)null);
            if(var11 != null) {
               var5.setLastReceivedTimestamp(var11);
            }

            var7 = true;
         }
      }

      PushRouter var8 = new PushRouter(var0, var5);
      if(var7) {
         var8.saveStateToDisk();
         ParseFileUtils.deleteQuietly(var1);
      }

      return var8;
   }

   private static JSONObject readJSONFileQuietly(File var0) {
      JSONObject var1 = null;
      if(var0 != null) {
         JSONObject var4;
         try {
            var4 = ParseFileUtils.readFileToJSONObject(var0);
         } catch (IOException var5) {
            return null;
         } catch (JSONException var6) {
            return null;
         }

         var1 = var4;
      }

      return var1;
   }

   static void resetInstance() {
      synchronized(PushRouter.class){}

      try {
         ParseFileUtils.deleteQuietly(new File(ParsePlugins.get().getFilesDir(), "push"));
         instance = null;
      } finally {
         ;
      }

   }

   private void saveStateToDisk() {
      // $FF: Couldn't be decompiled
   }

   public String getLastReceivedTimestamp() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.history.getLastReceivedTimestamp();
      } finally {
         ;
      }

      return var2;
   }

   public boolean handlePush(String param1, String param2, String param3, JSONObject param4) {
      // $FF: Couldn't be decompiled
   }

   JSONObject toJSON() throws JSONException {
      synchronized(this){}

      JSONObject var1;
      try {
         var1 = new JSONObject();
         var1.put("history", this.history.toJSON());
      } finally {
         ;
      }

      return var1;
   }
}
