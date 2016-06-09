package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Iterator;
import java.util.Map;

public abstract class zzca extends zzak {
   private static final String zzbiQ;
   private static final String zzbjO;

   static {
      zzbiQ = com.google.android.gms.internal.zzae.zzdV.toString();
      zzbjO = com.google.android.gms.internal.zzae.zzdW.toString();
   }

   public zzca(String var1) {
      String[] var2 = new String[]{zzbiQ, zzbjO};
      super(var1, var2);
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      Iterator var2 = var1.values().iterator();

      while(var2.hasNext()) {
         if((com.google.android.gms.internal.zzag.zza)var2.next() == zzdf.zzHF()) {
            return zzdf.zzR(Boolean.valueOf(false));
         }
      }

      com.google.android.gms.internal.zzag.zza var3 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiQ);
      com.google.android.gms.internal.zzag.zza var4 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbjO);
      boolean var5;
      if(var3 != null && var4 != null) {
         var5 = this.zza(var3, var4, var1);
      } else {
         var5 = false;
      }

      return zzdf.zzR(Boolean.valueOf(var5));
   }

   protected abstract boolean zza(com.google.android.gms.internal.zzag.zza var1, com.google.android.gms.internal.zzag.zza var2, Map<String, com.google.android.gms.internal.zzag.zza> var3);
}
