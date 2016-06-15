package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.class_1055;
import com.google.android.gms.analytics.class_180;
import com.google.android.gms.analytics.class_838;
import com.google.android.gms.analytics.class_843;
import com.google.android.gms.analytics.class_849;
import com.google.android.gms.analytics.class_862;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_867;
import com.google.android.gms.analytics.class_868;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_720;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
   // $FF: renamed from: Ce com.google.android.gms.analytics.TrackerHandler
   private final TrackerHandler field_3133;
   // $FF: renamed from: Cf java.util.Map
   private final Map<String, String> field_3134;
   // $FF: renamed from: Cg com.google.android.gms.analytics.ah
   private class_180 field_3135;
   // $FF: renamed from: Ch com.google.android.gms.analytics.k
   private final class_843 field_3136;
   // $FF: renamed from: Ci com.google.android.gms.analytics.ai
   private final class_868 field_3137;
   // $FF: renamed from: Cj com.google.android.gms.analytics.g
   private final class_838 field_3138;
   // $FF: renamed from: Ck boolean
   private boolean field_3139;
   // $FF: renamed from: Cl com.google.android.gms.analytics.Tracker$a
   private Tracker.class_1095 field_3140;
   // $FF: renamed from: Cm com.google.android.gms.analytics.am
   private class_867 field_3141;
   // $FF: renamed from: Cn com.google.android.gms.analytics.ExceptionReporter
   private ExceptionReporter field_3142;
   private Context mContext;
   // $FF: renamed from: rd java.util.Map
   private final Map<String, String> field_3143;

   Tracker(String var1, TrackerHandler var2, Context var3) {
      this(var1, var2, class_843.method_4653(), class_868.method_4874(), class_838.method_4635(), new class_862("tracking"), var3);
   }

   Tracker(String var1, TrackerHandler var2, class_843 var3, class_868 var4, class_838 var5, class_180 var6, Context var7) {
      this.field_3143 = new HashMap();
      this.field_3134 = new HashMap();
      this.field_3133 = var2;
      if(var7 != null) {
         this.mContext = var7.getApplicationContext();
      }

      if(var1 != null) {
         this.field_3143.put("&tid", var1);
      }

      this.field_3143.put("useSecure", "1");
      this.field_3136 = var3;
      this.field_3137 = var4;
      this.field_3138 = var5;
      this.field_3143.put("&a", Integer.toString(1 + (new Random()).nextInt(Integer.MAX_VALUE)));
      this.field_3135 = var6;
      this.field_3140 = new Tracker.class_1095();
      this.enableAdvertisingIdCollection(false);
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.am) void
   void method_4098(class_867 var1) {
      class_863.method_4841("Loading Tracker config values.");
      this.field_3141 = var1;
      if(this.field_3141.method_4866()) {
         String var3 = this.field_3141.method_4867();
         this.set("&tid", var3);
         class_863.method_4841("[Tracker] trackingId loaded: " + var3);
      }

      if(this.field_3141.method_4868()) {
         String var2 = Double.toString(this.field_3141.method_4869());
         this.set("&sf", var2);
         class_863.method_4841("[Tracker] sample frequency loaded: " + var2);
      }

      if(this.field_3141.method_4870()) {
         this.setSessionTimeout((long)this.field_3141.getSessionTimeout());
         class_863.method_4841("[Tracker] session timeout loaded: " + this.method_4099());
      }

      if(this.field_3141.method_4871()) {
         this.enableAutoActivityTracking(this.field_3141.method_4872());
         class_863.method_4841("[Tracker] auto activity tracking loaded: " + this.method_4100());
      }

      if(this.field_3141.method_4863()) {
         if(this.field_3141.method_4864()) {
            this.set("&aip", "1");
            class_863.method_4841("[Tracker] anonymize ip loaded: true");
         }

         class_863.method_4841("[Tracker] anonymize ip loaded: false");
      }

      this.enableExceptionReporting(this.field_3141.method_4865());
   }

   public void enableAdvertisingIdCollection(boolean var1) {
      if(!var1) {
         this.field_3143.put("&ate", (Object)null);
         this.field_3143.put("&adid", (Object)null);
      } else {
         if(this.field_3143.containsKey("&ate")) {
            this.field_3143.remove("&ate");
         }

         if(this.field_3143.containsKey("&adid")) {
            this.field_3143.remove("&adid");
            return;
         }
      }

   }

   public void enableAutoActivityTracking(boolean var1) {
      this.field_3140.enableAutoActivityTracking(var1);
   }

   public void enableExceptionReporting(boolean var1) {
      if(this.field_3139 != var1) {
         this.field_3139 = var1;
         if(var1) {
            this.field_3142 = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
            Thread.setDefaultUncaughtExceptionHandler(this.field_3142);
            class_863.method_4841("Uncaught exceptions will be reported to Google Analytics.");
         } else {
            if(this.field_3142 != null) {
               Thread.setDefaultUncaughtExceptionHandler(this.field_3142.method_5301());
            } else {
               Thread.setDefaultUncaughtExceptionHandler((UncaughtExceptionHandler)null);
            }

            class_863.method_4841("Uncaught exceptions will not be reported to Google Analytics.");
         }
      }
   }

   // $FF: renamed from: fn () long
   long method_4099() {
      return this.field_3140.method_2274();
   }

   // $FF: renamed from: fo () boolean
   boolean method_4100() {
      return this.field_3140.method_2275();
   }

   public String get(String var1) {
      class_849.method_4705().method_4707(class_849.class_1322.field_3010);
      if(!TextUtils.isEmpty(var1)) {
         if(this.field_3143.containsKey(var1)) {
            return (String)this.field_3143.get(var1);
         }

         if(var1.equals("&ul")) {
            return class_1055.method_5793(Locale.getDefault());
         }

         if(this.field_3136 != null && this.field_3136.method_4657(var1)) {
            return this.field_3136.getValue(var1);
         }

         if(this.field_3137 != null && this.field_3137.method_4876(var1)) {
            return this.field_3137.getValue(var1);
         }

         if(this.field_3138 != null && this.field_3138.method_4637(var1)) {
            return this.field_3138.getValue(var1);
         }
      }

      return null;
   }

   public void send(Map<String, String> var1) {
      class_849.method_4705().method_4707(class_849.class_1322.field_3012);
      HashMap var2 = new HashMap();
      var2.putAll(this.field_3143);
      if(var1 != null) {
         var2.putAll(var1);
      }

      Iterator var3 = this.field_3134.keySet().iterator();

      while(var3.hasNext()) {
         String var9 = (String)var3.next();
         if(!var2.containsKey(var9)) {
            var2.put(var9, this.field_3134.get(var9));
         }
      }

      this.field_3134.clear();
      if(TextUtils.isEmpty((CharSequence)var2.get("&tid"))) {
         class_863.method_4842(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
      }

      String var4 = (String)var2.get("&t");
      if(TextUtils.isEmpty(var4)) {
         class_863.method_4842(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
         var4 = "";
      }

      if(this.field_3140.method_2276()) {
         var2.put("&sc", "start");
      }

      String var5 = var4.toLowerCase();
      if("screenview".equals(var5) || "pageview".equals(var5) || "appview".equals(var5) || TextUtils.isEmpty(var5)) {
         int var6 = 1 + Integer.parseInt((String)this.field_3143.get("&a"));
         if(var6 >= Integer.MAX_VALUE) {
            var6 = 1;
         }

         this.field_3143.put("&a", Integer.toString(var6));
      }

      if(!var5.equals("transaction") && !var5.equals("item") && !this.field_3135.method_895()) {
         class_863.method_4842("Too many hits sent too quickly, rate limiting invoked.");
      } else {
         this.field_3133.method_3099(var2);
      }
   }

   public void set(String var1, String var2) {
      class_335.method_2306(var1, "Key should be non-null");
      class_849.method_4705().method_4707(class_849.class_1322.field_3011);
      this.field_3143.put(var1, var2);
   }

   public void setAnonymizeIp(boolean var1) {
      this.set("&aip", class_1055.method_5791(var1));
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

   public void setCampaignParamsOnNextHit(Uri var1) {
      if(var1 != null) {
         String var2 = var1.getQueryParameter("referrer");
         if(!TextUtils.isEmpty(var2)) {
            Uri var3 = Uri.parse("http://hostname/?" + var2);
            String var4 = var3.getQueryParameter("utm_id");
            if(var4 != null) {
               this.field_3134.put("&ci", var4);
            }

            String var5 = var3.getQueryParameter("utm_campaign");
            if(var5 != null) {
               this.field_3134.put("&cn", var5);
            }

            String var6 = var3.getQueryParameter("utm_content");
            if(var6 != null) {
               this.field_3134.put("&cc", var6);
            }

            String var7 = var3.getQueryParameter("utm_medium");
            if(var7 != null) {
               this.field_3134.put("&cm", var7);
            }

            String var8 = var3.getQueryParameter("utm_source");
            if(var8 != null) {
               this.field_3134.put("&cs", var8);
            }

            String var9 = var3.getQueryParameter("utm_term");
            if(var9 != null) {
               this.field_3134.put("&ck", var9);
            }

            String var10 = var3.getQueryParameter("dclid");
            if(var10 != null) {
               this.field_3134.put("&dclid", var10);
            }

            String var11 = var3.getQueryParameter("gclid");
            if(var11 != null) {
               this.field_3134.put("&gclid", var11);
               return;
            }
         }
      }

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
         class_863.method_4842("Invalid width or height. The values should be non-negative.");
      } else {
         this.set("&sr", var1 + "x" + var2);
      }
   }

   public void setSessionTimeout(long var1) {
      this.field_3140.setSessionTimeout(1000L * var1);
   }

   public void setTitle(String var1) {
      this.set("&dt", var1);
   }

   public void setUseSecure(boolean var1) {
      this.set("useSecure", class_1055.method_5791(var1));
   }

   public void setViewportSize(String var1) {
      this.set("&vp", var1);
   }

   private class class_1095 implements GoogleAnalytics.class_1144 {
      // $FF: renamed from: Co boolean
      private boolean field_818 = false;
      // $FF: renamed from: Cp int
      private int field_819 = 0;
      // $FF: renamed from: Cq long
      private long field_820 = -1L;
      // $FF: renamed from: Cr boolean
      private boolean field_821 = false;
      // $FF: renamed from: Cs long
      private long field_822;
      // $FF: renamed from: wb com.google.android.gms.internal.ld
      private class_141 field_824 = class_720.method_4198();

      // $FF: renamed from: fq () void
      private void method_2273() {
         GoogleAnalytics var1 = GoogleAnalytics.method_3102();
         if(var1 == null) {
            class_863.method_4839("GoogleAnalytics isn\'t initialized for the Tracker!");
         } else if(this.field_820 < 0L && !this.field_818) {
            var1.method_3106(Tracker.this.field_3140);
         } else {
            var1.method_3104(Tracker.this.field_3140);
         }
      }

      public void enableAutoActivityTracking(boolean var1) {
         this.field_818 = var1;
         this.method_2273();
      }

      // $FF: renamed from: fn () long
      public long method_2274() {
         return this.field_820;
      }

      // $FF: renamed from: fo () boolean
      public boolean method_2275() {
         return this.field_818;
      }

      // $FF: renamed from: fp () boolean
      public boolean method_2276() {
         boolean var1 = this.field_821;
         this.field_821 = false;
         return var1;
      }

      // $FF: renamed from: fr () boolean
      boolean method_2277() {
         return this.field_824.elapsedRealtime() >= this.field_822 + Math.max(1000L, this.field_820);
      }

      // $FF: renamed from: i (android.app.Activity) void
      public void method_193(Activity var1) {
         class_849.method_4705().method_4707(class_849.class_1322.field_3035);
         if(this.field_819 == 0 && this.method_2277()) {
            this.field_821 = true;
         }

         ++this.field_819;
         if(this.field_818) {
            Intent var2 = var1.getIntent();
            if(var2 != null) {
               Tracker.this.setCampaignParamsOnNextHit(var2.getData());
            }

            HashMap var3 = new HashMap();
            var3.put("&t", "screenview");
            class_849.method_4705().method_4706(true);
            Tracker var5 = Tracker.this;
            String var6;
            if(Tracker.this.field_3141 != null) {
               var6 = Tracker.this.field_3141.method_4873(var1);
            } else {
               var6 = var1.getClass().getCanonicalName();
            }

            var5.set("&cd", var6);
            Tracker.this.send(var3);
            class_849.method_4705().method_4706(false);
         }

      }

      // $FF: renamed from: j (android.app.Activity) void
      public void method_194(Activity var1) {
         class_849.method_4705().method_4707(class_849.class_1322.field_3036);
         this.field_819 += -1;
         this.field_819 = Math.max(0, this.field_819);
         if(this.field_819 == 0) {
            this.field_822 = this.field_824.elapsedRealtime();
         }

      }

      public void setSessionTimeout(long var1) {
         this.field_820 = var1;
         this.method_2273();
      }
   }
}
