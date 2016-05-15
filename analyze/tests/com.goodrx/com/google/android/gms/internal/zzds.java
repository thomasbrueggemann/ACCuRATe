package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public class zzds implements zzdf {
   public void zza(zzjp var1, Map<String, String> var2) {
      zzdq var3 = com.google.android.gms.ads.internal.zzr.zzbR();
      if(var2.containsKey("abort")) {
         if(!var3.zzd(var1)) {
            zzin.zzaK("Precache abort but no preload task running.");
         }

      } else {
         String var4 = (String)var2.get("src");
         if(var4 == null) {
            zzin.zzaK("Precache video action is missing the src parameter.");
         } else {
            int var6;
            label30: {
               int var9;
               try {
                  var9 = Integer.parseInt((String)var2.get("player"));
               } catch (NumberFormatException var10) {
                  var6 = 0;
                  break label30;
               }

               var6 = var9;
            }

            String var7;
            if(var2.containsKey("mimetype")) {
               var7 = (String)var2.get("mimetype");
            } else {
               var7 = "";
            }

            if(var3.zze(var1)) {
               zzin.zzaK("Precache task already running.");
            } else {
               com.google.android.gms.common.internal.zzb.zzv(var1.zzhR());
               (new zzdp(var1, var1.zzhR().zzpw.zza(var1, var6, var7), var4)).zzhn();
            }
         }
      }
   }
}
