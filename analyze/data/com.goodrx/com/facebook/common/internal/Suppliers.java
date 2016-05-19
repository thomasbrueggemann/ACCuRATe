package com.facebook.common.internal;

import com.facebook.common.internal.Supplier;

public class Suppliers {
   // $FF: renamed from: of (java.lang.Object) com.facebook.common.internal.Supplier
   public static <T> Supplier<T> method_601(final T var0) {
      return new Supplier() {
         public T get() {
            return var0;
         }
      };
   }
}
