package com.google.android.gms.analytics.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzpr;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class zzam {
   private static final char[] zzTu = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

   public static String zzK(boolean var0) {
      return var0?"1":"0";
   }

   public static double zza(String var0, double var1) {
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

   public static zzpr zza(zzaf var0, String var1) {
      com.google.android.gms.common.internal.zzx.zzz(var0);
      if(TextUtils.isEmpty(var1)) {
         return null;
      } else {
         new HashMap();

         Map var5;
         try {
            var5 = zzmz.zza(new URI("?" + var1), "UTF-8");
         } catch (URISyntaxException var7) {
            var0.zzd("No valid campaign data found", var7);
            return null;
         }

         zzpr var6 = new zzpr();
         var6.zzey((String)var5.get("utm_content"));
         var6.zzew((String)var5.get("utm_medium"));
         var6.setName((String)var5.get("utm_campaign"));
         var6.zzev((String)var5.get("utm_source"));
         var6.zzex((String)var5.get("utm_term"));
         var6.zzez((String)var5.get("utm_id"));
         var6.zzeA((String)var5.get("anid"));
         var6.zzeB((String)var5.get("gclid"));
         var6.zzeC((String)var5.get("dclid"));
         var6.zzeD((String)var5.get("aclid"));
         return var6;
      }
   }

   public static String zza(Locale var0) {
      if(var0 != null) {
         String var1 = var0.getLanguage();
         if(!TextUtils.isEmpty(var1)) {
            StringBuilder var2 = new StringBuilder();
            var2.append(var1.toLowerCase());
            if(!TextUtils.isEmpty(var0.getCountry())) {
               var2.append("-").append(var0.getCountry().toLowerCase());
            }

            return var2.toString();
         }
      }

      return null;
   }

   public static void zza(Map<String, String> var0, String var1, Map<String, String> var2) {
      zzc(var0, var1, (String)var2.get(var1));
   }

   public static boolean zza(double var0, String var2) {
      return var0 > 0.0D && var0 < 100.0D && (double)(zzbw(var2) % 10000) >= 100.0D * var0;
   }

   public static boolean zza(Context param0, Class<? extends Service> param1) {
      // $FF: Couldn't be decompiled
   }

   public static boolean zza(Context param0, Class<? extends BroadcastReceiver> param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public static void zzb(Map<String, String> var0, String var1, boolean var2) {
      if(!var0.containsKey(var1)) {
         String var3;
         if(var2) {
            var3 = "1";
         } else {
            var3 = "0";
         }

         var0.put(var1, var3);
      }

   }

   public static long zzbt(String var0) {
      if(var0 == null) {
         return 0L;
      } else {
         try {
            long var2 = Long.parseLong(var0);
            return var2;
         } catch (NumberFormatException var4) {
            return 0L;
         }
      }
   }

   public static MessageDigest zzbv(String var0) {
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

   public static int zzbw(String var0) {
      int var1 = 1;
      if(!TextUtils.isEmpty(var0)) {
         int var2 = -1 + var0.length();
         var1 = 0;

         for(int var3 = var2; var3 >= 0; --var3) {
            char var4 = var0.charAt(var3);
            var1 = var4 + (268435455 & var1 << 6) + (var4 << 14);
            int var5 = 266338304 & var1;
            if(var5 != 0) {
               var1 ^= var5 >> 21;
            }
         }
      }

      return var1;
   }

   public static boolean zzbx(String var0) {
      return TextUtils.isEmpty(var0) || !var0.startsWith("http:");
   }

   public static void zzc(Map<String, String> var0, String var1, String var2) {
      if(var2 != null && !var0.containsKey(var1)) {
         var0.put(var1, var2);
      }

   }

   public static void zzd(Map<String, String> var0, String var1, String var2) {
      if(var2 != null && TextUtils.isEmpty((CharSequence)var0.get(var1))) {
         var0.put(var1, var2);
      }

   }

   public static boolean zzh(String var0, boolean var1) {
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
}
