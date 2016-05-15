package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.LangUtils;
import java.util.Locale;

public class AuthScope {
   public static final AuthScope ANY;
   public static final String ANY_HOST = null;
   public static final String ANY_REALM = null;
   public static final String ANY_SCHEME = null;
   private final String host;
   private final int port;
   private final String realm;
   private final String scheme;

   static {
      ANY = new AuthScope(ANY_HOST, -1, ANY_REALM, ANY_SCHEME);
   }

   public AuthScope(HttpHost var1, String var2, String var3) {
      this(var1.getHostName(), var1.getPort(), var2, var3);
   }

   public AuthScope(String var1, int var2) {
      this(var1, var2, ANY_REALM, ANY_SCHEME);
   }

   public AuthScope(String var1, int var2, String var3, String var4) {
      String var5;
      if(var1 == null) {
         var5 = ANY_HOST;
      } else {
         var5 = var1.toLowerCase(Locale.ENGLISH);
      }

      this.host = var5;
      if(var2 < 0) {
         var2 = -1;
      }

      this.port = var2;
      if(var3 == null) {
         var3 = ANY_REALM;
      }

      this.realm = var3;
      String var6;
      if(var4 == null) {
         var6 = ANY_SCHEME;
      } else {
         var6 = var4.toUpperCase(Locale.ENGLISH);
      }

      this.scheme = var6;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 == null) {
         var2 = false;
      } else if(var1 != this) {
         if(!(var1 instanceof AuthScope)) {
            return super.equals(var1);
         }

         AuthScope var3 = (AuthScope)var1;
         if(!LangUtils.equals(this.host, var3.host) || this.port != var3.port || !LangUtils.equals(this.realm, var3.realm) || !LangUtils.equals(this.scheme, var3.scheme)) {
            return false;
         }
      }

      return var2;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.host), this.port), this.realm), this.scheme);
   }

   public int match(AuthScope var1) {
      int var4;
      if(LangUtils.equals(this.scheme, var1.scheme)) {
         var4 = 0 + 1;
      } else {
         String var2 = this.scheme;
         String var3 = ANY_SCHEME;
         var4 = 0;
         if(var2 != var3) {
            String var5 = var1.scheme;
            String var6 = ANY_SCHEME;
            var4 = 0;
            if(var5 != var6) {
               return -1;
            }
         }
      }

      if(LangUtils.equals(this.realm, var1.realm)) {
         var4 += 2;
      } else if(this.realm != ANY_REALM && var1.realm != ANY_REALM) {
         return -1;
      }

      if(this.port == var1.port) {
         var4 += 4;
      } else if(this.port != -1 && var1.port != -1) {
         return -1;
      }

      if(LangUtils.equals(this.host, var1.host)) {
         var4 += 8;
      } else if(this.host != ANY_HOST && var1.host != ANY_HOST) {
         return -1;
      }

      return var4;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      if(this.scheme != null) {
         var1.append(this.scheme.toUpperCase(Locale.ENGLISH));
         var1.append(' ');
      }

      if(this.realm != null) {
         var1.append('\'');
         var1.append(this.realm);
         var1.append('\'');
      } else {
         var1.append("<any realm>");
      }

      if(this.host != null) {
         var1.append('@');
         var1.append(this.host);
         if(this.port >= 0) {
            var1.append(':');
            var1.append(this.port);
         }
      }

      return var1.toString();
   }
}
