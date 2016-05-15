package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzbx extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_46;

   static {
      field_46 = com.google.android.gms.internal.zzad.zzbN.toString();
   }

   public zzbx() {
      super(field_46, new String[0]);
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      return zzdf.zzR(VERSION.RELEASE);
   }
}
