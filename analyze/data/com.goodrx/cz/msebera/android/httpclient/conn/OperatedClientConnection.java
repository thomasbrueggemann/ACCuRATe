package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
   Socket getSocket();

   boolean isSecure();

   void openCompleted(boolean var1, HttpParams var2) throws IOException;

   void opening(Socket var1, HttpHost var2) throws IOException;

   void update(Socket var1, HttpHost var2, boolean var3, HttpParams var4) throws IOException;
}
