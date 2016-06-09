package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzde;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzcc extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_47;
   private static final String zzbjY;
   private static final String zzbjZ;

   static {
      field_47 = com.google.android.gms.internal.zzad.zzbP.toString();
      zzbjY = com.google.android.gms.internal.zzae.zzgm.toString();
      zzbjZ = com.google.android.gms.internal.zzae.zzgk.toString();
   }

   public zzcc() {
      super(field_47, new String[0]);
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbjY);
      com.google.android.gms.internal.zzag.zza var3 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbjZ);
      double var4;
      double var6;
      if(var2 != null && var2 != zzdf.zzHF() && var3 != null && var3 != zzdf.zzHF()) {
         zzde var8 = zzdf.zzh(var2);
         zzde var9 = zzdf.zzh(var3);
         if(var8 != zzdf.zzHD() && var9 != zzdf.zzHD()) {
            double var10 = var8.doubleValue();
            var4 = var9.doubleValue();
            if(var10 <= var4) {
               var6 = var10;
               return zzdf.zzR(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
            }
         }
      }

      var4 = 2.147483647E9D;
      var6 = 0.0D;
      return zzdf.zzR(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
   }
}
