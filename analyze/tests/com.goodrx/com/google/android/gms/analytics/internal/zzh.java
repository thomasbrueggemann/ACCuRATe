package com.google.android.gms.analytics.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh {
   private final String zzPO;
   private final long zzQD;
   private final String zzQE;
   private final boolean zzQF;
   private long zzQG;
   private final Map<String, String> zzxA;

   public zzh(long var1, String var3, String var4, boolean var5, long var6, Map<String, String> var8) {
      com.google.android.gms.common.internal.zzx.zzcM(var3);
      com.google.android.gms.common.internal.zzx.zzcM(var4);
      this.zzQD = var1;
      this.zzPO = var3;
      this.zzQE = var4;
      this.zzQF = var5;
      this.zzQG = var6;
      if(var8 != null) {
         this.zzxA = new HashMap(var8);
      } else {
         this.zzxA = Collections.emptyMap();
      }
   }

   public String getClientId() {
      return this.zzPO;
   }

   public long zzjD() {
      return this.zzQD;
   }

   public String zzjE() {
      return this.zzQE;
   }

   public boolean zzjF() {
      return this.zzQF;
   }

   public long zzjG() {
      return this.zzQG;
   }

   public Map<String, String> zzn() {
      return this.zzxA;
   }

   public void zzn(long var1) {
      this.zzQG = var1;
   }
}
