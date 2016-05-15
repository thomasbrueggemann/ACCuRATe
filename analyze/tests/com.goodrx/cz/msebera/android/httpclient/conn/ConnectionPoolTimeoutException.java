package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.ConnectTimeoutException;

public class ConnectionPoolTimeoutException extends ConnectTimeoutException {
   public ConnectionPoolTimeoutException() {
   }

   public ConnectionPoolTimeoutException(String var1) {
      super(var1);
   }
}
