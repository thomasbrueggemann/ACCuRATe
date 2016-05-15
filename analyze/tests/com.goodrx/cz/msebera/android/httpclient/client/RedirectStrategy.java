package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

public interface RedirectStrategy {
   HttpUriRequest getRedirect(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException;

   boolean isRedirected(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException;
}
