package com.peirr.blooadapp.wizard.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class StepPagerStrip extends View {
   private static final int[] ATTRS = new int[]{16842927};
   private int mCurrentPage;
   private int mGravity;
   private Paint mNextTabPaint;
   private StepPagerStrip.OnPageSelectedListener mOnPageSelectedListener;
   private int mPageCount;
   private Paint mPrevTabPaint;
   private Paint mSelectedLastTabPaint;
   private Paint mSelectedTabPaint;
   private float mTabHeight;
   private float mTabSpacing;
   private float mTabWidth;
   private RectF mTempRectF;

   public StepPagerStrip(Context var1) {
      this(var1, (AttributeSet)null, 0);
   }

   public StepPagerStrip(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public StepPagerStrip(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mGravity = 51;
      this.mTempRectF = new RectF();
      TypedArray var4 = var1.obtainStyledAttributes(var2, ATTRS);
      this.mGravity = var4.getInteger(0, this.mGravity);
      var4.recycle();
      Resources var5 = this.getResources();
      this.mTabWidth = (float)var5.getDimensionPixelSize(2131165188);
      this.mTabHeight = (float)var5.getDimensionPixelSize(2131165186);
      this.mTabSpacing = (float)var5.getDimensionPixelSize(2131165187);
      this.mPrevTabPaint = new Paint();
      this.mPrevTabPaint.setColor(var5.getColor(2131099652));
      this.mSelectedTabPaint = new Paint();
      this.mSelectedTabPaint.setColor(var5.getColor(2131099654));
      this.mSelectedLastTabPaint = new Paint();
      this.mSelectedLastTabPaint.setColor(var5.getColor(2131099653));
      this.mNextTabPaint = new Paint();
      this.mNextTabPaint.setColor(var5.getColor(2131099651));
   }

   private int hitTest(float var1) {
      if(this.mPageCount != 0) {
         float var2 = (float)this.mPageCount * (this.mTabWidth + this.mTabSpacing) - this.mTabSpacing;
         boolean var3 = false;
         float var4;
         switch(7 & this.mGravity) {
         case 1:
            var4 = ((float)this.getWidth() - var2) / 2.0F;
            var3 = false;
            break;
         case 5:
            var4 = (float)(this.getWidth() - this.getPaddingRight()) - var2;
            var3 = false;
            break;
         case 7:
            var4 = (float)this.getPaddingLeft();
            var3 = true;
            break;
         default:
            var4 = (float)this.getPaddingLeft();
         }

         float var5 = this.mTabWidth;
         if(var3) {
            var5 = ((float)(this.getWidth() - this.getPaddingRight() - this.getPaddingLeft()) - (float)(-1 + this.mPageCount) * this.mTabSpacing) / (float)this.mPageCount;
         }

         float var6 = var4 + (float)this.mPageCount * (var5 + this.mTabSpacing);
         if(var1 >= var4 && var1 <= var6 && var6 > var4) {
            return (int)((var1 - var4) / (var6 - var4) * (float)this.mPageCount);
         }
      }

      return -1;
   }

   private void scrollCurrentPageIntoView() {
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mPageCount != 0) {
         float var2 = (float)this.mPageCount * (this.mTabWidth + this.mTabSpacing) - this.mTabSpacing;
         boolean var3 = false;
         float var4;
         switch(7 & this.mGravity) {
         case 1:
            var4 = ((float)this.getWidth() - var2) / 2.0F;
            var3 = false;
            break;
         case 5:
            var4 = (float)(this.getWidth() - this.getPaddingRight()) - var2;
            var3 = false;
            break;
         case 7:
            var4 = (float)this.getPaddingLeft();
            var3 = true;
            break;
         default:
            var4 = (float)this.getPaddingLeft();
         }

         switch(112 & this.mGravity) {
         case 16:
            this.mTempRectF.top = (float)((int)((float)this.getHeight() - this.mTabHeight) / 2);
            break;
         case 80:
            this.mTempRectF.top = (float)(this.getHeight() - this.getPaddingBottom()) - this.mTabHeight;
            break;
         default:
            this.mTempRectF.top = (float)this.getPaddingTop();
         }

         this.mTempRectF.bottom = this.mTempRectF.top + this.mTabHeight;
         float var5 = this.mTabWidth;
         if(var3) {
            var5 = ((float)(this.getWidth() - this.getPaddingRight() - this.getPaddingLeft()) - (float)(-1 + this.mPageCount) * this.mTabSpacing) / (float)this.mPageCount;
         }

         for(int var6 = 0; var6 < this.mPageCount; ++var6) {
            this.mTempRectF.left = var4 + (float)var6 * (var5 + this.mTabSpacing);
            this.mTempRectF.right = var5 + this.mTempRectF.left;
            RectF var7 = this.mTempRectF;
            Paint var8;
            if(var6 < this.mCurrentPage) {
               var8 = this.mPrevTabPaint;
            } else if(var6 > this.mCurrentPage) {
               var8 = this.mNextTabPaint;
            } else if(var6 == -1 + this.mPageCount) {
               var8 = this.mSelectedLastTabPaint;
            } else {
               var8 = this.mSelectedTabPaint;
            }

            var1.drawRect(var7, var8);
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(View.resolveSize((int)((float)this.mPageCount * (this.mTabWidth + this.mTabSpacing) - this.mTabSpacing) + this.getPaddingLeft() + this.getPaddingRight(), var1), View.resolveSize((int)this.mTabHeight + this.getPaddingTop() + this.getPaddingBottom(), var2));
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.scrollCurrentPageIntoView();
      super.onSizeChanged(var1, var2, var3, var4);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(this.mOnPageSelectedListener != null) {
         switch(var1.getActionMasked()) {
         case 0:
         case 2:
            int var2 = this.hitTest(var1.getX());
            if(var2 >= 0) {
               this.mOnPageSelectedListener.onPageStripSelected(var2);
            }

            return true;
         case 1:
         }
      }

      return super.onTouchEvent(var1);
   }

   public void setCurrentPage(int var1) {
      this.mCurrentPage = var1;
      this.invalidate();
      this.scrollCurrentPageIntoView();
   }

   public void setOnPageSelectedListener(StepPagerStrip.OnPageSelectedListener var1) {
      this.mOnPageSelectedListener = var1;
   }

   public void setPageCount(int var1) {
      this.mPageCount = var1;
      this.invalidate();
   }

   public interface OnPageSelectedListener {
      void onPageStripSelected(int var1);
   }
}
