package com.squareup.okhttp.internal.tls;

import com.squareup.okhttp.internal.tls.DistinguishedNameParser;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class OkHostnameVerifier implements HostnameVerifier {
   private static final int ALT_DNS_NAME = 2;
   private static final int ALT_IPA_NAME = 7;
   public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
   private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

   private List<String> getSubjectAltNames(X509Certificate param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   static boolean verifyAsIpAddress(String var0) {
      return VERIFY_AS_IP_ADDRESS.matcher(var0).matches();
   }

   private boolean verifyHostName(String var1, X509Certificate var2) {
      String var3 = var1.toLowerCase(Locale.US);
      boolean var4 = false;
      Iterator var5 = this.getSubjectAltNames(var2, 2).iterator();

      String var7;
      do {
         if(!var5.hasNext()) {
            if(!var4) {
               String var6 = (new DistinguishedNameParser(var2.getSubjectX500Principal())).findMostSpecific("cn");
               if(var6 != null) {
                  return this.verifyHostName(var3, var6);
               }
            }

            return false;
         }

         var7 = (String)var5.next();
         var4 = true;
      } while(!this.verifyHostName(var3, var7));

      return true;
   }

   private boolean verifyIpAddress(String var1, X509Certificate var2) {
      Iterator var3 = this.getSubjectAltNames(var2, 7).iterator();

      do {
         if(!var3.hasNext()) {
            return false;
         }
      } while(!var1.equalsIgnoreCase((String)var3.next()));

      return true;
   }

   public boolean verify(String var1, X509Certificate var2) {
      return verifyAsIpAddress(var1)?this.verifyIpAddress(var1, var2):this.verifyHostName(var1, var2);
   }

   public boolean verify(String var1, SSLSession var2) {
      try {
         boolean var4 = this.verify(var1, (X509Certificate)var2.getPeerCertificates()[0]);
         return var4;
      } catch (SSLException var5) {
         return false;
      }
   }

   public boolean verifyHostName(String var1, String var2) {
      boolean var3 = true;
      if(var1 != null && var1.length() != 0 && var2 != null && var2.length() != 0) {
         String var4 = var2.toLowerCase(Locale.US);
         if(!var4.contains("*")) {
            return var1.equals(var4);
         }

         if(!var4.startsWith("*.") || !var1.regionMatches(0, var4, 2, -2 + var4.length())) {
            int var5 = var4.indexOf(42);
            if(var5 > var4.indexOf(46)) {
               return false;
            }

            if(!var1.regionMatches(0, var4, 0, var5)) {
               return false;
            }

            int var6 = var4.length() - (var5 + 1);
            int var7 = var1.length() - var6;
            if(var1.indexOf(46, var5) < var7 && !var1.endsWith(".clients.google.com")) {
               return false;
            }

            if(!var1.regionMatches(var7, var4, var5 + 1, var6)) {
               return false;
            }
         }
      } else {
         var3 = false;
      }

      return var3;
   }
}
