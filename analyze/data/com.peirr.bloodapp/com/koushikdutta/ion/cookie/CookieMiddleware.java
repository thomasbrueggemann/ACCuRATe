package com.koushikdutta.ion.cookie;

import android.content.Context;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.SimpleMiddleware;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.util.Map;

public class CookieMiddleware extends SimpleMiddleware {
   CookieManager manager = new CookieManager((CookieStore)null, (CookiePolicy)null);

   public CookieMiddleware(Context var1) {
   }

   public CookieManager getCookieManager() {
      return this.manager;
   }

   public CookieStore getCookieStore() {
      return this.manager.getCookieStore();
   }

   public void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedData var1) {
      try {
         this.manager.put(var1.request.getUri(), var1.headers.getHeaders().toMultimap());
      } catch (Exception var3) {
         ;
      }
   }

   public void onSocket(AsyncHttpClientMiddleware.OnSocketData var1) {
      try {
         Map var3 = this.manager.get(var1.request.getUri(), var1.request.getHeaders().getHeaders().toMultimap());
         var1.request.getHeaders().addCookies(var3);
      } catch (Exception var4) {
         ;
      }
   }
}
