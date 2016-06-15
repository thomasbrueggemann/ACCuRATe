package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.class_134;
import com.google.android.gms.analytics.class_138;
import com.google.android.gms.analytics.class_147;
import com.google.android.gms.analytics.class_642;
import com.google.android.gms.analytics.class_643;
import com.google.android.gms.analytics.class_653;
import com.google.android.gms.analytics.class_657;
import com.google.android.gms.analytics.class_659;
import com.google.android.gms.analytics.class_660;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_671;
import com.google.android.gms.internal.class_395;
import com.google.android.gms.internal.fe;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.analytics.t
class class_658 extends Thread implements class_134 {
   // $FF: renamed from: uL com.google.android.gms.analytics.t
   private static class_658 field_3436;
   private volatile boolean mClosed = false;
   private final Context mContext;
   // $FF: renamed from: uH java.util.concurrent.LinkedBlockingQueue
   private final LinkedBlockingQueue<Runnable> field_3437 = new LinkedBlockingQueue();
   // $FF: renamed from: uI boolean
   private volatile boolean field_3438 = false;
   // $FF: renamed from: uJ java.util.List
   private volatile List<fe> field_3439;
   // $FF: renamed from: uK java.lang.String
   private volatile String field_3440;
   // $FF: renamed from: uM com.google.android.gms.analytics.ag
   private volatile class_147 field_3441;

   private class_658(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.start();
   }

   // $FF: renamed from: O (java.lang.String) int
   static int method_3756(String var0) {
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

   // $FF: renamed from: a (java.lang.Throwable) java.lang.String
   private String method_3759(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   // $FF: renamed from: q (java.util.Map) java.lang.String
   private String method_3767(Map<String, String> var1) {
      return var1.containsKey("useSecure")?(class_671.method_3911((String)var1.get("useSecure"), true)?"https:":"http:"):"https:";
   }

   // $FF: renamed from: r (java.util.Map) boolean
   private boolean method_3768(Map<String, String> var1) {
      if(var1.get("&sf") == null) {
         return false;
      } else {
         double var2 = class_671.method_3908((String)var1.get("&sf"), 100.0D);
         if(var2 >= 100.0D) {
            return false;
         } else if((double)(method_3756((String)var1.get("&cid")) % 10000) >= var2 * 100.0D) {
            String var4;
            if(var1.get("&t") == null) {
               var4 = "unknown";
            } else {
               var4 = (String)var1.get("&t");
            }

            class_669.method_3890(String.format("%s hit sampled out", new Object[]{var4}));
            return true;
         } else {
            return false;
         }
      }
   }

   // $FF: renamed from: s (java.util.Map) void
   private void method_3769(Map<String, String> var1) {
      class_138 var2 = class_653.method_3734(this.mContext);
      class_671.method_3910(var1, "&adid", var2.getValue("&adid"));
      class_671.method_3910(var1, "&ate", var2.getValue("&ate"));
   }

   // $FF: renamed from: t (java.util.Map) void
   private void method_3770(Map<String, String> var1) {
      class_642 var2 = class_642.method_3680();
      class_671.method_3910(var1, "&an", var2.getValue("&an"));
      class_671.method_3910(var1, "&av", var2.getValue("&av"));
      class_671.method_3910(var1, "&aid", var2.getValue("&aid"));
      class_671.method_3910(var1, "&aiid", var2.getValue("&aiid"));
      var1.put("&v", "1");
   }

   // $FF: renamed from: u (android.content.Context) com.google.android.gms.analytics.t
   static class_658 method_3771(Context var0) {
      if(field_3436 == null) {
         field_3436 = new class_658(var0);
      }

      return field_3436;
   }

   // $FF: renamed from: v (android.content.Context) java.lang.String
   static String method_3772(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.Runnable) void
   void method_3773(Runnable var1) {
      this.field_3437.add(var1);
   }

   // $FF: renamed from: cg () void
   public void method_699() {
      this.method_3773(new Runnable() {
         public void run() {
            class_658.this.field_3441.method_753();
         }
      });
   }

   // $FF: renamed from: cl () void
   public void method_700() {
      this.method_3773(new Runnable() {
         public void run() {
            class_658.this.field_3441.method_754();
         }
      });
   }

   // $FF: renamed from: cn () void
   public void method_701() {
      this.method_3773(new Runnable() {
         public void run() {
            class_658.this.field_3441.method_755();
         }
      });
   }

   // $FF: renamed from: co () java.util.concurrent.LinkedBlockingQueue
   public LinkedBlockingQueue<Runnable> method_702() {
      return this.field_3437;
   }

   public Thread getThread() {
      return this;
   }

   protected void init() {
      this.field_3441.method_752();
      this.field_3439 = new ArrayList();
      this.field_3439.add(new class_395("appendVersion", "&_v".substring(1), "ma4.0.2"));
      this.field_3439.add(new class_395("appendQueueTime", "&qt".substring(1), (String)null));
      this.field_3439.add(new class_395("appendCacheBuster", "&z".substring(1), (String)null));
   }

   // $FF: renamed from: p (java.util.Map) void
   public void method_703(Map<String, String> var1) {
      final HashMap var2 = new HashMap(var1);
      String var3 = (String)var1.get("&ht");
      if(var3 != null) {
         try {
            Long.valueOf(var3);
         } catch (NumberFormatException var6) {
            var3 = null;
         }
      }

      if(var3 == null) {
         var2.put("&ht", Long.toString(System.currentTimeMillis()));
      }

      this.method_3773(new Runnable() {
         public void run() {
            class_658.this.method_3769(var2);
            if(TextUtils.isEmpty((CharSequence)var2.get("&cid"))) {
               var2.put("&cid", class_643.method_3687().getValue("&cid"));
            }

            if(!GoogleAnalytics.getInstance(class_658.this.mContext).getAppOptOut() && !class_658.this.method_3768(var2)) {
               if(!TextUtils.isEmpty(class_658.this.field_3440)) {
                  class_660.method_3794().method_3798(true);
                  var2.putAll((new HitBuilders.HitBuilder()).setCampaignParamsFromUrl(class_658.this.field_3440).build());
                  class_660.method_3794().method_3798(false);
                  class_658.this.field_3440 = null;
               }

               class_658.this.method_3770(var2);
               Map var1 = class_657.method_3755(var2);
               class_658.this.field_3441.method_751(var1, Long.valueOf((String)var2.get("&ht")).longValue(), class_658.this.method_3767(var2), class_658.this.field_3439);
            }
         }
      });
   }

   public void run() {
      Process.setThreadPriority(10);

      try {
         Thread.sleep(5000L);
      } catch (InterruptedException var9) {
         class_669.method_3891("sleep interrupted in GAThread initialize");
      }

      try {
         if(this.field_3441 == null) {
            this.field_3441 = new class_659(this.mContext, this);
         }

         this.init();
         this.field_3440 = method_3772(this.mContext);
         class_669.method_3890("Initialized GA Thread");
      } catch (Throwable var8) {
         class_669.method_3888("Error initializing the GAThread: " + this.method_3759(var8));
         class_669.method_3888("Google Analytics will not start up.");
         this.field_3438 = true;
      }

      while(!this.mClosed) {
         try {
            try {
               Runnable var5 = (Runnable)this.field_3437.take();
               if(!this.field_3438) {
                  var5.run();
               }
            } catch (InterruptedException var6) {
               class_669.method_3889(var6.toString());
            }
         } catch (Throwable var7) {
            class_669.method_3888("Error on GAThread: " + this.method_3759(var7));
            class_669.method_3888("Google Analytics is shutting down.");
            this.field_3438 = true;
         }
      }

   }
}
