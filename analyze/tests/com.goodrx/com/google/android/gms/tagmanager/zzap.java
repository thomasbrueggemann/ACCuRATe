package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.tagmanager.zzk;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzap extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_41;
   private static final String zzbiQ;
   private static final String zzbiS;
   private static final String zzbiW;

   static {
      field_41 = com.google.android.gms.internal.zzad.zzcb.toString();
      zzbiQ = com.google.android.gms.internal.zzae.zzdV.toString();
      zzbiW = com.google.android.gms.internal.zzae.zzdL.toString();
      zzbiS = com.google.android.gms.internal.zzae.zzfQ.toString();
   }

   public zzap() {
      String var1 = field_41;
      String[] var2 = new String[]{zzbiQ};
      super(var1, var2);
   }

   private byte[] zzg(String var1, byte[] var2) throws NoSuchAlgorithmException {
      MessageDigest var3 = MessageDigest.getInstance(var1);
      var3.update(var2);
      return var3.digest();
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiQ);
      if(var2 != null && var2 != zzdf.zzHF()) {
         String var3 = zzdf.zzg(var2);
         com.google.android.gms.internal.zzag.zza var4 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiW);
         String var5;
         if(var4 == null) {
            var5 = "MD5";
         } else {
            var5 = zzdf.zzg(var4);
         }

         com.google.android.gms.internal.zzag.zza var6 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiS);
         String var7;
         if(var6 == null) {
            var7 = "text";
         } else {
            var7 = zzdf.zzg(var6);
         }

         byte[] var8;
         if("text".equals(var7)) {
            var8 = var3.getBytes();
         } else {
            if(!"base16".equals(var7)) {
               zzbg.method_353("Hash: unknown input format: " + var7);
               return zzdf.zzHF();
            }

            var8 = zzk.zzfO(var3);
         }

         try {
            com.google.android.gms.internal.zzag.zza var10 = zzdf.zzR(zzk.zzj(this.zzg(var5, var8)));
            return var10;
         } catch (NoSuchAlgorithmException var11) {
            zzbg.method_353("Hash: unknown algorithm: " + var5);
            return zzdf.zzHF();
         }
      } else {
         return zzdf.zzHF();
      }
   }
}
