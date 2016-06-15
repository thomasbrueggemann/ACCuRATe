package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutICS implements MenuBuilder.ItemInvoker, MenuView {
   static final int GENERATED_ITEM_PADDING = 4;
   static final int MIN_CELL_SIZE = 56;
   private static final String TAG = "ActionMenuView";
   private boolean mFormatItems;
   private int mFormatItemsWidth;
   private int mGeneratedItemPadding;
   private int mMaxItemHeight;
   private int mMeasuredExtraWidth;
   private MenuBuilder mMenu;
   private int mMinCellSize;
   private ActionMenuPresenter mPresenter;
   private boolean mReserveOverflow;

   public ActionMenuView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionMenuView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setBaselineAligned(false);
      float var3 = var1.getResources().getDisplayMetrics().density;
      this.mMinCellSize = (int)(56.0F * var3);
      this.mGeneratedItemPadding = (int)(4.0F * var3);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_639.styleable.ActionBar, class_639.attr.actionBarStyle, 0);
      this.mMaxItemHeight = var4.getDimensionPixelSize(1, 0);
      var4.recycle();
   }

   static int measureChildForCells(View var0, int var1, int var2, int var3, int var4) {
      ActionMenuView.LayoutParams var5 = (ActionMenuView.LayoutParams)var0.getLayoutParams();
      int var6 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(var3) - var4, MeasureSpec.getMode(var3));
      ActionMenuItemView var7;
      if(var0 instanceof ActionMenuItemView) {
         var7 = (ActionMenuItemView)var0;
      } else {
         var7 = null;
      }

      boolean var8;
      if(var7 != null && var7.hasText()) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var9 = 0;
      if(var2 > 0) {
         label47: {
            if(var8) {
               var9 = 0;
               if(var2 < 2) {
                  break label47;
               }
            }

            var0.measure(MeasureSpec.makeMeasureSpec(var1 * var2, Integer.MIN_VALUE), var6);
            int var11 = var0.getMeasuredWidth();
            var9 = var11 / var1;
            if(var11 % var1 != 0) {
               ++var9;
            }

            if(var8 && var9 < 2) {
               var9 = 2;
            }
         }
      }

      boolean var10;
      if(!var5.isOverflowButton && var8) {
         var10 = true;
      } else {
         var10 = false;
      }

      var5.expandable = var10;
      var5.cellsUsed = var9;
      var0.measure(MeasureSpec.makeMeasureSpec(var9 * var1, 1073741824), var6);
      return var9;
   }

   private void onMeasureExactFormat(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var2);
      int var4 = MeasureSpec.getSize(var1);
      int var5 = MeasureSpec.getSize(var2);
      int var6 = this.getPaddingLeft() + this.getPaddingRight();
      int var7 = this.getPaddingTop() + this.getPaddingBottom();
      int var8;
      if(var3 == 1073741824) {
         var8 = MeasureSpec.makeMeasureSpec(var5 - var7, 1073741824);
      } else {
         var8 = MeasureSpec.makeMeasureSpec(Math.min(this.mMaxItemHeight, var5 - var7), Integer.MIN_VALUE);
      }

      int var9 = var4 - var6;
      int var10 = var9 / this.mMinCellSize;
      int var11 = var9 % this.mMinCellSize;
      if(var10 == 0) {
         this.setMeasuredDimension(var9, 0);
      } else {
         int var12 = this.mMinCellSize + var11 / var10;
         int var13 = var10;
         int var14 = 0;
         int var15 = 0;
         int var16 = 0;
         int var17 = 0;
         boolean var18 = false;
         long var19 = 0L;
         int var21 = this.getChildCount();

         for(int var22 = 0; var22 < var21; ++var22) {
            View var45 = this.getChildAt(var22);
            if(var45.getVisibility() != 8) {
               boolean var46 = var45 instanceof ActionMenuItemView;
               ++var17;
               if(var46) {
                  var45.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
               }

               ActionMenuView.LayoutParams var47 = (ActionMenuView.LayoutParams)var45.getLayoutParams();
               var47.expanded = false;
               var47.extraPixels = 0;
               var47.cellsUsed = 0;
               var47.expandable = false;
               var47.leftMargin = 0;
               var47.rightMargin = 0;
               boolean var48;
               if(var46 && ((ActionMenuItemView)var45).hasText()) {
                  var48 = true;
               } else {
                  var48 = false;
               }

               var47.preventEdgeOffset = var48;
               int var49;
               if(var47.isOverflowButton) {
                  var49 = 1;
               } else {
                  var49 = var13;
               }

               int var50 = measureChildForCells(var45, var12, var49, var8, var7);
               var15 = Math.max(var15, var50);
               if(var47.expandable) {
                  ++var16;
               }

               if(var47.isOverflowButton) {
                  var18 = true;
               }

               var13 -= var50;
               int var51 = var45.getMeasuredHeight();
               var14 = Math.max(var14, var51);
               if(var50 == 1) {
                  var19 |= (long)(1 << var22);
               }
            }
         }

         boolean var23;
         if(var18 && var17 == 2) {
            var23 = true;
         } else {
            var23 = false;
         }

         boolean var24;
         for(var24 = false; var16 > 0 && var13 > 0; var24 = true) {
            int var35 = Integer.MAX_VALUE;
            long var36 = 0L;
            int var38 = 0;

            for(int var39 = 0; var39 < var21; ++var39) {
               ActionMenuView.LayoutParams var44 = (ActionMenuView.LayoutParams)this.getChildAt(var39).getLayoutParams();
               if(var44.expandable) {
                  if(var44.cellsUsed < var35) {
                     var35 = var44.cellsUsed;
                     var36 = (long)(1 << var39);
                     var38 = 1;
                  } else if(var44.cellsUsed == var35) {
                     var36 |= (long)(1 << var39);
                     ++var38;
                  }
               }
            }

            var19 |= var36;
            if(var38 > var13) {
               break;
            }

            int var40 = var35 + 1;

            for(int var41 = 0; var41 < var21; ++var41) {
               View var42 = this.getChildAt(var41);
               ActionMenuView.LayoutParams var43 = (ActionMenuView.LayoutParams)var42.getLayoutParams();
               if((var36 & (long)(1 << var41)) == 0L) {
                  if(var43.cellsUsed == var40) {
                     var19 |= (long)(1 << var41);
                  }
               } else {
                  if(var23 && var43.preventEdgeOffset && var13 == 1) {
                     var42.setPadding(var12 + this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                  }

                  ++var43.cellsUsed;
                  var43.expanded = true;
                  --var13;
               }
            }
         }

         boolean var25;
         if(!var18 && var17 == 1) {
            var25 = true;
         } else {
            var25 = false;
         }

         if(var13 > 0 && var19 != 0L && (var13 < var17 - 1 || var25 || var15 > 1)) {
            float var29 = (float)Long.bitCount(var19);
            if(!var25) {
               if((1L & var19) != 0L && !((ActionMenuView.LayoutParams)this.getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                  var29 -= 0.5F;
               }

               if((var19 & (long)(1 << var21 - 1)) != 0L && !((ActionMenuView.LayoutParams)this.getChildAt(var21 - 1).getLayoutParams()).preventEdgeOffset) {
                  var29 -= 0.5F;
               }
            }

            int var30;
            if(var29 > 0.0F) {
               var30 = (int)((float)(var13 * var12) / var29);
            } else {
               var30 = 0;
            }

            for(int var31 = 0; var31 < var21; ++var31) {
               if((var19 & (long)(1 << var31)) != 0L) {
                  View var32 = this.getChildAt(var31);
                  ActionMenuView.LayoutParams var33 = (ActionMenuView.LayoutParams)var32.getLayoutParams();
                  if(var32 instanceof ActionMenuItemView) {
                     var33.extraPixels = var30;
                     var33.expanded = true;
                     if(var31 == 0 && !var33.preventEdgeOffset) {
                        var33.leftMargin = -var30 / 2;
                     }

                     var24 = true;
                  } else if(var33.isOverflowButton) {
                     var33.extraPixels = var30;
                     var33.expanded = true;
                     var33.rightMargin = -var30 / 2;
                     var24 = true;
                  } else {
                     if(var31 != 0) {
                        var33.leftMargin = var30 / 2;
                     }

                     int var34 = var21 - 1;
                     if(var31 != var34) {
                        var33.rightMargin = var30 / 2;
                     }
                  }
               }
            }

            var13 = 0;
         }

         if(var24) {
            for(int var26 = 0; var26 < var21; ++var26) {
               View var27 = this.getChildAt(var26);
               ActionMenuView.LayoutParams var28 = (ActionMenuView.LayoutParams)var27.getLayoutParams();
               if(var28.expanded) {
                  var27.measure(MeasureSpec.makeMeasureSpec(var12 * var28.cellsUsed + var28.extraPixels, 1073741824), var8);
               }
            }
         }

         if(var3 != 1073741824) {
            var5 = var14;
         }

         this.setMeasuredDimension(var9, var5);
         this.mMeasuredExtraWidth = var13 * var12;
      }
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 != null && var1 instanceof ActionMenuView.LayoutParams;
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      return false;
   }

   protected ActionMenuView.LayoutParams generateDefaultLayoutParams() {
      ActionMenuView.LayoutParams var1 = new ActionMenuView.LayoutParams(-2, -2);
      var1.gravity = 16;
      return var1;
   }

   public ActionMenuView.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ActionMenuView.LayoutParams(this.getContext(), var1);
   }

   protected ActionMenuView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      if(var1 instanceof ActionMenuView.LayoutParams) {
         ActionMenuView.LayoutParams var2 = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)var1);
         if(var2.gravity <= 0) {
            var2.gravity = 16;
         }

         return var2;
      } else {
         return this.generateDefaultLayoutParams();
      }
   }

   public ActionMenuView.LayoutParams generateOverflowButtonLayoutParams() {
      ActionMenuView.LayoutParams var1 = this.generateDefaultLayoutParams();
      var1.isOverflowButton = true;
      return var1;
   }

   public int getWindowAnimations() {
      return 0;
   }

   protected boolean hasSupportDividerBeforeChildAt(int var1) {
      View var2 = this.getChildAt(var1 - 1);
      View var3 = this.getChildAt(var1);
      int var4 = this.getChildCount();
      boolean var5 = false;
      if(var1 < var4) {
         boolean var6 = var2 instanceof ActionMenuView.ActionMenuChildView;
         var5 = false;
         if(var6) {
            var5 = false | ((ActionMenuView.ActionMenuChildView)var2).needsDividerAfter();
         }
      }

      if(var1 > 0 && var3 instanceof ActionMenuView.ActionMenuChildView) {
         var5 |= ((ActionMenuView.ActionMenuChildView)var3).needsDividerBefore();
      }

      return var5;
   }

   public void initialize(MenuBuilder var1) {
      this.mMenu = var1;
   }

   public boolean invokeItem(MenuItemImpl var1) {
      return this.mMenu.performItemAction(var1, 0);
   }

   public boolean isExpandedFormat() {
      return this.mFormatItems;
   }

   public boolean isOverflowReserved() {
      return this.mReserveOverflow;
   }

   public void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      this.mPresenter.updateMenuView(false);
      if(this.mPresenter != null && this.mPresenter.isOverflowMenuShowing()) {
         this.mPresenter.hideOverflowMenu();
         this.mPresenter.showOverflowMenu();
      }

   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mPresenter.dismissPopupMenus();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(!this.mFormatItems) {
         super.onLayout(var1, var2, var3, var4, var5);
      } else {
         int var6 = this.getChildCount();
         int var7 = (var3 + var5) / 2;
         int var8 = this.getSupportDividerWidth();
         int var9 = 0;
         int var10 = 0;
         int var11 = var4 - var2 - this.getPaddingRight() - this.getPaddingLeft();
         boolean var12 = false;

         for(int var13 = 0; var13 < var6; ++var13) {
            View var31 = this.getChildAt(var13);
            if(var31.getVisibility() != 8) {
               ActionMenuView.LayoutParams var32 = (ActionMenuView.LayoutParams)var31.getLayoutParams();
               if(var32.isOverflowButton) {
                  int var34 = var31.getMeasuredWidth();
                  if(this.hasSupportDividerBeforeChildAt(var13)) {
                     var34 += var8;
                  }

                  int var35 = var31.getMeasuredHeight();
                  int var36 = this.getWidth() - this.getPaddingRight() - var32.rightMargin;
                  int var37 = var36 - var34;
                  int var38 = var7 - var35 / 2;
                  var31.layout(var37, var38, var36, var38 + var35);
                  var11 -= var34;
                  var12 = true;
               } else {
                  int var33 = var31.getMeasuredWidth() + var32.leftMargin + var32.rightMargin;
                  var9 += var33;
                  var11 -= var33;
                  if(this.hasSupportDividerBeforeChildAt(var13)) {
                     var9 += var8;
                  }

                  ++var10;
               }
            }
         }

         if(var6 == 1 && !var12) {
            View var26 = this.getChildAt(0);
            int var27 = var26.getMeasuredWidth();
            int var28 = var26.getMeasuredHeight();
            int var29 = (var4 - var2) / 2 - var27 / 2;
            int var30 = var7 - var28 / 2;
            var26.layout(var29, var30, var29 + var27, var30 + var28);
            return;
         }

         byte var14;
         if(var12) {
            var14 = 0;
         } else {
            var14 = 1;
         }

         int var15 = var10 - var14;
         int var16;
         if(var15 > 0) {
            var16 = var11 / var15;
         } else {
            var16 = 0;
         }

         int var17 = Math.max(0, var16);
         int var18 = this.getPaddingLeft();

         for(int var19 = 0; var19 < var6; ++var19) {
            View var20 = this.getChildAt(var19);
            ActionMenuView.LayoutParams var21 = (ActionMenuView.LayoutParams)var20.getLayoutParams();
            if(var20.getVisibility() != 8 && !var21.isOverflowButton) {
               int var22 = var18 + var21.leftMargin;
               int var23 = var20.getMeasuredWidth();
               int var24 = var20.getMeasuredHeight();
               int var25 = var7 - var24 / 2;
               var20.layout(var22, var25, var22 + var23, var25 + var24);
               var18 = var22 + var17 + var23 + var21.rightMargin;
            }
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      boolean var3 = this.mFormatItems;
      boolean var4;
      if(MeasureSpec.getMode(var1) == 1073741824) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.mFormatItems = var4;
      if(var3 != this.mFormatItems) {
         this.mFormatItemsWidth = 0;
      }

      int var5 = MeasureSpec.getMode(var1);
      if(this.mFormatItems && this.mMenu != null && var5 != this.mFormatItemsWidth) {
         this.mFormatItemsWidth = var5;
         this.mMenu.onItemsChanged(true);
      }

      if(this.mFormatItems) {
         this.onMeasureExactFormat(var1, var2);
      } else {
         int var6 = this.getChildCount();

         for(int var7 = 0; var7 < var6; ++var7) {
            ActionMenuView.LayoutParams var8 = (ActionMenuView.LayoutParams)this.getChildAt(var7).getLayoutParams();
            var8.rightMargin = 0;
            var8.leftMargin = 0;
         }

         super.onMeasure(var1, var2);
      }
   }

   public void setOverflowReserved(boolean var1) {
      this.mReserveOverflow = var1;
   }

   public void setPresenter(ActionMenuPresenter var1) {
      this.mPresenter = var1;
   }

   public interface ActionMenuChildView {
      boolean needsDividerAfter();

      boolean needsDividerBefore();
   }

   public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
      @ExportedProperty
      public int cellsUsed;
      @ExportedProperty
      public boolean expandable;
      public boolean expanded;
      @ExportedProperty
      public int extraPixels;
      @ExportedProperty
      public boolean isOverflowButton;
      @ExportedProperty
      public boolean preventEdgeOffset;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.isOverflowButton = false;
      }

      public LayoutParams(int var1, int var2, boolean var3) {
         super(var1, var2);
         this.isOverflowButton = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(ActionMenuView.LayoutParams var1) {
         super(var1);
         this.isOverflowButton = var1.isOverflowButton;
      }
   }
}
