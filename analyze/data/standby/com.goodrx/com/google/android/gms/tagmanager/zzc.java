package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zza;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzc extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_55;
   private final zza zzbhC;

   static {
      field_55 = com.google.android.gms.internal.zzad.zzbs.toString();
   }

   public zzc(Context var1) {
      this(zza.zzaW(var1));
   }

   zzc(zza var1) {
      super(field_55, new String[0]);
      this.zzbhC = var1;
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      boolean var2;
      if(!this.zzbhC.isLimitAdTrackingEnabled()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return zzdf.zzR(Boolean.valueOf(var2));
   }
}
