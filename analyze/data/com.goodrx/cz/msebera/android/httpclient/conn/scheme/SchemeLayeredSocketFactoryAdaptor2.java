package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.scheme.LayeredSchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class SchemeLayeredSocketFactoryAdaptor2 implements SchemeLayeredSocketFactory {
   private final LayeredSchemeSocketFactory factory;

   SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory var1) {
      this.factory = var1;
   }

   public Socket connectSocket(Socket var1, InetSocketAddress var2, InetSocketAddress var3, HttpParams var4) throws IOException, UnknownHostException, ConnectTimeoutException {
      return this.factory.connectSocket(var1, var2, var3, var4);
   }

   public Socket createLayeredSocket(Socket var1, String var2, int var3, HttpParams var4) throws IOException, UnknownHostException {
      return this.factory.createLayeredSocket(var1, var2, var3, true);
   }

   public Socket createSocket(HttpParams var1) throws IOException {
      return this.factory.createSocket(var1);
   }

   public boolean isSecure(Socket var1) throws IllegalArgumentException {
      return this.factory.isSecure(var1);
   }
}
