package org.apache.cordova;

import android.util.Log;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.NativeToJsMessageQueue;
import org.apache.cordova.PluginManager;
import org.json.JSONArray;
import org.json.JSONException;

public class CordovaBridge {
   private static final String LOG_TAG = "CordovaBridge";
   private volatile int expectedBridgeSecret = -1;
   private NativeToJsMessageQueue jsMessageQueue;
   private String loadedUrl;
   private PluginManager pluginManager;

   public CordovaBridge(PluginManager var1, NativeToJsMessageQueue var2) {
      this.pluginManager = var1;
      this.jsMessageQueue = var2;
   }

   private boolean verifySecret(String var1, int var2) throws IllegalAccessException {
      if(!this.jsMessageQueue.isBridgeEnabled()) {
         if(var2 == -1) {
            Log.d("CordovaBridge", var1 + " call made before bridge was enabled.");
         } else {
            Log.d("CordovaBridge", "Ignoring " + var1 + " from previous page load.");
         }

         return false;
      } else if(this.expectedBridgeSecret >= 0 && var2 == this.expectedBridgeSecret) {
         return true;
      } else {
         throw new IllegalAccessException();
      }
   }

   void clearBridgeSecret() {
      this.expectedBridgeSecret = -1;
   }

   int generateBridgeSecret() {
      this.expectedBridgeSecret = (int)(2.147483647E9D * Math.random());
      return this.expectedBridgeSecret;
   }

   public NativeToJsMessageQueue getMessageQueue() {
      return this.jsMessageQueue;
   }

   public String jsExec(int var1, String var2, String var3, String var4, String var5) throws JSONException, IllegalAccessException {
      if(!this.verifySecret("exec()", var1)) {
         return null;
      } else if(var5 == null) {
         return "@Null arguments.";
      } else {
         this.jsMessageQueue.setPaused(true);

         try {
            CordovaResourceApi.jsThread = Thread.currentThread();
            this.pluginManager.exec(var2, var3, var4, var5);
            String var8 = this.jsMessageQueue.popAndEncode(false);
            return var8;
         } catch (Throwable var11) {
            var11.printStackTrace();
         } finally {
            this.jsMessageQueue.setPaused(false);
         }

         return "";
      }
   }

   public String jsRetrieveJsMessages(int var1, boolean var2) throws IllegalAccessException {
      return !this.verifySecret("retrieveJsMessages()", var1)?null:this.jsMessageQueue.popAndEncode(var2);
   }

   public void jsSetNativeToJsBridgeMode(int var1, int var2) throws IllegalAccessException {
      if(this.verifySecret("setNativeToJsBridgeMode()", var1)) {
         this.jsMessageQueue.setBridgeMode(var2);
      }
   }

   public String promptOnJsPrompt(String var1, String var2, String var3) {
      String var9;
      if(var3 != null && var3.length() > 3 && var3.startsWith("gap:")) {
         label69: {
            try {
               JSONArray var12 = new JSONArray(var3.substring(4));
               var9 = this.jsExec(var12.getInt(0), var12.getString(1), var12.getString(2), var12.getString(3), var2);
               break label69;
            } catch (JSONException var18) {
               var18.printStackTrace();
            } catch (IllegalAccessException var19) {
               var19.printStackTrace();
            }

            return "";
         }

         if(var9 == null) {
            var9 = "";
         }
      } else {
         if(var3 != null && var3.startsWith("gap_bridge_mode:")) {
            try {
               this.jsSetNativeToJsBridgeMode(Integer.parseInt(var3.substring(16)), Integer.parseInt(var2));
            } catch (NumberFormatException var15) {
               var15.printStackTrace();
            } catch (IllegalAccessException var16) {
               var16.printStackTrace();
            }

            return "";
         }

         if(var3 == null || !var3.startsWith("gap_poll:")) {
            if(var3 != null && var3.startsWith("gap_init:")) {
               if(!var1.startsWith("file:") && (!var1.startsWith("http") || !this.loadedUrl.startsWith(var1))) {
                  Log.e("CordovaBridge", "gap_init called from restricted origin: " + var1);
                  return "";
               }

               int var4 = Integer.parseInt(var3.substring(9));
               this.jsMessageQueue.setBridgeMode(var4);
               int var5 = this.generateBridgeSecret();
               return "" + var5;
            }

            return null;
         }

         int var7 = Integer.parseInt(var3.substring(9));

         try {
            var9 = this.jsRetrieveJsMessages(var7, "1".equals(var2));
         } catch (IllegalAccessException var17) {
            var17.printStackTrace();
            return "";
         }

         if(var9 == null) {
            return "";
         }
      }

      return var9;
   }

   public void reset(String var1) {
      this.jsMessageQueue.reset();
      this.clearBridgeSecret();
      this.loadedUrl = var1;
   }
}
