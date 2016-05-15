package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
   public static final int HORIZONTAL = 0;
   private static final int INDEX_BOTTOM = 2;
   private static final int INDEX_CENTER_VERTICAL = 0;
   private static final int INDEX_FILL = 3;
   private static final int INDEX_TOP = 1;
   public static final int SHOW_DIVIDER_BEGINNING = 1;
   public static final int SHOW_DIVIDER_END = 4;
   public static final int SHOW_DIVIDER_MIDDLE = 2;
   public static final int SHOW_DIVIDER_NONE = 0;
   public static final int VERTICAL = 1;
   private static final int VERTICAL_GRAVITY_COUNT = 4;
   private boolean mBaselineAligned;
   private int mBaselineAlignedChildIndex;
   private int mBaselineChildTop;
   private Drawable mDivider;
   private int mDividerHeight;
   private int mDividerPadding;
   private int mDividerWidth;
   private int mGravity;
   private int[] mMaxAscent;
   private int[] mMaxDescent;
   private int mOrientation;
   private int mShowDividers;
   private int mTotalLength;
   private boolean mUseLargestChild;
   private float mWeightSum;

   public LinearLayoutCompat(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public LinearLayoutCompat(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public LinearLayoutCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mBaselineAligned = true;
      this.mBaselineAlignedChildIndex = -1;
      this.mBaselineChildTop = 0;
      this.mGravity = 8388659;
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(var1, var2, class_22.styleable.LinearLayoutCompat, var3, 0);
      int var5 = var4.getInt(class_22.styleable.LinearLayoutCompat_android_orientation, -1);
      if(var5 >= 0) {
         this.setOrientation(var5);
      }

      int var6 = var4.getInt(class_22.styleable.LinearLayoutCompat_android_gravity, -1);
      if(var6 >= 0) {
         this.setGravity(var6);
      }

      boolean var7 = var4.getBoolean(class_22.styleable.LinearLayoutCompat_android_baselineAligned, true);
      if(!var7) {
         this.setBaselineAligned(var7);
      }

      this.mWeightSum = var4.getFloat(class_22.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
      this.mBaselineAlignedChildIndex = var4.getInt(class_22.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
      this.mUseLargestChild = var4.getBoolean(class_22.styleable.LinearLayoutCompat_measureWithLargestChild, false);
      this.setDividerDrawable(var4.getDrawable(class_22.styleable.LinearLayoutCompat_divider));
      this.mShowDividers = var4.getInt(class_22.styleable.LinearLayoutCompat_showDividers, 0);
      this.mDividerPadding = var4.getDimensionPixelSize(class_22.styleable.LinearLayoutCompat_dividerPadding, 0);
      var4.recycle();
   }

   private void forceUniformHeight(int var1, int var2) {
      int var3 = MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824);

      for(int var4 = 0; var4 < var1; ++var4) {
         View var5 = this.getVirtualChildAt(var4);
         if(var5.getVisibility() != 8) {
            LinearLayoutCompat.LayoutParams var6 = (LinearLayoutCompat.LayoutParams)var5.getLayoutParams();
            if(var6.height == -1) {
               int var7 = var6.width;
               var6.width = var5.getMeasuredWidth();
               this.measureChildWithMargins(var5, var2, 0, var3, 0);
               var6.width = var7;
            }
         }
      }

   }

   private void forceUniformWidth(int var1, int var2) {
      int var3 = MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);

      for(int var4 = 0; var4 < var1; ++var4) {
         View var5 = this.getVirtualChildAt(var4);
         if(var5.getVisibility() != 8) {
            LinearLayoutCompat.LayoutParams var6 = (LinearLayoutCompat.LayoutParams)var5.getLayoutParams();
            if(var6.width == -1) {
               int var7 = var6.height;
               var6.height = var5.getMeasuredHeight();
               this.measureChildWithMargins(var5, var3, 0, var2, 0);
               var6.height = var7;
            }
         }
      }

   }

   private void setChildFrame(View var1, int var2, int var3, int var4, int var5) {
      var1.layout(var2, var3, var2 + var4, var3 + var5);
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof LinearLayoutCompat.LayoutParams;
   }

   void drawDividersHorizontal(Canvas var1) {
      int var2 = this.getVirtualChildCount();
      boolean var3 = ViewUtils.isLayoutRtl(this);

      for(int var4 = 0; var4 < var2; ++var4) {
         View var8 = this.getVirtualChildAt(var4);
         if(var8 != null && var8.getVisibility() != 8 && this.hasDividerBeforeChildAt(var4)) {
            LinearLayoutCompat.LayoutParams var9 = (LinearLayoutCompat.LayoutParams)var8.getLayoutParams();
            int var10;
            if(var3) {
               var10 = var8.getRight() + var9.rightMargin;
            } else {
               var10 = var8.getLeft() - var9.leftMargin - this.mDividerWidth;
            }

            this.drawVerticalDivider(var1, var10);
         }
      }

      if(this.hasDividerBeforeChildAt(var2)) {
         View var5 = this.getVirtualChildAt(var2 - 1);
         int var7;
         if(var5 == null) {
            if(var3) {
               var7 = this.getPaddingLeft();
            } else {
               var7 = this.getWidth() - this.getPaddingRight() - this.mDividerWidth;
            }
         } else {
            LinearLayoutCompat.LayoutParams var6 = (LinearLayoutCompat.LayoutParams)var5.getLayoutParams();
            if(var3) {
               var7 = var5.getLeft() - var6.leftMargin - this.mDividerWidth;
            } else {
               var7 = var5.getRight() + var6.rightMargin;
            }
         }

         this.drawVerticalDivider(var1, var7);
      }

   }

   void drawDividersVertical(Canvas var1) {
      int var2 = this.getVirtualChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         View var7 = this.getVirtualChildAt(var3);
         if(var7 != null && var7.getVisibility() != 8 && this.hasDividerBeforeChildAt(var3)) {
            LinearLayoutCompat.LayoutParams var8 = (LinearLayoutCompat.LayoutParams)var7.getLayoutParams();
            this.drawHorizontalDivider(var1, var7.getTop() - var8.topMargin - this.mDividerHeight);
         }
      }

      if(this.hasDividerBeforeChildAt(var2)) {
         View var4 = this.getVirtualChildAt(var2 - 1);
         int var6;
         if(var4 == null) {
            var6 = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
         } else {
            LinearLayoutCompat.LayoutParams var5 = (LinearLayoutCompat.LayoutParams)var4.getLayoutParams();
            var6 = var4.getBottom() + var5.bottomMargin;
         }

         this.drawHorizontalDivider(var1, var6);
      }

   }

   void drawHorizontalDivider(Canvas var1, int var2) {
      this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, var2, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, var2 + this.mDividerHeight);
      this.mDivider.draw(var1);
   }

   void drawVerticalDivider(Canvas var1, int var2) {
      this.mDivider.setBounds(var2, this.getPaddingTop() + this.mDividerPadding, var2 + this.mDividerWidth, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
      this.mDivider.draw(var1);
   }

   protected LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
      return this.mOrientation == 0?new LinearLayoutCompat.LayoutParams(-2, -2):(this.mOrientation == 1?new LinearLayoutCompat.LayoutParams(-1, -2):null);
   }

   public LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new LinearLayoutCompat.LayoutParams(this.getContext(), var1);
   }

   protected LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return new LinearLayoutCompat.LayoutParams(var1);
   }

   public int getBaseline() {
      int var1 = -1;
      if(this.mBaselineAlignedChildIndex < 0) {
         var1 = super.getBaseline();
      } else {
         if(this.getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
         }

         View var2 = this.getChildAt(this.mBaselineAlignedChildIndex);
         int var3 = var2.getBaseline();
         if(var3 != var1) {
            int var4 = this.mBaselineChildTop;
            if(this.mOrientation == 1) {
               int var5 = 112 & this.mGravity;
               if(var5 != 48) {
                  switch(var5) {
                  case 16:
                     var4 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.mTotalLength) / 2;
                     break;
                  case 80:
                     var4 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.mTotalLength;
                  }
               }
            }

            return var3 + var4 + ((LinearLayoutCompat.LayoutParams)var2.getLayoutParams()).topMargin;
         }

         if(this.mBaselineAlignedChildIndex != 0) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn\'t know how to get its baseline.");
         }
      }

      return var1;
   }

   public int getBaselineAlignedChildIndex() {
      return this.mBaselineAlignedChildIndex;
   }

   int getChildrenSkipCount(View var1, int var2) {
      return 0;
   }

   public Drawable getDividerDrawable() {
      return this.mDivider;
   }

   public int getDividerPadding() {
      return this.mDividerPadding;
   }

   public int getDividerWidth() {
      return this.mDividerWidth;
   }

   int getLocationOffset(View var1) {
      return 0;
   }

   int getNextLocationOffset(View var1) {
      return 0;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public int getShowDividers() {
      return this.mShowDividers;
   }

   View getVirtualChildAt(int var1) {
      return this.getChildAt(var1);
   }

   int getVirtualChildCount() {
      return this.getChildCount();
   }

   public float getWeightSum() {
      return this.mWeightSum;
   }

   protected boolean hasDividerBeforeChildAt(int var1) {
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

   public boolean isBaselineAligned() {
      return this.mBaselineAligned;
   }

   public boolean isMeasureWithLargestChildEnabled() {
      return this.mUseLargestChild;
   }

   void layoutHorizontal(int var1, int var2, int var3, int var4) {
      boolean var5 = ViewUtils.isLayoutRtl(this);
      int var6 = this.getPaddingTop();
      int var7 = var4 - var2;
      int var8 = var7 - this.getPaddingBottom();
      int var9 = var7 - var6 - this.getPaddingBottom();
      int var10 = this.getVirtualChildCount();
      int var11 = 8388615 & this.mGravity;
      int var12 = 112 & this.mGravity;
      boolean var13 = this.mBaselineAligned;
      int[] var14 = this.mMaxAscent;
      int[] var15 = this.mMaxDescent;
      int var16;
      switch(GravityCompat.getAbsoluteGravity(var11, ViewCompat.getLayoutDirection(this))) {
      case 1:
         var16 = this.getPaddingLeft() + (var3 - var1 - this.mTotalLength) / 2;
         break;
      case 5:
         var16 = var3 + this.getPaddingLeft() - var1 - this.mTotalLength;
         break;
      default:
         var16 = this.getPaddingLeft();
      }

      byte var17 = 1;
      int var18 = 0;
      if(var5) {
         var18 = var10 - 1;
         var17 = -1;
      }

      for(int var19 = 0; var19 < var10; ++var19) {
         int var20 = var18 + var17 * var19;
         View var21 = this.getVirtualChildAt(var20);
         if(var21 == null) {
            var16 += this.measureNullChild(var20);
         } else if(var21.getVisibility() != 8) {
            int var22 = var21.getMeasuredWidth();
            int var23 = var21.getMeasuredHeight();
            int var24 = -1;
            LinearLayoutCompat.LayoutParams var25 = (LinearLayoutCompat.LayoutParams)var21.getLayoutParams();
            if(var13 && var25.height != -1) {
               var24 = var21.getBaseline();
            }

            int var26 = var25.gravity;
            if(var26 < 0) {
               var26 = var12;
            }

            int var27;
            switch(var26 & 112) {
            case 16:
               var27 = var6 + (var9 - var23) / 2 + var25.topMargin - var25.bottomMargin;
               break;
            case 48:
               var27 = var6 + var25.topMargin;
               if(var24 != -1) {
                  var27 += var14[1] - var24;
               }
               break;
            case 80:
               var27 = var8 - var23 - var25.bottomMargin;
               if(var24 != -1) {
                  int var28 = var21.getMeasuredHeight() - var24;
                  var27 -= var15[2] - var28;
               }
               break;
            default:
               var27 = var6;
            }

            if(this.hasDividerBeforeChildAt(var20)) {
               var16 += this.mDividerWidth;
            }

            int var29 = var16 + var25.leftMargin;
            this.setChildFrame(var21, var29 + this.getLocationOffset(var21), var27, var22, var23);
            var16 = var29 + var22 + var25.rightMargin + this.getNextLocationOffset(var21);
            var19 += this.getChildrenSkipCount(var21, var20);
         }
      }

   }

   void layoutVertical(int var1, int var2, int var3, int var4) {
      int var5 = this.getPaddingLeft();
      int var6 = var3 - var1;
      int var7 = var6 - this.getPaddingRight();
      int var8 = var6 - var5 - this.getPaddingRight();
      int var9 = this.getVirtualChildCount();
      int var10 = 112 & this.mGravity;
      int var11 = 8388615 & this.mGravity;
      int var12;
      switch(var10) {
      case 16:
         var12 = this.getPaddingTop() + (var4 - var2 - this.mTotalLength) / 2;
         break;
      case 80:
         var12 = var4 + this.getPaddingTop() - var2 - this.mTotalLength;
         break;
      default:
         var12 = this.getPaddingTop();
      }

      for(int var13 = 0; var13 < var9; ++var13) {
         View var14 = this.getVirtualChildAt(var13);
         if(var14 == null) {
            var12 += this.measureNullChild(var13);
         } else if(var14.getVisibility() != 8) {
            int var15 = var14.getMeasuredWidth();
            int var16 = var14.getMeasuredHeight();
            LinearLayoutCompat.LayoutParams var17 = (LinearLayoutCompat.LayoutParams)var14.getLayoutParams();
            int var18 = var17.gravity;
            if(var18 < 0) {
               var18 = var11;
            }

            int var19;
            switch(7 & GravityCompat.getAbsoluteGravity(var18, ViewCompat.getLayoutDirection(this))) {
            case 1:
               var19 = var5 + (var8 - var15) / 2 + var17.leftMargin - var17.rightMargin;
               break;
            case 5:
               var19 = var7 - var15 - var17.rightMargin;
               break;
            default:
               var19 = var5 + var17.leftMargin;
            }

            if(this.hasDividerBeforeChildAt(var13)) {
               var12 += this.mDividerHeight;
            }

            int var20 = var12 + var17.topMargin;
            this.setChildFrame(var14, var19, var20 + this.getLocationOffset(var14), var15, var16);
            var12 = var20 + var16 + var17.bottomMargin + this.getNextLocationOffset(var14);
            var13 += this.getChildrenSkipCount(var14, var13);
         }
      }

   }

   void measureChildBeforeLayout(View var1, int var2, int var3, int var4, int var5, int var6) {
      this.measureChildWithMargins(var1, var3, var4, var5, var6);
   }

   void measureHorizontal(int var1, int var2) {
      this.mTotalLength = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      boolean var7 = true;
      float var8 = 0.0F;
      int var9 = this.getVirtualChildCount();
      int var10 = MeasureSpec.getMode(var1);
      int var11 = MeasureSpec.getMode(var2);
      boolean var12 = false;
      boolean var13 = false;
      if(this.mMaxAscent == null || this.mMaxDescent == null) {
         this.mMaxAscent = new int[4];
         this.mMaxDescent = new int[4];
      }

      int[] var14 = this.mMaxAscent;
      int[] var15 = this.mMaxDescent;
      var14[3] = -1;
      var14[2] = -1;
      var14[1] = -1;
      var14[0] = -1;
      var15[3] = -1;
      var15[2] = -1;
      var15[1] = -1;
      var15[0] = -1;
      boolean var16 = this.mBaselineAligned;
      boolean var17 = this.mUseLargestChild;
      boolean var18;
      if(var10 == 1073741824) {
         var18 = true;
      } else {
         var18 = false;
      }

      int var19 = Integer.MIN_VALUE;

      for(int var20 = 0; var20 < var9; ++var20) {
         View var48 = this.getVirtualChildAt(var20);
         if(var48 == null) {
            this.mTotalLength += this.measureNullChild(var20);
         } else if(var48.getVisibility() == 8) {
            var20 += this.getChildrenSkipCount(var48, var20);
         } else {
            if(this.hasDividerBeforeChildAt(var20)) {
               this.mTotalLength += this.mDividerWidth;
            }

            LinearLayoutCompat.LayoutParams var49 = (LinearLayoutCompat.LayoutParams)var48.getLayoutParams();
            var8 += var49.weight;
            if(var10 == 1073741824 && var49.width == 0 && var49.weight > 0.0F) {
               if(var18) {
                  this.mTotalLength += var49.leftMargin + var49.rightMargin;
               } else {
                  int var62 = this.mTotalLength;
                  this.mTotalLength = Math.max(var62, var62 + var49.leftMargin + var49.rightMargin);
               }

               if(var16) {
                  int var63 = MeasureSpec.makeMeasureSpec(0, 0);
                  var48.measure(var63, var63);
               } else {
                  var13 = true;
               }
            } else {
               int var50 = Integer.MIN_VALUE;
               if(var49.width == 0 && var49.weight > 0.0F) {
                  var50 = 0;
                  var49.width = -2;
               }

               int var51;
               if(var8 == 0.0F) {
                  var51 = this.mTotalLength;
               } else {
                  var51 = 0;
               }

               this.measureChildBeforeLayout(var48, var20, var1, var51, var2, 0);
               if(var50 != Integer.MIN_VALUE) {
                  var49.width = var50;
               }

               int var52 = var48.getMeasuredWidth();
               if(var18) {
                  this.mTotalLength += var52 + var49.leftMargin + var49.rightMargin + this.getNextLocationOffset(var48);
               } else {
                  int var53 = this.mTotalLength;
                  this.mTotalLength = Math.max(var53, var53 + var52 + var49.leftMargin + var49.rightMargin + this.getNextLocationOffset(var48));
               }

               if(var17) {
                  var19 = Math.max(var52, var19);
               }
            }

            boolean var54 = false;
            if(var11 != 1073741824) {
               int var61 = var49.height;
               var54 = false;
               if(var61 == -1) {
                  var12 = true;
                  var54 = true;
               }
            }

            int var55 = var49.topMargin + var49.bottomMargin;
            int var56 = var55 + var48.getMeasuredHeight();
            int var57 = ViewCompat.getMeasuredState(var48);
            var4 = ViewUtils.combineMeasuredStates(var4, var57);
            if(var16) {
               int var58 = var48.getBaseline();
               if(var58 != -1) {
                  int var59;
                  if(var49.gravity < 0) {
                     var59 = this.mGravity;
                  } else {
                     var59 = var49.gravity;
                  }

                  int var60 = (-2 & (var59 & 112) >> 4) >> 1;
                  var14[var60] = Math.max(var14[var60], var58);
                  var15[var60] = Math.max(var15[var60], var56 - var58);
               }
            }

            var3 = Math.max(var3, var56);
            if(var7 && var49.height == -1) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var49.weight > 0.0F) {
               if(!var54) {
                  var55 = var56;
               }

               var6 = Math.max(var6, var55);
            } else {
               if(!var54) {
                  var55 = var56;
               }

               var5 = Math.max(var5, var55);
            }

            var20 += this.getChildrenSkipCount(var48, var20);
         }
      }

      if(this.mTotalLength > 0 && this.hasDividerBeforeChildAt(var9)) {
         this.mTotalLength += this.mDividerWidth;
      }

      if(var14[1] != -1 || var14[0] != -1 || var14[2] != -1 || var14[3] != -1) {
         int var21 = Math.max(var14[3], Math.max(var14[0], Math.max(var14[1], var14[2]))) + Math.max(var15[3], Math.max(var15[0], Math.max(var15[1], var15[2])));
         var3 = Math.max(var3, var21);
      }

      if(var17 && (var10 == Integer.MIN_VALUE || var10 == 0)) {
         this.mTotalLength = 0;

         for(int var44 = 0; var44 < var9; ++var44) {
            View var45 = this.getVirtualChildAt(var44);
            if(var45 == null) {
               this.mTotalLength += this.measureNullChild(var44);
            } else if(var45.getVisibility() == 8) {
               var44 += this.getChildrenSkipCount(var45, var44);
            } else {
               LinearLayoutCompat.LayoutParams var46 = (LinearLayoutCompat.LayoutParams)var45.getLayoutParams();
               if(var18) {
                  this.mTotalLength += var19 + var46.leftMargin + var46.rightMargin + this.getNextLocationOffset(var45);
               } else {
                  int var47 = this.mTotalLength;
                  this.mTotalLength = Math.max(var47, var47 + var19 + var46.leftMargin + var46.rightMargin + this.getNextLocationOffset(var45));
               }
            }
         }
      }

      this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
      int var22 = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, this.getSuggestedMinimumWidth()), var1, 0);
      int var23 = (var22 & 16777215) - this.mTotalLength;
      if(var13 || var23 != 0 && var8 > 0.0F) {
         float var24;
         if(this.mWeightSum > 0.0F) {
            var24 = this.mWeightSum;
         } else {
            var24 = var8;
         }

         var14[3] = -1;
         var14[2] = -1;
         var14[1] = -1;
         var14[0] = -1;
         var15[3] = -1;
         var15[2] = -1;
         var15[1] = -1;
         var15[0] = -1;
         var3 = -1;
         this.mTotalLength = 0;

         for(int var25 = 0; var25 < var9; ++var25) {
            View var28 = this.getVirtualChildAt(var25);
            if(var28 != null && var28.getVisibility() != 8) {
               LinearLayoutCompat.LayoutParams var29 = (LinearLayoutCompat.LayoutParams)var28.getLayoutParams();
               float var30 = var29.weight;
               if(var30 > 0.0F) {
                  int var38 = (int)(var30 * (float)var23 / var24);
                  var24 -= var30;
                  var23 -= var38;
                  int var39 = getChildMeasureSpec(var2, this.getPaddingTop() + this.getPaddingBottom() + var29.topMargin + var29.bottomMargin, var29.height);
                  if(var29.width == 0 && var10 == 1073741824) {
                     if(var38 <= 0) {
                        var38 = 0;
                     }

                     var28.measure(MeasureSpec.makeMeasureSpec(var38, 1073741824), var39);
                  } else {
                     int var40 = var38 + var28.getMeasuredWidth();
                     if(var40 < 0) {
                        var40 = 0;
                     }

                     var28.measure(MeasureSpec.makeMeasureSpec(var40, 1073741824), var39);
                  }

                  int var41 = -16777216 & ViewCompat.getMeasuredState(var28);
                  var4 = ViewUtils.combineMeasuredStates(var4, var41);
               }

               if(var18) {
                  this.mTotalLength += var28.getMeasuredWidth() + var29.leftMargin + var29.rightMargin + this.getNextLocationOffset(var28);
               } else {
                  int var31 = this.mTotalLength;
                  this.mTotalLength = Math.max(var31, var31 + var28.getMeasuredWidth() + var29.leftMargin + var29.rightMargin + this.getNextLocationOffset(var28));
               }

               boolean var32;
               if(var11 != 1073741824 && var29.height == -1) {
                  var32 = true;
               } else {
                  var32 = false;
               }

               int var33 = var29.topMargin + var29.bottomMargin;
               int var34 = var33 + var28.getMeasuredHeight();
               var3 = Math.max(var3, var34);
               if(!var32) {
                  var33 = var34;
               }

               var5 = Math.max(var5, var33);
               if(var7 && var29.height == -1) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               if(var16) {
                  int var35 = var28.getBaseline();
                  if(var35 != -1) {
                     int var36;
                     if(var29.gravity < 0) {
                        var36 = this.mGravity;
                     } else {
                        var36 = var29.gravity;
                     }

                     int var37 = (-2 & (var36 & 112) >> 4) >> 1;
                     var14[var37] = Math.max(var14[var37], var35);
                     var15[var37] = Math.max(var15[var37], var34 - var35);
                  }
               }
            }
         }

         this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
         if(var14[1] != -1 || var14[0] != -1 || var14[2] != -1 || var14[3] != -1) {
            int var26 = Math.max(var14[3], Math.max(var14[0], Math.max(var14[1], var14[2]))) + Math.max(var15[3], Math.max(var15[0], Math.max(var15[1], var15[2])));
            var3 = Math.max(var3, var26);
         }
      } else {
         var5 = Math.max(var5, var6);
         if(var17 && var10 != 1073741824) {
            for(int var42 = 0; var42 < var9; ++var42) {
               View var43 = this.getVirtualChildAt(var42);
               if(var43 != null && var43.getVisibility() != 8 && ((LinearLayoutCompat.LayoutParams)var43.getLayoutParams()).weight > 0.0F) {
                  var43.measure(MeasureSpec.makeMeasureSpec(var19, 1073741824), MeasureSpec.makeMeasureSpec(var43.getMeasuredHeight(), 1073741824));
               }
            }
         }
      }

      if(!var7 && var11 != 1073741824) {
         var3 = var5;
      }

      int var27 = Math.max(var3 + this.getPaddingTop() + this.getPaddingBottom(), this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(var22 | -16777216 & var4, ViewCompat.resolveSizeAndState(var27, var2, var4 << 16));
      if(var12) {
         this.forceUniformHeight(var9, var1);
      }

   }

   int measureNullChild(int var1) {
      return 0;
   }

   void measureVertical(int var1, int var2) {
      this.mTotalLength = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      boolean var7 = true;
      float var8 = 0.0F;
      int var9 = this.getVirtualChildCount();
      int var10 = MeasureSpec.getMode(var1);
      int var11 = MeasureSpec.getMode(var2);
      boolean var12 = false;
      boolean var13 = false;
      int var14 = this.mBaselineAlignedChildIndex;
      boolean var15 = this.mUseLargestChild;
      int var16 = Integer.MIN_VALUE;

      for(int var17 = 0; var17 < var9; ++var17) {
         View var38 = this.getVirtualChildAt(var17);
         if(var38 == null) {
            this.mTotalLength += this.measureNullChild(var17);
         } else if(var38.getVisibility() == 8) {
            var17 += this.getChildrenSkipCount(var38, var17);
         } else {
            if(this.hasDividerBeforeChildAt(var17)) {
               this.mTotalLength += this.mDividerHeight;
            }

            LinearLayoutCompat.LayoutParams var39 = (LinearLayoutCompat.LayoutParams)var38.getLayoutParams();
            var8 += var39.weight;
            if(var11 == 1073741824 && var39.height == 0 && var39.weight > 0.0F) {
               int var48 = this.mTotalLength;
               this.mTotalLength = Math.max(var48, var48 + var39.topMargin + var39.bottomMargin);
               var13 = true;
            } else {
               int var40 = Integer.MIN_VALUE;
               if(var39.height == 0 && var39.weight > 0.0F) {
                  var40 = 0;
                  var39.height = -2;
               }

               int var41;
               if(var8 == 0.0F) {
                  var41 = this.mTotalLength;
               } else {
                  var41 = 0;
               }

               this.measureChildBeforeLayout(var38, var17, var1, 0, var2, var41);
               if(var40 != Integer.MIN_VALUE) {
                  var39.height = var40;
               }

               int var42 = var38.getMeasuredHeight();
               int var43 = this.mTotalLength;
               this.mTotalLength = Math.max(var43, var43 + var42 + var39.topMargin + var39.bottomMargin + this.getNextLocationOffset(var38));
               if(var15) {
                  var16 = Math.max(var42, var16);
               }
            }

            if(var14 >= 0 && var14 == var17 + 1) {
               this.mBaselineChildTop = this.mTotalLength;
            }

            if(var17 < var14 && var39.weight > 0.0F) {
               throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won\'t work.  Either remove the weight, or don\'t set mBaselineAlignedChildIndex.");
            }

            boolean var44 = false;
            if(var10 != 1073741824) {
               int var47 = var39.width;
               var44 = false;
               if(var47 == -1) {
                  var12 = true;
                  var44 = true;
               }
            }

            int var45 = var39.leftMargin + var39.rightMargin;
            int var46 = var45 + var38.getMeasuredWidth();
            var3 = Math.max(var3, var46);
            var4 = ViewUtils.combineMeasuredStates(var4, ViewCompat.getMeasuredState(var38));
            if(var7 && var39.width == -1) {
               var7 = true;
            } else {
               var7 = false;
            }

            if(var39.weight > 0.0F) {
               if(!var44) {
                  var45 = var46;
               }

               var6 = Math.max(var6, var45);
            } else {
               if(!var44) {
                  var45 = var46;
               }

               var5 = Math.max(var5, var45);
            }

            var17 += this.getChildrenSkipCount(var38, var17);
         }
      }

      if(this.mTotalLength > 0 && this.hasDividerBeforeChildAt(var9)) {
         this.mTotalLength += this.mDividerHeight;
      }

      if(var15 && (var11 == Integer.MIN_VALUE || var11 == 0)) {
         this.mTotalLength = 0;

         for(int var34 = 0; var34 < var9; ++var34) {
            View var35 = this.getVirtualChildAt(var34);
            if(var35 == null) {
               this.mTotalLength += this.measureNullChild(var34);
            } else if(var35.getVisibility() == 8) {
               var34 += this.getChildrenSkipCount(var35, var34);
            } else {
               LinearLayoutCompat.LayoutParams var36 = (LinearLayoutCompat.LayoutParams)var35.getLayoutParams();
               int var37 = this.mTotalLength;
               this.mTotalLength = Math.max(var37, var37 + var16 + var36.topMargin + var36.bottomMargin + this.getNextLocationOffset(var35));
            }
         }
      }

      this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
      int var18 = ViewCompat.resolveSizeAndState(Math.max(this.mTotalLength, this.getSuggestedMinimumHeight()), var2, 0);
      int var19 = (var18 & 16777215) - this.mTotalLength;
      if(!var13 && (var19 == 0 || var8 <= 0.0F)) {
         var5 = Math.max(var5, var6);
         if(var15 && var11 != 1073741824) {
            for(int var32 = 0; var32 < var9; ++var32) {
               View var33 = this.getVirtualChildAt(var32);
               if(var33 != null && var33.getVisibility() != 8 && ((LinearLayoutCompat.LayoutParams)var33.getLayoutParams()).weight > 0.0F) {
                  var33.measure(MeasureSpec.makeMeasureSpec(var33.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(var16, 1073741824));
               }
            }
         }
      } else {
         float var20;
         if(this.mWeightSum > 0.0F) {
            var20 = this.mWeightSum;
         } else {
            var20 = var8;
         }

         this.mTotalLength = 0;

         for(int var21 = 0; var21 < var9; ++var21) {
            View var22 = this.getVirtualChildAt(var21);
            if(var22.getVisibility() != 8) {
               LinearLayoutCompat.LayoutParams var23 = (LinearLayoutCompat.LayoutParams)var22.getLayoutParams();
               float var24 = var23.weight;
               if(var24 > 0.0F) {
                  int var29 = (int)(var24 * (float)var19 / var20);
                  var20 -= var24;
                  var19 -= var29;
                  int var30 = getChildMeasureSpec(var1, this.getPaddingLeft() + this.getPaddingRight() + var23.leftMargin + var23.rightMargin, var23.width);
                  if(var23.height == 0 && var11 == 1073741824) {
                     if(var29 <= 0) {
                        var29 = 0;
                     }

                     var22.measure(var30, MeasureSpec.makeMeasureSpec(var29, 1073741824));
                  } else {
                     int var31 = var29 + var22.getMeasuredHeight();
                     if(var31 < 0) {
                        var31 = 0;
                     }

                     var22.measure(var30, MeasureSpec.makeMeasureSpec(var31, 1073741824));
                  }

                  var4 = ViewUtils.combineMeasuredStates(var4, -256 & ViewCompat.getMeasuredState(var22));
               }

               int var25 = var23.leftMargin + var23.rightMargin;
               int var26 = var25 + var22.getMeasuredWidth();
               var3 = Math.max(var3, var26);
               boolean var27;
               if(var10 != 1073741824 && var23.width == -1) {
                  var27 = true;
               } else {
                  var27 = false;
               }

               if(!var27) {
                  var25 = var26;
               }

               var5 = Math.max(var5, var25);
               if(var7 && var23.width == -1) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               int var28 = this.mTotalLength;
               this.mTotalLength = Math.max(var28, var28 + var22.getMeasuredHeight() + var23.topMargin + var23.bottomMargin + this.getNextLocationOffset(var22));
            }
         }

         this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
      }

      if(!var7 && var10 != 1073741824) {
         var3 = var5;
      }

      this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(var3 + this.getPaddingLeft() + this.getPaddingRight(), this.getSuggestedMinimumWidth()), var1, var4), var18);
      if(var12) {
         this.forceUniformWidth(var9, var2);
      }

   }

   protected void onDraw(Canvas var1) {
      if(this.mDivider != null) {
         if(this.mOrientation == 1) {
            this.drawDividersVertical(var1);
         } else {
            this.drawDividersHorizontal(var1);
         }
      }
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      if(VERSION.SDK_INT >= 14) {
         super.onInitializeAccessibilityEvent(var1);
         var1.setClassName(LinearLayoutCompat.class.getName());
      }

   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      if(VERSION.SDK_INT >= 14) {
         super.onInitializeAccessibilityNodeInfo(var1);
         var1.setClassName(LinearLayoutCompat.class.getName());
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(this.mOrientation == 1) {
         this.layoutVertical(var2, var3, var4, var5);
      } else {
         this.layoutHorizontal(var2, var3, var4, var5);
      }
   }

   protected void onMeasure(int var1, int var2) {
      if(this.mOrientation == 1) {
         this.measureVertical(var1, var2);
      } else {
         this.measureHorizontal(var1, var2);
      }
   }

   public void setBaselineAligned(boolean var1) {
      this.mBaselineAligned = var1;
   }

   public void setBaselineAlignedChildIndex(int var1) {
      if(var1 >= 0 && var1 < this.getChildCount()) {
         this.mBaselineAlignedChildIndex = var1;
      } else {
         throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
      }
   }

   public void setDividerDrawable(Drawable var1) {
      if(var1 != this.mDivider) {
         this.mDivider = var1;
         if(var1 != null) {
            this.mDividerWidth = var1.getIntrinsicWidth();
            this.mDividerHeight = var1.getIntrinsicHeight();
         } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
         }

         boolean var2 = false;
         if(var1 == null) {
            var2 = true;
         }

         this.setWillNotDraw(var2);
         this.requestLayout();
      }
   }

   public void setDividerPadding(int var1) {
      this.mDividerPadding = var1;
   }

   public void setGravity(int var1) {
      if(this.mGravity != var1) {
         if((8388615 & var1) == 0) {
            var1 |= 8388611;
         }

         if((var1 & 112) == 0) {
            var1 |= 48;
         }

         this.mGravity = var1;
         this.requestLayout();
      }

   }

   public void setHorizontalGravity(int var1) {
      int var2 = var1 & 8388615;
      if((8388615 & this.mGravity) != var2) {
         this.mGravity = var2 | -8388616 & this.mGravity;
         this.requestLayout();
      }

   }

   public void setMeasureWithLargestChildEnabled(boolean var1) {
      this.mUseLargestChild = var1;
   }

   public void setOrientation(int var1) {
      if(this.mOrientation != var1) {
         this.mOrientation = var1;
         this.requestLayout();
      }

   }

   public void setShowDividers(int var1) {
      if(var1 != this.mShowDividers) {
         this.requestLayout();
      }

      this.mShowDividers = var1;
   }

   public void setVerticalGravity(int var1) {
      int var2 = var1 & 112;
      if((112 & this.mGravity) != var2) {
         this.mGravity = var2 | -113 & this.mGravity;
         this.requestLayout();
      }

   }

   public void setWeightSum(float var1) {
      this.mWeightSum = Math.max(0.0F, var1);
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface DividerMode {
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int gravity = -1;
      public float weight;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.weight = 0.0F;
      }

      public LayoutParams(int var1, int var2, float var3) {
         super(var1, var2);
         this.weight = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_22.styleable.LinearLayoutCompat_Layout);
         this.weight = var3.getFloat(class_22.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
         this.gravity = var3.getInt(class_22.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
         var3.recycle();
      }

      public LayoutParams(LinearLayoutCompat.LayoutParams var1) {
         super(var1);
         this.weight = var1.weight;
         this.gravity = var1.gravity;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface OrientationMode {
   }
}
