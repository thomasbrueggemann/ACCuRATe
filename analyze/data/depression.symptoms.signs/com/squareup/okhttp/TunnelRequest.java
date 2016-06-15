package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;

public final class TunnelRequest {
   final String host;
   final int port;
   final String proxyAuthorization;
   final String userAgent;

   public TunnelRequest(String var1, int var2, String var3, String var4) {
      if(var1 == null) {
         throw new NullPointerException("host == null");
      } else if(var3 == null) {
         throw new NullPointerException("userAgent == null");
      } else {
         this.host = var1;
         this.port = var2;
         this.userAgent = var3;
         this.proxyAuthorization = var4;
      }
   }

   RawHeaders getRequestHeaders() {
      RawHeaders var1 = new RawHeaders();
      var1.setRequestLine("CONNECT " + this.host + ":" + this.port + " HTTP/1.1");
      String var2;
      if(this.port == Util.getDefaultPort("https")) {
         var2 = this.host;
      } else {
         var2 = this.host + ":" + this.port;
      }

      var1.set("Host", var2);
      var1.set("User-Agent", this.userAgent);
      if(this.proxyAuthorization != null) {
         var1.set("Proxy-Authorization", this.proxyAuthorization);
      }

      var1.set("Proxy-Connection", "Keep-Alive");
      return var1;
   }
}
