package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// $FF: renamed from: com.google.android.gms.internal.fb
public class class_368 extends class_367 {
   public class_368(class_369 var1, boolean var2) {
      super(var1, var2);
   }

   // $FF: renamed from: c (android.content.Context, java.lang.String, java.lang.String) android.webkit.WebResourceResponse
   protected WebResourceResponse method_2332(Context var1, String var2, String var3) throws IOException {
      HttpURLConnection var4 = (HttpURLConnection)(new URL(var3)).openConnection();

      WebResourceResponse var6;
      try {
         class_365.method_2294(var1, var2, true, var4);
         var4.connect();
         var6 = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(class_365.method_2289(new InputStreamReader(var4.getInputStream())).getBytes("UTF-8")));
      } finally {
         var4.disconnect();
      }

      return var6;
   }

   public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
      try {
         if(!"mraid.js".equalsIgnoreCase((new File(var2)).getName())) {
            return super.shouldInterceptRequest(var1, var2);
         } else if(!(var1 instanceof class_369)) {
            class_370.method_2358("Tried to intercept request from a WebView that wasn\'t an AdWebView.");
            return super.shouldInterceptRequest(var1, var2);
         } else {
            class_369 var4 = (class_369)var1;
            var4.method_2349().method_2329();
            if(var4.method_2338().field_570) {
               class_370.method_2357("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
               return this.method_2332(var4.getContext(), this.lL.method_2351().field_1607, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            } else if(var4.method_2352()) {
               class_370.method_2357("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
               return this.method_2332(var4.getContext(), this.lL.method_2351().field_1607, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            } else {
               class_370.method_2357("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
               WebResourceResponse var5 = this.method_2332(var4.getContext(), this.lL.method_2351().field_1607, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
               return var5;
            }
         }
      } catch (IOException var6) {
         class_370.method_2358("Could not fetching MRAID JS. " + var6.getMessage());
         return super.shouldInterceptRequest(var1, var2);
      }
   }
}
