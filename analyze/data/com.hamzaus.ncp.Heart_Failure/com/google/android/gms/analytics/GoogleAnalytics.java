package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.class_134;
import com.google.android.gms.analytics.class_642;
import com.google.android.gms.analytics.class_643;
import com.google.android.gms.analytics.class_646;
import com.google.android.gms.analytics.class_647;
import com.google.android.gms.analytics.class_649;
import com.google.android.gms.analytics.class_650;
import com.google.android.gms.analytics.class_655;
import com.google.android.gms.analytics.class_658;
import com.google.android.gms.analytics.class_660;
import com.google.android.gms.analytics.class_666;
import com.google.android.gms.analytics.class_669;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
   // $FF: renamed from: wj boolean
   private static boolean field_2142;
   // $FF: renamed from: wq com.google.android.gms.analytics.GoogleAnalytics
   private static GoogleAnalytics field_2143;
   private Context mContext;
   // $FF: renamed from: tA java.lang.String
   private String field_2144;
   // $FF: renamed from: tS com.google.android.gms.analytics.f
   private class_134 field_2145;
   // $FF: renamed from: tz java.lang.String
   private String field_2146;
   // $FF: renamed from: wk boolean
   private boolean field_2147;
   // $FF: renamed from: wl com.google.android.gms.analytics.af
   private class_649 field_2148;
   // $FF: renamed from: wm java.lang.Boolean
   private volatile Boolean field_2149;
   // $FF: renamed from: wn com.google.android.gms.analytics.Logger
   private Logger field_2150;
   // $FF: renamed from: wo java.util.Set
   private Set<GoogleAnalytics.class_844> field_2151;
   // $FF: renamed from: wp boolean
   private boolean field_2152;

   protected GoogleAnalytics(Context var1) {
      this(var1, class_658.method_3771(var1), class_650.method_3715());
   }

   private GoogleAnalytics(Context var1, class_134 var2, class_649 var3) {
      this.field_2149 = Boolean.valueOf(false);
      this.field_2152 = false;
      if(var1 == null) {
         throw new IllegalArgumentException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.field_2145 = var2;
         this.field_2148 = var3;
         class_642.method_3681(this.mContext);
         class_666.method_3868(this.mContext);
         class_643.method_3690(this.mContext);
         this.field_2150 = new class_647();
         this.field_2151 = new HashSet();
         this.method_2716();
      }
   }

   // $FF: renamed from: P (java.lang.String) int
   private int method_2711(String var1) {
      String var2 = var1.toLowerCase();
      return "verbose".equals(var2)?0:("info".equals(var2)?1:("warning".equals(var2)?2:("error".equals(var2)?3:-1)));
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.Tracker) com.google.android.gms.analytics.Tracker
   private Tracker method_2712(Tracker var1) {
      if(this.field_2146 != null) {
         var1.set("&an", this.field_2146);
      }

      if(this.field_2144 != null) {
         var1.set("&av", this.field_2144);
      }

      return var1;
   }

   // $FF: renamed from: dd () com.google.android.gms.analytics.GoogleAnalytics
   static GoogleAnalytics method_2715() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: de () void
   private void method_2716() {
      if(!field_2142) {
         ApplicationInfo var2;
         label24: {
            ApplicationInfo var6;
            try {
               var6 = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException var7) {
               class_669.method_3890("PackageManager doesn\'t know about package: " + var7);
               var2 = null;
               break label24;
            }

            var2 = var6;
         }

         if(var2 == null) {
            class_669.method_3891("Couldn\'t get ApplicationInfo to load gloabl config.");
            return;
         }

         Bundle var3 = var2.metaData;
         if(var3 != null) {
            int var4 = var3.getInt("com.google.android.gms.analytics.globalConfigResource");
            if(var4 > 0) {
               class_655 var5 = (class_655)(new class_646(this.mContext)).r(var4);
               if(var5 != null) {
                  this.method_2720(var5);
                  return;
               }
            }
         }
      }

   }

   // $FF: renamed from: f (android.app.Activity) void
   private void method_2717(Activity var1) {
      Iterator var2 = this.field_2151.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.class_844)var2.next()).method_190(var1);
      }

   }

   // $FF: renamed from: g (android.app.Activity) void
   private void method_2718(Activity var1) {
      Iterator var2 = this.field_2151.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.class_844)var2.next()).method_191(var1);
      }

   }

   public static GoogleAnalytics getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.GoogleAnalytics$a) void
   void method_2719(GoogleAnalytics.class_844 var1) {
      this.field_2151.add(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.w) void
   void method_2720(class_655 var1) {
      class_669.method_3890("Loading global config values.");
      if(var1.method_3744()) {
         this.field_2146 = var1.method_3745();
         class_669.method_3890("app name loaded: " + this.field_2146);
      }

      if(var1.method_3746()) {
         this.field_2144 = var1.method_3747();
         class_669.method_3890("app version loaded: " + this.field_2144);
      }

      if(var1.method_3748()) {
         int var2 = this.method_2711(var1.method_3749());
         if(var2 >= 0) {
            class_669.method_3890("log level loaded: " + var2);
            this.getLogger().setLogLevel(var2);
         }
      }

      if(var1.method_3750()) {
         this.field_2148.setLocalDispatchPeriod(var1.method_3751());
      }

      if(var1.method_3752()) {
         this.setDryRun(var1.method_3753());
      }

   }

   // $FF: renamed from: b (com.google.android.gms.analytics.GoogleAnalytics$a) void
   void method_2721(GoogleAnalytics.class_844 var1) {
      this.field_2151.remove(var1);
   }

   @Deprecated
   public void dispatchLocalHits() {
      this.field_2148.dispatchLocalHits();
   }

   public void enableAutoActivityReports(Application var1) {
      if(VERSION.SDK_INT >= 14 && !this.field_2152) {
         var1.registerActivityLifecycleCallbacks(new GoogleAnalytics.class_845());
         this.field_2152 = true;
      }

   }

   public boolean getAppOptOut() {
      class_660.method_3794().method_3795(class_660.class_1313.field_3771);
      return this.field_2149.booleanValue();
   }

   public Logger getLogger() {
      return this.field_2150;
   }

   public boolean isDryRunEnabled() {
      class_660.method_3794().method_3795(class_660.class_1313.field_3783);
      return this.field_2147;
   }

   public Tracker newTracker(int param1) {
      // $FF: Couldn't be decompiled
   }

   public Tracker newTracker(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: p (java.util.Map) void
   void method_2710(Map<String, String> param1) {
      // $FF: Couldn't be decompiled
   }

   public void reportActivityStart(Activity var1) {
      if(!this.field_2152) {
         this.method_2717(var1);
      }

   }

   public void reportActivityStop(Activity var1) {
      if(!this.field_2152) {
         this.method_2718(var1);
      }

   }

   public void setAppOptOut(boolean var1) {
      class_660.method_3794().method_3795(class_660.class_1313.field_3770);
      this.field_2149 = Boolean.valueOf(var1);
      if(this.field_2149.booleanValue()) {
         this.field_2145.method_699();
      }

   }

   public void setDryRun(boolean var1) {
      class_660.method_3794().method_3795(class_660.class_1313.field_3782);
      this.field_2147 = var1;
   }

   @Deprecated
   public void setLocalDispatchPeriod(int var1) {
      this.field_2148.setLocalDispatchPeriod(var1);
   }

   public void setLogger(Logger var1) {
      class_660.method_3794().method_3795(class_660.class_1313.field_3784);
      this.field_2150 = var1;
   }

   interface class_844 {
      // $FF: renamed from: h (android.app.Activity) void
      void method_190(Activity var1);

      // $FF: renamed from: i (android.app.Activity) void
      void method_191(Activity var1);
   }

   class class_845 implements ActivityLifecycleCallbacks {
      public void onActivityCreated(Activity var1, Bundle var2) {
      }

      public void onActivityDestroyed(Activity var1) {
      }

      public void onActivityPaused(Activity var1) {
      }

      public void onActivityResumed(Activity var1) {
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      }

      public void onActivityStarted(Activity var1) {
         GoogleAnalytics.this.method_2717(var1);
      }

      public void onActivityStopped(Activity var1) {
         GoogleAnalytics.this.method_2718(var1);
      }
   }
}
