package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class zzt extends zzz {
   static final Pair<String, Long> zzaXh = new Pair("", Long.valueOf(0L));
   private SharedPreferences zzTh;
   public final zzt.zzc zzaXi = new zzt.zzc("health_monitor", this.zzCp().zzkX());
   public final zzt.zzb zzaXj = new zzt.zzb("last_upload", 0L);
   public final zzt.zzb zzaXk = new zzt.zzb("last_upload_attempt", 0L);
   public final zzt.zzb zzaXl = new zzt.zzb("backoff", 0L);
   public final zzt.zzb zzaXm = new zzt.zzb("last_delete_stale", 0L);
   public final zzt.zzb zzaXn = new zzt.zzb("midnight_offset", 0L);
   private String zzaXo;
   private boolean zzaXp;
   private long zzaXq;
   private final SecureRandom zzaXr = new SecureRandom();
   public final zzt.zzb zzaXs = new zzt.zzb("time_before_start", 10000L);
   public final zzt.zzb zzaXt = new zzt.zzb("session_timeout", 1800000L);
   public final zzt.zza zzaXu = new zzt.zza("start_new_session", true);
   public final zzt.zzb zzaXv = new zzt.zzb("last_pause_time", 0L);
   public final zzt.zzb zzaXw = new zzt.zzb("time_active", 0L);
   public boolean zzaXx;

   zzt(zzw var1) {
      super(var1);
   }

   @WorkerThread
   private SharedPreferences zzCO() {
      this.zzjk();
      this.zzjv();
      return this.zzTh;
   }

   @WorkerThread
   void setMeasurementEnabled(boolean var1) {
      this.zzjk();
      this.zzAo().zzCK().zzj("Setting measurementEnabled", Boolean.valueOf(var1));
      Editor var2 = this.zzCO().edit();
      var2.putBoolean("measurement_enabled", var1);
      var2.apply();
   }

   @WorkerThread
   boolean zzAr() {
      this.zzjk();
      SharedPreferences var1 = this.zzCO();
      boolean var2;
      if(!com.google.android.gms.measurement.zza.zzAs()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var1.getBoolean("measurement_enabled", var2);
   }

   String zzCM() {
      byte[] var1 = new byte[16];
      this.zzaXr.nextBytes(var1);
      Locale var2 = Locale.US;
      Object[] var3 = new Object[]{new BigInteger(1, var1)};
      return String.format(var2, "%032x", var3);
   }

   @WorkerThread
   long zzCN() {
      this.zzjv();
      this.zzjk();
      long var1 = this.zzaXn.get();
      if(var1 == 0L) {
         var1 = (long)(1 + this.zzaXr.nextInt(86400000));
         this.zzaXn.set(var1);
      }

      return var1;
   }

   @WorkerThread
   Boolean zzCP() {
      this.zzjk();
      return !this.zzCO().contains("use_service")?null:Boolean.valueOf(this.zzCO().getBoolean("use_service", false));
   }

   @WorkerThread
   protected String zzCQ() {
      this.zzjk();
      String var1 = this.zzCO().getString("previous_os_version", (String)null);
      String var2 = this.zzCh().zzCy();
      if(!TextUtils.isEmpty(var2) && !var2.equals(var1)) {
         Editor var3 = this.zzCO().edit();
         var3.putString("previous_os_version", var2);
         var3.apply();
      }

      return var1;
   }

   @WorkerThread
   void zzar(boolean var1) {
      this.zzjk();
      this.zzAo().zzCK().zzj("Setting useService", Boolean.valueOf(var1));
      Editor var2 = this.zzCO().edit();
      var2.putBoolean("use_service", var1);
      var2.apply();
   }

   @WorkerThread
   Pair<String, Boolean> zzfh(String var1) {
      this.zzjk();
      long var2 = this.zzjl().elapsedRealtime();
      if(this.zzaXo != null && var2 < this.zzaXq) {
         return new Pair(this.zzaXo, Boolean.valueOf(this.zzaXp));
      } else {
         this.zzaXq = var2 + this.zzCp().zzeS(var1);
         AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);

         try {
            AdvertisingIdClient.Info var5 = AdvertisingIdClient.getAdvertisingIdInfo(this.getContext());
            this.zzaXo = var5.getId();
            this.zzaXp = var5.isLimitAdTrackingEnabled();
         } catch (Throwable var6) {
            this.zzAo().zzCJ().zzj("Unable to get advertising id", var6);
            this.zzaXo = "";
         }

         AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
         return new Pair(this.zzaXo, Boolean.valueOf(this.zzaXp));
      }
   }

   String zzfi(String var1) {
      String var2 = (String)this.zzfh(var1).first;
      MessageDigest var3 = zzaj.zzbv("MD5");
      if(var3 == null) {
         return null;
      } else {
         Locale var4 = Locale.US;
         Object[] var5 = new Object[]{new BigInteger(1, var3.digest(var2.getBytes()))};
         return String.format(var4, "%032X", var5);
      }
   }

   protected void zziJ() {
      this.zzTh = this.getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
      this.zzaXx = this.zzTh.getBoolean("has_been_opened", false);
      if(!this.zzaXx) {
         Editor var1 = this.zzTh.edit();
         var1.putBoolean("has_been_opened", true);
         var1.apply();
      }

   }

   public final class zza {
      private final boolean zzaXy;
      private boolean zzaXz;
      private boolean zzagf;
      private final String zzvs;

      public zza(String var2, boolean var3) {
         com.google.android.gms.common.internal.zzx.zzcM(var2);
         this.zzvs = var2;
         this.zzaXy = var3;
      }

      @WorkerThread
      private void zzCR() {
         if(!this.zzaXz) {
            this.zzaXz = true;
            this.zzagf = zzt.this.zzTh.getBoolean(this.zzvs, this.zzaXy);
         }
      }

      @WorkerThread
      public boolean get() {
         this.zzCR();
         return this.zzagf;
      }

      @WorkerThread
      public void set(boolean var1) {
         Editor var2 = zzt.this.zzTh.edit();
         var2.putBoolean(this.zzvs, var1);
         var2.apply();
         this.zzagf = var1;
      }
   }

   public final class zzb {
      private long zzaDV;
      private final long zzaXB;
      private boolean zzaXz;
      private final String zzvs;

      public zzb(String var2, long var3) {
         com.google.android.gms.common.internal.zzx.zzcM(var2);
         this.zzvs = var2;
         this.zzaXB = var3;
      }

      @WorkerThread
      private void zzCR() {
         if(!this.zzaXz) {
            this.zzaXz = true;
            this.zzaDV = zzt.this.zzTh.getLong(this.zzvs, this.zzaXB);
         }
      }

      @WorkerThread
      public long get() {
         this.zzCR();
         return this.zzaDV;
      }

      @WorkerThread
      public void set(long var1) {
         Editor var3 = zzt.this.zzTh.edit();
         var3.putLong(this.zzvs, var1);
         var3.apply();
         this.zzaDV = var1;
      }
   }

   public final class zzc {
      private final long zzTl;
      final String zzaXC;
      private final String zzaXD;
      private final String zzaXE;

      private zzc(String var2, long var3) {
         com.google.android.gms.common.internal.zzx.zzcM(var2);
         boolean var6;
         if(var3 > 0L) {
            var6 = true;
         } else {
            var6 = false;
         }

         com.google.android.gms.common.internal.zzx.zzac(var6);
         this.zzaXC = var2 + ":start";
         this.zzaXD = var2 + ":count";
         this.zzaXE = var2 + ":value";
         this.zzTl = var3;
      }

      // $FF: synthetic method
      zzc(String var2, long var3, Object var5) {
         this();
      }

      @WorkerThread
      private void zzlL() {
         zzt.this.zzjk();
         long var1 = zzt.this.zzjl().currentTimeMillis();
         Editor var3 = zzt.this.zzTh.edit();
         var3.remove(this.zzaXD);
         var3.remove(this.zzaXE);
         var3.putLong(this.zzaXC, var1);
         var3.apply();
      }

      @WorkerThread
      private long zzlM() {
         zzt.this.zzjk();
         long var1 = this.zzlO();
         if(var1 == 0L) {
            this.zzlL();
            return 0L;
         } else {
            return Math.abs(var1 - zzt.this.zzjl().currentTimeMillis());
         }
      }

      @WorkerThread
      private long zzlO() {
         return zzt.this.zzCO().getLong(this.zzaXC, 0L);
      }

      @WorkerThread
      public void zzbq(String var1) {
         this.zzf(var1, 1L);
      }

      @WorkerThread
      public void zzf(String var1, long var2) {
         zzt.this.zzjk();
         if(this.zzlO() == 0L) {
            this.zzlL();
         }

         if(var1 == null) {
            var1 = "";
         }

         long var4 = zzt.this.zzTh.getLong(this.zzaXD, 0L);
         if(var4 <= 0L) {
            Editor var10 = zzt.this.zzTh.edit();
            var10.putString(this.zzaXE, var1);
            var10.putLong(this.zzaXD, var2);
            var10.apply();
         } else {
            boolean var6;
            if((Long.MAX_VALUE & zzt.this.zzaXr.nextLong()) < var2 * (Long.MAX_VALUE / (var4 + var2))) {
               var6 = true;
            } else {
               var6 = false;
            }

            Editor var7 = zzt.this.zzTh.edit();
            if(var6) {
               var7.putString(this.zzaXE, var1);
            }

            var7.putLong(this.zzaXD, var4 + var2);
            var7.apply();
         }
      }

      @WorkerThread
      public Pair<String, Long> zzlN() {
         zzt.this.zzjk();
         long var1 = this.zzlM();
         if(var1 < this.zzTl) {
            return null;
         } else if(var1 > 2L * this.zzTl) {
            this.zzlL();
            return null;
         } else {
            String var3 = zzt.this.zzCO().getString(this.zzaXE, (String)null);
            long var4 = zzt.this.zzCO().getLong(this.zzaXD, 0L);
            this.zzlL();
            return var3 != null && var4 > 0L?new Pair(var3, Long.valueOf(var4)):zzt.zzaXh;
         }
      }
   }
}
