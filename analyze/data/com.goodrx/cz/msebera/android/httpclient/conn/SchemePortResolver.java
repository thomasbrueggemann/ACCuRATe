package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;

public interface SchemePortResolver {
   int resolve(HttpHost var1) throws UnsupportedSchemeException;
}
