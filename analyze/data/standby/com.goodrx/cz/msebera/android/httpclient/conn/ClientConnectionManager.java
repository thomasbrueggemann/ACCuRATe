package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

@Deprecated
public interface ClientConnectionManager {
   SchemeRegistry getSchemeRegistry();

   void releaseConnection(ManagedClientConnection var1, long var2, TimeUnit var4);

   ClientConnectionRequest requestConnection(HttpRoute var1, Object var2);

   void shutdown();
}
