package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.auth.AuthenticationException;

public class NTLMEngineException extends AuthenticationException {
   public NTLMEngineException() {
   }

   public NTLMEngineException(String var1) {
      super(var1);
   }

   public NTLMEngineException(String var1, Throwable var2) {
      super(var1, var2);
   }
}
