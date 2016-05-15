package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

public class RequestAuthCache implements HttpRequestInterceptor {
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   private void doPreemptiveAuth(HttpHost var1, AuthScheme var2, AuthState var3, CredentialsProvider var4) {
      String var5 = var2.getSchemeName();
      if(this.log.isDebugEnabled()) {
         this.log.debug("Re-using cached \'" + var5 + "\' auth scheme for " + var1);
      }

      Credentials var6 = var4.getCredentials(new AuthScope(var1, AuthScope.ANY_REALM, var5));
      if(var6 != null) {
         if("BASIC".equalsIgnoreCase(var2.getSchemeName())) {
            var3.setState(AuthProtocolState.CHALLENGED);
         } else {
            var3.setState(AuthProtocolState.SUCCESS);
         }

         var3.update(var2, var6);
      } else {
         this.log.debug("No credentials for preemptive authentication");
      }
   }

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP context");
      HttpClientContext var5 = HttpClientContext.adapt(var2);
      AuthCache var6 = var5.getAuthCache();
      if(var6 == null) {
         this.log.debug("Auth cache not set in the context");
      } else {
         CredentialsProvider var7 = var5.getCredentialsProvider();
         if(var7 == null) {
            this.log.debug("Credentials provider not set in the context");
            return;
         }

         RouteInfo var8 = var5.getHttpRoute();
         if(var8 == null) {
            this.log.debug("Route info not set in the context");
            return;
         }

         HttpHost var9 = var5.getTargetHost();
         if(var9 == null) {
            this.log.debug("Target host not set in the context");
            return;
         }

         if(var9.getPort() < 0) {
            var9 = new HttpHost(var9.getHostName(), var8.getTargetHost().getPort(), var9.getSchemeName());
         }

         AuthState var10 = var5.getTargetAuthState();
         if(var10 != null && var10.getState() == AuthProtocolState.UNCHALLENGED) {
            AuthScheme var14 = var6.get(var9);
            if(var14 != null) {
               this.doPreemptiveAuth(var9, var14, var10, var7);
            }
         }

         HttpHost var11 = var8.getProxyHost();
         AuthState var12 = var5.getProxyAuthState();
         if(var11 != null && var12 != null && var12.getState() == AuthProtocolState.UNCHALLENGED) {
            AuthScheme var13 = var6.get(var11);
            if(var13 != null) {
               this.doPreemptiveAuth(var11, var13, var12, var7);
               return;
            }
         }
      }

   }
}
