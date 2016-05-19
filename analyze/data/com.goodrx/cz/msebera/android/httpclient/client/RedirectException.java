package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.ProtocolException;

public class RedirectException extends ProtocolException {
   public RedirectException() {
   }

   public RedirectException(String var1) {
      super(var1);
   }
}
