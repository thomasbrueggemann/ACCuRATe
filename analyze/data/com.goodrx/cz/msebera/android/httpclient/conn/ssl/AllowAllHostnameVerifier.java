package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.conn.ssl.AbstractVerifier;

public class AllowAllHostnameVerifier extends AbstractVerifier {
   public final String toString() {
      return "ALLOW_ALL";
   }

   public final void verify(String var1, String[] var2, String[] var3) {
   }
}
