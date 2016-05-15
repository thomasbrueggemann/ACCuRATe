package com.google.android.gms.common.stats;

public abstract class zzf {
   public abstract int getEventType();

   public abstract long getTimeMillis();

   public String toString() {
      return this.getTimeMillis() + "\t" + this.getEventType() + "\t" + this.zzrL() + this.zzrO();
   }

   public abstract long zzrL();

   public abstract String zzrO();
}
