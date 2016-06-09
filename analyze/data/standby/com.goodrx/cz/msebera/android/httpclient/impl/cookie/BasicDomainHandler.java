package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;

public class BasicDomainHandler implements CookieAttributeHandler {
   public boolean match(Cookie var1, CookieOrigin var2) {
      Args.notNull(var1, "Cookie");
      Args.notNull(var2, "Cookie origin");
      String var5 = var2.getHost();
      String var6 = var1.getDomain();
      if(var6 != null) {
         if(var5.equals(var6)) {
            return true;
         }

         if(!var6.startsWith(".")) {
            var6 = '.' + var6;
         }

         if(var5.endsWith(var6) || var5.equals(var6.substring(1))) {
            return true;
         }
      }

      return false;
   }

   public void parse(SetCookie var1, String var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      if(var2 == null) {
         throw new MalformedCookieException("Missing value for domain attribute");
      } else if(var2.trim().length() == 0) {
         throw new MalformedCookieException("Blank value for domain attribute");
      } else {
         var1.setDomain(var2);
      }
   }

   public void validate(Cookie var1, CookieOrigin var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      Args.notNull(var2, "Cookie origin");
      String var5 = var2.getHost();
      String var6 = var1.getDomain();
      if(var6 == null) {
         throw new CookieRestrictionViolationException("Cookie domain may not be null");
      } else {
         if(var5.contains(".")) {
            if(!var5.endsWith(var6)) {
               if(var6.startsWith(".")) {
                  var6 = var6.substring(1, var6.length());
               }

               if(!var5.equals(var6)) {
                  throw new CookieRestrictionViolationException("Illegal domain attribute \"" + var6 + "\". Domain of origin: \"" + var5 + "\"");
               }
            }
         } else if(!var5.equals(var6)) {
            throw new CookieRestrictionViolationException("Illegal domain attribute \"" + var6 + "\". Domain of origin: \"" + var5 + "\"");
         }

      }
   }
}
