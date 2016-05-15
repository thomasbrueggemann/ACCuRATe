package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;

@Deprecated
public class HttpAuthenticator extends cz.msebera.android.httpclient.impl.auth.HttpAuthenticator {
   public HttpAuthenticator() {
   }

   public HttpAuthenticator(HttpClientAndroidLog var1) {
      super(var1);
   }

   public boolean authenticate(HttpHost var1, HttpResponse var2, AuthenticationStrategy var3, AuthState var4, HttpContext var5) {
      return this.handleAuthChallenge(var1, var2, var3, var4, var5);
   }
}
