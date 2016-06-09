package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.tagmanager.zzk;
import java.util.Map;

class zzad extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_51;
   private static final String zzbiQ;
   private static final String zzbiR;
   private static final String zzbiS;
   private static final String zzbiT;

   static {
      field_51 = com.google.android.gms.internal.zzad.zzbZ.toString();
      zzbiQ = com.google.android.gms.internal.zzae.zzdV.toString();
      zzbiR = com.google.android.gms.internal.zzae.zzgu.toString();
      zzbiS = com.google.android.gms.internal.zzae.zzfQ.toString();
      zzbiT = com.google.android.gms.internal.zzae.zzgE.toString();
   }

   public zzad() {
      String var1 = field_51;
      String[] var2 = new String[]{zzbiQ};
      super(var1, var2);
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiQ);
      if(var2 != null && var2 != zzdf.zzHF()) {
         String var3 = zzdf.zzg(var2);
         com.google.android.gms.internal.zzag.zza var4 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiS);
         String var5;
         if(var4 == null) {
            var5 = "text";
         } else {
            var5 = zzdf.zzg(var4);
         }

         com.google.android.gms.internal.zzag.zza var6 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiT);
         String var7;
         if(var6 == null) {
            var7 = "base16";
         } else {
            var7 = zzdf.zzg(var6);
         }

         com.google.android.gms.internal.zzag.zza var8 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiR);
         byte var9;
         if(var8 != null && zzdf.zzk(var8).booleanValue()) {
            var9 = 3;
         } else {
            var9 = 2;
         }

         byte[] var12;
         label64: {
            byte[] var14;
            try {
               if(!"text".equals(var5)) {
                  if("base16".equals(var5)) {
                     var12 = zzk.zzfO(var3);
                  } else if("base64".equals(var5)) {
                     var12 = Base64.decode(var3, var9);
                  } else {
                     if(!"base64url".equals(var5)) {
                        zzbg.method_353("Encode: unknown input format: " + var5);
                        com.google.android.gms.internal.zzag.zza var11 = zzdf.zzHF();
                        return var11;
                     }

                     var12 = Base64.decode(var3, var9 | 8);
                  }
                  break label64;
               }

               var14 = var3.getBytes();
            } catch (IllegalArgumentException var15) {
               zzbg.method_353("Encode: invalid input:");
               return zzdf.zzHF();
            }

            var12 = var14;
         }

         String var13;
         if("base16".equals(var7)) {
            var13 = zzk.zzj(var12);
         } else if("base64".equals(var7)) {
            var13 = Base64.encodeToString(var12, var9);
         } else {
            if(!"base64url".equals(var7)) {
               zzbg.method_353("Encode: unknown output format: " + var7);
               return zzdf.zzHF();
            }

            var13 = Base64.encodeToString(var12, var9 | 8);
         }

         return zzdf.zzR(var13);
      } else {
         return zzdf.zzHF();
      }
   }
}
