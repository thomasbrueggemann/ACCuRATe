package com.google.android.gms.internal;

import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_431;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.eb
public final class class_375 {
   private int mOrientation = -1;
   // $FF: renamed from: qD java.lang.String
   private String field_1618;
   // $FF: renamed from: qE java.lang.String
   private String field_1619;
   // $FF: renamed from: qF java.lang.String
   private String field_1620;
   // $FF: renamed from: qG java.util.List
   private List<String> field_1621;
   // $FF: renamed from: qH java.lang.String
   private String field_1622;
   // $FF: renamed from: qI java.lang.String
   private String field_1623;
   // $FF: renamed from: qJ java.util.List
   private List<String> field_1624;
   // $FF: renamed from: qK long
   private long field_1625 = -1L;
   // $FF: renamed from: qL boolean
   private boolean field_1626 = false;
   // $FF: renamed from: qM long
   private final long field_1627 = -1L;
   // $FF: renamed from: qN java.util.List
   private List<String> field_1628;
   // $FF: renamed from: qO long
   private long field_1629 = -1L;

   // $FF: renamed from: a (java.util.Map, java.lang.String) java.lang.String
   private static String method_2382(Map<String, List<String>> var0, String var1) {
      List var2 = (List)var0.get(var1);
      return var2 != null && !var2.isEmpty()?(String)var2.get(0):null;
   }

   // $FF: renamed from: b (java.util.Map, java.lang.String) long
   private static long method_2383(Map<String, List<String>> var0, String var1) {
      List var2 = (List)var0.get(var1);
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);

         float var5;
         try {
            var5 = Float.parseFloat(var3);
         } catch (NumberFormatException var6) {
            class_370.method_2358("Could not parse float from " + var1 + " header: " + var3);
            return -1L;
         }

         return (long)(var5 * 1000.0F);
      } else {
         return -1L;
      }
   }

   // $FF: renamed from: c (java.util.Map, java.lang.String) java.util.List
   private static List<String> method_2384(Map<String, List<String>> var0, String var1) {
      List var2 = (List)var0.get(var1);
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);
         if(var3 != null) {
            return Arrays.asList(var3.trim().split("\\s+"));
         }
      }

      return null;
   }

   // $FF: renamed from: e (java.util.Map) void
   private void method_2385(Map<String, List<String>> var1) {
      this.field_1618 = method_2382(var1, "X-Afma-Ad-Size");
   }

   // $FF: renamed from: f (java.util.Map) void
   private void method_2386(Map<String, List<String>> var1) {
      List var2 = method_2384(var1, "X-Afma-Click-Tracking-Urls");
      if(var2 != null) {
         this.field_1621 = var2;
      }

   }

   // $FF: renamed from: g (java.util.Map) void
   private void method_2387(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Debug-Dialog");
      if(var2 != null && !var2.isEmpty()) {
         this.field_1622 = (String)var2.get(0);
      }

   }

   // $FF: renamed from: h (java.util.Map) void
   private void method_2388(Map<String, List<String>> var1) {
      List var2 = method_2384(var1, "X-Afma-Tracking-Urls");
      if(var2 != null) {
         this.field_1624 = var2;
      }

   }

   // $FF: renamed from: i (java.util.Map) void
   private void method_2389(Map<String, List<String>> var1) {
      long var2 = method_2383(var1, "X-Afma-Interstitial-Timeout");
      if(var2 != -1L) {
         this.field_1625 = var2;
      }

   }

   // $FF: renamed from: j (java.util.Map) void
   private void method_2390(Map<String, List<String>> var1) {
      this.field_1623 = method_2382(var1, "X-Afma-ActiveView");
   }

   // $FF: renamed from: k (java.util.Map) void
   private void method_2391(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Mediation");
      if(var2 != null && !var2.isEmpty()) {
         this.field_1626 = Boolean.valueOf((String)var2.get(0)).booleanValue();
      }

   }

   // $FF: renamed from: l (java.util.Map) void
   private void method_2392(Map<String, List<String>> var1) {
      List var2 = method_2384(var1, "X-Afma-Manual-Tracking-Urls");
      if(var2 != null) {
         this.field_1628 = var2;
      }

   }

   // $FF: renamed from: m (java.util.Map) void
   private void method_2393(Map<String, List<String>> var1) {
      long var2 = method_2383(var1, "X-Afma-Refresh-Rate");
      if(var2 != -1L) {
         this.field_1629 = var2;
      }

   }

   // $FF: renamed from: n (java.util.Map) void
   private void method_2394(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Orientation");
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);
         if("portrait".equalsIgnoreCase(var3)) {
            this.mOrientation = class_365.method_2305();
         } else if("landscape".equalsIgnoreCase(var3)) {
            this.mOrientation = class_365.method_2304();
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, java.util.Map, java.lang.String) void
   public void method_2395(String var1, Map<String, List<String>> var2, String var3) {
      this.field_1619 = var1;
      this.field_1620 = var3;
      this.method_2396(var2);
   }

   // $FF: renamed from: d (java.util.Map) void
   public void method_2396(Map<String, List<String>> var1) {
      this.method_2385(var1);
      this.method_2386(var1);
      this.method_2387(var1);
      this.method_2388(var1);
      this.method_2389(var1);
      this.method_2391(var1);
      this.method_2392(var1);
      this.method_2393(var1);
      this.method_2394(var1);
      this.method_2390(var1);
   }

   // $FF: renamed from: i (long) com.google.android.gms.internal.dv
   public class_431 method_2397(long var1) {
      return new class_431(this.field_1619, this.field_1620, this.field_1621, this.field_1624, this.field_1625, this.field_1626, -1L, this.field_1628, this.field_1629, this.mOrientation, this.field_1618, var1, this.field_1622, this.field_1623);
   }
}
