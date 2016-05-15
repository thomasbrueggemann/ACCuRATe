package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.auth.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {
   public InvalidCredentialsException() {
   }

   public InvalidCredentialsException(String var1) {
      super(var1);
   }
}
