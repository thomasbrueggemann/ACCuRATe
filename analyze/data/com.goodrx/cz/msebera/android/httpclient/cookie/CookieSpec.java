package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import java.util.List;

public interface CookieSpec {
   List<Header> formatCookies(List<Cookie> var1);

   int getVersion();

   Header getVersionHeader();

   boolean match(Cookie var1, CookieOrigin var2);

   List<Cookie> parse(Header var1, CookieOrigin var2) throws MalformedCookieException;

   void validate(Cookie var1, CookieOrigin var2) throws MalformedCookieException;
}
