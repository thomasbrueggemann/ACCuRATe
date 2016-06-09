package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import javax.annotation.Nullable;

public class ArrayDrawable extends Drawable implements Callback, TransformAwareDrawable, TransformCallback {
   private final DrawableParent[] mDrawableParents;
   private final DrawableProperties mDrawableProperties = new DrawableProperties();
   private boolean mIsMutated = false;
   private boolean mIsStateful = false;
   private boolean mIsStatefulCalculated = false;
   private final Drawable[] mLayers;
   private final Rect mTmpRect = new Rect();
   private TransformCallback mTransformCallback;

   public ArrayDrawable(Drawable[] var1) {
      Preconditions.checkNotNull(var1);
      this.mLayers = var1;

      for(int var3 = 0; var3 < this.mLayers.length; ++var3) {
         DrawableUtils.setCallbacks(this.mLayers[var3], this, this);
      }

      this.mDrawableParents = new DrawableParent[this.mLayers.length];
   }

   private DrawableParent createDrawableParentForIndex(final int var1) {
      return new DrawableParent() {
         public Drawable getDrawable() {
            return ArrayDrawable.this.getDrawable(var1);
         }

         public Drawable setDrawable(Drawable var1x) {
            return ArrayDrawable.this.setDrawable(var1, var1x);
         }
      };
   }

   public void draw(Canvas var1) {
      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var3.draw(var1);
         }
      }

   }

   @Nullable
   public Drawable getDrawable(int var1) {
      boolean var2 = true;
      boolean var3;
      if(var1 >= 0) {
         var3 = var2;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      if(var1 >= this.mLayers.length) {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      return this.mLayers[var1];
   }

   public DrawableParent getDrawableParentForIndex(int var1) {
      boolean var2 = true;
      boolean var3;
      if(var1 >= 0) {
         var3 = var2;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      if(var1 >= this.mDrawableParents.length) {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      if(this.mDrawableParents[var1] == null) {
         this.mDrawableParents[var1] = this.createDrawableParentForIndex(var1);
      }

      return this.mDrawableParents[var1];
   }

   public int getIntrinsicHeight() {
      int var1 = -1;

      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var1 = Math.max(var1, var3.getIntrinsicHeight());
         }
      }

      if(var1 > 0) {
         return var1;
      } else {
         return -1;
      }
   }

   public int getIntrinsicWidth() {
      int var1 = -1;

      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var1 = Math.max(var1, var3.getIntrinsicWidth());
         }
      }

      if(var1 > 0) {
         return var1;
      } else {
         return -1;
      }
   }

   public int getNumberOfLayers() {
      return this.mLayers.length;
   }

   public int getOpacity() {
      int var1;
      if(this.mLayers.length == 0) {
         var1 = -2;
      } else {
         var1 = -1;

         for(int var2 = 1; var2 < this.mLayers.length; ++var2) {
            Drawable var3 = this.mLayers[var2];
            if(var3 != null) {
               var1 = Drawable.resolveOpacity(var1, var3.getOpacity());
            }
         }
      }

      return var1;
   }

   public boolean getPadding(Rect var1) {
      var1.left = 0;
      var1.top = 0;
      var1.right = 0;
      var1.bottom = 0;
      Rect var2 = this.mTmpRect;

      for(int var3 = 0; var3 < this.mLayers.length; ++var3) {
         Drawable var4 = this.mLayers[var3];
         if(var4 != null) {
            var4.getPadding(var2);
            var1.left = Math.max(var1.left, var2.left);
            var1.top = Math.max(var1.top, var2.top);
            var1.right = Math.max(var1.right, var2.right);
            var1.bottom = Math.max(var1.bottom, var2.bottom);
         }
      }

      return true;
   }

   public void getRootBounds(RectF var1) {
      if(this.mTransformCallback != null) {
         this.mTransformCallback.getRootBounds(var1);
      } else {
         var1.set(this.getBounds());
      }
   }

   public void getTransform(Matrix var1) {
      if(this.mTransformCallback != null) {
         this.mTransformCallback.getTransform(var1);
      } else {
         var1.reset();
      }
   }

   public void invalidateDrawable(Drawable var1) {
      this.invalidateSelf();
   }

   public boolean isStateful() {
      if(!this.mIsStatefulCalculated) {
         this.mIsStateful = false;

         for(int var1 = 0; var1 < this.mLayers.length; ++var1) {
            Drawable var2 = this.mLayers[var1];
            boolean var3 = this.mIsStateful;
            boolean var4;
            if(var2 != null && var2.isStateful()) {
               var4 = true;
            } else {
               var4 = false;
            }

            this.mIsStateful = var4 | var3;
         }

         this.mIsStatefulCalculated = true;
      }

      return this.mIsStateful;
   }

   public Drawable mutate() {
      for(int var1 = 0; var1 < this.mLayers.length; ++var1) {
         Drawable var2 = this.mLayers[var1];
         if(var2 != null) {
            var2.mutate();
         }
      }

      this.mIsMutated = true;
      return this;
   }

   protected void onBoundsChange(Rect var1) {
      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var3.setBounds(var1);
         }
      }

   }

   protected boolean onLevelChange(int var1) {
      boolean var2 = false;

      for(int var3 = 0; var3 < this.mLayers.length; ++var3) {
         Drawable var4 = this.mLayers[var3];
         if(var4 != null && var4.setLevel(var1)) {
            var2 = true;
         }
      }

      return var2;
   }

   protected boolean onStateChange(int[] var1) {
      boolean var2 = false;

      for(int var3 = 0; var3 < this.mLayers.length; ++var3) {
         Drawable var4 = this.mLayers[var3];
         if(var4 != null && var4.setState(var1)) {
            var2 = true;
         }
      }

      return var2;
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      this.scheduleSelf(var2, var3);
   }

   public void setAlpha(int var1) {
      this.mDrawableProperties.setAlpha(var1);

      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var3.setAlpha(var1);
         }
      }

   }

   public void setColorFilter(ColorFilter var1) {
      this.mDrawableProperties.setColorFilter(var1);

      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var3.setColorFilter(var1);
         }
      }

   }

   public void setDither(boolean var1) {
      this.mDrawableProperties.setDither(var1);

      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var3.setDither(var1);
         }
      }

   }

   @Nullable
   public Drawable setDrawable(int var1, @Nullable Drawable var2) {
      boolean var3 = true;
      boolean var4;
      if(var1 >= 0) {
         var4 = var3;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      if(var1 >= this.mLayers.length) {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      Drawable var5 = this.mLayers[var1];
      if(var2 != var5) {
         if(var2 != null && this.mIsMutated) {
            var2.mutate();
         }

         DrawableUtils.setCallbacks(this.mLayers[var1], (Callback)null, (TransformCallback)null);
         DrawableUtils.setCallbacks(var2, (Callback)null, (TransformCallback)null);
         DrawableUtils.setDrawableProperties(var2, this.mDrawableProperties);
         if(var2 != null) {
            var2.setBounds(this.getBounds());
            var2.setLevel(this.getLevel());
            var2.setState(this.getState());
            var2.setVisible(this.isVisible(), false);
         }

         DrawableUtils.setCallbacks(var2, this, this);
         this.mIsStatefulCalculated = false;
         this.mLayers[var1] = var2;
         this.invalidateSelf();
      }

      return var5;
   }

   public void setFilterBitmap(boolean var1) {
      this.mDrawableProperties.setFilterBitmap(var1);

      for(int var2 = 0; var2 < this.mLayers.length; ++var2) {
         Drawable var3 = this.mLayers[var2];
         if(var3 != null) {
            var3.setFilterBitmap(var1);
         }
      }

   }

   public void setTransformCallback(TransformCallback var1) {
      this.mTransformCallback = var1;
   }

   public boolean setVisible(boolean var1, boolean var2) {
      boolean var3 = super.setVisible(var1, var2);

      for(int var4 = 0; var4 < this.mLayers.length; ++var4) {
         Drawable var5 = this.mLayers[var4];
         if(var5 != null) {
            var5.setVisible(var1, var2);
         }
      }

      return var3;
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      this.unscheduleSelf(var2);
   }
}
