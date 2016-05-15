package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzca;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

abstract class zzcz extends zzca {
   public zzcz(String var1) {
      super(var1);
   }

   protected boolean zza(com.google.android.gms.internal.zzag.zza var1, com.google.android.gms.internal.zzag.zza var2, Map<String, com.google.android.gms.internal.zzag.zza> var3) {
      String var4 = zzdf.zzg(var1);
      String var5 = zzdf.zzg(var2);
      return var4 != zzdf.zzHE() && var5 != zzdf.zzHE()?this.zza(var4, var5, var3):false;
   }

   protected abstract boolean zza(String var1, String var2, Map<String, com.google.android.gms.internal.zzag.zza> var3);
}
