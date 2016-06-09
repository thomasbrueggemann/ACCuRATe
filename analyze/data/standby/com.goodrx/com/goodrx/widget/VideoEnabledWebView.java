package com.goodrx.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.goodrx.widget.VideoEnabledWebChromeClient;
import java.util.Map;

public class VideoEnabledWebView extends WebView {
   private boolean addedJavascriptInterface = false;
   private VideoEnabledWebChromeClient videoEnabledWebChromeClient;

   public VideoEnabledWebView(Context var1) {
      super(var1);
   }

   public VideoEnabledWebView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public VideoEnabledWebView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private void addJavascriptInterface() {
      if(!this.addedJavascriptInterface) {
         this.addJavascriptInterface(new VideoEnabledWebView.JavascriptInterface(), "_VideoEnabledWebView");
         this.addedJavascriptInterface = true;
      }

   }

   public boolean isVideoFullscreen() {
      return this.videoEnabledWebChromeClient != null && this.videoEnabledWebChromeClient.isVideoFullscreen();
   }

   public void loadData(String var1, String var2, String var3) {
      this.addJavascriptInterface();
      super.loadData(var1, var2, var3);
   }

   public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5) {
      this.addJavascriptInterface();
      super.loadDataWithBaseURL(var1, var2, var3, var4, var5);
   }

   public void loadUrl(String var1) {
      this.addJavascriptInterface();
      super.loadUrl(var1);
   }

   public void loadUrl(String var1, Map<String, String> var2) {
      this.addJavascriptInterface();
      super.loadUrl(var1, var2);
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   public void setWebChromeClient(WebChromeClient var1) {
      this.getSettings().setJavaScriptEnabled(true);
      if(var1 instanceof VideoEnabledWebChromeClient) {
         this.videoEnabledWebChromeClient = (VideoEnabledWebChromeClient)var1;
      }

      super.setWebChromeClient(var1);
   }

   public class JavascriptInterface {
      @android.webkit.JavascriptInterface
      public void notifyVideoEnd() {
         Log.d("___", "GOT IT");
         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
               if(VideoEnabledWebView.this.videoEnabledWebChromeClient != null) {
                  VideoEnabledWebView.this.videoEnabledWebChromeClient.onHideCustomView();
               }

            }
         });
      }
   }
}
