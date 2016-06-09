package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import java.io.InterruptedIOException;

public class ConnectTimeoutException extends InterruptedIOException {
   private final HttpHost host = null;

   public ConnectTimeoutException() {
   }

   public ConnectTimeoutException(String var1) {
      super(var1);
   }
}
