package com.google.android.gms.internal;

import com.google.android.gms.internal.class_372;
import com.google.android.gms.internal.ey;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.gn
@ey
public class class_378 {
   // $FF: renamed from: wN com.google.android.gms.internal.gn$a
   public static final class_378.class_1549<Void> field_1156 = new class_378.class_1549() {
      // $FF: renamed from: b (java.io.InputStream) java.lang.Object
      // $FF: synthetic method
      public Object method_730(InputStream var1) {
         return this.method_4017(var1);
      }

      // $FF: renamed from: c (java.io.InputStream) java.lang.Void
      public Void method_4017(InputStream var1) {
         return null;
      }

      // $FF: renamed from: cQ () java.lang.Object
      // $FF: synthetic method
      public Object method_731() {
         return this.method_4018();
      }

      // $FF: renamed from: dz () java.lang.Void
      public Void method_4018() {
         return null;
      }
   };

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.gn$a) java.util.concurrent.Future
   public <T> Future<T> method_2588(final String var1, final class_378.class_1549<T> var2) {
      return class_372.submit(new Callable() {
         public T call() {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public interface class_1549<T> {
      // $FF: renamed from: b (java.io.InputStream) java.lang.Object
      T method_730(InputStream var1);

      // $FF: renamed from: cQ () java.lang.Object
      T method_731();
   }
}
