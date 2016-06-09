package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.impl.cookie.AbstractCookieAttributeHandler;
import cz.msebera.android.httpclient.util.Args;

public class BasicSecureHandler extends AbstractCookieAttributeHandler {
   public boolean match(Cookie var1, CookieOrigin var2) {
      Args.notNull(var1, "Cookie");
      Args.notNull(var2, "Cookie origin");
      return !var1.isSecure() || var2.isSecure();
   }

   public void parse(SetCookie var1, String var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      var1.setSecure(true);
   }
}
