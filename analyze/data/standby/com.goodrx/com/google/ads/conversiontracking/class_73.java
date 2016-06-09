package com.google.ads.conversiontracking;

import android.content.Context;
import com.google.ads.conversiontracking.class_74;
import com.google.ads.conversiontracking.class_76;
import com.google.ads.conversiontracking.class_79;
import com.google.ads.conversiontracking.d;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.ads.conversiontracking.e
public class class_73 {
   // $FF: renamed from: a java.lang.Object
   private final Object field_547 = new Object();
   // $FF: renamed from: b java.util.List
   private final List<d> field_548;
   // $FF: renamed from: c android.content.Context
   private Context field_549;
   // $FF: renamed from: d boolean
   private boolean field_550 = true;
   // $FF: renamed from: e boolean
   private boolean field_551 = false;
   // $FF: renamed from: f com.google.ads.conversiontracking.f
   private class_74 field_552;

   public class_73(Context var1) {
      this.field_549 = var1;
      this.field_552 = new class_74(var1);
      this.field_548 = new LinkedList();
      (new Thread(new class_73.class_111())).start();
      ScheduledThreadPoolExecutor var2 = new ScheduledThreadPoolExecutor(1);
      long var3 = class_79.method_542(var1);
      long var5 = class_79.method_522();
      long var7 = var3 + 300000L - var5;
      class_73.class_110 var9 = new class_73.class_110(null);
      if(var7 <= 0L) {
         var7 = 0L;
      }

      var2.scheduleAtFixedRate(var9, var7, 300000L, TimeUnit.MILLISECONDS);
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.e) java.lang.Object
   // $FF: synthetic method
   static Object method_488(class_73 var0) {
      return var0.field_547;
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.e, boolean) boolean
   // $FF: synthetic method
   static boolean method_489(class_73 var0, boolean var1) {
      var0.field_550 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.google.ads.conversiontracking.e) boolean
   // $FF: synthetic method
   static boolean method_490(class_73 var0) {
      return var0.field_551;
   }

   // $FF: renamed from: b (com.google.ads.conversiontracking.e, boolean) boolean
   // $FF: synthetic method
   static boolean method_491(class_73 var0, boolean var1) {
      var0.field_551 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.google.ads.conversiontracking.e) android.content.Context
   // $FF: synthetic method
   static Context method_492(class_73 var0) {
      return var0.field_549;
   }

   // $FF: renamed from: d (com.google.ads.conversiontracking.e) boolean
   // $FF: synthetic method
   static boolean method_493(class_73 var0) {
      return var0.field_550;
   }

   // $FF: renamed from: e (com.google.ads.conversiontracking.e) com.google.ads.conversiontracking.f
   // $FF: synthetic method
   static class_74 method_494(class_73 var0) {
      return var0.field_552;
   }

   // $FF: renamed from: f (com.google.ads.conversiontracking.e) java.util.List
   // $FF: synthetic method
   static List method_495(class_73 var0) {
      return var0.field_548;
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.d) int
   protected int method_496(class_76 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.Runnable) void
   protected void method_497(Runnable var1) {
      (new Thread(var1)).start();
   }

   // $FF: renamed from: a (java.lang.String, com.google.ads.conversiontracking.g$c, boolean, boolean, boolean) void
   public void method_498(String param1, class_79.class_95 param2, boolean param3, boolean param4, boolean param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.ads.conversiontracking.d) void
   protected void method_499(class_76 var1) {
      if(!var1.field_572 && var1.field_571) {
         class_79.method_535(this.field_549, var1.field_575, var1.field_576);
      }

   }

   private class class_110 implements Runnable {
      private class_110() {
      }

      // $FF: synthetic method
      class_110(Object var2) {
         this();
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   public class class_111 implements Runnable {
      // $FF: renamed from: a long
      protected long field_476 = 0L;

      // $FF: renamed from: a () void
      private void method_370() {
         if(this.field_476 == 0L) {
            this.field_476 = 1000L;
         } else {
            this.field_476 = Math.min(2L * this.field_476, 60000L);
         }
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
