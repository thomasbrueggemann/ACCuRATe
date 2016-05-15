package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

public interface zzf<F> {
   F zzB(F var1);

   <T> F zzb(com.google.android.gms.drive.metadata.zzb<T> var1, T var2);

   <T> F zzb(Operator var1, MetadataField<T> var2, T var3);

   F zzb(Operator var1, List<F> var2);

   F zzdj(String var1);

   F zze(MetadataField<?> var1);

   <T> F zze(MetadataField<T> var1, T var2);

   F zztP();

   F zztQ();
}
