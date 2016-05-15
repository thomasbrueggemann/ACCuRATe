package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.AuthScheme;

public interface AuthCache {
   AuthScheme get(HttpHost var1);

   void put(HttpHost var1, AuthScheme var2);

   void remove(HttpHost var1);
}
