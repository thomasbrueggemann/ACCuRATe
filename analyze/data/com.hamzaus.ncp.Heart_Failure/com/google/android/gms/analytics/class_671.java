package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.ak
class class_671 {
   // $FF: renamed from: xB char[]
   private static final char[] field_3591 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

   // $FF: renamed from: U (java.lang.String) java.util.Map
   public static Map<String, String> method_3905(String var0) {
      HashMap var1 = new HashMap();
      String[] var2 = var0.split("&");
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String[] var5 = var2[var4].split("=");
         if(var5.length > 1) {
            var1.put(var5[0], var5[1]);
         } else if(var5.length == 1 && var5[0].length() != 0) {
            var1.put(var5[0], (Object)null);
         }
      }

      return var1;
   }

   // $FF: renamed from: V (java.lang.String) java.lang.String
   public static String method_3906(String var0) {
      if(TextUtils.isEmpty(var0)) {
         return null;
      } else {
         if(var0.contains("?")) {
            String[] var9 = var0.split("[\\?]");
            if(var9.length > 1) {
               var0 = var9[1];
            }
         }

         if(var0.contains("%3D")) {
            String var8;
            try {
               var8 = URLDecoder.decode(var0, "UTF-8");
            } catch (UnsupportedEncodingException var10) {
               return null;
            }

            var0 = var8;
         } else if(!var0.contains("=")) {
            return null;
         }

         Map var1 = method_3905(var0);
         String[] var2 = new String[]{"dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t"};
         StringBuilder var3 = new StringBuilder();

         for(int var4 = 0; var4 < var2.length; ++var4) {
            if(!TextUtils.isEmpty((CharSequence)var1.get(var2[var4]))) {
               if(var3.length() > 0) {
                  var3.append("&");
               }

               var3.append(var2[var4]).append("=").append((String)var1.get(var2[var4]));
            }
         }

         return var3.toString();
      }
   }

   // $FF: renamed from: W (java.lang.String) java.security.MessageDigest
   public static MessageDigest method_3907(String var0) {
      for(int var1 = 0; var1 < 2; ++var1) {
         MessageDigest var3;
         try {
            var3 = MessageDigest.getInstance(var0);
         } catch (NoSuchAlgorithmException var4) {
            continue;
         }

         if(var3 != null) {
            return var3;
         }
      }

      return null;
   }

   // $FF: renamed from: a (java.lang.String, double) double
   public static double method_3908(String var0, double var1) {
      if(var0 == null) {
         return var1;
      } else {
         try {
            double var4 = Double.parseDouble(var0);
            return var4;
         } catch (NumberFormatException var6) {
            return var1;
         }
      }
   }

   // $FF: renamed from: a (java.util.Locale) java.lang.String
   static String method_3909(Locale var0) {
      if(var0 != null && !TextUtils.isEmpty(var0.getLanguage())) {
         StringBuilder var1 = new StringBuilder();
         var1.append(var0.getLanguage().toLowerCase());
         if(!TextUtils.isEmpty(var0.getCountry())) {
            var1.append("-").append(var0.getCountry().toLowerCase());
         }

         return var1.toString();
      } else {
         return null;
      }
   }

   // $FF: renamed from: a (java.util.Map, java.lang.String, java.lang.String) void
   public static void method_3910(Map<String, String> var0, String var1, String var2) {
      if(!var0.containsKey(var1)) {
         var0.put(var1, var2);
      }

   }

   // $FF: renamed from: d (java.lang.String, boolean) boolean
   public static boolean method_3911(String var0, boolean var1) {
      if(var0 != null) {
         if(!var0.equalsIgnoreCase("true") && !var0.equalsIgnoreCase("yes") && !var0.equalsIgnoreCase("1")) {
            if(var0.equalsIgnoreCase("false") || var0.equalsIgnoreCase("no") || var0.equalsIgnoreCase("0")) {
               return false;
            }
         } else {
            var1 = true;
         }
      }

      return var1;
   }

   // $FF: renamed from: v (boolean) java.lang.String
   static String method_3912(boolean var0) {
      return var0?"1":"0";
   }
}
