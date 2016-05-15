package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzfm;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzmr;
import java.util.Map;

@zzhb
public class zzdl implements zzdf {
   static final Map<String, Integer> zzzC = zzmr.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
   private final com.google.android.gms.ads.internal.zze zzzA;
   private final zzfn zzzB;

   public zzdl(com.google.android.gms.ads.internal.zze var1, zzfn var2) {
      this.zzzA = var1;
      this.zzzB = var2;
   }

   public void zza(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("a");
      int var4 = ((Integer)zzzC.get(var3)).intValue();
      if(var4 != 5 && this.zzzA != null && !this.zzzA.zzbh()) {
         this.zzzA.zzq((String)null);
      } else {
         switch(var4) {
         case 1:
            this.zzzB.zzi(var2);
            return;
         case 2:
         default:
            zzin.zzaJ("Unknown MRAID command called.");
            return;
         case 3:
            (new zzfp(var1, var2)).execute();
            return;
         case 4:
            (new zzfm(var1, var2)).execute();
            return;
         case 5:
            (new zzfo(var1, var2)).execute();
            return;
         case 6:
            this.zzzB.zzp(true);
         }
      }
   }
}
