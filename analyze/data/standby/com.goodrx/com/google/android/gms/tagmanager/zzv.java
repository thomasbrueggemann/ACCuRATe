package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzv extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_73;
   private static final String NAME;
   private static final String zzbiA;
   private final DataLayer zzbhN;

   static {
      field_73 = com.google.android.gms.internal.zzad.zzbz.toString();
      NAME = com.google.android.gms.internal.zzae.zzgo.toString();
      zzbiA = com.google.android.gms.internal.zzae.zzeY.toString();
   }

   public zzv(DataLayer var1) {
      String var2 = field_73;
      String[] var3 = new String[]{NAME};
      super(var2, var3);
      this.zzbhN = var1;
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      Object var2 = this.zzbhN.get(zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(NAME)));
      if(var2 == null) {
         com.google.android.gms.internal.zzag.zza var3 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiA);
         return var3 != null?var3:zzdf.zzHF();
      } else {
         return zzdf.zzR(var2);
      }
   }
}
