package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import java.io.Serializable;
import java.util.Comparator;

public class CookieIdentityComparator implements Serializable, Comparator<Cookie> {
   public int compare(Cookie var1, Cookie var2) {
      int var3 = var1.getName().compareTo(var2.getName());
      if(var3 == 0) {
         String var6 = var1.getDomain();
         if(var6 == null) {
            var6 = "";
         } else if(var6.indexOf(46) == -1) {
            var6 = var6 + ".local";
         }

         String var7 = var2.getDomain();
         if(var7 == null) {
            var7 = "";
         } else if(var7.indexOf(46) == -1) {
            var7 = var7 + ".local";
         }

         var3 = var6.compareToIgnoreCase(var7);
      }

      if(var3 == 0) {
         String var4 = var1.getPath();
         if(var4 == null) {
            var4 = "/";
         }

         String var5 = var2.getPath();
         if(var5 == null) {
            var5 = "/";
         }

         var3 = var4.compareTo(var5);
      }

      return var3;
   }
}
