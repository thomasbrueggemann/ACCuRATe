package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzr;

public class zzm<T> {
   public final T result;
   public final zzb.zza zzag;
   public final zzr zzah;
   public boolean zzai = false;

   private zzm(zzr var1) {
      this.result = null;
      this.zzag = null;
      this.zzah = var1;
   }

   private zzm(T var1, zzb.zza var2) {
      this.result = var1;
      this.zzag = var2;
      this.zzah = null;
   }

   public static <T> zzm<T> zza(T var0, zzb.zza var1) {
      return new zzm(var0, var1);
   }

   public static <T> zzm<T> zzd(zzr var0) {
      return new zzm(var0);
   }

   public boolean isSuccess() {
      return this.zzah == null;
   }

   public interface zza {
      void zze(zzr var1);
   }

   public interface zzb<T> {
      void zzb(T var1);
   }
}
