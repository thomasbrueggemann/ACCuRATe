package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.BasicAuthCache;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
   private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "Kerberos", "NTLM", "Digest", "Basic"}));
   private final int challengeCode;
   private final String headerName;
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   AuthenticationStrategyImpl(int var1, String var2) {
      this.challengeCode = var1;
      this.headerName = var2;
   }

   public void authFailed(HttpHost var1, AuthScheme var2, HttpContext var3) {
      Args.notNull(var1, "Host");
      Args.notNull(var3, "HTTP context");
      AuthCache var6 = HttpClientContext.adapt(var3).getAuthCache();
      if(var6 != null) {
         if(this.log.isDebugEnabled()) {
            this.log.debug("Clearing cached auth scheme for " + var1);
         }

         var6.remove(var1);
      }

   }

   public void authSucceeded(HttpHost var1, AuthScheme var2, HttpContext var3) {
      Args.notNull(var1, "Host");
      Args.notNull(var2, "Auth scheme");
      Args.notNull(var3, "HTTP context");
      HttpClientContext var7 = HttpClientContext.adapt(var3);
      if(this.isCachable(var2)) {
         Object var8 = var7.getAuthCache();
         if(var8 == null) {
            var8 = new BasicAuthCache();
            var7.setAuthCache((AuthCache)var8);
         }

         if(this.log.isDebugEnabled()) {
            this.log.debug("Caching \'" + var2.getSchemeName() + "\' auth scheme for " + var1);
         }

         ((AuthCache)var8).put(var1, var2);
      }

   }

   public Map<String, Header> getChallenges(HttpHost var1, HttpResponse var2, HttpContext var3) throws MalformedChallengeException {
      Args.notNull(var2, "HTTP response");
      Header[] var5 = var2.getHeaders(this.headerName);
      HashMap var6 = new HashMap(var5.length);
      int var7 = var5.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Header var9 = var5[var8];
         CharArrayBuffer var11;
         int var12;
         if(var9 instanceof FormattedHeader) {
            var11 = ((FormattedHeader)var9).getBuffer();
            var12 = ((FormattedHeader)var9).getValuePos();
         } else {
            String var10 = var9.getValue();
            if(var10 == null) {
               throw new MalformedChallengeException("Header value is null");
            }

            var11 = new CharArrayBuffer(var10.length());
            var11.append(var10);
            var12 = 0;
         }

         while(var12 < var11.length() && HTTP.isWhitespace(var11.charAt(var12))) {
            ++var12;
         }

         int var13;
         for(var13 = var12; var12 < var11.length() && !HTTP.isWhitespace(var11.charAt(var12)); ++var12) {
            ;
         }

         var6.put(var11.substring(var13, var12).toLowerCase(Locale.ENGLISH), var9);
      }

      return var6;
   }

   abstract Collection<String> getPreferredAuthSchemes(RequestConfig var1);

   public boolean isAuthenticationRequested(HttpHost var1, HttpResponse var2, HttpContext var3) {
      Args.notNull(var2, "HTTP response");
      return var2.getStatusLine().getStatusCode() == this.challengeCode;
   }

   protected boolean isCachable(AuthScheme var1) {
      if(var1 != null && var1.isComplete()) {
         String var2 = var1.getSchemeName();
         if(var2.equalsIgnoreCase("Basic") || var2.equalsIgnoreCase("Digest")) {
            return true;
         }
      }

      return false;
   }

   public Queue<AuthOption> select(Map<String, Header> var1, HttpHost var2, HttpResponse var3, HttpContext var4) throws MalformedChallengeException {
      Args.notNull(var1, "Map of auth challenges");
      Args.notNull(var2, "Host");
      Args.notNull(var3, "HTTP response");
      Args.notNull(var4, "HTTP context");
      HttpClientContext var9 = HttpClientContext.adapt(var4);
      LinkedList var10 = new LinkedList();
      Lookup var11 = var9.getAuthSchemeRegistry();
      if(var11 == null) {
         this.log.debug("Auth scheme registry not set in the context");
      } else {
         CredentialsProvider var12 = var9.getCredentialsProvider();
         if(var12 == null) {
            this.log.debug("Credentials provider not set in the context");
            return var10;
         }

         Object var13 = this.getPreferredAuthSchemes(var9.getRequestConfig());
         if(var13 == null) {
            var13 = DEFAULT_SCHEME_PRIORITY;
         }

         if(this.log.isDebugEnabled()) {
            this.log.debug("Authentication schemes in the order of preference: " + var13);
         }

         Iterator var14 = ((Collection)var13).iterator();

         while(var14.hasNext()) {
            String var15 = (String)var14.next();
            Header var16 = (Header)var1.get(var15.toLowerCase(Locale.ENGLISH));
            if(var16 != null) {
               AuthSchemeProvider var17 = (AuthSchemeProvider)var11.lookup(var15);
               if(var17 == null) {
                  if(this.log.isWarnEnabled()) {
                     this.log.warn("Authentication scheme " + var15 + " not supported");
                  }
               } else {
                  AuthScheme var18 = var17.create(var4);
                  var18.processChallenge(var16);
                  Credentials var19 = var12.getCredentials(new AuthScope(var2.getHostName(), var2.getPort(), var18.getRealm(), var18.getSchemeName()));
                  if(var19 != null) {
                     AuthOption var20 = new AuthOption(var18, var19);
                     var10.add(var20);
                  }
               }
            } else if(this.log.isDebugEnabled()) {
               this.log.debug("Challenge for " + var15 + " authentication scheme not available");
            }
         }
      }

      return var10;
   }
}
