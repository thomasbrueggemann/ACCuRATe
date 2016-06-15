package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_429;
import java.net.URI;
import java.net.URISyntaxException;

// $FF: renamed from: com.google.android.gms.internal.fd
public class class_394 extends WebViewClient {
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   private final class_369 field_1764;
   // $FF: renamed from: sQ java.lang.String
   private final String field_1765;
   // $FF: renamed from: sR boolean
   private boolean field_1766;
   // $FF: renamed from: sS com.google.android.gms.internal.dp
   private final class_429 field_1767;

   public class_394(class_429 var1, class_369 var2, String var3) {
      this.field_1765 = this.method_2476(var3);
      this.field_1766 = false;
      this.field_1764 = var2;
      this.field_1767 = var1;
   }

   // $FF: renamed from: G (java.lang.String) java.lang.String
   private String method_2476(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         try {
            if(var1.endsWith("/")) {
               String var3 = var1.substring(0, -1 + var1.length());
               return var3;
            }
         } catch (IndexOutOfBoundsException var4) {
            class_370.method_2355(var4.getMessage());
            return var1;
         }
      }

      return var1;
   }

   // $FF: renamed from: F (java.lang.String) boolean
   protected boolean method_2477(String var1) {
      String var2 = this.method_2476(var1);
      if(!TextUtils.isEmpty(var2)) {
         try {
            URI var3 = new URI(var2);
            if("passback".equals(var3.getScheme())) {
               class_370.method_2363("Passback received");
               this.field_1767.method_2592();
               return true;
            }

            if(!TextUtils.isEmpty(this.field_1765)) {
               URI var5 = new URI(this.field_1765);
               String var6 = var5.getHost();
               String var7 = var3.getHost();
               String var8 = var5.getPath();
               String var9 = var3.getPath();
               if(class_349.equal(var6, var7) && class_349.equal(var8, var9)) {
                  class_370.method_2363("Passback received");
                  this.field_1767.method_2592();
                  return true;
               }
            }
         } catch (URISyntaxException var10) {
            class_370.method_2355(var10.getMessage());
            return false;
         }
      }

      return false;
   }

   public void onLoadResource(WebView var1, String var2) {
      class_370.method_2363("JavascriptAdWebViewClient::onLoadResource: " + var2);
      if(!this.method_2477(var2)) {
         this.field_1764.method_2349().onLoadResource(this.field_1764, var2);
      }

   }

   public void onPageFinished(WebView var1, String var2) {
      class_370.method_2363("JavascriptAdWebViewClient::onPageFinished: " + var2);
      if(!this.field_1766) {
         this.field_1767.method_2591();
         this.field_1766 = true;
      }

   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      class_370.method_2363("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + var2);
      if(this.method_2477(var2)) {
         class_370.method_2363("shouldOverrideUrlLoading: received passback url");
         return true;
      } else {
         return this.field_1764.method_2349().shouldOverrideUrlLoading(this.field_1764, var2);
      }
   }
}
