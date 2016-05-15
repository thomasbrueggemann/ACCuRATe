package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class HttpAuthenticator {
   public HttpClientAndroidLog log;

   public HttpAuthenticator() {
      this((HttpClientAndroidLog)null);
   }

   public HttpAuthenticator(HttpClientAndroidLog var1) {
      if(var1 == null) {
         var1 = new HttpClientAndroidLog(this.getClass());
      }

      this.log = var1;
   }

   public boolean handleAuthChallenge(HttpHost param1, HttpResponse param2, AuthenticationStrategy param3, AuthState param4, HttpContext param5) {
      // $FF: Couldn't be decompiled
   }

   public boolean isAuthenticationRequested(HttpHost var1, HttpResponse var2, AuthenticationStrategy var3, AuthState var4, HttpContext var5) {
      if(var3.isAuthenticationRequested(var1, var2, var5)) {
         this.log.debug("Authentication required");
         if(var4.getState() == AuthProtocolState.SUCCESS) {
            var3.authFailed(var1, var4.getAuthScheme(), var5);
         }

         return true;
      } else {
         switch(null.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[var4.getState().ordinal()]) {
         case 1:
         case 2:
            this.log.debug("Authentication succeeded");
            var4.setState(AuthProtocolState.SUCCESS);
            var3.authSucceeded(var1, var4.getAuthScheme(), var5);
         case 3:
            break;
         default:
            var4.setState(AuthProtocolState.UNCHALLENGED);
         }

         return false;
      }
   }
}
