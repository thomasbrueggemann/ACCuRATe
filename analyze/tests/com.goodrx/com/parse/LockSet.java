package com.parse;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

class LockSet {
   private static long nextStableId = 0L;
   private static WeakHashMap<Lock, Long> stableIds = new WeakHashMap();
   private final Set<Lock> locks = new TreeSet(new Comparator() {
      public int compare(Lock var1, Lock var2) {
         return LockSet.getStableId(var1).compareTo(LockSet.getStableId(var2));
      }
   });

   public LockSet(Collection<Lock> var1) {
      this.locks.addAll(var1);
   }

   private static Long getStableId(Lock param0) {
      // $FF: Couldn't be decompiled
   }

   public void lock() {
      Iterator var1 = this.locks.iterator();

      while(var1.hasNext()) {
         ((Lock)var1.next()).lock();
      }

   }

   public void unlock() {
      Iterator var1 = this.locks.iterator();

      while(var1.hasNext()) {
         ((Lock)var1.next()).unlock();
      }

   }
}
