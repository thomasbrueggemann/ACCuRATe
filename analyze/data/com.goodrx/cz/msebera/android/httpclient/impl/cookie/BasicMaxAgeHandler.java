package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.impl.cookie.AbstractCookieAttributeHandler;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;

public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler {
   public void parse(SetCookie var1, String var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      if(var2 == null) {
         throw new MalformedCookieException("Missing value for max-age attribute");
      } else {
         int var5;
         try {
            var5 = Integer.parseInt(var2);
         } catch (NumberFormatException var6) {
            throw new MalformedCookieException("Invalid max-age attribute: " + var2);
         }

         if(var5 < 0) {
            throw new MalformedCookieException("Negative max-age attribute: " + var2);
         } else {
            var1.setExpiryDate(new Date(System.currentTimeMillis() + 1000L * (long)var5));
         }
      }
   }
}
