package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
   private static List<Runnable> zzPe = new ArrayList();
   private boolean zzPf;
   private Set<GoogleAnalytics.zza> zzPg = new HashSet();
   private boolean zzPh;
   private boolean zzPi;
   private volatile boolean zzPj;
   private boolean zzPk;
   private boolean zzqA;

   public GoogleAnalytics(zzf var1) {
      super(var1);
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public static GoogleAnalytics getInstance(Context var0) {
      return zzf.zzaa(var0).zzjz();
   }

   public static void zziF() {
      // $FF: Couldn't be decompiled
   }

   private com.google.android.gms.analytics.internal.zzb zziH() {
      return this.zzix().zziH();
   }

   private zzan zziI() {
      return this.zzix().zziI();
   }

   public void dispatchLocalHits() {
      this.zziH().zzjd();
   }

   @TargetApi(14)
   public void enableAutoActivityReports(Application var1) {
      if(VERSION.SDK_INT >= 14 && !this.zzPh) {
         var1.registerActivityLifecycleCallbacks(new GoogleAnalytics.zzb());
         this.zzPh = true;
      }

   }

   public boolean getAppOptOut() {
      return this.zzPj;
   }

   public String getClientId() {
      zzx.zzcE("getClientId can not be called from the main thread");
      return this.zzix().zzjC().zzkk();
   }

   @Deprecated
   public Logger getLogger() {
      return zzae.getLogger();
   }

   public boolean isDryRunEnabled() {
      return this.zzPi;
   }

   public boolean isInitialized() {
      return this.zzqA && !this.zzPf;
   }

   public Tracker newTracker(int param1) {
      // $FF: Couldn't be decompiled
   }

   public Tracker newTracker(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void setDryRun(boolean var1) {
      this.zzPi = var1;
   }

   @Deprecated
   public void setLogger(Logger var1) {
      zzae.setLogger(var1);
      if(!this.zzPk) {
         Log.i((String)zzy.zzRL.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + (String)zzy.zzRL.get() + " DEBUG");
         this.zzPk = true;
      }

   }

   public void zza() {
      this.zziE();
      this.zzqA = true;
   }

   void zza(GoogleAnalytics.zza var1) {
      this.zzPg.add(var1);
      Context var3 = this.zzix().getContext();
      if(var3 instanceof Application) {
         this.enableAutoActivityReports((Application)var3);
      }

   }

   void zzb(GoogleAnalytics.zza var1) {
      this.zzPg.remove(var1);
   }

   void zziE() {
      zzan var1 = this.zziI();
      if(var1.zzlj()) {
         this.getLogger().setLogLevel(var1.getLogLevel());
      }

      if(var1.zzln()) {
         this.setDryRun(var1.zzlo());
      }

      if(var1.zzlj()) {
         Logger var2 = zzae.getLogger();
         if(var2 != null) {
            var2.setLogLevel(var1.getLogLevel());
         }
      }

   }

   void zziG() {
      this.zziH().zzje();
   }

   void zzj(Activity var1) {
      Iterator var2 = this.zzPg.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.zza)var2.next()).zzl(var1);
      }

   }

   void zzk(Activity var1) {
      Iterator var2 = this.zzPg.iterator();

      while(var2.hasNext()) {
         ((GoogleAnalytics.zza)var2.next()).zzm(var1);
      }

   }

   interface zza {
      void zzl(Activity var1);

      void zzm(Activity var1);
   }

   @TargetApi(14)
   class zzb implements ActivityLifecycleCallbacks {
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
         GoogleAnalytics.this.zzj(var1);
      }

      public void onActivityStopped(Activity var1) {
         GoogleAnalytics.this.zzk(var1);
      }
   }
}
