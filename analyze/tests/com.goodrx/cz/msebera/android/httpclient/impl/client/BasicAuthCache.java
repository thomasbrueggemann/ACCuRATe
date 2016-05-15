package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import cz.msebera.android.httpclient.util.Args;
import java.util.HashMap;

public class BasicAuthCache implements AuthCache {
   private final HashMap<HttpHost, AuthScheme> map;
   private final SchemePortResolver schemePortResolver;

   public BasicAuthCache() {
      this((SchemePortResolver)null);
   }

   public BasicAuthCache(SchemePortResolver var1) {
      this.map = new HashMap();
      if(var1 == null) {
         var1 = DefaultSchemePortResolver.INSTANCE;
      }

      this.schemePortResolver = (SchemePortResolver)var1;
   }

   public AuthScheme get(HttpHost var1) {
      Args.notNull(var1, "HTTP host");
      return (AuthScheme)this.map.get(this.getKey(var1));
   }

   protected HttpHost getKey(HttpHost var1) {
      if(var1.getPort() <= 0) {
         int var3;
         try {
            var3 = this.schemePortResolver.resolve(var1);
         } catch (UnsupportedSchemeException var4) {
            return var1;
         }

         var1 = new HttpHost(var1.getHostName(), var3, var1.getSchemeName());
      }

      return var1;
   }

   public void put(HttpHost var1, AuthScheme var2) {
      Args.notNull(var1, "HTTP host");
      this.map.put(this.getKey(var1), var2);
   }

   public void remove(HttpHost var1) {
      Args.notNull(var1, "HTTP host");
      this.map.remove(this.getKey(var1));
   }

   public String toString() {
      return this.map.toString();
   }
}
