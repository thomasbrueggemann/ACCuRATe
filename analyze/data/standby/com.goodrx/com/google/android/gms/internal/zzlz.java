package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzlz<T> {
   private static zzlz.zza zzaiV = null;
   private static int zzaiW = 0;
   private static String zzaiX = "com.google.android.providers.gsf.permission.READ_GSERVICES";
   private static final Object zzqy = new Object();
   private T zzSC = null;
   protected final String zzvs;
   protected final T zzvt;

   protected zzlz(String var1, T var2) {
      this.zzvs = var1;
      this.zzvt = var2;
   }

   public static boolean isInitialized() {
      return zzaiV != null;
   }

   public static zzlz<Float> zza(final String var0, final Float var1) {
      return new zzlz(var0, var1) {
         // $FF: synthetic method
         protected Object zzct(String var1) {
            return this.zzcx(var1);
         }

         protected Float zzcx(String var1) {
            return zzlz.zzaiV.zzb(this.zzvs, (Float)this.zzvt);
         }
      };
   }

   public static zzlz<Integer> zza(final String var0, final Integer var1) {
      return new zzlz(var0, var1) {
         // $FF: synthetic method
         protected Object zzct(String var1) {
            return this.zzcw(var1);
         }

         protected Integer zzcw(String var1) {
            return zzlz.zzaiV.zzb(this.zzvs, (Integer)this.zzvt);
         }
      };
   }

   public static zzlz<Long> zza(final String var0, final Long var1) {
      return new zzlz(var0, var1) {
         // $FF: synthetic method
         protected Object zzct(String var1) {
            return this.zzcv(var1);
         }

         protected Long zzcv(String var1) {
            return zzlz.zzaiV.getLong(this.zzvs, (Long)this.zzvt);
         }
      };
   }

   public static zzlz<Boolean> zzk(final String var0, boolean var1) {
      return new zzlz(var0, Boolean.valueOf(var1)) {
         // $FF: synthetic method
         protected Object zzct(String var1) {
            return this.zzcu(var1);
         }

         protected Boolean zzcu(String var1) {
            return zzlz.zzaiV.zza(this.zzvs, (Boolean)this.zzvt);
         }
      };
   }

   public static int zzpW() {
      return zzaiW;
   }

   public static zzlz<String> zzv(final String var0, final String var1) {
      return new zzlz(var0, var1) {
         // $FF: synthetic method
         protected Object zzct(String var1) {
            return this.zzcy(var1);
         }

         protected String zzcy(String var1) {
            return zzlz.zzaiV.getString(this.zzvs, (String)this.zzvt);
         }
      };
   }

   public final T get() {
      return this.zzSC != null?this.zzSC:this.zzct(this.zzvs);
   }

   protected abstract T zzct(String var1);

   public final T zzpX() {
      long var1 = Binder.clearCallingIdentity();

      Object var4;
      try {
         var4 = this.get();
      } finally {
         Binder.restoreCallingIdentity(var1);
      }

      return var4;
   }

   private interface zza {
      Long getLong(String var1, Long var2);

      String getString(String var1, String var2);

      Boolean zza(String var1, Boolean var2);

      Float zzb(String var1, Float var2);

      Integer zzb(String var1, Integer var2);
   }
}
