package org.apache.cordova.statusbar;

import android.util.Log;
import android.view.Window;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;

public class StatusBar extends CordovaPlugin {
   private static final String TAG = "StatusBar";

   public boolean execute(String var1, CordovaArgs var2, CallbackContext var3) throws JSONException {
      Log.v("StatusBar", "Executing action: " + var1);
      final Window var5 = this.cordova.getActivity().getWindow();
      if("show".equals(var1)) {
         this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
               var5.clearFlags(1024);
            }
         });
         return true;
      } else if("hide".equals(var1)) {
         this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
               var5.addFlags(1024);
            }
         });
         return true;
      } else {
         return false;
      }
   }

   public void initialize(CordovaInterface var1, CordovaWebView var2) {
      Log.v("StatusBar", "StatusBar: initialization");
      super.initialize(var1, var2);
      this.cordova.getActivity().getWindow().clearFlags(2048);
   }
}
