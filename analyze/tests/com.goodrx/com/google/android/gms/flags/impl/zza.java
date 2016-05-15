package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

public abstract class zza<T> {
   public static class zza extends zza<Boolean> {
      public static Boolean zza(final SharedPreferences var0, final String var1, final Boolean var2) {
         return (Boolean)zzpl.zzb(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
               return this.zzvt();
            }

            public Boolean zzvt() {
               return Boolean.valueOf(var0.getBoolean(var1, var2.booleanValue()));
            }
         });
      }
   }

   public static class zzb extends zza<Integer> {
      public static Integer zza(final SharedPreferences var0, final String var1, final Integer var2) {
         return (Integer)zzpl.zzb(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
               return this.zzvu();
            }

            public Integer zzvu() {
               return Integer.valueOf(var0.getInt(var1, var2.intValue()));
            }
         });
      }
   }

   public static class zzc extends zza<Long> {
      public static Long zza(final SharedPreferences var0, final String var1, final Long var2) {
         return (Long)zzpl.zzb(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
               return this.zzvv();
            }

            public Long zzvv() {
               return Long.valueOf(var0.getLong(var1, var2.longValue()));
            }
         });
      }
   }

   public static class zzd extends zza<String> {
      public static String zza(final SharedPreferences var0, final String var1, final String var2) {
         return (String)zzpl.zzb(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
               return this.zzkp();
            }

            public String zzkp() {
               return var0.getString(var1, var2);
            }
         });
      }
   }
}
