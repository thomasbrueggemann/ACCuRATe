package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.List;

public class ImmutableList<E> extends ArrayList<E> {
   private ImmutableList(List<E> var1) {
      super(var1);
   }

   public static <E> ImmutableList<E> copyOf(List<E> var0) {
      return new ImmutableList(var0);
   }
}
