package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;

public interface ClientCookie extends Cookie {
   boolean containsAttribute(String var1);

   String getAttribute(String var1);
}
