package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public abstract class AbstractVerifier implements X509HostnameVerifier {
   private static final String[] BAD_COUNTRY_2LDS = new String[]{"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   static {
      Arrays.sort(BAD_COUNTRY_2LDS);
   }

   public static int countDots(String var0) {
      int var1 = 0;

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         if(var0.charAt(var2) == 46) {
            ++var1;
         }
      }

      return var1;
   }

   static String[] extractCNs(String var0) throws SSLException {
      if(var0 != null) {
         LinkedList var1 = new LinkedList();
         StringTokenizer var2 = new StringTokenizer(var0, ",");

         while(var2.hasMoreTokens()) {
            String var5 = var2.nextToken();
            int var6 = var5.indexOf("CN=");
            if(var6 >= 0) {
               var1.add(var5.substring(var6 + 3));
            }
         }

         if(!var1.isEmpty()) {
            String[] var3 = new String[var1.size()];
            var1.toArray(var3);
            return var3;
         }
      }

      return null;
   }

   public static String[] getCNs(X509Certificate var0) {
      String var1 = var0.getSubjectX500Principal().toString();

      try {
         String[] var3 = extractCNs(var1);
         return var3;
      } catch (SSLException var4) {
         return null;
      }
   }

   private static String[] getSubjectAlts(X509Certificate var0, String var1) {
      byte var2;
      if(isIPAddress(var1)) {
         var2 = 7;
      } else {
         var2 = 2;
      }

      LinkedList var3 = new LinkedList();

      Collection var5;
      label35: {
         Collection var11;
         try {
            var11 = var0.getSubjectAlternativeNames();
         } catch (CertificateParsingException var12) {
            var5 = null;
            break label35;
         }

         var5 = var11;
      }

      if(var5 != null) {
         Iterator var8 = var5.iterator();

         while(var8.hasNext()) {
            List var9 = (List)var8.next();
            if(((Integer)var9.get(0)).intValue() == var2) {
               var3.add((String)var9.get(1));
            }
         }
      }

      if(!var3.isEmpty()) {
         String[] var6 = new String[var3.size()];
         var3.toArray(var6);
         return var6;
      } else {
         return null;
      }
   }

   private static boolean isIPAddress(String var0) {
      return var0 != null && (InetAddressUtils.isIPv4Address(var0) || InetAddressUtils.isIPv6Address(var0));
   }

   private String normaliseIPv6Address(String var1) {
      if(var1 != null && InetAddressUtils.isIPv6Address(var1)) {
         try {
            String var3 = InetAddress.getByName(var1).getHostAddress();
            return var3;
         } catch (UnknownHostException var4) {
            this.log.error("Unexpected error converting " + var1, var4);
            return var1;
         }
      } else {
         return var1;
      }
   }

   boolean validCountryWildcard(String var1) {
      String[] var2 = var1.split("\\.");
      return var2.length != 3 || var2[2].length() != 2 || Arrays.binarySearch(BAD_COUNTRY_2LDS, var2[1]) < 0;
   }

   public final void verify(String var1, X509Certificate var2) throws SSLException {
      this.verify(var1, getCNs(var2), getSubjectAlts(var2, var1));
   }

   public final void verify(String var1, SSLSocket var2) throws IOException {
      if(var1 == null) {
         throw new NullPointerException("host to verify is null");
      } else {
         SSLSession var3 = var2.getSession();
         if(var3 == null) {
            var2.getInputStream().available();
            var3 = var2.getSession();
            if(var3 == null) {
               var2.startHandshake();
               var3 = var2.getSession();
            }
         }

         this.verify(var1, (X509Certificate)var3.getPeerCertificates()[0]);
      }
   }

   public final void verify(String var1, String[] var2, String[] var3, boolean var4) throws SSLException {
      LinkedList var5 = new LinkedList();
      if(var2 != null && var2.length > 0 && var2[0] != null) {
         var5.add(var2[0]);
      }

      if(var3 != null) {
         int var23 = var3.length;

         for(int var24 = 0; var24 < var23; ++var24) {
            String var25 = var3[var24];
            if(var25 != null) {
               var5.add(var25);
            }
         }
      }

      if(var5.isEmpty()) {
         String var21 = "Certificate for <" + var1 + "> doesn\'t contain CN or DNS subjectAlt";
         SSLException var22 = new SSLException(var21);
         throw var22;
      } else {
         StringBuilder var6 = new StringBuilder();
         String var7 = this.normaliseIPv6Address(var1.trim().toLowerCase(Locale.ENGLISH));
         boolean var8 = false;
         Iterator var9 = var5.iterator();

         while(var9.hasNext()) {
            String var10 = ((String)var9.next()).toLowerCase(Locale.ENGLISH);
            var6.append(" <");
            var6.append(var10);
            var6.append('>');
            if(var9.hasNext()) {
               var6.append(" OR");
            }

            String[] var14 = var10.split("\\.");
            boolean var15;
            if(var14.length >= 3 && var14[0].endsWith("*") && this.validCountryWildcard(var10) && !isIPAddress(var1)) {
               var15 = true;
            } else {
               var15 = false;
            }

            if(var15) {
               String var16 = var14[0];
               if(var16.length() > 1) {
                  String var17 = var16.substring(0, -1 + var16.length());
                  String var18 = var10.substring(var16.length());
                  String var19 = var7.substring(var17.length());
                  if(var7.startsWith(var17) && var19.endsWith(var18)) {
                     var8 = true;
                  } else {
                     var8 = false;
                  }
               } else {
                  var8 = var7.endsWith(var10.substring(1));
               }

               if(var8 && var4) {
                  if(countDots(var7) == countDots(var10)) {
                     var8 = true;
                  } else {
                     var8 = false;
                  }
               }
            } else {
               var8 = var7.equals(this.normaliseIPv6Address(var10));
            }

            if(var8) {
               break;
            }
         }

         if(!var8) {
            throw new SSLException("hostname in certificate didn\'t match: <" + var1 + "> !=" + var6);
         }
      }
   }

   public final boolean verify(String var1, SSLSession var2) {
      try {
         this.verify(var1, (X509Certificate)var2.getPeerCertificates()[0]);
         return true;
      } catch (SSLException var4) {
         return false;
      }
   }
}
