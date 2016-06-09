package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;

public abstract class CloseableHttpClient implements HttpClient, Closeable {
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   private static HttpHost determineTarget(HttpUriRequest var0) throws ClientProtocolException {
      URI var1 = var0.getURI();
      boolean var2 = var1.isAbsolute();
      HttpHost var3 = null;
      if(var2) {
         var3 = URIUtils.extractHost(var1);
         if(var3 == null) {
            throw new ClientProtocolException("URI does not specify a valid host name: " + var1);
         }
      }

      return var3;
   }

   protected abstract CloseableHttpResponse doExecute(HttpHost var1, HttpRequest var2, HttpContext var3) throws IOException, ClientProtocolException;

   public CloseableHttpResponse execute(HttpUriRequest var1) throws IOException, ClientProtocolException {
      return this.execute(var1, (HttpContext)null);
   }

   public CloseableHttpResponse execute(HttpUriRequest var1, HttpContext var2) throws IOException, ClientProtocolException {
      Args.notNull(var1, "HTTP request");
      return this.doExecute(determineTarget(var1), var1, var2);
   }
}
