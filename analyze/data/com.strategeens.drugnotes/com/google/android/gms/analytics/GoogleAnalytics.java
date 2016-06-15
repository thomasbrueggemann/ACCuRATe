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
import com.google.android.gms.analytics.class_169;
import com.google.android.gms.analytics.class_838;
import com.google.android.gms.analytics.class_842;
import com.google.android.gms.analytics.class_843;
import com.google.android.gms.analytics.class_845;
import com.google.android.gms.analytics.class_847;
import com.google.android.gms.analytics.class_849;
import com.google.android.gms.analytics.class_852;
import com.google.android.gms.analytics.class_853;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_866;
import com.google.android.gms.analytics.class_868;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
   // $FF: renamed from: Bm boolean
   private static boolean field_1840;
   // $FF: renamed from: Bs com.google.android.gms.analytics.GoogleAnalytics
   private static GoogleAnalytics field_1841;
   // $FF: renamed from: Bn com.google.android.gms.analytics.aj
   private class_852 field_1842;
   // $FF: renamed from: Bo java.lang.Boolean
   private volatile Boolean field_1843;
   // $FF: renamed from: Bp com.google.android.gms.analytics.Logger
   private Logger field_1844;
   // $FF: renamed from: Bq java.util.Set
   private Set<GoogleAnalytics.class_1144> field_1845;
   // $FF: renamed from: Br boolean
   private boolean field_1846;
   private Context mContext;
   // $FF: renamed from: yV com.google.android.gms.analytics.f
   private class_169 field_1847;
   // $FF: renamed from: ya java.lang.String
   private String field_1848;
   // $FF: renamed from: yb java.lang.String
   private String field_1849;
   // $FF: renamed from: yt boolean
   private boolean field_1850;

   protected GoogleAnalytics(Context var1) {
      this(var1, class_847.method_4677(var1), class_853.method_4728());
   }

   private GoogleAnalytics(Context var1, class_169 var2, class_852 var3) {
      this.field_1843 = Boolean.valueOf(false);
      this.field_1846 = false;
      if(var1 == null) {
         throw new IllegalArgumentException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.field_1847 = var2;
         this.field_1842 = var3;
         class_838.method_4636(this.mContext);
         class_868.method_4875(this.mContext);
         class_843.method_4656(this.mContext);
         this.field_1844 = new class_845();
         this.field_1845 = new HashSet();
         this.method_3103();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.Tracker) com.google.android.gms.analytics.Tracker
   private Tracker method_3100(Tracker var1) {
      if(this.field_1848 != null) {
         var1.set("&an", this.field_1848);
      }

      if(this.field_1849 != null) {
         var1.set("&av", this.field_1849);
      }

      return var1;
   }

   // $FF: renamed from: ai (java.lang.String) int
   private int method_3101(String var1) {
      String var2 = var1.toLowerCase();
      return "verbose".equals(var2)?0:("info".equals(var2)?1:("warning".equals(var2)?2:("error".equals(var2)?3:-1)));
   }

   // $FF: renamed from: eY () com.google.android.gms.analytics.GoogleAnalytics
   static GoogleAnalytics method_3102() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eZ () void
   private void method_3103() {
      if(!field_1840) {
         ApplicationInfo var2;
         label24: {
            ApplicationInfo var6;
            try {
               var6 = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException var7) {
               class_863.method_4841("PackageManager doesn\'t know about package: " + var7);
               var2 = null;
               break label24;
            }

            var2 = var6;
         }

         if(var2 == null) {
            class_863.method_4842("Couldn\'t get ApplicationInfo to load gloabl config.");
            return;
         }

         Bundle var3 = var2.metaData;
         if(var3 != null) {
            int var4 = var3.getInt("com.google.android.gms.analytics.globalConfigResource");
            if(var4 > 0) {
               class_866 var5 = (class_866)(new class_842(this.mContext)).x(var4);
               if(var5 != null) {
                  this.method_3105(var5);
                  return;
               }
            }
         }
      }

   }

   public static GoogleAnalytics getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.GoogleAnalytics$a) void
   void method_3104(GoogleAnalytics.class_1144 var1) {
      this.field_1845.add(var1);
      if(this.mContext instanceof Application) {
         this.enableAutoActivityReports((Application)this.mContext);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.analytics.aa) void
   void method_3105(class_866 var1) {
      class_863.method_4841("Loading global config values.");
      if(var1.method_4852()) {
         this.field_1848 = var1.method_4853();
         class_863.method_4841("app name loaded: " + this.field_1848);
      }

      if(var1.method_4854()) {
         this.field_1849 = var1.method_4855();
         class_863.method_4841("app version loaded: " + this.field_1849);
      }

      if(var1.method_4856()) {
         int var2 = this.method_3101(var1.method_4857());
         if(var2 >= 0) {
            class_863.method_4841("log level loaded: " + var2);
            this.getLogger().setLogLevel(var2);
         }
      }

      if(var1.method_4858()) {
         this.field_1842.setLocalDispatchPeriod(var1.method_4859());
      }

      if(var1.method_4860()) {
         this.setDryRun(var1.method_4861());
      }

   }

   // $FF: renamed from: b (com.google.android.gms.analytics.GoogleAnalytics$a) void
   void method_3106(GoogleAnalytics.class_1144 var1) {
      this.field_1845.remove(var1);
   }

   // $FF: renamed from: dY () void
   void method_3107() {
      this.field_1847.method_848();
   }

   @Deprecated
   public void dispatchLocalHits() {
      this.field_1842.dispatchLocalHits();
   }

   public void enableAutoActivityReports(Application var1) {
      if(VERSION.SDK_INT >= 14 && !this.field_1846) {
         var1.registerActivityLifecycleCallbacks(new GoogleAnalytics.class_1145());
         this.field_1846 = true;
      }

   }

   // $FF: renamed from: g (android.app.Activity) void
   void method_3108(Activity var1) {
      Iterator var2 = this.field_1845.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.class_1144)var2.next()).method_193(var1);
      }

   }

   public boolean getAppOptOut() {
      class_849.method_4705().method_4707(class_849.class_1322.field_2992);
      return this.field_1843.booleanValue();
   }

   public Logger getLogger() {
      return this.field_1844;
   }

   // $FF: renamed from: h (android.app.Activity) void
   void method_3109(Activity var1) {
      Iterator var2 = this.field_1845.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.class_1144)var2.next()).method_194(var1);
      }

   }

   public boolean isDryRunEnabled() {
      class_849.method_4705().method_4707(class_849.class_1322.field_3004);
      return this.field_1850;
   }

   public Tracker newTracker(int param1) {
      // $FF: Couldn't be decompiled
   }

   public Tracker newTracker(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void reportActivityStart(Activity var1) {
      if(!this.field_1846) {
         this.method_3108(var1);
      }

   }

   public void reportActivityStop(Activity var1) {
      if(!this.field_1846) {
         this.method_3109(var1);
      }

   }

   public void setAppOptOut(boolean var1) {
      class_849.method_4705().method_4707(class_849.class_1322.field_2991);
      this.field_1843 = Boolean.valueOf(var1);
      if(this.field_1843.booleanValue()) {
         this.field_1847.method_845();
      }

   }

   public void setDryRun(boolean var1) {
      class_849.method_4705().method_4707(class_849.class_1322.field_3003);
      this.field_1850 = var1;
   }

   @Deprecated
   public void setLocalDispatchPeriod(int var1) {
      this.field_1842.setLocalDispatchPeriod(var1);
   }

   public void setLogger(Logger var1) {
      class_849.method_4705().method_4707(class_849.class_1322.field_3031);
      this.field_1844 = var1;
   }

   // $FF: renamed from: u (java.util.Map) void
   void method_3099(Map<String, String> param1) {
      // $FF: Couldn't be decompiled
   }

   interface class_1144 {
      // $FF: renamed from: i (android.app.Activity) void
      void method_193(Activity var1);

      // $FF: renamed from: j (android.app.Activity) void
      void method_194(Activity var1);
   }

   class class_1145 implements ActivityLifecycleCallbacks {
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
         GoogleAnalytics.this.method_3108(var1);
      }

      public void onActivityStopped(Activity var1) {
         GoogleAnalytics.this.method_3109(var1);
      }
   }
}
