package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuDialogHelper;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import java.util.ArrayList;

public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
   private static final String TAG = "ActionMenuPresenter";
   private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
   private ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
   private int mActionItemWidthLimit;
   private boolean mExpandedActionViewsExclusive;
   private int mMaxItems;
   private boolean mMaxItemsSet;
   private int mMinCellSize;
   int mOpenSubMenuId;
   private View mOverflowButton;
   private ActionMenuPresenter.OverflowPopup mOverflowPopup;
   final ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback = new ActionMenuPresenter.PopupPresenterCallback();
   private ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
   private boolean mReserveOverflow;
   private boolean mReserveOverflowSet;
   private View mScrapActionButtonView;
   private boolean mStrictWidthLimit;
   private int mWidthLimit;
   private boolean mWidthLimitSet;

   public ActionMenuPresenter(Context var1) {
      super(var1, class_639.layout.abc_action_menu_layout, class_639.layout.abc_action_menu_item_layout);
   }

   private View findViewForItem(MenuItem var1) {
      ViewGroup var2 = (ViewGroup)this.mMenuView;
      View var5;
      if(var2 == null) {
         var5 = null;
      } else {
         int var3 = var2.getChildCount();
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               return null;
            }

            var5 = var2.getChildAt(var4);
            if(var5 instanceof MenuView.ItemView && ((MenuView.ItemView)var5).getItemData() == var1) {
               break;
            }

            ++var4;
         }
      }

      return var5;
   }

   public void bindItemView(MenuItemImpl var1, MenuView.ItemView var2) {
      var2.initialize(var1, 0);
      ActionMenuView var3 = (ActionMenuView)this.mMenuView;
      ((ActionMenuItemView)var2).setItemInvoker(var3);
   }

   public boolean dismissPopupMenus() {
      return this.hideOverflowMenu() | this.hideSubMenus();
   }

   public boolean filterLeftoverView(ViewGroup var1, int var2) {
      return var1.getChildAt(var2) == this.mOverflowButton?false:super.filterLeftoverView(var1, var2);
   }

   public boolean flagActionItems() {
      ArrayList var1 = this.mMenu.getVisibleItems();
      int var2 = var1.size();
      int var3 = this.mMaxItems;
      int var4 = this.mActionItemWidthLimit;
      int var5 = MeasureSpec.makeMeasureSpec(0, 0);
      ViewGroup var6 = (ViewGroup)this.mMenuView;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      boolean var10 = false;

      for(int var11 = 0; var11 < var2; ++var11) {
         MenuItemImpl var33 = (MenuItemImpl)var1.get(var11);
         if(var33.requiresActionButton()) {
            ++var7;
         } else if(var33.requestsActionButton()) {
            ++var8;
         } else {
            var10 = true;
         }

         if(this.mExpandedActionViewsExclusive && var33.isActionViewExpanded()) {
            var3 = 0;
         }
      }

      if(this.mReserveOverflow && (var10 || var7 + var8 > var3)) {
         --var3;
      }

      int var12 = var3 - var7;
      SparseBooleanArray var13 = this.mActionButtonGroups;
      var13.clear();
      boolean var14 = this.mStrictWidthLimit;
      int var15 = 0;
      int var16 = 0;
      if(var14) {
         var16 = var4 / this.mMinCellSize;
         int var32 = var4 % this.mMinCellSize;
         var15 = this.mMinCellSize + var32 / var16;
      }

      for(int var17 = 0; var17 < var2; ++var17) {
         MenuItemImpl var18 = (MenuItemImpl)var1.get(var17);
         if(var18.requiresActionButton()) {
            View var29 = this.getItemView(var18, this.mScrapActionButtonView, var6);
            if(this.mScrapActionButtonView == null) {
               this.mScrapActionButtonView = var29;
            }

            if(this.mStrictWidthLimit) {
               var16 -= ActionMenuView.measureChildForCells(var29, var15, var16, var5, 0);
            } else {
               var29.measure(var5, var5);
            }

            int var30 = var29.getMeasuredWidth();
            var4 -= var30;
            if(var9 == 0) {
               var9 = var30;
            }

            int var31 = var18.getGroupId();
            if(var31 != 0) {
               var13.put(var31, true);
            }

            var18.setIsActionButton(true);
         } else if(var18.requestsActionButton()) {
            int var19 = var18.getGroupId();
            boolean var20 = var13.get(var19);
            boolean var21;
            if(var12 <= 0 && !var20 || var4 <= 0 || this.mStrictWidthLimit && var16 <= 0) {
               var21 = false;
            } else {
               var21 = true;
            }

            if(var21) {
               View var24 = this.getItemView(var18, this.mScrapActionButtonView, var6);
               if(this.mScrapActionButtonView == null) {
                  this.mScrapActionButtonView = var24;
               }

               if(this.mStrictWidthLimit) {
                  int var28 = ActionMenuView.measureChildForCells(var24, var15, var16, var5, 0);
                  var16 -= var28;
                  if(var28 == 0) {
                     var21 = false;
                  }
               } else {
                  var24.measure(var5, var5);
               }

               int var25 = var24.getMeasuredWidth();
               var4 -= var25;
               if(var9 == 0) {
                  var9 = var25;
               }

               if(this.mStrictWidthLimit) {
                  boolean var27;
                  if(var4 >= 0) {
                     var27 = true;
                  } else {
                     var27 = false;
                  }

                  var21 &= var27;
               } else {
                  boolean var26;
                  if(var4 + var9 > 0) {
                     var26 = true;
                  } else {
                     var26 = false;
                  }

                  var21 &= var26;
               }
            }

            if(var21 && var19 != 0) {
               var13.put(var19, true);
            } else if(var20) {
               var13.put(var19, false);

               for(int var22 = 0; var22 < var17; ++var22) {
                  MenuItemImpl var23 = (MenuItemImpl)var1.get(var22);
                  if(var23.getGroupId() == var19) {
                     if(var23.isActionButton()) {
                        ++var12;
                     }

                     var23.setIsActionButton(false);
                  }
               }
            }

            if(var21) {
               --var12;
            }

            var18.setIsActionButton(var21);
         }
      }

      return true;
   }

   public View getItemView(MenuItemImpl var1, View var2, ViewGroup var3) {
      View var4 = var1.getActionView();
      if(var4 == null || var1.hasCollapsibleActionView()) {
         if(!(var2 instanceof ActionMenuItemView)) {
            var2 = null;
         }

         var4 = super.getItemView(var1, var2, var3);
      }

      byte var5;
      if(var1.isActionViewExpanded()) {
         var5 = 8;
      } else {
         var5 = 0;
      }

      var4.setVisibility(var5);
      ActionMenuView var6 = (ActionMenuView)var3;
      LayoutParams var7 = var4.getLayoutParams();
      if(!var6.checkLayoutParams(var7)) {
         var4.setLayoutParams(var6.generateLayoutParams(var7));
      }

      return var4;
   }

   public MenuView getMenuView(ViewGroup var1) {
      MenuView var2 = super.getMenuView(var1);
      ((ActionMenuView)var2).setPresenter(this);
      return var2;
   }

   public boolean hideOverflowMenu() {
      if(this.mPostedOpenRunnable != null && this.mMenuView != null) {
         ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
         this.mPostedOpenRunnable = null;
         return true;
      } else {
         ActionMenuPresenter.OverflowPopup var1 = this.mOverflowPopup;
         if(var1 != null) {
            var1.dismiss();
            return true;
         } else {
            return false;
         }
      }
   }

   public boolean hideSubMenus() {
      if(this.mActionButtonPopup != null) {
         this.mActionButtonPopup.dismiss();
         return true;
      } else {
         return false;
      }
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
      super.initForMenu(var1, var2);
      Resources var3 = var1.getResources();
      ActionBarPolicy var4 = ActionBarPolicy.get(var1);
      if(!this.mReserveOverflowSet) {
         this.mReserveOverflow = var4.showsOverflowMenuButton();
      }

      if(!this.mWidthLimitSet) {
         this.mWidthLimit = var4.getEmbeddedMenuWidthLimit();
      }

      if(!this.mMaxItemsSet) {
         this.mMaxItems = var4.getMaxActionButtons();
      }

      int var5 = this.mWidthLimit;
      if(this.mReserveOverflow) {
         if(this.mOverflowButton == null) {
            this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this.mSystemContext);
            int var6 = MeasureSpec.makeMeasureSpec(0, 0);
            this.mOverflowButton.measure(var6, var6);
         }

         var5 -= this.mOverflowButton.getMeasuredWidth();
      } else {
         this.mOverflowButton = null;
      }

      this.mActionItemWidthLimit = var5;
      this.mMinCellSize = (int)(56.0F * var3.getDisplayMetrics().density);
      this.mScrapActionButtonView = null;
   }

   public boolean isOverflowMenuShowing() {
      return this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
   }

   public boolean isOverflowReserved() {
      return this.mReserveOverflow;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      this.dismissPopupMenus();
      super.onCloseMenu(var1, var2);
   }

   public void onConfigurationChanged(Configuration var1) {
      if(!this.mMaxItemsSet) {
         this.mMaxItems = this.mContext.getResources().getInteger(class_639.integer.abc_max_action_buttons);
      }

      if(this.mMenu != null) {
         this.mMenu.onItemsChanged(true);
      }

   }

   public void onRestoreInstanceState(Parcelable var1) {
      ActionMenuPresenter.SavedState var2 = (ActionMenuPresenter.SavedState)var1;
      if(var2.openSubMenuId > 0) {
         MenuItem var3 = this.mMenu.findItem(var2.openSubMenuId);
         if(var3 != null) {
            this.onSubMenuSelected((SubMenuBuilder)var3.getSubMenu());
         }
      }

   }

   public Parcelable onSaveInstanceState() {
      ActionMenuPresenter.SavedState var1 = new ActionMenuPresenter.SavedState();
      var1.openSubMenuId = this.mOpenSubMenuId;
      return var1;
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      if(var1.hasVisibleItems()) {
         SubMenuBuilder var2;
         for(var2 = var1; var2.getParentMenu() != this.mMenu; var2 = (SubMenuBuilder)var2.getParentMenu()) {
            ;
         }

         if(this.findViewForItem(var2.getItem()) == null) {
            if(this.mOverflowButton == null) {
               return false;
            }

            View var10000 = this.mOverflowButton;
         }

         this.mOpenSubMenuId = var1.getItem().getItemId();
         this.mActionButtonPopup = new ActionMenuPresenter.ActionButtonSubmenu(var1);
         this.mActionButtonPopup.show((IBinder)null);
         super.onSubMenuSelected(var1);
         return true;
      } else {
         return false;
      }
   }

   public void onSubUiVisibilityChanged(boolean var1) {
      if(var1) {
         super.onSubMenuSelected((SubMenuBuilder)null);
      } else {
         this.mMenu.close(false);
      }
   }

   public void setExpandedActionViewsExclusive(boolean var1) {
      this.mExpandedActionViewsExclusive = var1;
   }

   public void setItemLimit(int var1) {
      this.mMaxItems = var1;
      this.mMaxItemsSet = true;
   }

   public void setReserveOverflow(boolean var1) {
      this.mReserveOverflow = var1;
      this.mReserveOverflowSet = true;
   }

   public void setWidthLimit(int var1, boolean var2) {
      this.mWidthLimit = var1;
      this.mStrictWidthLimit = var2;
      this.mWidthLimitSet = true;
   }

   public boolean shouldIncludeItem(int var1, MenuItemImpl var2) {
      return var2.isActionButton();
   }

   public boolean showOverflowMenu() {
      if(this.mReserveOverflow && !this.isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null) {
         this.mPostedOpenRunnable = new ActionMenuPresenter.OpenOverflowRunnable(new ActionMenuPresenter.OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
         ((View)this.mMenuView).post(this.mPostedOpenRunnable);
         super.onSubMenuSelected((SubMenuBuilder)null);
         return true;
      } else {
         return false;
      }
   }

   public void updateMenuView(boolean var1) {
      super.updateMenuView(var1);
      if(this.mMenuView != null) {
         if(this.mMenu != null) {
            ArrayList var8 = this.mMenu.getActionItems();
            int var9 = var8.size();

            for(int var10 = 0; var10 < var9; ++var10) {
               ActionProvider var11 = ((MenuItemImpl)var8.get(var10)).getSupportActionProvider();
               if(var11 != null) {
                  var11.setSubUiVisibilityListener(this);
               }
            }
         }

         ArrayList var2;
         if(this.mMenu != null) {
            var2 = this.mMenu.getNonActionItems();
         } else {
            var2 = null;
         }

         boolean var3 = this.mReserveOverflow;
         boolean var4 = false;
         if(var3) {
            var4 = false;
            if(var2 != null) {
               int var7 = var2.size();
               if(var7 == 1) {
                  if(!((MenuItemImpl)var2.get(0)).isActionViewExpanded()) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }
               } else if(var7 > 0) {
                  var4 = true;
               } else {
                  var4 = false;
               }
            }
         }

         if(var4) {
            if(this.mOverflowButton == null) {
               this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this.mSystemContext);
            }

            ViewGroup var5 = (ViewGroup)this.mOverflowButton.getParent();
            if(var5 != this.mMenuView) {
               if(var5 != null) {
                  var5.removeView(this.mOverflowButton);
               }

               ActionMenuView var6 = (ActionMenuView)this.mMenuView;
               var6.addView(this.mOverflowButton, var6.generateOverflowButtonLayoutParams());
            }
         } else if(this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
         }

         ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
      }
   }

   private class ActionButtonSubmenu extends MenuDialogHelper {
      public ActionButtonSubmenu(SubMenuBuilder var2) {
         super(var2);
         ActionMenuPresenter.this.setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
      }

      public void onDismiss(DialogInterface var1) {
         super.onDismiss(var1);
         ActionMenuPresenter.this.mActionButtonPopup = null;
         ActionMenuPresenter.this.mOpenSubMenuId = 0;
      }
   }

   private class OpenOverflowRunnable implements Runnable {
      private ActionMenuPresenter.OverflowPopup mPopup;

      public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup var2) {
         this.mPopup = var2;
      }

      public void run() {
         ActionMenuPresenter.this.mMenu.changeMenuMode();
         View var1 = (View)ActionMenuPresenter.this.mMenuView;
         if(var1 != null && var1.getWindowToken() != null && this.mPopup.tryShow()) {
            ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
         }

         ActionMenuPresenter.this.mPostedOpenRunnable = null;
      }
   }

   private class OverflowMenuButton extends ImageButton implements ActionMenuView.ActionMenuChildView {
      public OverflowMenuButton(Context var2) {
         super(var2, (AttributeSet)null, class_639.attr.actionOverflowButtonStyle);
         this.setClickable(true);
         this.setFocusable(true);
         this.setVisibility(0);
         this.setEnabled(true);
      }

      public boolean needsDividerAfter() {
         return false;
      }

      public boolean needsDividerBefore() {
         return false;
      }

      public boolean performClick() {
         if(super.performClick()) {
            return true;
         } else {
            this.playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
         }
      }
   }

   private class OverflowPopup extends MenuPopupHelper {
      public OverflowPopup(Context var2, MenuBuilder var3, View var4, boolean var5) {
         super(var2, var3, var4, var5);
         this.setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
      }

      public void onDismiss() {
         super.onDismiss();
         ActionMenuPresenter.this.mMenu.close();
         ActionMenuPresenter.this.mOverflowPopup = null;
      }
   }

   private class PopupPresenterCallback implements MenuPresenter.Callback {
      private PopupPresenterCallback() {
      }

      // $FF: synthetic method
      PopupPresenterCallback(Object var2) {
         this();
      }

      public void onCloseMenu(MenuBuilder var1, boolean var2) {
         if(var1 instanceof SubMenuBuilder) {
            ((SubMenuBuilder)var1).getRootMenu().close(false);
         }

      }

      public boolean onOpenSubMenu(MenuBuilder var1) {
         if(var1 == null) {
            return false;
         } else {
            ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder)var1).getItem().getItemId();
            return false;
         }
      }
   }

   private static class SavedState implements Parcelable {
      public static final Creator<ActionMenuPresenter.SavedState> CREATOR = new Creator() {
         public ActionMenuPresenter.SavedState createFromParcel(Parcel var1) {
            return new ActionMenuPresenter.SavedState(var1);
         }

         public ActionMenuPresenter.SavedState[] newArray(int var1) {
            return new ActionMenuPresenter.SavedState[var1];
         }
      };
      public int openSubMenuId;

      SavedState() {
      }

      SavedState(Parcel var1) {
         this.openSubMenuId = var1.readInt();
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.openSubMenuId);
      }
   }
}
