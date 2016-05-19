package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

@Deprecated
public class HttpClientParams {
   public static long getConnectionManagerTimeout(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      Long var2 = (Long)var0.getParameter("http.conn-manager.timeout");
      return var2 != null?var2.longValue():(long)HttpConnectionParams.getConnectionTimeout(var0);
   }

   public static boolean isAuthenticating(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getBooleanParameter("http.protocol.handle-authentication", true);
   }

   public static boolean isRedirecting(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getBooleanParameter("http.protocol.handle-redirects", true);
   }
}
