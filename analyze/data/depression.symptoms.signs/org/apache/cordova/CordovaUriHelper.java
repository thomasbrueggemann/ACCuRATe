package org.apache.cordova;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;

class CordovaUriHelper {
   private static final String TAG = "CordovaUriHelper";
   private CordovaWebView appView;
   private CordovaInterface cordova;

   CordovaUriHelper(CordovaInterface var1, CordovaWebView var2) {
      this.appView = var2;
      this.cordova = var1;
   }

   @TargetApi(15)
   boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      if(!this.appView.pluginManager.onOverrideUrlLoading(var2)) {
         if(var2.startsWith("file://") | var2.startsWith("data:")) {
            return var2.contains("app_webview");
         }

         if(this.appView.getWhitelist().isUrlWhiteListed(var2)) {
            return false;
         }

         if(this.appView.getExternalWhitelist().isUrlWhiteListed(var2)) {
            try {
               Intent var3 = new Intent("android.intent.action.VIEW");
               var3.setData(Uri.parse(var2));
               var3.addCategory("android.intent.category.BROWSABLE");
               var3.setComponent((ComponentName)null);
               if(VERSION.SDK_INT >= 15) {
                  var3.setSelector((Intent)null);
               }

               this.cordova.getActivity().startActivity(var3);
               return true;
            } catch (ActivityNotFoundException var5) {
               LOG.method_6("CordovaUriHelper", "Error loading url " + var2, var5);
               return true;
            }
         }
      }

      return true;
   }
}
