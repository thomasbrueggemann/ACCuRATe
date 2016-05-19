package com.google.android.gms.internal;

import com.google.android.gms.internal.zzo;
import com.google.android.gms.internal.zzr;

public class zzd implements zzo {
   private int zzo;
   private int zzp;
   private final int zzq;
   private final float zzr;

   public zzd() {
      this(2500, 1, 1.0F);
   }

   public zzd(int var1, int var2, float var3) {
      this.zzo = var1;
      this.zzq = var2;
      this.zzr = var3;
   }

   public void zza(zzr var1) throws zzr {
      ++this.zzp;
      this.zzo = (int)((float)this.zzo + (float)this.zzo * this.zzr);
      if(!this.zzf()) {
         throw var1;
      }
   }

   public int zzd() {
      return this.zzo;
   }

   public int zze() {
      return this.zzp;
   }

   protected boolean zzf() {
      return this.zzp <= this.zzq;
   }
}
