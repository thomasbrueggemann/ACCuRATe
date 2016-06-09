package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class MenuPopupHelper implements MenuPresenter, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
   static final int ITEM_LAYOUT = 0;
   private static final String TAG = "MenuPopupHelper";
   private final MenuPopupHelper.MenuAdapter mAdapter;
   private View mAnchorView;
   private int mContentWidth;
   private final Context mContext;
   private int mDropDownGravity;
   boolean mForceShowIcon;
   private boolean mHasContentWidth;
   private final LayoutInflater mInflater;
   private ViewGroup mMeasureParent;
   private final MenuBuilder mMenu;
   private final boolean mOverflowOnly;
   private ListPopupWindow mPopup;
   private final int mPopupMaxWidth;
   private final int mPopupStyleAttr;
   private final int mPopupStyleRes;
   private MenuPresenter.Callback mPresenterCallback;
   private ViewTreeObserver mTreeObserver;

   static {
      ITEM_LAYOUT = class_22.layout.abc_popup_menu_item_layout;
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2) {
      this(var1, var2, (View)null, false, class_22.attr.popupMenuStyle);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3) {
      this(var1, var2, var3, false, class_22.attr.popupMenuStyle);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3, boolean var4, int var5) {
      this(var1, var2, var3, var4, var5, 0);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3, boolean var4, int var5, int var6) {
      this.mDropDownGravity = 0;
      this.mContext = var1;
      this.mInflater = LayoutInflater.from(var1);
      this.mMenu = var2;
      this.mAdapter = new MenuPopupHelper.MenuAdapter(this.mMenu);
      this.mOverflowOnly = var4;
      this.mPopupStyleAttr = var5;
      this.mPopupStyleRes = var6;
      Resources var7 = var1.getResources();
      this.mPopupMaxWidth = Math.max(var7.getDisplayMetrics().widthPixels / 2, var7.getDimensionPixelSize(class_22.dimen.abc_config_prefDialogWidth));
      this.mAnchorView = var3;
      var2.addMenuPresenter(this, var1);
   }

   private int measureContentWidth() {
      int var1 = 0;
      View var2 = null;
      int var3 = 0;
      MenuPopupHelper.MenuAdapter var4 = this.mAdapter;
      int var5 = MeasureSpec.makeMeasureSpec(0, 0);
      int var6 = MeasureSpec.makeMeasureSpec(0, 0);
      int var7 = var4.getCount();

      for(int var8 = 0; var8 < var7; ++var8) {
         int var9 = var4.getItemViewType(var8);
         if(var9 != var3) {
            var3 = var9;
            var2 = null;
         }

         if(this.mMeasureParent == null) {
            this.mMeasureParent = new FrameLayout(this.mContext);
         }

         var2 = var4.getView(var8, var2, this.mMeasureParent);
         var2.measure(var5, var6);
         int var10 = var2.getMeasuredWidth();
         if(var10 >= this.mPopupMaxWidth) {
            var1 = this.mPopupMaxWidth;
            break;
         }

         if(var10 > var1) {
            var1 = var10;
         }
      }

      return var1;
   }

   public boolean collapseItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public void dismiss() {
      if(this.isShowing()) {
         this.mPopup.dismiss();
      }

   }

   public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public boolean flagActionItems() {
      return false;
   }

   public int getGravity() {
      return this.mDropDownGravity;
   }

   public int getId() {
      return 0;
   }

   public MenuView getMenuView(ViewGroup var1) {
      throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
   }

   public ListPopupWindow getPopup() {
      return this.mPopup;
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
   }

   public boolean isShowing() {
      return this.mPopup != null && this.mPopup.isShowing();
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(var1 == this.mMenu) {
         this.dismiss();
         if(this.mPresenterCallback != null) {
            this.mPresenterCallback.onCloseMenu(var1, var2);
            return;
         }
      }

   }

   public void onDismiss() {
      this.mPopup = null;
      this.mMenu.close();
      if(this.mTreeObserver != null) {
         if(!this.mTreeObserver.isAlive()) {
            this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
         }

         this.mTreeObserver.removeGlobalOnLayoutListener(this);
         this.mTreeObserver = null;
      }

   }

   public void onGlobalLayout() {
      if(this.isShowing()) {
         View var1 = this.mAnchorView;
         if(var1 != null && var1.isShown()) {
            if(this.isShowing()) {
               this.mPopup.show();
               return;
            }
         } else {
            this.dismiss();
         }
      }

   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      MenuPopupHelper.MenuAdapter var6 = this.mAdapter;
      var6.mAdapterMenu.performItemAction(var6.getItem(var3), 0);
   }

   public boolean onKey(View var1, int var2, KeyEvent var3) {
      if(var3.getAction() == 1 && var2 == 82) {
         this.dismiss();
         return true;
      } else {
         return false;
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
   }

   public Parcelable onSaveInstanceState() {
      return null;
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      if(var1.hasVisibleItems()) {
         MenuPopupHelper var2 = new MenuPopupHelper(this.mContext, var1, this.mAnchorView);
         var2.setCallback(this.mPresenterCallback);
         int var3 = var1.size();
         int var4 = 0;

         boolean var5;
         while(true) {
            var5 = false;
            if(var4 >= var3) {
               break;
            }

            MenuItem var7 = var1.getItem(var4);
            if(var7.isVisible() && var7.getIcon() != null) {
               var5 = true;
               break;
            }

            ++var4;
         }

         var2.setForceShowIcon(var5);
         if(var2.tryShow()) {
            if(this.mPresenterCallback != null) {
               this.mPresenterCallback.onOpenSubMenu(var1);
            }

            return true;
         }
      }

      return false;
   }

   public void setAnchorView(View var1) {
      this.mAnchorView = var1;
   }

   public void setCallback(MenuPresenter.Callback var1) {
      this.mPresenterCallback = var1;
   }

   public void setForceShowIcon(boolean var1) {
      this.mForceShowIcon = var1;
   }

   public void setGravity(int var1) {
      this.mDropDownGravity = var1;
   }

   public void show() {
      if(!this.tryShow()) {
         throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
      }
   }

   public boolean tryShow() {
      this.mPopup = new ListPopupWindow(this.mContext, (AttributeSet)null, this.mPopupStyleAttr, this.mPopupStyleRes);
      this.mPopup.setOnDismissListener(this);
      this.mPopup.setOnItemClickListener(this);
      this.mPopup.setAdapter(this.mAdapter);
      this.mPopup.setModal(true);
      View var1 = this.mAnchorView;
      if(var1 != null) {
         ViewTreeObserver var2 = this.mTreeObserver;
         boolean var3 = false;
         if(var2 == null) {
            var3 = true;
         }

         this.mTreeObserver = var1.getViewTreeObserver();
         if(var3) {
            this.mTreeObserver.addOnGlobalLayoutListener(this);
         }

         this.mPopup.setAnchorView(var1);
         this.mPopup.setDropDownGravity(this.mDropDownGravity);
         if(!this.mHasContentWidth) {
            this.mContentWidth = this.measureContentWidth();
            this.mHasContentWidth = true;
         }

         this.mPopup.setContentWidth(this.mContentWidth);
         this.mPopup.setInputMethodMode(2);
         this.mPopup.show();
         this.mPopup.getListView().setOnKeyListener(this);
         return true;
      } else {
         return false;
      }
   }

   public void updateMenuView(boolean var1) {
      this.mHasContentWidth = false;
      if(this.mAdapter != null) {
         this.mAdapter.notifyDataSetChanged();
      }

   }

   private class MenuAdapter extends BaseAdapter {
      private MenuBuilder mAdapterMenu;
      private int mExpandedIndex = -1;

      public MenuAdapter(MenuBuilder var2) {
         this.mAdapterMenu = var2;
         this.findExpandedIndex();
      }

      void findExpandedIndex() {
         MenuItemImpl var1 = MenuPopupHelper.this.mMenu.getExpandedItem();
         if(var1 != null) {
            ArrayList var2 = MenuPopupHelper.this.mMenu.getNonActionItems();
            int var3 = var2.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if((MenuItemImpl)var2.get(var4) == var1) {
                  this.mExpandedIndex = var4;
                  return;
               }
            }
         }

         this.mExpandedIndex = -1;
      }

      public int getCount() {
         ArrayList var1;
         if(MenuPopupHelper.this.mOverflowOnly) {
            var1 = this.mAdapterMenu.getNonActionItems();
         } else {
            var1 = this.mAdapterMenu.getVisibleItems();
         }

         return this.mExpandedIndex < 0?var1.size():-1 + var1.size();
      }

      public MenuItemImpl getItem(int var1) {
         ArrayList var2;
         if(MenuPopupHelper.this.mOverflowOnly) {
            var2 = this.mAdapterMenu.getNonActionItems();
         } else {
            var2 = this.mAdapterMenu.getVisibleItems();
         }

         if(this.mExpandedIndex >= 0 && var1 >= this.mExpandedIndex) {
            ++var1;
         }

         return (MenuItemImpl)var2.get(var1);
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         if(var2 == null) {
            var2 = MenuPopupHelper.this.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, var3, false);
         }

         MenuView.ItemView var4 = (MenuView.ItemView)var2;
         if(MenuPopupHelper.this.mForceShowIcon) {
            ((ListMenuItemView)var2).setForceShowIcon(true);
         }

         var4.initialize(this.getItem(var1), 0);
         return var2;
      }

      public void notifyDataSetChanged() {
         this.findExpandedIndex();
         super.notifyDataSetChanged();
      }
   }
}
