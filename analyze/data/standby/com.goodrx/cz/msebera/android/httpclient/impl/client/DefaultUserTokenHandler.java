package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.security.Principal;
import javax.net.ssl.SSLSession;

public class DefaultUserTokenHandler implements UserTokenHandler {
   public static final DefaultUserTokenHandler INSTANCE = new DefaultUserTokenHandler();

   private static Principal getAuthPrincipal(AuthState var0) {
      AuthScheme var1 = var0.getAuthScheme();
      if(var1 != null && var1.isComplete() && var1.isConnectionBased()) {
         Credentials var2 = var0.getCredentials();
         if(var2 != null) {
            return var2.getUserPrincipal();
         }
      }

      return null;
   }

   public Object getUserToken(HttpContext var1) {
      HttpClientContext var2 = HttpClientContext.adapt(var1);
      AuthState var3 = var2.getTargetAuthState();
      Principal var4 = null;
      if(var3 != null) {
         var4 = getAuthPrincipal(var3);
         if(var4 == null) {
            var4 = getAuthPrincipal(var2.getProxyAuthState());
         }
      }

      if(var4 == null) {
         HttpConnection var5 = var2.getConnection();
         if(var5.isOpen() && var5 instanceof ManagedHttpClientConnection) {
            SSLSession var6 = ((ManagedHttpClientConnection)var5).getSSLSession();
            if(var6 != null) {
               var4 = var6.getLocalPrincipal();
            }
         }
      }

      return var4;
   }
}
