package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzd;
import com.google.android.gms.measurement.zzg;
import com.google.android.gms.measurement.zzi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzf<T extends zzf> {
   private final zzg zzaUs;
   protected final zzc zzaUt;
   private final List<zzd> zzaUu;

   protected zzf(zzg var1, zzmq var2) {
      zzx.zzz(var1);
      this.zzaUs = var1;
      this.zzaUu = new ArrayList();
      zzc var4 = new zzc(this, var2);
      var4.zzAE();
      this.zzaUt = var4;
   }

   protected zzg zzAC() {
      return this.zzaUs;
   }

   public zzc zzAF() {
      return this.zzaUt;
   }

   public List<zzi> zzAG() {
      return this.zzaUt.zzAw();
   }

   protected void zza(zzc var1) {
   }

   protected void zzd(zzc var1) {
      Iterator var2 = this.zzaUu.iterator();

      while(var2.hasNext()) {
         ((zzd)var2.next()).zza(this, var1);
      }

   }

   public zzc zziy() {
      zzc var1 = this.zzaUt.zzAu();
      this.zzd(var1);
      return var1;
   }
}
