package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.client.ClientProtocolException;

public class HttpResponseException extends ClientProtocolException {
   private final int statusCode;

   public HttpResponseException(int var1, String var2) {
      super(var2);
      this.statusCode = var1;
   }
}
