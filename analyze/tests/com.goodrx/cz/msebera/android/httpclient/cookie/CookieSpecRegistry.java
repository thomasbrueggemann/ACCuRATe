package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class CookieSpecRegistry implements Lookup<CookieSpecProvider> {
   private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs = new ConcurrentHashMap();

   public CookieSpec getCookieSpec(String var1, HttpParams var2) throws IllegalStateException {
      Args.notNull(var1, "Name");
      CookieSpecFactory var4 = (CookieSpecFactory)this.registeredSpecs.get(var1.toLowerCase(Locale.ENGLISH));
      if(var4 != null) {
         return var4.newInstance(var2);
      } else {
         throw new IllegalStateException("Unsupported cookie spec: " + var1);
      }
   }

   public CookieSpecProvider lookup(final String var1) {
      return new CookieSpecProvider() {
         public CookieSpec create(HttpContext var1x) {
            HttpRequest var2 = (HttpRequest)var1x.getAttribute("http.request");
            return CookieSpecRegistry.this.getCookieSpec(var1, var2.getParams());
         }
      };
   }

   public void register(String var1, CookieSpecFactory var2) {
      Args.notNull(var1, "Name");
      Args.notNull(var2, "Cookie spec factory");
      this.registeredSpecs.put(var1.toLowerCase(Locale.ENGLISH), var2);
   }
}
