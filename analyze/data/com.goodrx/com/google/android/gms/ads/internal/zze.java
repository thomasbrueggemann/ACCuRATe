package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zze {
   private boolean zzpA;
   private boolean zzpB;
   private zze.zza zzpz;

   public zze() {
      this.zzpB = ((Boolean)zzbt.zzvI.get()).booleanValue();
   }

   public zze(boolean var1) {
      this.zzpB = var1;
   }

   public boolean zzbh() {
      return !this.zzpB || this.zzpA;
   }

   public void zzq(String var1) {
      zzin.zzaI("Action was blocked because no click was detected.");
      if(this.zzpz != null) {
         this.zzpz.zzr(var1);
      }

   }

   public interface zza {
      void zzr(String var1);
   }
}
