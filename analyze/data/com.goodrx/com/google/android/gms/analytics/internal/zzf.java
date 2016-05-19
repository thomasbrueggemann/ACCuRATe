package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzai;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzg;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.analytics.internal.zzv;
import com.google.android.gms.internal.zzmq;
import java.lang.Thread.UncaughtExceptionHandler;

public class zzf {
   private static zzf zzQn;
   private final Context mContext;
   private final zzu zzQA;
   private final Context zzQo;
   private final zzr zzQp;
   private final zzaf zzQq;
   private final com.google.android.gms.measurement.zzg zzQr;
   private final zzb zzQs;
   private final zzv zzQt;
   private final zzan zzQu;
   private final zzai zzQv;
   private final GoogleAnalytics zzQw;
   private final zzn zzQx;
   private final zza zzQy;
   private final zzk zzQz;
   private final zzmq zzqW;

   protected zzf(zzg var1) {
      Context var2 = var1.getApplicationContext();
      com.google.android.gms.common.internal.zzx.zzb(var2, "Application context can\'t be null");
      com.google.android.gms.common.internal.zzx.zzb(var2 instanceof Application, "getApplicationContext didn\'t return the application");
      Context var4 = var1.zzjx();
      com.google.android.gms.common.internal.zzx.zzz(var4);
      this.mContext = var2;
      this.zzQo = var4;
      this.zzqW = var1.zzh(this);
      this.zzQp = var1.zzg(this);
      zzaf var6 = var1.zzf(this);
      var6.zza();
      this.zzQq = var6;
      if(this.zzjn().zzkr()) {
         this.zzjm().zzbf("Google Analytics " + zze.VERSION + " is starting up.");
      } else {
         this.zzjm().zzbf("Google Analytics " + zze.VERSION + " is starting up. " + "To enable debug logging on a device run:\n" + "  adb shell setprop log.tag.GAv4 DEBUG\n" + "  adb logcat -s GAv4");
      }

      zzai var7 = var1.zzq(this);
      var7.zza();
      this.zzQv = var7;
      zzan var8 = var1.zze(this);
      var8.zza();
      this.zzQu = var8;
      zzb var9 = var1.zzl(this);
      zzn var10 = var1.zzd(this);
      zza var11 = var1.zzc(this);
      zzk var12 = var1.zzb(this);
      zzu var13 = var1.zza(this);
      com.google.android.gms.measurement.zzg var14 = var1.zzab(var2);
      var14.zza(this.zzjw());
      this.zzQr = var14;
      GoogleAnalytics var15 = var1.zzi(this);
      var10.zza();
      this.zzQx = var10;
      var11.zza();
      this.zzQy = var11;
      var12.zza();
      this.zzQz = var12;
      var13.zza();
      this.zzQA = var13;
      zzv var16 = var1.zzp(this);
      var16.zza();
      this.zzQt = var16;
      var9.zza();
      this.zzQs = var9;
      if(this.zzjn().zzkr()) {
         this.zzjm().zzb("Device AnalyticsService version", zze.VERSION);
      }

      var15.zza();
      this.zzQw = var15;
      var9.start();
   }

   private void zza(zzd var1) {
      com.google.android.gms.common.internal.zzx.zzb(var1, "Analytics service not created/initialized");
      com.google.android.gms.common.internal.zzx.zzb(var1.isInitialized(), "Analytics service not initialized");
   }

   public static zzf zzaa(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public Context getContext() {
      return this.mContext;
   }

   public zzb zziH() {
      this.zza(this.zzQs);
      return this.zzQs;
   }

   public zzan zziI() {
      this.zza(this.zzQu);
      return this.zzQu;
   }

   public zzai zzjA() {
      return this.zzQv != null && this.zzQv.isInitialized()?this.zzQv:null;
   }

   public zza zzjB() {
      this.zza(this.zzQy);
      return this.zzQy;
   }

   public zzn zzjC() {
      this.zza(this.zzQx);
      return this.zzQx;
   }

   public void zzjk() {
      com.google.android.gms.measurement.zzg.zzjk();
   }

   public zzmq zzjl() {
      return this.zzqW;
   }

   public zzaf zzjm() {
      this.zza(this.zzQq);
      return this.zzQq;
   }

   public zzr zzjn() {
      return this.zzQp;
   }

   public com.google.android.gms.measurement.zzg zzjo() {
      com.google.android.gms.common.internal.zzx.zzz(this.zzQr);
      return this.zzQr;
   }

   public zzv zzjp() {
      this.zza(this.zzQt);
      return this.zzQt;
   }

   public zzai zzjq() {
      this.zza(this.zzQv);
      return this.zzQv;
   }

   public zzk zzjt() {
      this.zza(this.zzQz);
      return this.zzQz;
   }

   public zzu zzju() {
      return this.zzQA;
   }

   protected UncaughtExceptionHandler zzjw() {
      return new UncaughtExceptionHandler() {
         public void uncaughtException(Thread var1, Throwable var2) {
            zzaf var3 = zzf.this.zzjy();
            if(var3 != null) {
               var3.zze("Job execution failed", var2);
            }

         }
      };
   }

   public Context zzjx() {
      return this.zzQo;
   }

   public zzaf zzjy() {
      return this.zzQq;
   }

   public GoogleAnalytics zzjz() {
      com.google.android.gms.common.internal.zzx.zzz(this.zzQw);
      com.google.android.gms.common.internal.zzx.zzb(this.zzQw.isInitialized(), "Analytics instance not initialized");
      return this.zzQw;
   }
}
