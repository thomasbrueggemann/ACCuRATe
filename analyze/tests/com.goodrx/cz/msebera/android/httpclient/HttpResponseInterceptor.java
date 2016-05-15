package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

public interface HttpResponseInterceptor {
   void process(HttpResponse var1, HttpContext var2) throws HttpException, IOException;
}
