package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.conn.scheme.LayeredSchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactoryAdaptor;
import cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactoryAdaptor2;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactoryAdaptor;
import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.util.Locale;

@Deprecated
public final class Scheme {
   private final int defaultPort;
   private final boolean layered;
   private final String name;
   private final SchemeSocketFactory socketFactory;
   private String stringRep;

   public Scheme(String var1, int var2, SchemeSocketFactory var3) {
      Args.notNull(var1, "Scheme name");
      boolean var5;
      if(var2 > 0 && var2 <= '\uffff') {
         var5 = true;
      } else {
         var5 = false;
      }

      Args.check(var5, "Port is invalid");
      Args.notNull(var3, "Socket factory");
      this.name = var1.toLowerCase(Locale.ENGLISH);
      this.defaultPort = var2;
      if(var3 instanceof SchemeLayeredSocketFactory) {
         this.layered = true;
         this.socketFactory = var3;
      } else if(var3 instanceof LayeredSchemeSocketFactory) {
         this.layered = true;
         this.socketFactory = new SchemeLayeredSocketFactoryAdaptor2((LayeredSchemeSocketFactory)var3);
      } else {
         this.layered = false;
         this.socketFactory = var3;
      }
   }

   @Deprecated
   public Scheme(String var1, SocketFactory var2, int var3) {
      Args.notNull(var1, "Scheme name");
      Args.notNull(var2, "Socket factory");
      boolean var6;
      if(var3 > 0 && var3 <= '\uffff') {
         var6 = true;
      } else {
         var6 = false;
      }

      Args.check(var6, "Port is invalid");
      this.name = var1.toLowerCase(Locale.ENGLISH);
      if(var2 instanceof LayeredSocketFactory) {
         this.socketFactory = new SchemeLayeredSocketFactoryAdaptor((LayeredSocketFactory)var2);
         this.layered = true;
      } else {
         this.socketFactory = new SchemeSocketFactoryAdaptor(var2);
         this.layered = false;
      }

      this.defaultPort = var3;
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Scheme)) {
            return false;
         }

         Scheme var2 = (Scheme)var1;
         if(!this.name.equals(var2.name) || this.defaultPort != var2.defaultPort || this.layered != var2.layered) {
            return false;
         }
      }

      return true;
   }

   public final int getDefaultPort() {
      return this.defaultPort;
   }

   public final String getName() {
      return this.name;
   }

   public final SchemeSocketFactory getSchemeSocketFactory() {
      return this.socketFactory;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.defaultPort), this.name), this.layered);
   }

   public final boolean isLayered() {
      return this.layered;
   }

   public final int resolvePort(int var1) {
      if(var1 <= 0) {
         var1 = this.defaultPort;
      }

      return var1;
   }

   public final String toString() {
      if(this.stringRep == null) {
         StringBuilder var1 = new StringBuilder();
         var1.append(this.name);
         var1.append(':');
         var1.append(Integer.toString(this.defaultPort));
         this.stringRep = var1.toString();
      }

      return this.stringRep;
   }
}
