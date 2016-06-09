package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Collection;

public class zzj<T extends Parcelable> extends com.google.android.gms.drive.metadata.zzb<T> {
   public zzj(String var1, Collection<String> var2, Collection<String> var3, int var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   protected Object zzn(Bundle var1) {
      return this.zzs(var1);
   }

   protected Collection<T> zzs(Bundle var1) {
      return var1.getParcelableArrayList(this.getName());
   }
}
