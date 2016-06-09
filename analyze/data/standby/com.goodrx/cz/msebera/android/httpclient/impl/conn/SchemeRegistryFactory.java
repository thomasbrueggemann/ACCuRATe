package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;

@Deprecated
public final class SchemeRegistryFactory {
   public static SchemeRegistry createDefault() {
      SchemeRegistry var0 = new SchemeRegistry();
      var0.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
      var0.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
      return var0;
   }
}
