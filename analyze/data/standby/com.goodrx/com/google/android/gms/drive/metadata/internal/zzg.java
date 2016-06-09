package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;

public class zzg extends com.google.android.gms.drive.metadata.zza<Long> {
   public zzg(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   protected Object zzn(Bundle var1) {
      return this.zzr(var1);
   }

   protected Long zzr(Bundle var1) {
      return Long.valueOf(var1.getLong(this.getName()));
   }
}
