package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.ProtocolException;

public class MalformedChallengeException extends ProtocolException {
   public MalformedChallengeException() {
   }

   public MalformedChallengeException(String var1) {
      super(var1);
   }
}
