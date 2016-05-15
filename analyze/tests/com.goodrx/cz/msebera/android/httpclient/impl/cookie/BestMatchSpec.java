package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec;
import cz.msebera.android.httpclient.impl.cookie.NetscapeDraftHeaderParser;
import cz.msebera.android.httpclient.impl.cookie.RFC2109Spec;
import cz.msebera.android.httpclient.impl.cookie.RFC2965Spec;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Iterator;
import java.util.List;

public class BestMatchSpec implements CookieSpec {
   private BrowserCompatSpec compat;
   private final String[] datepatterns;
   private RFC2109Spec obsoleteStrict;
   private final boolean oneHeader;
   private RFC2965Spec strict;

   public BestMatchSpec() {
      this((String[])null, false);
   }

   public BestMatchSpec(String[] var1, boolean var2) {
      String[] var3;
      if(var1 == null) {
         var3 = null;
      } else {
         var3 = (String[])var1.clone();
      }

      this.datepatterns = var3;
      this.oneHeader = var2;
   }

   private BrowserCompatSpec getCompat() {
      if(this.compat == null) {
         this.compat = new BrowserCompatSpec(this.datepatterns);
      }

      return this.compat;
   }

   private RFC2109Spec getObsoleteStrict() {
      if(this.obsoleteStrict == null) {
         this.obsoleteStrict = new RFC2109Spec(this.datepatterns, this.oneHeader);
      }

      return this.obsoleteStrict;
   }

   private RFC2965Spec getStrict() {
      if(this.strict == null) {
         this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
      }

      return this.strict;
   }

   public List<Header> formatCookies(List<Cookie> var1) {
      Args.notNull(var1, "List of cookies");
      int var3 = Integer.MAX_VALUE;
      boolean var4 = true;
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Cookie var6 = (Cookie)var5.next();
         if(!(var6 instanceof SetCookie2)) {
            var4 = false;
         }

         if(var6.getVersion() < var3) {
            var3 = var6.getVersion();
         }
      }

      if(var3 > 0) {
         if(var4) {
            return this.getStrict().formatCookies(var1);
         } else {
            return this.getObsoleteStrict().formatCookies(var1);
         }
      } else {
         return this.getCompat().formatCookies(var1);
      }
   }

   public int getVersion() {
      return this.getStrict().getVersion();
   }

   public Header getVersionHeader() {
      return this.getStrict().getVersionHeader();
   }

   public boolean match(Cookie var1, CookieOrigin var2) {
      Args.notNull(var1, "Cookie");
      Args.notNull(var2, "Cookie origin");
      return var1.getVersion() > 0?(var1 instanceof SetCookie2?this.getStrict().match(var1, var2):this.getObsoleteStrict().match(var1, var2)):this.getCompat().match(var1, var2);
   }

   public List<Cookie> parse(Header var1, CookieOrigin var2) throws MalformedCookieException {
      Args.notNull(var1, "Header");
      Args.notNull(var2, "Cookie origin");
      HeaderElement[] var5 = var1.getElements();
      boolean var6 = false;
      boolean var7 = false;
      int var8 = var5.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         HeaderElement var15 = var5[var9];
         if(var15.getParameterByName("version") != null) {
            var6 = true;
         }

         if(var15.getParameterByName("expires") != null) {
            var7 = true;
         }
      }

      if(!var7 && var6) {
         if("Set-Cookie2".equals(var1.getName())) {
            return this.getStrict().parse(var5, var2);
         } else {
            return this.getObsoleteStrict().parse(var5, var2);
         }
      } else {
         NetscapeDraftHeaderParser var10 = NetscapeDraftHeaderParser.DEFAULT;
         CharArrayBuffer var12;
         ParserCursor var13;
         if(var1 instanceof FormattedHeader) {
            var12 = ((FormattedHeader)var1).getBuffer();
            var13 = new ParserCursor(((FormattedHeader)var1).getValuePos(), var12.length());
         } else {
            String var11 = var1.getValue();
            if(var11 == null) {
               throw new MalformedCookieException("Header value is null");
            }

            var12 = new CharArrayBuffer(var11.length());
            var12.append(var11);
            var13 = new ParserCursor(0, var12.length());
         }

         HeaderElement[] var14 = new HeaderElement[]{var10.parseHeader(var12, var13)};
         return this.getCompat().parse(var14, var2);
      }
   }

   public String toString() {
      return "best-match";
   }

   public void validate(Cookie var1, CookieOrigin var2) throws MalformedCookieException {
      Args.notNull(var1, "Cookie");
      Args.notNull(var2, "Cookie origin");
      if(var1.getVersion() > 0) {
         if(var1 instanceof SetCookie2) {
            this.getStrict().validate(var1, var2);
         } else {
            this.getObsoleteStrict().validate(var1, var2);
         }
      } else {
         this.getCompat().validate(var1, var2);
      }
   }
}
