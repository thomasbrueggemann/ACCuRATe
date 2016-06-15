package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.class_1055;
import com.google.android.gms.analytics.class_169;
import com.google.android.gms.analytics.class_172;
import com.google.android.gms.analytics.class_179;
import com.google.android.gms.analytics.class_838;
import com.google.android.gms.analytics.class_843;
import com.google.android.gms.analytics.class_846;
import com.google.android.gms.analytics.class_849;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_865;
import com.google.android.gms.internal.class_400;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.google.android.gms.analytics.x
class class_847 extends Thread implements class_169 {
   // $FF: renamed from: zM com.google.android.gms.analytics.x
   private static class_847 field_3519;
   private volatile boolean mClosed = false;
   private final Context mContext;
   // $FF: renamed from: zJ java.util.concurrent.LinkedBlockingQueue
   private final LinkedBlockingQueue<Runnable> field_3520 = new LinkedBlockingQueue();
   // $FF: renamed from: zK boolean
   private volatile boolean field_3521 = false;
   // $FF: renamed from: zL java.lang.String
   private volatile String field_3522;
   // $FF: renamed from: zN com.google.android.gms.analytics.ak
   private volatile class_179 field_3523;
   // $FF: renamed from: zO java.util.concurrent.locks.Lock
   private final Lock field_3524;
   // $FF: renamed from: zP java.util.List
   private final List<ha> field_3525 = new ArrayList();

   private class_847(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.field_3525.add(new class_400("appendVersion", "&_v".substring(1), "ma4.0.4"));
      this.field_3524 = new ReentrantLock();
      this.start();
   }

   // $FF: renamed from: A (android.content.Context) com.google.android.gms.analytics.x
   static class_847 method_4677(Context var0) {
      if(field_3519 == null) {
         field_3519 = new class_847(var0);
      }

      return field_3519;
   }

   // $FF: renamed from: B (android.content.Context) java.lang.String
   static String method_4678(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ah (java.lang.String) int
   static int method_4681(String var0) {
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

   // $FF: renamed from: b (java.lang.Runnable) void
   private void method_4683(Runnable var1) {
      this.field_3520.add(var1);
   }

   // $FF: renamed from: g (java.lang.Throwable) java.lang.String
   private String method_4686(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   // $FF: renamed from: dQ () void
   public void method_845() {
      this.method_4683(new class_847.class_1303());
   }

   // $FF: renamed from: dW () void
   public void method_846() {
      this.method_4683(new class_847.class_1305());
   }

   // $FF: renamed from: dX () java.util.concurrent.LinkedBlockingQueue
   public LinkedBlockingQueue<Runnable> method_847() {
      return this.field_3520;
   }

   // $FF: renamed from: dY () void
   public void method_848() {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      this.method_4683(new class_847.class_1302());
   }

   public Thread getThread() {
      return this;
   }

   protected void init() {
      // $FF: Couldn't be decompiled
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: u (java.util.Map) void
   public void method_849(Map<String, String> var1) {
      this.method_4683(new class_847.class_1304(var1));
   }

   private class class_1303 implements Runnable {
      private class_1303() {
      }

      // $FF: synthetic method
      class_1303(Object var2) {
         this();
      }

      public void run() {
         class_847.this.field_3523.method_892();
      }
   }

   private class class_1302 implements Runnable {
      private class_1302() {
      }

      // $FF: synthetic method
      class_1302(Object var2) {
         this();
      }

      public void run() {
         class_847.this.field_3523.dispatch();
      }
   }

   private class class_1305 implements Runnable {
      private class_1305() {
      }

      // $FF: synthetic method
      class_1305(Object var2) {
         this();
      }

      public void run() {
         class_847.this.field_3523.method_893();
      }
   }

   private class class_1304 implements Runnable {
      // $FF: renamed from: zR java.util.Map
      private final Map<String, String> field_2575;

      class_1304(Map<String, String> var1) {
         this.field_2575 = new HashMap(var2);
         String var3 = (String)var2.get("&ht");
         if(var3 != null) {
            try {
               Long.valueOf(var3);
            } catch (NumberFormatException var8) {
               var3 = null;
            }
         }

         if(var3 == null) {
            long var4 = System.currentTimeMillis();
            this.field_2575.put("&ht", Long.toString(var4));
         }

      }

      // $FF: renamed from: v (java.util.Map) java.lang.String
      private String method_3397(Map<String, String> var1) {
         return var1.containsKey("useSecure")?(class_1055.method_5799((String)var1.get("useSecure"), true)?"https:":"http:"):"https:";
      }

      // $FF: renamed from: w (java.util.Map) void
      private void method_3398(Map<String, String> var1) {
         class_172 var2 = class_846.method_4673(class_847.this.mContext);
         class_1055.method_5794(var1, "&adid", var2);
         class_1055.method_5794(var1, "&ate", var2);
      }

      // $FF: renamed from: x (java.util.Map) void
      private void method_3399(Map<String, String> var1) {
         class_838 var2 = class_838.method_4635();
         class_1055.method_5794(var1, "&an", var2);
         class_1055.method_5794(var1, "&av", var2);
         class_1055.method_5794(var1, "&aid", var2);
         class_1055.method_5794(var1, "&aiid", var2);
         var1.put("&v", "1");
      }

      // $FF: renamed from: y (java.util.Map) boolean
      private boolean method_3400(Map<String, String> var1) {
         if(var1.get("&sf") == null) {
            return false;
         } else {
            double var2 = class_1055.method_5792((String)var1.get("&sf"), 100.0D);
            if(var2 >= 100.0D) {
               return false;
            } else if((double)(class_847.method_4681((String)var1.get("&cid")) % 10000) >= var2 * 100.0D) {
               String var4;
               if(var1.get("&t") == null) {
                  var4 = "unknown";
               } else {
                  var4 = (String)var1.get("&t");
               }

               class_863.method_4841(String.format("%s hit sampled out", new Object[]{var4}));
               return true;
            } else {
               return false;
            }
         }
      }

      public void run() {
         this.method_3398(this.field_2575);
         if(TextUtils.isEmpty((CharSequence)this.field_2575.get("&cid"))) {
            this.field_2575.put("&cid", class_843.method_4653().getValue("&cid"));
         }

         if(!GoogleAnalytics.getInstance(class_847.this.mContext).getAppOptOut() && !this.method_3400(this.field_2575)) {
            if(!TextUtils.isEmpty(class_847.this.field_3522)) {
               class_849.method_4705().method_4706(true);
               this.field_2575.putAll((new HitBuilders.HitBuilder()).setCampaignParamsFromUrl(class_847.this.field_3522).build());
               class_849.method_4705().method_4706(false);
               class_847.this.field_3522 = null;
            }

            this.method_3399(this.field_2575);
            Map var1 = class_865.method_4851(this.field_2575);
            class_847.this.field_3523.method_891(var1, Long.valueOf((String)this.field_2575.get("&ht")).longValue(), this.method_3397(this.field_2575), class_847.this.field_3525);
         }
      }
   }
}
