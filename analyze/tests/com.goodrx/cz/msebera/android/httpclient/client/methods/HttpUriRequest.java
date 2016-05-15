package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.HttpRequest;
import java.net.URI;

public interface HttpUriRequest extends HttpRequest {
   String getMethod();

   URI getURI();

   boolean isAborted();
}
