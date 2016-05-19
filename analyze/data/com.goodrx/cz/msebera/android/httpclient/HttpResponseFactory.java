package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.protocol.HttpContext;

public interface HttpResponseFactory {
   HttpResponse newHttpResponse(StatusLine var1, HttpContext var2);
}
