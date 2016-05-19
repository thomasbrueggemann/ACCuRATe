package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import java.util.Collection;

public class zzb extends com.google.android.gms.drive.metadata.zza<Boolean> {
   public zzb(String var1, int var2) {
      super(var1, var2);
   }

   public zzb(String var1, Collection<String> var2, Collection<String> var3, int var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   protected Object zzn(Bundle var1) {
      return this.zzo(var1);
   }

   protected Boolean zzo(Bundle var1) {
      return Boolean.valueOf(var1.getBoolean(this.getName()));
   }
}
