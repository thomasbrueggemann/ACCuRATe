package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.impl.cookie.AbstractCookieAttributeHandler;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;

public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
   private final String[] datepatterns;

   public BasicExpiresHandler(String[] var1) {
      Args.notNull(var1, "Array of date patterns");
      this.datepatterns = var1;
   }

   public void parse(SetCookie var1, String var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      if(var2 == null) {
         throw new MalformedCookieException("Missing value for expires attribute");
      } else {
         Date var4 = DateUtils.parseDate(var2, this.datepatterns);
         if(var4 == null) {
            throw new MalformedCookieException("Unable to parse expires attribute: " + var2);
         } else {
            var1.setExpiryDate(var4);
         }
      }
   }
}
