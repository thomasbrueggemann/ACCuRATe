package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

public interface BackoffManager {
   void backOff(HttpRoute var1);

   void probe(HttpRoute var1);
}
