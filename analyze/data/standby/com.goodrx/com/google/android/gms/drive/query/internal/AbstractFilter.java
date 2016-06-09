package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;

public abstract class AbstractFilter implements Filter {
   public String toString() {
      Object[] var1 = new Object[]{this.zza(new com.google.android.gms.drive.query.zzc())};
      return String.format("Filter[%s]", var1);
   }
}
