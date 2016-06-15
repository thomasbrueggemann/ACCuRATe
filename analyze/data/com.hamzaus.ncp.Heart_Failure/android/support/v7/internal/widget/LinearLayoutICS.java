package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.class_639;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LinearLayoutICS extends LinearLayout {
   private static final int SHOW_DIVIDER_BEGINNING = 1;
   private static final int SHOW_DIVIDER_END = 4;
   private static final int SHOW_DIVIDER_MIDDLE = 2;
   private static final int SHOW_DIVIDER_NONE;
   private final Drawable mDivider;
   private final int mDividerHeight;
   private final int mDividerPadding;
   private final int mDividerWidth;
   private final int mShowDividers;

   public LinearLayoutICS(Context var1, AttributeSet var2) {
      byte var3 = 1;
      super(var1, var2);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_639.styleable.LinearLayoutICS);
      this.mDivider = var4.getDrawable(0);
      if(this.mDivider != null) {
         this.mDividerWidth = this.mDivider.getIntrinsicWidth();
         this.mDividerHeight = this.mDivider.getIntrinsicHeight();
      } else {
         this.mDividerWidth = 0;
         this.mDividerHeight = 0;
      }

      this.mShowDividers = var4.getInt(var3, 0);
      this.mDividerPadding = var4.getDimensionPixelSize(2, 0);
      var4.recycle();
      if(this.mDivider != null) {
         var3 = 0;
      }

      this.setWillNotDraw((boolean)var3);
   }

   void drawSupportDividersHorizontal(Canvas var1) {
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         View var6 = this.getChildAt(var3);
         if(var6 != null && var6.getVisibility() != 8 && this.hasSupportDividerBeforeChildAt(var3)) {
            LayoutParams var7 = (LayoutParams)var6.getLayoutParams();
            this.drawSupportVerticalDivider(var1, var6.getLeft() - var7.leftMargin);
         }
      }

      if(this.hasSupportDividerBeforeChildAt(var2)) {
         View var4 = this.getChildAt(var2 - 1);
         int var5;
         if(var4 == null) {
            var5 = this.getWidth() - this.getPaddingRight() - this.mDividerWidth;
         } else {
            var5 = var4.getRight();
         }

         this.drawSupportVerticalDivider(var1, var5);
      }

   }

   void drawSupportDividersVertical(Canvas var1) {
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         View var6 = this.getChildAt(var3);
         if(var6 != null && var6.getVisibility() != 8 && this.hasSupportDividerBeforeChildAt(var3)) {
            LayoutParams var7 = (LayoutParams)var6.getLayoutParams();
            this.drawSupportHorizontalDivider(var1, var6.getTop() - var7.topMargin);
         }
      }

      if(this.hasSupportDividerBeforeChildAt(var2)) {
         View var4 = this.getChildAt(var2 - 1);
         int var5;
         if(var4 == null) {
            var5 = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
         } else {
            var5 = var4.getBottom();
         }

         this.drawSupportHorizontalDivider(var1, var5);
      }

   }

   void drawSupportHorizontalDivider(Canvas var1, int var2) {
      this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, var2, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, var2 + this.mDividerHeight);
      this.mDivider.draw(var1);
   }

   void drawSupportVerticalDivider(Canvas var1, int var2) {
      this.mDivider.setBounds(var2, this.getPaddingTop() + this.mDividerPadding, var2 + this.mDividerWidth, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
      this.mDivider.draw(var1);
   }

   public int getSupportDividerWidth() {
      return this.mDividerWidth;
   }

   protected boolean hasSupportDividerBeforeChildAt(int var1) {
      if(var1 == 0) {
         if((1 & this.mShowDividers) == 0) {
            return false;
         }
      } else {
         if(var1 != this.getChildCount()) {
            if((2 & this.mShowDividers) == 0) {
               return false;
            }

            int var2 = var1 - 1;

            boolean var3;
            while(true) {
               var3 = false;
               if(var2 < 0) {
                  break;
               }

               if(this.getChildAt(var2).getVisibility() != 8) {
                  var3 = true;
                  break;
               }

               --var2;
            }

            return var3;
         }

         if((4 & this.mShowDividers) == 0) {
            return false;
         }
      }

      return true;
   }

   protected void measureChildWithMargins(View var1, int var2, int var3, int var4, int var5) {
      if(this.mDivider != null) {
         int var6 = this.indexOfChild(var1);
         int var7 = this.getChildCount();
         LayoutParams var8 = (LayoutParams)var1.getLayoutParams();
         if(this.getOrientation() == 1) {
            if(this.hasSupportDividerBeforeChildAt(var6)) {
               var8.topMargin = this.mDividerHeight;
            } else if(var6 == var7 - 1 && this.hasSupportDividerBeforeChildAt(var7)) {
               var8.bottomMargin = this.mDividerHeight;
            }
         } else if(this.hasSupportDividerBeforeChildAt(var6)) {
            var8.leftMargin = this.mDividerWidth;
         } else if(var6 == var7 - 1 && this.hasSupportDividerBeforeChildAt(var7)) {
            var8.rightMargin = this.mDividerWidth;
         }
      }

      super.measureChildWithMargins(var1, var2, var3, var4, var5);
   }

   protected void onDraw(Canvas var1) {
      if(this.mDivider != null) {
         if(this.getOrientation() == 1) {
            this.drawSupportDividersVertical(var1);
         } else {
            this.drawSupportDividersHorizontal(var1);
         }
      }
   }
}
