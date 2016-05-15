package com.google.android.gms.analytics.internal;

public enum zzm {
   zzRk,
   zzRl,
   zzRm,
   zzRn,
   zzRo,
   zzRp;

   static {
      zzm[] var0 = new zzm[]{zzRk, zzRl, zzRm, zzRn, zzRo, zzRp};
   }

   public static zzm zzbm(String var0) {
      return "BATCH_BY_SESSION".equalsIgnoreCase(var0)?zzRl:("BATCH_BY_TIME".equalsIgnoreCase(var0)?zzRm:("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(var0)?zzRn:("BATCH_BY_COUNT".equalsIgnoreCase(var0)?zzRo:("BATCH_BY_SIZE".equalsIgnoreCase(var0)?zzRp:zzRk))));
   }
}
