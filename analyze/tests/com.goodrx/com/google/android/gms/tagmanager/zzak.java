package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzak {
   private final Set<String> zzbiU;
   private final String zzbiV;

   public zzak(String var1, String... var2) {
      this.zzbiV = var1;
      this.zzbiU = new HashSet(var2.length);
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.zzbiU.add(var5);
      }

   }

   public abstract boolean zzFW();

   public String zzGB() {
      return this.zzbiV;
   }

   public Set<String> zzGC() {
      return this.zzbiU;
   }

   public abstract com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1);

   boolean zze(Set<String> var1) {
      return var1.containsAll(this.zzbiU);
   }
}
