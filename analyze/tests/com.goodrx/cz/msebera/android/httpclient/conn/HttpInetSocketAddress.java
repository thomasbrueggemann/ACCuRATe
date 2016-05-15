package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@Deprecated
public class HttpInetSocketAddress extends InetSocketAddress {
   private final HttpHost httphost;

   public HttpInetSocketAddress(HttpHost var1, InetAddress var2, int var3) {
      super(var2, var3);
      Args.notNull(var1, "HTTP host");
      this.httphost = var1;
   }

   public HttpHost getHttpHost() {
      return this.httphost;
   }

   public String toString() {
      return this.httphost.getHostName() + ":" + this.getPort();
   }
}
