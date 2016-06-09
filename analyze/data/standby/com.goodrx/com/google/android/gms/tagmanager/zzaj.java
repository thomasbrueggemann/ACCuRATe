package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzaj {
   private static void zza(DataLayer var0, com.google.android.gms.internal.zzaf.zzd var1) {
      com.google.android.gms.internal.zzag.zza[] var2 = var1.zziD;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.zzfX(zzdf.zzg(var2[var4]));
      }

   }

   public static void zza(DataLayer var0, com.google.android.gms.internal.zzaf.zzi var1) {
      if(var1.zzjs == null) {
         zzbg.zzaK("supplemental missing experimentSupplemental");
      } else {
         zza(var0, var1.zzjs);
         zzb(var0, var1.zzjs);
         zzc(var0, var1.zzjs);
      }
   }

   private static void zzb(DataLayer var0, com.google.android.gms.internal.zzaf.zzd var1) {
      com.google.android.gms.internal.zzag.zza[] var2 = var1.zziC;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Map var5 = zzc(var2[var4]);
         if(var5 != null) {
            var0.push(var5);
         }
      }

   }

   private static Map<String, Object> zzc(com.google.android.gms.internal.zzag.zza var0) {
      Object var1 = zzdf.zzl(var0);
      if(!(var1 instanceof Map)) {
         zzbg.zzaK("value: " + var1 + " is not a map value, ignored.");
         return null;
      } else {
         return (Map)var1;
      }
   }

   private static void zzc(DataLayer var0, com.google.android.gms.internal.zzaf.zzd var1) {
      com.google.android.gms.internal.zzaf.zzc[] var2 = var1.zziE;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         com.google.android.gms.internal.zzaf.zzc var5 = var2[var4];
         if(var5.key == null) {
            zzbg.zzaK("GaExperimentRandom: No key");
         } else {
            Object var6 = var0.get(var5.key);
            Long var7;
            if(!(var6 instanceof Number)) {
               var7 = null;
            } else {
               var7 = Long.valueOf(((Number)var6).longValue());
            }

            long var8 = var5.zziy;
            long var10 = var5.zziz;
            if(!var5.zziA || var7 == null || var7.longValue() < var8 || var7.longValue() > var10) {
               if(var8 > var10) {
                  zzbg.zzaK("GaExperimentRandom: random range invalid");
                  continue;
               }

               var6 = Long.valueOf(Math.round(Math.random() * (double)(var10 - var8) + (double)var8));
            }

            var0.zzfX(var5.key);
            Map var12 = var0.zzn(var5.key, var6);
            if(var5.zziB > 0L) {
               if(!var12.containsKey("gtm")) {
                  Object[] var15 = new Object[]{"lifetime", Long.valueOf(var5.zziB)};
                  var12.put("gtm", DataLayer.mapOf(var15));
               } else {
                  Object var13 = var12.get("gtm");
                  if(var13 instanceof Map) {
                     ((Map)var13).put("lifetime", Long.valueOf(var5.zziB));
                  } else {
                     zzbg.zzaK("GaExperimentRandom: gtm not a map");
                  }
               }
            }

            var0.push(var12);
         }
      }

   }
}
