package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class zzt extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_72;
   private static final String zzbhF;
   private static final String zzbip;
   private final zzt.zza zzbiq;

   static {
      field_72 = com.google.android.gms.internal.zzad.zzbJ.toString();
      zzbip = com.google.android.gms.internal.zzae.zzfH.toString();
      zzbhF = com.google.android.gms.internal.zzae.zzdI.toString();
   }

   public zzt(zzt.zza var1) {
      String var2 = field_72;
      String[] var3 = new String[]{zzbip};
      super(var2, var3);
      this.zzbiq = var1;
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(zzbip));
      HashMap var3 = new HashMap();
      com.google.android.gms.internal.zzag.zza var4 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbhF);
      if(var4 != null) {
         Object var7 = zzdf.zzl(var4);
         if(!(var7 instanceof Map)) {
            zzbg.zzaK("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
            return zzdf.zzHF();
         }

         Iterator var8 = ((Map)var7).entrySet().iterator();

         while(var8.hasNext()) {
            Entry var9 = (Entry)var8.next();
            var3.put(var9.getKey().toString(), var9.getValue());
         }
      }

      try {
         com.google.android.gms.internal.zzag.zza var6 = zzdf.zzR(this.zzbiq.zzc(var2, var3));
         return var6;
      } catch (Exception var10) {
         zzbg.zzaK("Custom macro/tag " + var2 + " threw exception " + var10.getMessage());
         return zzdf.zzHF();
      }
   }

   public interface zza {
      Object zzc(String var1, Map<String, Object> var2);
   }
}
