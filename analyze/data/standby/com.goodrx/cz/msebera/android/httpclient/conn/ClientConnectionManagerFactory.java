package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
public interface ClientConnectionManagerFactory {
   ClientConnectionManager newInstance(HttpParams var1, SchemeRegistry var2);
}
