package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzax;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzaw extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_38;
   private static final String zzbhD;
   private final Context context;

   static {
      field_38 = com.google.android.gms.internal.zzad.zzcc.toString();
      zzbhD = com.google.android.gms.internal.zzae.zzex.toString();
   }

   public zzaw(Context var1) {
      super(field_38, new String[0]);
      this.context = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2;
      if((com.google.android.gms.internal.zzag.zza)var1.get(zzbhD) != null) {
         var2 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(zzbhD));
      } else {
         var2 = null;
      }

      String var3 = zzax.zzm(this.context, var2);
      return var3 != null?zzdf.zzR(var3):zzdf.zzHF();
   }
}
