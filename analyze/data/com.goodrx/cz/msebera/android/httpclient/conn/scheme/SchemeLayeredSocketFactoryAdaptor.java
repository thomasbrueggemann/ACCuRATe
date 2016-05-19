package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactoryAdaptor;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class SchemeLayeredSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor implements SchemeLayeredSocketFactory {
   private final LayeredSocketFactory factory;

   SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory var1) {
      super(var1);
      this.factory = var1;
   }

   public Socket createLayeredSocket(Socket var1, String var2, int var3, HttpParams var4) throws IOException, UnknownHostException {
      return this.factory.createSocket(var1, var2, var3, true);
   }
}
