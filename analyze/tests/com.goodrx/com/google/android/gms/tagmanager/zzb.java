package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zza;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzb extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_56;
   private final zza zzbhC;

   static {
      field_56 = com.google.android.gms.internal.zzad.zzbr.toString();
   }

   public zzb(Context var1) {
      this(zza.zzaW(var1));
   }

   zzb(zza var1) {
      super(field_56, new String[0]);
      this.zzbhC = var1;
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2 = this.zzbhC.zzFQ();
      return var2 == null?zzdf.zzHF():zzdf.zzR(var2);
   }
}
