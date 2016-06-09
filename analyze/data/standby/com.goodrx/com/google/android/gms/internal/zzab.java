package com.google.android.gms.internal;

import com.google.android.gms.internal.zzi;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzx;
import java.io.UnsupportedEncodingException;

public class zzab extends zzk<String> {
   private final zzm.zzb<String> zzaG;

   public zzab(int var1, String var2, zzm.zzb<String> var3, zzm.zza var4) {
      super(var1, var2, var4);
      this.zzaG = var3;
   }

   public zzab(String var1, zzm.zzb<String> var2, zzm.zza var3) {
      this(0, var1, var2, var3);
   }

   protected zzm<String> zza(zzi var1) {
      String var2;
      try {
         var2 = new String(var1.data, zzx.zza(var1.zzA));
      } catch (UnsupportedEncodingException var4) {
         var2 = new String(var1.data);
      }

      return zzm.zza(var2, zzx.zzb(var1));
   }

   // $FF: synthetic method
   protected void zza(Object var1) {
      this.zzi((String)var1);
   }

   protected void zzi(String var1) {
      this.zzaG.zzb(var1);
   }
}
