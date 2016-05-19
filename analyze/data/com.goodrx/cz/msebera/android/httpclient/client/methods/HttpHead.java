package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.client.methods.HttpRequestBase;
import java.net.URI;

public class HttpHead extends HttpRequestBase {
   public HttpHead() {
   }

   public HttpHead(URI var1) {
      this.setURI(var1);
   }

   public String getMethod() {
      return "HEAD";
   }
}
