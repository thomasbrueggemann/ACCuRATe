package com.google.android.gms.common.stats;

import android.support.v4.util.SimpleArrayMap;

public class zze {
   private final long zzanN;
   private final int zzanO;
   private final SimpleArrayMap<String, Long> zzanP;

   public zze() {
      this.zzanN = 60000L;
      this.zzanO = 10;
      this.zzanP = new SimpleArrayMap(10);
   }

   public zze(int var1, long var2) {
      this.zzanN = var2;
      this.zzanO = var1;
      this.zzanP = new SimpleArrayMap();
   }

   private void zzb(long var1, long var3) {
      for(int var5 = -1 + this.zzanP.size(); var5 >= 0; --var5) {
         if(var3 - ((Long)this.zzanP.valueAt(var5)).longValue() > var1) {
            this.zzanP.removeAt(var5);
         }
      }

   }

   public Long zzcS(String param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean zzcT(String param1) {
      // $FF: Couldn't be decompiled
   }
}
