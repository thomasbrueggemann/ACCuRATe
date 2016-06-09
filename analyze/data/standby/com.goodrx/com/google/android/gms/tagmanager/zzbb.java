package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Locale;
import java.util.Map;

public class zzbb extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_44;

   static {
      field_44 = com.google.android.gms.internal.zzad.zzbM.toString();
   }

   public zzbb() {
      super(field_44, new String[0]);
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      Locale var2 = Locale.getDefault();
      if(var2 == null) {
         return zzdf.zzHF();
      } else {
         String var3 = var2.getLanguage();
         return var3 == null?zzdf.zzHF():zzdf.zzR(var3.toLowerCase());
      }
   }
}
