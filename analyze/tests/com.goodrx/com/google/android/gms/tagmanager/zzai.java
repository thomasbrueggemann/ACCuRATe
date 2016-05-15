package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzcp;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzai extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_50;
   private final zzcp zzbhO;

   static {
      field_50 = com.google.android.gms.internal.zzad.zzbI.toString();
   }

   public zzai(zzcp var1) {
      super(field_50, new String[0]);
      this.zzbhO = var1;
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2 = this.zzbhO.zzHe();
      return var2 == null?zzdf.zzHF():zzdf.zzR(var2);
   }
}
