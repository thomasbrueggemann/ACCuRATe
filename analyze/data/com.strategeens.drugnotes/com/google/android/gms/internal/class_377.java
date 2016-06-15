package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.gk
@ey
public class class_377<T> implements Future<T> {
   // $FF: renamed from: wF java.lang.Object
   private final T field_1155;

   public class_377(T var1) {
      this.field_1155 = var1;
   }

   public boolean cancel(boolean var1) {
      return false;
   }

   public T get() {
      return this.field_1155;
   }

   public T get(long var1, TimeUnit var3) {
      return this.field_1155;
   }

   public boolean isCancelled() {
      return false;
   }

   public boolean isDone() {
      return true;
   }
}
