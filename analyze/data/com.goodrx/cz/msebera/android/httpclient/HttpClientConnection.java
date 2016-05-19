package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import java.io.IOException;

public interface HttpClientConnection extends HttpConnection {
   void flush() throws IOException;

   boolean isResponseAvailable(int var1) throws IOException;

   void receiveResponseEntity(HttpResponse var1) throws HttpException, IOException;

   HttpResponse receiveResponseHeader() throws HttpException, IOException;

   void sendRequestEntity(HttpEntityEnclosingRequest var1) throws HttpException, IOException;

   void sendRequestHeader(HttpRequest var1) throws HttpException, IOException;
}
