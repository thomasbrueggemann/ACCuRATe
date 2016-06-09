package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

@Deprecated
public interface RequestDirector {
   HttpResponse execute(HttpHost var1, HttpRequest var2, HttpContext var3) throws HttpException, IOException;
}
