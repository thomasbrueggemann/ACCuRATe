package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import cz.msebera.android.httpclient.conn.HttpInetSocketAddress;
import cz.msebera.android.httpclient.conn.scheme.HostNameResolver;
import cz.msebera.android.httpclient.conn.scheme.LayeredSchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.AllowAllHostnameVerifier;
import cz.msebera.android.httpclient.conn.ssl.BrowserCompatHostnameVerifier;
import cz.msebera.android.httpclient.conn.ssl.SSLContexts;
import cz.msebera.android.httpclient.conn.ssl.SSLInitializationException;
import cz.msebera.android.httpclient.conn.ssl.StrictHostnameVerifier;
import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

@Deprecated
public class SSLSocketFactory implements LayeredSchemeSocketFactory, LayeredSocketFactory, SchemeLayeredSocketFactory {
   public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
   public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
   public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
   private volatile X509HostnameVerifier hostnameVerifier;
   private final HostNameResolver nameResolver;
   private final javax.net.ssl.SSLSocketFactory socketfactory;
   private final String[] supportedCipherSuites;
   private final String[] supportedProtocols;

   public SSLSocketFactory(KeyStore var1) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
      this(SSLContexts.custom().loadTrustMaterial(var1).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
   }

   public SSLSocketFactory(SSLContext var1, X509HostnameVerifier var2) {
      this(((SSLContext)Args.notNull(var1, "SSL context")).getSocketFactory(), (String[])null, (String[])null, var2);
   }

   public SSLSocketFactory(javax.net.ssl.SSLSocketFactory var1, String[] var2, String[] var3, X509HostnameVerifier var4) {
      this.socketfactory = (javax.net.ssl.SSLSocketFactory)Args.notNull(var1, "SSL socket factory");
      this.supportedProtocols = var2;
      this.supportedCipherSuites = var3;
      if(var4 == null) {
         var4 = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
      }

      this.hostnameVerifier = var4;
      this.nameResolver = null;
   }

   public static SSLSocketFactory getSocketFactory() throws SSLInitializationException {
      return new SSLSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
   }

   private void internalPrepareSocket(SSLSocket var1) throws IOException {
      if(this.supportedProtocols != null) {
         var1.setEnabledProtocols(this.supportedProtocols);
      }

      if(this.supportedCipherSuites != null) {
         var1.setEnabledCipherSuites(this.supportedCipherSuites);
      }

      this.prepareSocket(var1);
   }

   private void verifyHostname(SSLSocket var1, String var2) throws IOException {
      try {
         this.hostnameVerifier.verify(var2, var1);
      } catch (IOException var6) {
         try {
            var1.close();
         } catch (Exception var5) {
            ;
         }

         throw var6;
      }
   }

   public Socket connectSocket(int var1, Socket var2, HttpHost var3, InetSocketAddress var4, InetSocketAddress var5, HttpContext var6) throws IOException {
      Args.notNull(var3, "HTTP host");
      Args.notNull(var4, "Remote address");
      Socket var9;
      if(var2 != null) {
         var9 = var2;
      } else {
         var9 = this.createSocket(var6);
      }

      if(var5 != null) {
         var9.bind(var5);
      }

      try {
         var9.connect(var4, var1);
      } catch (IOException var14) {
         try {
            var9.close();
         } catch (IOException var13) {
            ;
         }

         throw var14;
      }

      if(var9 instanceof SSLSocket) {
         SSLSocket var12 = (SSLSocket)var9;
         var12.startHandshake();
         this.verifyHostname(var12, var3.getHostName());
         return var9;
      } else {
         return this.createLayeredSocket(var9, var3.getHostName(), var4.getPort(), var6);
      }
   }

   public Socket connectSocket(Socket var1, String var2, int var3, InetAddress var4, int var5, HttpParams var6) throws IOException, UnknownHostException, ConnectTimeoutException {
      InetAddress var7;
      if(this.nameResolver != null) {
         var7 = this.nameResolver.resolve(var2);
      } else {
         var7 = InetAddress.getByName(var2);
      }

      InetSocketAddress var8;
      if(var4 == null) {
         var8 = null;
         if(var5 <= 0) {
            return this.connectSocket(var1, new HttpInetSocketAddress(new HttpHost(var2, var3), var7, var3), var8, var6);
         }
      }

      if(var5 <= 0) {
         var5 = 0;
      }

      var8 = new InetSocketAddress(var4, var5);
      return this.connectSocket(var1, new HttpInetSocketAddress(new HttpHost(var2, var3), var7, var3), var8, var6);
   }

   public Socket connectSocket(Socket var1, InetSocketAddress var2, InetSocketAddress var3, HttpParams var4) throws IOException, UnknownHostException, ConnectTimeoutException {
      Args.notNull(var2, "Remote address");
      Args.notNull(var4, "HTTP parameters");
      HttpHost var7;
      if(var2 instanceof HttpInetSocketAddress) {
         var7 = ((HttpInetSocketAddress)var2).getHttpHost();
      } else {
         var7 = new HttpHost(var2.getHostName(), var2.getPort(), "https");
      }

      int var8 = HttpConnectionParams.getSoTimeout(var4);
      int var9 = HttpConnectionParams.getConnectionTimeout(var4);
      var1.setSoTimeout(var8);
      return this.connectSocket(var9, var1, var7, var2, var3, (HttpContext)null);
   }

   public Socket createLayeredSocket(Socket var1, String var2, int var3, HttpParams var4) throws IOException, UnknownHostException {
      return this.createLayeredSocket(var1, var2, var3, (HttpContext)null);
   }

   public Socket createLayeredSocket(Socket var1, String var2, int var3, HttpContext var4) throws IOException {
      SSLSocket var5 = (SSLSocket)this.socketfactory.createSocket(var1, var2, var3, true);
      this.internalPrepareSocket(var5);
      var5.startHandshake();
      this.verifyHostname(var5, var2);
      return var5;
   }

   public Socket createLayeredSocket(Socket var1, String var2, int var3, boolean var4) throws IOException, UnknownHostException {
      return this.createLayeredSocket(var1, var2, var3, (HttpContext)null);
   }

   public Socket createSocket() throws IOException {
      return this.createSocket((HttpContext)null);
   }

   public Socket createSocket(HttpParams var1) throws IOException {
      return this.createSocket((HttpContext)null);
   }

   public Socket createSocket(HttpContext var1) throws IOException {
      SSLSocket var2 = (SSLSocket)this.socketfactory.createSocket();
      this.internalPrepareSocket(var2);
      return var2;
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException, UnknownHostException {
      return this.createLayeredSocket(var1, var2, var3, var4);
   }

   public boolean isSecure(Socket var1) throws IllegalArgumentException {
      Args.notNull(var1, "Socket");
      Asserts.check(var1 instanceof SSLSocket, "Socket not created by this factory");
      boolean var3;
      if(!var1.isClosed()) {
         var3 = true;
      } else {
         var3 = false;
      }

      Asserts.check(var3, "Socket is closed");
      return true;
   }

   protected void prepareSocket(SSLSocket var1) throws IOException {
   }

   public void setHostnameVerifier(X509HostnameVerifier var1) {
      Args.notNull(var1, "Hostname verifier");
      this.hostnameVerifier = var1;
   }
}
