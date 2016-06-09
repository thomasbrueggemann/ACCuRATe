package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.protocol.RequestAuthenticationBase;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

@Deprecated
public class RequestTargetAuthentication extends RequestAuthenticationBase {
   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP context");
      if(!var1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && !var1.containsHeader("Authorization")) {
         AuthState var5 = (AuthState)var2.getAttribute("http.auth.target-scope");
         if(var5 == null) {
            this.log.debug("Target auth state not set in the context");
         } else {
            if(this.log.isDebugEnabled()) {
               this.log.debug("Target auth state: " + var5.getState());
            }

            this.process(var5, var1, var2);
         }
      }
   }
}
