package cz.msebera.android.httpclient.client;

import java.io.IOException;

public class ClientProtocolException extends IOException {
   public ClientProtocolException() {
   }

   public ClientProtocolException(String var1) {
      super(var1);
   }

   public ClientProtocolException(Throwable var1) {
      this.initCause(var1);
   }
}
