package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;

public interface HttpClient {
   HttpResponse execute(HttpUriRequest var1) throws IOException, ClientProtocolException;

   @Deprecated
   HttpParams getParams();
}
