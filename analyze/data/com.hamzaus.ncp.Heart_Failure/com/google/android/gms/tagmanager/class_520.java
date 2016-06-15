package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.tagmanager.class_544;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ay
class class_520 {
   private static String afP;
   static Map<String, String> afQ = new HashMap();

   // $FF: renamed from: bX (java.lang.String) void
   static void method_2940(String param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (android.content.Context, java.lang.String, java.lang.String) java.lang.String
   static String method_2941(Context var0, String var1, String var2) {
      String var3 = (String)afQ.get(var1);
      if(var3 == null) {
         SharedPreferences var4 = var0.getSharedPreferences("gtm_click_referrers", 0);
         if(var4 != null) {
            var3 = var4.getString(var1, "");
         } else {
            var3 = "";
         }

         afQ.put(var1, var3);
      }

      return method_2945(var3, var2);
   }

   // $FF: renamed from: d (android.content.Context, java.lang.String) void
   static void method_2942(Context var0, String var1) {
      class_544.method_3083(var0, "gtm_install_referrer", "referrer", var1);
      method_2944(var0, var1);
   }

   // $FF: renamed from: e (android.content.Context, java.lang.String) java.lang.String
   static String method_2943(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (android.content.Context, java.lang.String) void
   static void method_2944(Context var0, String var1) {
      String var2 = method_2945(var1, "conv");
      if(var2 != null && var2.length() > 0) {
         afQ.put(var2, var1);
         class_544.method_3083(var0, "gtm_click_referrers", var2, var1);
      }

   }

   // $FF: renamed from: p (java.lang.String, java.lang.String) java.lang.String
   static String method_2945(String var0, String var1) {
      return var1 == null?(var0.length() > 0?var0:null):Uri.parse("http://hostname/?" + var0).getQueryParameter(var1);
   }
}
