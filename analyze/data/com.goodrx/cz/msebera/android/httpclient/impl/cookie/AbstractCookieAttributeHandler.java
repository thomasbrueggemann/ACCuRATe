package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;

public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
   public boolean match(Cookie var1, CookieOrigin var2) {
      return true;
   }

   public void validate(Cookie var1, CookieOrigin var2) throws MalformedCookieException {
   }
}
