package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.design.class_5;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout extends LinearLayoutCompat {
   private Drawable mForeground;
   boolean mForegroundBoundsChanged;
   private int mForegroundGravity;
   protected boolean mForegroundInPadding;
   private final Rect mOverlayBounds;
   private final Rect mSelfBounds;

   public ForegroundLinearLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ForegroundLinearLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ForegroundLinearLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mSelfBounds = new Rect();
      this.mOverlayBounds = new Rect();
      this.mForegroundGravity = 119;
      this.mForegroundInPadding = true;
      this.mForegroundBoundsChanged = false;
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_5.styleable.ForegroundLinearLayout, var3, 0);
      this.mForegroundGravity = var4.getInt(class_5.styleable.ForegroundLinearLayout_android_foregroundGravity, this.mForegroundGravity);
      Drawable var5 = var4.getDrawable(class_5.styleable.ForegroundLinearLayout_android_foreground);
      if(var5 != null) {
         this.setForeground(var5);
      }

      this.mForegroundInPadding = var4.getBoolean(class_5.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
      var4.recycle();
   }

   public void draw(@NonNull Canvas var1) {
      super.draw(var1);
      if(this.mForeground != null) {
         Drawable var2 = this.mForeground;
         if(this.mForegroundBoundsChanged) {
            this.mForegroundBoundsChanged = false;
            Rect var3 = this.mSelfBounds;
            Rect var4 = this.mOverlayBounds;
            int var5 = this.getRight() - this.getLeft();
            int var6 = this.getBottom() - this.getTop();
            if(this.mForegroundInPadding) {
               var3.set(0, 0, var5, var6);
            } else {
               var3.set(this.getPaddingLeft(), this.getPaddingTop(), var5 - this.getPaddingRight(), var6 - this.getPaddingBottom());
            }

            Gravity.apply(this.mForegroundGravity, var2.getIntrinsicWidth(), var2.getIntrinsicHeight(), var3, var4);
            var2.setBounds(var4);
         }

         var2.draw(var1);
      }

   }

   public void drawableHotspotChanged(float var1, float var2) {
      super.drawableHotspotChanged(var1, var2);
      if(this.mForeground != null) {
         this.mForeground.setHotspot(var1, var2);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mForeground != null && this.mForeground.isStateful()) {
         this.mForeground.setState(this.getDrawableState());
      }

   }

   public Drawable getForeground() {
      return this.mForeground;
   }

   public int getForegroundGravity() {
      return this.mForegroundGravity;
   }

   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      if(this.mForeground != null) {
         this.mForeground.jumpToCurrentState();
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.mForegroundBoundsChanged |= var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.mForegroundBoundsChanged = true;
   }

   public void setForeground(Drawable var1) {
      if(this.mForeground != var1) {
         if(this.mForeground != null) {
            this.mForeground.setCallback((Callback)null);
            this.unscheduleDrawable(this.mForeground);
         }

         this.mForeground = var1;
         if(var1 != null) {
            this.setWillNotDraw(false);
            var1.setCallback(this);
            if(var1.isStateful()) {
               var1.setState(this.getDrawableState());
            }

            if(this.mForegroundGravity == 119) {
               var1.getPadding(new Rect());
            }
         } else {
            this.setWillNotDraw(true);
         }

         this.requestLayout();
         this.invalidate();
      }

   }

   public void setForegroundGravity(int var1) {
      if(this.mForegroundGravity != var1) {
         if((8388615 & var1) == 0) {
            var1 |= 8388611;
         }

         if((var1 & 112) == 0) {
            var1 |= 48;
         }

         this.mForegroundGravity = var1;
         if(this.mForegroundGravity == 119 && this.mForeground != null) {
            Rect var2 = new Rect();
            this.mForeground.getPadding(var2);
         }

         this.requestLayout();
      }

   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mForeground;
   }
}
