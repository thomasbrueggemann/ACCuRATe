package com.google.android.gms.internal;

import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.ey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ft
@ey
public final class class_424 {
   private int mOrientation = -1;
   // $FF: renamed from: pD java.lang.String
   private String field_1336;
   // $FF: renamed from: uJ java.lang.String
   private String field_1337;
   // $FF: renamed from: uK java.lang.String
   private String field_1338;
   // $FF: renamed from: uL java.util.List
   private List<String> field_1339;
   // $FF: renamed from: uM java.lang.String
   private String field_1340;
   // $FF: renamed from: uN java.lang.String
   private String field_1341;
   // $FF: renamed from: uO java.util.List
   private List<String> field_1342;
   // $FF: renamed from: uP long
   private long field_1343 = -1L;
   // $FF: renamed from: uQ boolean
   private boolean field_1344 = false;
   // $FF: renamed from: uR long
   private final long field_1345 = -1L;
   // $FF: renamed from: uS long
   private long field_1346 = -1L;
   // $FF: renamed from: uT boolean
   private boolean field_1347 = false;
   // $FF: renamed from: uU boolean
   private boolean field_1348 = false;
   // $FF: renamed from: uV boolean
   private boolean field_1349 = false;
   // $FF: renamed from: uW boolean
   private boolean field_1350 = true;
   // $FF: renamed from: uo java.util.List
   private List<String> field_1351;

   // $FF: renamed from: a (java.util.Map, java.lang.String) java.lang.String
   static String method_2794(Map<String, List<String>> var0, String var1) {
      List var2 = (List)var0.get(var1);
      return var2 != null && !var2.isEmpty()?(String)var2.get(0):null;
   }

   // $FF: renamed from: b (java.util.Map, java.lang.String) long
   static long method_2795(Map<String, List<String>> var0, String var1) {
      List var2 = (List)var0.get(var1);
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);

         float var5;
         try {
            var5 = Float.parseFloat(var3);
         } catch (NumberFormatException var6) {
            class_368.method_2506("Could not parse float from " + var1 + " header: " + var3);
            return -1L;
         }

         return (long)(var5 * 1000.0F);
      } else {
         return -1L;
      }
   }

   // $FF: renamed from: c (java.util.Map, java.lang.String) java.util.List
   static List<String> method_2796(Map<String, List<String>> var0, String var1) {
      List var2 = (List)var0.get(var1);
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);
         if(var3 != null) {
            return Arrays.asList(var3.trim().split("\\s+"));
         }
      }

      return null;
   }

   // $FF: renamed from: d (java.util.Map, java.lang.String) boolean
   private boolean method_2797(Map<String, List<String>> var1, String var2) {
      List var3 = (List)var1.get(var2);
      return var3 != null && !var3.isEmpty() && Boolean.valueOf((String)var3.get(0)).booleanValue();
   }

   // $FF: renamed from: f (java.util.Map) void
   private void method_2798(Map<String, List<String>> var1) {
      this.field_1337 = method_2794(var1, "X-Afma-Ad-Size");
   }

   // $FF: renamed from: g (java.util.Map) void
   private void method_2799(Map<String, List<String>> var1) {
      List var2 = method_2796(var1, "X-Afma-Click-Tracking-Urls");
      if(var2 != null) {
         this.field_1339 = var2;
      }

   }

   // $FF: renamed from: h (java.util.Map) void
   private void method_2800(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Debug-Dialog");
      if(var2 != null && !var2.isEmpty()) {
         this.field_1340 = (String)var2.get(0);
      }

   }

   // $FF: renamed from: i (java.util.Map) void
   private void method_2801(Map<String, List<String>> var1) {
      List var2 = method_2796(var1, "X-Afma-Tracking-Urls");
      if(var2 != null) {
         this.field_1342 = var2;
      }

   }

   // $FF: renamed from: j (java.util.Map) void
   private void method_2802(Map<String, List<String>> var1) {
      long var2 = method_2795(var1, "X-Afma-Interstitial-Timeout");
      if(var2 != -1L) {
         this.field_1343 = var2;
      }

   }

   // $FF: renamed from: k (java.util.Map) void
   private void method_2803(Map<String, List<String>> var1) {
      this.field_1341 = method_2794(var1, "X-Afma-ActiveView");
   }

   // $FF: renamed from: l (java.util.Map) void
   private void method_2804(Map<String, List<String>> var1) {
      this.field_1348 |= this.method_2797(var1, "X-Afma-Native");
   }

   // $FF: renamed from: m (java.util.Map) void
   private void method_2805(Map<String, List<String>> var1) {
      this.field_1347 |= this.method_2797(var1, "X-Afma-Custom-Rendering-Allowed");
   }

   // $FF: renamed from: n (java.util.Map) void
   private void method_2806(Map<String, List<String>> var1) {
      this.field_1344 |= this.method_2797(var1, "X-Afma-Mediation");
   }

   // $FF: renamed from: o (java.util.Map) void
   private void method_2807(Map<String, List<String>> var1) {
      List var2 = method_2796(var1, "X-Afma-Manual-Tracking-Urls");
      if(var2 != null) {
         this.field_1351 = var2;
      }

   }

   // $FF: renamed from: p (java.util.Map) void
   private void method_2808(Map<String, List<String>> var1) {
      long var2 = method_2795(var1, "X-Afma-Refresh-Rate");
      if(var2 != -1L) {
         this.field_1346 = var2;
      }

   }

   // $FF: renamed from: q (java.util.Map) void
   private void method_2809(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Orientation");
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);
         if("portrait".equalsIgnoreCase(var3)) {
            this.mOrientation = class_375.method_2572();
         } else if("landscape".equalsIgnoreCase(var3)) {
            this.mOrientation = class_375.method_2571();
            return;
         }
      }

   }

   // $FF: renamed from: r (java.util.Map) void
   private void method_2810(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Use-HTTPS");
      if(var2 != null && !var2.isEmpty()) {
         this.field_1349 = Boolean.valueOf((String)var2.get(0)).booleanValue();
      }

   }

   // $FF: renamed from: s (java.util.Map) void
   private void method_2811(Map<String, List<String>> var1) {
      List var2 = (List)var1.get("X-Afma-Content-Url-Opted-Out");
      if(var2 != null && !var2.isEmpty()) {
         this.field_1350 = Boolean.valueOf((String)var2.get(0)).booleanValue();
      }

   }

   // $FF: renamed from: a (java.lang.String, java.util.Map, java.lang.String) void
   public void method_2812(String var1, Map<String, List<String>> var2, String var3) {
      this.field_1338 = var1;
      this.field_1336 = var3;
      this.method_2813(var2);
   }

   // $FF: renamed from: e (java.util.Map) void
   public void method_2813(Map<String, List<String>> var1) {
      this.method_2798(var1);
      this.method_2799(var1);
      this.method_2800(var1);
      this.method_2801(var1);
      this.method_2802(var1);
      this.method_2806(var1);
      this.method_2807(var1);
      this.method_2808(var1);
      this.method_2809(var1);
      this.method_2803(var1);
      this.method_2810(var1);
      this.method_2805(var1);
      this.method_2804(var1);
      this.method_2811(var1);
   }

   // $FF: renamed from: i (long) com.google.android.gms.internal.fj
   public class_438 method_2814(long var1) {
      return new class_438(this.field_1338, this.field_1336, this.field_1339, this.field_1342, this.field_1343, this.field_1344, -1L, this.field_1351, this.field_1346, this.mOrientation, this.field_1337, var1, this.field_1340, this.field_1341, this.field_1347, this.field_1348, this.field_1349, this.field_1350);
   }
}
