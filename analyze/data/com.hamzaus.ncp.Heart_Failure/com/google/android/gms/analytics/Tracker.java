package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.class_136;
import com.google.android.gms.analytics.class_143;
import com.google.android.gms.analytics.class_642;
import com.google.android.gms.analytics.class_643;
import com.google.android.gms.analytics.class_656;
import com.google.android.gms.analytics.class_660;
import com.google.android.gms.analytics.class_666;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_670;
import com.google.android.gms.analytics.class_671;
import com.google.android.gms.internal.class_347;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
   private Context mContext;
   // $FF: renamed from: xb com.google.android.gms.analytics.TrackerHandler
   private final TrackerHandler field_3165;
   // $FF: renamed from: xc java.util.Map
   private final Map<String, String> field_3166;
   // $FF: renamed from: xd com.google.android.gms.analytics.ad
   private class_143 field_3167;
   // $FF: renamed from: xe com.google.android.gms.analytics.h
   private final class_643 field_3168;
   // $FF: renamed from: xf com.google.android.gms.analytics.ae
   private final class_666 field_3169;
   // $FF: renamed from: xg com.google.android.gms.analytics.g
   private final class_642 field_3170;
   // $FF: renamed from: xh boolean
   private boolean field_3171;
   // $FF: renamed from: xi com.google.android.gms.analytics.Tracker$a
   private Tracker.class_825 field_3172;
   // $FF: renamed from: xj com.google.android.gms.analytics.aj
   private class_670 field_3173;
   // $FF: renamed from: xk com.google.android.gms.analytics.ExceptionReporter
   private ExceptionReporter field_3174;

   Tracker(String var1, TrackerHandler var2, Context var3) {
      this(var1, var2, class_643.method_3687(), class_666.method_3867(), class_642.method_3680(), new class_656("tracking"), var3);
   }

   Tracker(String var1, TrackerHandler var2, class_643 var3, class_666 var4, class_642 var5, class_143 var6, Context var7) {
      this.field_3166 = new HashMap();
      this.field_3165 = var2;
      if(var7 != null) {
         this.mContext = var7.getApplicationContext();
      }

      if(var1 != null) {
         this.field_3166.put("&tid", var1);
      }

      this.field_3166.put("useSecure", "1");
      this.field_3168 = var3;
      this.field_3169 = var4;
      this.field_3170 = var5;
      this.field_3166.put("&a", Integer.toString(1 + (new Random()).nextInt(Integer.MAX_VALUE)));
      this.field_3167 = var6;
      this.field_3172 = new Tracker.class_825();
      this.enableAdvertisingIdCollection(false);
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.aj) void
   void method_3427(class_670 var1) {
      class_669.method_3890("Loading Tracker config values.");
      this.field_3173 = var1;
      if(this.field_3173.method_3903()) {
         String var3 = this.field_3173.method_3894();
         this.set("&tid", var3);
         class_669.method_3890("[Tracker] trackingId loaded: " + var3);
      }

      if(this.field_3173.method_3895()) {
         String var2 = Double.toString(this.field_3173.method_3896());
         this.set("&sf", var2);
         class_669.method_3890("[Tracker] sample frequency loaded: " + var2);
      }

      if(this.field_3173.method_3897()) {
         this.setSessionTimeout((long)this.field_3173.getSessionTimeout());
         class_669.method_3890("[Tracker] session timeout loaded: " + this.method_3428());
      }

      if(this.field_3173.method_3898()) {
         this.enableAutoActivityTracking(this.field_3173.method_3899());
         class_669.method_3890("[Tracker] auto activity tracking loaded: " + this.method_3429());
      }

      if(this.field_3173.method_3900()) {
         if(this.field_3173.method_3901()) {
            this.set("&aip", "1");
            class_669.method_3890("[Tracker] anonymize ip loaded: true");
         }

         class_669.method_3890("[Tracker] anonymize ip loaded: false");
      }

      this.enableExceptionReporting(this.field_3173.method_3902());
   }

   // $FF: renamed from: dt () long
   long method_3428() {
      return this.field_3172.method_1863();
   }

   // $FF: renamed from: du () boolean
   boolean method_3429() {
      return this.field_3172.method_1864();
   }

   public void enableAdvertisingIdCollection(boolean var1) {
      if(!var1) {
         this.field_3166.put("&ate", (Object)null);
         this.field_3166.put("&adid", (Object)null);
      } else {
         if(this.field_3166.containsKey("&ate")) {
            this.field_3166.remove("&ate");
         }

         if(this.field_3166.containsKey("&adid")) {
            this.field_3166.remove("&adid");
            return;
         }
      }

   }

   public void enableAutoActivityTracking(boolean var1) {
      this.field_3172.enableAutoActivityTracking(var1);
   }

   public void enableExceptionReporting(boolean var1) {
      if(this.field_3171 != var1) {
         this.field_3171 = var1;
         if(var1) {
            this.field_3174 = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
            Thread.setDefaultUncaughtExceptionHandler(this.field_3174);
            class_669.method_3890("Uncaught exceptions will be reported to Google Analytics.");
         } else {
            if(this.field_3174 != null) {
               Thread.setDefaultUncaughtExceptionHandler(this.field_3174.method_4211());
            } else {
               Thread.setDefaultUncaughtExceptionHandler((UncaughtExceptionHandler)null);
            }

            class_669.method_3890("Uncaught exceptions will not be reported to Google Analytics.");
         }
      }
   }

   public String get(String var1) {
      class_660.method_3794().method_3795(class_660.class_1313.field_3789);
      if(!TextUtils.isEmpty(var1)) {
         if(this.field_3166.containsKey(var1)) {
            return (String)this.field_3166.get(var1);
         }

         if(var1.equals("&ul")) {
            return class_671.method_3909(Locale.getDefault());
         }

         if(this.field_3168 != null && this.field_3168.method_3691(var1)) {
            return this.field_3168.getValue(var1);
         }

         if(this.field_3169 != null && this.field_3169.method_3869(var1)) {
            return this.field_3169.getValue(var1);
         }

         if(this.field_3170 != null && this.field_3170.method_3682(var1)) {
            return this.field_3170.getValue(var1);
         }
      }

      return null;
   }

   public void send(Map<String, String> var1) {
      class_660.method_3794().method_3795(class_660.class_1313.field_3791);
      HashMap var2 = new HashMap();
      var2.putAll(this.field_3166);
      if(var1 != null) {
         var2.putAll(var1);
      }

      if(TextUtils.isEmpty((CharSequence)var2.get("&tid"))) {
         class_669.method_3891(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
      }

      String var3 = (String)var2.get("&t");
      if(TextUtils.isEmpty(var3)) {
         class_669.method_3891(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
         var3 = "";
      }

      if(this.field_3172.method_1865()) {
         var2.put("&sc", "start");
      }

      String var4 = var3.toLowerCase();
      if("screenview".equals(var4) || "pageview".equals(var4) || "appview".equals(var4) || TextUtils.isEmpty(var4)) {
         int var5 = 1 + Integer.parseInt((String)this.field_3166.get("&a"));
         if(var5 >= Integer.MAX_VALUE) {
            var5 = 1;
         }

         this.field_3166.put("&a", Integer.toString(var5));
      }

      if(!var4.equals("transaction") && !var4.equals("item") && !this.field_3167.method_720()) {
         class_669.method_3891("Too many hits sent too quickly, rate limiting invoked.");
      } else {
         this.field_3165.method_2710(var2);
      }
   }

   public void set(String var1, String var2) {
      class_347.method_2166(var1, "Key should be non-null");
      class_660.method_3794().method_3795(class_660.class_1313.field_3790);
      this.field_3166.put(var1, var2);
   }

   public void setAnonymizeIp(boolean var1) {
      this.set("&aip", class_671.method_3912(var1));
   }

   public void setAppId(String var1) {
      this.set("&aid", var1);
   }

   public void setAppInstallerId(String var1) {
      this.set("&aiid", var1);
   }

   public void setAppName(String var1) {
      this.set("&an", var1);
   }

   public void setAppVersion(String var1) {
      this.set("&av", var1);
   }

   public void setClientId(String var1) {
      this.set("&cid", var1);
   }

   public void setEncoding(String var1) {
      this.set("&de", var1);
   }

   public void setHostname(String var1) {
      this.set("&dh", var1);
   }

   public void setLanguage(String var1) {
      this.set("&ul", var1);
   }

   public void setLocation(String var1) {
      this.set("&dl", var1);
   }

   public void setPage(String var1) {
      this.set("&dp", var1);
   }

   public void setReferrer(String var1) {
      this.set("&dr", var1);
   }

   public void setSampleRate(double var1) {
      this.set("&sf", Double.toHexString(var1));
   }

   public void setScreenColors(String var1) {
      this.set("&sd", var1);
   }

   public void setScreenName(String var1) {
      this.set("&cd", var1);
   }

   public void setScreenResolution(int var1, int var2) {
      if(var1 < 0 && var2 < 0) {
         class_669.method_3891("Invalid width or height. The values should be non-negative.");
      } else {
         this.set("&sr", var1 + "x" + var2);
      }
   }

   public void setSessionTimeout(long var1) {
      this.field_3172.setSessionTimeout(1000L * var1);
   }

   public void setTitle(String var1) {
      this.set("&dt", var1);
   }

   public void setUseSecure(boolean var1) {
      this.set("useSecure", class_671.method_3912(var1));
   }

   public void setViewportSize(String var1) {
      this.set("&vp", var1);
   }

   private class class_825 implements GoogleAnalytics.class_844 {
      // $FF: renamed from: ur com.google.android.gms.analytics.i
      private class_136 field_950 = new class_136() {
         public long currentTimeMillis() {
            return System.currentTimeMillis();
         }
      };
      // $FF: renamed from: xl boolean
      private boolean field_951 = false;
      // $FF: renamed from: xm int
      private int field_952 = 0;
      // $FF: renamed from: xn long
      private long field_953 = -1L;
      // $FF: renamed from: xo boolean
      private boolean field_954 = false;
      // $FF: renamed from: xp long
      private long field_955;

      // $FF: renamed from: dw () void
      private void method_1862() {
         GoogleAnalytics var1 = GoogleAnalytics.method_2715();
         if(var1 == null) {
            class_669.method_3888("GoogleAnalytics isn\'t initialized for the Tracker!");
         } else if(this.field_953 < 0L && !this.field_951) {
            var1.method_2721(Tracker.this.field_3172);
         } else {
            var1.method_2719(Tracker.this.field_3172);
         }
      }

      // $FF: renamed from: dt () long
      public long method_1863() {
         return this.field_953;
      }

      // $FF: renamed from: du () boolean
      public boolean method_1864() {
         return this.field_951;
      }

      // $FF: renamed from: dv () boolean
      public boolean method_1865() {
         boolean var1 = this.field_954;
         this.field_954 = false;
         return var1;
      }

      // $FF: renamed from: dx () boolean
      boolean method_1866() {
         return this.field_950.currentTimeMillis() >= this.field_955 + Math.max(1000L, this.field_953);
      }

      public void enableAutoActivityTracking(boolean var1) {
         this.field_951 = var1;
         this.method_1862();
      }

      // $FF: renamed from: h (android.app.Activity) void
      public void method_190(Activity var1) {
         class_660.method_3794().method_3795(class_660.class_1313.field_3814);
         if(this.field_952 == 0 && this.method_1866()) {
            this.field_954 = true;
         }

         ++this.field_952;
         if(this.field_951) {
            HashMap var2 = new HashMap();
            var2.put("&t", "screenview");
            class_660.method_3794().method_3798(true);
            Tracker var4 = Tracker.this;
            String var5;
            if(Tracker.this.field_3173 != null) {
               var5 = Tracker.this.field_3173.method_3904(var1);
            } else {
               var5 = var1.getClass().getCanonicalName();
            }

            var4.set("&cd", var5);
            Tracker.this.send(var2);
            class_660.method_3794().method_3798(false);
         }

      }

      // $FF: renamed from: i (android.app.Activity) void
      public void method_191(Activity var1) {
         class_660.method_3794().method_3795(class_660.class_1313.field_3815);
         this.field_952 += -1;
         this.field_952 = Math.max(0, this.field_952);
         if(this.field_952 == 0) {
            this.field_955 = this.field_950.currentTimeMillis();
         }

      }

      public void setSessionTimeout(long var1) {
         this.field_953 = var1;
         this.method_1862();
      }
   }
}
