package com.google.ads.conversiontracking;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import com.google.ads.conversiontracking.class_4;
import com.google.ads.conversiontracking.class_79;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.ads.conversiontracking.c
public class class_75 implements Runnable {
   // $FF: renamed from: a long
   private static final long field_556;
   // $FF: renamed from: b long
   private static final long field_557;
   // $FF: renamed from: c java.lang.Object
   private static Object field_558;
   // $FF: renamed from: d com.google.ads.conversiontracking.c
   private static class_75 field_559;
   // $FF: renamed from: e long
   private final long field_560;
   // $FF: renamed from: f long
   private final long field_561;
   // $FF: renamed from: g com.google.ads.conversiontracking.b
   private final class_4 field_562;
   // $FF: renamed from: h android.content.Context
   private final Context field_563;
   // $FF: renamed from: i android.os.HandlerThread
   private final HandlerThread field_564;
   // $FF: renamed from: j java.lang.Object
   private final Object field_565 = new Object();
   // $FF: renamed from: k java.util.Set
   private final Set<String> field_566;
   // $FF: renamed from: l java.util.Map
   private final Map<String, Long> field_567;
   // $FF: renamed from: m android.content.SharedPreferences
   private final SharedPreferences field_568;
   // $FF: renamed from: n long
   private long field_569;
   // $FF: renamed from: o android.os.Handler
   private Handler field_570;

   static {
      field_556 = TimeUnit.SECONDS.toMillis(3600L);
      field_557 = TimeUnit.SECONDS.toMillis(30L);
      field_558 = new Object();
   }

   class_75(Context var1, long var2, long var4, class_4 var6) {
      this.field_563 = var1;
      this.field_561 = var2;
      this.field_560 = var4;
      this.field_562 = var6;
      this.field_567 = new HashMap();
      this.field_566 = new HashSet();
      this.field_568 = this.field_563.getSharedPreferences("google_auto_usage", 0);
      this.method_514();
      this.field_564 = new HandlerThread("Google Conversion SDK", 10);
      this.field_564.start();
      this.field_570 = new Handler(this.field_564.getLooper());
      this.method_513();
   }

   // $FF: renamed from: a (android.content.Context) com.google.ads.conversiontracking.c
   public static class_75 method_510(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b () long
   private long method_511() {
      long var1 = class_79.method_522();
      long var3 = 0L;
      if(var1 >= this.field_569) {
         var3 = 1L + (var1 - this.field_569) / this.field_561;
      }

      return this.field_569 + var3 * this.field_561;
   }

   // $FF: renamed from: b (long) void
   private void method_512(long var1) {
      this.field_568.edit().putLong("end_of_interval", var1).commit();
      this.field_569 = var1;
   }

   // $FF: renamed from: c () void
   private void method_513() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d () void
   private void method_514() {
      if(this.field_569 == 0L) {
         long var1 = class_79.method_522() + this.field_561;
         this.field_569 = this.field_568.getLong("end_of_interval", var1);
      }

   }

   // $FF: renamed from: a (long) void
   protected void method_515(long param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a () boolean
   protected boolean method_516() {
      ActivityManager var1 = (ActivityManager)this.field_563.getSystemService("activity");
      KeyguardManager var2 = (KeyguardManager)this.field_563.getSystemService("keyguard");
      PowerManager var3 = (PowerManager)this.field_563.getSystemService("power");
      List var4 = var1.getRunningAppProcesses();
      if(var4 == null) {
         return false;
      } else {
         Iterator var5 = var4.iterator();

         RunningAppProcessInfo var6;
         do {
            if(!var5.hasNext()) {
               return false;
            }

            var6 = (RunningAppProcessInfo)var5.next();
         } while(Process.myPid() != var6.pid || var6.importance != 100 || var2.inKeyguardRestrictedInputMode() || !var3.isScreenOn());

         return true;
      }
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_517(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (java.lang.String) boolean
   public boolean method_518(String var1) {
      return this.field_567.containsKey(var1);
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
