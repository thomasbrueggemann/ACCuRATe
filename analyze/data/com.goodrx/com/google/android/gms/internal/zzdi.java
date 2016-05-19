package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdj;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public class zzdi implements zzdf {
   private final zzdj zzzy;

   public zzdi(zzdj var1) {
      this.zzzy = var1;
   }

   public void zza(zzjp var1, Map<String, String> var2) {
      boolean var3 = "1".equals(var2.get("transparentBackground"));
      boolean var4 = "1".equals(var2.get("blur"));

      float var6;
      label18: {
         float var7;
         label17: {
            try {
               if(var2.get("blurRadius") != null) {
                  var7 = Float.parseFloat((String)var2.get("blurRadius"));
                  break label17;
               }
            } catch (NumberFormatException var8) {
               zzin.zzb("Fail to parse float", var8);
            }

            var6 = 0.0F;
            break label18;
         }

         var6 = var7;
      }

      this.zzzy.zzd(var3);
      this.zzzy.zza(var4, var6);
   }
}
