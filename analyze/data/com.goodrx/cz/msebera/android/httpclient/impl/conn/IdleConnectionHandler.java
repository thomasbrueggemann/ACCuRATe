package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class IdleConnectionHandler {
   private final Map<HttpConnection, Object> connectionToTimes = new HashMap();
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   public void removeAll() {
      this.connectionToTimes.clear();
   }
}
