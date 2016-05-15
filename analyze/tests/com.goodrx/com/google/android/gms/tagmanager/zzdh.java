package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzdh extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_36;
   private static final String zzbiQ;

   static {
      field_36 = com.google.android.gms.internal.zzad.zzci.toString();
      zzbiQ = com.google.android.gms.internal.zzae.zzdV.toString();
   }

   public zzdh() {
      String var1 = field_36;
      String[] var2 = new String[]{zzbiQ};
      super(var1, var2);
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      return zzdf.zzR(zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(zzbiQ)).toUpperCase());
   }
}
