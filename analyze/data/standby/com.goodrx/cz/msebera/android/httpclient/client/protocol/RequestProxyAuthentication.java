package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.protocol.RequestAuthenticationBase;
import cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

@Deprecated
public class RequestProxyAuthentication extends RequestAuthenticationBase {
   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP context");
      if(!var1.containsHeader("Proxy-Authorization")) {
         HttpRoutedConnection var5 = (HttpRoutedConnection)var2.getAttribute("http.connection");
         if(var5 == null) {
            this.log.debug("HTTP connection not set in the context");
            return;
         }

         if(!var5.getRoute().isTunnelled()) {
            AuthState var6 = (AuthState)var2.getAttribute("http.auth.proxy-scope");
            if(var6 == null) {
               this.log.debug("Proxy auth state not set in the context");
               return;
            }

            if(this.log.isDebugEnabled()) {
               this.log.debug("Proxy auth state: " + var6.getState());
            }

            this.process(var6, var1, var2);
            return;
         }
      }

   }
}
