package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

public class RequestClientConnControl implements HttpRequestInterceptor {
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      if(var1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
         var1.setHeader("Proxy-Connection", "Keep-Alive");
      } else {
         RouteInfo var4 = HttpClientContext.adapt(var2).getHttpRoute();
         if(var4 == null) {
            this.log.debug("Connection route not set in the context");
            return;
         }

         if((var4.getHopCount() == 1 || var4.isTunnelled()) && !var1.containsHeader("Connection")) {
            var1.addHeader("Connection", "Keep-Alive");
         }

         if(var4.getHopCount() == 2 && !var4.isTunnelled() && !var1.containsHeader("Proxy-Connection")) {
            var1.addHeader("Proxy-Connection", "Keep-Alive");
            return;
         }
      }

   }
}
