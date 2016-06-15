package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.v;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.gms.internal.z
public final class class_451 {
   // $FF: renamed from: ld com.google.android.gms.internal.z$a
   private final class_451.class_1166 field_2720;
   // $FF: renamed from: le java.lang.Runnable
   private final Runnable field_2721;
   // $FF: renamed from: lf com.google.android.gms.internal.aj
   private class_182 field_2722;
   // $FF: renamed from: lg boolean
   private boolean field_2723;
   // $FF: renamed from: lh boolean
   private boolean field_2724;
   // $FF: renamed from: li long
   private long field_2725;

   public class_451(class_452 var1) {
      this(var1, new class_451.class_1166(class_371.field_1606));
   }

   class_451(final class_452 var1, class_451.class_1166 var2) {
      this.field_2723 = false;
      this.field_2724 = false;
      this.field_2725 = 0L;
      this.field_2720 = var2;
      this.field_2721 = new Runnable() {
         // $FF: renamed from: lj java.lang.ref.WeakReference
         private final WeakReference<v> field_4061 = new WeakReference(var1);

         public void run() {
            class_451.this.field_2723 = false;
            class_452 var2 = (class_452)this.field_4061.get();
            if(var2 != null) {
               var2.method_2810(class_451.this.field_2722);
            }

         }
      };
   }

   // $FF: renamed from: a (com.google.android.gms.internal.aj, long) void
   public void method_2791(class_182 var1, long var2) {
      if(this.field_2723) {
         class_370.method_2358("An ad refresh is already scheduled.");
      } else {
         this.field_2722 = var1;
         this.field_2723 = true;
         this.field_2725 = var2;
         if(!this.field_2724) {
            class_370.method_2356("Scheduling ad refresh " + var2 + " milliseconds from now.");
            this.field_2720.postDelayed(this.field_2721, var2);
            return;
         }
      }

   }

   public void cancel() {
      this.field_2723 = false;
      this.field_2720.removeCallbacks(this.field_2721);
   }

   // $FF: renamed from: d (com.google.android.gms.internal.aj) void
   public void method_2792(class_182 var1) {
      this.method_2791(var1, 60000L);
   }

   public void pause() {
      this.field_2724 = true;
      if(this.field_2723) {
         this.field_2720.removeCallbacks(this.field_2721);
      }

   }

   public void resume() {
      this.field_2724 = false;
      if(this.field_2723) {
         this.field_2723 = false;
         this.method_2791(this.field_2722, this.field_2725);
      }

   }

   public static class class_1166 {
      private final Handler mHandler;

      public class_1166(Handler var1) {
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
