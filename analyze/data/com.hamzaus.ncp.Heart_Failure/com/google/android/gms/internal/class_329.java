package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.internal.class_275;

// $FF: renamed from: com.google.android.gms.internal.gu
public final class class_329 extends Drawable implements Callback {
   // $FF: renamed from: FA com.google.android.gms.internal.gu$b
   private class_329.class_1231 field_1339;
   // $FF: renamed from: FB android.graphics.drawable.Drawable
   private Drawable field_1340;
   // $FF: renamed from: FC android.graphics.drawable.Drawable
   private Drawable field_1341;
   // $FF: renamed from: FD boolean
   private boolean field_1342;
   // $FF: renamed from: FE boolean
   private boolean field_1343;
   // $FF: renamed from: FF boolean
   private boolean field_1344;
   // $FF: renamed from: FG int
   private int field_1345;
   // $FF: renamed from: Fm boolean
   private boolean field_1346;
   // $FF: renamed from: Fs int
   private int field_1347;
   // $FF: renamed from: Ft long
   private long field_1348;
   // $FF: renamed from: Fu int
   private int field_1349;
   // $FF: renamed from: Fv int
   private int field_1350;
   // $FF: renamed from: Fw int
   private int field_1351;
   // $FF: renamed from: Fx int
   private int field_1352;
   // $FF: renamed from: Fy int
   private int field_1353;
   // $FF: renamed from: Fz boolean
   private boolean field_1354;

   public class_329(Drawable var1, Drawable var2) {
      this((class_329.class_1231)null);
      if(var1 == null) {
         var1 = class_329.class_1121.field_3494;
      }

      this.field_1340 = (Drawable)var1;
      ((Drawable)var1).setCallback(this);
      class_329.class_1231 var3 = this.field_1339;
      var3.field_3497 |= ((Drawable)var1).getChangingConfigurations();
      if(var2 == null) {
         var2 = class_329.class_1121.field_3494;
      }

      this.field_1341 = (Drawable)var2;
      ((Drawable)var2).setCallback(this);
      class_329.class_1231 var4 = this.field_1339;
      var4.field_3497 |= ((Drawable)var2).getChangingConfigurations();
   }

   class_329(class_329.class_1231 var1) {
      this.field_1347 = 0;
      this.field_1351 = 255;
      this.field_1353 = 0;
      this.field_1346 = true;
      this.field_1339 = new class_329.class_1231(var1);
   }

   public boolean canConstantState() {
      if(!this.field_1342) {
         boolean var1;
         if(this.field_1340.getConstantState() != null && this.field_1341.getConstantState() != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.field_1343 = var1;
         this.field_1342 = true;
      }

      return this.field_1343;
   }

   public void draw(Canvas var1) {
      boolean var2 = true;
      boolean var5;
      switch(this.field_1347) {
      case 1:
         this.field_1348 = SystemClock.uptimeMillis();
         this.field_1347 = 2;
         var5 = false;
         break;
      case 2:
         if(this.field_1348 >= 0L) {
            float var3 = (float)(SystemClock.uptimeMillis() - this.field_1348) / (float)this.field_1352;
            if(var3 < 1.0F) {
               var2 = false;
            }

            if(var2) {
               this.field_1347 = 0;
            }

            float var4 = Math.min(var3, 1.0F);
            this.field_1353 = (int)((float)this.field_1349 + var4 * (float)(this.field_1350 - this.field_1349));
         }
      default:
         var5 = var2;
      }

      int var6 = this.field_1353;
      boolean var7 = this.field_1346;
      Drawable var8 = this.field_1340;
      Drawable var9 = this.field_1341;
      if(!var5) {
         if(var7) {
            var8.setAlpha(this.field_1351 - var6);
         }

         var8.draw(var1);
         if(var7) {
            var8.setAlpha(this.field_1351);
         }

         if(var6 > 0) {
            var9.setAlpha(var6);
            var9.draw(var1);
            var9.setAlpha(this.field_1351);
         }

         this.invalidateSelf();
      } else {
         if(!var7 || var6 == 0) {
            var8.draw(var1);
         }

         if(var6 == this.field_1351) {
            var9.setAlpha(this.field_1351);
            var9.draw(var1);
         }

      }
   }

   // $FF: renamed from: fb () android.graphics.drawable.Drawable
   public Drawable method_2108() {
      return this.field_1341;
   }

   public int getChangingConfigurations() {
      return super.getChangingConfigurations() | this.field_1339.field_3496 | this.field_1339.field_3497;
   }

   public ConstantState getConstantState() {
      if(this.canConstantState()) {
         this.field_1339.field_3496 = this.getChangingConfigurations();
         return this.field_1339;
      } else {
         return null;
      }
   }

   public int getIntrinsicHeight() {
      return Math.max(this.field_1340.getIntrinsicHeight(), this.field_1341.getIntrinsicHeight());
   }

   public int getIntrinsicWidth() {
      return Math.max(this.field_1340.getIntrinsicWidth(), this.field_1341.getIntrinsicWidth());
   }

   public int getOpacity() {
      if(!this.field_1344) {
         this.field_1345 = Drawable.resolveOpacity(this.field_1340.getOpacity(), this.field_1341.getOpacity());
         this.field_1344 = true;
      }

      return this.field_1345;
   }

   public void invalidateDrawable(Drawable var1) {
      if(class_275.method_1850()) {
         Callback var2 = this.getCallback();
         if(var2 != null) {
            var2.invalidateDrawable(this);
         }
      }

   }

   public Drawable mutate() {
      if(!this.field_1354 && super.mutate() == this) {
         if(!this.canConstantState()) {
            throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
         }

         this.field_1340.mutate();
         this.field_1341.mutate();
         this.field_1354 = true;
      }

      return this;
   }

   protected void onBoundsChange(Rect var1) {
      this.field_1340.setBounds(var1);
      this.field_1341.setBounds(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      if(class_275.method_1850()) {
         Callback var5 = this.getCallback();
         if(var5 != null) {
            var5.scheduleDrawable(this, var2, var3);
         }
      }

   }

   public void setAlpha(int var1) {
      if(this.field_1353 == this.field_1351) {
         this.field_1353 = var1;
      }

      this.field_1351 = var1;
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.field_1340.setColorFilter(var1);
      this.field_1341.setColorFilter(var1);
   }

   public void startTransition(int var1) {
      this.field_1349 = 0;
      this.field_1350 = this.field_1351;
      this.field_1353 = 0;
      this.field_1352 = var1;
      this.field_1347 = 1;
      this.invalidateSelf();
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      if(class_275.method_1850()) {
         Callback var3 = this.getCallback();
         if(var3 != null) {
            var3.unscheduleDrawable(this, var2);
         }
      }

   }

   private static final class class_1121 extends Drawable {
      // $FF: renamed from: FH com.google.android.gms.internal.gu$a
      private static final class_329.class_1121 field_3494 = new class_329.class_1121();
      // $FF: renamed from: FI com.google.android.gms.internal.gu$a$a
      private static final class_329.class_1122 field_3495 = new class_329.class_1122();

      public void draw(Canvas var1) {
      }

      public ConstantState getConstantState() {
         return field_3495;
      }

      public int getOpacity() {
         return -2;
      }

      public void setAlpha(int var1) {
      }

      public void setColorFilter(ColorFilter var1) {
      }
   }

   private static final class class_1122 extends ConstantState {
      private class_1122() {
      }

      // $FF: synthetic method
      class_1122(Object var1) {
         this();
      }

      public int getChangingConfigurations() {
         return 0;
      }

      public Drawable newDrawable() {
         return class_329.class_1121.field_3494;
      }
   }

   static final class class_1231 extends ConstantState {
      // $FF: renamed from: FJ int
      int field_3496;
      // $FF: renamed from: FK int
      int field_3497;

      class_1231(class_329.class_1231 var1) {
         if(var1 != null) {
            this.field_3496 = var1.field_3496;
            this.field_3497 = var1.field_3497;
         }

      }

      public int getChangingConfigurations() {
         return this.field_3496;
      }

      public Drawable newDrawable() {
         return new class_329(this);
      }
   }
}
