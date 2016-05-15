package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class RequestDefaultHeaders implements HttpRequestInterceptor {
   private final Collection<? extends Header> defaultHeaders;

   public RequestDefaultHeaders() {
      this((Collection)null);
   }

   public RequestDefaultHeaders(Collection<? extends Header> var1) {
      this.defaultHeaders = var1;
   }

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      if(!var1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
         Collection var4 = (Collection)var1.getParams().getParameter("http.default-headers");
         if(var4 == null) {
            var4 = this.defaultHeaders;
         }

         if(var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               var1.addHeader((Header)var5.next());
            }
         }
      }

   }
}
