package com.parse;

import java.util.AbstractList;
import java.util.List;

class Lists {
   static <T> List<List<T>> partition(List<T> var0, int var1) {
      return new Lists.Partition(var0, var1);
   }

   private static class Partition<T> extends AbstractList<List<T>> {
      private final List<T> list;
      private final int size;

      public Partition(List<T> var1, int var2) {
         this.list = var1;
         this.size = var2;
      }

      public List<T> get(int var1) {
         int var2 = var1 * this.size;
         int var3 = Math.min(var2 + this.size, this.list.size());
         return this.list.subList(var2, var3);
      }

      public int size() {
         return (int)Math.ceil((double)this.list.size() / (double)this.size);
      }
   }
}
