package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class zzmz {
   private static final Pattern zzaof = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
   private static final Pattern zzaog = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
   private static final Pattern zzaoh = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

   private static String decode(String var0, String var1) {
      if(var1 == null) {
         var1 = "ISO-8859-1";
      }

      try {
         return URLDecoder.decode(var0, var1);
      } catch (UnsupportedEncodingException var3) {
         throw new IllegalArgumentException(var3);
      }
   }

   public static Map<String, String> zza(URI var0, String var1) {
      Object var2 = Collections.emptyMap();
      String var3 = var0.getRawQuery();
      if(var3 != null && var3.length() > 0) {
         HashMap var4 = new HashMap();
         Scanner var5 = new Scanner(var3);
         var5.useDelimiter("&");

         while(true) {
            if(!var5.hasNext()) {
               var2 = var4;
               break;
            }

            String[] var7 = var5.next().split("=");
            if(var7.length == 0 || var7.length > 2) {
               throw new IllegalArgumentException("bad parameter");
            }

            String var8 = decode(var7[0], var1);
            int var9 = var7.length;
            String var10 = null;
            if(var9 == 2) {
               var10 = decode(var7[1], var1);
            }

            var4.put(var8, var10);
         }
      }

      return (Map)var2;
   }
}
