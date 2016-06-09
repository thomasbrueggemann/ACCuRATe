package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.MathUtils;
import android.support.design.widget.ViewOffsetBehavior;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
   private int mOverlayTop;
   private final Rect mTempRect1 = new Rect();
   private final Rect mTempRect2 = new Rect();
   private int mVerticalLayoutGap = 0;

   public HeaderScrollingViewBehavior() {
   }

   public HeaderScrollingViewBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private static int resolveGravity(int var0) {
      if(var0 == 0) {
         var0 = 8388659;
      }

      return var0;
   }

   abstract View findFirstDependency(List<View> var1);

   final int getOverlapPixelsForOffset(View var1) {
      return this.mOverlayTop == 0?0:MathUtils.constrain(Math.round(this.getOverlapRatioForOffset(var1) * (float)this.mOverlayTop), 0, this.mOverlayTop);
   }

   float getOverlapRatioForOffset(View var1) {
      return 1.0F;
   }

   public final int getOverlayTop() {
      return this.mOverlayTop;
   }

   int getScrollRange(View var1) {
      return var1.getMeasuredHeight();
   }

   final int getVerticalLayoutGap() {
      return this.mVerticalLayoutGap;
   }

   protected void layoutChild(CoordinatorLayout var1, View var2, int var3) {
      View var4 = this.findFirstDependency(var1.getDependencies(var2));
      if(var4 != null) {
         CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
         Rect var6 = this.mTempRect1;
         var6.set(var1.getPaddingLeft() + var5.leftMargin, var4.getBottom() + var5.topMargin, var1.getWidth() - var1.getPaddingRight() - var5.rightMargin, var1.getHeight() + var4.getBottom() - var1.getPaddingBottom() - var5.bottomMargin);
         Rect var7 = this.mTempRect2;
         GravityCompat.apply(resolveGravity(var5.gravity), var2.getMeasuredWidth(), var2.getMeasuredHeight(), var6, var7, var3);
         int var8 = this.getOverlapPixelsForOffset(var4);
         var2.layout(var7.left, var7.top - var8, var7.right, var7.bottom - var8);
         this.mVerticalLayoutGap = var7.top - var4.getBottom();
      } else {
         super.layoutChild(var1, var2, var3);
         this.mVerticalLayoutGap = 0;
      }
   }

   public boolean onMeasureChild(CoordinatorLayout var1, View var2, int var3, int var4, int var5, int var6) {
      int var7 = var2.getLayoutParams().height;
      if(var7 == -1 || var7 == -2) {
         View var8 = this.findFirstDependency(var1.getDependencies(var2));
         if(var8 != null) {
            if(ViewCompat.getFitsSystemWindows(var8) && !ViewCompat.getFitsSystemWindows(var2)) {
               ViewCompat.setFitsSystemWindows(var2, true);
               if(ViewCompat.getFitsSystemWindows(var2)) {
                  var2.requestLayout();
                  return true;
               }
            }

            if(ViewCompat.isLaidOut(var8)) {
               int var9 = MeasureSpec.getSize(var5);
               if(var9 == 0) {
                  var9 = var1.getHeight();
               }

               int var10 = var9 - var8.getMeasuredHeight() + this.getScrollRange(var8);
               int var11;
               if(var7 == -1) {
                  var11 = 1073741824;
               } else {
                  var11 = Integer.MIN_VALUE;
               }

               var1.onMeasureChild(var2, var3, var4, MeasureSpec.makeMeasureSpec(var10, var11), var6);
               return true;
            }
         }
      }

      return false;
   }

   public final void setOverlayTop(int var1) {
      this.mOverlayTop = var1;
   }
}
