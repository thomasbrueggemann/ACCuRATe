package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnection;
import cz.msebera.android.httpclient.impl.conn.SystemDefaultDnsResolver;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
   protected final DnsResolver dnsResolver;
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());
   protected final SchemeRegistry schemeRegistry;

   public DefaultClientConnectionOperator(SchemeRegistry var1) {
      Args.notNull(var1, "Scheme registry");
      this.schemeRegistry = var1;
      this.dnsResolver = new SystemDefaultDnsResolver();
   }

   private SchemeRegistry getSchemeRegistry(HttpContext var1) {
      SchemeRegistry var2 = (SchemeRegistry)var1.getAttribute("http.scheme-registry");
      if(var2 == null) {
         var2 = this.schemeRegistry;
      }

      return var2;
   }

   public OperatedClientConnection createConnection() {
      return new DefaultClientConnection();
   }

   public void openConnection(OperatedClientConnection param1, HttpHost param2, InetAddress param3, HttpContext param4, HttpParams param5) throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected void prepareSocket(Socket var1, HttpContext var2, HttpParams var3) throws IOException {
      var1.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(var3));
      var1.setSoTimeout(HttpConnectionParams.getSoTimeout(var3));
      int var4 = HttpConnectionParams.getLinger(var3);
      if(var4 >= 0) {
         boolean var5;
         if(var4 > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         var1.setSoLinger(var5, var4);
      }

   }

   protected InetAddress[] resolveHostname(String var1) throws UnknownHostException {
      return this.dnsResolver.resolve(var1);
   }

   public void updateSecureConnection(OperatedClientConnection var1, HttpHost var2, HttpContext var3, HttpParams var4) throws IOException {
      Args.notNull(var1, "Connection");
      Args.notNull(var2, "Target host");
      Args.notNull(var4, "Parameters");
      Asserts.check(var1.isOpen(), "Connection must be open");
      Scheme var8 = this.getSchemeRegistry(var3).getScheme(var2.getSchemeName());
      Asserts.check(var8.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
      SchemeLayeredSocketFactory var9 = (SchemeLayeredSocketFactory)var8.getSchemeSocketFactory();
      Socket var10 = var9.createLayeredSocket(var1.getSocket(), var2.getHostName(), var8.resolvePort(var2.getPort()), var4);
      this.prepareSocket(var10, var3, var4);
      var1.update(var10, var2, var9.isSecure(var10), var4);
   }
}
