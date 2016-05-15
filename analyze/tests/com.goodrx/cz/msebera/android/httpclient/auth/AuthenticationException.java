package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.ProtocolException;

public class AuthenticationException extends ProtocolException {
   public AuthenticationException() {
   }

   public AuthenticationException(String var1) {
      super(var1);
   }

   public AuthenticationException(String var1, Throwable var2) {
      super(var1, var2);
   }
}
