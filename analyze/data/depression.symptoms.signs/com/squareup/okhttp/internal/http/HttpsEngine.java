package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.TunnelRequest;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Policy;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import java.io.IOException;
import java.net.CacheResponse;
import java.net.SecureCacheResponse;
import java.net.URL;
import javax.net.ssl.SSLSocket;

public final class HttpsEngine extends HttpEngine {
   private SSLSocket sslSocket;

   public HttpsEngine(OkHttpClient var1, Policy var2, String var3, RawHeaders var4, Connection var5, RetryableOutputStream var6) throws IOException {
      super(var1, var2, var3, var4, var5, var6);
      SSLSocket var7;
      if(var5 != null) {
         var7 = (SSLSocket)var5.getSocket();
      } else {
         var7 = null;
      }

      this.sslSocket = var7;
   }

   protected boolean acceptCacheResponseType(CacheResponse var1) {
      return var1 instanceof SecureCacheResponse;
   }

   protected void connected(Connection var1) {
      this.sslSocket = (SSLSocket)var1.getSocket();
      super.connected(var1);
   }

   public SSLSocket getSslSocket() {
      return this.sslSocket;
   }

   protected TunnelRequest getTunnelConfig() {
      String var1 = this.requestHeaders.getUserAgent();
      if(var1 == null) {
         var1 = getDefaultUserAgent();
      }

      URL var2 = this.policy.getURL();
      return new TunnelRequest(var2.getHost(), Util.getEffectivePort(var2), var1, this.requestHeaders.getProxyAuthorization());
   }

   protected boolean includeAuthorityInRequestLine() {
      return false;
   }
}
