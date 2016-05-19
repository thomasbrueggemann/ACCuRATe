package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.scheme.HostNameResolver;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

@Deprecated
public class PlainSocketFactory implements SchemeSocketFactory, SocketFactory {
   private final HostNameResolver nameResolver = null;

   public static PlainSocketFactory getSocketFactory() {
      return new PlainSocketFactory();
   }

   @Deprecated
   public Socket connectSocket(Socket var1, String var2, int var3, InetAddress var4, int var5, HttpParams var6) throws IOException, UnknownHostException, ConnectTimeoutException {
      InetSocketAddress var7;
      label23: {
         if(var4 == null) {
            var7 = null;
            if(var5 <= 0) {
               break label23;
            }
         }

         if(var5 <= 0) {
            var5 = 0;
         }

         var7 = new InetSocketAddress(var4, var5);
      }

      InetAddress var8;
      if(this.nameResolver != null) {
         var8 = this.nameResolver.resolve(var2);
      } else {
         var8 = InetAddress.getByName(var2);
      }

      return this.connectSocket(var1, new InetSocketAddress(var8, var3), var7, var6);
   }

   public Socket connectSocket(Socket var1, InetSocketAddress var2, InetSocketAddress var3, HttpParams var4) throws IOException, ConnectTimeoutException {
      Args.notNull(var2, "Remote address");
      Args.notNull(var4, "HTTP parameters");
      Socket var7 = var1;
      if(var1 == null) {
         var7 = this.createSocket();
      }

      if(var3 != null) {
         var7.setReuseAddress(HttpConnectionParams.getSoReuseaddr(var4));
         var7.bind(var3);
      }

      int var8 = HttpConnectionParams.getConnectionTimeout(var4);
      int var9 = HttpConnectionParams.getSoTimeout(var4);

      try {
         var7.setSoTimeout(var9);
         var7.connect(var2, var8);
         return var7;
      } catch (SocketTimeoutException var11) {
         throw new ConnectTimeoutException("Connect to " + var2 + " timed out");
      }
   }

   public Socket createSocket() {
      return new Socket();
   }

   public Socket createSocket(HttpParams var1) {
      return new Socket();
   }

   public final boolean isSecure(Socket var1) {
      return false;
   }
}
