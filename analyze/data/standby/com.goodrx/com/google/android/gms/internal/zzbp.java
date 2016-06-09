package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzhb;

@zzhb
public abstract class zzbp<T> {
   private final int zzvr;
   private final String zzvs;
   private final T zzvt;

   private zzbp(int var1, String var2, T var3) {
      this.zzvr = var1;
      this.zzvs = var2;
      this.zzvt = var3;
      com.google.android.gms.ads.internal.zzr.zzbK().zza(this);
   }

   // $FF: synthetic method
   zzbp(int var1, String var2, Object var3, Object var4) {
      this(var1, var2, var3);
   }

   public static zzbp<String> zza(int var0, String var1) {
      zzbp var2 = zza(var0, var1, (String)null);
      com.google.android.gms.ads.internal.zzr.zzbK().zzb(var2);
      return var2;
   }

   public static zzbp<Integer> zza(final int var0, final String var1, int var2) {
      return new zzbp(var0, var1, Integer.valueOf(var2), null) {
         // $FF: synthetic method
         public Object zza(SharedPreferences var1) {
            return this.zzc(var1);
         }

         public Integer zzc(SharedPreferences var1) {
            return Integer.valueOf(var1.getInt(this.getKey(), ((Integer)this.zzdq()).intValue()));
         }
      };
   }

   public static zzbp<Long> zza(final int var0, final String var1, long var2) {
      return new zzbp(var0, var1, Long.valueOf(var2), null) {
         // $FF: synthetic method
         public Object zza(SharedPreferences var1) {
            return this.zzd(var1);
         }

         public Long zzd(SharedPreferences var1) {
            return Long.valueOf(var1.getLong(this.getKey(), ((Long)this.zzdq()).longValue()));
         }
      };
   }

   public static zzbp<Boolean> zza(final int var0, final String var1, final Boolean var2) {
      return new zzbp(var0, var1, var2, null) {
         // $FF: synthetic method
         public Object zza(SharedPreferences var1) {
            return this.zzb(var1);
         }

         public Boolean zzb(SharedPreferences var1) {
            return Boolean.valueOf(var1.getBoolean(this.getKey(), ((Boolean)this.zzdq()).booleanValue()));
         }
      };
   }

   public static zzbp<String> zza(final int var0, final String var1, final String var2) {
      return new zzbp(var0, var1, var2, null) {
         // $FF: synthetic method
         public Object zza(SharedPreferences var1) {
            return this.zze(var1);
         }

         public String zze(SharedPreferences var1) {
            return var1.getString(this.getKey(), (String)this.zzdq());
         }
      };
   }

   public static zzbp<String> zzb(int var0, String var1) {
      zzbp var2 = zza(var0, var1, (String)null);
      com.google.android.gms.ads.internal.zzr.zzbK().zzc(var2);
      return var2;
   }

   public T get() {
      return com.google.android.gms.ads.internal.zzr.zzbL().zzd(this);
   }

   public String getKey() {
      return this.zzvs;
   }

   protected abstract T zza(SharedPreferences var1);

   public T zzdq() {
      return this.zzvt;
   }
}
