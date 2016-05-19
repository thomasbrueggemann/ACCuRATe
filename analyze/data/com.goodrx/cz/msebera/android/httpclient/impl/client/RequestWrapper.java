package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
   private int execCount;
   private String method;
   private final HttpRequest original;
   private URI uri;
   private ProtocolVersion version;

   public RequestWrapper(HttpRequest var1) throws ProtocolException {
      Args.notNull(var1, "HTTP request");
      this.original = var1;
      this.setParams(var1.getParams());
      this.setHeaders(var1.getAllHeaders());
      if(var1 instanceof HttpUriRequest) {
         this.uri = ((HttpUriRequest)var1).getURI();
         this.method = ((HttpUriRequest)var1).getMethod();
         this.version = null;
      } else {
         RequestLine var3 = var1.getRequestLine();

         try {
            this.uri = new URI(var3.getUri());
         } catch (URISyntaxException var5) {
            throw new ProtocolException("Invalid request URI: " + var3.getUri(), var5);
         }

         this.method = var3.getMethod();
         this.version = var1.getProtocolVersion();
      }

      this.execCount = 0;
   }

   public int getExecCount() {
      return this.execCount;
   }

   public String getMethod() {
      return this.method;
   }

   public HttpRequest getOriginal() {
      return this.original;
   }

   public ProtocolVersion getProtocolVersion() {
      if(this.version == null) {
         this.version = HttpProtocolParams.getVersion(this.getParams());
      }

      return this.version;
   }

   public RequestLine getRequestLine() {
      String var1 = this.getMethod();
      ProtocolVersion var2 = this.getProtocolVersion();
      URI var3 = this.uri;
      String var4 = null;
      if(var3 != null) {
         var4 = this.uri.toASCIIString();
      }

      if(var4 == null || var4.length() == 0) {
         var4 = "/";
      }

      return new BasicRequestLine(var1, var4, var2);
   }

   public URI getURI() {
      return this.uri;
   }

   public void incrementExecCount() {
      ++this.execCount;
   }

   public boolean isAborted() {
      return false;
   }

   public boolean isRepeatable() {
      return true;
   }

   public void resetHeaders() {
      this.headergroup.clear();
      this.setHeaders(this.original.getAllHeaders());
   }

   public void setURI(URI var1) {
      this.uri = var1;
   }
}
