package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.impl.cookie.BestMatchSpec;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;

public class BestMatchSpecFactory implements CookieSpecFactory, CookieSpecProvider {
   private final String[] datepatterns;
   private final boolean oneHeader;

   public BestMatchSpecFactory() {
      this((String[])null, false);
   }

   public BestMatchSpecFactory(String[] var1, boolean var2) {
      this.datepatterns = var1;
      this.oneHeader = var2;
   }

   public CookieSpec create(HttpContext var1) {
      return new BestMatchSpec(this.datepatterns, this.oneHeader);
   }

   public CookieSpec newInstance(HttpParams var1) {
      if(var1 != null) {
         Collection var2 = (Collection)var1.getParameter("http.protocol.cookie-datepatterns");
         String[] var3 = null;
         if(var2 != null) {
            var3 = (String[])var2.toArray(new String[var2.size()]);
         }

         return new BestMatchSpec(var3, var1.getBooleanParameter("http.protocol.single-cookie-header", false));
      } else {
         return new BestMatchSpec();
      }
   }
}
