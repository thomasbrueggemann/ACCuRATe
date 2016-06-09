package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzcz;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcf extends zzcz {
   // $FF: renamed from: ID java.lang.String
   private static final String field_68;
   private static final String zzbkc;

   static {
      field_68 = com.google.android.gms.internal.zzad.zzcy.toString();
      zzbkc = com.google.android.gms.internal.zzae.zzfO.toString();
   }

   public zzcf() {
      super(field_68);
   }

   protected boolean zza(String var1, String var2, Map<String, com.google.android.gms.internal.zzag.zza> var3) {
      byte var4;
      if(zzdf.zzk((com.google.android.gms.internal.zzag.zza)var3.get(zzbkc)).booleanValue()) {
         var4 = 66;
      } else {
         var4 = 64;
      }

      try {
         boolean var6 = Pattern.compile(var2, var4).matcher(var1).find();
         return var6;
      } catch (PatternSyntaxException var7) {
         return false;
      }
   }
}
