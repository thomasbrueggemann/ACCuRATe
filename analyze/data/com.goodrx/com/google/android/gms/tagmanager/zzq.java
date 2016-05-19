package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzq extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_61;
   private final String zzadc;

   static {
      field_61 = com.google.android.gms.internal.zzad.zzbA.toString();
   }

   public zzq(String var1) {
      super(field_61, new String[0]);
      this.zzadc = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      return this.zzadc == null?zzdf.zzHF():zzdf.zzR(this.zzadc);
   }
}
