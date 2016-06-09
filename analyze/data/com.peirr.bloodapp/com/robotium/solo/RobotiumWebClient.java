package com.robotium.solo;

import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import com.robotium.solo.WebElementCreator;
import java.util.Iterator;
import java.util.List;

class RobotiumWebClient extends WebChromeClient {
   private Instrumentation inst;
   private WebChromeClient originalWebChromeClient = null;
   private WebChromeClient robotiumWebClient;
   WebElementCreator webElementCreator;

   public RobotiumWebClient(Instrumentation var1, WebElementCreator var2) {
      this.inst = var1;
      this.webElementCreator = var2;
      this.robotiumWebClient = this;
   }

   public void enableJavascriptAndSetRobotiumWebClient(List<WebView> var1, WebChromeClient var2) {
      this.originalWebChromeClient = var2;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         final WebView var4 = (WebView)var3.next();
         if(var4 != null) {
            this.inst.runOnMainSync(new Runnable() {
               public void run() {
                  var4.getSettings().setJavaScriptEnabled(true);
                  var4.setWebChromeClient(RobotiumWebClient.this.robotiumWebClient);
               }
            });
         }
      }

   }

   public Bitmap getDefaultVideoPoster() {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.getDefaultVideoPoster():null;
   }

   public View getVideoLoadingProgressView() {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.getVideoLoadingProgressView():null;
   }

   public void getVisitedHistory(ValueCallback<String[]> var1) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.getVisitedHistory(var1);
      }

   }

   public void onCloseWindow(WebView var1) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onCloseWindow(var1);
      }

   }

   public void onConsoleMessage(String var1, int var2, String var3) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onConsoleMessage(var1, var2, var3);
      }

   }

   public boolean onConsoleMessage(ConsoleMessage var1) {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.onConsoleMessage(var1):true;
   }

   public boolean onCreateWindow(WebView var1, boolean var2, boolean var3, Message var4) {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.onCreateWindow(var1, var2, var3, var4):true;
   }

   public void onExceededDatabaseQuota(String var1, String var2, long var3, long var5, long var7, QuotaUpdater var9) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onExceededDatabaseQuota(var1, var2, var3, var5, var7, var9);
      }

   }

   public void onGeolocationPermissionsHidePrompt() {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onGeolocationPermissionsHidePrompt();
      }

   }

   public void onGeolocationPermissionsShowPrompt(String var1, Callback var2) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onGeolocationPermissionsShowPrompt(var1, var2);
      }

   }

   public void onHideCustomView() {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onHideCustomView();
      }

   }

   public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.onJsAlert(var1, var2, var3, var4):true;
   }

   public boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
      return this.originalWebChromeClient.onJsBeforeUnload(var1, var2, var3, var4)?this.originalWebChromeClient.onJsBeforeUnload(var1, var2, var3, var4):true;
   }

   public boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.onJsConfirm(var1, var2, var3, var4):true;
   }

   public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
      if(var3 == null || !var3.contains(";,") && !var3.contains("robotium-finished")) {
         if(this.originalWebChromeClient != null) {
            return this.originalWebChromeClient.onJsPrompt(var1, var2, var3, var4, var5);
         }
      } else {
         if(var3.equals("robotium-finished")) {
            this.webElementCreator.setFinished(true);
         } else {
            this.webElementCreator.createWebElementAndAddInList(var3, var1);
         }

         var5.confirm();
      }

      return true;
   }

   public boolean onJsTimeout() {
      return this.originalWebChromeClient != null?this.originalWebChromeClient.onJsTimeout():true;
   }

   public void onProgressChanged(WebView var1, int var2) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onProgressChanged(var1, var2);
      }

   }

   public void onReachedMaxAppCacheSize(long var1, long var3, QuotaUpdater var5) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onReachedMaxAppCacheSize(var1, var3, var5);
      }

   }

   public void onReceivedIcon(WebView var1, Bitmap var2) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onReceivedIcon(var1, var2);
      }

   }

   public void onReceivedTitle(WebView var1, String var2) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onReceivedTitle(var1, var2);
      }

   }

   public void onReceivedTouchIconUrl(WebView var1, String var2, boolean var3) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onReceivedTouchIconUrl(var1, var2, var3);
      }

   }

   public void onRequestFocus(WebView var1) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onRequestFocus(var1);
      }

   }

   public void onShowCustomView(View var1, CustomViewCallback var2) {
      if(this.originalWebChromeClient != null) {
         this.originalWebChromeClient.onShowCustomView(var1, var2);
      }

   }
}
