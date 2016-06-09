package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class Sets {
   public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
      return new CopyOnWriteArraySet();
   }

   public static <E> HashSet<E> newHashSet() {
      return new HashSet();
   }

   public static <E> HashSet<E> newHashSet(Iterable<? extends E> var0) {
      return var0 instanceof Collection?new HashSet((Collection)var0):newHashSet(var0.iterator());
   }

   public static <E> HashSet<E> newHashSet(Iterator<? extends E> var0) {
      HashSet var1 = newHashSet();

      while(var0.hasNext()) {
         var1.add(var0.next());
      }

      return var1;
   }

   public static <E> HashSet<E> newHashSet(E... var0) {
      HashSet var1 = newHashSetWithCapacity(var0.length);
      Collections.addAll(var1, var0);
      return var1;
   }

   public static <E> HashSet<E> newHashSetWithCapacity(int var0) {
      return new HashSet(var0);
   }

   public static <E> Set<E> newIdentityHashSet() {
      return newSetFromMap(new IdentityHashMap());
   }

   public static <E> LinkedHashSet<E> newLinkedHashSet() {
      return new LinkedHashSet();
   }

   public static <E> Set<E> newSetFromMap(Map<E, Boolean> var0) {
      return Collections.newSetFromMap(var0);
   }
}
