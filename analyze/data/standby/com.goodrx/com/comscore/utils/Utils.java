package com.comscore.utils;

import com.comscore.utils.Base64Coder;
import com.comscore.utils.CSLog;
import com.comscore.utils.Constants;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;

public class Utils {
   public static List<String> arrayOfStrings(List var0) {
      ArrayList var1 = new ArrayList();
      if(var0 != null) {
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            if(var3 != null) {
               var1.add(var3.toString());
            }
         }
      }

      return var1;
   }

   public static String encrypt(String var0) {
      X509EncodedKeySpec var1 = new X509EncodedKeySpec(Constants.RSA_PUBLIC_KEY);
      PublicKey var2 = KeyFactory.getInstance("RSA").generatePublic(var1);
      Cipher var3 = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
      var3.init(1, var2);
      String var4 = new String(Base64Coder.encode(var3.doFinal(var0.getBytes())));
      CSLog.method_371(Utils.class, "encrypt(" + var0 + ")=" + var4);
      return var4;
   }

   public static boolean getBoolean(String var0) {
      return getBoolean(var0, false);
   }

   public static boolean getBoolean(String var0, boolean var1) {
      if(var0 != null) {
         if(!var0.equalsIgnoreCase("yes") && !var0.equalsIgnoreCase("true")) {
            if(var0.equalsIgnoreCase("no") || var0.equalsIgnoreCase("false")) {
               return false;
            }
         } else {
            var1 = true;
         }
      }

      return var1;
   }

   public static int getInteger(String var0) {
      return getInteger(var0, 0);
   }

   public static int getInteger(String var0, int var1) {
      try {
         int var3 = Integer.parseInt(var0);
         return var3;
      } catch (NumberFormatException var4) {
         return var1;
      }
   }

   public static long getLong(String var0) {
      return getLong(var0, 0L);
   }

   public static long getLong(String var0, long var1) {
      try {
         long var4 = Long.parseLong(var0);
         return var4;
      } catch (NumberFormatException var6) {
         return var1;
      }
   }

   public static boolean isEmpty(String var0) {
      return var0 == null || var0.length() == 0;
   }

   public static boolean isNotEmpty(String var0) {
      return var0 != null && var0.length() > 0;
   }

   public static HashMap<String, String> mapOfStrings(Map var0) {
      HashMap var1 = new HashMap();
      if(var0 != null) {
         Iterator var2 = var0.keySet().iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            if(var3 != null && var0.get(var3) != null) {
               String var4 = var3.toString();
               if(var4.length() > 0) {
                  var1.put(var4, var0.get(var3).toString());
               }
            }
         }
      }

      return var1;
   }

   public static String md5(String param0) {
      // $FF: Couldn't be decompiled
   }
}
