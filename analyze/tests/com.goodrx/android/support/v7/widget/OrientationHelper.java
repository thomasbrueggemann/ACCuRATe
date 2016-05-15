package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class OrientationHelper {
   public static final int HORIZONTAL = 0;
   private static final int INVALID_SIZE = Integer.MIN_VALUE;
   public static final int VERTICAL = 1;
   private int mLastTotalSpace;
   protected final RecyclerView.LayoutManager mLayoutManager;

   private OrientationHelper(RecyclerView.LayoutManager var1) {
      this.mLastTotalSpace = Integer.MIN_VALUE;
      this.mLayoutManager = var1;
   }

   // $FF: synthetic method
   OrientationHelper(RecyclerView.LayoutManager var1, Object var2) {
      this(var1);
   }

   public static OrientationHelper createHorizontalHelper(final RecyclerView.LayoutManager var0) {
      return new OrientationHelper(var0, null) {
         public int getDecoratedEnd(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedRight(var1) + var2.rightMargin;
         }

         public int getDecoratedMeasurement(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(var1) + var2.leftMargin + var2.rightMargin;
         }

         public int getDecoratedMeasurementInOther(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(var1) + var2.topMargin + var2.bottomMargin;
         }

         public int getDecoratedStart(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedLeft(var1) - var2.leftMargin;
         }

         public int getEnd() {
            return this.mLayoutManager.getWidth();
         }

         public int getEndAfterPadding() {
            return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
         }

         public int getEndPadding() {
            return this.mLayoutManager.getPaddingRight();
         }

         public int getMode() {
            return this.mLayoutManager.getWidthMode();
         }

         public int getModeInOther() {
            return this.mLayoutManager.getHeightMode();
         }

         public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingLeft();
         }

         public int getTotalSpace() {
            return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft() - this.mLayoutManager.getPaddingRight();
         }

         public void offsetChild(View var1, int var2) {
            var1.offsetLeftAndRight(var2);
         }

         public void offsetChildren(int var1) {
            this.mLayoutManager.offsetChildrenHorizontal(var1);
         }
      };
   }

   public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager var0, int var1) {
      switch(var1) {
      case 0:
         return createHorizontalHelper(var0);
      case 1:
         return createVerticalHelper(var0);
      default:
         throw new IllegalArgumentException("invalid orientation");
      }
   }

   public static OrientationHelper createVerticalHelper(final RecyclerView.LayoutManager var0) {
      return new OrientationHelper(var0, null) {
         public int getDecoratedEnd(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedBottom(var1) + var2.bottomMargin;
         }

         public int getDecoratedMeasurement(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(var1) + var2.topMargin + var2.bottomMargin;
         }

         public int getDecoratedMeasurementInOther(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(var1) + var2.leftMargin + var2.rightMargin;
         }

         public int getDecoratedStart(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.mLayoutManager.getDecoratedTop(var1) - var2.topMargin;
         }

         public int getEnd() {
            return this.mLayoutManager.getHeight();
         }

         public int getEndAfterPadding() {
            return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
         }

         public int getEndPadding() {
            return this.mLayoutManager.getPaddingBottom();
         }

         public int getMode() {
            return this.mLayoutManager.getHeightMode();
         }

         public int getModeInOther() {
            return this.mLayoutManager.getWidthMode();
         }

         public int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingTop();
         }

         public int getTotalSpace() {
            return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop() - this.mLayoutManager.getPaddingBottom();
         }

         public void offsetChild(View var1, int var2) {
            var1.offsetTopAndBottom(var2);
         }

         public void offsetChildren(int var1) {
            this.mLayoutManager.offsetChildrenVertical(var1);
         }
      };
   }

   public abstract int getDecoratedEnd(View var1);

   public abstract int getDecoratedMeasurement(View var1);

   public abstract int getDecoratedMeasurementInOther(View var1);

   public abstract int getDecoratedStart(View var1);

   public abstract int getEnd();

   public abstract int getEndAfterPadding();

   public abstract int getEndPadding();

   public abstract int getMode();

   public abstract int getModeInOther();

   public abstract int getStartAfterPadding();

   public abstract int getTotalSpace();

   public int getTotalSpaceChange() {
      return Integer.MIN_VALUE == this.mLastTotalSpace?0:this.getTotalSpace() - this.mLastTotalSpace;
   }

   public abstract void offsetChild(View var1, int var2);

   public abstract void offsetChildren(int var1);

   public void onLayoutComplete() {
      this.mLastTotalSpace = this.getTotalSpace();
   }
}
