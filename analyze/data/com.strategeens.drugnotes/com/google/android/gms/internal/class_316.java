package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.internal.class_712;

// $FF: renamed from: com.google.android.gms.internal.iz
public final class class_316 extends Drawable implements Callback {
   // $FF: renamed from: LO boolean
   private boolean field_765;
   // $FF: renamed from: LV int
   private int field_766;
   // $FF: renamed from: LW long
   private long field_767;
   // $FF: renamed from: LX int
   private int field_768;
   // $FF: renamed from: LY int
   private int field_769;
   // $FF: renamed from: LZ int
   private int field_770;
   // $FF: renamed from: Ma int
   private int field_771;
   // $FF: renamed from: Mb boolean
   private boolean field_772;
   // $FF: renamed from: Mc com.google.android.gms.internal.iz$b
   private class_316.class_1589 field_773;
   // $FF: renamed from: Md android.graphics.drawable.Drawable
   private Drawable field_774;
   // $FF: renamed from: Me android.graphics.drawable.Drawable
   private Drawable field_775;
   // $FF: renamed from: Mf boolean
   private boolean field_776;
   // $FF: renamed from: Mg boolean
   private boolean field_777;
   // $FF: renamed from: Mh boolean
   private boolean field_778;
   // $FF: renamed from: Mi int
   private int field_779;
   private int mFrom;

   public class_316(Drawable var1, Drawable var2) {
      this((class_316.class_1589)null);
      if(var1 == null) {
         var1 = class_316.class_1370.field_4177;
      }

      this.field_774 = (Drawable)var1;
      ((Drawable)var1).setCallback(this);
      class_316.class_1589 var3 = this.field_773;
      var3.field_4176 |= ((Drawable)var1).getChangingConfigurations();
      if(var2 == null) {
         var2 = class_316.class_1370.field_4177;
      }

      this.field_775 = (Drawable)var2;
      ((Drawable)var2).setCallback(this);
      class_316.class_1589 var4 = this.field_773;
      var4.field_4176 |= ((Drawable)var2).getChangingConfigurations();
   }

   class_316(class_316.class_1589 var1) {
      this.field_766 = 0;
      this.field_769 = 255;
      this.field_771 = 0;
      this.field_765 = true;
      this.field_773 = new class_316.class_1589(var1);
   }

   public boolean canConstantState() {
      if(!this.field_776) {
         boolean var1;
         if(this.field_774.getConstantState() != null && this.field_775.getConstantState() != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.field_777 = var1;
         this.field_776 = true;
      }

      return this.field_777;
   }

   public void draw(Canvas var1) {
      boolean var2 = true;
      boolean var5;
      switch(this.field_766) {
      case 1:
         this.field_767 = SystemClock.uptimeMillis();
         this.field_766 = 2;
         var5 = false;
         break;
      case 2:
         if(this.field_767 >= 0L) {
            float var3 = (float)(SystemClock.uptimeMillis() - this.field_767) / (float)this.field_770;
            if(var3 < 1.0F) {
               var2 = false;
            }

            if(var2) {
               this.field_766 = 0;
            }

            float var4 = Math.min(var3, 1.0F);
            this.field_771 = (int)((float)this.mFrom + var4 * (float)(this.field_768 - this.mFrom));
         }
      default:
         var5 = var2;
      }

      int var6 = this.field_771;
      boolean var7 = this.field_765;
      Drawable var8 = this.field_774;
      Drawable var9 = this.field_775;
      if(!var5) {
         if(var7) {
            var8.setAlpha(this.field_769 - var6);
         }

         var8.draw(var1);
         if(var7) {
            var8.setAlpha(this.field_769);
         }

         if(var6 > 0) {
            var9.setAlpha(var6);
            var9.draw(var1);
            var9.setAlpha(this.field_769);
         }

         this.invalidateSelf();
      } else {
         if(!var7 || var6 == 0) {
            var8.draw(var1);
         }

         if(var6 == this.field_769) {
            var9.setAlpha(this.field_769);
            var9.draw(var1);
         }

      }
   }

   public int getChangingConfigurations() {
      return super.getChangingConfigurations() | this.field_773.field_4175 | this.field_773.field_4176;
   }

   public ConstantState getConstantState() {
      if(this.canConstantState()) {
         this.field_773.field_4175 = this.getChangingConfigurations();
         return this.field_773;
      } else {
         return null;
      }
   }

   public int getIntrinsicHeight() {
      return Math.max(this.field_774.getIntrinsicHeight(), this.field_775.getIntrinsicHeight());
   }

   public int getIntrinsicWidth() {
      return Math.max(this.field_774.getIntrinsicWidth(), this.field_775.getIntrinsicWidth());
   }

   public int getOpacity() {
      if(!this.field_778) {
         this.field_779 = Drawable.resolveOpacity(this.field_774.getOpacity(), this.field_775.getOpacity());
         this.field_778 = true;
      }

      return this.field_779;
   }

   // $FF: renamed from: hh () android.graphics.drawable.Drawable
   public Drawable method_2214() {
      return this.field_775;
   }

   public void invalidateDrawable(Drawable var1) {
      if(class_712.method_4177()) {
         Callback var2 = this.getCallback();
         if(var2 != null) {
            var2.invalidateDrawable(this);
         }
      }

   }

   public Drawable mutate() {
      if(!this.field_772 && super.mutate() == this) {
         if(!this.canConstantState()) {
            throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
         }

         this.field_774.mutate();
         this.field_775.mutate();
         this.field_772 = true;
      }

      return this;
   }

   protected void onBoundsChange(Rect var1) {
      this.field_774.setBounds(var1);
      this.field_775.setBounds(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      if(class_712.method_4177()) {
         Callback var5 = this.getCallback();
         if(var5 != null) {
            var5.scheduleDrawable(this, var2, var3);
         }
      }

   }

   public void setAlpha(int var1) {
      if(this.field_771 == this.field_769) {
         this.field_771 = var1;
      }

      this.field_769 = var1;
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.field_774.setColorFilter(var1);
      this.field_775.setColorFilter(var1);
   }

   public void startTransition(int var1) {
      this.mFrom = 0;
      this.field_768 = this.field_769;
      this.field_771 = 0;
      this.field_770 = var1;
      this.field_766 = 1;
      this.invalidateSelf();
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      if(class_712.method_4177()) {
         Callback var3 = this.getCallback();
         if(var3 != null) {
            var3.unscheduleDrawable(this, var2);
         }
      }

   }

   private static final class class_1370 extends Drawable {
      // $FF: renamed from: Mj com.google.android.gms.internal.iz$a
      private static final class_316.class_1370 field_4177 = new class_316.class_1370();
      // $FF: renamed from: Mk com.google.android.gms.internal.iz$a$a
      private static final class_316.class_1371 field_4178 = new class_316.class_1371();

      public void draw(Canvas var1) {
      }

      public ConstantState getConstantState() {
         return field_4178;
      }

      public int getOpacity() {
         return -2;
      }

      public void setAlpha(int var1) {
      }

      public void setColorFilter(ColorFilter var1) {
      }
   }

   private static final class class_1371 extends ConstantState {
      private class_1371() {
      }

      // $FF: synthetic method
      class_1371(Object var1) {
         this();
      }

      public int getChangingConfigurations() {
         return 0;
      }

      public Drawable newDrawable() {
         return class_316.class_1370.field_4177;
      }
   }

   static final class class_1589 extends ConstantState {
      // $FF: renamed from: Ml int
      int field_4175;
      // $FF: renamed from: Mm int
      int field_4176;

      class_1589(class_316.class_1589 var1) {
         if(var1 != null) {
            this.field_4175 = var1.field_4175;
            this.field_4176 = var1.field_4176;
         }

      }

      public int getChangingConfigurations() {
         return this.field_4175;
      }

      public Drawable newDrawable() {
         return new class_316(this);
      }
   }
}
