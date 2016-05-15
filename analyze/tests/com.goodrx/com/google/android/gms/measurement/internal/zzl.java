package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzlz;

public final class zzl {
   public static zzl.zza<Boolean> zzaVY = zzl.zza.zzm("measurement.service_enabled", true);
   public static zzl.zza<Boolean> zzaVZ = zzl.zza.zzm("measurement.service_client_enabled", true);
   public static zzl.zza<String> zzaWa = zzl.zza.zzl("measurement.log_tag", "GMPM", "GMPM-SVC");
   public static zzl.zza<Long> zzaWb = zzl.zza.zze("measurement.ad_id_cache_time", 10000L);
   public static zzl.zza<Long> zzaWc = zzl.zza.zze("measurement.monitoring.sample_period_millis", 86400000L);
   public static zzl.zza<Long> zzaWd = zzl.zza.zze("measurement.config.cache_time", 86400000L);
   public static zzl.zza<String> zzaWe = zzl.zza.zzN("measurement.config.url_scheme", "https");
   public static zzl.zza<String> zzaWf = zzl.zza.zzN("measurement.config.url_authority", "app-measurement.com");
   public static zzl.zza<Integer> zzaWg = zzl.zza.zzD("measurement.upload.max_bundles", 100);
   public static zzl.zza<Integer> zzaWh = zzl.zza.zzD("measurement.upload.max_batch_size", 65536);
   public static zzl.zza<Integer> zzaWi = zzl.zza.zzD("measurement.upload.max_bundle_size", 65536);
   public static zzl.zza<Integer> zzaWj = zzl.zza.zzD("measurement.upload.max_events_per_bundle", 1000);
   public static zzl.zza<Integer> zzaWk = zzl.zza.zzD("measurement.upload.max_events_per_day", 100000);
   public static zzl.zza<Integer> zzaWl = zzl.zza.zzD("measurement.upload.max_public_events_per_day", '썐');
   public static zzl.zza<Integer> zzaWm = zzl.zza.zzD("measurement.upload.max_conversions_per_day", 500);
   public static zzl.zza<Integer> zzaWn = zzl.zza.zzD("measurement.store.max_stored_events_per_app", 100000);
   public static zzl.zza<String> zzaWo = zzl.zza.zzN("measurement.upload.url", "https://app-measurement.com/a");
   public static zzl.zza<Long> zzaWp = zzl.zza.zze("measurement.upload.backoff_period", 43200000L);
   public static zzl.zza<Long> zzaWq = zzl.zza.zze("measurement.upload.window_interval", 3600000L);
   public static zzl.zza<Long> zzaWr = zzl.zza.zze("measurement.upload.interval", 3600000L);
   public static zzl.zza<Long> zzaWs = zzl.zza.zze("measurement.upload.stale_data_deletion_interval", 86400000L);
   public static zzl.zza<Long> zzaWt = zzl.zza.zze("measurement.upload.initial_upload_delay_time", 15000L);
   public static zzl.zza<Long> zzaWu = zzl.zza.zze("measurement.upload.retry_time", 1800000L);
   public static zzl.zza<Integer> zzaWv = zzl.zza.zzD("measurement.upload.retry_count", 6);
   public static zzl.zza<Long> zzaWw = zzl.zza.zze("measurement.upload.max_queue_time", 2419200000L);
   public static zzl.zza<Integer> zzaWx = zzl.zza.zzD("measurement.lifetimevalue.max_currency_tracked", 4);
   public static zzl.zza<Long> zzaWy = zzl.zza.zze("measurement.service_client.idle_disconnect_millis", 5000L);

   public static final class zza<V> {
      private final V zzSA;
      private final zzlz<V> zzSB;
      private V zzSC;
      private final String zzvs;

      private zza(String var1, zzlz<V> var2, V var3) {
         com.google.android.gms.common.internal.zzx.zzz(var2);
         this.zzSB = var2;
         this.zzSA = var3;
         this.zzvs = var1;
      }

      static zzl.zza<Integer> zzD(String var0, int var1) {
         return zzo(var0, var1, var1);
      }

      static zzl.zza<String> zzN(String var0, String var1) {
         return zzl(var0, var1, var1);
      }

      static zzl.zza<Long> zzb(String var0, long var1, long var3) {
         return new zzl.zza(var0, zzlz.zza(var0, Long.valueOf(var3)), Long.valueOf(var1));
      }

      static zzl.zza<Boolean> zzb(String var0, boolean var1, boolean var2) {
         return new zzl.zza(var0, zzlz.zzk(var0, var2), Boolean.valueOf(var1));
      }

      static zzl.zza<Long> zze(String var0, long var1) {
         return zzb(var0, var1, var1);
      }

      static zzl.zza<String> zzl(String var0, String var1, String var2) {
         return new zzl.zza(var0, zzlz.zzv(var0, var2), var1);
      }

      static zzl.zza<Boolean> zzm(String var0, boolean var1) {
         return zzb(var0, var1, var1);
      }

      static zzl.zza<Integer> zzo(String var0, int var1, int var2) {
         return new zzl.zza(var0, zzlz.zza(var0, Integer.valueOf(var2)), Integer.valueOf(var1));
      }

      public V get() {
         return this.zzSC != null?this.zzSC:(com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()?this.zzSB.zzpX():this.zzSA);
      }

      public V get(V var1) {
         if(this.zzSC != null) {
            var1 = this.zzSC;
         } else if(var1 == null) {
            if(com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()) {
               return this.zzSB.zzpX();
            }

            return this.zzSA;
         }

         return var1;
      }

      public String getKey() {
         return this.zzvs;
      }
   }
}
