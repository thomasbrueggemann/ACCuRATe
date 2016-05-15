package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieIdentityComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class BasicCookieStore implements CookieStore, Serializable {
   private final TreeSet<Cookie> cookies = new TreeSet(new CookieIdentityComparator());

   public void addCookie(Cookie var1) {
      synchronized(this){}
      if(var1 != null) {
         try {
            this.cookies.remove(var1);
            if(!var1.isExpired(new Date())) {
               this.cookies.add(var1);
            }
         } finally {
            ;
         }
      }

   }

   public List<Cookie> getCookies() {
      synchronized(this){}

      ArrayList var1;
      try {
         var1 = new ArrayList(this.cookies);
      } finally {
         ;
      }

      return var1;
   }

   public String toString() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.cookies.toString();
      } finally {
         ;
      }

      return var2;
   }
}
