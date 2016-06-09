package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzbw;
import com.google.android.gms.tagmanager.zzdf;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzdj {
   private static zzbw<com.google.android.gms.internal.zzag.zza> zza(zzbw<com.google.android.gms.internal.zzag.zza> var0) {
      try {
         zzbw var1 = new zzbw(zzdf.zzR(zzgA(zzdf.zzg((com.google.android.gms.internal.zzag.zza)var0.getObject()))), var0.zzGP());
         return var1;
      } catch (UnsupportedEncodingException var3) {
         zzbg.zzb("Escape URI: unsupported encoding", var3);
         return var0;
      }
   }

   private static zzbw<com.google.android.gms.internal.zzag.zza> zza(zzbw<com.google.android.gms.internal.zzag.zza> var0, int var1) {
      if(!zzn((com.google.android.gms.internal.zzag.zza)var0.getObject())) {
         zzbg.method_353("Escaping can only be applied to strings.");
         return var0;
      } else {
         switch(var1) {
         case 12:
            return zza(var0);
         default:
            zzbg.method_353("Unsupported Value Escaping: " + var1);
            return var0;
         }
      }
   }

   static zzbw<com.google.android.gms.internal.zzag.zza> zza(zzbw<com.google.android.gms.internal.zzag.zza> var0, int... var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var0 = zza(var0, var1[var3]);
      }

      return var0;
   }

   static String zzgA(String var0) throws UnsupportedEncodingException {
      return URLEncoder.encode(var0, "UTF-8").replaceAll("\\+", "%20");
   }

   private static boolean zzn(com.google.android.gms.internal.zzag.zza var0) {
      return zzdf.zzl(var0) instanceof String;
   }
}
