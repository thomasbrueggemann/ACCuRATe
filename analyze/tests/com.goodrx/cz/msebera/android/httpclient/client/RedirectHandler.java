package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.URI;

@Deprecated
public interface RedirectHandler {
   URI getLocationURI(HttpResponse var1, HttpContext var2) throws ProtocolException;

   boolean isRedirectRequested(HttpResponse var1, HttpContext var2);
}
