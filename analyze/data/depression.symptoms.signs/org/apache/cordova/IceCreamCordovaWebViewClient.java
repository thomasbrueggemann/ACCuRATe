package org.apache.cordova;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaUriHelper;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.LOG;

@TargetApi(11)
public class IceCreamCordovaWebViewClient extends CordovaWebViewClient {
   private static final String TAG = "IceCreamCordovaWebViewClient";
   private CordovaUriHelper helper;

   public IceCreamCordovaWebViewClient(CordovaInterface var1) {
      super(var1);
   }

   public IceCreamCordovaWebViewClient(CordovaInterface var1, CordovaWebView var2) {
      super(var1, var2);
   }

   private boolean isUrlHarmful(String var1) {
      return (var1.startsWith("http:") || var1.startsWith("https:")) && !this.appView.getWhitelist().isUrlWhiteListed(var1) || var1.contains("app_webview");
   }

   private static boolean needsKitKatContentUrlFix(Uri var0) {
      return VERSION.SDK_INT >= 19 && "content".equals(var0.getScheme());
   }

   private static boolean needsSpecialsInAssetUrlFix(Uri var0) {
      if(CordovaResourceApi.getUriType(var0) == 1) {
         if(var0.getQuery() != null || var0.getFragment() != null) {
            return true;
         }

         if(var0.toString().contains("%")) {
            switch(VERSION.SDK_INT) {
            case 14:
            case 15:
               return true;
            default:
               return false;
            }
         }
      }

      return false;
   }

   public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
      try {
         if(this.isUrlHarmful(var2)) {
            LOG.method_14("IceCreamCordovaWebViewClient", "URL blocked by whitelist: " + var2);
            return new WebResourceResponse("text/plain", "UTF-8", (InputStream)null);
         } else {
            CordovaResourceApi var4 = this.appView.getResourceApi();
            Uri var5 = Uri.parse(var2);
            Uri var6 = var4.remapUri(var5);
            if(var5.equals(var6) && !needsSpecialsInAssetUrlFix(var5) && !needsKitKatContentUrlFix(var5)) {
               return null;
            } else {
               CordovaResourceApi.OpenForReadResult var7 = var4.openForRead(var6, true);
               WebResourceResponse var8 = new WebResourceResponse(var7.mimeType, "UTF-8", var7.inputStream);
               return var8;
            }
         }
      } catch (IOException var9) {
         if(!(var9 instanceof FileNotFoundException)) {
            LOG.method_6("IceCreamCordovaWebViewClient", "Error occurred while loading a file (returning a 404).", var9);
         }

         return new WebResourceResponse("text/plain", "UTF-8", (InputStream)null);
      }
   }
}
