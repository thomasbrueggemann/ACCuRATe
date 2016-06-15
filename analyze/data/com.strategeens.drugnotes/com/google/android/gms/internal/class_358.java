package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_436;
import com.google.android.gms.internal.ey;
import java.net.URI;
import java.net.URISyntaxException;

// $FF: renamed from: com.google.android.gms.internal.gz
@ey
public class class_358 extends WebViewClient {
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1074;
   // $FF: renamed from: xr java.lang.String
   private final String field_1075;
   // $FF: renamed from: xs boolean
   private boolean field_1076;
   // $FF: renamed from: xt com.google.android.gms.internal.fb
   private final class_436 field_1077;

   public class_358(class_436 var1, class_371 var2, String var3) {
      this.field_1075 = this.method_2460(var3);
      this.field_1076 = false;
      this.field_1074 = var2;
      this.field_1077 = var1;
   }

   // $FF: renamed from: Z (java.lang.String) java.lang.String
   private String method_2460(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         try {
            if(var1.endsWith("/")) {
               String var3 = var1.substring(0, -1 + var1.length());
               return var3;
            }
         } catch (IndexOutOfBoundsException var4) {
            class_368.method_2503(var4.getMessage());
            return var1;
         }
      }

      return var1;
   }

   // $FF: renamed from: Y (java.lang.String) boolean
   protected boolean method_2461(String var1) {
      String var2 = this.method_2460(var1);
      if(!TextUtils.isEmpty(var2)) {
         try {
            URI var3 = new URI(var2);
            if("passback".equals(var3.getScheme())) {
               class_368.method_2502("Passback received");
               this.field_1077.method_2872();
               return true;
            }

            if(!TextUtils.isEmpty(this.field_1075)) {
               URI var5 = new URI(this.field_1075);
               String var6 = var5.getHost();
               String var7 = var3.getHost();
               String var8 = var5.getPath();
               String var9 = var3.getPath();
               if(class_336.equal(var6, var7) && class_336.equal(var8, var9)) {
                  class_368.method_2502("Passback received");
                  this.field_1077.method_2872();
                  return true;
               }
            }
         } catch (URISyntaxException var10) {
            class_368.method_2503(var10.getMessage());
            return false;
         }
      }

      return false;
   }

   public void onLoadResource(WebView var1, String var2) {
      class_368.method_2502("JavascriptAdWebViewClient::onLoadResource: " + var2);
      if(!this.method_2461(var2)) {
         this.field_1074.method_2531().onLoadResource(this.field_1074, var2);
      }

   }

   public void onPageFinished(WebView var1, String var2) {
      class_368.method_2502("JavascriptAdWebViewClient::onPageFinished: " + var2);
      if(!this.field_1076) {
         this.field_1077.method_2871();
         this.field_1076 = true;
      }

   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      class_368.method_2502("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + var2);
      if(this.method_2461(var2)) {
         class_368.method_2502("shouldOverrideUrlLoading: received passback url");
         return true;
      } else {
         return this.field_1074.method_2531().shouldOverrideUrlLoading(this.field_1074, var2);
      }
   }
}
