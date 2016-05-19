package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import java.util.HashMap;
import java.util.Map;

@zzhb
public class zzca {
   @Nullable
   private final zzcb zzpe;
   private final Map<String, zzbz> zzxy;

   public zzca(@Nullable zzcb var1) {
      this.zzpe = var1;
      this.zzxy = new HashMap();
   }

   public void zza(String var1, zzbz var2) {
      this.zzxy.put(var1, var2);
   }

   public void zza(String var1, String var2, long var3) {
      zzbx.zza(this.zzpe, (zzbz)this.zzxy.get(var2), var3, new String[]{var1});
      this.zzxy.put(var1, zzbx.zza(this.zzpe, var3));
   }

   @Nullable
   public zzcb zzdA() {
      return this.zzpe;
   }
}
