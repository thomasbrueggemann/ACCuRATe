package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.flags.impl.zzb;
import com.google.android.gms.internal.zzpk;

public class FlagProviderImpl extends zzpk.zza {
   private boolean zzqA = false;
   private SharedPreferences zzvx;

   public boolean getBooleanFlagValue(String var1, boolean var2, int var3) {
      return zza.zza.zza(this.zzvx, var1, Boolean.valueOf(var2)).booleanValue();
   }

   public int getIntFlagValue(String var1, int var2, int var3) {
      return zza.zzb.zza(this.zzvx, var1, Integer.valueOf(var2)).intValue();
   }

   public long getLongFlagValue(String var1, long var2, int var4) {
      return zza.zzc.zza(this.zzvx, var1, Long.valueOf(var2)).longValue();
   }

   public String getStringFlagValue(String var1, String var2, int var3) {
      return zza.zzd.zza(this.zzvx, var1, var2);
   }

   public void init(zzd var1) {
      Context var2 = (Context)zze.zzp(var1);
      if(!this.zzqA) {
         try {
            this.zzvx = zzb.zzw(var2.createPackageContext("com.google.android.gms", 0));
            this.zzqA = true;
         } catch (NameNotFoundException var4) {
            ;
         }
      }
   }
}
