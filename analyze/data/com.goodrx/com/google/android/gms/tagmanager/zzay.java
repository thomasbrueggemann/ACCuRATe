package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.tagmanager.zzdj;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzay extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_39;
   private static final String zzbiQ;
   private static final String zzbji;
   private static final String zzbjj;
   private static final String zzbjk;

   static {
      field_39 = com.google.android.gms.internal.zzad.zzcd.toString();
      zzbiQ = com.google.android.gms.internal.zzae.zzdV.toString();
      zzbji = com.google.android.gms.internal.zzae.zzfU.toString();
      zzbjj = com.google.android.gms.internal.zzae.zzfY.toString();
      zzbjk = com.google.android.gms.internal.zzae.zzfr.toString();
   }

   public zzay() {
      String var1 = field_39;
      String[] var2 = new String[]{zzbiQ};
      super(var1, var2);
   }

   private String zza(String var1, zzay.zza var2, Set<Character> var3) {
      switch(null.zzbjl[var2.ordinal()]) {
      case 1:
         try {
            String var9 = zzdj.zzgA(var1);
            return var9;
         } catch (UnsupportedEncodingException var10) {
            zzbg.zzb("Joiner: unsupported encoding", var10);
            return var1;
         }
      case 2:
         String var4 = var1.replace("\\", "\\\\");
         Iterator var5 = var3.iterator();

         String var6;
         String var7;
         for(var6 = var4; var5.hasNext(); var6 = var6.replace(var7, "\\" + var7)) {
            var7 = ((Character)var5.next()).toString();
         }

         return var6;
      default:
         return var1;
      }
   }

   private void zza(StringBuilder var1, String var2, zzay.zza var3, Set<Character> var4) {
      var1.append(this.zza(var2, var3, var4));
   }

   private void zza(Set<Character> var1, String var2) {
      for(int var3 = 0; var3 < var2.length(); ++var3) {
         var1.add(Character.valueOf(var2.charAt(var3)));
      }

   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      com.google.android.gms.internal.zzag.zza var2 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbiQ);
      if(var2 == null) {
         return zzdf.zzHF();
      } else {
         com.google.android.gms.internal.zzag.zza var3 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbji);
         String var4;
         if(var3 != null) {
            var4 = zzdf.zzg(var3);
         } else {
            var4 = "";
         }

         com.google.android.gms.internal.zzag.zza var5 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbjj);
         String var6;
         if(var5 != null) {
            var6 = zzdf.zzg(var5);
         } else {
            var6 = "=";
         }

         zzay.zza var7 = zzay.zza.zzbjm;
         com.google.android.gms.internal.zzag.zza var8 = (com.google.android.gms.internal.zzag.zza)var1.get(zzbjk);
         zzay.zza var9;
         HashSet var10;
         if(var8 != null) {
            String var23 = zzdf.zzg(var8);
            if("url".equals(var23)) {
               var9 = zzay.zza.zzbjn;
               var10 = null;
            } else {
               if(!"backslash".equals(var23)) {
                  zzbg.method_353("Joiner: unsupported escape type: " + var23);
                  return zzdf.zzHF();
               }

               var9 = zzay.zza.zzbjo;
               var10 = new HashSet();
               this.zza(var10, var4);
               this.zza(var10, var6);
               var10.remove(Character.valueOf('\\'));
            }
         } else {
            var9 = var7;
            var10 = null;
         }

         StringBuilder var11 = new StringBuilder();
         switch(var2.type) {
         case 2:
            boolean var17 = true;
            com.google.android.gms.internal.zzag.zza[] var18 = var2.zzjy;
            int var19 = var18.length;

            for(int var20 = 0; var20 < var19; var17 = false) {
               com.google.android.gms.internal.zzag.zza var21 = var18[var20];
               if(!var17) {
                  var11.append(var4);
               }

               this.zza(var11, zzdf.zzg(var21), var9, var10);
               ++var20;
            }

            return zzdf.zzR(var11.toString());
         case 3:
            for(int var12 = 0; var12 < var2.zzjz.length; ++var12) {
               if(var12 > 0) {
                  var11.append(var4);
               }

               String var13 = zzdf.zzg(var2.zzjz[var12]);
               String var14 = zzdf.zzg(var2.zzjA[var12]);
               this.zza(var11, var13, var9, var10);
               var11.append(var6);
               this.zza(var11, var14, var9, var10);
            }

            return zzdf.zzR(var11.toString());
         default:
            this.zza(var11, zzdf.zzg(var2), var9, var10);
            return zzdf.zzR(var11.toString());
         }
      }
   }

   private static enum zza {
      zzbjm,
      zzbjn,
      zzbjo;

      static {
         zzay.zza[] var0 = new zzay.zza[]{zzbjm, zzbjn, zzbjo};
      }
   }
}
