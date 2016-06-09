package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Deprecated
public interface ManagedClientConnection extends HttpClientConnection, ConnectionReleaseTrigger, HttpRoutedConnection, ManagedHttpClientConnection {
   HttpRoute getRoute();

   void layerProtocol(HttpContext var1, HttpParams var2) throws IOException;

   void markReusable();

   void open(HttpRoute var1, HttpContext var2, HttpParams var3) throws IOException;

   void setIdleDuration(long var1, TimeUnit var3);

   void setState(Object var1);

   void tunnelProxy(HttpHost var1, boolean var2, HttpParams var3) throws IOException;

   void tunnelTarget(boolean var1, HttpParams var2) throws IOException;

   void unmarkReusable();
}
