package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.u;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.gms.internal.ab
@ey
public class class_207 {
   // $FF: renamed from: mu com.google.android.gms.internal.ab$a
   private final class_207.class_1197 field_336;
   // $FF: renamed from: mv java.lang.Runnable
   private final Runnable field_337;
   // $FF: renamed from: mw com.google.android.gms.internal.av
   private class_218 field_338;
   // $FF: renamed from: mx boolean
   private boolean field_339;
   // $FF: renamed from: my boolean
   private boolean field_340;
   // $FF: renamed from: mz long
   private long field_341;

   public class_207(class_548 var1) {
      this(var1, new class_207.class_1197(class_367.field_1120));
   }

   class_207(final class_548 var1, class_207.class_1197 var2) {
      this.field_339 = false;
      this.field_340 = false;
      this.field_341 = 0L;
      this.field_336 = var2;
      this.field_337 = new Runnable() {
         // $FF: renamed from: mA java.lang.ref.WeakReference
         private final WeakReference<u> field_2614 = new WeakReference(var1);

         public void run() {
            class_207.this.field_339 = false;
            class_548 var2 = (class_548)this.field_2614.get();
            if(var2 != null) {
               var2.method_3334(class_207.this.field_338);
            }

         }
      };
   }

   // $FF: renamed from: a (com.google.android.gms.internal.av, long) void
   public void method_1493(class_218 var1, long var2) {
      if(this.field_339) {
         class_368.method_2506("An ad refresh is already scheduled.");
      } else {
         this.field_338 = var1;
         this.field_339 = true;
         this.field_341 = var2;
         if(!this.field_340) {
            class_368.method_2504("Scheduling ad refresh " + var2 + " milliseconds from now.");
            this.field_336.postDelayed(this.field_337, var2);
            return;
         }
      }

   }

   // $FF: renamed from: aD () boolean
   public boolean method_1494() {
      return this.field_339;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.av) void
   public void method_1495(class_218 var1) {
      this.method_1493(var1, 60000L);
   }

   public void cancel() {
      this.field_339 = false;
      this.field_336.removeCallbacks(this.field_337);
   }

   public void pause() {
      this.field_340 = true;
      if(this.field_339) {
         this.field_336.removeCallbacks(this.field_337);
      }

   }

   public void resume() {
      this.field_340 = false;
      if(this.field_339) {
         this.field_339 = false;
         this.method_1493(this.field_338, this.field_341);
      }

   }

   public static class class_1197 {
      private final Handler mHandler;

      public class_1197(Handler var1) {
         this.mHandler = var1;
      }

      public boolean postDelayed(Runnable var1, long var2) {
         return this.mHandler.postDelayed(var1, var2);
      }

      public void removeCallbacks(Runnable var1) {
         this.mHandler.removeCallbacks(var1);
      }
   }
}
