package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;
import java.util.Collection;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.drive.metadata.b
public abstract class class_266<T> extends a<Collection<T>> {
   protected class_266(String var1, int var2) {
      super(var1, Collections.emptySet(), Collections.emptySet(), var2);
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1835(var1, var2, var3);
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.util.Collection
   protected Collection<T> method_1835(DataHolder var1, int var2, int var3) {
      throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
   }
}
