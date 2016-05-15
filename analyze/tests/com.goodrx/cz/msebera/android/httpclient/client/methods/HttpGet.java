package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.client.methods.HttpRequestBase;
import java.net.URI;

public class HttpGet extends HttpRequestBase {
   public HttpGet() {
   }

   public HttpGet(String var1) {
      this.setURI(URI.create(var1));
   }

   public HttpGet(URI var1) {
      this.setURI(var1);
   }

   public String getMethod() {
      return "GET";
   }
}
