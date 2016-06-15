package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.aj;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.ed;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.dz
public final class class_434 {
   // $FF: renamed from: qx java.text.SimpleDateFormat
   private static final SimpleDateFormat field_1910 = new SimpleDateFormat("yyyyMMdd");

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.dt, java.lang.String) com.google.android.gms.internal.dv
   public static class_431 method_2601(Context param0, class_433 param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dt, com.google.android.gms.internal.ed, android.location.Location, java.lang.String) java.lang.String
   public static String method_2602(class_433 param0, class_377 param1, Location param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.util.HashMap, android.location.Location) void
   private static void method_2603(HashMap<String, Object> var0, Location var1) {
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

   // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.aj) void
   private static void method_2604(HashMap<String, Object> var0, aj var1) {
      String var2 = class_364.method_2288();
      if(var2 != null) {
         var0.put("abf", var2);
      }

      if(var1.field_579 != -1L) {
         var0.put("cust_age", field_1910.format(new Date(var1.field_579)));
      }

      if(var1.extras != null) {
         var0.put("extras", var1.extras);
      }

      if(var1.field_580 != -1) {
         var0.put("cust_gender", Integer.valueOf(var1.field_580));
      }

      if(var1.field_581 != null) {
         var0.put("kw", var1.field_581);
      }

      if(var1.field_583 != -1) {
         var0.put("tag_for_child_directed_treatment", Integer.valueOf(var1.field_583));
      }

      if(var1.field_582) {
         var0.put("adtest", "on");
      }

      if(var1.versionCode >= 2) {
         if(var1.field_584) {
            var0.put("d_imp_hdr", Integer.valueOf(1));
         }

         if(!TextUtils.isEmpty(var1.field_585)) {
            var0.put("ppid", var1.field_585);
         }

         if(var1.field_586 != null) {
            method_2605(var0, var1.field_586);
         }
      }

      if(var1.versionCode >= 3 && var1.field_588 != null) {
         var0.put("url", var1.field_588);
      }

   }

   // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.ax) void
   private static void method_2605(HashMap<String, Object> var0, ax var1) {
      if(Color.alpha(var1.field_530) != 0) {
         var0.put("acolor", method_2608(var1.field_530));
      }

      if(Color.alpha(var1.backgroundColor) != 0) {
         var0.put("bgcolor", method_2608(var1.backgroundColor));
      }

      if(Color.alpha(var1.field_531) != 0 && Color.alpha(var1.field_532) != 0) {
         var0.put("gradientto", method_2608(var1.field_531));
         var0.put("gradientfrom", method_2608(var1.field_532));
      }

      if(Color.alpha(var1.field_533) != 0) {
         var0.put("bcolor", method_2608(var1.field_533));
      }

      var0.put("bthick", Integer.toString(var1.field_534));
      String var3;
      switch(var1.field_535) {
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

      int var4 = var1.field_536;
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

      if(var1.field_537 != null) {
         var0.put("channel", var1.field_537);
      }

      if(Color.alpha(var1.field_538) != 0) {
         var0.put("dcolor", method_2608(var1.field_538));
      }

      if(var1.field_539 != null) {
         var0.put("font", var1.field_539);
      }

      if(Color.alpha(var1.field_540) != 0) {
         var0.put("hcolor", method_2608(var1.field_540));
      }

      var0.put("headersize", Integer.toString(var1.field_541));
      if(var1.field_542 != null) {
         var0.put("q", var1.field_542);
      }

   }

   // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.ed) void
   private static void method_2606(HashMap<String, Object> var0, ed var1) {
      var0.put("am", Integer.valueOf(var1.field_1639));
      var0.put("cog", method_2607(var1.field_1640));
      var0.put("coh", method_2607(var1.field_1641));
      if(!TextUtils.isEmpty(var1.field_1642)) {
         var0.put("carrier", var1.field_1642);
      }

      var0.put("gl", var1.field_1643);
      if(var1.field_1644) {
         var0.put("simulator", Integer.valueOf(1));
      }

      var0.put("ma", method_2607(var1.field_1645));
      var0.put("sp", method_2607(var1.field_1646));
      var0.put("hl", var1.field_1647);
      if(!TextUtils.isEmpty(var1.field_1648)) {
         var0.put("mv", var1.field_1648);
      }

      var0.put("muv", Integer.valueOf(var1.field_1649));
      if(var1.field_1650 != -2) {
         var0.put("cnt", Integer.valueOf(var1.field_1650));
      }

      var0.put("gnt", Integer.valueOf(var1.field_1651));
      var0.put("pt", Integer.valueOf(var1.field_1652));
      var0.put("rm", Integer.valueOf(var1.field_1653));
      var0.put("riv", Integer.valueOf(var1.field_1654));
      var0.put("u_sd", Float.valueOf(var1.field_1655));
      var0.put("sh", Integer.valueOf(var1.field_1657));
      var0.put("sw", Integer.valueOf(var1.field_1656));
      Bundle var17 = new Bundle();
      var17.putInt("active_network_state", var1.field_1661);
      var17.putBoolean("active_network_metered", var1.field_1660);
      var0.put("connectivity", var17);
      Bundle var19 = new Bundle();
      var19.putBoolean("is_charging", var1.field_1659);
      var19.putDouble("battery_level", var1.field_1658);
      var0.put("battery", var19);
   }

   // $FF: renamed from: m (boolean) java.lang.Integer
   private static Integer method_2607(boolean var0) {
      byte var1;
      if(var0) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      return Integer.valueOf(var1);
   }

   // $FF: renamed from: o (int) java.lang.String
   private static String method_2608(int var0) {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{Integer.valueOf(16777215 & var0)};
      return String.format(var1, "#%06x", var2);
   }
}
