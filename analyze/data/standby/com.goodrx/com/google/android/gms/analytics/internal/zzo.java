package com.google.android.gms.analytics.internal;

public enum zzo {
   zzRu,
   zzRv;

   static {
      zzo[] var0 = new zzo[]{zzRu, zzRv};
   }

   public static zzo zzbn(String var0) {
      return "GZIP".equalsIgnoreCase(var0)?zzRv:zzRu;
   }
}
