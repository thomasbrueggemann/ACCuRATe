package org.apache.cordova;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Hashtable;
import org.apache.cordova.AuthenticationToken;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaUriHelper;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaWebViewClient extends WebViewClient {
   private static final String TAG = "CordovaWebViewClient";
   CordovaWebView appView;
   private Hashtable<String, AuthenticationToken> authenticationTokens = new Hashtable();
   CordovaInterface cordova;
   private boolean doClearHistory = false;
   CordovaUriHelper helper;
   boolean isCurrentlyLoading;

   @Deprecated
   public CordovaWebViewClient(CordovaInterface var1) {
      this.cordova = var1;
   }

   public CordovaWebViewClient(CordovaInterface var1, CordovaWebView var2) {
      this.cordova = var1;
      this.appView = var2;
      this.helper = new CordovaUriHelper(var1, var2);
   }

   public void clearAuthenticationTokens() {
      this.authenticationTokens.clear();
   }

   public AuthenticationToken getAuthenticationToken(String var1, String var2) {
      AuthenticationToken var3 = (AuthenticationToken)this.authenticationTokens.get(var1.concat(var2));
      if(var3 == null) {
         var3 = (AuthenticationToken)this.authenticationTokens.get(var1);
         if(var3 == null) {
            var3 = (AuthenticationToken)this.authenticationTokens.get(var2);
         }

         if(var3 == null) {
            var3 = (AuthenticationToken)this.authenticationTokens.get("");
         }
      }

      return var3;
   }

   public void onPageFinished(WebView var1, String var2) {
      super.onPageFinished(var1, var2);
      if(this.isCurrentlyLoading) {
         this.isCurrentlyLoading = false;
         LOG.method_2("CordovaWebViewClient", "onPageFinished(" + var2 + ")");
         if(this.doClearHistory) {
            var1.clearHistory();
            this.doClearHistory = false;
         }

         CordovaWebView var3 = this.appView;
         ++var3.loadUrlTimeout;
         this.appView.postMessage("onPageFinished", var2);
         if(this.appView.getVisibility() == 4) {
            (new Thread(new Runnable() {
               public void run() {
                  try {
                     Thread.sleep(2000L);
                     CordovaWebViewClient.this.cordova.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                           CordovaWebViewClient.this.appView.postMessage("spinner", "stop");
                        }
                     });
                  } catch (InterruptedException var2) {
                     ;
                  }
               }
            })).start();
         }

         if(var2.equals("about:blank")) {
            this.appView.postMessage("exit", (Object)null);
            return;
         }
      }

   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      super.onPageStarted(var1, var2, var3);
      this.isCurrentlyLoading = true;
      LOG.method_2("CordovaWebViewClient", "onPageStarted(" + var2 + ")");
      this.appView.bridge.reset(var2);
      this.appView.postMessage("onPageStarted", var2);
      if(this.appView.pluginManager != null) {
         this.appView.pluginManager.onReset();
      }

   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      if(this.isCurrentlyLoading) {
         Object[] var5 = new Object[]{Integer.valueOf(var2), var3, var4};
         LOG.method_4("CordovaWebViewClient", "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", var5);
         CordovaWebView var6 = this.appView;
         ++var6.loadUrlTimeout;
         if(var2 == -10) {
            if(var1.canGoBack()) {
               var1.goBack();
               return;
            }

            super.onReceivedError(var1, var2, var3, var4);
         }

         JSONObject var7 = new JSONObject();

         try {
            var7.put("errorCode", var2);
            var7.put("description", var3);
            var7.put("url", var4);
         } catch (JSONException var9) {
            var9.printStackTrace();
         }

         this.appView.postMessage("onReceivedError", var7);
      }
   }

   public void onReceivedHttpAuthRequest(WebView var1, HttpAuthHandler var2, String var3, String var4) {
      AuthenticationToken var5 = this.getAuthenticationToken(var3, var4);
      if(var5 != null) {
         var2.proceed(var5.getUserName(), var5.getPassword());
      } else {
         super.onReceivedHttpAuthRequest(var1, var2, var3, var4);
      }
   }

   @TargetApi(8)
   public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      String var4 = this.cordova.getActivity().getPackageName();
      PackageManager var5 = this.cordova.getActivity().getPackageManager();

      try {
         if((2 & var5.getApplicationInfo(var4, 128).flags) != 0) {
            var2.proceed();
         } else {
            super.onReceivedSslError(var1, var2, var3);
         }
      } catch (NameNotFoundException var7) {
         super.onReceivedSslError(var1, var2, var3);
      }
   }

   public AuthenticationToken removeAuthenticationToken(String var1, String var2) {
      return (AuthenticationToken)this.authenticationTokens.remove(var1.concat(var2));
   }

   public void setAuthenticationToken(AuthenticationToken var1, String var2, String var3) {
      if(var2 == null) {
         var2 = "";
      }

      if(var3 == null) {
         var3 = "";
      }

      this.authenticationTokens.put(var2.concat(var3), var1);
   }

   @Deprecated
   public void setWebView(CordovaWebView var1) {
      this.appView = var1;
      this.helper = new CordovaUriHelper(this.cordova, var1);
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      return this.helper.shouldOverrideUrlLoading(var1, var2);
   }
}
