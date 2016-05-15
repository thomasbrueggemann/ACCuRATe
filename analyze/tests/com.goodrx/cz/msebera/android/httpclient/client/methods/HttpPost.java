package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import java.net.URI;

public class HttpPost extends HttpEntityEnclosingRequestBase {
   public HttpPost() {
   }

   public HttpPost(URI var1) {
      this.setURI(var1);
   }

   public String getMethod() {
      return "POST";
   }
}
