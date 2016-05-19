package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public final class zzda implements zzdf {
   private final zzdb zzyW;

   public zzda(zzdb var1) {
      this.zzyW = var1;
   }

   public void zza(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("name");
      if(var3 == null) {
         zzin.zzaK("App event with no name parameter.");
      } else {
         this.zzyW.onAppEvent(var3, (String)var2.get("info"));
      }
   }
}
