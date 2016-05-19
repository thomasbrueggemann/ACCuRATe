package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;

public class BasicPathHandler implements CookieAttributeHandler {
   public boolean match(Cookie var1, CookieOrigin var2) {
      Args.notNull(var1, "Cookie");
      Args.notNull(var2, "Cookie origin");
      String var5 = var2.getPath();
      String var6 = var1.getPath();
      if(var6 == null) {
         var6 = "/";
      }

      if(var6.length() > 1 && var6.endsWith("/")) {
         var6 = var6.substring(0, -1 + var6.length());
      }

      boolean var7 = var5.startsWith(var6);
      if(var7 && var5.length() != var6.length() && !var6.endsWith("/")) {
         if(var5.charAt(var6.length()) != 47) {
            return false;
         }

         var7 = true;
      }

      return var7;
   }

   public void parse(SetCookie var1, String var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      if(TextUtils.isBlank(var2)) {
         var2 = "/";
      }

      var1.setPath(var2);
   }

   public void validate(Cookie var1, CookieOrigin var2) throws MalformedCookieException {
      if(!this.match(var1, var2)) {
         throw new CookieRestrictionViolationException("Illegal path attribute \"" + var1.getPath() + "\". Path of origin: \"" + var2.getPath() + "\"");
      }
   }
}
