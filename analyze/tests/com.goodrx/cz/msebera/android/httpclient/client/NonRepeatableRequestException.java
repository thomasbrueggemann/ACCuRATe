package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.ProtocolException;

public class NonRepeatableRequestException extends ProtocolException {
   public NonRepeatableRequestException() {
   }

   public NonRepeatableRequestException(String var1) {
      super(var1);
   }

   public NonRepeatableRequestException(String var1, Throwable var2) {
      super(var1, var2);
   }
}
