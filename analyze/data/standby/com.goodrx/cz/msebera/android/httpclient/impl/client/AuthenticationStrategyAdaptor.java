package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.BasicAuthCache;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Deprecated
class AuthenticationStrategyAdaptor implements AuthenticationStrategy {
   private final AuthenticationHandler handler;
   public HttpClientAndroidLog log;

   private boolean isCachable(AuthScheme var1) {
      if(var1 != null && var1.isComplete()) {
         String var2 = var1.getSchemeName();
         if(var2.equalsIgnoreCase("Basic") || var2.equalsIgnoreCase("Digest")) {
            return true;
         }
      }

      return false;
   }

   public void authFailed(HttpHost var1, AuthScheme var2, HttpContext var3) {
      AuthCache var4 = (AuthCache)var3.getAttribute("http.auth.auth-cache");
      if(var4 != null) {
         if(this.log.isDebugEnabled()) {
            this.log.debug("Removing from cache \'" + var2.getSchemeName() + "\' auth scheme for " + var1);
         }

         var4.remove(var1);
      }
   }

   public void authSucceeded(HttpHost var1, AuthScheme var2, HttpContext var3) {
      Object var4 = (AuthCache)var3.getAttribute("http.auth.auth-cache");
      if(this.isCachable(var2)) {
         if(var4 == null) {
            var4 = new BasicAuthCache();
            var3.setAttribute("http.auth.auth-cache", var4);
         }

         if(this.log.isDebugEnabled()) {
            this.log.debug("Caching \'" + var2.getSchemeName() + "\' auth scheme for " + var1);
         }

         ((AuthCache)var4).put(var1, var2);
      }

   }

   public Map<String, Header> getChallenges(HttpHost var1, HttpResponse var2, HttpContext var3) throws MalformedChallengeException {
      return this.handler.getChallenges(var2, var3);
   }

   public AuthenticationHandler getHandler() {
      return this.handler;
   }

   public boolean isAuthenticationRequested(HttpHost var1, HttpResponse var2, HttpContext var3) {
      return this.handler.isAuthenticationRequested(var2, var3);
   }

   public Queue<AuthOption> select(Map<String, Header> var1, HttpHost var2, HttpResponse var3, HttpContext var4) throws MalformedChallengeException {
      Args.notNull(var1, "Map of auth challenges");
      Args.notNull(var2, "Host");
      Args.notNull(var3, "HTTP response");
      Args.notNull(var4, "HTTP context");
      LinkedList var9 = new LinkedList();
      CredentialsProvider var10 = (CredentialsProvider)var4.getAttribute("http.auth.credentials-provider");
      if(var10 == null) {
         this.log.debug("Credentials provider not set in the context");
      } else {
         AuthScheme var12;
         try {
            var12 = this.handler.selectScheme(var1, var3, var4);
         } catch (AuthenticationException var14) {
            if(!this.log.isWarnEnabled()) {
               return var9;
            }

            this.log.warn(var14.getMessage(), var14);
            return var9;
         }

         var12.processChallenge((Header)var1.get(var12.getSchemeName().toLowerCase(Locale.ENGLISH)));
         Credentials var13 = var10.getCredentials(new AuthScope(var2.getHostName(), var2.getPort(), var12.getRealm(), var12.getSchemeName()));
         if(var13 != null) {
            var9.add(new AuthOption(var12, var13));
            return var9;
         }
      }

      return var9;
   }
}
