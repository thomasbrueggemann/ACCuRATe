package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;

public final class HttpHost implements Serializable, Cloneable {
   protected final InetAddress address;
   protected final String hostname;
   protected final String lcHostname;
   protected final int port;
   protected final String schemeName;

   public HttpHost(String var1, int var2) {
      this(var1, var2, (String)null);
   }

   public HttpHost(String var1, int var2, String var3) {
      this.hostname = (String)Args.notBlank(var1, "Host name");
      this.lcHostname = var1.toLowerCase(Locale.ENGLISH);
      if(var3 != null) {
         this.schemeName = var3.toLowerCase(Locale.ENGLISH);
      } else {
         this.schemeName = "http";
      }

      this.port = var2;
      this.address = null;
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof HttpHost)) {
            return false;
         }

         HttpHost var2 = (HttpHost)var1;
         if(!this.lcHostname.equals(var2.lcHostname) || this.port != var2.port || !this.schemeName.equals(var2.schemeName)) {
            return false;
         }
      }

      return true;
   }

   public String getHostName() {
      return this.hostname;
   }

   public int getPort() {
      return this.port;
   }

   public String getSchemeName() {
      return this.schemeName;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
   }

   public String toHostString() {
      if(this.port != -1) {
         StringBuilder var1 = new StringBuilder(6 + this.hostname.length());
         var1.append(this.hostname);
         var1.append(":");
         var1.append(Integer.toString(this.port));
         return var1.toString();
      } else {
         return this.hostname;
      }
   }

   public String toString() {
      return this.toURI();
   }

   public String toURI() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.schemeName);
      var1.append("://");
      var1.append(this.hostname);
      if(this.port != -1) {
         var1.append(':');
         var1.append(Integer.toString(this.port));
      }

      return var1.toString();
   }
}
