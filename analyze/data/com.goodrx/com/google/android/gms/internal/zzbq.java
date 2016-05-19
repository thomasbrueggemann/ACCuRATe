package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzhb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@zzhb
public class zzbq {
   private final Collection<zzbp> zzvu = new ArrayList();
   private final Collection<zzbp<String>> zzvv = new ArrayList();
   private final Collection<zzbp<String>> zzvw = new ArrayList();

   public void zza(zzbp var1) {
      this.zzvu.add(var1);
   }

   public void zzb(zzbp<String> var1) {
      this.zzvv.add(var1);
   }

   public void zzc(zzbp<String> var1) {
      this.zzvw.add(var1);
   }

   public List<String> zzdr() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.zzvv.iterator();

      while(var2.hasNext()) {
         String var3 = (String)((zzbp)var2.next()).get();
         if(var3 != null) {
            var1.add(var3);
         }
      }

      return var1;
   }
}
