package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.cookie.Cookie;
import java.util.List;

public interface CookieStore {
   void addCookie(Cookie var1);

   List<Cookie> getCookies();
}
