package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_434;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fv;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.fr
@ey
public final class class_426 {
   // $FF: renamed from: uD java.text.SimpleDateFormat
   private static final SimpleDateFormat field_1359 = new SimpleDateFormat("yyyyMMdd");

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.fh, java.lang.String) com.google.android.gms.internal.fj
   public static class_438 method_2821(Context param0, class_440 param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fh, com.google.android.gms.internal.fv, android.location.Location, java.lang.String, java.lang.String, java.lang.String) java.lang.String
   public static String method_2822(class_440 param0, class_434 param1, Location param2, String param3, String param4, String param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.util.HashMap, android.location.Location) void
   private static void method_2823(HashMap<String, Object> var0, Location var1) {
      HashMap var2 = new HashMap();
      Float var3 = Float.valueOf(1000.0F * var1.getAccuracy());
      Long var4 = Long.valueOf(1000L * var1.getTime());
      Long var5 = Long.valueOf((long)(1.0E7D * var1.getLatitude()));
      Long var6 = Long.valueOf((long)(1.0E7D * var1.getLongitude()));
      var2.put("radius", var3);
      var2.put("lat", var5);
      var2.put("long", var6);
      var2.put("time", var4);
      var0.put("uule", var2);
   }

   // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.av) void
   private static void method_2824(HashMap<String, Object> var0, av var1) {
      String var2 = class_383.method_2636();
      if(var2 != null) {
         var0.put("abf", var2);
      }

      if(var1.field_357 != -1L) {
         var0.put("cust_age", field_1359.format(new Date(var1.field_357)));
      }

      if(var1.extras != null) {
         var0.put("extras", var1.extras);
      }

      if(var1.field_358 != -1) {
         var0.put("cust_gender", Integer.valueOf(var1.field_358));
      }

      if(var1.field_359 != null) {
         var0.put("kw", var1.field_359);
      }

      if(var1.field_361 != -1) {
         var0.put("tag_for_child_directed_treatment", Integer.valueOf(var1.field_361));
      }

      if(var1.field_360) {
         var0.put("adtest", "on");
      }

      if(var1.versionCode >= 2) {
         if(var1.field_362) {
            var0.put("d_imp_hdr", Integer.valueOf(1));
         }

         if(!TextUtils.isEmpty(var1.field_363)) {
            var0.put("ppid", var1.field_363);
         }

         if(var1.field_364 != null) {
            method_2825(var0, var1.field_364);
         }
      }

      if(var1.versionCode >= 3 && var1.field_366 != null) {
         var0.put("url", var1.field_366);
      }

   }

   // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.bj) void
   private static void method_2825(HashMap<String, Object> var0, bj var1) {
      if(Color.alpha(var1.field_491) != 0) {
         var0.put("acolor", method_2828(var1.field_491));
      }

      if(Color.alpha(var1.backgroundColor) != 0) {
         var0.put("bgcolor", method_2828(var1.backgroundColor));
      }

      if(Color.alpha(var1.field_492) != 0 && Color.alpha(var1.field_493) != 0) {
         var0.put("gradientto", method_2828(var1.field_492));
         var0.put("gradientfrom", method_2828(var1.field_493));
      }

      if(Color.alpha(var1.field_494) != 0) {
         var0.put("bcolor", method_2828(var1.field_494));
      }

      var0.put("bthick", Integer.toString(var1.field_495));
      String var3;
      switch(var1.field_496) {
      case 0:
         var3 = "none";
         break;
      case 1:
         var3 = "dashed";
         break;
      case 2:
         var3 = "dotted";
         break;
      case 3:
         var3 = "solid";
         break;
      default:
         var3 = null;
      }

      if(var3 != null) {
         var0.put("btype", var3);
      }

      int var4 = var1.field_497;
      String var5 = null;
      switch(var4) {
      case 0:
         var5 = "light";
         break;
      case 1:
         var5 = "medium";
         break;
      case 2:
         var5 = "dark";
      }

      if(var5 != null) {
         var0.put("callbuttoncolor", var5);
      }

      if(var1.field_498 != null) {
         var0.put("channel", var1.field_498);
      }

      if(Color.alpha(var1.field_499) != 0) {
         var0.put("dcolor", method_2828(var1.field_499));
      }

      if(var1.field_500 != null) {
         var0.put("font", var1.field_500);
      }

      if(Color.alpha(var1.field_501) != 0) {
         var0.put("hcolor", method_2828(var1.field_501));
      }

      var0.put("headersize", Integer.toString(var1.field_502));
      if(var1.field_503 != null) {
         var0.put("q", var1.field_503);
      }

   }

   // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.fv) void
   private static void method_2826(HashMap<String, Object> var0, fv var1) {
      var0.put("am", Integer.valueOf(var1.field_1411));
      var0.put("cog", method_2827(var1.field_1412));
      var0.put("coh", method_2827(var1.field_1413));
      if(!TextUtils.isEmpty(var1.field_1414)) {
         var0.put("carrier", var1.field_1414);
      }

      var0.put("gl", var1.field_1415);
      if(var1.field_1416) {
         var0.put("simulator", Integer.valueOf(1));
      }

      var0.put("ma", method_2827(var1.field_1417));
      var0.put("sp", method_2827(var1.field_1418));
      var0.put("hl", var1.field_1419);
      if(!TextUtils.isEmpty(var1.field_1420)) {
         var0.put("mv", var1.field_1420);
      }

      var0.put("muv", Integer.valueOf(var1.field_1421));
      if(var1.field_1422 != -2) {
         var0.put("cnt", Integer.valueOf(var1.field_1422));
      }

      var0.put("gnt", Integer.valueOf(var1.field_1423));
      var0.put("pt", Integer.valueOf(var1.field_1424));
      var0.put("rm", Integer.valueOf(var1.field_1425));
      var0.put("riv", Integer.valueOf(var1.field_1426));
      var0.put("u_sd", Float.valueOf(var1.field_1427));
      var0.put("sh", Integer.valueOf(var1.field_1429));
      var0.put("sw", Integer.valueOf(var1.field_1428));
      Bundle var17 = new Bundle();
      var17.putInt("active_network_state", var1.field_1410);
      var17.putBoolean("active_network_metered", var1.field_1409);
      var0.put("connectivity", var17);
      Bundle var19 = new Bundle();
      var19.putBoolean("is_charging", var1.field_1408);
      var19.putDouble("battery_level", var1.field_1430);
      var0.put("battery", var19);
   }

   // $FF: renamed from: u (boolean) java.lang.Integer
   private static Integer method_2827(boolean var0) {
      byte var1;
      if(var0) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      return Integer.valueOf(var1);
   }

   // $FF: renamed from: u (int) java.lang.String
   private static String method_2828(int var0) {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{Integer.valueOf(16777215 & var0)};
      return String.format(var1, "#%06x", var2);
   }
}
