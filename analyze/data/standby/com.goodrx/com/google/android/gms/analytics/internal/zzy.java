package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzm;
import com.google.android.gms.analytics.internal.zzo;
import com.google.android.gms.internal.zzlz;

public final class zzy {
   public static zzy.zza<Boolean> zzRJ = zzy.zza.zzg("analytics.service_enabled", false);
   public static zzy.zza<Boolean> zzRK = zzy.zza.zzg("analytics.service_client_enabled", true);
   public static zzy.zza<String> zzRL = zzy.zza.zze("analytics.log_tag", "GAv4", "GAv4-SVC");
   public static zzy.zza<Long> zzRM = zzy.zza.zzb("analytics.max_tokens", 60L);
   public static zzy.zza<Float> zzRN = zzy.zza.zza("analytics.tokens_per_sec", 0.5F);
   public static zzy.zza<Integer> zzRO = zzy.zza.zza("analytics.max_stored_hits", 2000, 20000);
   public static zzy.zza<Integer> zzRP = zzy.zza.zzd("analytics.max_stored_hits_per_app", 2000);
   public static zzy.zza<Integer> zzRQ = zzy.zza.zzd("analytics.max_stored_properties_per_app", 100);
   public static zzy.zza<Long> zzRR = zzy.zza.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
   public static zzy.zza<Long> zzRS = zzy.zza.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
   public static zzy.zza<Long> zzRT = zzy.zza.zzb("analytics.min_local_dispatch_millis", 120000L);
   public static zzy.zza<Long> zzRU = zzy.zza.zzb("analytics.max_local_dispatch_millis", 7200000L);
   public static zzy.zza<Long> zzRV = zzy.zza.zzb("analytics.dispatch_alarm_millis", 7200000L);
   public static zzy.zza<Long> zzRW = zzy.zza.zzb("analytics.max_dispatch_alarm_millis", 32400000L);
   public static zzy.zza<Integer> zzRX = zzy.zza.zzd("analytics.max_hits_per_dispatch", 20);
   public static zzy.zza<Integer> zzRY = zzy.zza.zzd("analytics.max_hits_per_batch", 20);
   public static zzy.zza<String> zzRZ = zzy.zza.zzl("analytics.insecure_host", "http://www.google-analytics.com");
   public static zzy.zza<String> zzSa = zzy.zza.zzl("analytics.secure_host", "https://ssl.google-analytics.com");
   public static zzy.zza<String> zzSb = zzy.zza.zzl("analytics.simple_endpoint", "/collect");
   public static zzy.zza<String> zzSc = zzy.zza.zzl("analytics.batching_endpoint", "/batch");
   public static zzy.zza<Integer> zzSd = zzy.zza.zzd("analytics.max_get_length", 2036);
   public static zzy.zza<String> zzSe;
   public static zzy.zza<String> zzSf;
   public static zzy.zza<Integer> zzSg;
   public static zzy.zza<Integer> zzSh;
   public static zzy.zza<Integer> zzSi;
   public static zzy.zza<Integer> zzSj;
   public static zzy.zza<String> zzSk;
   public static zzy.zza<Integer> zzSl;
   public static zzy.zza<Long> zzSm;
   public static zzy.zza<Integer> zzSn;
   public static zzy.zza<Integer> zzSo;
   public static zzy.zza<Long> zzSp;
   public static zzy.zza<String> zzSq;
   public static zzy.zza<Integer> zzSr;
   public static zzy.zza<Boolean> zzSs;
   public static zzy.zza<Long> zzSt;
   public static zzy.zza<Long> zzSu;
   public static zzy.zza<Long> zzSv;
   public static zzy.zza<Long> zzSw;
   public static zzy.zza<Long> zzSx;
   public static zzy.zza<Long> zzSy;
   public static zzy.zza<Long> zzSz;

   static {
      zzSe = zzy.zza.zze("analytics.batching_strategy.k", zzm.zzRo.name(), zzm.zzRo.name());
      zzSf = zzy.zza.zzl("analytics.compression_strategy.k", zzo.zzRv.name());
      zzSg = zzy.zza.zzd("analytics.max_hits_per_request.k", 20);
      zzSh = zzy.zza.zzd("analytics.max_hit_length.k", 8192);
      zzSi = zzy.zza.zzd("analytics.max_post_length.k", 8192);
      zzSj = zzy.zza.zzd("analytics.max_batch_post_length", 8192);
      zzSk = zzy.zza.zzl("analytics.fallback_responses.k", "404,502");
      zzSl = zzy.zza.zzd("analytics.batch_retry_interval.seconds.k", 3600);
      zzSm = zzy.zza.zzb("analytics.service_monitor_interval", 86400000L);
      zzSn = zzy.zza.zzd("analytics.http_connection.connect_timeout_millis", '\uea60');
      zzSo = zzy.zza.zzd("analytics.http_connection.read_timeout_millis", '\uee48');
      zzSp = zzy.zza.zzb("analytics.campaigns.time_limit", 86400000L);
      zzSq = zzy.zza.zzl("analytics.first_party_experiment_id", "");
      zzSr = zzy.zza.zzd("analytics.first_party_experiment_variant", 0);
      zzSs = zzy.zza.zzg("analytics.test.disable_receiver", false);
      zzSt = zzy.zza.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
      zzSu = zzy.zza.zzb("analytics.service_client.connect_timeout_millis", 5000L);
      zzSv = zzy.zza.zzb("analytics.service_client.second_connect_delay_millis", 5000L);
      zzSw = zzy.zza.zzb("analytics.service_client.unexpected_reconnect_millis", 60000L);
      zzSx = zzy.zza.zzb("analytics.service_client.reconnect_throttle_millis", 1800000L);
      zzSy = zzy.zza.zzb("analytics.monitoring.sample_period_millis", 86400000L);
      zzSz = zzy.zza.zzb("analytics.initialization_warning_threshold", 5000L);
   }

   public static final class zza<V> {
      private final V zzSA;
      private final zzlz<V> zzSB;
      private V zzSC;

      private zza(zzlz<V> var1, V var2) {
         com.google.android.gms.common.internal.zzx.zzz(var1);
         this.zzSB = var1;
         this.zzSA = var2;
      }

      static zzy.zza<Float> zza(String var0, float var1) {
         return zza(var0, var1, var1);
      }

      static zzy.zza<Float> zza(String var0, float var1, float var2) {
         return new zzy.zza(zzlz.zza(var0, Float.valueOf(var2)), Float.valueOf(var1));
      }

      static zzy.zza<Integer> zza(String var0, int var1, int var2) {
         return new zzy.zza(zzlz.zza(var0, Integer.valueOf(var2)), Integer.valueOf(var1));
      }

      static zzy.zza<Long> zza(String var0, long var1, long var3) {
         return new zzy.zza(zzlz.zza(var0, Long.valueOf(var3)), Long.valueOf(var1));
      }

      static zzy.zza<Boolean> zza(String var0, boolean var1, boolean var2) {
         return new zzy.zza(zzlz.zzk(var0, var2), Boolean.valueOf(var1));
      }

      static zzy.zza<Long> zzb(String var0, long var1) {
         return zza(var0, var1, var1);
      }

      static zzy.zza<Integer> zzd(String var0, int var1) {
         return zza(var0, var1, var1);
      }

      static zzy.zza<String> zze(String var0, String var1, String var2) {
         return new zzy.zza(zzlz.zzv(var0, var2), var1);
      }

      static zzy.zza<Boolean> zzg(String var0, boolean var1) {
         return zza(var0, var1, var1);
      }

      static zzy.zza<String> zzl(String var0, String var1) {
         return zze(var0, var1, var1);
      }

      public V get() {
         return this.zzSC != null?this.zzSC:(com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()?this.zzSB.zzpX():this.zzSA);
      }
   }
}
