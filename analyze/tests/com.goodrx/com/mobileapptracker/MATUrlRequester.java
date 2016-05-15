package com.mobileapptracker;

import android.util.Log;
import com.mobileapptracker.MATDeferredDplinkr;
import org.json.JSONException;
import org.json.JSONObject;

class MATUrlRequester {
   private static void logResponse(JSONObject var0) {
      if(var0.length() > 0) {
         try {
            if(var0.has("errors") && var0.getJSONArray("errors").length() != 0) {
               String var11 = var0.getJSONArray("errors").getString(0);
               Log.d("MobileAppTracker", "Event was rejected by server with error: " + var11);
               return;
            }

            if(var0.has("log_action") && !var0.getString("log_action").equals("null") && !var0.getString("log_action").equals("false") && !var0.getString("log_action").equals("true")) {
               JSONObject var6 = var0.getJSONObject("log_action");
               if(var6.has("conversion")) {
                  JSONObject var7 = var6.getJSONObject("conversion");
                  if(var7.has("status")) {
                     if(var7.getString("status").equals("rejected")) {
                        String var9 = var7.getString("status_code");
                        Log.d("MobileAppTracker", "Event was rejected by server: status code " + var9);
                        return;
                     }

                     Log.d("MobileAppTracker", "Event was accepted by server");
                     return;
                  }
               }
            } else if(var0.has("options")) {
               JSONObject var3 = var0.getJSONObject("options");
               if(var3.has("conversion_status")) {
                  String var4 = var3.getString("conversion_status");
                  Log.d("MobileAppTracker", "Event was " + var4 + " by server");
               }
            }
         } catch (JSONException var12) {
            Log.d("MobileAppTracker", "Server response status could not be parsed");
            var12.printStackTrace();
            return;
         }
      }

   }

   protected static JSONObject requestUrl(String param0, JSONObject param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void requestDeeplink(MATDeferredDplinkr param1) {
      // $FF: Couldn't be decompiled
   }
}
