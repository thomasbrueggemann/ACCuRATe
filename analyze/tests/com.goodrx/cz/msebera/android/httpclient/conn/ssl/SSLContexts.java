package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.conn.ssl.SSLContextBuilder;
import cz.msebera.android.httpclient.conn.ssl.SSLInitializationException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SSLContexts {
   public static SSLContext createDefault() throws SSLInitializationException {
      try {
         SSLContext var2 = SSLContext.getInstance("TLS");
         var2.init((KeyManager[])null, (TrustManager[])null, (SecureRandom)null);
         return var2;
      } catch (NoSuchAlgorithmException var3) {
         throw new SSLInitializationException(var3.getMessage(), var3);
      } catch (KeyManagementException var4) {
         throw new SSLInitializationException(var4.getMessage(), var4);
      }
   }

   public static SSLContextBuilder custom() {
      return new SSLContextBuilder();
   }
}
