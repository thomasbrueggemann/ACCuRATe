package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzi;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzx {
   public static String zza(Map<String, String> var0) {
      return zzb(var0, "ISO-8859-1");
   }

   public static zzb.zza zzb(zzi var0) {
      long var1 = System.currentTimeMillis();
      Map var3 = var0.zzA;
      long var4 = 0L;
      long var6 = 0L;
      long var8 = 0L;
      String var10 = (String)var3.get("Date");
      if(var10 != null) {
         var4 = zzg(var10);
      }

      String var11 = (String)var3.get("Cache-Control");
      boolean var12;
      boolean var13;
      if(var11 == null) {
         var12 = false;
         var13 = false;
      } else {
         String[] var26 = var11.split(",");
         int var27 = 0;
         var12 = false;
         long var28 = var8;
         long var30 = var6;

         while(true) {
            if(var27 >= var26.length) {
               var6 = var30;
               var8 = var28;
               var13 = true;
               break;
            }

            String var32 = var26[var27].trim();
            if(var32.equals("no-cache") || var32.equals("no-store")) {
               return null;
            }

            if(var32.startsWith("max-age=")) {
               label76: {
                  long var37;
                  try {
                     var37 = Long.parseLong(var32.substring(8));
                  } catch (Exception var40) {
                     break label76;
                  }

                  var30 = var37;
               }
            } else if(var32.startsWith("stale-while-revalidate=")) {
               label72: {
                  long var34;
                  try {
                     var34 = Long.parseLong(var32.substring(23));
                  } catch (Exception var39) {
                     break label72;
                  }

                  var28 = var34;
               }
            } else if(var32.equals("must-revalidate") || var32.equals("proxy-revalidate")) {
               var12 = true;
            }

            ++var27;
         }
      }

      String var14 = (String)var3.get("Expires");
      long var15;
      if(var14 != null) {
         var15 = zzg(var14);
      } else {
         var15 = 0L;
      }

      String var17 = (String)var3.get("Last-Modified");
      long var18;
      if(var17 != null) {
         var18 = zzg(var17);
      } else {
         var18 = 0L;
      }

      String var20 = (String)var3.get("ETag");
      long var21;
      long var23;
      if(var13) {
         var23 = var1 + 1000L * var6;
         if(var12) {
            var21 = var23;
         } else {
            var21 = var23 + 1000L * var8;
         }
      } else if(var4 > 0L && var15 >= var4) {
         var21 = var1 + (var15 - var4);
         var23 = var21;
      } else {
         var21 = 0L;
         var23 = 0L;
      }

      zzb.zza var25 = new zzb.zza();
      var25.data = var0.data;
      var25.zzb = var20;
      var25.zzf = var23;
      var25.zze = var21;
      var25.zzc = var4;
      var25.zzd = var18;
      var25.zzg = var3;
      return var25;
   }

   public static String zzb(Map<String, String> var0, String var1) {
      String var2 = (String)var0.get("Content-Type");
      if(var2 != null) {
         String[] var3 = var2.split(";");

         for(int var4 = 1; var4 < var3.length; ++var4) {
            String[] var5 = var3[var4].trim().split("=");
            if(var5.length == 2 && var5[0].equals("charset")) {
               var1 = var5[1];
               break;
            }
         }
      }

      return var1;
   }

   public static long zzg(String var0) {
      try {
         long var2 = DateUtils.parseDate(var0).getTime();
         return var2;
      } catch (DateParseException var4) {
         return 0L;
      }
   }
}
