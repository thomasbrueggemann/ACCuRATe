package com.loopj.android.http;

import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MySSLSocketFactory extends SSLSocketFactory {
   final SSLContext sslContext = SSLContext.getInstance("TLS");

   public MySSLSocketFactory(KeyStore var1) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
      super(var1);
      X509TrustManager var2 = new X509TrustManager() {
         public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         }

         public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         }

         public X509Certificate[] getAcceptedIssuers() {
            return null;
         }
      };
      this.sslContext.init((KeyManager[])null, new TrustManager[]{var2}, (SecureRandom)null);
   }

   public static SSLSocketFactory getFixedSocketFactory() {
      try {
         MySSLSocketFactory var0 = new MySSLSocketFactory(getKeystore());
         var0.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
         return var0;
      } catch (Throwable var2) {
         var2.printStackTrace();
         return SSLSocketFactory.getSocketFactory();
      }
   }

   public static KeyStore getKeystore() {
      KeyStore var0 = null;

      try {
         var0 = KeyStore.getInstance(KeyStore.getDefaultType());
         var0.load((InputStream)null, (char[])null);
         return var0;
      } catch (Throwable var2) {
         var2.printStackTrace();
         return var0;
      }
   }

   public Socket createSocket() throws IOException {
      return this.sslContext.getSocketFactory().createSocket();
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      return this.sslContext.getSocketFactory().createSocket(var1, var2, var3, var4);
   }
}
