package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Queue;

@Deprecated
abstract class RequestAuthenticationBase implements HttpRequestInterceptor {
   final HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   private Header authenticate(AuthScheme var1, Credentials var2, HttpRequest var3, HttpContext var4) throws AuthenticationException {
      Asserts.notNull(var1, "Auth scheme");
      return var1 instanceof ContextAwareAuthScheme?((ContextAwareAuthScheme)var1).authenticate(var2, var3, var4):var1.authenticate(var2, var3);
   }

   private void ensureAuthScheme(AuthScheme var1) {
      Asserts.notNull(var1, "Auth scheme");
   }

   void process(AuthState var1, HttpRequest var2, HttpContext var3) {
      AuthScheme var4 = var1.getAuthScheme();
      Credentials var5 = var1.getCredentials();
      switch(null.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[var1.getState().ordinal()]) {
      case 1:
         return;
      case 2:
         this.ensureAuthScheme(var4);
         if(var4.isConnectionBased()) {
            return;
         }
         break;
      case 3:
         Queue var6 = var1.getAuthOptions();
         if(var6 != null) {
            while(!var6.isEmpty()) {
               AuthOption var8 = (AuthOption)var6.remove();
               AuthScheme var9 = var8.getAuthScheme();
               Credentials var10 = var8.getCredentials();
               var1.update(var9, var10);
               if(this.log.isDebugEnabled()) {
                  this.log.debug("Generating response to an authentication challenge using " + var9.getSchemeName() + " scheme");
               }

               try {
                  var2.addHeader(this.authenticate(var9, var10, var2, var3));
                  return;
               } catch (AuthenticationException var13) {
                  if(this.log.isWarnEnabled()) {
                     this.log.warn(var9 + " authentication error: " + var13.getMessage());
                  }
               }
            }

            return;
         }

         this.ensureAuthScheme(var4);
      }

      if(var4 != null) {
         try {
            var2.addHeader(this.authenticate(var4, var5, var2, var3));
         } catch (AuthenticationException var12) {
            if(this.log.isErrorEnabled()) {
               this.log.error(var4 + " authentication error: " + var12.getMessage());
               return;
            }
         }
      }

   }
}
