package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.protocol.HttpContext;

public interface HttpRoutePlanner {
   HttpRoute determineRoute(HttpHost var1, HttpRequest var2, HttpContext var3) throws HttpException;
}
