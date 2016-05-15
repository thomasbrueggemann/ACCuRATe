package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

public class ResponseProcessCookies implements HttpResponseInterceptor {
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   private static String formatCooke(Cookie var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append(var0.getName());
      var1.append("=\"");
      String var4 = var0.getValue();
      if(var4 != null) {
         if(var4.length() > 100) {
            var4 = var4.substring(0, 100) + "...";
         }

         var1.append(var4);
      }

      var1.append("\"");
      var1.append(", version:");
      var1.append(Integer.toString(var0.getVersion()));
      var1.append(", domain:");
      var1.append(var0.getDomain());
      var1.append(", path:");
      var1.append(var0.getPath());
      var1.append(", expiry:");
      var1.append(var0.getExpiryDate());
      return var1.toString();
   }

   private void processCookies(HeaderIterator param1, CookieSpec param2, CookieOrigin param3, CookieStore param4) {
      // $FF: Couldn't be decompiled
   }

   public void process(HttpResponse var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP context");
      HttpClientContext var5 = HttpClientContext.adapt(var2);
      CookieSpec var6 = var5.getCookieSpec();
      if(var6 == null) {
         this.log.debug("Cookie spec not specified in HTTP context");
      } else {
         CookieStore var7 = var5.getCookieStore();
         if(var7 == null) {
            this.log.debug("Cookie store not specified in HTTP context");
            return;
         }

         CookieOrigin var8 = var5.getCookieOrigin();
         if(var8 == null) {
            this.log.debug("Cookie origin not specified in HTTP context");
            return;
         }

         this.processCookies(var1.headerIterator("Set-Cookie"), var6, var8, var7);
         if(var6.getVersion() > 0) {
            this.processCookies(var1.headerIterator("Set-Cookie2"), var6, var8, var7);
            return;
         }
      }

   }
}
