package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzbx {
   @Nullable
   public static zzbz zza(@Nullable zzcb var0, long var1) {
      return var0 == null?null:var0.zzb(var1);
   }

   public static boolean zza(@Nullable zzcb var0, @Nullable zzbz var1, long var2, String... var4) {
      return var0 != null && var1 != null?var0.zza(var1, var2, var4):false;
   }

   public static boolean zza(@Nullable zzcb var0, @Nullable zzbz var1, String... var2) {
      return var0 != null && var1 != null?var0.zza(var1, var2):false;
   }

   @Nullable
   public static zzbz zzb(@Nullable zzcb var0) {
      return var0 == null?null:var0.zzdB();
   }
}
