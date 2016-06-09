package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class AuthSchemeRegistry implements Lookup<AuthSchemeProvider> {
   private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes = new ConcurrentHashMap();

   public AuthScheme getAuthScheme(String var1, HttpParams var2) throws IllegalStateException {
      Args.notNull(var1, "Name");
      AuthSchemeFactory var4 = (AuthSchemeFactory)this.registeredSchemes.get(var1.toLowerCase(Locale.ENGLISH));
      if(var4 != null) {
         return var4.newInstance(var2);
      } else {
         throw new IllegalStateException("Unsupported authentication scheme: " + var1);
      }
   }

   public AuthSchemeProvider lookup(final String var1) {
      return new AuthSchemeProvider() {
         public AuthScheme create(HttpContext var1x) {
            HttpRequest var2 = (HttpRequest)var1x.getAttribute("http.request");
            return AuthSchemeRegistry.this.getAuthScheme(var1, var2.getParams());
         }
      };
   }

   public void register(String var1, AuthSchemeFactory var2) {
      Args.notNull(var1, "Name");
      Args.notNull(var2, "Authentication scheme factory");
      this.registeredSchemes.put(var1.toLowerCase(Locale.ENGLISH), var2);
   }
}
