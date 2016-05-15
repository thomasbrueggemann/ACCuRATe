package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;

public class URIUtils {
   public static HttpHost extractHost(URI var0) {
      if(var0 != null && var0.isAbsolute()) {
         int var1 = var0.getPort();
         String var2 = var0.getHost();
         if(var2 == null) {
            var2 = var0.getAuthority();
            if(var2 != null) {
               int var4 = var2.indexOf(64);
               if(var4 >= 0) {
                  if(var2.length() > var4 + 1) {
                     var2 = var2.substring(var4 + 1);
                  } else {
                     var2 = null;
                  }
               }

               if(var2 != null) {
                  int var5 = var2.indexOf(58);
                  if(var5 >= 0) {
                     int var6 = var5 + 1;
                     int var7 = 0;

                     for(int var8 = var6; var8 < var2.length() && Character.isDigit(var2.charAt(var8)); ++var8) {
                        ++var7;
                     }

                     if(var7 > 0) {
                        label62: {
                           int var9 = var6 + var7;

                           int var11;
                           try {
                              var11 = Integer.parseInt(var2.substring(var6, var9));
                           } catch (NumberFormatException var12) {
                              break label62;
                           }

                           var1 = var11;
                        }
                     }

                     var2 = var2.substring(0, var5);
                  }
               }
            }
         }

         String var3 = var0.getScheme();
         if(!TextUtils.isBlank(var2)) {
            return new HttpHost(var2, var1, var3);
         }
      }

      return null;
   }

   private static URI normalizeSyntax(URI var0) {
      URI var1;
      if(!var0.isOpaque() && var0.getAuthority() != null) {
         Args.check(var0.isAbsolute(), "Base URI must be absolute");
         String var2;
         if(var0.getPath() == null) {
            var2 = "";
         } else {
            var2 = var0.getPath();
         }

         String[] var3 = var2.split("/");
         Stack var4 = new Stack();
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            String var17 = var3[var6];
            if(var17.length() != 0 && !".".equals(var17)) {
               if("..".equals(var17)) {
                  if(!var4.isEmpty()) {
                     var4.pop();
                  }
               } else {
                  var4.push(var17);
               }
            }
         }

         StringBuilder var7 = new StringBuilder();
         Iterator var8 = var4.iterator();

         while(var8.hasNext()) {
            String var15 = (String)var8.next();
            var7.append('/').append(var15);
         }

         if(var2.lastIndexOf(47) == -1 + var2.length()) {
            var7.append('/');
         }

         try {
            var1 = new URI(var0.getScheme().toLowerCase(Locale.ENGLISH), var0.getAuthority().toLowerCase(Locale.ENGLISH), var7.toString(), (String)null, (String)null);
            if(var0.getQuery() != null || var0.getFragment() != null) {
               StringBuilder var10 = new StringBuilder(var1.toASCIIString());
               if(var0.getQuery() != null) {
                  var10.append('?').append(var0.getRawQuery());
               }

               if(var0.getFragment() != null) {
                  var10.append('#').append(var0.getRawFragment());
               }

               URI var11 = URI.create(var10.toString());
               return var11;
            }
         } catch (URISyntaxException var18) {
            throw new IllegalArgumentException(var18);
         }
      } else {
         var1 = var0;
      }

      return var1;
   }

   public static URI resolve(URI var0, URI var1) {
      Args.notNull(var0, "Base URI");
      Args.notNull(var1, "Reference URI");
      URI var4 = var1;
      String var5 = var1.toString();
      if(var5.startsWith("?")) {
         return resolveReferenceStartingWithQueryString(var0, var1);
      } else {
         boolean var6;
         if(var5.length() == 0) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var6) {
            var4 = URI.create("#");
         }

         URI var7 = var0.resolve(var4);
         if(var6) {
            String var8 = var7.toString();
            var7 = URI.create(var8.substring(0, var8.indexOf(35)));
         }

         return normalizeSyntax(var7);
      }
   }

   private static URI resolveReferenceStartingWithQueryString(URI var0, URI var1) {
      String var2 = var0.toString();
      if(var2.indexOf(63) > -1) {
         var2 = var2.substring(0, var2.indexOf(63));
      }

      return URI.create(var2 + var1.toString());
   }

   public static URI rewriteURI(URI var0) throws URISyntaxException {
      Args.notNull(var0, "URI");
      if(var0.isOpaque()) {
         return var0;
      } else {
         URIBuilder var2 = new URIBuilder(var0);
         if(var2.getUserInfo() != null) {
            var2.setUserInfo((String)null);
         }

         if(TextUtils.isEmpty(var2.getPath())) {
            var2.setPath("/");
         }

         if(var2.getHost() != null) {
            var2.setHost(var2.getHost().toLowerCase(Locale.ENGLISH));
         }

         var2.setFragment((String)null);
         return var2.build();
      }
   }

   public static URI rewriteURI(URI var0, HttpHost var1, boolean var2) throws URISyntaxException {
      Args.notNull(var0, "URI");
      if(var0.isOpaque()) {
         return var0;
      } else {
         URIBuilder var4 = new URIBuilder(var0);
         if(var1 != null) {
            var4.setScheme(var1.getSchemeName());
            var4.setHost(var1.getHostName());
            var4.setPort(var1.getPort());
         } else {
            var4.setScheme((String)null);
            var4.setHost((String)null);
            var4.setPort(-1);
         }

         if(var2) {
            var4.setFragment((String)null);
         }

         if(TextUtils.isEmpty(var4.getPath())) {
            var4.setPath("/");
         }

         return var4.build();
      }
   }
}
