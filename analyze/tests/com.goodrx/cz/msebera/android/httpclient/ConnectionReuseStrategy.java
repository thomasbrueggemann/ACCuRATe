package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;

public interface ConnectionReuseStrategy {
   boolean keepAlive(HttpResponse var1, HttpContext var2);
}
