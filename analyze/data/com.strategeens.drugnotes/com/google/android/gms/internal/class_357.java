package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.ey;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// $FF: renamed from: com.google.android.gms.internal.gx
@ey
public class class_357 extends class_356 {
   public class_357(class_371 var1, boolean var2) {
      super(var1, var2);
   }

   // $FF: renamed from: d (android.content.Context, java.lang.String, java.lang.String) android.webkit.WebResourceResponse
   protected WebResourceResponse method_2459(Context var1, String var2, String var3) throws IOException {
      HttpURLConnection var4 = (HttpURLConnection)(new URL(var3)).openConnection();

      WebResourceResponse var6;
      try {
         class_375.method_2559(var1, var2, true, var4, true);
         var4.addRequestProperty("Cache-Control", "max-stale=3600");
         var4.connect();
         var6 = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(class_375.method_2551(new InputStreamReader(var4.getInputStream())).getBytes("UTF-8")));
      } finally {
         var4.disconnect();
      }

      return var6;
   }

   public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
      try {
         if(!"mraid.js".equalsIgnoreCase((new File(var2)).getName())) {
            return super.shouldInterceptRequest(var1, var2);
         } else if(!(var1 instanceof class_371)) {
            class_368.method_2506("Tried to intercept request from a WebView that wasn\'t an AdWebView.");
            return super.shouldInterceptRequest(var1, var2);
         } else {
            class_371 var4 = (class_371)var1;
            var4.method_2531().method_2455();
            if(var4.method_2525().field_447) {
               class_368.method_2505("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
               return this.method_2459(var4.getContext(), this.mo.method_2534().field_1121, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
            } else if(var4.method_2535()) {
               class_368.method_2505("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
               return this.method_2459(var4.getContext(), this.mo.method_2534().field_1121, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
            } else {
               class_368.method_2505("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
               WebResourceResponse var5 = this.method_2459(var4.getContext(), this.mo.method_2534().field_1121, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
               return var5;
            }
         }
      } catch (IOException var6) {
         class_368.method_2506("Could not fetch MRAID JS. " + var6.getMessage());
         return super.shouldInterceptRequest(var1, var2);
      }
   }
}
