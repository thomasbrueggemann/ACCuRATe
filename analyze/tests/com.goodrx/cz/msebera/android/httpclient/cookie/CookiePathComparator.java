package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import java.io.Serializable;
import java.util.Comparator;

public class CookiePathComparator implements Serializable, Comparator<Cookie> {
   private String normalizePath(Cookie var1) {
      String var2 = var1.getPath();
      if(var2 == null) {
         var2 = "/";
      }

      if(!var2.endsWith("/")) {
         var2 = var2 + '/';
      }

      return var2;
   }

   public int compare(Cookie var1, Cookie var2) {
      String var3 = this.normalizePath(var1);
      String var4 = this.normalizePath(var2);
      if(!var3.equals(var4)) {
         if(var3.startsWith(var4)) {
            return -1;
         }

         if(var4.startsWith(var3)) {
            return 1;
         }
      }

      return 0;
   }
}
