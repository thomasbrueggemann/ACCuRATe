package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzca;
import com.google.android.gms.tagmanager.zzde;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

abstract class zzbv extends zzca {
   public zzbv(String var1) {
      super(var1);
   }

   protected boolean zza(com.google.android.gms.internal.zzag.zza var1, com.google.android.gms.internal.zzag.zza var2, Map<String, com.google.android.gms.internal.zzag.zza> var3) {
      zzde var4 = zzdf.zzh(var1);
      zzde var5 = zzdf.zzh(var2);
      return var4 != zzdf.zzHD() && var5 != zzdf.zzHD()?this.zza(var4, var5, var3):false;
   }

   protected abstract boolean zza(zzde var1, zzde var2, Map<String, com.google.android.gms.internal.zzag.zza> var3);
}
