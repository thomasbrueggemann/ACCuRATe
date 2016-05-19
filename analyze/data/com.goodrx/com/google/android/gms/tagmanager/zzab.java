package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzab extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_52;

   static {
      field_52 = com.google.android.gms.internal.zzad.zzbC.toString();
   }

   public zzab() {
      super(field_52, new String[0]);
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2 = Build.MANUFACTURER;
      String var3 = Build.MODEL;
      if(!var3.startsWith(var2) && !var2.equals("unknown")) {
         var3 = var2 + " " + var3;
      }

      return zzdf.zzR(var3);
   }
}
