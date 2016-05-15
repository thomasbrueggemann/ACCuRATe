package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.parse.ParseHttpClient;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class ParseApacheHttpClient extends ParseHttpClient<HttpUriRequest, HttpResponse> {
   private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
   private DefaultHttpClient apacheClient;

   public ParseApacheHttpClient(int var1, SSLSessionCache var2) {
      BasicHttpParams var3 = new BasicHttpParams();
      HttpConnectionParams.setStaleCheckingEnabled(var3, false);
      HttpConnectionParams.setConnectionTimeout(var3, var1);
      HttpConnectionParams.setSoTimeout(var3, var1);
      HttpConnectionParams.setSocketBufferSize(var3, 8192);
      HttpClientParams.setRedirecting(var3, false);
      SchemeRegistry var4 = new SchemeRegistry();
      var4.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      var4.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(var1, var2), 443));
      String var7 = System.getProperty("http.maxConnections");
      if(var7 != null) {
         int var11 = Integer.parseInt(var7);
         ConnManagerParams.setMaxConnectionsPerRoute(var3, new ConnPerRouteBean(var11));
         ConnManagerParams.setMaxTotalConnections(var3, var11);
      }

      String var8 = System.getProperty("http.proxyHost");
      String var9 = System.getProperty("http.proxyPort");
      if(var8 != null && var8.length() != 0 && var9 != null && var9.length() != 0) {
         var3.setParameter("http.route.default-proxy", new HttpHost(var8, Integer.parseInt(var9), "http"));
      }

      this.apacheClient = new DefaultHttpClient(new ThreadSafeClientConnManager(var3, var4), var3);
      this.apacheClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
   }

   ParseHttpResponse executeInternal(ParseHttpRequest var1) throws IOException {
      HttpUriRequest var2 = this.getRequest(var1);
      DefaultHttpClient var3 = this.apacheClient;
      HttpResponse var4;
      if(!(var3 instanceof HttpClient)) {
         var4 = var3.execute(var2);
      } else {
         var4 = HttpInstrumentation.execute((HttpClient)var3, var2);
      }

      return this.getResponse(var4);
   }

   HttpUriRequest getRequest(ParseHttpRequest var1) throws IOException {
      if(var1 == null) {
         throw new IllegalArgumentException("ParseHttpRequest passed to getApacheRequest should not be null.");
      } else {
         ParseHttpRequest.Method var2 = var1.getMethod();
         String var3 = var1.getUrl();
         Object var4;
         switch(null.$SwitchMap$com$parse$http$ParseHttpRequest$Method[var2.ordinal()]) {
         case 1:
            var4 = new HttpGet(var3);
            break;
         case 2:
            var4 = new HttpDelete(var3);
            break;
         case 3:
            var4 = new HttpPost(var3);
            break;
         case 4:
            var4 = new HttpPut(var3);
            break;
         default:
            throw new IllegalStateException("Unsupported http method " + var2.toString());
         }

         Iterator var5 = var1.getAllHeaders().entrySet().iterator();

         while(var5.hasNext()) {
            Entry var7 = (Entry)var5.next();
            ((HttpUriRequest)var4).setHeader((String)var7.getKey(), (String)var7.getValue());
         }

         AndroidHttpClient.modifyRequestToAcceptGzipResponse((HttpRequest)var4);
         ParseHttpBody var6 = var1.getBody();
         switch(null.$SwitchMap$com$parse$http$ParseHttpRequest$Method[var2.ordinal()]) {
         case 3:
            ((HttpPost)var4).setEntity(new ParseApacheHttpClient.ParseApacheHttpEntity(var6));
            return (HttpUriRequest)var4;
         case 4:
            ((HttpPut)var4).setEntity(new ParseApacheHttpClient.ParseApacheHttpEntity(var6));
            return (HttpUriRequest)var4;
         default:
            return (HttpUriRequest)var4;
         }
      }
   }

   ParseHttpResponse getResponse(HttpResponse var1) throws IOException {
      if(var1 == null) {
         throw new IllegalArgumentException("HttpResponse passed to getResponse should not be null.");
      } else {
         int var2 = var1.getStatusLine().getStatusCode();
         InputStream var3;
         if(this.disableHttpLibraryAutoDecompress()) {
            var3 = var1.getEntity().getContent();
         } else {
            var3 = AndroidHttpClient.getUngzippedContent(var1.getEntity());
         }

         int var4 = -1;
         Header[] var5 = var1.getHeaders("Content-Length");
         if(var5.length > 0) {
            var4 = Integer.parseInt(var5[0].getValue());
         }

         String var6 = var1.getStatusLine().getReasonPhrase();
         HashMap var7 = new HashMap();
         Header[] var8 = var1.getAllHeaders();
         int var9 = var8.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            Header var15 = var8[var10];
            var7.put(var15.getName(), var15.getValue());
         }

         if(!this.disableHttpLibraryAutoDecompress()) {
            var7.remove("Content-Encoding");
         }

         HttpEntity var11 = var1.getEntity();
         String var12 = null;
         if(var11 != null) {
            Header var13 = var11.getContentType();
            var12 = null;
            if(var13 != null) {
               var12 = var11.getContentType().getValue();
            }
         }

         return (new ParseHttpResponse.Builder()).setStatusCode(var2).setContent(var3).setTotalSize((long)var4).setReasonPhrase(var6).setHeaders(var7).setContentType(var12).build();
      }
   }

   private static class ParseApacheHttpEntity extends InputStreamEntity {
      private ParseHttpBody parseBody;

      public ParseApacheHttpEntity(ParseHttpBody var1) throws IOException {
         super(var1.getContent(), var1.getContentLength());
         super.setContentType(var1.getContentType());
         this.parseBody = var1;
      }

      public void writeTo(OutputStream var1) throws IOException {
         this.parseBody.writeTo(var1);
      }
   }
}
