package org.apache.cordova.splashscreen;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class SplashScreen extends CordovaPlugin {
   public boolean execute(String var1, JSONArray var2, CallbackContext var3) {
      if(var1.equals("hide")) {
         this.webView.postMessage("splashscreen", "hide");
      } else {
         if(!var1.equals("show")) {
            return false;
         }

         this.webView.postMessage("splashscreen", "show");
      }

      var3.success();
      return true;
   }
}
