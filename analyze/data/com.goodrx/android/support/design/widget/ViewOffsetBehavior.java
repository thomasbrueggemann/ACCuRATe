package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.ViewOffsetHelper;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
   private int mTempLeftRightOffset = 0;
   private int mTempTopBottomOffset = 0;
   private ViewOffsetHelper mViewOffsetHelper;

   public ViewOffsetBehavior() {
   }

   public ViewOffsetBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public int getLeftAndRightOffset() {
      return this.mViewOffsetHelper != null?this.mViewOffsetHelper.getLeftAndRightOffset():0;
   }

   public int getTopAndBottomOffset() {
      return this.mViewOffsetHelper != null?this.mViewOffsetHelper.getTopAndBottomOffset():0;
   }

   protected void layoutChild(CoordinatorLayout var1, V var2, int var3) {
      var1.onLayoutChild(var2, var3);
   }

   public boolean onLayoutChild(CoordinatorLayout var1, V var2, int var3) {
      this.layoutChild(var1, var2, var3);
      if(this.mViewOffsetHelper == null) {
         this.mViewOffsetHelper = new ViewOffsetHelper(var2);
      }

      this.mViewOffsetHelper.onViewLayout();
      if(this.mTempTopBottomOffset != 0) {
         this.mViewOffsetHelper.setTopAndBottomOffset(this.mTempTopBottomOffset);
         this.mTempTopBottomOffset = 0;
      }

      if(this.mTempLeftRightOffset != 0) {
         this.mViewOffsetHelper.setLeftAndRightOffset(this.mTempLeftRightOffset);
         this.mTempLeftRightOffset = 0;
      }

      return true;
   }

   public boolean setLeftAndRightOffset(int var1) {
      if(this.mViewOffsetHelper != null) {
         return this.mViewOffsetHelper.setLeftAndRightOffset(var1);
      } else {
         this.mTempLeftRightOffset = var1;
         return false;
      }
   }

   public boolean setTopAndBottomOffset(int var1) {
      if(this.mViewOffsetHelper != null) {
         return this.mViewOffsetHelper.setTopAndBottomOffset(var1);
      } else {
         this.mTempTopBottomOffset = var1;
         return false;
      }
   }
}
