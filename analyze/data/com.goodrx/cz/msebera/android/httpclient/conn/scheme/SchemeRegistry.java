package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class SchemeRegistry {
   private final ConcurrentHashMap<String, Scheme> registeredSchemes = new ConcurrentHashMap();

   public final Scheme get(String var1) {
      Args.notNull(var1, "Scheme name");
      return (Scheme)this.registeredSchemes.get(var1);
   }

   public final Scheme getScheme(HttpHost var1) {
      Args.notNull(var1, "Host");
      return this.getScheme(var1.getSchemeName());
   }

   public final Scheme getScheme(String var1) {
      Scheme var2 = this.get(var1);
      if(var2 == null) {
         throw new IllegalStateException("Scheme \'" + var1 + "\' not registered.");
      } else {
         return var2;
      }
   }

   public final Scheme register(Scheme var1) {
      Args.notNull(var1, "Scheme");
      return (Scheme)this.registeredSchemes.put(var1.getName(), var1);
   }
}
