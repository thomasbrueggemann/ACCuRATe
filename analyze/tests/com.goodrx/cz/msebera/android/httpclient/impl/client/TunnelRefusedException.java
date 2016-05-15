package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;

@Deprecated
public class TunnelRefusedException extends HttpException {
   private final HttpResponse response;

   public TunnelRefusedException(String var1, HttpResponse var2) {
      super(var1);
      this.response = var2;
   }

   public HttpResponse getResponse() {
      return this.response;
   }
}
