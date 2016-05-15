package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzax;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zze extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_54;
   private static final String zzbhD;
   private static final String zzbhE;
   private final Context context;

   static {
      field_54 = com.google.android.gms.internal.zzad.zzbX.toString();
      zzbhD = com.google.android.gms.internal.zzae.zzex.toString();
      zzbhE = com.google.android.gms.internal.zzae.zzeA.toString();
   }

   public zze(Context var1) {
      String var2 = field_54;
      String[] var3 = new String[]{zzbhE};
      super(var2, var3);
      this.context = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbhE);
      if(var2 == null) {
         return zzdf.zzHF();
      } else {
         String var3 = zzdf.zzg(var2);
         com.google.android.gms.internal.zzag.zza var4 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbhD);
         String var5;
         if(var4 != null) {
            var5 = zzdf.zzg(var4);
         } else {
            var5 = null;
         }

         String var6 = zzax.zzf(this.context, var3, var5);
         return var6 != null?zzdf.zzR(var6):zzdf.zzHF();
      }
   }
}
