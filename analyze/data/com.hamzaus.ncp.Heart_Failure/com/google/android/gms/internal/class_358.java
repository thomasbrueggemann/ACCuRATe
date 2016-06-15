package com.google.android.gms.internal;

import com.google.android.gms.internal.class_366;

// $FF: renamed from: com.google.android.gms.internal.en
public abstract class class_358 {
   // $FF: renamed from: le java.lang.Runnable
   private final Runnable field_1543 = new Runnable() {
      public final void run() {
         class_358.this.field_1544 = Thread.currentThread();
         class_358.this.method_2261();
      }
   };
   // $FF: renamed from: sc java.lang.Thread
   private volatile Thread field_1544;

   // $FF: renamed from: bc () void
   public abstract void method_2261();

   public final void cancel() {
      this.onStop();
      if(this.field_1544 != null) {
         this.field_1544.interrupt();
      }

   }

   public abstract void onStop();

   public final void start() {
      class_366.execute(this.field_1543);
   }
}
