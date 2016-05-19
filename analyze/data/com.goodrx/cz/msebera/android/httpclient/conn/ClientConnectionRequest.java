package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import java.util.concurrent.TimeUnit;

@Deprecated
public interface ClientConnectionRequest {
   ManagedClientConnection getConnection(long var1, TimeUnit var3) throws InterruptedException, ConnectionPoolTimeoutException;
}
