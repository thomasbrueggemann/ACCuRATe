package com.google.android.gms.common.data;

import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils {
   public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> var0) {
      ArrayList var1 = new ArrayList(var0.size());
      int var2 = var0.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.add(((Freezable)var0.get(var3)).freeze());
      }

      return var1;
   }

   public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] var0) {
      ArrayList var1 = new ArrayList(var0.length);

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1.add(var0[var2].freeze());
      }

      return var1;
   }

   public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(((Freezable)var2.next()).freeze());
      }

      return var1;
   }
}
