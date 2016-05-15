package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zza {
   static <E> List<E> zzf(Collection<E> var0) {
      return (List)(var0 != null && !var0.isEmpty()?new ArrayList(var0):Collections.emptyList());
   }

   static <E> Set<E> zzw(List<E> var0) {
      return var0 != null && !var0.isEmpty()?Collections.unmodifiableSet(new HashSet(var0)):Collections.emptySet();
   }
}
