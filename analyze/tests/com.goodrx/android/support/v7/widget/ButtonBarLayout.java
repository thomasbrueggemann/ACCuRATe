package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.class_22;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class ButtonBarLayout extends LinearLayout {
   private boolean mAllowStacking;
   private int mLastWidthSize = -1;

   public ButtonBarLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_22.styleable.ButtonBarLayout);
      this.mAllowStacking = var3.getBoolean(class_22.styleable.ButtonBarLayout_allowStacking, false);
      var3.recycle();
   }

   private boolean isStacked() {
      return this.getOrientation() == 1;
   }

   private void setStacked(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.setOrientation(var2);
      byte var3;
      if(var1) {
         var3 = 5;
      } else {
         var3 = 80;
      }

      this.setGravity(var3);
      View var4 = this.findViewById(class_22.class_93.spacer);
      if(var4 != null) {
         byte var6;
         if(var1) {
            var6 = 8;
         } else {
            var6 = 4;
         }

         var4.setVisibility(var6);
      }

      for(int var5 = -2 + this.getChildCount(); var5 >= 0; --var5) {
         this.bringChildToFront(this.getChildAt(var5));
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getSize(var1);
      if(this.mAllowStacking) {
         if(var3 > this.mLastWidthSize && this.isStacked()) {
            this.setStacked(false);
         }

         this.mLastWidthSize = var3;
      }

      int var4;
      boolean var5;
      if(!this.isStacked() && MeasureSpec.getMode(var1) == 1073741824) {
         var4 = MeasureSpec.makeMeasureSpec(var3, Integer.MIN_VALUE);
         var5 = true;
      } else {
         var4 = var1;
         var5 = false;
      }

      super.onMeasure(var4, var2);
      if(this.mAllowStacking && !this.isStacked()) {
         boolean var10;
         if(VERSION.SDK_INT >= 11) {
            int var11 = -16777216 & ViewCompat.getMeasuredWidthAndState(this);
            var10 = false;
            if(var11 == 16777216) {
               var10 = true;
            }
         } else {
            int var6 = 0;
            int var7 = 0;

            for(int var8 = this.getChildCount(); var7 < var8; ++var7) {
               var6 += this.getChildAt(var7).getMeasuredWidth();
            }

            int var9 = var6 + this.getPaddingLeft() + this.getPaddingRight();
            var10 = false;
            if(var9 > var3) {
               var10 = true;
            }
         }

         if(var10) {
            this.setStacked(true);
            var5 = true;
         }
      }

      if(var5) {
         super.onMeasure(var1, var2);
      }

   }

   public void setAllowStacking(boolean var1) {
      if(this.mAllowStacking != var1) {
         this.mAllowStacking = var1;
         if(!this.mAllowStacking && this.getOrientation() == 1) {
            this.setStacked(false);
         }

         this.requestLayout();
      }

   }
}
