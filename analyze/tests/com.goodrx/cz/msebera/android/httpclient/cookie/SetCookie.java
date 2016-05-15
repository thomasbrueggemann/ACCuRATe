package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import java.util.Date;

public interface SetCookie extends Cookie {
   void setComment(String var1);

   void setDomain(String var1);

   void setExpiryDate(Date var1);

   void setPath(String var1);

   void setSecure(boolean var1);

   void setVersion(int var1);
}
