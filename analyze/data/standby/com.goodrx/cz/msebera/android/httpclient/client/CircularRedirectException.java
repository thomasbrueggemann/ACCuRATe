package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.client.RedirectException;

public class CircularRedirectException extends RedirectException {
   public CircularRedirectException() {
   }

   public CircularRedirectException(String var1) {
      super(var1);
   }
}
