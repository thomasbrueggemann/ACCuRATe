package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.purchase.zzl;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zzk {
   private final String zzuM;

   public boolean zza(String var1, int var2, Intent var3) {
      if(var1 != null && var3 != null) {
         String var4 = zzr.zzbM().zze(var3);
         String var5 = zzr.zzbM().zzf(var3);
         if(var4 != null && var5 != null) {
            if(!var1.equals(zzr.zzbM().zzaq(var4))) {
               zzin.zzaK("Developer payload not match.");
               return false;
            }

            if(this.zzuM != null && !zzl.zzc(this.zzuM, var4, var5)) {
               zzin.zzaK("Fail to verify signature.");
               return false;
            }

            return true;
         }
      }

      return false;
   }

   public String zzfZ() {
      return zzr.zzbC().zzhs();
   }
}
