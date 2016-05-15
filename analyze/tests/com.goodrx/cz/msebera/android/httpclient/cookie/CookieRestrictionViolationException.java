package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.cookie.MalformedCookieException;

public class CookieRestrictionViolationException extends MalformedCookieException {
   public CookieRestrictionViolationException() {
   }

   public CookieRestrictionViolationException(String var1) {
      super(var1);
   }
}
