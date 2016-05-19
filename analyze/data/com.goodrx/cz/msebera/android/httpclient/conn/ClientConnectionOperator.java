package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;

@Deprecated
public interface ClientConnectionOperator {
   OperatedClientConnection createConnection();

   void openConnection(OperatedClientConnection var1, HttpHost var2, InetAddress var3, HttpContext var4, HttpParams var5) throws IOException;

   void updateSecureConnection(OperatedClientConnection var1, HttpHost var2, HttpContext var3, HttpParams var4) throws IOException;
}
