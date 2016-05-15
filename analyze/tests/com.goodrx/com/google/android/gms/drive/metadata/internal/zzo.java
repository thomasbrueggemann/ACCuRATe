package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;

public class zzo extends com.google.android.gms.drive.metadata.zzb<String> {
   public zzo(String var1, int var2) {
      super(var1, Collections.singleton(var1), Collections.emptySet(), var2);
   }

   // $FF: synthetic method
   protected Object zzn(Bundle var1) {
      return this.zzs(var1);
   }

   protected Collection<String> zzs(Bundle var1) {
      return var1.getStringArrayList(this.getName());
   }
}
