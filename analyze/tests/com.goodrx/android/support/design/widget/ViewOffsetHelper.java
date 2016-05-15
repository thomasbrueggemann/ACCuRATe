package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewParent;

class ViewOffsetHelper {
   private int mLayoutLeft;
   private int mLayoutTop;
   private int mOffsetLeft;
   private int mOffsetTop;
   private final View mView;

   public ViewOffsetHelper(View var1) {
      this.mView = var1;
   }

   private static void tickleInvalidationFlag(View var0) {
      float var1 = ViewCompat.getTranslationY(var0);
      ViewCompat.setTranslationY(var0, 1.0F + var1);
      ViewCompat.setTranslationY(var0, var1);
   }

   private void updateOffsets() {
      ViewCompat.offsetTopAndBottom(this.mView, this.mOffsetTop - (this.mView.getTop() - this.mLayoutTop));
      ViewCompat.offsetLeftAndRight(this.mView, this.mOffsetLeft - (this.mView.getLeft() - this.mLayoutLeft));
      if(VERSION.SDK_INT < 23) {
         tickleInvalidationFlag(this.mView);
         ViewParent var1 = this.mView.getParent();
         if(var1 instanceof View) {
            tickleInvalidationFlag((View)var1);
         }
      }

   }

   public int getLeftAndRightOffset() {
      return this.mOffsetLeft;
   }

   public int getTopAndBottomOffset() {
      return this.mOffsetTop;
   }

   public void onViewLayout() {
      this.mLayoutTop = this.mView.getTop();
      this.mLayoutLeft = this.mView.getLeft();
      this.updateOffsets();
   }

   public boolean setLeftAndRightOffset(int var1) {
      if(this.mOffsetLeft != var1) {
         this.mOffsetLeft = var1;
         this.updateOffsets();
         return true;
      } else {
         return false;
      }
   }

   public boolean setTopAndBottomOffset(int var1) {
      if(this.mOffsetTop != var1) {
         this.mOffsetTop = var1;
         this.updateOffsets();
         return true;
      } else {
         return false;
      }
   }
}
