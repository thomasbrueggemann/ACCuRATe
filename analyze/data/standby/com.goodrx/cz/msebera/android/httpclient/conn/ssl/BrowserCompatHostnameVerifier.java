package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.conn.ssl.AbstractVerifier;
import javax.net.ssl.SSLException;

public class BrowserCompatHostnameVerifier extends AbstractVerifier {
   public final String toString() {
      return "BROWSER_COMPATIBLE";
   }

   boolean validCountryWildcard(String var1) {
      return true;
   }

   public final void verify(String var1, String[] var2, String[] var3) throws SSLException {
      this.verify(var1, var2, var3, false);
   }
}
