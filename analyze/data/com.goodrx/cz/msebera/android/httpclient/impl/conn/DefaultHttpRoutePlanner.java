package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.params.ConnRouteParams;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.InetAddress;

@Deprecated
public class DefaultHttpRoutePlanner implements HttpRoutePlanner {
   protected final SchemeRegistry schemeRegistry;

   public DefaultHttpRoutePlanner(SchemeRegistry var1) {
      Args.notNull(var1, "Scheme registry");
      this.schemeRegistry = var1;
   }

   public HttpRoute determineRoute(HttpHost var1, HttpRequest var2, HttpContext var3) throws HttpException {
      Args.notNull(var2, "HTTP request");
      HttpRoute var5 = ConnRouteParams.getForcedRoute(var2.getParams());
      if(var5 != null) {
         return var5;
      } else {
         Asserts.notNull(var1, "Target host");
         InetAddress var6 = ConnRouteParams.getLocalAddress(var2.getParams());
         HttpHost var7 = ConnRouteParams.getDefaultProxy(var2.getParams());

         Scheme var9;
         try {
            var9 = this.schemeRegistry.getScheme(var1.getSchemeName());
         } catch (IllegalStateException var12) {
            throw new HttpException(var12.getMessage());
         }

         boolean var10 = var9.isLayered();
         HttpRoute var11;
         if(var7 == null) {
            var11 = new HttpRoute(var1, var6, var10);
         } else {
            var11 = new HttpRoute(var1, var6, var7, var10);
         }

         return var11;
      }
   }
}
