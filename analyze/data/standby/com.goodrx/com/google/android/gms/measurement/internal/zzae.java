package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzpz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class zzae {
   final boolean zzaXg;
   final int zzaZh;
   final boolean zzaZi;
   final String zzaZj;
   final List<String> zzaZk;
   final String zzaZl;

   public zzae(zzpz.zzf var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      boolean var3;
      if(var1.zzaZN != null && var1.zzaZN.intValue() != 0) {
         label64: {
            if(var1.zzaZN.intValue() == 6) {
               if(var1.zzaZQ == null || var1.zzaZQ.length == 0) {
                  var3 = false;
                  break label64;
               }
            } else if(var1.zzaZO == null) {
               var3 = false;
               break label64;
            }

            var3 = true;
         }
      } else {
         var3 = false;
      }

      if(var3) {
         this.zzaZh = var1.zzaZN.intValue();
         Boolean var4 = var1.zzaZP;
         boolean var5 = false;
         if(var4 != null) {
            boolean var7 = var1.zzaZP.booleanValue();
            var5 = false;
            if(var7) {
               var5 = true;
            }
         }

         this.zzaZi = var5;
         if(!this.zzaZi && this.zzaZh != 1 && this.zzaZh != 6) {
            this.zzaZj = var1.zzaZO.toUpperCase(Locale.ENGLISH);
         } else {
            this.zzaZj = var1.zzaZO;
         }

         List var6;
         if(var1.zzaZQ == null) {
            var6 = null;
         } else {
            var6 = this.zza(var1.zzaZQ, this.zzaZi);
         }

         this.zzaZk = var6;
         if(this.zzaZh == 1) {
            this.zzaZl = this.zzaZj;
         } else {
            this.zzaZl = null;
         }
      } else {
         this.zzaZh = 0;
         this.zzaZi = false;
         this.zzaZj = null;
         this.zzaZk = null;
         this.zzaZl = null;
      }

      this.zzaXg = var3;
   }

   private List<String> zza(String[] var1, boolean var2) {
      Object var3;
      if(var2) {
         var3 = Arrays.asList(var1);
      } else {
         var3 = new ArrayList();
         int var4 = var1.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ((List)var3).add(var1[var5].toUpperCase(Locale.ENGLISH));
         }
      }

      return (List)var3;
   }

   public Boolean zzfp(String var1) {
      if(!this.zzaXg) {
         return null;
      } else {
         if(!this.zzaZi && this.zzaZh != 1) {
            var1 = var1.toUpperCase(Locale.ENGLISH);
         }

         switch(this.zzaZh) {
         case 1:
            byte var2;
            if(this.zzaZi) {
               var2 = 0;
            } else {
               var2 = 66;
            }

            return Boolean.valueOf(Pattern.compile(this.zzaZl, var2).matcher(var1).matches());
         case 2:
            return Boolean.valueOf(var1.startsWith(this.zzaZj));
         case 3:
            return Boolean.valueOf(var1.endsWith(this.zzaZj));
         case 4:
            return Boolean.valueOf(var1.contains(this.zzaZj));
         case 5:
            return Boolean.valueOf(var1.equals(this.zzaZj));
         case 6:
            return Boolean.valueOf(this.zzaZk.contains(var1));
         default:
            return null;
         }
      }
   }
}
