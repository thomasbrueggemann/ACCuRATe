package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.AbstractExecutionAwareRequest;
import cz.msebera.android.httpclient.client.methods.Configurable;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import java.net.URI;

public abstract class HttpRequestBase extends AbstractExecutionAwareRequest implements Configurable, HttpUriRequest {
   private RequestConfig config;
   private URI uri;
   private ProtocolVersion version;

   public RequestConfig getConfig() {
      return this.config;
   }

   public abstract String getMethod();

   public ProtocolVersion getProtocolVersion() {
      return this.version != null?this.version:HttpProtocolParams.getVersion(this.getParams());
   }

   public RequestLine getRequestLine() {
      String var1 = this.getMethod();
      ProtocolVersion var2 = this.getProtocolVersion();
      URI var3 = this.getURI();
      String var4 = null;
      if(var3 != null) {
         var4 = var3.toASCIIString();
      }

      if(var4 == null || var4.length() == 0) {
         var4 = "/";
      }

      return new BasicRequestLine(var1, var4, var2);
   }

   public URI getURI() {
      return this.uri;
   }

   public void setConfig(RequestConfig var1) {
      this.config = var1;
   }

   public void setProtocolVersion(ProtocolVersion var1) {
      this.version = var1;
   }

   public void setURI(URI var1) {
      this.uri = var1;
   }

   public String toString() {
      return this.getMethod() + " " + this.getURI() + " " + this.getProtocolVersion();
   }
}
