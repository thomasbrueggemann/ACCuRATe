package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

public interface HttpRequestInterceptor {
   void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException;
}
