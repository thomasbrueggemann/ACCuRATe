package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.tagmanager.zzcv;
import java.util.HashMap;
import java.util.Map;

public class zzax {
   private static String zzbjg;
   static Map<String, String> zzbjh = new HashMap();

   public static String zzU(String var0, String var1) {
      return var1 == null?(var0.length() > 0?var0:null):Uri.parse("http://hostname/?" + var0).getQueryParameter(var1);
   }

   public static String zzf(Context var0, String var1, String var2) {
      String var3 = (String)zzbjh.get(var1);
      if(var3 == null) {
         SharedPreferences var4 = var0.getSharedPreferences("gtm_click_referrers", 0);
         if(var4 != null) {
            var3 = var4.getString(var1, "");
         } else {
            var3 = "";
         }

         zzbjh.put(var1, var3);
      }

      return zzU(var3, var2);
   }

   public static String zzm(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void zzn(Context var0, String var1) {
      String var2 = zzU(var1, "conv");
      if(var2 != null && var2.length() > 0) {
         zzbjh.put(var2, var1);
         zzcv.zzb(var0, "gtm_click_referrers", var2, var1);
      }

   }
}
