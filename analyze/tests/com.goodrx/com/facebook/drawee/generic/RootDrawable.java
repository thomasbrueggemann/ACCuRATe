package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;

public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
   @Nullable
   @VisibleForTesting
   Drawable mControllerOverlay = null;
   @Nullable
   private VisibilityCallback mVisibilityCallback;

   public RootDrawable(Drawable var1) {
      super(var1);
   }

   @SuppressLint({"WrongCall"})
   public void draw(Canvas var1) {
      if(this.isVisible()) {
         if(this.mVisibilityCallback != null) {
            this.mVisibilityCallback.onDraw();
         }

         super.draw(var1);
         if(this.mControllerOverlay != null) {
            this.mControllerOverlay.setBounds(this.getBounds());
            this.mControllerOverlay.draw(var1);
            return;
         }
      }

   }

   public int getIntrinsicHeight() {
      return -1;
   }

   public int getIntrinsicWidth() {
      return -1;
   }

   public void setControllerOverlay(@Nullable Drawable var1) {
      this.mControllerOverlay = var1;
      this.invalidateSelf();
   }

   public void setVisibilityCallback(@Nullable VisibilityCallback var1) {
      this.mVisibilityCallback = var1;
   }

   public boolean setVisible(boolean var1, boolean var2) {
      if(this.mVisibilityCallback != null) {
         this.mVisibilityCallback.onVisibilityChange(var1);
      }

      return super.setVisible(var1, var2);
   }
}
