package com.google.android.gms.internal;

import com.google.android.gms.internal.class_372;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.gf
@ey
public abstract class class_360 {
   // $FF: renamed from: mv java.lang.Runnable
   private final Runnable field_1078 = new Runnable() {
      public final void run() {
         class_360.this.field_1079 = Thread.currentThread();
         class_360.this.method_2464();
      }
   };
   // $FF: renamed from: wu java.lang.Thread
   private volatile Thread field_1079;

   public final void cancel() {
      this.onStop();
      if(this.field_1079 != null) {
         this.field_1079.interrupt();
      }

   }

   // $FF: renamed from: cx () void
   public abstract void method_2464();

   public abstract void onStop();

   public final void start() {
      class_372.method_2539(this.field_1078);
   }
}
