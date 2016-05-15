package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.Configurable;
import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;

public class RequestBuilder {
   private RequestConfig config;
   private HttpEntity entity;
   private HeaderGroup headergroup;
   private String method;
   private LinkedList<NameValuePair> parameters;
   private URI uri;
   private ProtocolVersion version;

   RequestBuilder() {
      this((String)null);
   }

   RequestBuilder(String var1) {
      this.method = var1;
   }

   public static RequestBuilder copy(HttpRequest var0) {
      Args.notNull(var0, "HTTP request");
      return (new RequestBuilder()).doCopy(var0);
   }

   private RequestBuilder doCopy(HttpRequest var1) {
      if(var1 == null) {
         return this;
      } else {
         this.method = var1.getRequestLine().getMethod();
         this.version = var1.getRequestLine().getProtocolVersion();
         if(var1 instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest)var1).getURI();
         } else {
            this.uri = URI.create(var1.getRequestLine().getUri());
         }

         if(this.headergroup == null) {
            this.headergroup = new HeaderGroup();
         }

         this.headergroup.clear();
         this.headergroup.setHeaders(var1.getAllHeaders());
         if(var1 instanceof HttpEntityEnclosingRequest) {
            this.entity = ((HttpEntityEnclosingRequest)var1).getEntity();
         } else {
            this.entity = null;
         }

         if(var1 instanceof Configurable) {
            this.config = ((Configurable)var1).getConfig();
         } else {
            this.config = null;
         }

         this.parameters = null;
         return this;
      }
   }

   public HttpUriRequest build() {
      URI var1;
      if(this.uri != null) {
         var1 = this.uri;
      } else {
         var1 = URI.create("/");
      }

      Object var2 = this.entity;
      if(this.parameters != null && !this.parameters.isEmpty()) {
         if(var2 != null || !"POST".equalsIgnoreCase(this.method) && !"PUT".equalsIgnoreCase(this.method)) {
            label46: {
               URI var6;
               try {
                  var6 = (new URIBuilder(var1)).addParameters(this.parameters).build();
               } catch (URISyntaxException var7) {
                  break label46;
               }

               var1 = var6;
            }
         } else {
            var2 = new UrlEncodedFormEntity(this.parameters, HTTP.DEF_CONTENT_CHARSET);
         }
      }

      Object var3;
      if(var2 == null) {
         var3 = new RequestBuilder.InternalRequest(this.method);
      } else {
         RequestBuilder.InternalEntityEclosingRequest var4 = new RequestBuilder.InternalEntityEclosingRequest(this.method);
         var4.setEntity((HttpEntity)var2);
         var3 = var4;
      }

      ((HttpRequestBase)var3).setProtocolVersion(this.version);
      ((HttpRequestBase)var3).setURI(var1);
      if(this.headergroup != null) {
         ((HttpRequestBase)var3).setHeaders(this.headergroup.getAllHeaders());
      }

      ((HttpRequestBase)var3).setConfig(this.config);
      return (HttpUriRequest)var3;
   }

   public RequestBuilder setUri(URI var1) {
      this.uri = var1;
      return this;
   }

   static class InternalEntityEclosingRequest extends HttpEntityEnclosingRequestBase {
      private final String method;

      InternalEntityEclosingRequest(String var1) {
         this.method = var1;
      }

      public String getMethod() {
         return this.method;
      }
   }

   static class InternalRequest extends HttpRequestBase {
      private final String method;

      InternalRequest(String var1) {
         this.method = var1;
      }

      public String getMethod() {
         return this.method;
      }
   }
}
