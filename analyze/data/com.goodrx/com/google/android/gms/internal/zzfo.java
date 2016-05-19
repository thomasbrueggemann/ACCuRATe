package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public class zzfo {
   private final boolean zzDp;
   private final String zzDq;
   private final zzjp zzpD;

   public zzfo(zzjp var1, Map<String, String> var2) {
      this.zzpD = var1;
      this.zzDq = (String)var2.get("forceOrientation");
      if(var2.containsKey("allowOrientationChange")) {
         this.zzDp = Boolean.parseBoolean((String)var2.get("allowOrientationChange"));
      } else {
         this.zzDp = true;
      }
   }

   public void execute() {
      if(this.zzpD == null) {
         zzin.zzaK("AdWebView is null");
      } else {
         int var1;
         if("portrait".equalsIgnoreCase(this.zzDq)) {
            var1 = com.google.android.gms.ads.internal.zzr.zzbE().zzhw();
         } else if("landscape".equalsIgnoreCase(this.zzDq)) {
            var1 = com.google.android.gms.ads.internal.zzr.zzbE().zzhv();
         } else if(this.zzDp) {
            var1 = -1;
         } else {
            var1 = com.google.android.gms.ads.internal.zzr.zzbE().zzhx();
         }

         this.zzpD.setRequestedOrientation(var1);
      }
   }
}
