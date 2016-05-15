package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpException;

public class ProtocolException extends HttpException {
   public ProtocolException() {
   }

   public ProtocolException(String var1) {
      super(var1);
   }

   public ProtocolException(String var1, Throwable var2) {
      super(var1, var2);
   }
}
