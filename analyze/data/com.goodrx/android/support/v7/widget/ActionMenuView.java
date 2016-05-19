package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
   static final int GENERATED_ITEM_PADDING = 4;
   static final int MIN_CELL_SIZE = 56;
   private static final String TAG = "ActionMenuView";
   private MenuPresenter.Callback mActionMenuPresenterCallback;
   private boolean mFormatItems;
   private int mFormatItemsWidth;
   private int mGeneratedItemPadding;
   private MenuBuilder mMenu;
   private MenuBuilder.Callback mMenuBuilderCallback;
   private int mMinCellSize;
   private ActionMenuView.OnMenuItemClickListener mOnMenuItemClickListener;
   private Context mPopupContext;
   private int mPopupTheme;
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
      this.mPopupContext = var1;
      this.mPopupTheme = 0;
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
      int var8 = getChildMeasureSpec(var2, var7, -2);
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
      }
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 != null && var1 instanceof ActionMenuView.LayoutParams;
   }

   public void dismissPopupMenus() {
      if(this.mPresenter != null) {
         this.mPresenter.dismissPopupMenus();
      }

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
      if(var1 != null) {
         ActionMenuView.LayoutParams var2;
         if(var1 instanceof ActionMenuView.LayoutParams) {
            var2 = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)var1);
         } else {
            var2 = new ActionMenuView.LayoutParams(var1);
         }

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

   public Menu getMenu() {
      if(this.mMenu == null) {
         Context var1 = this.getContext();
         this.mMenu = new MenuBuilder(var1);
         this.mMenu.setCallback(new ActionMenuView.MenuBuilderCallback());
         this.mPresenter = new ActionMenuPresenter(var1);
         this.mPresenter.setReserveOverflow(true);
         ActionMenuPresenter var2 = this.mPresenter;
         Object var3;
         if(this.mActionMenuPresenterCallback != null) {
            var3 = this.mActionMenuPresenterCallback;
         } else {
            var3 = new ActionMenuView.ActionMenuPresenterCallback();
         }

         var2.setCallback((MenuPresenter.Callback)var3);
         this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
         this.mPresenter.setMenuView(this);
      }

      return this.mMenu;
   }

   @Nullable
   public Drawable getOverflowIcon() {
      this.getMenu();
      return this.mPresenter.getOverflowIcon();
   }

   public int getPopupTheme() {
      return this.mPopupTheme;
   }

   public int getWindowAnimations() {
      return 0;
   }

   protected boolean hasSupportDividerBeforeChildAt(int var1) {
      boolean var5;
      if(var1 == 0) {
         var5 = false;
      } else {
         View var2 = this.getChildAt(var1 - 1);
         View var3 = this.getChildAt(var1);
         int var4 = this.getChildCount();
         var5 = false;
         if(var1 < var4) {
            boolean var6 = var2 instanceof ActionMenuView.ActionMenuChildView;
            var5 = false;
            if(var6) {
               var5 = false | ((ActionMenuView.ActionMenuChildView)var2).needsDividerAfter();
            }
         }

         if(var1 > 0 && var3 instanceof ActionMenuView.ActionMenuChildView) {
            return var5 | ((ActionMenuView.ActionMenuChildView)var3).needsDividerBefore();
         }
      }

      return var5;
   }

   public boolean hideOverflowMenu() {
      return this.mPresenter != null && this.mPresenter.hideOverflowMenu();
   }

   public void initialize(MenuBuilder var1) {
      this.mMenu = var1;
   }

   public boolean invokeItem(MenuItemImpl var1) {
      return this.mMenu.performItemAction(var1, 0);
   }

   public boolean isOverflowMenuShowPending() {
      return this.mPresenter != null && this.mPresenter.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      return this.mPresenter != null && this.mPresenter.isOverflowMenuShowing();
   }

   public boolean isOverflowReserved() {
      return this.mReserveOverflow;
   }

   public void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      if(this.mPresenter != null) {
         this.mPresenter.updateMenuView(false);
         if(this.mPresenter.isOverflowMenuShowing()) {
            this.mPresenter.hideOverflowMenu();
            this.mPresenter.showOverflowMenu();
         }
      }

   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.dismissPopupMenus();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(!this.mFormatItems) {
         super.onLayout(var1, var2, var3, var4, var5);
      } else {
         int var6 = this.getChildCount();
         int var7 = (var5 - var3) / 2;
         int var8 = this.getDividerWidth();
         int var9 = 0;
         int var10 = 0;
         int var11 = var4 - var2 - this.getPaddingRight() - this.getPaddingLeft();
         boolean var12 = false;
         boolean var13 = ViewUtils.isLayoutRtl(this);

         for(int var14 = 0; var14 < var6; ++var14) {
            View var40 = this.getChildAt(var14);
            if(var40.getVisibility() != 8) {
               ActionMenuView.LayoutParams var41 = (ActionMenuView.LayoutParams)var40.getLayoutParams();
               if(var41.isOverflowButton) {
                  int var43 = var40.getMeasuredWidth();
                  if(this.hasSupportDividerBeforeChildAt(var14)) {
                     var43 += var8;
                  }

                  int var44 = var40.getMeasuredHeight();
                  int var46;
                  int var45;
                  if(var13) {
                     var46 = this.getPaddingLeft() + var41.leftMargin;
                     var45 = var46 + var43;
                  } else {
                     var45 = this.getWidth() - this.getPaddingRight() - var41.rightMargin;
                     var46 = var45 - var43;
                  }

                  int var47 = var7 - var44 / 2;
                  int var48 = var47 + var44;
                  var40.layout(var46, var47, var45, var48);
                  var11 -= var43;
                  var12 = true;
               } else {
                  int var42 = var40.getMeasuredWidth() + var41.leftMargin + var41.rightMargin;
                  var9 += var42;
                  var11 -= var42;
                  if(this.hasSupportDividerBeforeChildAt(var14)) {
                     var9 += var8;
                  }

                  ++var10;
               }
            }
         }

         if(var6 == 1 && !var12) {
            View var35 = this.getChildAt(0);
            int var36 = var35.getMeasuredWidth();
            int var37 = var35.getMeasuredHeight();
            int var38 = (var4 - var2) / 2 - var36 / 2;
            int var39 = var7 - var37 / 2;
            var35.layout(var38, var39, var38 + var36, var39 + var37);
            return;
         }

         byte var15;
         if(var12) {
            var15 = 0;
         } else {
            var15 = 1;
         }

         int var16 = var10 - var15;
         int var17;
         if(var16 > 0) {
            var17 = var11 / var16;
         } else {
            var17 = 0;
         }

         int var18 = Math.max(0, var17);
         if(var13) {
            int var27 = this.getWidth() - this.getPaddingRight();

            for(int var28 = 0; var28 < var6; ++var28) {
               View var29 = this.getChildAt(var28);
               ActionMenuView.LayoutParams var30 = (ActionMenuView.LayoutParams)var29.getLayoutParams();
               if(var29.getVisibility() != 8 && !var30.isOverflowButton) {
                  int var31 = var27 - var30.rightMargin;
                  int var32 = var29.getMeasuredWidth();
                  int var33 = var29.getMeasuredHeight();
                  int var34 = var7 - var33 / 2;
                  var29.layout(var31 - var32, var34, var31, var34 + var33);
                  var27 = var31 - (var18 + var32 + var30.leftMargin);
               }
            }
         } else {
            int var19 = this.getPaddingLeft();

            for(int var20 = 0; var20 < var6; ++var20) {
               View var21 = this.getChildAt(var20);
               ActionMenuView.LayoutParams var22 = (ActionMenuView.LayoutParams)var21.getLayoutParams();
               if(var21.getVisibility() != 8 && !var22.isOverflowButton) {
                  int var23 = var19 + var22.leftMargin;
                  int var24 = var21.getMeasuredWidth();
                  int var25 = var21.getMeasuredHeight();
                  int var26 = var7 - var25 / 2;
                  var21.layout(var23, var26, var23 + var24, var26 + var25);
                  var19 = var23 + var18 + var24 + var22.rightMargin;
               }
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

      int var5 = MeasureSpec.getSize(var1);
      if(this.mFormatItems && this.mMenu != null && var5 != this.mFormatItemsWidth) {
         this.mFormatItemsWidth = var5;
         this.mMenu.onItemsChanged(true);
      }

      int var6 = this.getChildCount();
      if(this.mFormatItems && var6 > 0) {
         this.onMeasureExactFormat(var1, var2);
      } else {
         for(int var7 = 0; var7 < var6; ++var7) {
            ActionMenuView.LayoutParams var8 = (ActionMenuView.LayoutParams)this.getChildAt(var7).getLayoutParams();
            var8.rightMargin = 0;
            var8.leftMargin = 0;
         }

         super.onMeasure(var1, var2);
      }
   }

   public MenuBuilder peekMenu() {
      return this.mMenu;
   }

   public void setExpandedActionViewsExclusive(boolean var1) {
      this.mPresenter.setExpandedActionViewsExclusive(var1);
   }

   public void setMenuCallbacks(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.mActionMenuPresenterCallback = var1;
      this.mMenuBuilderCallback = var2;
   }

   public void setOnMenuItemClickListener(ActionMenuView.OnMenuItemClickListener var1) {
      this.mOnMenuItemClickListener = var1;
   }

   public void setOverflowIcon(@Nullable Drawable var1) {
      this.getMenu();
      this.mPresenter.setOverflowIcon(var1);
   }

   public void setOverflowReserved(boolean var1) {
      this.mReserveOverflow = var1;
   }

   public void setPopupTheme(@StyleRes int var1) {
      if(this.mPopupTheme != var1) {
         this.mPopupTheme = var1;
         if(var1 != 0) {
            this.mPopupContext = new ContextThemeWrapper(this.getContext(), var1);
            return;
         }

         this.mPopupContext = this.getContext();
      }

   }

   public void setPresenter(ActionMenuPresenter var1) {
      this.mPresenter = var1;
      this.mPresenter.setMenuView(this);
   }

   public boolean showOverflowMenu() {
      return this.mPresenter != null && this.mPresenter.showOverflowMenu();
   }

   public interface ActionMenuChildView {
      boolean needsDividerAfter();

      boolean needsDividerBefore();
   }

   private class ActionMenuPresenterCallback implements MenuPresenter.Callback {
      private ActionMenuPresenterCallback() {
      }

      // $FF: synthetic method
      ActionMenuPresenterCallback(Object var2) {
         this();
      }

      public void onCloseMenu(MenuBuilder var1, boolean var2) {
      }

      public boolean onOpenSubMenu(MenuBuilder var1) {
         return false;
      }
   }

   public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
      @ExportedProperty
      public int cellsUsed;
      @ExportedProperty
      public boolean expandable;
      boolean expanded;
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

      LayoutParams(int var1, int var2, boolean var3) {
         super(var1, var2);
         this.isOverflowButton = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(ActionMenuView.LayoutParams var1) {
         super((android.view.ViewGroup.LayoutParams)var1);
         this.isOverflowButton = var1.isOverflowButton;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }
   }

   private class MenuBuilderCallback implements MenuBuilder.Callback {
      private MenuBuilderCallback() {
      }

      // $FF: synthetic method
      MenuBuilderCallback(Object var2) {
         this();
      }

      public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
         return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(var2);
      }

      public void onMenuModeChange(MenuBuilder var1) {
         if(ActionMenuView.this.mMenuBuilderCallback != null) {
            ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(var1);
         }

      }
   }

   public interface OnMenuItemClickListener {
      boolean onMenuItemClick(MenuItem var1);
   }
}
