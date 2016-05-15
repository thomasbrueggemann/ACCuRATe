package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.util.Args;

public class DefaultSchemePortResolver implements SchemePortResolver {
   public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

   public int resolve(HttpHost var1) throws UnsupportedSchemeException {
      Args.notNull(var1, "HTTP host");
      int var3 = var1.getPort();
      if(var3 > 0) {
         return var3;
      } else {
         String var4 = var1.getSchemeName();
         if(var4.equalsIgnoreCase("http")) {
            return 80;
         } else if(var4.equalsIgnoreCase("https")) {
            return 443;
         } else {
            throw new UnsupportedSchemeException(var4 + " protocol is not supported");
         }
      }
   }
}
