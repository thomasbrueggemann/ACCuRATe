package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzdq implements Iterable<zzdp> {
   private final List<zzdp> zzzM = new LinkedList();

   private zzdp zzf(zzjp var1) {
      Iterator var2 = com.google.android.gms.ads.internal.zzr.zzbR().iterator();

      zzdp var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (zzdp)var2.next();
      } while(var3.zzpD != var1);

      return var3;
   }

   public Iterator<zzdp> iterator() {
      return this.zzzM.iterator();
   }

   public void zza(zzdp var1) {
      this.zzzM.add(var1);
   }

   public void zzb(zzdp var1) {
      this.zzzM.remove(var1);
   }

   public boolean zzd(zzjp var1) {
      zzdp var2 = this.zzf(var1);
      if(var2 != null) {
         var2.zzzJ.abort();
         return true;
      } else {
         return false;
      }
   }

   public boolean zze(zzjp var1) {
      return this.zzf(var1) != null;
   }
}
