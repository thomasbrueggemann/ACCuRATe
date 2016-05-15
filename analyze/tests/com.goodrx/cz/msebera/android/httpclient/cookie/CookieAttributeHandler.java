package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;

public interface CookieAttributeHandler {
   boolean match(Cookie var1, CookieOrigin var2);

   void parse(SetCookie var1, String var2) throws MalformedCookieException;

   void validate(Cookie var1, CookieOrigin var2) throws MalformedCookieException;
}
