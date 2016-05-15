package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.conn.ssl.TrustStrategy;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SSLContextBuilder {
   private Set<KeyManager> keymanagers = new HashSet();
   private String protocol;
   private SecureRandom secureRandom;
   private Set<TrustManager> trustmanagers = new HashSet();

   public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
      String var1;
      if(this.protocol != null) {
         var1 = this.protocol;
      } else {
         var1 = "TLS";
      }

      SSLContext var2 = SSLContext.getInstance(var1);
      KeyManager[] var3;
      if(!this.keymanagers.isEmpty()) {
         var3 = (KeyManager[])this.keymanagers.toArray(new KeyManager[this.keymanagers.size()]);
      } else {
         var3 = null;
      }

      TrustManager[] var4;
      if(!this.trustmanagers.isEmpty()) {
         var4 = (TrustManager[])this.trustmanagers.toArray(new TrustManager[this.trustmanagers.size()]);
      } else {
         var4 = null;
      }

      var2.init(var3, var4, this.secureRandom);
      return var2;
   }

   public SSLContextBuilder loadTrustMaterial(KeyStore var1) throws NoSuchAlgorithmException, KeyStoreException {
      return this.loadTrustMaterial(var1, (TrustStrategy)null);
   }

   public SSLContextBuilder loadTrustMaterial(KeyStore var1, TrustStrategy var2) throws NoSuchAlgorithmException, KeyStoreException {
      TrustManagerFactory var3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      var3.init(var1);
      TrustManager[] var4 = var3.getTrustManagers();
      if(var4 != null) {
         if(var2 != null) {
            for(int var9 = 0; var9 < var4.length; ++var9) {
               TrustManager var10 = var4[var9];
               if(var10 instanceof X509TrustManager) {
                  var4[var9] = new SSLContextBuilder.TrustManagerDelegate((X509TrustManager)var10, var2);
               }
            }
         }

         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            TrustManager var7 = var4[var6];
            this.trustmanagers.add(var7);
         }
      }

      return this;
   }

   static class TrustManagerDelegate implements X509TrustManager {
      private final X509TrustManager trustManager;
      private final TrustStrategy trustStrategy;

      TrustManagerDelegate(X509TrustManager var1, TrustStrategy var2) {
         this.trustManager = var1;
         this.trustStrategy = var2;
      }

      public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         this.trustManager.checkClientTrusted(var1, var2);
      }

      public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         if(!this.trustStrategy.isTrusted(var1, var2)) {
            this.trustManager.checkServerTrusted(var1, var2);
         }

      }

      public X509Certificate[] getAcceptedIssuers() {
         return this.trustManager.getAcceptedIssuers();
      }
   }
}
