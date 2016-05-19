package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T> implements MetadataField<T> {
   private final String zzasF;
   private final Set<String> zzasG;
   private final Set<String> zzasH;
   private final int zzasI;

   protected zza(String var1, int var2) {
      this.zzasF = (String)zzx.zzb(var1, "fieldName");
      this.zzasG = Collections.singleton(var1);
      this.zzasH = Collections.emptySet();
      this.zzasI = var2;
   }

   protected zza(String var1, Collection<String> var2, Collection<String> var3, int var4) {
      this.zzasF = (String)zzx.zzb(var1, "fieldName");
      this.zzasG = Collections.unmodifiableSet(new HashSet(var2));
      this.zzasH = Collections.unmodifiableSet(new HashSet(var3));
      this.zzasI = var4;
   }

   public final String getName() {
      return this.zzasF;
   }

   public String toString() {
      return this.zzasF;
   }

   public final T zzm(Bundle var1) {
      zzx.zzb(var1, "bundle");
      return var1.get(this.getName()) != null?this.zzn(var1):null;
   }

   protected abstract T zzn(Bundle var1);
}
