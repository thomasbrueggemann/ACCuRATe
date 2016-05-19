package com.newrelic.agent.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Util {
   private static final Random random = new Random();

   public static Random getRandom() {
      return random;
   }

   public static String sanitizeUrl(String var0) {
      if(var0 == null) {
         return null;
      } else {
         URL var1;
         try {
            var1 = new URL(var0);
         } catch (MalformedURLException var10) {
            return null;
         }

         StringBuffer var2 = new StringBuffer();
         var2.append(var1.getProtocol());
         var2.append("://");
         var2.append(var1.getHost());
         if(var1.getPort() != -1) {
            var2.append(":");
            var2.append(var1.getPort());
         }

         var2.append(var1.getPath());
         return var2.toString();
      }
   }

   public static String slurp(InputStream var0) throws IOException {
      char[] var1 = new char[8192];
      StringBuilder var2 = new StringBuilder();
      BufferedReader var3 = new BufferedReader(new InputStreamReader(var0));

      while(true) {
         int var4 = var3.read(var1);
         if(var4 < 0) {
            return var2.toString();
         }

         var2.append(var1, 0, var4);
      }
   }
}
