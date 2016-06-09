package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSet<E> extends HashSet<E> {
   private ImmutableSet(Set<E> var1) {
      super(var1);
   }

   public static <E> ImmutableSet<E> copyOf(Set<E> var0) {
      return new ImmutableSet(var0);
   }

   // $FF: renamed from: of (java.lang.Object[]) com.facebook.common.internal.ImmutableSet
   public static <E> ImmutableSet<E> method_351(E... var0) {
      HashSet var1 = new HashSet();
      Collections.addAll(var1, var0);
      return new ImmutableSet(var1);
   }
}
