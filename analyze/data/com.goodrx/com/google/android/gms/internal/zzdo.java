package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;
import java.util.WeakHashMap;

@zzhb
public final class zzdo implements zzdf {
   private final Map<zzjp, Integer> zzzI = new WeakHashMap();

   private static int zza(Context var0, Map<String, String> var1, String var2, int var3) {
      String var4 = (String)var1.get(var2);
      if(var4 != null) {
         int var6;
         try {
            var6 = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(var0, Integer.parseInt(var4));
         } catch (NumberFormatException var7) {
            zzin.zzaK("Could not parse " + var2 + " in a video GMSG: " + var4);
            return var3;
         }

         var3 = var6;
      }

      return var3;
   }

   public void zza(zzjp param1, Map<String, String> param2) {
      // $FF: Couldn't be decompiled
   }
}
